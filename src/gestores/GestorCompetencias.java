package gestores;

import DAO.CompetenciaDAO;
import DAO.DeporteDAO;
import DTO.CompetenciaDTO;
import capanegocios.Competencia;
import capanegocios.Deporte;
import capanegocios.Estado;
import capanegocios.FormaPuntuacion;
import capanegocios.Modalidad;

public class GestorCompetencias {
	
	public static void crearCompetencia(CompetenciaDTO competenciaDTO, long idformaPrim, String deportePrim, long idmodalidadPrim){
		Competencia competencia = new Competencia();
		competencia.CompetenciaDTO(competenciaDTO);
		Deporte deporte = DeporteDAO.getDeporte(deportePrim);
		competencia.setDeporte(deporte);
		FormaPuntuacion forma = CompetenciaDAO.getFormaPuntuacion(idformaPrim);
		competencia.setPuntuacion(forma);
		Modalidad modalidad = CompetenciaDAO.getModalidad(idmodalidadPrim);
		competencia.setModalidad(modalidad);
		
		/*
		for(String object: competenciaDTO.getLugares()){
			Lugar lugar = LugarDAO.getLugar(object);
			Disponibilidad disponibilidad = new Disponibilidad(competenciaDTO.getDisponibilidad());
			competencia.setDisponibilidad(disponibilidad);
			
		}*/
		Estado estado = new Estado();
		estado.setId_estado(1);
		estado.setNombre("Creada");
		competencia.setEstado(estado);
		
		CompetenciaDAO.agregarCompetencia(competencia);
		
	}
}
