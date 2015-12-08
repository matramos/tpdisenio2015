package gestores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import DAO.CompetenciaDAO;
import DAO.DeporteDAO;
import DAO.EncuentroDAO;
import DAO.ParticipanteDAO;
import DAO.RondaDAO;
import DAO.UsuarioDAO;
import DAO.LugarDAO;
import DTO.CompetenciaDTO;
import DTO.DisponibilidadDTO;
import DTO.ListaDeportesDTO;
import DTO.ListaParticipantesDTO;
import DTO.ParticipanteDTO;
import capanegocios.Competencia;
import capanegocios.Deporte;
import capanegocios.Disponibilidad;
import capanegocios.Encuentro;
import capanegocios.Estado;
import capanegocios.FormaPuntuacion;
import capanegocios.Lugar;
import capanegocios.Modalidad;
import capanegocios.Participante;
import capanegocios.Ronda;
import capanegocios.SeRealizaEn;
import capanegocios.Usuario;
public class GestorCompetencias {
	
	private static Competencia competencia;
	private static Ronda ronda;
	private static Encuentro encuentro;
	
	public static long crearCompetencia(CompetenciaDTO competenciaDTO, int idformaPrim, String deportePrim, long idmodalidadPrim, long idUsuario){
		long idGenerado=-1;
		Competencia competencia = new Competencia();
		competencia.CompetenciaDTO(competenciaDTO);
		Deporte deporte = DeporteDAO.getDeporte(deportePrim);
		
		competencia.setDeporte(deporte);
		FormaPuntuacion forma = CompetenciaDAO.getFormaPuntuacion(idformaPrim);
		competencia.setPuntuacion(forma);
		Modalidad modalidad = CompetenciaDAO.getModalidad(idmodalidadPrim);
		competencia.setModalidad(modalidad);
		competencia.setResultado_final(competenciaDTO.getResultado_final());
		
		Usuario usuario = UsuarioDAO.getUsuario(idUsuario);
		competencia.setUsuario(usuario);
		for(DisponibilidadDTO object: competenciaDTO.getLugares()){
			Disponibilidad dispo = new Disponibilidad();
			dispo.setDisponibilidad(object.getDisponibilidad());
			dispo.setLugar(LugarDAO.getLugar(object.getLugar()));
			competencia.addLugar(dispo);
		}
		/*for(DisponibilidadDTO object: competenciaDTO.getDisponibilidades()){
			Lugar lugar = LugarDAO.getLugar(object.getLugar());
			Disponibilidad disponibilidad = new Disponibilidad();
			disponibilidad.setLugar(lugar);
			disponibilidad.setDisponibilidad(object.getDisponibilidad());
			competencia.addDisponibilidad(disponibilidad);
			
		}*/
		Estado estado = new Estado();
		estado.setId(1);
		estado.setNombre("Creada");
		competencia.setEstado(estado);
		
		
		idGenerado = CompetenciaDAO.agregarCompetencia(competencia);
		return idGenerado;
		
	}
	
	public static ArrayList<CompetenciaDTO> buscarCompetencias(String nombreComp, int deporteID, int modalidadID, int estadoID, long usuarioID) {
			ArrayList<CompetenciaDTO> competenciasQueRetornan = new ArrayList<>(); 
		ArrayList<Competencia> competenciasEncontradas = CompetenciaDAO.buscarCompetencias(nombreComp, deporteID, modalidadID, estadoID,usuarioID);

		for(Competencia comp : competenciasEncontradas){
			//System.out.println(comp.getDeporte().getNombre());
			CompetenciaDTO compDTO = new CompetenciaDTO(comp);
			competenciasQueRetornan.add(compDTO);
		}
		return competenciasQueRetornan;
	}

	
	/*public static ArrayList<CompetenciaDTO> buscarCompetencias(String string, int i, int j, int k) {
		
		return null;
	}*/

public static CompetenciaDTO getCompetencia(long id_competencia){
	
	competencia = CompetenciaDAO.getCompetencia(id_competencia);

	CompetenciaDTO competencia2 = new CompetenciaDTO(competencia);
	
	
	
	return competencia2;
}

public static long agregarParticipante(ParticipanteDTO participanteDTO,long id_competencia){
	
	System.out.println(participanteDTO.getId_participante());
	System.out.println(participanteDTO.getEmail());
	
	competencia = CompetenciaDAO.getCompetencia(id_competencia);
	long res = 0;
	Participante participante = new Participante();
	
	participante.ParticipanteDTO(participanteDTO);
	
	competencia.agregarParticipante(participante);
	Estado estado = new Estado();
	estado.setId(1);
	estado.setNombre("Creada");
	competencia.setEstado(estado);
	
	
	res = CompetenciaDAO.agregarCompetencia(competencia);
	return  res;
}


public static ListaParticipantesDTO mostrarTabla(CompetenciaDTO competencia2) {
	ListaParticipantesDTO participantes = new ListaParticipantesDTO();
	for(ParticipanteDTO part : competencia2.getParticipantes()){
		participantes.addParticipante(part);
	}
	participantes.ordenar();
	return participantes;
}




public static void generarFixture(long id_competencia) {
	competencia = buscarCompetencia(id_competencia);
	if(competencia.getEstado().getNombre().equals("planificada")) competencia.borrarFixture();
	GestorFixture.generarFixture(competencia);
	
	CompetenciaDAO.agregarCompetencia(competencia);

}

public static Competencia buscarCompetencia(long id_competencia) {
	
	System.out.println("entro a buscar competencia");
	competencia = CompetenciaDAO.getCompetencia(id_competencia);
	return competencia;
}

public static Ronda buscarRonda(long id_ronda) {
	ronda = RondaDAO.getRonda(id_ronda);
	return ronda;
}

public static void actualizar(Competencia competencia) {
	CompetenciaDAO.actualizarCompetencia(competencia); 
}

public static Encuentro buscarEncuentro(long id_encuentro) {
	System.out.println("entro a bucar el encuentro");
	encuentro = EncuentroDAO.getEncuentro(id_encuentro);
	return encuentro;
}



}