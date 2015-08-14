package com.aidar;

import com.aidar.data.Database;
import com.aidar.data.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/list")
public class PageController {

    private void buildModel(ModelMap model) {
        List<Task> tasks=Database.getTasks();
        model.addAttribute("tasks", tasks);
        model.addAttribute("listIsEmpty", tasks.isEmpty());
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showHomePage(ModelMap model) {
        buildModel(model);
        return "page";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String showListPage(@RequestParam("task") String text, ModelMap model) {
        Database.addTask(text);
        buildModel(model);
        return "page";
    }

}
