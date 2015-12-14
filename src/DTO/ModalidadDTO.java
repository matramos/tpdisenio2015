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
		this.eliminatoriaSimple = modalidad.getEliminatoriasimple();
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
	public boolean isEliminatoriaSimple() {
		return eliminatoriaSimple;
	}
	public void setEliminatoriaSimple(boolean elminatoriaSimple) {
		this.eliminatoriaSimple = elminatoriaSimple;
	}
	public boolean isEliminatoriaDoble() {
		return eliminatoriaDoble;
	}
	public void setEliminatoriaDoble(boolean eliminatoriaDoble) {
		this.eliminatoriaDoble = eliminatoriaDoble;
	}
	public String getNombre(){
		String retorno="";
		if(id_modalidad==1) retorno = "Liga";
		else if (id_modalidad==2) retorno =  "Eliminatoria Simple";
		else if(id_modalidad==3) retorno =  "Eliminatoria Doble";
		return retorno;
	}
}
