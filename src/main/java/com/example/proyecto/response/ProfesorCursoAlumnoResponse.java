package com.example.proyecto.response;


import com.example.proyecto.dto.ProfesorCursoAlumnoDTO;

public class ProfesorCursoAlumnoResponse {
    private String resultado;
    private ProfesorCursoAlumnoDTO data;
    
    public ProfesorCursoAlumnoResponse() {
    	
    }

    public ProfesorCursoAlumnoResponse(String resultado, ProfesorCursoAlumnoDTO data) {
        this.resultado = resultado;
        this.data = data;
    }

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public ProfesorCursoAlumnoDTO getData() {
		return data;
	}

	public void setData(ProfesorCursoAlumnoDTO data) {
		this.data = data;
	}

	

	
    
}


