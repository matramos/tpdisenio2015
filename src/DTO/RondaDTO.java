package DTO;

import java.util.ArrayList;
import java.util.List;
import capanegocios.Encuentro;
import capanegocios.Ronda;

public class RondaDTO {
	private long id_ronda;
	private int numeroRonda;
	private boolean finalizado;
	private boolean comenzada;
	private List<EncuentroDTO> encuentros = new ArrayList<EncuentroDTO>();
	
	public RondaDTO(Ronda ronda){
		this.id_ronda=ronda.getId_ronda();
		this.numeroRonda=ronda.getNumeroRonda();
		this.finalizado=ronda.isFinalizado();
		this.comenzada=ronda.isComenzada();
		for(Encuentro enc : ronda.getEncuentros()){
			EncuentroDTO encDTO = new EncuentroDTO(enc);
			this.encuentros.add(encDTO);
		}
	}
	
	public RondaDTO() {
		// TODO Auto-generated constructor stub
	}

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
	public List<EncuentroDTO> getEncuentros() {
		return encuentros;
	}
	public void setEncuentros(List<EncuentroDTO> encuentros) {
		this.encuentros = encuentros;
	}
}
