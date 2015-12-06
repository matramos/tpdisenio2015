package capanegocios;

import DTO.ModalidadDTO;

public class Modalidad {
	public long id_modalidad;
	public boolean liga;
	public boolean eliminatoriasimple;
	public boolean eliminatoriadoble;
	
	
	public Modalidad(ModalidadDTO modalidad) {
		this.id_modalidad=modalidad.getId_modalidad();
		this.liga=modalidad.isLiga();
		this.eliminatoriasimple=modalidad.isEliminatoriaSimple();
		this.eliminatoriadoble=modalidad.isEliminatoriaDoble();
	}
	
	public Modalidad() {
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

	public boolean getEliminatoriasimple() {
		return eliminatoriasimple;
	}
	public boolean getElminatoriasimple() {
		return eliminatoriasimple;
	}
	public void setEliminatoriasimple(boolean elminatoriaSimple) {
		this.eliminatoriasimple = elminatoriaSimple;
	}
	public void setElminatoriasimple(boolean elminatoriaSimple) {
		this.eliminatoriasimple = elminatoriaSimple;
	}
	public boolean getEliminatoriadoble() {
		return eliminatoriadoble;
	}
	public void setEliminatoriadoble(boolean eliminatoriaDoble) {
		this.eliminatoriadoble = eliminatoriaDoble;
	}

	
	
}
