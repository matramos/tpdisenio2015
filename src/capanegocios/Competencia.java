package capanegocios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DTO.CompetenciaDTO;
import DTO.DisponibilidadDTO;
import DTO.ParticipanteDTO;
import DTO.RondaDTO;


public class Competencia {

	private long id_competencia;
	private String nombre;
	private int cantidad_sets;
	private Modalidad modalidad;
	private String reglamento;
	private Deporte deporte;
	private int puntos_presentarse;
	private int puntos_ganador;
	private int puntos_empate;
	private boolean permite_empates;
	private Date fecha_hora;
	private int sets;
	private FormaPuntuacion puntuacion;
	private int resultado_final;
	private List<Participante> participantes = new ArrayList<Participante>();
	private List<Ronda> rondas = new ArrayList<Ronda>();
	private List<Disponibilidad> lugares = new ArrayList<Disponibilidad>();
	private Estado estado;
	private Usuario usuario;
	
	public Competencia(CompetenciaDTO competencia) {
		this.id_competencia=competencia.getId_competencia();
		this.nombre=competencia.getNombre();
		this.cantidad_sets=competencia.getCantidad_sets();
		this.modalidad=new Modalidad(competencia.getModalidad());
		this.reglamento=competencia.getReglamento();
		this.deporte=new Deporte(competencia.getDeporte());
		this.puntos_presentarse=competencia.getPuntos_presentarse();
		this.puntos_ganador=competencia.getPuntos_ganador();
		this.puntos_empate=competencia.getPuntos_empate();
		this.permite_empates=competencia.isPermite_empates();
		this.fecha_hora=competencia.getFecha_hora();
		this.sets=competencia.getSets();
		this.puntuacion=new FormaPuntuacion(competencia.getPuntuacion());
		this.resultado_final=competencia.getResultado_final();
		for(ParticipanteDTO partDTO : competencia.getParticipantes()){
			Participante part = new Participante(partDTO);
			participantes.add(part);
		}
		for(RondaDTO rondaDTO : competencia.getRondas()){
			Ronda ronda = new Ronda(rondaDTO);
			rondas.add(ronda);
		}
		for(DisponibilidadDTO dispoDTO : competencia.getLugares()){
			Disponibilidad dispo = new Disponibilidad(dispoDTO);
			lugares.add(dispo);
		}
		this.estado=new Estado(competencia.getEstado());
	}

	public Competencia() {
		// TODO Auto-generated constructor stub
	}

	public void CompetenciaDTO(CompetenciaDTO competenciaDTO){
		//this.id_competencia=competenciaDTO.getId_competencia();
		this.nombre=competenciaDTO.getNombre();
		this.cantidad_sets=competenciaDTO.getCantidad_sets();
		this.reglamento=competenciaDTO.getReglamento();
		this.puntos_presentarse=competenciaDTO.getPuntos_presentarse();
		this.puntos_ganador=competenciaDTO.getPuntos_ganador();
		this.puntos_empate=competenciaDTO.getPuntos_empate();
		this.permite_empates=competenciaDTO.isPermite_empates();
		this.fecha_hora=competenciaDTO.getFecha_hora();
		this.sets=competenciaDTO.getSets();
		this.resultado_final=competenciaDTO.getResultado_final();
	}
	
	public void agregarParticipante(Participante participante){
		participantes.add(participante);
	}
	
	

	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setDeporte(Deporte deporte){
		this.deporte = deporte;
	}
	
	public void setPuntuacion(FormaPuntuacion puntuacion){
		this.puntuacion = puntuacion;
	}
	
	public void setModalidad(Modalidad modalidad){
		this.modalidad = modalidad;
	}
	
	public void setEstado(Estado estado){
		this.estado = estado;
	}

	public long getId_competencia() {
		return id_competencia;
	}

	public void setId_competencia(long id_competencia) {
		this.id_competencia = id_competencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad_sets() {
		return cantidad_sets;
	}

	public void setCantidad_sets(int cantidad_sets) {
		this.cantidad_sets = cantidad_sets;
	}

	public String getReglamento() {
		return reglamento;
	}

	public void setReglamento(String reglamento) {
		this.reglamento = reglamento;
	}

	public int getPuntos_presentarse() {
		return puntos_presentarse;
	}

	public void setPuntos_presentarse(int puntos_presentarse) {
		this.puntos_presentarse = puntos_presentarse;
	}

	public int getPuntos_ganador() {
		return puntos_ganador;
	}

	public void setPuntos_ganador(int puntos_ganador) {
		this.puntos_ganador = puntos_ganador;
	}

	public int getPuntos_empate() {
		return puntos_empate;
	}

	public void setPuntos_empate(int puntos_empate) {
		this.puntos_empate = puntos_empate;
	}

	public boolean isPermite_empates() {
		return permite_empates;
	}

	public void setPermite_empates(boolean permite_empates) {
		this.permite_empates = permite_empates;
	}

	public Date getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(Date fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public int getResultado_final() {
		return resultado_final;
	}

	public void setResultado_final(int resultado_final) {
		this.resultado_final = resultado_final;
	}

	public List<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public List<Ronda> getRondas() {
		return rondas;
	}
	
	public Ronda getRonda(long id_ronda) {
		Ronda retorno = null;
		for(Ronda r: this.rondas){
			if(r.getId_ronda()==id_ronda)
				retorno=r;
				
		}
		return retorno;
	}

	public void setRondas(List<Ronda> rondas) {
		this.rondas = rondas;
	}

	public Modalidad getModalidad() {
		return modalidad;
	}

	public Deporte getDeporte() {
		return deporte;
	}

	public FormaPuntuacion getPuntuacion() {
		return puntuacion;
	}

	public Estado getEstado() {
		return estado;
	}


	public List<Disponibilidad> getLugares() {
		return lugares;
	}


	public void setLugares(List<Disponibilidad> lugares) {
		this.lugares = lugares;
	}
	
	public void addLugar(Disponibilidad lugar){
		this.lugares.add(lugar);
	}

	public void borrarFixture() {
		rondas.clear();
	}

	public void addRonda(Ronda rondita) {
		rondas.add(rondita);
	}

	public void ActualizarEncuentro(long id_ronda,Encuentro encuentroActualizado) {
		
		int i=0;
		int j=0;
		int x=0;
		int y=0;
		
		for(Ronda ronda : rondas ){
			if(ronda.getId_ronda()==id_ronda){
				for(Encuentro encuentro : ronda.getEncuentros()){
					if(encuentro.getId_encuentro()==encuentroActualizado.getId_encuentro()){
						ronda.getEncuentros().set(j,encuentroActualizado);
						Ronda rondaActualizada=ronda;
						rondas.set(i, rondaActualizada);
						x=i;
						y=j;
						
					}
					j++;
				}
			}
			i++;
		}
		
	}

	public void actualizarParticipantes(Participante participanteP1, Participante participanteP2) {
		
		for(Participante p : this.participantes){
			if(p.getId_participante()==participanteP1.getId_participante()){
				p=participanteP1;
				
			}
			if(p.getId_participante()==participanteP2.getId_participante()){
				p=participanteP2;
				
			}
		}
		
	}
	
}
