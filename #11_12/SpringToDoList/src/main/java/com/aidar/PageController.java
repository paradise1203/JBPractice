package com.aidar;

import com.aidar.data.Database;
import com.aidar.data.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/list")
public class PageController {

    private boolean hasMyCookie(Cookie[] mas) {
        for(Cookie c:mas)
            if (c.getName().equals("name"))
                return true;
        return false;
    }

    private void buildModel(ModelMap model, HttpServletRequest request) {
        List<Task> tasks = Database.getTasks();
        model.addAttribute("tasks", tasks);
        model.addAttribute("listIsEmpty", tasks.isEmpty());
        Cookie[] cookies=request.getCookies();
        boolean hasCookie= cookies != null && hasMyCookie(cookies);
        model.addAttribute("hasCookie", hasCookie);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showHomePage(ModelMap model, HttpServletRequest request) {
        buildModel(model, request);
        return "page";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String showListPage(@RequestParam("task") String task, @RequestParam(value="firstName", required = false) String firstName,
                               @CookieValue(value = "name", defaultValue = "Stranger") String name,
                               HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        Database.addTask(task);
        buildModel(model,request);
        Cookie[] cookies=request.getCookies();
        if (!(cookies != null && hasMyCookie(cookies))) {
            name = firstName;
            response.addCookie(new Cookie("name", name));
        }
        return "page";
    }

}
