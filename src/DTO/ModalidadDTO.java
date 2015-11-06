package DTO;

public class ModalidadDTO {
	public long id_modalidad;
	public boolean liga;
	public boolean elminatoriaSimple;
	public boolean eliminatoriaDoble;
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
		return elminatoriaSimple;
	}
	public void setElminatoriaSimple(boolean elminatoriaSimple) {
		this.elminatoriaSimple = elminatoriaSimple;
	}
	public boolean isEliminatoriaDoble() {
		return eliminatoriaDoble;
	}
	public void setEliminatoriaDoble(boolean eliminatoriaDoble) {
		this.eliminatoriaDoble = eliminatoriaDoble;
	}

}
