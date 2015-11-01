package capanegocios;

public class Disponibilidad {
	
	private int id_lugar;
	private int id_competencia;
	private int disponibilidad;
	
	private Disponibilidad(int id_lugar,int id_competencia,int disponibilidad){
		
		this.id_lugar=id_lugar;
		this.id_competencia=id_competencia;
		this.disponibilidad=disponibilidad;
	}
}
