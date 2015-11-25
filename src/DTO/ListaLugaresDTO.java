package DTO;

import java.util.ArrayList;
import java.util.List;

import capanegocios.Lugar;

public class ListaLugaresDTO {
	public List<LugarDTO> lugares = new ArrayList();
	
	public void setLugares(List<LugarDTO> lugares){
		this.lugares = lugares;
	}
	public List<LugarDTO> getLugares(){
		return lugares;
	}
	
	public void addLugar(LugarDTO lugar){
		this.lugares.add(lugar);
	}
	
	public LugarDTO getLugar(String lugar){
		LugarDTO retorno = new LugarDTO();
		for(LugarDTO object: lugares){
			if(object.getNombre().equals(lugar))
				retorno = object;
		}
		return retorno;
	}
}
