package capanegocios;

import DTO.ModalidadDTO;

public class Modalidad {
	public long id_modalidad;
	public boolean liga;
	public boolean elminatoriasimple;
	public boolean eliminatoriadoble;
	
	
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
		return elminatoriasimple;
	}
	public void setEliminatoriasimple(boolean elminatoriaSimple) {
		this.elminatoriasimple = elminatoriaSimple;
	}
	public boolean getEliminatoriadoble() {
		return eliminatoriadoble;
	}
	public void setEliminatoriadoble(boolean eliminatoriaDoble) {
		this.eliminatoriadoble = eliminatoriaDoble;
	}

	
	
}
