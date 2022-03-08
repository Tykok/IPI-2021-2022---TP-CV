package com.example.cv.repository;

import com.example.cv.entities.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepo extends JpaRepository<Experience, Long> {

    List<Experience> findAllByPersonneId(Long id);
}
