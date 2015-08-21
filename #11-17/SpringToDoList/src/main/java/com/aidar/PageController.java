package com.aidar;

import com.aidar.dao.Task;
import com.aidar.dao.TaskRepository;
import com.aidar.dao.ToDoListDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/list")
public class PageController {

    @Autowired
    @Qualifier("toDoListDAO")
    private ToDoListDAO DAO;

    @Autowired
    TaskRepository repository;

    private boolean hasMyCookie(Cookie[] mas) {
        for (Cookie c : mas)
            if (c.getName().equals("name"))
                return true;
        return false;
    }

    private void deleteMyCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        Cookie nameCookie = null;
        for (Cookie c : cookies)
            if (c.getName().equals("name"))
                nameCookie = c;
        if (nameCookie != null) {
            nameCookie.setMaxAge(0);
            response.addCookie(nameCookie);
        }
    }

    private void buildModel(ModelMap model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<Task> tasks = null;
        if (session != null)
            tasks = repository.findBySessionId(session.getId());
        model.addAttribute("tasks", tasks);
        Cookie[] cookies = request.getCookies();
        boolean hasCookie = cookies != null && hasMyCookie(cookies);
        model.addAttribute("hasCookie", hasCookie);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showHomePage(@RequestParam(value = "clear", required = false) boolean clear,
                               HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        if (clear)
            deleteMyCookie(request, response);
        buildModel(model, request);
        return "page";
    }

    @RequestMapping(method = RequestMethod.POST)
    public void showListPage(@RequestParam("task") String task,
                                                   @RequestParam(value = "firstName", required = false) String firstName,
                                                   HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        String sessionId = request.getSession().getId();
        repository.addTask(sessionId, task);
        buildModel(model, request);
        Cookie[] cookies = request.getCookies();
        if (!(cookies != null && hasMyCookie(cookies))) {
            response.addCookie(new Cookie("name", firstName));
        }
    }

    @RequestMapping(value = "/clearUserInf", method = RequestMethod.POST)
    public String clear(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        repository.deleteTaskList(session.getId());
        session.invalidate();
        redirectAttributes.addAttribute("clear", true);
        return "redirect:/list";
    }

}