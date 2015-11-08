package gestores;

import java.util.List;

import DAO.DeporteDAO;
import DTO.DeporteDTO;
import DTO.ListaDeportesDTO;
import capanegocios.Deporte;
import capanegocios.Lugar;

public class GestorDeportes {
	private static ListaDeportesDTO listaDeportes;
	private static DeporteDTO deporteD;

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
		deporteD = DeporteDAO.getDeporteDTO(deporte);
		
		
		/*Iterator iter = listaLugares.iterator();
		while (iter.hasNext()){
			Object l = iter.next();
			lugares.addLugar( l);
		}*/
		
		return deporteD;
	}
}
