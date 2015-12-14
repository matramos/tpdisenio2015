package capanegocios;

import java.util.ArrayList;
import java.util.List;

public class Provincia {
	
	private long id;
	private String nombre;
	private List<Localidad> localidades = new ArrayList<Localidad>();
	
	
	public String getNombre(){
		return nombre;
	}
	public long getId(){
		return id;
	}
	public void setId(long id){
		this.id = id;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void addLocalidad(Localidad localidad){
		this.localidades.add(localidad);
	}
	
	public List<Localidad> getLocalidades(){
		return localidades;
	}
	
	public void setLocalidades(List<Localidad> localidades){
		this.localidades= localidades;
	}
	
}
