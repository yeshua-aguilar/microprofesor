package com.example.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorCursoAlumnoDTO {
	
	private int id;
	private int idCurso;
	private String NombreCurso;
	private int idProfesor;
	private String NombreProfesor;
	private int idAlumno;
	private String NombreAlumno;
	

}
