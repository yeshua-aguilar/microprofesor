package com.example.proyecto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.proyecto.dto.ProfesorCursoDTO;
import com.example.proyecto.entity.ProfesorCurso;
import com.example.proyecto.repository.ProfesorCursoRepository;



public class ProfesorCursoServiceImpl {
	
	@Autowired
    private ProfesorCursoRepository profesorCursoRepository;
	
	public ProfesorCursoDTO crearProfesorCurso(ProfesorCursoDTO profesorCursoDTO) {
        ProfesorCurso profesorcurso = new ProfesorCurso();
        profesorcurso.setIdCurso(profesorCursoDTO.getIdCurso());
        profesorcurso.setIdProfesor(profesorCursoDTO.getIdCurso());
        profesorCursoRepository.save(profesorcurso);
        profesorCursoDTO.setId(profesorcurso.getId());
        return profesorCursoDTO;
    }
	
	public ProfesorCursoDTO obtenerProfesorCursoPorId(int id) {
        ProfesorCurso profesorCurso = profesorCursoRepository.findById(id).orElse(null);
        if (profesorCurso == null) {
            return null;
        }
        ProfesorCursoDTO profesorCursoDTO = new ProfesorCursoDTO();
        profesorCursoDTO.setId(profesorCurso.getId());
        profesorCursoDTO.setIdCurso(profesorCurso.getIdCurso());
        profesorCursoDTO.setIdProfesor(profesorCurso.getIdProfesor());
        return profesorCursoDTO;
    }
	
	public List<ProfesorCursoDTO> obtenerTodosLosProfesoresCursos() {
        List<ProfesorCurso> profesorCursos = profesorCursoRepository.findAll();
        return profesorCursos.stream().map(profesorCurso -> {
        	ProfesorCursoDTO profesorCursoDTO = new ProfesorCursoDTO();
        	profesorCursoDTO.setId(profesorCurso.getId());
        	profesorCursoDTO.setIdCurso(profesorCurso.getIdCurso());
        	profesorCursoDTO.setIdProfesor(profesorCurso.getIdProfesor());
            return profesorCursoDTO;
        }).collect(Collectors.toList());
    }
	
	public boolean eliminarProfesorCurso(int id) {
    	try {
    		profesorCursoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    
}
