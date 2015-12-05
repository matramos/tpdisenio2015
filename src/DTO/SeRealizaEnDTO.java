package DTO;

import java.util.List;

import capanegocios.Deporte;
import capanegocios.Lugar;
import capanegocios.SeRealizaEn;

public class SeRealizaEnDTO {
	public long id_lugar;
	public long id_deporte;
	private Lugar lugar;
	private Deporte deporte;

	public SeRealizaEnDTO(SeRealizaEn realiza){
		this.id_lugar=realiza.getIdlugar();
		this.id_deporte=realiza.getIddeporte();
		this.lugar=realiza.getLugar();
		this.deporte=realiza.getDeporte();
	}
	
	public SeRealizaEnDTO() {
		// TODO Auto-generated constructor stub
	}

	public long getId_lugar() {
		return id_lugar;
	}
	public void setId_lugar(long id_lugar) {
		this.id_lugar = id_lugar;
	}
	public long getId_deporte() {
		return id_deporte;
	}
	public void setId_deporte(long id_deporte) {
		this.id_deporte = id_deporte;
	}

	
	
}
