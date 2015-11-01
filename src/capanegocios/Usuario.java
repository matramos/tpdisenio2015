package capanegocios;

import java.util.List;

import javax.persistence.*;


public class Usuario {
	
	private long id;
	private String apellido;
	private String nombre;
	private String contrasena;
	private String email;
	private TipoDocumento tipo;
	private int documento;
	private List<Lugar> lugares;
	
	
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id=id;
	}
	
	public String getContrasena(){
		return contrasena;
	}
	
	public void setContrasena(String contrasena){
		this.contrasena=contrasena;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	public String getApellido(){
		return apellido;
	}
	
	public void setApellido(String apellido){
		this.apellido=apellido;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public TipoDocumento getTipo(){
		return tipo;
	}
	
	public void setTipo(TipoDocumento tipo){
		this.tipo=tipo;
	}
	
	public int getDocumento(){
		return documento;
	}
	
	public void setDocumento(int documento){
		this.documento=documento;
	}
	
	public List<Lugar> getLugares(){
		return lugares;
	}
	
	public void setLugares(List<Lugar> lugares){
		this.lugares=lugares;
	}
}