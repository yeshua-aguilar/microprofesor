package com.example.proyecto.Client;


import com.example.proyecto.dto.CursoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cursos-service",url = "http://localhost:8085")
public interface CursoFeignClient {

    @GetMapping("/cursos/{id}")
    CursoDTO obtenerCursoPorId(@PathVariable("id") int id);
}



