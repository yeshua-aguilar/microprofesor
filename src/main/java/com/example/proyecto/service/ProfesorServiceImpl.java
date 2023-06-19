package com.example.proyecto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.proyecto.dto.ProfesorDTO;
import com.example.proyecto.entity.Profesor;
import com.example.proyecto.repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService {
	
    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public ProfesorDTO crearProfesor(ProfesorDTO profesorDTO) {
        Profesor profesor = new Profesor();
        profesor.setNombre(profesorDTO.getNombre());
        profesor.setApellido(profesorDTO.getApellido());
        profesor.setEdad(profesorDTO.getEdad());
        profesorRepository.save(profesor);
        profesorDTO.setId(profesor.getId());
        return profesorDTO;
    }

    @Override
    public ProfesorDTO obtenerProfesorPorId(int id) {
        Profesor profesor = profesorRepository.findById(id).orElse(null);
        if (profesor == null) {
            return null;
        }
        ProfesorDTO profesorDTO = new ProfesorDTO();
        profesorDTO.setId(profesor.getId());
        profesorDTO.setNombre(profesor.getNombre());
        profesorDTO.setApellido(profesor.getApellido());
        profesorDTO.setEdad(profesor.getEdad());
        return profesorDTO;
    }

    @Override
    public List<ProfesorDTO> obtenerTodosLosProfesores() {
        List<Profesor> profesores = profesorRepository.findAll();
        return profesores.stream().map(profesor -> {
            ProfesorDTO profesorDTO = new ProfesorDTO();
            profesorDTO.setId(profesor.getId());
            profesorDTO.setNombre(profesor.getNombre());
            profesorDTO.setApellido(profesor.getApellido());
            profesorDTO.setEdad(profesor.getEdad());
            return profesorDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public boolean eliminarProfesor(int id) {
    	try {
    		profesorRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
