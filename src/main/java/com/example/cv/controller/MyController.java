package com.example.cv.controller;

import com.example.cv.entities.Personne;
import com.example.cv.helper.exception.InvalidArgumentException;
import com.example.cv.service.PersonneService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    private PersonneService personneService;

    public MyController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping("")
    private String index(Model model) {
        List<Personne> users = personneService.findAll();
        model.addAttribute("personnes", users);
        return "index";
    }

    @GetMapping("/cv")
    private String getUserCv(Model model, @RequestParam(value = "id", defaultValue = "") long userId) throws InvalidArgumentException {
        model.addAttribute("personne", personneService.findById(userId));
        return "template_CV";
    }
}
