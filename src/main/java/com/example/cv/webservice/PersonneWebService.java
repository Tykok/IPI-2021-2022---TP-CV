package com.example.cv.webservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personne")
public class PersonneWebService {

    // http://localhost:8080/personne/test
    @GetMapping("/test")
    public String testMethods() {
        System.out.println("URL : personne/test \nMethods : test()");
        return "Méthode test de personne";
    }

    @GetMapping("id")
    public String getUser(){
        // Return the user with the id given in the url
        return "ok";
    }

    @GetMapping("/skills")
    public String getSkills(){
        // This function return the skill of a people according to the id given in url
        return "ok";
    }

    @GetMapping("competences")
    public String getCompetences(){
        // This function return the competences of a people according to the id given in url
        return "ok";
    }
}
