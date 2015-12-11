package DTO;



public class InfoCompetenciaDTO {

	private ModalidadDTO modalidad;
	private FormaPuntuacionDTO puntuacion;
	private EstadoDTO estado;
	private boolean permite_empates;
	private int puntos_empate;
	private int puntos_ganador;
	private int puntos_presentarse;
	private int resultado_final;
	
	
	
	public int getResultado_final() {
		return resultado_final;
	}
	public void setResultado_final(int resultado_final) {
		this.resultado_final = resultado_final;
	}
	public ModalidadDTO getModalidad() {
		return modalidad;
	}
	public void setModalidad(ModalidadDTO modalidad) {
		this.modalidad = modalidad;
	}
	
	public EstadoDTO getEstado() {
		return estado;
	}
	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}
	public boolean isPermite_empates() {
		return permite_empates;
	}
	public void setPermite_empates(boolean permite_empates) {
		this.permite_empates = permite_empates;
	}
	public int getPuntos_empate() {
		return puntos_empate;
	}
	public void setPuntos_empate(int puntos_empate) {
		this.puntos_empate = puntos_empate;
	}
	public int getPuntos_ganador() {
		return puntos_ganador;
	}
	public void setPuntos_ganador(int puntos_ganador) {
		this.puntos_ganador = puntos_ganador;
	}
	public int getPuntos_presentarse() {
		return puntos_presentarse;
	}
	public void setPuntos_presentarse(int puntos_presentarse) {
		this.puntos_presentarse = puntos_presentarse;
	}
	public FormaPuntuacionDTO getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(FormaPuntuacionDTO puntuacion) {
		this.puntuacion = puntuacion;
	}
}