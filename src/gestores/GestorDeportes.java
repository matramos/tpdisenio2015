package gestores;

import java.util.List;

import DAO.DeporteDAO;

import DTO.ListaDeportesDTO;
import capanegocios.Deporte;
import capanegocios.Lugar;

public class GestorDeportes {
	private static ListaDeportesDTO listaDeportes;

	public static ListaDeportesDTO getListadoDeportes(){
		listaDeportes = DeporteDAO.getListado();
		
		
		/*Iterator iter = listaLugares.iterator();
		while (iter.hasNext()){
			Object l = iter.next();
			lugares.addLugar( l);
		}*/
		
		return listaDeportes;
	}
	
	public static DeporteDTO getDeporteDTO(String deporte){
		listaDeportes = DeporteDAO.getListado();
		
		
		/*Iterator iter = listaLugares.iterator();
		while (iter.hasNext()){
			Object l = iter.next();
			lugares.addLugar( l);
		}*/
		
		return listaDeportes;
	}
}
