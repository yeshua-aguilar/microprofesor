package com.example.proyecto.response;

import java.util.List;

import com.example.proyecto.dto.ProfesorCursoDTO;

public class ProfesorResponse4 {
	private String resultado;
    private List<ProfesorCursoDTO> cursos;

    public ProfesorResponse4(String resultado, List<ProfesorCursoDTO> profesorcurso) {
        this.resultado = resultado;
        this.cursos = profesorcurso;
    }

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public List<ProfesorCursoDTO> getCursos() {
		return cursos;
	}

	public void setCursos(List<ProfesorCursoDTO> cursos) {
		this.cursos = cursos;
	}

    
}
