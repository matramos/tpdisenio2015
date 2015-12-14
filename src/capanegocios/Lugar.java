package capanegocios;


import java.util.ArrayList;
import java.util.List;

import DTO.CompetenciaDTO;
import DTO.LugarDTO;
import DTO.SeRealizaEnDTO;

public class Lugar {
	private long id;
	private String nombre;
	private String descripcion;
	private List<SeRealizaEn> serealizaen;
	private List<Competencia> competencias = new ArrayList<Competencia>();

	
	public Lugar(LugarDTO lugar) {
		this.id=lugar.getId();
		this.nombre=lugar.getNombre();
		this.descripcion=lugar.getDescripcion();
		for(SeRealizaEnDTO realizaDTO : lugar.getSerealizaen()){
			SeRealizaEn realiza = new SeRealizaEn(realizaDTO);
			this.serealizaen.add(realiza);
		}
		for(CompetenciaDTO compDTO :lugar.getCompetencias()){
			Competencia comp = new Competencia(compDTO);
			this.competencias.add(comp);
		}
	}
	
	public Lugar() {
		
	}
	public List<Competencia> getCompetencias() {
		return competencias;
	}
	public void setCompetencias(List<Competencia> competencias) {
		this.competencias = competencias;
	}
	public String getNombre(){
		return nombre;
	}
	public void setSerealizaen(List<SeRealizaEn> serealizaen){
		this.serealizaen=serealizaen;
	}
	
	public List<SeRealizaEn> getSerealizaen(){
		return serealizaen;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id=id;
	}
	
	public String getDescripcion(){
		return descripcion;
	}
	
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
	
	
}
