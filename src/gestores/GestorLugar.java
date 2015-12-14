package gestores;

import DAO.LugarDAO;
import DTO.ListaLugaresDTO;

public class GestorLugar {
	
	private static ListaLugaresDTO listaLugares;
	
	public static ListaLugaresDTO getListadoLugares(){
		//guardo la lista de lugares dto al DAO y la retorno
		listaLugares = LugarDAO.getListado();
		
		return listaLugares;
	}
	
	public static ListaLugaresDTO getListadoLugares(long idDeporte){
		//guardo la lista de lugares dto al DAO y la retorno
		listaLugares = LugarDAO.getListado(idDeporte);
		
		return listaLugares;
	}
}

