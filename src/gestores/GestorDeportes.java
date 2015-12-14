package gestores;

import DAO.DeporteDAO;
import DTO.DeporteDTO;
import DTO.ListaDeportesDTO;

public class GestorDeportes {
	private static ListaDeportesDTO listaDeportes;
	private static DeporteDTO deporteD;

	public static ListaDeportesDTO getListadoDeportes(){
		listaDeportes = DeporteDAO.getListado();
					
		return listaDeportes;
	}
	
	public static DeporteDTO getDeporteDTO(String deporte){
		deporteD = DeporteDAO.getDeporteDTO(deporte);
				
		return deporteD;
	}
}
