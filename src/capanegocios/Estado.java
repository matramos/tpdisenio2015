package capanegocios;

import DTO.EstadoDTO;

public class Estado {
	
	private long id;
	private String nombre;
	
	public Estado(EstadoDTO estado) {
		this.id=estado.getId_estado();
		this.nombre=estado.getNombre();
	}
	public Estado() {
		// TODO Auto-generated constructor stub
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
