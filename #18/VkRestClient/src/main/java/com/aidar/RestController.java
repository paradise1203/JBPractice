package com.aidar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpServletRequest;

@Controller
public class RestController {

    @Autowired
    private RestTemplate restTemplate;
    private Token token;
    private AudioCollection audios;

    @RequestMapping("/home")
    public String showHomePage(ModelMap model) {
        return "page";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, ModelMap model) {
        String code = request.getParameter("code");
        token = restTemplate.getForObject("https://oauth.vk.com/access_token?" +
                "client_id=5042953&client_secret=t6VTlzMUhXStuXOoUzsV&redirect_uri=http://localhost:8080/login&code=" +
                code, Token.class);
        model.addAttribute("token", token);
        return "page";
    }

    @RequestMapping("/audios")
    public String audios(ModelMap model) {
        audios = restTemplate.getForObject("https://api.vk.com/method/audio.get?" +
                "access_token=" + token.getAccess_token(), AudioCollection.class);
        model.addAttribute("audios", audios);
        return "page";
    }

    @RequestMapping("/delete")
    public String delete(ModelMap model) {
        String res = restTemplate.getForObject("https://api.vk.com/method/audio.delete?" +
                "audio_id=" + audios.getItems().get(0) + "&owner_id=" + token.getUser_id() + "&access_token=" + token.getAccess_token(), String.class);
        model.addAttribute("deleteRes", res);
        return "page";
    }

}