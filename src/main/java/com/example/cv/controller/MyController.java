package com.example.cv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MyController {

    public class User {

        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    @GetMapping("")
    private String index(Model model) {
        ArrayList<User> users = new ArrayList<>();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/user")
    private String getUserCv(Model model, @RequestParam(value = "id", defaultValue = "") int userId) {
        return "template_CV";
    }
}
