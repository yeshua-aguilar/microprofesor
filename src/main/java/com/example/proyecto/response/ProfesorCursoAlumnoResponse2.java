package com.example.proyecto.response;

import java.util.List;

import com.example.proyecto.dto.ProfesorCursoAlumnoDTO;

public class ProfesorCursoAlumnoResponse2 {
	private String resultado;
    private List<ProfesorCursoAlumnoDTO> data;
    
public ProfesorCursoAlumnoResponse2() {
    	
    }

    public ProfesorCursoAlumnoResponse2(String resultado, List<ProfesorCursoAlumnoDTO> data) {
        this.resultado = resultado;
        this.data = data;
    }

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public List<ProfesorCursoAlumnoDTO> getData() {
		return data;
	}

	public void setData(List<ProfesorCursoAlumnoDTO> data) {
		this.data = data;
	}

	

    
}
