package capanegocios;

import java.util.ArrayList;
import java.util.List;

public class Pais {
	
	private long id;
	private String nombre;
	private List<Provincia> provincias = new ArrayList<Provincia>();
	
	public Pais(int id,String nombre){
		this.id=id;
		this.nombre=nombre;
	}
	
	public void setId(long id){
		this.id= id;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setProvincias(List provincias){
		this.provincias = provincias;
	}
	
	public String getnombre_pais(){
		return nombre;
	}
	
	public List getProvincias(){
		return provincias;
	}
	
	public Long getId(){
		return id;
	}
	
	public void addProvincia(Provincia provincia){
		this.provincias.add(provincia);
	}
}
