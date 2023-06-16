package com.example.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.proyecto.entity.ProfesorCurso;

@Repository
public interface ProfesorCursoRepository extends JpaRepository<ProfesorCurso, Integer> {
    
}

