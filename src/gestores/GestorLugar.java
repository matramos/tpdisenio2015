package gestores;

import java.util.Iterator;
import java.util.List;

import DAO.LugarDAO;
import DTO.ListaLugaresDTO;
import capanegocios.Lugar;

public class GestorLugar {
	//private static ListaLugaresDTO lugares;
	private static ListaLugaresDTO listaLugares;
	
	public static ListaLugaresDTO getListadoLugares(){
		listaLugares = LugarDAO.getListado();
		
		
		/*Iterator iter = listaLugares.iterator();
		while (iter.hasNext()){
			Object l = iter.next();
			lugares.addLugar( l);
		}*/
		
		return listaLugares;
	}
}

