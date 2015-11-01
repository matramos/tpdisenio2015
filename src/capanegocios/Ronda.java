package capanegocios;

import java.util.List;

public class Ronda {
	private long id_ronda;
	private Competencia competencia;
	private int numeroRonda;
	private boolean finalizado;
	private boolean comenzada;
	private List<Encuentro> encuentros;
}
