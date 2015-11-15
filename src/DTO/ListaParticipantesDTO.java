package DTO;

import java.util.ArrayList;
import java.util.List;

public class ListaParticipantesDTO {
	public List<ParticipanteDTO> participantes = new ArrayList();

	public List<ParticipanteDTO> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<ParticipanteDTO> participantes) {
		this.participantes = participantes;
	}
	
	public void addParticipante(ParticipanteDTO participante){
		this.participantes.add(participante);
	}

}