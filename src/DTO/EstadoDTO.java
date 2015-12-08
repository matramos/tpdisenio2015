package DTO;

import capanegocios.Estado;

public class EstadoDTO {
	private long id_estado;
	private String nombre;
	
	public EstadoDTO(Estado estado) {
		this.id_estado = estado.getId();
		this.nombre = estado.getNombre();
	}
	public EstadoDTO() {
		// TODO Auto-generated constructor stub
	}
	public long getId_estado() {
		return id_estado;
	}
	public void setId_estado(long l) {
		this.id_estado = l;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
