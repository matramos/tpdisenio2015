package DTO;

import java.util.ArrayList;
import java.util.List;

import javassist.bytecode.Descriptor.Iterator;

public class ListaEncuentrosDTO {
	public List<EncuentroDTO> encuentros = new ArrayList();

	public List<EncuentroDTO> getParticipantes() {
		return encuentros;
	}

	public void setEncuentro(List<EncuentroDTO> encuentros) {
		this.encuentros=encuentros;
	}
	
	public void addEncuentro(EncuentroDTO encuentro){
		this.encuentros.add(encuentro);
	}
	public  EncuentroDTO buscarEncuentro(long id_encuentro){
		int i=0;
		EncuentroDTO encontrado = new EncuentroDTO();
		Iterator it= (Iterator) encuentros;
		while(it.hasNext()) {
		long id= it.next();
		if (id == id_encuentro){
			 encontrado=encuentros.get(i);
		}
		
		}
		return encontrado;
	}
}
