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

import javax.swing.JOptionPane;

import capanegocios.Competencia;
import capanegocios.Disponibilidad;
import capanegocios.Encuentro;
import capanegocios.ListaEncuentros;
import capanegocios.ListaRondas;
import capanegocios.Lugar;
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
		List<Disponibilidad> lugares = new ArrayList<Disponibilidad>();
		
		//copiamos la lista de Disponibilidades para no modificar la original
		for(Disponibilidad dispo : competencia.getLugares()){
			Disponibilidad copia = new Disponibilidad(dispo);
			lugares.add(copia);
		}
		
		//EN CASO DE TENER UN NUMERO IMPAR DE PARTICIPANTES, CREAMOS ESTE PARTICIPANTE "FANTASMA". VER DESPUES COMO ESTO AFECTA AL cu18 Y cu21
		if (!(participantes.size()%2 == 0)){
			Participante fantasma = new Participante("ghost"); 
			participantes.add(fantasma);
		}
		
		for(int r=0; r<(participantes.size()-1);r++){
			Ronda rondita = new Ronda();
			rondita.setNumeroRonda(r);
			rondita.setComenzada(false);
			rondita.setFinalizado(false);
			
			for(int e=0; e<(participantes.size()/2);e++){
				
				//getLugar lo hago aca porque no tengo idea como hacerlo en competencia.
				int l = 0;
				while(lugares.get(l).getDisponibilidad() == 0){
					l++;
				}
				Lugar lugarcito = lugares.get(l).getLugar();
				lugares.get(l).setDisponibilidad(lugares.get(l).getDisponibilidad()-1);
				
				Encuentro encuentrito = new Encuentro(participantes.get(e), participantes.get(participantes.size()-e-1), lugarcito);
				for(int s=0; s <= competencia.getCantidad_sets(); s++){
					Set setito = new Set();
					encuentrito.addSet(setito);
				}
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
		System.out.println("ENTRO A GESTIONAR RESULTADO");
		competencia= GestorCompetencias.buscarCompetencia(id_competencia);
		System.out.println(competencia.getNombre());
		ronda = competencia.getRonda(id_ronda);
		encuentro = ronda.getEncuentro(id_encuentro);
		//participante1=encuentro.getJugador1();
		//participante2=encuentro.getJugador2();
		//
		encuentroDTO=new EncuentroDTO(encuentro);
		//int cantSets=competencia.getCantidad_sets();	
		//System.out.println(competencia.getCantidad_sets());
		/*
		while(cantSets!=0){
			SetDTO set1 = new SetDTO();
			encuentroDTO.addSet(set1);
			cantSets--;
		}*/
		return encuentroDTO;
	}

	public boolean cargarResultado(long id_competencia,long id_ronda,long id_encuentro,EncuentroDTO encuentro) {
		
		competencia= GestorCompetencias.buscarCompetencia(id_competencia);
		ronda = competencia.getRonda(id_ronda);
		encuentro2 = ronda.getEncuentro(id_encuentro);
		modalidad=competencia.getModalidad();

		if(modalidad.isLiga()==true){
			
			encuentro2.ActualizarEncuentro(encuentro);
			
			
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
			
			//encuentro2.agregarRegistros(registroEncuentro);
			
			// CONSIDERS DEL DIAGRAMA DEL CASO DE USO
			//consideracion si la ronda no esta comenzada
			ronda = competencia.getRonda(id_ronda);
			if(ronda.isComenzada()==false)
				ronda.setComenzada(true);
			
			//consideracion del ultimo encuentro de la ronda fue cargada
			int cantEncuentros = ronda.getEncuentros().size();
			if(ronda.getEncuentros().get(cantEncuentros-1).isEstado_encuentro()==true)
				ronda.setFinalizado(true);
			
			if(competencia.getEstado().getNombre().equals("Planificada"))
				competencia.getEstado().setNombre("En Disputa");
			else{
				cantEncuentros = ronda.getEncuentros().size();
				if(ronda.getEncuentros().get(cantEncuentros-1).isEstado_encuentro()==true)
					competencia.getEstado().setNombre("Finalizada");
			}
			//actualizo la competencia con el nuevo encuentro actualizado
			
			System.out.println("TODOS LOS DATOS PARA EL CAMPEON DE LOS CAMPEONES, PARA TROV");
			System.out.println("LOS ID INVOLUCRADOS DE COMPETENCIA , RONDA , ENCUENTRO");
			System.out.println(competencia.getId_competencia());
			System.out.println(ronda.getId_ronda());
			System.out.println(encuentro2.getId_encuentro());
			System.out.println("TODOS LOS SET DEL ENCUENTRO SELECCIONADO, CON SU ID Y PUNTAJES DE LOS PARTICIPANTES");
			for(Set set : encuentro2.getSets()){
				System.out.println(set.getId_set());
				System.out.println(set.getPuntajep1());
				System.out.println(set.getPuntajep2());
			}
			System.out.println("REGISTRO DEL ENCUENTRO GESTIONADO");
			System.out.println("POR DESGRACIA NO PUEDO AGREGAR EL REGISTRO A LA LISTA registros DEL ENCUENTRO POR ESO SE IMPRIME LO VIEJO PERO ANDAN LAS ASIGANCIONES");
			System.out.println(registroEncuentro.getId_registro());
			System.out.println(registroEncuentro.getEncuentro().getId_encuentro());
			System.out.println(registroEncuentro.getId_registro());
			System.out.println(registroEncuentro.getPuntajep1());
			System.out.println(registroEncuentro.getPuntajep2());
			System.out.println(registroEncuentro.isEstado_participante1());
			System.out.println(registroEncuentro.isEstado_participante2());
			System.out.println("REGISTRO DE SETS DEL REGISTRO ENCUENTRO");
			for(RegistroSet regSet : registroEncuentro.getRegistroSets()){
				System.out.println(regSet.getId_registro_set());
				System.out.println(regSet.getPuntajeP1());
				System.out.println(regSet.getPuntajeP2());
			}
			
			
			competencia.ActualizarEncuentro(id_ronda,encuentro2);
			competencia.actualizarParticipantes(encuentro2.getJugador1(),encuentro2.getJugador2());
			GestorCompetencias.actualizar(competencia);
			
			return true;
		}
		else{
			JOptionPane.showMessageDialog(null, "No se puede gestionar el encuentro, la modalidad es Eliminacion Simple o Doble");
			/*Cu008 ventana = new Cu008(idGenerado,id_usuario);
			ventana.setVisible(true);*/
			//dispose();
			return false;
		}
		
	}

}
