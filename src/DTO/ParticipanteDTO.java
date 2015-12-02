package DTO;

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
	private String imagen;
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
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
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
}


