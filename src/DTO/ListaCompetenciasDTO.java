package DTO;

import java.util.ArrayList;
import java.util.List;

public class ListaCompetenciasDTO {
	public List<CompetenciaDTO> competencias = new ArrayList();

	public List<CompetenciaDTO> getCompetencias() {
		return competencias;
	}

	public void setCompetencias(List<CompetenciaDTO> competencias) {
		this.competencias = competencias;
	}
	
	public void addCompetencia(CompetenciaDTO competencia){
		this.competencias.add(competencia);
	}

}
