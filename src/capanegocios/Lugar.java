package capanegocios;

import java.util.List;

public class Lugar {
	private long id;
	private String nombre;
	private String descripcion;
	private List<SeRealizaEn> serealizaen;
	
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
