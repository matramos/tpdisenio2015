package capanegocios;

import java.util.List;

public class Deporte {
	private long id;
	private String nombre;
	private List<SeRealizaEn> serealizaen;
	
	
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
