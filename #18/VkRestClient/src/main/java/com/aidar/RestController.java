package com.aidar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Controller
public class RestController {

    @Autowired
    UsersDAO dao;

    private String getSessionId(HttpServletRequest request) {
        return request.getSession().getId();
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        try {
            FileInputStream fin = new FileInputStream("C:\\Users\\Aidar_2\\Documents\\Work\\JBPractice\\#18\\VkRestClient\\src\\main\\resources\\config.properties");
            properties.load(fin);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    @RequestMapping("/home")
    public String showHomePage(Model model) {
        model.addAttribute("url", getProperties().getProperty("authorizeUrl"));
        return "page";
    }

    @RequestMapping("/login")
    public
    @ResponseBody
    Token login(HttpServletRequest request, Model model) {
        dao.addUser(getSessionId(request));
        String code = request.getParameter("code");
        String url = getProperties().getProperty("getTokenUrl");
        return dao.getUser(getSessionId(request)).getToken(url, code);
    }

    @RequestMapping("/audios")
    public
    @ResponseBody
    AudioCollectionResponse audios(HttpServletRequest request, Model model) {
        String url = getProperties().getProperty("getAudiosUrl");
        return dao.getUser(getSessionId(request)).getAudios(url);
    }

    @RequestMapping("/delete")
    public
    @ResponseBody
    String delete(HttpServletRequest request, Model model) {
        String url = getProperties().getProperty("deleteAudioUrl");
        return dao.getUser(getSessionId(request)).deleteAudio(url);
    }

}