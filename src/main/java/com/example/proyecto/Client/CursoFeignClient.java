package com.example.proyecto.Client;


import com.example.proyecto.response.CursosResponse;
import com.example.proyecto.response.CursosResponse2;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "proyecto",url = "http://localhost:8085")
public interface CursoFeignClient {
	
	@GetMapping("/cursos")
	CursosResponse2 obtenerTodosLosCursos();

    @GetMapping("/cursos/{id}")
    CursosResponse obtenerCursoPorId(@PathVariable("id") int id);
    
}



