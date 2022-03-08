package com.example.cv.service;

import com.example.cv.entities.Experience;
import com.example.cv.entities.Personne;
import com.example.cv.entities.Skills;
import com.example.cv.helper.exception.InvalidArgumentException;
import com.example.cv.helper.exception.stringException.StringExceptions;
import com.example.cv.repository.ExperienceRepo;
import com.example.cv.repository.PersonneRepo;
import com.example.cv.repository.SkillsRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneService {

    private PersonneRepo personneRepo;
    private ExperienceService experienceService;
    private SkillsService skillsService;
    private ExperienceRepo experienceRepo;
    private SkillsRepo skillsRepo;

    public PersonneService(
            PersonneRepo personneRepo,
            ExperienceService experienceService,
            SkillsService skillsService,
            ExperienceRepo experienceRepo,
            SkillsRepo skillsRepo
    ) {
        this.personneRepo = personneRepo;
        this.experienceService = experienceService;
        this.skillsService = skillsService;
        this.experienceRepo = experienceRepo;
        this.skillsRepo = skillsRepo;
    }

    public List<Personne> findAll() {
        List<Personne> personnes = personneRepo.findAll();
        return personnes;
    }

    public Personne findById(Long id) throws InvalidArgumentException {
        Personne personne = personneRepo.findById(id)
                .orElseThrow(() -> new InvalidArgumentException(
                        StringExceptions.INVALID_ARGUMENT + id
                ));
        return personne;
    }

    public Personne save(Personne personne) {
        Personne savedPersonne = personneRepo.save(personne);
        List<Experience> experiences = personne.getExperiences();
        List<Skills> skillsList = personne.getSkills();
        for (Experience experience : experiences) {
            experience.setPersonne(savedPersonne);
        }
        if (experiences.size() > 0)
            experienceRepo.saveAll(experiences);
        for (Skills skills : skillsList) {
            skills.setPersonne(personne);
        }
        if (skillsList.size() > 0)
            skillsRepo.saveAll(skillsList);
        return savedPersonne;
    }

    public void deleteById(Long id) {
        personneRepo.deleteById(id);
    }

    public void deleteAll() {
        personneRepo.deleteAll();
    }
}