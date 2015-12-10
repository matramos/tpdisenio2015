package DTO;

import capanegocios.FormaPuntuacion;

public class FormaPuntuacionDTO {
	
	public long id_formadepuntuacion;
	public boolean sets;
	public boolean resultadoFinal;
	public boolean puntuacion;
	
	public FormaPuntuacionDTO(FormaPuntuacion puntuacion2) {
		this.id_formadepuntuacion = puntuacion2.getId_formadepuntuacion();
		this.sets = puntuacion2.isSets();
		this.resultadoFinal = puntuacion2.isResultadoFinal();
		this.puntuacion = puntuacion2.isPuntuacion();
	}
	
	public FormaPuntuacionDTO() {
	
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
