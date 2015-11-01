package capanegocios;

import java.sql.Date;
import java.util.List;

public class Competencia {

	private int id_competencia;
	private String nombre;
	private int cantidad_sets;
	private String modalidad;
	private String reglamento;
	private int puntos_presentarse;
	private int puntos_ganador;
	private int puntos_empate;
	private boolean permite_empates;
	private Date fecha_hora;
	private int sets;
	private int puntuacion;
	private int resultado_final;
	private List<Participante> participantes;
	private List<Ronda> rondas;
	public Competencia(int id_competencia,String nombre,int cantidad_sets,String modalidad,String reglamento,int puntos_presentarse,
			int puntos_empate,boolean permite_empates,Date fecha_hora,int sets,int puntuacion,int resultado_final){
		this.id_competencia=id_competencia;
		this.nombre=nombre;
		this.cantidad_sets=cantidad_sets;
		this.modalidad=modalidad;
		this.reglamento=reglamento;
		this.puntos_presentarse=puntos_presentarse;
		this.puntos_empate=puntos_empate;
		this.permite_empates=permite_empates;
		this.fecha_hora=fecha_hora;
		this.sets=sets;
		this.puntuacion=puntuacion;
		this.resultado_final=resultado_final;
	}
}
