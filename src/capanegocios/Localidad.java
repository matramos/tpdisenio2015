package capanegocios;

public class Localidad {

	private long id;
	private String nombre;

	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	public long getId(){
		return id;
	}
	public String getNombre(){
		
		return nombre;
	}
	public void setId(long id){
		this.id = id;
	}
}

