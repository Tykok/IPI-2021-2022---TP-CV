package com.example.cv.service;

import com.example.cv.entities.Skills;
import com.example.cv.repository.SkillsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillsService {

    @Autowired
    private SkillsRepo skillsRepo;

    private List<Skills> findAllByPersonneId(Long id) {
        List<Skills> skills = skillsRepo.findAllByPersonneId(id);
        return skills;
    }
}
