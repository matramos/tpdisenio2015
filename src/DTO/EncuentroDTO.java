package DTO;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import capanegocios.Encuentro;
import capanegocios.Lugar;
import capanegocios.Participante;
import capanegocios.Ronda;
import capanegocios.Set;

public class EncuentroDTO {
	private long id_encuentro;
	private boolean empate;
	private boolean resultadoReg;
	private int orden;
	private Date fecha;
	private ParticipanteDTO ganador;
	private ParticipanteDTO jugador1;
	private ParticipanteDTO jugador2;
	private LugarDTO lugar;
	private RondaDTO ronda;
	private int puntajep1;
	private int puntajep2;
	private boolean estadop1;
	private boolean estadop2;
	private List<EncuentroDTO> rganadores;
	private List<EncuentroDTO> rperdedores;
	private List<SetDTO> sets;	
	private EncuentroDTO encuentro1;
	private EncuentroDTO encuentro2;
	private boolean estado_encuentro;
	
	public EncuentroDTO(Encuentro encuentro){
		this.id_encuentro=encuentro.getId_encuentro();
		this.empate=encuentro.isEmpate();
		this.resultadoReg=encuentro.isResultadoReg();
		this.orden=encuentro.getOrden();
		this.fecha=encuentro.getFecha();
		this.ganador=new ParticipanteDTO(encuentro.getGanador());
		this.jugador1=new ParticipanteDTO(encuentro.getJugador1());
		this.jugador2=new ParticipanteDTO(encuentro.getJugador2());
		this.lugar=new LugarDTO(encuentro.getLugar());
		this.puntajep1=encuentro.getPuntajep1();
		this.puntajep2=encuentro.getPuntajep2();
		this.estadop1=encuentro.isEstadop1();
		this.estadop2=encuentro.isEstadop2();
		for(Encuentro rgan : encuentro.getRganadores()){
			EncuentroDTO rganDTO = new EncuentroDTO(rgan);
			this.rganadores.add(rganDTO);
		}
		for(Encuentro rper :encuentro.getRperdedores()){
			EncuentroDTO rperDTO = new EncuentroDTO(rper);
			this.rperdedores.add(rperDTO);
		}
		for(Set set : encuentro.getSets()){
			SetDTO setDTO = new SetDTO(set);
			this.sets.add(setDTO);
		}
		this.encuentro1=new EncuentroDTO(encuentro.getEncuentro1());
		this.encuentro2=new EncuentroDTO(encuentro.getEncuentro2());
		this.estado_encuentro=encuentro.isEstado_encuentro();
	}
	public EncuentroDTO() {
		// TODO Auto-generated constructor stub
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
	public ParticipanteDTO getGanador() {
		return ganador;
	}
	public void setGanador(ParticipanteDTO ganador) {
		this.ganador = ganador;
	}
	public ParticipanteDTO getJugador1() {
		return jugador1;
	}
	public void setJugador1(ParticipanteDTO jugador1) {
		this.jugador1 = jugador1;
	}
	public ParticipanteDTO getJugador2() {
		return jugador2;
	}
	public void setJugador2(ParticipanteDTO jugador2) {
		this.jugador2 = jugador2;
	}
	public LugarDTO getLugar() {
		return lugar;
	}
	public void setLugar(LugarDTO lugar) {
		this.lugar = lugar;
	}
	public RondaDTO getRonda() {
		return ronda;
	}
	public void setRonda(RondaDTO ronda) {
		this.ronda = ronda;
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
	public List<EncuentroDTO> getRganadores() {
		return rganadores;
	}
	public void setRganadores(List<EncuentroDTO> rganadores) {
		this.rganadores = rganadores;
	}
	public List<EncuentroDTO> getRperdedores() {
		return rperdedores;
	}
	public void setRperdedores(List<EncuentroDTO> rperdedores) {
		this.rperdedores = rperdedores;
	}
	public List<SetDTO> getSets() {
		return sets;
	}
	public void setSets(List<SetDTO> sets) {
		this.sets = sets;
	}
	public EncuentroDTO getEncuentro1() {
		return encuentro1;
	}
	public void setEncuentro1(EncuentroDTO encuentro1) {
		this.encuentro1 = encuentro1;
	}
	public EncuentroDTO getEncuentro2() {
		return encuentro2;
	}
	public void setEncuentro2(EncuentroDTO encuentro2) {
		this.encuentro2 = encuentro2;
	}
	
	public void addSet(SetDTO set){
		sets.add(set);
	}
	public boolean isEstado_encuentro() {
		return estado_encuentro;
	}
	public void setEstado_encuentro(boolean estado_encuentro) {
		this.estado_encuentro = estado_encuentro;
	}
}
	
	