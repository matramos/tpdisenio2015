package gestores;

import DTO.EncuentroDTO;
import java.util.ArrayList;
import java.util.List;

import capanegocios.Competencia;
import capanegocios.Disponibilidad;
import capanegocios.Encuentro;
import capanegocios.Estado;
import capanegocios.Lugar;
import capanegocios.Modalidad;
import capanegocios.Participante;
import capanegocios.RegistroEncuentro;
import capanegocios.RegistroSet;
import capanegocios.Ronda;
import capanegocios.Set;

public class GestorFixture{
	
	public static void generarFixture(Competencia competencia) {
		List<Participante> participantes = competencia.getParticipantes();
		List<Disponibilidad> lugares = new ArrayList<Disponibilidad>();
		
		
		
		//EN CASO DE TENER UN NUMERO IMPAR DE PARTICIPANTES, CREAMOS ESTE PARTICIPANTE "FANTASMA". VER DESPUES COMO ESTO AFECTA AL cu18 Y cu21
		boolean flagF = false;
		Participante fantasma = new Participante("ghost");
		if (!(participantes.size()%2 == 0)){
			participantes.add(fantasma);
			flagF = true;
		}
		
		for(int r=0; r<(participantes.size()-1);r++){
			Ronda rondita = new Ronda();
			rondita.setNumeroRonda(r);
			rondita.setComenzada(false);
			rondita.setFinalizado(false);
			
			//copiamos la lista de Disponibilidades para no modificar la original
			System.out.println(competencia.getLugares().size());
			for(Disponibilidad dispo : competencia.getLugares()){
				Disponibilidad copia = new Disponibilidad(dispo);
				lugares.add(copia);
			}
			int l = 0;
			
			for(int e=0; e<(participantes.size()/2);e++){
				
						
				//SI ALGUNO DE LOS PARTICIPANTES ES GHOST NO SE GENERA EL ENCUENTRO
				if(!participantes.get(e).getNombre().equals("ghost") 
						&& !participantes.get(participantes.size()-e-1).getNombre().equals("ghost")){
					
					//getLugar lo hago aca porque no tengo idea como hacerlo en competencia.
					if(lugares.get(l).getDisponibilidad() == 0){
						l++;
					}
					
					Lugar lugarcito = lugares.get(l).getLugar();
					
					
					lugares.get(l).setDisponibilidad(lugares.get(l).getDisponibilidad()-1);
					
					Encuentro encuentrito = new Encuentro(participantes.get(e), participantes.get(participantes.size()-e-1), lugarcito);
					for(int s=0; s < competencia.getCantidad_sets(); s++){
						Set setito = new Set();
						encuentrito.addSet(setito);
					}
					rondita.add(encuentrito);
				}
			}
			competencia.addRonda(rondita);
			
			
			//reordenamiento de participantes
			Participante pivot = participantes.get(0); //Sacamos el participante pivot, siempre es el 1
			participantes.remove(0);
			Participante ultimo = participantes.get(participantes.size()-1); //sacamos el último participante
			participantes.remove(participantes.size()-1);
			participantes.add(0, ultimo); //Lo ponemos en la posicion 1
			participantes.add(0, pivot);  //El participante 1, siempre va a estar en la posicion 0
			
			lugares.clear();
		}
		
		if(flagF){
			participantes.remove(fantasma);
		}

	}
	
	
	public static EncuentroDTO GestionarResultado(long id_competencia,long id_ronda,long id_encuentro){
		EncuentroDTO encuentroDTO;
		Competencia competencia;
		Ronda ronda;
		Encuentro encuentro;
		
		competencia= GestorCompetencias.buscarCompetencia(id_competencia);
		
		ronda = competencia.getRonda(id_ronda);
		
		encuentro = ronda.getEncuentro(id_encuentro);
		
		encuentroDTO=new EncuentroDTO(encuentro);

		return encuentroDTO;
	}

	public static void cargarResultado(long id_competencia,long id_ronda,long id_encuentro,EncuentroDTO encuentro) {
		Competencia competencia;
		Ronda ronda;
		Encuentro encuentro2;
		Modalidad modalidad;
		competencia= GestorCompetencias.buscarCompetencia(id_competencia);
		ronda = competencia.getRonda(id_ronda);
		encuentro2 = ronda.getEncuentro(id_encuentro);

		
		modalidad=competencia.getModalidad();
		

		if(modalidad.isLiga()==true){
			
			encuentro2.ActualizarEncuentro(encuentro);
			encuentro2.setResultadoReg(true);
			

			
			
			//creo el registro de encuentro
			RegistroEncuentro registroEncuentro = new RegistroEncuentro(encuentro2);
			
			
			//creo los registro de set, del caso de uso en particular
			List<RegistroSet> registroSets = new ArrayList<RegistroSet>();
			for(Set set : encuentro2.getSets()){
				RegistroSet registroS = new RegistroSet(set);
				registroSets.add(registroS);
			}
			registroEncuentro.setRegistroSets(registroSets);
			
			//actualizo el encuentro con el nuevo registro
			
			encuentro2.agregarRegistros(registroEncuentro);
			
			//le cargo el encuentro ahora, por las dudas			
			competencia.ActualizarEncuentro(id_ronda,encuentro2);
			
			// CONSIDERS DEL DIAGRAMA DEL CASO DE USO
			//consideracion si la ronda no esta comenzada
			ronda = competencia.getRonda(id_ronda);
			
			if(ronda.isComenzada()==false)
				ronda.setComenzada(true);
			
			//consideracion del ultimo encuentro de la ronda fue cargada
			int cantEncuentros = ronda.getEncuentros().size();
			int cantEncuentrosCargados = 0;
			for (Encuentro encu : ronda.getEncuentros()){
				if(encu.isResultadoReg()) cantEncuentrosCargados++;
			}
			
			if(cantEncuentros == cantEncuentrosCargados)
				ronda.setFinalizado(true);
			
			if(competencia.getEstado().getId() == 2){
				Estado endisputa = GestorCompetencias.getEstado(3);
				competencia.setEstado(endisputa);
			}
			
		
			if(competencia.getRondas().get(competencia.getRondas().size() -1).isFinalizado()){
				Estado finalizada = GestorCompetencias.getEstado(4);
				competencia.setEstado(finalizada);
			}
			//actualizo la competencia con el nuevo encuentro actualizado
			
			
			competencia.actualizarParticipantes(encuentro2.getJugador1(),encuentro2.getJugador2());
			
			GestorCompetencias.actualizar(competencia);
		}
		else{
			//"No se puede gestionar el encuentro, la modalidad es Eliminacion Simple o Doble"
			
			
		}
		
	}

}
