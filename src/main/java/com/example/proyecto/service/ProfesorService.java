package com.example.proyecto.service;

import java.util.List;

import com.example.proyecto.dto.ProfesorDTO;

public interface ProfesorService {
    ProfesorDTO crearCurso(ProfesorDTO cursoDTO);
    ProfesorDTO obtenerCursoPorId(int id);
    List<ProfesorDTO> obtenerTodosLosCursos();
    boolean eliminarCurso(int id);
}
