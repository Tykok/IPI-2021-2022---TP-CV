package com.example.cv.webservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    // http://localhost:8080/personne?id=:id
    @GetMapping("")
    public Integer getUser(@RequestParam Integer id){
        System.out.println("URL : personne?id=" + id + "\nMethods : test()");
        // Return the user with the id given in the url
        return id;
    }

    // http://localhost:8080/personne/skills?id=:id
    @GetMapping("/skills")
    public Integer getSkills(@RequestParam Integer id){
        System.out.println("URL : personne/skills?id=" + id + "\nMethods : test()");
        // This function return the skill of a people according to the id given in url
        return id;
    }

    // http://localhost:8080/personne/competences?id=:id
    @GetMapping("/competences")
    public Integer getCompetences(@RequestParam Integer id){
        System.out.println("URL : personne/competences?id=" + id + "\nMethods : test()");
        // This function return the competences of a people according to the id given in url
        return id;
    }
}
