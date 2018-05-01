package org.badcoding.spring.controller;

import org.badcoding.spring.form.UsersEditForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
