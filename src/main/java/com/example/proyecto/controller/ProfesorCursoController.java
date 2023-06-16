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

import com.example.proyecto.dto.ProfesorCursoDTO;
import com.example.proyecto.response.ProfesorResponse3;
import com.example.proyecto.response.ProfesorResponse4;
import com.example.proyecto.service.ProfesorCursoService;

@RestController
@RequestMapping(value = "/profesorcurso", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfesorCursoController {
	
	@Autowired
    private ProfesorCursoService profesorCursoService;
	
	@PostMapping
    public ResponseEntity<ProfesorResponse3> crearProfesorCurso(@RequestBody ProfesorCursoDTO profesorCursoDTO) {
        ProfesorCursoDTO profesorCursoCreado = profesorCursoService.crearProfesorCurso(profesorCursoDTO);
        if (profesorCursoCreado == null) {
        	return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new ProfesorResponse3("Se creo el profesorCurso corectamente", profesorCursoCreado));
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Object> obtenerProfesorCursoPorId(@PathVariable int id) {
		ProfesorCursoDTO profesorcurso = profesorCursoService.obtenerProfesorCursoPorId(id);
        if (profesorcurso == null) {
            return new ResponseEntity<>(new ProfesorResponse3("La consulta ha dado error", null), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ProfesorResponse3("Busqueda a travez del id Exitosa", profesorcurso), HttpStatus.OK);
    }
	
	@GetMapping
    public ResponseEntity<ProfesorResponse4> obtenerTodosLosProfesoresCursos() {
        List<ProfesorCursoDTO> profesorcurso = profesorCursoService.obtenerTodosLosProfesoresCursos();
        if (profesorcurso.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new ProfesorResponse4("Busqueda de todos los profesorCursos Exitosa", profesorcurso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProfesorResponse3> eliminarProfesorCurso(@PathVariable int id) {
        boolean eliminado = profesorCursoService.eliminarProfesorCurso(id);
        if (!eliminado) {
            return new ResponseEntity<>(new ProfesorResponse3("Error al eliminar el profesorCurso", null), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ProfesorResponse3("ProfesorCurso eliminado exitosamente", null), HttpStatus.OK);
    }

}
