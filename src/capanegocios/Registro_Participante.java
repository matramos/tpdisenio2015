package capanegocios;

import java.awt.Image;
import java.sql.Date;
import java.sql.Time;

public class Registro_Participante {

	private int id_registro;
	private Time hora;
	private Date fecha;
	private Image imagen;
	private String nombre;
	private String email;
	private int puntaje;
	
	private Registro_Participante(int id_registro,Time hora,Date fecha, Image imagen,
			String nombre,String email,int puntaje){
		
		this.id_registro=id_registro;
		this.hora=hora;
		this.fecha=fecha;
		this.imagen=imagen;
		this.nombre=nombre;
		this.email=email;
		this.puntaje=puntaje;
	}
}
