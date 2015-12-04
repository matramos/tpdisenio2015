package DTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListaParticipantesDTO {
	public List<ParticipanteDTO> participantes = new ArrayList<ParticipanteDTO>();

	public List<ParticipanteDTO> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<ParticipanteDTO> participantes) {
		this.participantes = participantes;
	}
	
	public void addParticipante(ParticipanteDTO participante){
		this.participantes.add(participante);
	}
	public void ordenar(){
		Collections.sort(this.participantes, new ComparadorParticipante());
	}
	
	public class ComparadorParticipante implements Comparator<ParticipanteDTO> {
	    public int compare(ParticipanteDTO p1, ParticipanteDTO p2) {
	        int value1 = compararEnteros(p1.puntaje,p2.puntaje);
	        if (value1 == 0) {
	            int value2 = compararEnteros(p1.tantosDif,p2.tantosDif);
	            if (value2 == 0) {
	                return compararEnteros(p1.tantosFav,p2.tantosFav);
	            } else {
	                return value2;
	        }
	    }
			return value1;
	}}
	
	public int compararEnteros(int a, int b){
		int retorno=0;
		if(a==b)
			return 0;
		else if (a>b)
			retorno=-1;
		else if(b>a)
			retorno= 1;
		return retorno;
	}
	}


