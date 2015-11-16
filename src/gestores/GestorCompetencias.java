package gestores;

import java.util.ArrayList;

import DAO.CompetenciaDAO;
import DAO.DeporteDAO;
import DTO.CompetenciaDTO;
import DTO.ListaDeportesDTO;
import capanegocios.Competencia;
import capanegocios.Deporte;
import capanegocios.Estado;
import capanegocios.FormaPuntuacion;
import capanegocios.Modalidad;

public class GestorCompetencias {
	
	private static Competencia competencia;
	
	public static boolean crearCompetencia(CompetenciaDTO competenciaDTO, int idformaPrim, String deportePrim, long idmodalidadPrim){
		boolean bool = false;
		Competencia competencia = new Competencia();
		competencia.CompetenciaDTO(competenciaDTO);
		Deporte deporte = DeporteDAO.getDeporte(deportePrim);
		
		competencia.setDeporte(deporte);
		FormaPuntuacion forma = CompetenciaDAO.getFormaPuntuacion(idformaPrim);
		competencia.setPuntuacion(forma);
		Modalidad modalidad = CompetenciaDAO.getModalidad(idmodalidadPrim);
		competencia.setModalidad(modalidad);
		
		/*for(String object: competenciaDTO.getLugares()){
			Lugar lugar = LugarDAO.getLugar(object);
			Disponibilidad disponibilidad = new Disponibilidad(competenciaDTO.getDisponibilidad());
			competencia.setDisponibilidad(disponibilidad);
			
		}*/
		Estado estado = new Estado();
		estado.setId_estado(1);
		estado.setNombre("Creada");
		competencia.setEstado(estado);
		competencia.setId_competencia(competenciaDTO.getId_competencia());
		
		bool = CompetenciaDAO.agregarCompetencia(competencia);
		return  bool;
		
	}
	
	public static ArrayList<CompetenciaDTO> buscarCompetencias(String nombreComp, int deporteID, int modalidadID, int estadoID) {
		ArrayList<CompetenciaDTO> competenciasQueRetornan = new ArrayList<>(); 
		ArrayList<Competencia> competenciasEncontradas = CompetenciaDAO.buscarCompetencias(nombreComp, deporteID, modalidadID, estadoID);
		for(Competencia comp : competenciasEncontradas){
			CompetenciaDTO compDTO = new CompetenciaDTO(comp);
			competenciasQueRetornan.add(compDTO);
		}
		return competenciasQueRetornan;
	}

	
	/*public static ArrayList<CompetenciaDTO> buscarCompetencias(String string, int i, int j, int k) {
		
		return null;
	}*/

public static CompetenciaDTO getCompetencia(long id_competencia){
	
	competencia = CompetenciaDAO.getCompetencia(id_competencia);
	CompetenciaDTO competencia2 = new CompetenciaDTO(competencia);
	
	
	/*Iterator iter = listaLugares.iterator();
	while (iter.hasNext()){
		Object l = iter.next();
		lugares.addLugar( l);
	}*/
	
	return competencia2;
}
}
