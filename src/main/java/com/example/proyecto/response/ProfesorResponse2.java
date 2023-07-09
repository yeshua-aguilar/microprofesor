package com.example.proyecto.response;

import java.util.List;

import com.example.proyecto.dto.ProfesorDTO;

public class ProfesorResponse2 {
	private String resultado;
    private List<ProfesorDTO> profesor;
    
    public ProfesorResponse2() {
    	
    }

    public ProfesorResponse2(String resultado, List<ProfesorDTO> profesor) {
        this.resultado = resultado;
        this.profesor = profesor;
    }

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public List<ProfesorDTO> getProfesor() {
		return profesor;
	}

	public void setProfesor(List<ProfesorDTO> profesor) {
		this.profesor = profesor;
	}

    
}
