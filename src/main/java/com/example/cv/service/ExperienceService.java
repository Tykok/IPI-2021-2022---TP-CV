package com.example.cv.service;

import com.example.cv.entities.Experience;
import com.example.cv.repository.ExperienceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepo experienceRepo;

    private List<Experience> findAllByPersonneId(Long id) {
        List<Experience> experiences = experienceRepo.findAllByPersonneId(id);
        return experiences;
    }

}
