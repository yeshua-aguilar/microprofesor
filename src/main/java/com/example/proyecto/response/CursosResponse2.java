package com.example.proyecto.response;

import java.util.List;

import com.example.proyecto.dto.CursoDTO;

public class CursosResponse2 {
	private String resultado;
    private List<CursoDTO> cursos;

    public CursosResponse2(String resultado, List<CursoDTO> cursos) {
        this.resultado = resultado;
        this.cursos = cursos;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public List<CursoDTO> getCurso() {
        return cursos;
    }

    public void setCurso(List<CursoDTO> cursos) {
        this.cursos = cursos;
    }
}
