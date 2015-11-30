package DTO;

import java.util.List;

public class LugarDTO {
	private long id;
	private String nombre;
	private String descripcion;
	private List<SeRealizaEnDTO> serealizaen;
	private List<CompetenciaDTO> competencias;
	
	
	public List<CompetenciaDTO> getCompetencias() {
		return competencias;
	}

	public void setCompetencias(List<CompetenciaDTO> competencias) {
		this.competencias = competencias;
	}

	public void setId(long id){
		this.id = id;
	}
	
	public long getId(){
		return id;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
	
	public String getDescripcion (){
		return descripcion;
	}

	public List<SeRealizaEnDTO> getSerealizaen() {
		return serealizaen;
	}

	public void setSerealizaen(List<SeRealizaEnDTO> serealizaen) {
		this.serealizaen = serealizaen;
	}
	
	public void addSerealizaen(SeRealizaEnDTO serealizaen){
		this.serealizaen.add(serealizaen);
	}
}
