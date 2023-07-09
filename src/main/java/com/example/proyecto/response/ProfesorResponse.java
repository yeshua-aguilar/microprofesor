package com.example.proyecto.response;


import com.example.proyecto.dto.ProfesorDTO;

public class ProfesorResponse {
    private String resultado;
    private ProfesorDTO profesor;
    
    public ProfesorResponse() {
    }

    public ProfesorResponse(String resultado, ProfesorDTO profesor) {
        this.resultado = resultado;
        this.profesor = profesor;
    }

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public ProfesorDTO getProfesor() {
		return profesor;
	}

	public void setProfesor(ProfesorDTO profesor) {
		this.profesor = profesor;
	}
    
}


