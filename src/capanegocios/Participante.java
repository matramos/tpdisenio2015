package capanegocios;

import java.util.List;

public class Participante {
	
	private long id_participante;
	private String email;
	private String nombre;
	private String imagen;
	private int puntaje;
	private Competencia competencia;
	private int partidosGanados;
	private int partidosPerdidos;
	private int partidosEmpatados;
	private int tantosFav;
	private int tantosCont;
	private int tantosDif;
	private List<Encuentro> encuentros;
}
