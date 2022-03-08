package com.example.cv.webservice;

import com.example.cv.entities.Personne;
import com.example.cv.helper.exception.InvalidArgumentException;
import com.example.cv.service.PersonneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personne")
public class PersonneWebService {

    private PersonneService personneService;

    public PersonneWebService(
            PersonneService personneService
    ) {
        this.personneService = personneService;
    }

    @GetMapping()
    public List<Personne> getAll() {
        List<Personne> personnes = personneService.findAll();
        return personnes;
    }

    @GetMapping("/{id}")
    public Personne getById(@PathVariable Long id) throws InvalidArgumentException {
        Personne personne = personneService.findById(id);
        return personne;
    }

    @PostMapping()
    public Personne save(@RequestBody Personne personne) {
        return personneService.save(personne);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        personneService.deleteById(id);
    }

    @GetMapping("/delete")
    public void deleteAll() {
        personneService.deleteAll();
    }
}
