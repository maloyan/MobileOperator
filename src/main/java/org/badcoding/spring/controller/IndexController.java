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

}
