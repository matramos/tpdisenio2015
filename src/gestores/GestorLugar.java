package gestores;

import java.util.Iterator;
import java.util.List;

import DAO.LugarDAO;
import DTO.ListaLugaresDTO;
import capanegocios.Lugar;

public class GestorLugar {
	//private static ListaLugaresDTO lugares;
	private static List<Lugar> listaLugares;
	
	public static ListaLugaresDTO getListadoLugares(){
		listaLugares = LugarDAO.getListado();
		ListaLugaresDTO lugares = new ListaLugaresDTO();
		
		/*Iterator iter = listaLugares.iterator();
		while (iter.hasNext()){
			Object l = iter.next();
			lugares.addLugar( l);
		}*/
		System.out.println(listaLugares.get(0).getNombre());
		lugares.setLugares(listaLugares);
		return lugares;
	}
}

