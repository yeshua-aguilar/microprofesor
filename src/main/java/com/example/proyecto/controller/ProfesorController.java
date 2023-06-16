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
    private ProfesorService profesorService;

    @PostMapping
    public ResponseEntity<ProfesorResponse> crearProfesor(@RequestBody ProfesorDTO profesorDTO) {
        ProfesorDTO profesorCreado = profesorService.crearProfesor(profesorDTO);
        if (profesorCreado == null) {
        	return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new ProfesorResponse("Se creo el profesor corectamente", profesorCreado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> obtenerCursoPorId(@PathVariable int id) {
        ProfesorDTO profesor = profesorService.obtenerProfesorPorId(id);
        if (profesor == null) {
            return new ResponseEntity<>(new ProfesorResponse("La consulta ha dado error", null), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ProfesorResponse("Busqueda a travez del id Exitosa", profesor), HttpStatus.OK);
    }



    @GetMapping
    public ResponseEntity<ProfesorResponse2> obtenerTodosLosProfesores() {
        List<ProfesorDTO> profesores = profesorService.obtenerTodosLosProfesores();
        if (profesores.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new ProfesorResponse2("Busqueda de todos los profesores Exitosa", profesores));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProfesorResponse> eliminarProfesor(@PathVariable int id) {
        boolean eliminado = profesorService.eliminarProfesor(id);
        if (!eliminado) {
            return new ResponseEntity<>(new ProfesorResponse("Error al eliminar el profesor", null), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ProfesorResponse("Prfesor eliminado exitosamente", null), HttpStatus.OK);
    }
    
}
