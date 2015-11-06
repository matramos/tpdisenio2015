package DTO;
import java.util.ArrayList;
import java.util.List;

import capanegocios.Deporte;

public class ListaDeportesDTO {
	public List<DeporteDTO> deportes = new ArrayList();
	
	public List<DeporteDTO> getDeportes(){
		return deportes;
	}
	
	public void setDeportes(List<DeporteDTO> deportes){
		this.deportes = deportes;
	}
	
	public void addDeporte(DeporteDTO deporte){
		this.deportes.add(deporte);
	}
	
	public long returnId(String deporte){
		long id=0;
		for(DeporteDTO object: this.deportes){
			if(object.getNombre().equals(deporte))
				id=object.getId();
		}
		return id;
	}
}
