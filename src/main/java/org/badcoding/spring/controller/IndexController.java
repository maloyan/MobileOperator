package org.badcoding.spring.controller;


import java.util.*;
import java.util.regex.*;
import java.text.*;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.badcoding.dao.interfaces.*;
import org.badcoding.hibernate.stored.*;
import org.badcoding.Application;
import org.badcoding.spring.form.*;
import org.springframework.validation.BindingResult;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String root(Map<String, Object> model) {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(@ModelAttribute IndexForm indexForm, @RequestParam(value="e", required=false) List<Integer> errors, Map<String, Object> model) {
        model.put("indexForm", (indexForm == null ? new IndexForm() : indexForm));
        if (errors != null)
            model.put("errors", errors);
        return "index";
    }

/*
    @RequestMapping(value="/get_tickets", method=RequestMethod.GET)
    public @ResponseBody List<List<String>> get_tickets(@RequestParam int flight_id, @RequestParam int type) {
        List<Tickets> t = tickets.getByFlight(flights.getById(flight_id), (type == -1 ? null : type));
        // System.out.println("result size = " + t.size());
        List<List<String>> result = new ArrayList<List<String>>(t.size());
        for (int i = 0; i < t.size(); i++) {
            List<String> ticket = new ArrayList<String>(3);
            ticket.add(String.valueOf(t.get(i).getSeat()));
            ticket.add(String.valueOf(t.get(i).getType()));
            ticket.add(String.valueOf(t.get(i).getCost()));
            ticket.add(String.valueOf(t.get(i).getTicket_id()));
            result.add(ticket);
        }
        return result;
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value="info", required=false) List<Integer> info, @RequestParam(value="ticket_id", required=false) Integer ticket_id, Map<String, Object> model) {
        model.put("registrationForm", new RegistrationForm());
        model.put("loginForm", new LoginForm());
        if (ticket_id != null)
            model.put("ticket_id", ticket_id);
        if (info != null)
            model.put("info", info);
        return "login";
    }

    @RequestMapping(value = "/process_login", method = RequestMethod.POST)
    public String process_login(HttpServletRequest request, @RequestParam(value="ticket_id", required=false) Integer ticket_id, @ModelAttribute("loginForm") LoginForm loginForm, Map<String, Object> model, BindingResult result) {
        List<Integer> errors = new ArrayList<Integer>();
        try {
            String email = loginForm.getEmail();
            String password = loginForm.getPassword();

            if (email.equals(admin)) { // admin login
                if (!password.equals(admin_password)) {
                    errors.add(32);
                    throw new Exception();
                }
                HttpSession session = request.getSession();
                session.setAttribute("is_admin", true);
                return "redirect:/admin/";
            }

            List<Users> user_a = users.getByEmail(email);
            if (user_a == null || user_a.size() == 0) {
                errors.add(33);
                throw new Exception();
            }
            Users user = user_a.get(0);
            if (!user.checkPassword(password)) {
                errors.add(32);
                throw new Exception();
            }

            HttpSession session = request.getSession();
            session.setAttribute("user_id", user.getUser_id());
            if (ticket_id != null) {
                model.put("ticket_id", ticket_id);
                return "redirect:/user/order_ticket";
            }
            return "redirect:/user/";
        } catch (Exception e) {
            model.put("loginForm", loginForm);
            model.put("registrationForm", new RegistrationForm());
            model.put("login_errors", errors);
            if (ticket_id != null) {
                model.put("ticket_id", ticket_id);
            }
            return "login";
        }

    }

*/
}