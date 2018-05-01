package org.badcoding.spring.controller;

import org.badcoding.dao.interfaces.UserDAO;
import org.badcoding.spring.form.UsersEditForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.SecureRandom;
import java.util.List;

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