package DTO;

import java.sql.Date;
import java.sql.Time;

public class RegistroEncuentroDTO {

	long id_registro;
	long id_encuentro;
	int puntajep1;
	int puntajep2;
	boolean estado_encuentro;
	boolean estado_participante1;
	boolean estado_participante2;
	int numero_encuentro;
	Date fecha;
	Time hora;
	int ganador;
	boolean empate;
	
	public long getId_registro() {
		return id_registro;
	}
	public void setId_registro(long id_registro) {
		this.id_registro = id_registro;
	}
	public long getId_encuentro() {
		return id_encuentro;
	}
	public void setId_encuentro(long id_encuentro) {
		this.id_encuentro = id_encuentro;
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
}
