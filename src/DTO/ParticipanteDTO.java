package DTO;

import java.awt.Image;
import java.util.List;

import org.hibernate.Transaction;

import Inicio.CrearSesion;
import capanegocios.Competencia;
import capanegocios.Encuentro;
import capanegocios.Participante;

public class ParticipanteDTO {
	
	private long id_participante;
	private String email;
	private String nombre;
	public byte[] imagen;
	public int puntaje;
	private CompetenciaDTO competencia;
	private int partidosGanados;
	private int partidosPerdidos;
	private int partidosEmpatados;
	public int tantosFav;
	private int tantosCont;
	public int tantosDif;
	private List<Encuentro> encuentros;
	
	
	public ParticipanteDTO(Participante part) {
		this.nombre= part.getNombre();
		this.email= part.getEmail();
		this.puntaje = part.getPuntaje();
		this.partidosGanados = part.getPartidosGanados();
		this.partidosPerdidos = part.getPartidosPerdidos();
		this.partidosEmpatados = part.getPartidosEmpatados();
		this.tantosFav = part.getTantosFav();
		this.tantosCont = part.getTantosCont();
		this.tantosDif = part.getTantosDif();
		// TODO Auto-generated constructor stub
	}
	public ParticipanteDTO() {
		this.puntaje = 0;
		this.partidosGanados = 0;
		this.partidosPerdidos = 0;
		this.partidosEmpatados = 0;
		this.tantosFav = 0;
		this.tantosCont = 0;
		this.tantosDif = 0;
	}
	public long getId_participante() {
		return id_participante;
	}
	public void setId_participante(long id_participante) {
		this.id_participante = id_participante;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public CompetenciaDTO getCompetencia() {
		return competencia;
	}
	public void setCompetencia(CompetenciaDTO competencia) {
		this.competencia = competencia;
	}
	public int getPartidosGanados() {
		return partidosGanados;
	}
	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}
	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}
	public void setPartidosPerdidos(int partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}
	public int getPartidosEmpatados() {
		return partidosEmpatados;
	}
	public void setPartidosEmpatados(int partidosEmpatados) {
		this.partidosEmpatados = partidosEmpatados;
	}
	public int getTantosFav() {
		return tantosFav;
	}
	public void setTantosFav(int tantosFav) {
		this.tantosFav = tantosFav;
	}
	public int getTantosCont() {
		return tantosCont;
	}
	public void setTantosCont(int tantosCont) {
		this.tantosCont = tantosCont;
	}
	public int getTantosDif() {
		return tantosDif;
	}
	public void setTantosDif(int tantosDif) {
		this.tantosDif = tantosDif;
	}
	public List<Encuentro> getEncuentros() {
		return encuentros;
	}
	public void setEncuentros(List<Encuentro> encuentros) {
		this.encuentros = encuentros;
	}
	
	public String[] crearFila(){
		int longitud = 5;
		if(tantosFav!=-1){
			longitud+=3;
		}
		String[] resultado = new String[longitud];
		resultado[0] = nombre;
		resultado[1] = ""+puntaje;
		resultado[2] = ""+partidosGanados;
		resultado[3] = ""+partidosEmpatados;
		resultado[4] = ""+partidosPerdidos;
		if(tantosFav!=-1){
			resultado[5] = ""+tantosFav;
			resultado[6] = ""+tantosCont;
			resultado[7] = ""+tantosDif;
		}
		return resultado;
		
		
	}
}


