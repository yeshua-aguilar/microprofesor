package com.example.proyecto.response;


import com.example.proyecto.dto.CursoDTO;

public class CursosResponse {
    private String resultado;
    private CursoDTO cursos;
    
    public CursosResponse() {
    }

    public CursosResponse(String resultado, CursoDTO curso) {
        this.resultado = resultado;
        this.cursos = curso;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public CursoDTO getCursos() {
        return cursos;
    }

    public void setCursos(CursoDTO cursos) {
        this.cursos = cursos;
    }
}


