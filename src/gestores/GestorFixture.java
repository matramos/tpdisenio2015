package gestores;

import DTO.CompetenciaDTO;
import DTO.EncuentroDTO;
import DTO.ListaEncuentrosDTO;
import DTO.ListaRondasDTO;
import DTO.ModalidadDTO;
import DTO.ParticipanteDTO;
import DTO.RegistroEncuentroDTO;
import DTO.RondaDTO;
import DTO.SetDTO;

import java.util.ArrayList;
import java.util.List;
import capanegocios.Competencia;
import capanegocios.Encuentro;
import capanegocios.ListaEncuentros;
import capanegocios.ListaRondas;
import capanegocios.Modalidad;
import capanegocios.Participante;
import capanegocios.RegistroEncuentro;
import capanegocios.RegistroSet;
import capanegocios.Ronda;
import capanegocios.Set;

public class GestorFixture{
	
	private Competencia competencia;
	private Encuentro encuentro2;
	private ListaRondas listaRondas;
	private Ronda ronda;
	private ListaEncuentros listaEncuentros;
	private Encuentro   encuentro;
	
	private Participante participante1;
	private Participante participante2;
	private Modalidad modalidad;
	private RegistroEncuentro registro;
	
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
				//falta lo de lugar aca
				Encuentro encuentrito = new Encuentro(participantes.get(e), participantes.get(participantes.size()-e-1));
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
	
	
	public EncuentroDTO GestionarResultado(long id_competencia,long id_ronda,long id_encuentro){
		EncuentroDTO encuentroDTO;
		System.out.println("entro en gestionar resultado");
		competencia= GestorCompetencias.buscarCompetencia(id_competencia);
		System.out.println(competencia.getNombre());
		//encuentro2= GestorCompetencias.buscarEncuentro(id_encuentro); //esto donde esta? en el diagrama? lo saq de gestor comp, esta  mal lo q hago
		// el encuentro sale de la misma ronda intanciada. ya fue dejame q a la noche lo haga todo de nuevo. no a ver
		
		ronda = competencia.getRonda(id_ronda);
		encuentro = ronda.getEncuentro(id_encuentro);
		participante1=encuentro.getJugador1();
		participante2=encuentro.getJugador2();
		//
		encuentroDTO=new EncuentroDTO(encuentro);
		int cantSets=competencia.getCantidad_sets();	
		System.out.println(competencia.getCantidad_sets());
		//
		while(cantSets!=0){
			SetDTO set1 = new SetDTO();//esto se crea vacio, fijate que hay que hacerlo con el set del encuentro, me estaba dando cuenta recien
			// lo creo vacio al pedo, tendrai q tener los datos del set de encuentro
			encuentroDTO.addSet(set1);
			cantSets--;
		}
		return encuentroDTO;
	}

	public void cargarResultado(long id_competencia,long id_ronda,long id_encuentro,EncuentroDTO encuentro) {
		
		competencia= GestorCompetencias.buscarCompetencia(id_competencia);
		encuentro2= GestorCompetencias.buscarEncuentro(id_encuentro);
		modalidad=competencia.getModalidad();
		
		if(modalidad.getEliminatoriasimple()== true ^ modalidad.getEliminatoriadoble()== true){
			
			//seteo el encuentro con los datos nuevos ingresados por el usuario
			encuentro2.ActualizarEncuentro(encuentro);
			
			//actualizo la competencia con el nuevo encuentro actualizado
			competencia.ActualizarEncuentro(id_ronda,encuentro2);
			
			//creo los registro de set, del caso de uso en particular
			List<RegistroSet> registroSets = new ArrayList<RegistroSet>();
			for(Set set : encuentro2.getSets()){
				RegistroSet registroS = new RegistroSet(set);
				registroSets.add(registroS);
			}
			
			//creo el registro de encuentro
			RegistroEncuentro registroEncuentro = new RegistroEncuentro(encuentro2,registroSets);
			
			//consideracion si la ronda no esta comenzada
			ronda=GestorCompetencias.buscarRonda(id_ronda);
			if(ronda.isComenzada()==false)
				ronda.setComenzada(true);
			
			//consideracion del ultimo encuentro de la ronda fue cargada
			int cantEncuentros = ronda.getEncuentros().size();
			if(ronda.getEncuentros().get(cantEncuentros-1).isEstado_encuentro()==true)
				ronda.setFinalizado(true);
			
			//actualizar datos de encuentro en los participantes
			
			Participante participanteP1 = encuentro2.getJugador1();
			Participante participanteP2 = encuentro2.getJugador2();
			if(encuentro2.isEmpate()==true){
				participanteP1.setPartidosEmpatados(participanteP1.getPartidosEmpatados()+1);
				participanteP2.setPartidosEmpatados(participanteP2.getPartidosEmpatados()+1);
			}
			if(encuentro2.getGanador().getId_participante()==participanteP1.getId_participante()){
				participanteP1.setPartidosGanados(participanteP1.getPartidosGanados()+1);
				participanteP2.setPartidosPerdidos(participanteP2.getPartidosPerdidos()+1);
			}
			else{
				participanteP2.setPartidosGanados(participanteP2.getPartidosGanados()+1);
				participanteP1.setPartidosPerdidos(participanteP1.getPartidosPerdidos()+1);
			}
			for(Set set : encuentro2.getSets()){
				participanteP1.setTantosFav(participanteP1.getTantosFav()+set.getPuntajep1());
				participanteP2.setTantosFav(participanteP2.getTantosFav()+set.getPuntajep2());
				participanteP1.setTantosCont(participanteP1.getTantosCont()+set.getPuntajep2());
				participanteP2.setTantosCont(participanteP2.getTantosCont()+set.getPuntajep1());
				participanteP1.setTantosDif(participanteP1.getTantosDif()+(set.getPuntajep1()-set.getPuntajep2()));
				participanteP2.setTantosDif(participanteP2.getTantosDif()+(set.getPuntajep2()-set.getPuntajep1()));
			}
		}
		if(competencia.getEstado().getNombre().equals("Planificada"))
			competencia.getEstado().setNombre("En Disputa");
		else{
			int cantEncuentros = ronda.getEncuentros().size();
			if(ronda.getEncuentros().get(cantEncuentros-1).isEstado_encuentro()==true)
				competencia.getEstado().setNombre("Finalizada");
		}
		GestorCompetencias.actualizar(competencia);
	}

}
