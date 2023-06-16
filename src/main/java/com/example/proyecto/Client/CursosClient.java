package com.example.proyecto.Client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.proyecto.dto.CursoDTO;
import com.example.proyecto.response.CursosResponse;
import com.example.proyecto.response.CursosResponse2;

@FeignClient(name = "proyecto", url = "http://localhost:8085")
public interface CursosClient {

    @PostMapping("/cursos")
    ResponseEntity<CursosResponse> crearCurso(@RequestBody CursoDTO cursoDTO);
    
    @GetMapping("/cursos/{id}")
    ResponseEntity<Object> obtenerCursoPorId(@PathVariable int id);

    @GetMapping("/cursos")
    ResponseEntity<CursosResponse2> obtenerTodosLosCursos();

    @DeleteMapping("/cursos/{id}")
    ResponseEntity<CursosResponse> eliminarCurso(@PathVariable int id);
}

