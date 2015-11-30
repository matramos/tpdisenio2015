package DTO;

import capanegocios.Modalidad;

public class ModalidadDTO {
	public long id_modalidad;
	public boolean liga;
	public boolean eliminatoriaSimple;
	public boolean eliminatoriaDoble;
	
	public ModalidadDTO(Modalidad modalidad) {
		this.id_modalidad = modalidad.getId_modalidad();
		this.liga = modalidad.isLiga();
		this.eliminatoriaSimple = modalidad.getElminatoriasimple();
		this.eliminatoriaDoble = modalidad.getEliminatoriadoble();
	}
	
	public ModalidadDTO() {
		// TODO Auto-generated constructor stub
	}

	public long getId_modalidad() {
		return id_modalidad;
	}
	public void setId_modalidad(long id_modalidad) {
		this.id_modalidad = id_modalidad;
	}
	public boolean isLiga() {
		return liga;
	}
	public void setLiga(boolean liga) {
		this.liga = liga;
	}
	public boolean isElminatoriaSimple() {
		return eliminatoriaSimple;
	}
	public void setElminatoriaSimple(boolean elminatoriaSimple) {
		this.eliminatoriaSimple = elminatoriaSimple;
	}
	public boolean isEliminatoriaDoble() {
		return eliminatoriaDoble;
	}
	public void setEliminatoriaDoble(boolean eliminatoriaDoble) {
		this.eliminatoriaDoble = eliminatoriaDoble;
	}
	
	public String getNombre(){
		if(liga) return "Liga";
		else if (eliminatoriaSimple) return "Eliminatoria Simple";
		else return "Eliminatoria Doble";
	}

}
