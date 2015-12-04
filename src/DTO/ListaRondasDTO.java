package DTO;

import java.util.ArrayList;
import java.util.List;

import capanegocios.Encuentro;
import capanegocios.Ronda;
import javassist.bytecode.Descriptor.Iterator;

public class ListaRondasDTO {
	public List<RondaDTO> rondas = new ArrayList();

	public List<RondaDTO> getParticipantes() {
		return rondas;
	}

	public void setRonda(List<RondaDTO> rondas) {
		this.rondas=rondas;
	}
	
	public void addRonda(RondaDTO ronda){
		this.rondas.add(ronda);
	}
	
	public  RondaDTO buscarRonda(long id_ronda){
		int i=0;
		RondaDTO encontrado = new RondaDTO();
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