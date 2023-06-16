package com.example.proyecto.Client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.proyecto.dto.CursoDTO;
import com.example.proyecto.response.ProfesorResponse;
import com.example.proyecto.response.ProfesorResponse2;

@FeignClient("cursos-service")
public interface CursosClient {

    @PostMapping("/cursos")
    ResponseEntity<ProfesorResponse> crearCurso(@RequestBody CursoDTO cursoDTO);
    
    @GetMapping("/cursos/{id}")
    ResponseEntity<Object> obtenerCursoPorId(@PathVariable int id);

    @GetMapping("/cursos")
    ResponseEntity<ProfesorResponse2> obtenerTodosLosCursos();

    @DeleteMapping("/cursos/{id}")
    ResponseEntity<ProfesorResponse> eliminarCurso(@PathVariable int id);
}

