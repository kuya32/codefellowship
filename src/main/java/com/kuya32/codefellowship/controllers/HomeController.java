package com.kuya32.codefellowship.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showHome(Model m, Principal principal) {
        System.out.println("Rendering the homepage!");
        m.addAttribute("principle", principal);
        return "home";
    }
}
