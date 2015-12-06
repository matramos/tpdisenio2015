package capanegocios;

import java.util.List;

import DTO.DeporteDTO;
import DTO.SeRealizaEnDTO;

public class Deporte {
	private long id;
	private String nombre;
	private List<SeRealizaEn> serealizaen;
	
	public Deporte(DeporteDTO deporte) {
		this.id=deporte.getId();
		this.nombre=deporte.getNombre();
		for(SeRealizaEnDTO realizaDTO : deporte.getSerealizaen()){
			SeRealizaEn realiza = new SeRealizaEn(realizaDTO);
			this.serealizaen.add(realiza);
		}
	}

	public Deporte() {
		
	}
	
	public void setId(long id){
		this.id=id;
		
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setSerealizaen(List<SeRealizaEn> serealizaen){
		this.serealizaen=serealizaen;
	}
	
	public long getId(){
		return id;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public List<SeRealizaEn> getSerealizaen(){
		return serealizaen;
	}
}
