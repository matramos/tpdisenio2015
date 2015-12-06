package capanegocios;

import DTO.FormaPuntuacionDTO;

public class FormaPuntuacion {
	public long id_formadepuntuacion;
	public boolean sets;
	public boolean resultadoFinal;
	public boolean puntuacion;
	
	public FormaPuntuacion(FormaPuntuacionDTO puntuacion) {
		this.id_formadepuntuacion=puntuacion.getId_formadepuntuacion();
		this.sets=puntuacion.isSets();
		this.resultadoFinal=puntuacion.isResultadoFinal();
		this.puntuacion=puntuacion.isPuntuacion();
	}
	public FormaPuntuacion() {
		// TODO Auto-generated constructor stub
	}
	public long getId_formadepuntuacion() {
		return id_formadepuntuacion;
	}
	public void setId_formadepuntuacion(long id_formadepuntuacion) {
		this.id_formadepuntuacion = id_formadepuntuacion;
	}
	public boolean isSets() {
		return sets;
	}
	public void setSets(boolean sets) {
		this.sets = sets;
	}
	public boolean isResultadoFinal() {
		return resultadoFinal;
	}
	public void setResultadoFinal(boolean resultadoFinal) {
		this.resultadoFinal = resultadoFinal;
	}
	public boolean isPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(boolean puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	
	
	
}
