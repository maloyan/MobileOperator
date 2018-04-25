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
    @Autowired
    UserDAO user;

    @Value("${application.admin}")
    private Integer admin;

    @Value("${application.admin.password}")
    private String admin_password;

    @RequestMapping("/")
    public String root(Map<String, Object> model) {
        return "redirect:/index";
    }

    @RequestMapping("/set_locale")
    public String set_locale(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="locale", required=false) String locale) {
        Application.localeResolver().setLocale(request, response, new Locale(locale));
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(@ModelAttribute IndexForm indexForm, @RequestParam(value="e", required=false) List<Integer> errors, Map<String, Object> model) {
        model.put("indexForm", (indexForm == null ? new IndexForm() : indexForm));
        if (errors != null)
            model.put("errors", errors);
        return "index";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value="info", required=false) List<Integer> info, Map<String, Object> model) {
        model.put("loginForm", new LoginForm());
        if (info != null)
            model.put("info", info);
        return "login";
    }

    @RequestMapping(value = "/process_login", method = RequestMethod.POST)
    public String process_login(HttpServletRequest request, @ModelAttribute("loginForm") LoginForm loginForm, Map<String, Object> model, BindingResult result) {
        List<Integer> errors = new ArrayList<Integer>();
        try {
            Integer id = loginForm.getId();
            String password = loginForm.getPassword();

            if (id.equals(admin)) {
                if (!password.equals(admin_password)) {
                    errors.add(32);
                    throw new Exception();
                }
                HttpSession session = request.getSession();
                session.setAttribute("is_admin", true);
                return "redirect:/admin/";
            }

            User user_a = user.getUserById(id);
            if (user_a == null) {
                errors.add(31);
                throw new Exception();
            }

            if (!user_a.checkPassword(password)) {
                errors.add(32);
                throw new Exception();
            }

            return "redirect:/user/";
        } catch (Exception e) {

            model.put("loginForm", loginForm);
            model.put("login_errors", errors);
            return "redirect:/login";
        }
    }
}
