package capanegocios;

public class RegistroSet {

	private long id_registro_set;
	private int puntajeP1;
	private int puntajeP2;
	
	public RegistroSet(Set set) {
		this.puntajeP1=set.getPuntajep1();
		this.puntajeP2=set.getPuntajep2();
	}
	public long getId_registro_set() {
		return id_registro_set;
	}
	public void setId_registro_set(long id_registro_set) {
		this.id_registro_set = id_registro_set;
	}
	public int getPuntajeP1() {
		return puntajeP1;
	}
	public void setPuntajeP1(int puntajeP1) {
		this.puntajeP1 = puntajeP1;
	}
	public int getPuntajeP2() {
		return puntajeP2;
	}
	public void setPuntajeP2(int puntajeP2) {
		this.puntajeP2 = puntajeP2;
	}
}
