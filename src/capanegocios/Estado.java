package capanegocios;

import DTO.EstadoDTO;

public class Estado {
	
	private long id_estado;
	private String nombre;
	
	public Estado(EstadoDTO estado) {
		this.id_estado=estado.getId_estado();
		this.nombre=estado.getNombre();
	}
	public Estado() {
		// TODO Auto-generated constructor stub
	}
	public long getId_estado() {
		return id_estado;
	}
	public void setId_estado(long id_estado) {
		this.id_estado = id_estado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
