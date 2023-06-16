package com.example.proyecto.service;

import java.util.List;

import com.example.proyecto.dto.ProfesorCursoDTO;

public interface ProfesorCursoService {
	
	ProfesorCursoDTO crearProfesorCurso(ProfesorCursoDTO profesorCursoDTO);
    ProfesorCursoDTO obtenerProfesorCursoPorId(int id);
    List<ProfesorCursoDTO> obtenerTodosLosProfesoresCursos();
    boolean eliminarProfesorCurso(int id);

}
