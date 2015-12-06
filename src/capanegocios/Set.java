package capanegocios;

import DTO.EncuentroDTO;
import DTO.SetDTO;

public class Set {
	private long id_set;
	private int puntajep1;
	private int puntajep2;
	
	public Set(SetDTO set) {
		this.id_set=set.getId_set();
		this.puntajep1=set.getPuntajep1();
		this.puntajep2=set.getPuntajep2();
	}
	public long getId_set() {
		return id_set;
	}
	public void setId_set(long id_set) {
		this.id_set = id_set;
	}
	public int getPuntajep1() {
		return puntajep1;
	}
	public void setPuntajep1(int puntajep1) {
		this.puntajep1 = puntajep1;
	}
	public int getPuntajep2() {
		return puntajep2;
	}
	public void setPuntajep2(int puntajep2) {
		this.puntajep2 = puntajep2;
	}
}


