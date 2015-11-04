package DTO;

import java.util.List;

import capanegocios.SeRealizaEn;

public class DeporteDTO {
	private long id;
	private String nombre;
	private List<SeRealizaEn> serealizaen;
	
	public void setId(long id){
		this.id = id;
	}
	
	public long getId(){
		return id;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre (String nombre){
		return nombre;
	}
	
	public void setSerealizaen(List<SeRealizaEn> serealizaen){
		this.serealizaen = serealizaen;
	}
	
	public List<SeRealizaEn> getSerealizaen(){
		return serealizaen;
	}
}
