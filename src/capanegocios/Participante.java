package capanegocios;

import java.util.List;
import DTO.CompetenciaDTO;
import DTO.ParticipanteDTO;

public class Participante {
	
	private long id_participante;
	private String email;
	private String nombre;
	private String imagen;
	private int puntaje;
	private int partidosGanados;
	private int partidosPerdidos;
	private int partidosEmpatados;
	private int tantosFav;
	private int tantosCont;
	private int tantosDif;
	
	public void ParticipanteDTO(ParticipanteDTO participanteDTO) {
		this.id_participante=participanteDTO.getId_participante();
		this.email=participanteDTO.getEmail();
		this.nombre=participanteDTO.getNombre();
		this.imagen=participanteDTO.getImagen();
		this.puntaje = participanteDTO.getPuntaje();
		this.partidosGanados = participanteDTO.getPartidosGanados();
		this.partidosPerdidos = participanteDTO.getPartidosPerdidos();
		this.partidosEmpatados = participanteDTO.getPartidosEmpatados();
		this.tantosFav = participanteDTO.getTantosFav();
		this.tantosCont = participanteDTO.getTantosCont();
		this.tantosDif=participanteDTO.getTantosDif();
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
	
	
}
