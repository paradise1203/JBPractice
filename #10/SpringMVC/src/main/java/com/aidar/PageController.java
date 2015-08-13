package com.aidar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/additionForm")
public class PageController {

    @RequestMapping(method = RequestMethod.GET)
    public String showHomePage() {
        return "additionForm";
    }

}
