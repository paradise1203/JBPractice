package com.aidar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/additionForm")
public class PageController {

    @RequestMapping(method = RequestMethod.GET)
    public String showHomePage() {
        return "page";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String showResult(@RequestParam("firstNumber") String fN, @RequestParam("secondNumber") String sN, ModelMap model) {
        model.addAttribute("firstNumber", Integer.parseInt(fN));
        model.addAttribute("secondNumber", Integer.parseInt(sN));
        model.addAttribute("result", true);
        return "page";
    }

}
