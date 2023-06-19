package com.example.proyecto.Client;


import com.example.proyecto.dto.CursoDTO;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "proyecto",url = "http://localhost:8085")
public interface CursoFeignClient {
	
	@GetMapping("/cursos")
    List<CursoDTO> obtenerTodosLosCursos();

    @GetMapping("/cursos/{id}")
    CursoDTO obtenerCursoPorId(@PathVariable("id") int id);
}



