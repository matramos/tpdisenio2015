package DTO;

import java.util.List;

import capanegocios.Lugar;

public class ListaLugaresDTO {
	private List<Lugar> lugares;
	
	public void setLugares(List<Lugar> lugares){
		this.lugares = lugares;
	}
	public List<Lugar> getLugares(){
		return lugares;
	}
	
	public void addLugar(Lugar lugar){
		this.lugares.add(lugar);
	}
}
