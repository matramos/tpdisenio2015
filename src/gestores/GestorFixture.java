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
import capanegocios.Competencia;
import capanegocios.Encuentro;
import capanegocios.ListaEncuentros;
import capanegocios.ListaRondas;
import capanegocios.Modalidad;
import capanegocios.Participante;
import capanegocios.RegistroEncuentro;
import capanegocios.Ronda;

public class GestorFixture{
	
	private Competencia competencia;
	private ListaRondas listaRondas;
	private Ronda ronda;
	private ListaEncuentros listaEncuentros;
	private EncuentroDTO   encuentro;
	private Participante participante1;
	private Participante participante2;
	private Modalidad modalidad;
	private RegistroEncuentro registro;
	
	public static void generarFixture(Competencia competencia) {
		// TODO Auto-generated method stub
		
	}
	
	
	public EncuentroDTO GestionarResultado(long id_competencia,long id_ronda,long id_encuentro){
		
		
		
		competencia= GestorCompetencias.buscarCompetencia(id_competencia);
		listaRondas=(ListaRondas) competencia.getRondas();
		ronda=listaRondas.buscarRonda(id_ronda);
		listaEncuentros=(ListaEncuentros) ronda.getEncuentros();
		encuentro=new EncuentroDTO(listaEncuentros.buscarEncuentro(id_encuentro));
		participante1=new Participante(encuentro.getJugador1());
		participante2=new Participante(encuentro.getJugador2());
		
		int cantSets=competencia.getCantidad_sets();	
		
		while(cantSets!=0){
			SetDTO set1 = new SetDTO();
			encuentro.addSet(set1);
		}
		return encuentro;
		/*
		modalidad=competencia.getModalidad();
		
		if(modalidad.getEliminatoriasimple()== true ^ modalidad.getEliminatoriadoble()== true){
			
			
			set1.setPuntajep1(Integer.parseInt(txtS1P1.getText()));
			set1.setPuntajep2(Integer.parseInt(txtS1P1.getText()));
			set1.setEncuentro(encuentro);
			
			set2.setPuntajep1(Integer.parseInt(txtS1P1.getText()));
			set2.setPuntajep2(Integer.parseInt(txtS1P1.getText()));
			set2.setEncuentro(encuentro);
			
			set3.setPuntajep1(Integer.parseInt(txtS1P1.getText()));
			set3.setPuntajep2(Integer.parseInt(txtS1P1.getText()));
			set3.setEncuentro(encuentro);
			
			set4.setPuntajep1(Integer.parseInt(txtS1P1.getText()));
			set4.setPuntajep2(Integer.parseInt(txtS1P1.getText()));
			set4.setEncuentro(encuentro);
			
			set5.setPuntajep1(Integer.parseInt(txtS1P1.getText()));
			set5.setPuntajep2(Integer.parseInt(txtS1P1.getText()));
			set5.setEncuentro(encuentro);
			
			set6.setPuntajep1(Integer.parseInt(txtS1P1.getText()));
			set6.setPuntajep2(Integer.parseInt(txtS1P1.getText()));
			set6.setEncuentro(encuentro);
			
			set7.setPuntajep1(Integer.parseInt(txtS1P1.getText()));
			set7.setPuntajep2(Integer.parseInt(txtS1P1.getText()));
			set7.setEncuentro(encuentro);
			
			set8.setPuntajep1(Integer.parseInt(txtS1P1.getText()));
			set8.setPuntajep2(Integer.parseInt(txtS1P1.getText()));
			set8.setEncuentro(encuentro);
			
			set9.setPuntajep1(Integer.parseInt(txtS1P1.getText()));
			set9.setPuntajep2(Integer.parseInt(txtS1P1.getText()));
			set9.setEncuentro(encuentro);
			
			registro = new RegistroEncuentroDTO();
			
		}*/

	}

}
