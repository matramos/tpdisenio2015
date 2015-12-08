package capanegocios;
import java.util.ArrayList;
import java.util.List;

import DTO.EncuentroDTO;
import DTO.RondaDTO;

public class Ronda {
	private long id_ronda;
	private int numeroRonda;
	private boolean finalizado;
	private boolean comenzada;
	private List<Encuentro> encuentros = new ArrayList<Encuentro>();
	
	public Ronda(RondaDTO ronda) {
		this.id_ronda=ronda.getId_ronda();
		this.numeroRonda=ronda.getNumeroRonda();
		this.finalizado=ronda.isFinalizado();
		this.comenzada=ronda.isComenzada();
		for(EncuentroDTO encuentroDTO : ronda.getEncuentros()){
			Encuentro encuentro = new Encuentro(encuentroDTO);
			encuentros.add(encuentro);
		}
	}
	public Ronda() {
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
	public List<Encuentro> getEncuentros() {
		return encuentros;
	}
	public void setEncuentros(List<Encuentro> encuentros) {
		this.encuentros = encuentros;
	}
	public void add(Encuentro encuentrito) {
		encuentros.add(encuentrito);	
	}
	public Encuentro getEncuentro(long id_encuentro) {
		Encuentro retorno = null;
		for(Encuentro e: this.encuentros){
			if(e.getId_encuentro()==id_encuentro)
				retorno=e;
				
		}
		return retorno;
	}
}
