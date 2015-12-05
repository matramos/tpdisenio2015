package capanegocios;

import java.util.List;

public class Ronda {
	private long id_ronda;
	private int numeroRonda;
	private boolean finalizado;
	private boolean comenzada;
	private List<Encuentro> encuentros;
	public long getId_ronda() {
		return id_ronda;
	}
	public void setId_ronda(long id_ronda) {
		this.id_ronda = id_ronda;
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
	public List<Encuentro> getEncuentros() {
		return encuentros;
	}
	public void setEncuentros(List<Encuentro> encuentros) {
		this.encuentros = encuentros;
	}
}
