package com.example.proyecto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto.Client.CursoFeignClient;
import com.example.proyecto.dto.CursoDTO;
import com.example.proyecto.dto.ProfesorCursoDTO;
import com.example.proyecto.entity.Profesor;
import com.example.proyecto.entity.ProfesorCurso;
import com.example.proyecto.repository.ProfesorCursoRepository;
import com.example.proyecto.repository.ProfesorRepository;

@Service
public class ProfesorCursoServiceImpl implements ProfesorCursoService {

	@Autowired
	private ProfesorCursoRepository profesorCursoRepository;

	@Autowired
	private ProfesorRepository profesorRepository;

	@Autowired
	private CursoFeignClient cursoFeignClient;

	public ProfesorCursoDTO crearProfesorCurso(ProfesorCursoDTO profesorCursoDTO) {
		ProfesorCurso profesorcurso = new ProfesorCurso();
		profesorCursoDTO.setId(profesorcurso.getId());
		profesorcurso.setIdCurso(profesorCursoDTO.getIdCurso());
		profesorcurso.setIdProfesor(profesorCursoDTO.getIdProfesor());
		profesorCursoRepository.save(profesorcurso);
		return profesorCursoDTO;
	}

	public ProfesorCursoDTO obtenerProfesorCursoPorId(int id) {
		ProfesorCurso profesorCurso = profesorCursoRepository.findById(id).orElse(null);
		Profesor profesor = profesorRepository.findById(id).orElse(null);
		if (profesorCurso == null) {
			return null;
		}
		
		CursoDTO curso = cursoFeignClient.obtenerCursoPorId(profesorCurso.getIdCurso());
		
		ProfesorCursoDTO profesorCursoDTO = new ProfesorCursoDTO();
		profesorCursoDTO.setId(profesorCurso.getId());
		profesorCursoDTO.setIdCurso(profesorCurso.getIdCurso());
		profesorCursoDTO.setNombreCurso(curso.getNombre());
		profesorCursoDTO.setIdProfesor(profesorCurso.getIdProfesor());
		profesorCursoDTO.setNombreProfesor(profesor.getNombre());

		return profesorCursoDTO;
	}

	public List<ProfesorCursoDTO> obtenerTodosLosProfesoresCursos() {
		List<ProfesorCurso> profesorCursos = profesorCursoRepository.findAll();
		List<Profesor> profesores = profesorRepository.findAll();
		return profesorCursos.stream().map(profesorCurso -> {
			ProfesorCursoDTO profesorCursoDTO = new ProfesorCursoDTO();
			profesorCursoDTO.setId(profesorCurso.getId());
			profesorCursoDTO.setIdCurso(profesorCurso.getIdCurso());
			profesorCursoDTO.setIdProfesor(profesorCurso.getIdProfesor());

			Profesor profesor = profesores.stream().filter(p -> p.getId() == profesorCurso.getIdProfesor()).findFirst()
					.orElse(null);

			if (profesor != null) {
				profesorCursoDTO.setNombreProfesor(profesor.getNombre());
			}

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
