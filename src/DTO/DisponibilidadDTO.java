package DTO;

public class DisponibilidadDTO {
	private LugarDTO lugar;
	private int disponibilidad;
	
	public LugarDTO getLugar() {
		return lugar;
	}
	public void setLugar(LugarDTO lugar) {
		this.lugar = lugar;
	}
	public int getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	
}
