package com.example.cv.repository;

import com.example.cv.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepo extends JpaRepository<Personne, Long> {
}
