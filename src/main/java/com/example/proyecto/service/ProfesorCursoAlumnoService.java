package com.example.proyecto.service;

import java.util.List;

import com.example.proyecto.dto.ProfesorCursoAlumnoDTO;


public interface ProfesorCursoAlumnoService {
	
	ProfesorCursoAlumnoDTO crearProfesorCursoAlumno(ProfesorCursoAlumnoDTO profesorCursoAlumnoDTO);
	ProfesorCursoAlumnoDTO obtenerProfesorCursoAlumnoPorId(int id);
    List<ProfesorCursoAlumnoDTO> obtenerTodosLosProfesoresCursoAlumno();
    boolean eliminarProfesorCursoAlumno(int id);

}
