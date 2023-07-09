package com.example.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AlumnosDto {
	private Long id;
	private String nombres;
	private String apellidos;
	private String sexo;
	private Boolean estado;
}
