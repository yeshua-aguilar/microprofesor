package com.example.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorCursoDTO {
	
	private int id;
	private int idCurso;
	private String nombreCurso;
	private int idProfesor;
	private String nombreProfesor;

}
