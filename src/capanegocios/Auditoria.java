package capanegocios;

import java.sql.Date;
import java.sql.Time;

public class Auditoria {
	
	private Date fecha;
	private Time hora;
	private String accion;
	private String nombre;
	private String pc;
	
	public Auditoria(Date fecha,Time hora,String accion,String nombre,String pc){
		
		this.fecha=fecha;
		this.hora=hora;
		this.accion=accion;
		this.nombre=nombre;
		this.pc=pc;
	}
}
