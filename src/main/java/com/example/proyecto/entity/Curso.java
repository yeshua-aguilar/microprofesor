package com.example.proyecto.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "curso")
@Builder
@AllArgsConstructor
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "codigoLibro")
	private int codigolibro;
	@Column(name = "cantidadLibro")
	private int cantidaLibro;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCodigolibro() {
		return codigolibro;
	}
	public void setCodigolibro(int codigolibro) {
		this.codigolibro = codigolibro;
	}
	public int getCantidaLibro() {
		return cantidaLibro;
	}
	public void setCantidaLibro(int cantidaLibro) {
		this.cantidaLibro = cantidaLibro;
	}
	
	

}