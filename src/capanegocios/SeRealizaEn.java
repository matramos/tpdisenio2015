package capanegocios;

import java.io.Serializable;

import DTO.SeRealizaEnDTO;

public class SeRealizaEn implements Serializable {
	private long idlugar;
	private long iddeporte;
	private Lugar lugar;
	private Deporte deporte;
	
	
	public SeRealizaEn(SeRealizaEnDTO realiza) {
		this.idlugar=realiza.getId_lugar();
		this.iddeporte=realiza.getId_deporte();
		this.lugar=new Lugar(realiza.getLugar());
		this.deporte=new Deporte(realiza.getDeporte());
	}

	public void setIdlugar(long idlugar){
		this.idlugar = idlugar;
	}
	
	public void setIddeporte(long iddeporte){
		this.iddeporte = iddeporte;
	}
	
	public long getIddeporte(){
		return iddeporte;
	}
	public long getIdlugar(){
		return idlugar;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public Deporte getDeporte() {
		return deporte;
	}

	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}
	
}
