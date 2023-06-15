package com.example.proyecto.response;

import java.util.List;

import com.example.proyecto.dto.ProfesorDTO;

public class ProfesorResponse2 {
	private String resultado;
    private List<ProfesorDTO> cursos;

    public ProfesorResponse2(String resultado, List<ProfesorDTO> cursos) {
        this.resultado = resultado;
        this.cursos = cursos;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public List<ProfesorDTO> getCurso() {
        return cursos;
    }

    public void setCurso(List<ProfesorDTO> cursos) {
        this.cursos = cursos;
    }
}
