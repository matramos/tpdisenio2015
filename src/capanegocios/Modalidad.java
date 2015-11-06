package capanegocios;

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
	public boolean getElminatoriasimple() {
		return elminatoriasimple;
	}
	public void setElminatoriasimple(boolean elminatoriaSimple) {
		this.elminatoriasimple = elminatoriaSimple;
	}
	public boolean getEliminatoriadoble() {
		return eliminatoriadoble;
	}
	public void setEliminatoriadoble(boolean eliminatoriaDoble) {
		this.eliminatoriadoble = eliminatoriaDoble;
	}
	
	
}
