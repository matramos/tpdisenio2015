package capanegocios;

import java.util.ArrayList;
import java.util.List;

import DTO.RondaDTO;
import javassist.bytecode.Descriptor.Iterator;

public class ListaRondas {

	public List<Ronda> rondas = new ArrayList();

	public List<Ronda> getParticipantes() {
		return rondas;
	}

	public void setRonda(List<Ronda> rondas) {
		this.rondas=rondas;
	}
	
	public void addRonda(Ronda ronda){
		this.rondas.add(ronda);
	}
	
	public  Ronda buscarRonda(long id_ronda){
		int i=0;
		Ronda encontrado = new Ronda();
		Iterator it= (Iterator) rondas;
		while(it.hasNext()) {
		long id= it.next();
		if (id == id_ronda){
			 encontrado=rondas.get(i);
		}
		
		}
		return encontrado;
	}
}

