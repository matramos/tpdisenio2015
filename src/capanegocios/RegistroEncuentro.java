package capanegocios;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class RegistroEncuentro {

	private long id_registro;
	private Encuentro encuentro;
	private int puntajep1;
	private int puntajep2;
	private boolean estado_encuentro;
	private boolean estado_participante1;
	private boolean estado_participante2;
	private int numero_encuentro;
	private List<RegistroSet> registroSets = new ArrayList<RegistroSet>();
	private Date fecha;
	private Time hora;
	int ganador;
	private boolean empate;
	
	public RegistroEncuentro() {
		// TODO Auto-generated constructor stub
	}
	
	public RegistroEncuentro(Encuentro encuentroActualizado) {
		//this.id_encuentro=encuentroActualizado.getId_encuentro();
		this.encuentro=encuentroActualizado;
		this.puntajep1=encuentroActualizado.getPuntajep1();
		this.puntajep2=encuentroActualizado.getPuntajep2();
		//this.estado_encuentro=encuentroActualizado.isEstado_encuentro();
		this.estado_participante1=encuentroActualizado.isEstadop1();
		this.estado_participante2=encuentroActualizado.isEstadop2();
		//this.numero_encuentro=encuentroActualizado.getOrden();
		//this.registroSets=registroSets;
		//fecha
		//hora
		//this.ganador=encuentroActualizado.getGanador();
		this.empate=encuentroActualizado.isEmpate();
	}
	
	public long getId_registro() {
		return id_registro;
	}
	public void setId_registro(long id_registro) {
		this.id_registro = id_registro;
	}
	
	public Encuentro getEncuentro() {
		return encuentro;
	}

	public void setEncuentro(Encuentro encuentro) {
		this.encuentro = encuentro;
	}

	public int getPuntajep1() {
		return puntajep1;
	}
	public void setPuntajep1(int puntajep1) {
		this.puntajep1 = puntajep1;
	}
	public int getPuntajep2() {
		return puntajep2;
	}
	public void setPuntajep2(int puntajep2) {
		this.puntajep2 = puntajep2;
	}
	public boolean isEstado_encuentro() {
		return estado_encuentro;
	}
	public void setEstado_encuentro(boolean estado_encuentro) {
		this.estado_encuentro = estado_encuentro;
	}
	public boolean isEstado_participante1() {
		return estado_participante1;
	}
	public void setEstado_participante1(boolean estado_participante1) {
		this.estado_participante1 = estado_participante1;
	}
	public boolean isEstado_participante2() {
		return estado_participante2;
	}
	public void setEstado_participante2(boolean estado_participante2) {
		this.estado_participante2 = estado_participante2;
	}
	public int getNumero_encuentro() {
		return numero_encuentro;
	}
	public void setNumero_encuentro(int numero_encuentro) {
		this.numero_encuentro = numero_encuentro;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	public int getGanador() {
		return ganador;
	}
	public void setGanador(int ganador) {
		this.ganador = ganador;
	}
	public boolean isEmpate() {
		return empate;
	}
	public void setEmpate(boolean empate) {
		this.empate = empate;
	}

	public List<RegistroSet> getRegistroSets() {
		return registroSets;
	}

	public void setRegistroSets(List<RegistroSet> registroSets) {
		this.registroSets = registroSets;
	}
}
