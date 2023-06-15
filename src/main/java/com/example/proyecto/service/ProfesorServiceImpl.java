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
    private ProfesorRepository cursoRepository;

    @Override
    public ProfesorDTO crearCurso(ProfesorDTO cursoDTO) {
        Profesor curso = new Profesor();
        curso.setNombre(cursoDTO.getNombre());
        curso.setApellido(cursoDTO.getApellido());
        curso.setEdad(cursoDTO.getEdad());
        cursoRepository.save(curso);
        cursoDTO.setId(curso.getId());
        return cursoDTO;
    }

    @Override
    public ProfesorDTO obtenerCursoPorId(int id) {
        Profesor curso = cursoRepository.findById(id).orElse(null);
        if (curso == null) {
            return null;
        }
        ProfesorDTO cursoDTO = new ProfesorDTO();
        cursoDTO.setId(curso.getId());
        cursoDTO.setNombre(curso.getNombre());
        cursoDTO.setApellido(curso.getApellido());
        cursoDTO.setEdad(curso.getEdad());
        return cursoDTO;
    }

    @Override
    public List<ProfesorDTO> obtenerTodosLosCursos() {
        List<Profesor> cursos = cursoRepository.findAll();
        return cursos.stream().map(curso -> {
            ProfesorDTO cursoDTO = new ProfesorDTO();
            cursoDTO.setId(curso.getId());
            cursoDTO.setNombre(curso.getNombre());
            cursoDTO.setApellido(curso.getApellido());
            cursoDTO.setEdad(curso.getEdad());
            return cursoDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public boolean eliminarCurso(int id) {
    	try {
            cursoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}