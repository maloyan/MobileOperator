package org.badcoding.spring.controller;

import org.badcoding.dao.interfaces.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.SecureRandom;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserDAO user;

    private SecureRandom random = new SecureRandom();

    private Integer session_id(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (Integer) session.getAttribute("user_id");
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("user_id", null);
        return "redirect:/index";
    }

    @RequestMapping("/info")
    public String search() {
        return "/user/info";
    }

    @RequestMapping("/")
    public String root() {
        return "redirect:/user/info";
    }

}