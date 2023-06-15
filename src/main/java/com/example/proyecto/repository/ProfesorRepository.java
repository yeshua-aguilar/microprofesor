package com.example.proyecto.repository;

import com.example.proyecto.entity.Profesor;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
	
}



