package com.codewithmosh.store.controllers;


import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Harsh");
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "Harsh");
        return "home";
    }

}
