package org.badcoding.spring.controller;

import java.util.*;
import java.util.regex.*;
import java.text.*;
import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.badcoding.dao.interfaces.*;
import org.badcoding.hibernate.stored.*;
import org.badcoding.spring.form.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private Boolean is_admin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (session.getAttribute("is_admin") != null);
    }

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("is_admin", null);
        return "redirect:/index";
	}

    @RequestMapping("/search")
    public String search(HttpServletRequest request, Map<String, Object> model) {
		List<Integer> errors = new ArrayList<Integer>();
		if (!is_admin(request)) {
			errors.add(45);
			model.put("e", errors);
			return "redirect:/index";
		}
		model.put("usersForm", new UsersForm());
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

	@RequestMapping(value = "/edit_user", method = RequestMethod.POST)
	public @ResponseBody
	List<Integer> edit_user(HttpServletRequest request, UsersEditForm usersEditForm) {
		return null;
	}

	@RequestMapping(value = "/remove_user", method = RequestMethod.POST)
	public @ResponseBody
	List<Integer> remove_user(HttpServletRequest request, Integer user_id) {
		return null;
	}

	@RequestMapping(value = "/add_user", method = RequestMethod.POST)
	public @ResponseBody
	List<Integer> add_user(HttpServletRequest request, UsersEditForm usersEditForm) {
		return null;
	}
}
