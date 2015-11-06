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
		//guardo la lista de lugares dto al DAO y la retorno
		listaLugares = LugarDAO.getListado();
		
		
		/*Iterator iter = listaLugares.iterator();
		while (iter.hasNext()){
			Object l = iter.next();
			lugares.addLugar( l);
		}*/
		
		return listaLugares;
	}
	public static ListaLugaresDTO getListadoLugares(long idDeporte){
		//guardo la lista de lugares dto al DAO y la retorno
		listaLugares = LugarDAO.getListado(idDeporte);
		
		
		/*Iterator iter = listaLugares.iterator();
		while (iter.hasNext()){
			Object l = iter.next();
			lugares.addLugar( l);
		}*/
		
		return listaLugares;
	}
}

