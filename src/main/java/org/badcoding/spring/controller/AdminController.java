package org.badcoding.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("is_admin", null);
        return "redirect:/index";
	}

    @RequestMapping("/search")
    public String search() {
	    return "/admin/search";
    }

    @RequestMapping("/tariff")
    public String tariff() {
        return "/admin/tariff";
    }

	@RequestMapping("/")
	public String root() {
		return "redirect:/admin/search";
	}
}
