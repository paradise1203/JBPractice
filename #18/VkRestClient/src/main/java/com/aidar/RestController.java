package com.aidar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RestController {

    @Autowired
    private UsersDAO dao;
    @Autowired
    private UrlCollection urls;

    private String getSessionId(HttpServletRequest request) {
        return request.getSession().getId();
    }

    @RequestMapping("/home")
    public String showHomePage(Model model) {
        model.addAttribute("url", urls.getAuthorizeUrl());
        return "page";
    }

    @RequestMapping("/login")
    public
    @ResponseBody
    Token login(HttpServletRequest request, Model model) {
        dao.addUser(getSessionId(request));
        String code = request.getParameter("code");
        return dao.getUser(getSessionId(request)).getToken(urls.getTokenUrl(), code);
    }

    @RequestMapping("/audios")
    public
    @ResponseBody
    AudioCollectionResponse audios(HttpServletRequest request, Model model) {
        return dao.getUser(getSessionId(request)).getAudios(urls.getAudiosUrl());
    }

    @RequestMapping("/delete")
    public
    @ResponseBody
    String delete(HttpServletRequest request, Model model) {
        return dao.getUser(getSessionId(request)).deleteAudio(urls.getDeleteAudioUrl());
    }

}