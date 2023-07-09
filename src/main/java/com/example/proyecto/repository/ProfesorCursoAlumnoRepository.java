package com.example.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.proyecto.entity.ProfesorCursoAlumno;

@Repository
public interface ProfesorCursoAlumnoRepository extends JpaRepository<ProfesorCursoAlumno, Integer> {
    
}