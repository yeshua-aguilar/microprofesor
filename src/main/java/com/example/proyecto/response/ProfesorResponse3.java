package com.example.proyecto.response;


import com.example.proyecto.dto.ProfesorCursoDTO;

public class ProfesorResponse3 {
    private String resultado;
    private ProfesorCursoDTO cursos;
    
public ProfesorResponse3() {
    	
    }

    public ProfesorResponse3(String resultado, ProfesorCursoDTO profesorcurso) {
        this.resultado = resultado;
        this.cursos = profesorcurso;
    }

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public ProfesorCursoDTO getCursos() {
		return cursos;
	}

	public void setCursos(ProfesorCursoDTO cursos) {
		this.cursos = cursos;
	}

	

    
}


