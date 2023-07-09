package com.example.proyecto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.proyecto.Client.AlumnoFeignClient;
import com.example.proyecto.Client.CursoFeignClient;
import com.example.proyecto.dto.AlumnosDto;
import com.example.proyecto.dto.CursoDTO;
import com.example.proyecto.dto.ProfesorCursoAlumnoDTO;
import com.example.proyecto.dto.ResponseDto;
import com.example.proyecto.repository.ProfesorCursoAlumnoRepository;
import com.example.proyecto.repository.ProfesorRepository;
import com.example.proyecto.response.CursosResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.proyecto.entity.*;
import org.springframework.stereotype.Service;

@Service
public class ProfesorCursoAlumnoServiceImpl implements ProfesorCursoAlumnoService{
	
	@Autowired
	private ProfesorCursoAlumnoRepository profesorCursoAlumnoRepository;
	
	@Autowired
	private ProfesorRepository profesorRepository;
	
	@Autowired
	private CursoFeignClient cursoFeignClient;
	
	@Autowired
    private AlumnoFeignClient alumnoFeignClient;

	@Override
	public ProfesorCursoAlumnoDTO crearProfesorCursoAlumno(ProfesorCursoAlumnoDTO profesorCursoAlumnoDTO) {
		ProfesorCursoAlumno profesorcursoalumno = new ProfesorCursoAlumno();
		profesorcursoalumno.setIdCurso(profesorCursoAlumnoDTO.getIdCurso());
		profesorcursoalumno.setIdProfesor(profesorCursoAlumnoDTO.getIdProfesor());
		profesorcursoalumno.setIdAlumno(profesorCursoAlumnoDTO.getIdAlumno());
		profesorCursoAlumnoRepository.save(profesorcursoalumno);
		return profesorCursoAlumnoDTO;
	}

	@Override
	public ProfesorCursoAlumnoDTO obtenerProfesorCursoAlumnoPorId(int id) {
		ProfesorCursoAlumno profesorCursoAlumno = profesorCursoAlumnoRepository.findById(id).orElse(null);
		Profesor profesor = profesorRepository.findById(id).orElse(null);
		if (profesorCursoAlumno == null) {
			return null;
		}
	
		ProfesorCursoAlumnoDTO profesorCursoAlumnoDTO = new ProfesorCursoAlumnoDTO();
		profesorCursoAlumnoDTO.setId(profesorCursoAlumno.getId());
		profesorCursoAlumnoDTO.setIdCurso(profesorCursoAlumno.getIdCurso());
		profesorCursoAlumnoDTO.setIdProfesor(profesorCursoAlumno.getIdProfesor());
		profesorCursoAlumnoDTO.setNombreProfesor(profesor.getNombre());
		profesorCursoAlumnoDTO.setIdAlumno(profesorCursoAlumno.getIdAlumno());
		
		try {
		    // Llamar al método obtenerCursoPorId() del Feign Client para obtener el nombre del curso
		    CursosResponse cursoResponse = cursoFeignClient.obtenerCursoPorId(profesorCursoAlumno.getIdCurso());
		    if (cursoResponse != null && cursoResponse.getCursos() != null) {
		        CursoDTO cursoDTO = (CursoDTO) cursoResponse.getCursos();
		        profesorCursoAlumnoDTO.setNombreCurso(cursoDTO.getNombre());
		    }
		} catch (Exception e) {
		    // Manejar la excepción aquí
		    // Puedes imprimir un mensaje de error o realizar cualquier otra acción necesaria
		    e.printStackTrace();
		}
		
		try {
            ResponseDto responseDto = alumnoFeignClient.readAlumnos(profesorCursoAlumno.getIdAlumno());
            if (responseDto != null && responseDto.getData() != null) {
            	ObjectMapper mapper = new ObjectMapper();
            	AlumnosDto alumnoDto = mapper.convertValue(responseDto.getData(), AlumnosDto.class);
            	profesorCursoAlumnoDTO.setNombreAlumno(alumnoDto.getNombres());
            }
        } catch (Exception e) {
            // Manejar la excepción aquí
            // Puedes imprimir el mensaje de error o realizar alguna acción específica
            e.printStackTrace();
        }


		return profesorCursoAlumnoDTO;
	}

	@Override
	public List<ProfesorCursoAlumnoDTO> obtenerTodosLosProfesoresCursoAlumno() {
		List<ProfesorCursoAlumno> profesorCursoAlumnos = profesorCursoAlumnoRepository.findAll();
		List<Profesor> profesores = profesorRepository.findAll();
		return profesorCursoAlumnos.stream().map(profesorCursoAlumno -> {
			ProfesorCursoAlumnoDTO profesorCursoAlumnoDTO = new ProfesorCursoAlumnoDTO();
			profesorCursoAlumnoDTO.setId(profesorCursoAlumno.getId());
			profesorCursoAlumnoDTO.setIdCurso(profesorCursoAlumno.getIdCurso());
			profesorCursoAlumnoDTO.setIdProfesor(profesorCursoAlumno.getIdProfesor());
			profesorCursoAlumnoDTO.setIdAlumno(profesorCursoAlumno.getIdAlumno());
			
			try {
			    // Llamar al método obtenerCursoPorId() del Feign Client para obtener el nombre del curso
			    CursosResponse cursoResponse = cursoFeignClient.obtenerCursoPorId(profesorCursoAlumno.getIdCurso());
			    if (cursoResponse != null && cursoResponse.getCursos() != null) {
			        CursoDTO cursoDTO = (CursoDTO) cursoResponse.getCursos();
			        profesorCursoAlumnoDTO.setNombreCurso(cursoDTO.getNombre());
			    }
			} catch (Exception e) {
			    // Manejar la excepción aquí
			    // Puedes imprimir un mensaje de error o realizar cualquier otra acción necesaria
			    e.printStackTrace();
			}
			
			try {
                ResponseDto responseDto = alumnoFeignClient.readAlumnos(profesorCursoAlumno.getIdAlumno());
                if (responseDto != null && responseDto.getData() != null) {
                	ObjectMapper mapper = new ObjectMapper();
                	AlumnosDto alumnoDto = mapper.convertValue(responseDto.getData(), AlumnosDto.class);
                	profesorCursoAlumnoDTO.setNombreAlumno(alumnoDto.getNombres());
                }
            } catch (Exception e) {
                // Manejar la excepción aquí
                // Puedes imprimir el mensaje de error o realizar alguna acción específica
                e.printStackTrace();
            }

			Profesor profesor = profesores.stream().filter(p -> p.getId() == profesorCursoAlumno.getIdProfesor()).findFirst()
					.orElse(null);

			if (profesor != null) {
				profesorCursoAlumnoDTO.setNombreProfesor(profesor.getNombre());
			}

			return profesorCursoAlumnoDTO;
		}).collect(Collectors.toList());
	}

	@Override
	public boolean eliminarProfesorCursoAlumno(int id) {
		try {
			profesorCursoAlumnoRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
