package com.example.cv.repository;

import com.example.cv.entities.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillsRepo extends JpaRepository<Skills, Long> {

    List<Skills> findAllByPersonneId(Long id);
}
