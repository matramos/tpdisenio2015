package capanegocios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DTO.CompetenciaDTO;
import DTO.DisponibilidadDTO;

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
	private List<Ronda> rondas;
	private List<Disponibilidad> lugares = new ArrayList<Disponibilidad>();
	private Estado estado;
	
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
	
}
