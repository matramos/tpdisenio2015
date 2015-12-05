package gestores;

import java.util.List;
import capanegocios.Competencia;
import capanegocios.Encuentro;
import capanegocios.Participante;
import capanegocios.Ronda;

public class GestorFixture {
	
	
	public static void generarFixture(Competencia competencia) {
		List<Participante> participantes = competencia.getParticipantes();
		
		//EN CASO DE TENER UN NUMERO IMPAR DE PARTICIPANTES, CREAMOS ESTE PARTICIPANTE "FANTASMA". VER DESPUES COMO ESTO AFECTA AL cu18 Y cu21
		if (!(participantes.size()%2 == 0)){
			Participante fantasma = new Participante("ghost"); 
			participantes.add(fantasma);
		}
		
		for(int r=0; r<(participantes.size()-1);r++){
			Ronda rondita = new Ronda();
			for(int e=0; e<(participantes.size()/2);e++){
				Encuentro encuentrito = new Encuentro(participantes.get(e), participantes.get(participantes.size()-e-1));
				System.out.println(participantes.get(e).getNombre()+"vs"+participantes.get(participantes.size()-e-1).getNombre());
				rondita.add(encuentrito);
			}
			competencia.addRonda(rondita);
			
			
			//reordenamiento de participantes
			Participante pivot = participantes.get(0); //Sacamos el participante pivot, siempre es el 1
			participantes.remove(0);
			Participante ultimo = participantes.get(participantes.size()-1); //sacamos el último participante
			participantes.remove(participantes.size()-1);
			participantes.add(0, ultimo); //Lo ponemos en la posicion 1
			participantes.add(0, pivot);  //El participante 1, siempre va a estar en la posicion 0

			
		}
		
		
		
		
	}

}
