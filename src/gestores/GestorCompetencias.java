package gestores;

import java.util.ArrayList;

import DAO.*;
import DTO.*;
import capanegocios.*;


public class GestorCompetencias {
	
	public static void crearCompetencia(CompetenciaDTO competenciaDTO){
		Competencia competencia = new Competencia(competenciaDTO);
		Deporte deporte = DeporteDAO.getDeporte(competenciaDTO.getDeporte());
		competencia.setDeporte(deporte);
		FormaPuntuacion forma = CompetenciaDAO.getFormaPuntuacion(competenciaDTO.getPuntuacion());
		competencia.setPuntuacion(forma);
		Modalidad modalidad = CompteneciaDAO.getModalidad(competenciaDTO.getModalidad());
		competencia.setModalidad(modalidad);
		
		for(String object: competenciaDTO.getLugares()){
			Lugar lugar = LugarDAO.getLugar(object);
			Disponibilidad disponibilidad = new Disponibilidad(competenciaDTO.getDisponibilidad());
			competencia.setDisponibilidad(disponibilidad);
			
		}
		Estado estado = new Estado();
		estado.setId_estado(1);
		estado.setNombre("Creada");
		competencia.setEstado(estado);
		
		CompetenciaDAO.agregarCompetencia(competencia);
		
	}
	
	public static ArrayList<CompetenciaDTO> buscarCompetencias(String string, int i, int j, int k) {
		
		return null;
	}
}
