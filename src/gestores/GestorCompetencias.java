package gestores;

import java.util.ArrayList;
import DAO.CompetenciaDAO;
import DAO.DeporteDAO;
import DAO.EncuentroDAO;
import DAO.RondaDAO;
import DAO.UsuarioDAO;
import DAO.LugarDAO;
import DTO.CompetenciaDTO;
import DTO.DisponibilidadDTO;
import DTO.EstadoDTO;
import DTO.FormaPuntuacionDTO;
import DTO.InfoCompetenciaDTO;
import DTO.ListaParticipantesDTO;
import DTO.ModalidadDTO;
import DTO.ParticipanteDTO;
import capanegocios.Competencia;
import capanegocios.Deporte;
import capanegocios.Disponibilidad;
import capanegocios.Encuentro;
import capanegocios.Estado;
import capanegocios.FormaPuntuacion;
import capanegocios.Modalidad;
import capanegocios.Participante;
import capanegocios.Ronda;
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
		
		Estado creada = CompetenciaDAO.getEstado(1);
		//estado.setId(1);
		//estado.setNombre("creada");
		competencia.setEstado(creada);
		
		
		idGenerado = CompetenciaDAO.agregarCompetencia(competencia);
		return idGenerado;
		
	}
	
	public static ArrayList<CompetenciaDTO> buscarCompetencias(String nombreComp, int deporteID, int modalidadID, int estadoID, long usuarioID) {
			ArrayList<CompetenciaDTO> competenciasQueRetornan = new ArrayList<>(); 
		ArrayList<Competencia> competenciasEncontradas = CompetenciaDAO.buscarCompetencias(nombreComp, deporteID, modalidadID, estadoID,usuarioID);

		for(Competencia comp : competenciasEncontradas){
			CompetenciaDTO compDTO = new CompetenciaDTO(comp);
			competenciasQueRetornan.add(compDTO);
		}
		return competenciasQueRetornan;
	}


public static CompetenciaDTO getCompetencia(long id_competencia){
	
	competencia = CompetenciaDAO.getCompetencia(id_competencia);

	CompetenciaDTO competencia2 = new CompetenciaDTO(competencia);
	
	return competencia2;
}

public static long agregarParticipante(ParticipanteDTO participanteDTO,long id_competencia){
		
	competencia = CompetenciaDAO.getCompetencia(id_competencia);
	long res = 0;
	Participante participante = new Participante();
	
	participante.ParticipanteDTO(participanteDTO);
	
	competencia.agregarParticipante(participante);
	
	if(competencia.getEstado().getId()==2){
	
		competencia.borrarFixture();
		Estado creada = CompetenciaDAO.getEstado(1);
		competencia.setEstado(creada);
	}
	
	
	//Estado estado = new Estado();
	//estado.setId(1);
	//estado.setNombre("creada");
	//competencia.setEstado(estado);
	
	
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
	
	//Si la Competencia esta planificada, le borramos el fixture del objeto y de la BD
	if(competencia.getEstado().getId() == 2){
		competencia.borrarFixture();
		CompetenciaDAO.actualizarCompetencia(competencia);
	}
	
	GestorFixture.generarFixture(competencia);
	
	//cambiamos el estado de la competencia a "planificada"
	Estado plani = CompetenciaDAO.getEstado(2);
	competencia.setEstado(plani);
	
	CompetenciaDAO.actualizarCompetencia(competencia);

}

public static Competencia buscarCompetencia(long id_competencia) {
	
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
	encuentro = EncuentroDAO.getEncuentro(id_encuentro);
	return encuentro;
}

public static InfoCompetenciaDTO getInfoCompetencia(long id_competencia) {
	Competencia competencia = CompetenciaDAO.getCompetencia(id_competencia);
	
	InfoCompetenciaDTO info = new InfoCompetenciaDTO();
	ModalidadDTO modalidad = new ModalidadDTO(competencia.getModalidad());
	FormaPuntuacionDTO forma = new FormaPuntuacionDTO(competencia.getPuntuacion());
	EstadoDTO estado = new EstadoDTO(competencia.getEstado());
	info.setModalidad(modalidad);
	info.setPuntuacion(forma);
	info.setEstado(estado);
	info.setPermite_empates(competencia.isPermite_empates());
	info.setPuntos_empate(competencia.getPuntos_empate());
	info.setPuntos_ganador(competencia.getPuntos_ganador());
	info.setPuntos_presentarse(competencia.getPuntos_presentarse());
	info.setResultado_final(competencia.getResultado_final());
	info.setCantidad_sets(competencia.getCantidad_sets());
	
	return info;
}

public static boolean validarNombre(String text) {
	boolean retorno=false;
	retorno = CompetenciaDAO.validarNombre(text);
	return retorno;
}

public static boolean validarMail(String text, long id_competencia) {
	boolean retorno=true;
	Competencia competencia = CompetenciaDAO.getCompetencia(id_competencia);
	for(Participante part: competencia.getParticipantes()){
		if(part.getEmail().equals(text)){
			retorno=false;
		}
	}
	
	return retorno;
}

public static boolean validarNombreP(String text, long id_competencia) {
	boolean retorno=true;
	Competencia competencia = CompetenciaDAO.getCompetencia(id_competencia);
	for(Participante part: competencia.getParticipantes()){
		if(part.getNombre().equals(text)){
			retorno=false;
		}
	}
	
	return retorno;
}

public static Estado getEstado(long id_estado){
	Estado est = CompetenciaDAO.getEstado(id_estado);
	return est;
}

}