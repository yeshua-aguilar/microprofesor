package com.example.proyecto.response;


import com.example.proyecto.dto.ProfesorDTO;

public class ProfesorResponse {
    private String resultado;
    private ProfesorDTO cursos;

    public ProfesorResponse(String resultado, ProfesorDTO curso) {
        this.resultado = resultado;
        this.cursos = curso;
    }

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public ProfesorDTO getCursos() {
		return cursos;
	}

	public void setCursos(ProfesorDTO cursos) {
		this.cursos = cursos;
	}

    
}


