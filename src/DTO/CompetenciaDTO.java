package DTO;

import java.util.Date;
import java.util.List;

import capanegocios.Competencia;
import capanegocios.Lugar;
import capanegocios.Participante;
import capanegocios.Ronda;

public class CompetenciaDTO {
	//Atributos de CompetenciaDTO
	private long id_competencia;
	private String nombre;
	private int cantidad_sets;
	private ModalidadDTO modalidad;
	private String reglamento;
	private DeporteDTO deporte;
	private int puntos_presentarse;
	private int puntos_ganador;
	private int puntos_empate;
	private boolean permite_empates;
	private Date fecha_hora;
	private int sets;
	private String puntuacion;
	private EstadoDTO estado;
	private int resultado_final;
	private List<String> lugares;
	private List<Participante> participantes;
	private List<Ronda> rondas;
	
	
	public CompetenciaDTO(Competencia comp) {
		this.id_competencia = comp.getId_competencia();
		this.nombre = comp.getNombre();
		//this.modalidad = comp.getModalidad().getNombre();
		//this.estado = comp.getEstado().getNombre();
		
	}
	
	public CompetenciaDTO() {
	}

	public List<String> getLugares() {
		return lugares;
	}
	public void setLugares(List<String> lugares) {
		this.lugares = lugares;
	}
	public DeporteDTO getDeporte() {
		return deporte;
	}
	public void setDeporte(DeporteDTO deporte) {
		this.deporte = deporte;
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
	public ModalidadDTO getModalidad() {
		return modalidad;
	}
	public void setModalidad(ModalidadDTO modalidad) {
		this.modalidad = modalidad;
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
	public String getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(String puntuacion) {
		this.puntuacion = puntuacion;
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
	public EstadoDTO getEstado() {
		return estado;
	}
	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}
	
}
