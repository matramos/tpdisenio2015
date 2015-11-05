package capanegocios;

import java.util.Date;
import java.util.List;

import DTO.CompetenciaDTO;

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
	private List<Participante> participantes;
	private List<Ronda> rondas;
	private Estado estado;
	
	public Competencia(CompetenciaDTO competenciaDTO){
		this.id_competencia=competenciaDTO.getId_competencia();
		this.nombre=competenciaDTO.getNombre();
		this.cantidad_sets=competenciaDTO.getCantidad_sets();
		this.reglamento=competenciaDTO.getReglamento();
		this.puntos_presentarse=competenciaDTO.getPuntos_presentarse();
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
}
