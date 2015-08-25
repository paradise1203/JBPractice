package com.aidar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RestController {

    @Autowired
    UsersDAO dao;

    private String getSessionId(HttpServletRequest request) {
        return request.getSession().getId();
    }

    @RequestMapping("/home")
    public String showHomePage() {
        return "page";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        dao.addUser(getSessionId(request));
        String code = request.getParameter("code");
        Token token = dao.getUser(getSessionId(request)).getToken(code);
        model.addAttribute("token", token);
        return "page";
    }

    @RequestMapping("/audios")
    public String audios(HttpServletRequest request, Model model) {
        AudioCollectionResponse audios = dao.getUser(getSessionId(request)).getAudios();
        model.addAttribute("audios", audios);
        return "page";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(HttpServletRequest request, Model model) {
        String res = dao.getUser(getSessionId(request)).deleteAudio();
        model.addAttribute("deleteRes", res);
        return "page";
    }

}