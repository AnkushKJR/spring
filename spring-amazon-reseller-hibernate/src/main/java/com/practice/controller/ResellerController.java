package com.practice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.dao.ResellerDao;
import com.practice.model.Reseller;




@Controller
public class ResellerController {
	@GetMapping("/register")
    public String showForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(Reseller r) {
        new ResellerDao().register(r);
        return "login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session) {

        Reseller r = new ResellerDao().login(username, password);

        if (r != null) {
            session.setAttribute("reseller", r);
            return "home";
        } else {
            return "login";
        }
    }
}
