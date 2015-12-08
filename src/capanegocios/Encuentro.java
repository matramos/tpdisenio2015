package capanegocios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DTO.EncuentroDTO;
import DTO.SetDTO;

public class Encuentro {
	private long id_encuentro;
	private boolean empate;
	private boolean resultadoReg;
	private int orden;
	private Date fecha;
	private Participante ganador;
	private Participante jugador1;
	private Participante jugador2;
	private Lugar lugar;
	private int puntajep1;
	private int puntajep2;
	private boolean estadop1;
	private boolean estadop2;
	private List<Encuentro> rganadores;
	private List<Encuentro> rperdedores;
	private List<Set> sets = new ArrayList<Set>();	
	private Encuentro encuentro1;
	private Encuentro encuentro2;
	private List<RegistroEncuentro> registros = new ArrayList<RegistroEncuentro>();
	
	public Encuentro(Participante participante1, Participante participante2) {
		this.jugador1 = participante1;
		this.jugador2 = participante2;
	}
	
	public Encuentro(){
		
	}
	
	public Encuentro(EncuentroDTO encuentro) {
		
		this.id_encuentro=encuentro.getId_encuentro();
		this.empate=encuentro.isEmpate();
		this.resultadoReg=encuentro.isResultadoReg();
		this.orden=encuentro.getOrden();
		this.fecha=encuentro.getFecha();
		this.ganador=new Participante(encuentro.getGanador());
		this.jugador1=new Participante(encuentro.getJugador1());
		this.jugador2=new Participante(encuentro.getJugador2());
		this.lugar=new Lugar(encuentro.getLugar());
		this.puntajep1=encuentro.getPuntajep1();
		this.puntajep2=encuentro.getPuntajep2();
		this.estadop1=encuentro.isEstadop1();
		this.estadop2=encuentro.isEstadop2();
		for(EncuentroDTO encuDTO : encuentro.getRganadores()){
			Encuentro encu = new Encuentro(encuDTO);
			rganadores.add(encu);
		}
		for(EncuentroDTO encuDTO : encuentro.getRperdedores()){
			Encuentro encu = new Encuentro(encuDTO);
			rperdedores.add(encu);
		}
		for(SetDTO setDTO : encuentro.getSets()){
			Set set = new Set(setDTO);
			sets.add(set);
		}
		this.encuentro1=new Encuentro(encuentro.getEncuentro1());
		this.encuentro2=new Encuentro(encuentro.getEncuentro2());
	}
	
	
	
	public List<RegistroEncuentro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<RegistroEncuentro> registros) {
		this.registros = registros;
	}

	public long getId_encuentro() {
		return id_encuentro;
	}
	public void setId_encuentro(long id_encuentro) {
		this.id_encuentro = id_encuentro;
	}
	public boolean isEmpate() {
		return empate;
	}
	public void setEmpate(boolean empate) {
		this.empate = empate;
	}
	public boolean isResultadoReg() {
		return resultadoReg;
	}
	public void setResultadoReg(boolean resultadoReg) {
		this.resultadoReg = resultadoReg;
	}
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Participante getGanador() {
		return ganador;
	}
	public void setGanador(Participante ganador) {
		this.ganador = ganador;
	}
	public Participante getJugador1() {
		return jugador1;
	}
	public void setJugador1(Participante jugador1) {
		this.jugador1 = jugador1;
	}
	public Participante getJugador2() {
		return jugador2;
	}
	public void setJugador2(Participante jugador2) {
		this.jugador2 = jugador2;
	}
	public Lugar getLugar() {
		return lugar;
	}
	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
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
	public boolean isEstadop1() {
		return estadop1;
	}
	public void setEstadop1(boolean estadop1) {
		this.estadop1 = estadop1;
	}
	public boolean isEstadop2() {
		return estadop2;
	}
	public void setEstadop2(boolean estadop2) {
		this.estadop2 = estadop2;
	}
	public List<Encuentro> getRganadores() {
		return rganadores;
	}
	public void setRganadores(List<Encuentro> rganadores) {
		this.rganadores = rganadores;
	}
	public List<Encuentro> getRperdedores() {
		return rperdedores;
	}
	public void setRperdedores(List<Encuentro> rperdedores) {
		this.rperdedores = rperdedores;
	}
	public List<Set> getSets() {
		return sets;
	}
	public void setSets(List<Set> sets) {
		this.sets = sets;
	}
	public Encuentro getEncuentro1() {
		return encuentro1;
	}
	public void setEncuentro1(Encuentro encuentro1) {
		this.encuentro1 = encuentro1;
	}
	public Encuentro getEncuentro2() {
		return encuentro2;
	}
	public void setEncuentro2(Encuentro encuentro2) {
		this.encuentro2 = encuentro2;
	}
	
	public void addSet(Set set1){
		sets.add(set1);
	}
	
}
