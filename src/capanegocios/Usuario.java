package capanegocios;

import java.util.ArrayList;
import java.util.List;


public class Usuario {
	
	private long id;
	private String apellido;
	private String nombre;
	private String contrasena;
	private String email;
	private TipoDocumento tipo;
	private int documento;
	private List<Lugar> lugares = new ArrayList<Lugar>();
	//private List<Competencia> competencias = new ArrayList<Competencia>();
	private Localidad localidad;
	private Auditoria auditoria;
	
	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public Auditoria getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
	}

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