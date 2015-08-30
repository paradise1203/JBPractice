package com.aidar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/login")
    public String login() {
        return "page";
    }

    @RequestMapping(path="/user/{username}")
    public String user(@PathVariable String username, Model model) {
        model.addAttribute("name", username);
        return "user";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

}
