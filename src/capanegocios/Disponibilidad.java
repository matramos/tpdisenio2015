package capanegocios;

import DTO.DisponibilidadDTO;

public class Disponibilidad {
	
	private Lugar lugar;
	private int disponibilidad;
	
	
	public Disponibilidad(DisponibilidadDTO disponibilidad) {
		this.lugar=new Lugar(disponibilidad.getLugar());
		this.disponibilidad=disponibilidad.getDisponibilidad();
	}
	public Disponibilidad() {
		// TODO Auto-generated constructor stub
	}
	public Lugar getLugar() {
		return lugar;
	}
	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}
	public int getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	
}
