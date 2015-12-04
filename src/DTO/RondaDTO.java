package DTO;

import java.util.List;
import capanegocios.Competencia;
import capanegocios.Encuentro;

public class RondaDTO {
	private long id_ronda;
	private Competencia competencia;
	private int numeroRonda;
	private boolean finalizado;
	private boolean comenzada;
	private List<EncuentroDTO> encuentros;
	public long getId_ronda() {
		return id_ronda;
	}
	public void setId_ronda(long id_ronda) {
		this.id_ronda = id_ronda;
	}
	public Competencia getCompetencia() {
		return competencia;
	}
	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}
	public int getNumeroRonda() {
		return numeroRonda;
	}
	public void setNumeroRonda(int numeroRonda) {
		this.numeroRonda = numeroRonda;
	}
	public boolean isFinalizado() {
		return finalizado;
	}
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	public boolean isComenzada() {
		return comenzada;
	}
	public void setComenzada(boolean comenzada) {
		this.comenzada = comenzada;
	}
	public List<EncuentroDTO> getEncuentros() {
		return encuentros;
	}
	public void setEncuentros(List<EncuentroDTO> encuentros) {
		this.encuentros = encuentros;
	}
}
