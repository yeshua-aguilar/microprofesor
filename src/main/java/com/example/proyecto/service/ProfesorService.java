package com.example.proyecto.service;

import java.util.List;

import com.example.proyecto.dto.ProfesorDTO;

public interface ProfesorService {
    ProfesorDTO crearProfesor(ProfesorDTO cursoDTO);
    ProfesorDTO obtenerProfesorPorId(int id);
    List<ProfesorDTO> obtenerTodosLosProfesores();
    boolean eliminarProfesor(int id);
}
