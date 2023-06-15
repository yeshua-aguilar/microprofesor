package com.example.proyecto.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto.dto.ProfesorDTO;
import com.example.proyecto.response.ProfesorResponse;
import com.example.proyecto.response.ProfesorResponse2;
import com.example.proyecto.service.ProfesorService;

@RestController
@RequestMapping(value = "/profesores", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfesorController {

    @Autowired
    private ProfesorService cursoService;

    @PostMapping
    public ResponseEntity<ProfesorResponse> crearCurso(@RequestBody ProfesorDTO cursoDTO) {
        ProfesorDTO cursoCreado = cursoService.crearCurso(cursoDTO);
        if (cursoCreado == null) {
        	return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new ProfesorResponse("Se creo el profesor corectamente", cursoCreado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> obtenerCursoPorId(@PathVariable int id) {
        ProfesorDTO curso = cursoService.obtenerCursoPorId(id);
        if (curso == null) {
            return new ResponseEntity<>(new ProfesorResponse("La consulta ha dado error", null), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ProfesorResponse("Busqueda a travez del id Exitosa", curso), HttpStatus.OK);
    }



    @GetMapping
    public ResponseEntity<ProfesorResponse2> obtenerTodosLosCursos() {
        List<ProfesorDTO> cursos = cursoService.obtenerTodosLosCursos();
        if (cursos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new ProfesorResponse2("Busqueda de todos los profesores Exitosa", cursos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProfesorResponse> eliminarCurso(@PathVariable int id) {
        boolean eliminado = cursoService.eliminarCurso(id);
        if (!eliminado) {
            return new ResponseEntity<>(new ProfesorResponse("Error al eliminar el profesor", null), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ProfesorResponse("Prfesor eliminado exitosamente", null), HttpStatus.OK);
    }
}
