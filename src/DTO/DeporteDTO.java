package DTO;

import java.util.List;

import capanegocios.SeRealizaEn;

public class DeporteDTO {
	private long id;
	private String nombre;
	private List<SeRealizaEnDTO> serealizaen;
	
	public void setId(long id){
		this.id = id;
	}
	
	public long getId(){
		return id;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre (){
		return nombre;
	}
	
	public void setSerealizaen(List<SeRealizaEnDTO> serealizaen){
		this.serealizaen = serealizaen;
	}
	
	
	public List<SeRealizaEnDTO> getSerealizaen(){
		return serealizaen;
	}
	
	public void addSerealizaen(SeRealizaEnDTO serealizaen){
		this.serealizaen.add(serealizaen);
	}
}
