package DTO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import capanegocios.Participante;
import capanegocios.Ronda;;

public class CompetenciaDTO {
	//Atributos de CompetenciaDTO
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
	
	
}
