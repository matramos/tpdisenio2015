package DTO;

import java.util.List;

import capanegocios.Competencia;
import capanegocios.Lugar;
import capanegocios.Participante;
import capanegocios.SeRealizaEn;

public class LugarDTO {
	private long id;
	private String nombre;
	private String descripcion;
	private List<SeRealizaEnDTO> serealizaen;
	private List<CompetenciaDTO> competencias;
	
	public LugarDTO(Lugar lugar){
		this.id=lugar.getId();
		this.descripcion=lugar.getDescripcion();
		for(SeRealizaEn realiza : lugar.getSerealizaen()){
			SeRealizaEnDTO realizaDTO = new SeRealizaEnDTO(realiza);
			this.serealizaen.add(realizaDTO);
		}
		for(Competencia comp : lugar.getCompetencias()){
			CompetenciaDTO compDTO = new CompetenciaDTO(comp);
			this.competencias.add(compDTO);
		}
	}
	
	
	public LugarDTO() {
		// TODO Auto-generated constructor stub
	}


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
