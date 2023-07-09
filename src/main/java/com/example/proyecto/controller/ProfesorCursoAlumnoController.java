package com.example.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto.dto.ProfesorCursoAlumnoDTO;
import com.example.proyecto.response.ProfesorCursoAlumnoResponse;
import com.example.proyecto.response.ProfesorCursoAlumnoResponse2;
import com.example.proyecto.service.ProfesorCursoAlumnoService;

@RestController
@RequestMapping("/profesorcursoalumno")
public class ProfesorCursoAlumnoController {
	
	@Autowired
    private ProfesorCursoAlumnoService profesorCursoAlumnoService;
	
	@PostMapping
    public ResponseEntity<ProfesorCursoAlumnoResponse> crearProfesorCursoAlumno(@RequestBody ProfesorCursoAlumnoDTO profesorCursoAlumnoDTO) {
		ProfesorCursoAlumnoDTO profesorCursoAlumnoCreado = profesorCursoAlumnoService.crearProfesorCursoAlumno(profesorCursoAlumnoDTO);
        if (profesorCursoAlumnoCreado == null) {
        	return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new ProfesorCursoAlumnoResponse("Se creo el ProfesorCursoAlumno corectamente", profesorCursoAlumnoCreado));
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Object> obtenerProfesorCursoAlumnoPorId(@PathVariable int id) {
		ProfesorCursoAlumnoDTO profesorcursoalumno = profesorCursoAlumnoService.obtenerProfesorCursoAlumnoPorId(id);
        if (profesorcursoalumno == null) {
            return new ResponseEntity<>(new ProfesorCursoAlumnoResponse("La consulta ha dado error", null), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ProfesorCursoAlumnoResponse("Busqueda a travez del id Exitosa", profesorcursoalumno), HttpStatus.OK);
    }
	
	@GetMapping
    public ResponseEntity<ProfesorCursoAlumnoResponse2> obtenerTodosLosProfesoresCursoAlumno() {
        List<ProfesorCursoAlumnoDTO> profesorcursoalumno = profesorCursoAlumnoService.obtenerTodosLosProfesoresCursoAlumno();
        if (profesorcursoalumno.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new ProfesorCursoAlumnoResponse2("Busqueda de todos los ProfesorCursoAlumno Exitosa", profesorcursoalumno));
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<ProfesorCursoAlumnoResponse> eliminarProfesorCursoAlumno(@PathVariable int id) {
        boolean eliminado = profesorCursoAlumnoService.eliminarProfesorCursoAlumno(id);
        if (!eliminado) {
            return new ResponseEntity<>(new ProfesorCursoAlumnoResponse("Error al eliminar el ProfesorCursoAlumno", null), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ProfesorCursoAlumnoResponse("ProfesorCursoAlumno eliminado exitosamente", null), HttpStatus.OK);
    }

}
