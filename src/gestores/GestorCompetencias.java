package gestores;

import java.util.ArrayList;

import DAO.CompetenciaDAO;
import DAO.DeporteDAO;
import DAO.LugarDAO;
import DTO.CompetenciaDTO;
import DTO.DisponibilidadDTO;
import DTO.ListaDeportesDTO;
import capanegocios.Competencia;
import capanegocios.Deporte;
import capanegocios.Disponibilidad;
import capanegocios.Estado;
import capanegocios.FormaPuntuacion;
import capanegocios.Lugar;
import capanegocios.Modalidad;

public class GestorCompetencias {
	
	private static Competencia competencia;
	
	public static long crearCompetencia(CompetenciaDTO competenciaDTO, int idformaPrim, String deportePrim, long idmodalidadPrim){
		long idGenerado=-1;
		Competencia competencia = new Competencia();
		competencia.CompetenciaDTO(competenciaDTO);
		Deporte deporte = DeporteDAO.getDeporte(deportePrim);
		
		competencia.setDeporte(deporte);
		FormaPuntuacion forma = CompetenciaDAO.getFormaPuntuacion(idformaPrim);
		competencia.setPuntuacion(forma);
		Modalidad modalidad = CompetenciaDAO.getModalidad(idmodalidadPrim);
		competencia.setModalidad(modalidad);
		
		/*for(DisponibilidadDTO object: competenciaDTO.getDisponibilidades()){
			Lugar lugar = LugarDAO.getLugar(object.getLugar());
			Disponibilidad disponibilidad = new Disponibilidad();
			disponibilidad.setLugar(lugar);
			disponibilidad.setDisponibilidad(object.getDisponibilidad());
			competencia.addDisponibilidad(disponibilidad);
			
		}*/
		Estado estado = new Estado();
		estado.setId_estado(1);
		estado.setNombre("Creada");
		competencia.setEstado(estado);
		
		
		idGenerado = CompetenciaDAO.agregarCompetencia(competencia);
		return idGenerado;
		
	}
	
	public static ArrayList<CompetenciaDTO> buscarCompetencias(String nombreComp, int deporteID, int modalidadID, int estadoID) {
		ArrayList<CompetenciaDTO> competenciasQueRetornan = new ArrayList<>(); 
		ArrayList<Competencia> competenciasEncontradas = CompetenciaDAO.buscarCompetencias(nombreComp, deporteID, modalidadID, estadoID);
		System.out.println(competenciasEncontradas.get(0).getDeporte().getNombre());
		for(Competencia comp : competenciasEncontradas){
			System.out.println(comp.getDeporte().getNombre());
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
