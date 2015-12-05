package capanegocios;

import java.util.ArrayList;
import java.util.List;

import DTO.EncuentroDTO;
import javassist.bytecode.Descriptor.Iterator;

public class ListaEncuentros {
	
	public List<Encuentro> encuentros = new ArrayList();

	public List<Encuentro> getParticipantes() {
		return encuentros;
	}

	public void setEncuentro(List<Encuentro> encuentros) {
		this.encuentros=encuentros;
	}
	
	public void addEncuentro(Encuentro encuentro){
		this.encuentros.add(encuentro);
	}
	public  Encuentro buscarEncuentro(long id_encuentro){
		int i=0;
		Encuentro encontrado = new Encuentro();
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
