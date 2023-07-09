package com.example.proyecto.Client;



import com.example.proyecto.dto.ResponseDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-alumnos",url = "http://localhost:8082")
public interface AlumnoFeignClient {
	
	@GetMapping("/alumnos")
	public ResponseDto readAllAlumnos();

    @GetMapping("/alumnos/{id}")
    public ResponseDto readAlumnos(@PathVariable("id") int id);
}



