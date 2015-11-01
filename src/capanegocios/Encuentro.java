package capanegocios;

import java.util.Date;
import java.util.List;

public class Encuentro {
	private long id_encuentro;
	private boolean empate;
	private boolean resultadoReg;
	private int orden;
	private Date fecha;
	private Participante ganador;
	private Participante jugador1;
	private Participante jugador2;
	private Lugar lugar;
	private Ronda ronda;
	private int puntajep1;
	private int puntajep2;
	private boolean estadop1;
	private boolean estadop2;
	private List<Encuentro> rganadores;
	private List<Encuentro> rperdedores;
	private List<Set> sets;	
	private Encuentro encuentro1;
	private Encuentro encuentro2;
	
}
