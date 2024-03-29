package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import DTO.CompetenciaDTO;
import DTO.DeporteDTO;
import DTO.EstadoDTO;
import DTO.ListaCompetenciasDTO;
import DTO.ListaDeportesDTO;
import DTO.ListaLugaresDTO;
import DTO.LugarDTO;
import DTO.ModalidadDTO;
import Inicio.CrearSesion;
import capanegocios.Competencia;
import capanegocios.Deporte;
import capanegocios.Estado;
import capanegocios.FormaPuntuacion;
import capanegocios.Modalidad;
import capanegocios.Participante;
import capanegocios.SeRealizaEn;

public class CompetenciaDAO {
	
	public static FormaPuntuacion getFormaPuntuacion(int idforma){
				
		Transaction tx = CrearSesion.session.beginTransaction();
		
		Query query = CrearSesion.session.createQuery("from FormaPuntuacion");

		
		List<FormaPuntuacion> formas = (List<FormaPuntuacion>) query.list();

		tx.commit();
		FormaPuntuacion forma = new FormaPuntuacion();
		for(FormaPuntuacion object: formas){
			if(object.getId_formadepuntuacion()==idforma){
				forma=object;
			}
		}
		
		return forma;
	
	}
	
	public static Modalidad getModalidad(long idmodalidad){
				
		Transaction tx = CrearSesion.session.beginTransaction();
		
		Query query = CrearSesion.session.createQuery("from Modalidad m where m.id_modalidad=?");
		query.setParameter(0, idmodalidad);
		
		Modalidad modalidadRec = (Modalidad) query.uniqueResult();

		tx.commit();
		
		
		return modalidadRec;
	}
	
	public static ArrayList<Competencia> buscarCompetencias(String nombre, int deporteID, int modalidadID, int estadoID, long usuarioID){
				
		Transaction tx = CrearSesion.session.beginTransaction();
		
		String consulta = "from Competencia ";
		int cuenta = -1;
		int nombrePar = -1;
		int deportePar = -1;
		int modalidadPar = -1;
		int estadoPar = -1;
		Boolean qnombre = false; 
		Boolean qdeporte = false;
		Boolean qmodalidad = false; 
		Boolean qestado = false;
		
		if(!(nombre.equals("")) || deporteID!=-1 || modalidadID!=-1 || estadoID!=-1){
			consulta += "c where ";
		}
		
		if(!(nombre.equals(""))){
			consulta += "c.nombre like ? ";
			qnombre = true;
			cuenta++;
			nombrePar =cuenta;
		}
		if(deporteID!=-1){
			if(qnombre){
				consulta += "and ";
			}
			consulta += "c.deporte.id=? ";
			qdeporte = true;
			cuenta++;
			deportePar = cuenta;
			
		}
		if(modalidadID!=-1){
			if(qdeporte || qnombre){
				consulta += "and ";
			}
			consulta += "c.modalidad.id_modalidad=? ";
			qmodalidad = true;
			cuenta++;
			modalidadPar = cuenta;
		}
		if(estadoID!=-1){
			if(qdeporte || qnombre || qmodalidad){
				consulta += "and ";
			}
			consulta += "c.estado.id=? ";
			cuenta++;
			estadoPar = cuenta;
			qestado = true;
		}
		
		if(qnombre || qdeporte || qmodalidad || qestado){
			consulta += "and c.usuario.id = ?";
		}
		else
			consulta += "c where c.usuario.id = ?";

		
		System.out.println(consulta);
		Query query = CrearSesion.session.createQuery(consulta);
		if(qnombre){
			query.setParameter(nombrePar, "%"+nombre+"%");
		}
		if(qdeporte){
			query.setParameter(deportePar, (long) deporteID);
		}
		if(qmodalidad){
			query.setParameter(modalidadPar, (long) modalidadID);
			
		}
		if(qestado){
			query.setParameter(estadoPar, (long) estadoID);
		}
		query.setParameter(cuenta+1, usuarioID);
		ArrayList<Competencia> competencias= (ArrayList<Competencia>) query.list();
		
		
		tx.commit();
		
		return competencias;
	}

	
	public static long agregarCompetencia(Competencia competencia){

		Transaction tx = CrearSesion.session.beginTransaction();
		long idGenerado = (long) CrearSesion.session.save(competencia);
		
		tx.commit();
		
		return idGenerado;
	}
	
	public static ListaCompetenciasDTO getListado(){
		
		
		Transaction tx = CrearSesion.session.beginTransaction();
		
		Query query = CrearSesion.session.createQuery("from Competencia");
		/*La linea anterior va a recuperar todas las competencias sin filtros.
		 para buscar con filtros va a haber que usar parametros, en el primer metodo
		 de esta clase hay un ejemplo de como se usan en las consultas*/
		
		List<Competencia> competencias= (List<Competencia>) query.list();

		ListaCompetenciasDTO listacompetencias= new ListaCompetenciasDTO();
		
		for(Competencia object: competencias){
			CompetenciaDTO  competencia = new CompetenciaDTO();
			ModalidadDTO modalidad = new ModalidadDTO();
			EstadoDTO estado = new EstadoDTO();
			DeporteDTO deporte = new DeporteDTO();
			/*Aca van el seteo de cada dto competencia que es lo que se devuelve*/
			
			competencia.setNombre(object.getNombre());
			modalidad.setEliminatoriaDoble(object.getModalidad().getEliminatoriadoble());
			modalidad.setEliminatoriaSimple(object.getModalidad().getEliminatoriasimple());
			modalidad.setId_modalidad(object.getModalidad().getId_modalidad());
			modalidad.setLiga(object.getModalidad().liga);
			competencia.setModalidad(modalidad);
			estado.setId_estado(object.getEstado().getId());
			estado.setNombre(object.getEstado().getNombre());
			competencia.setEstado(estado);
			deporte.setId(object.getDeporte().getId());
			deporte.setNombre(object.getNombre());
			competencia.setDeporte(deporte);
			
			//se agrega el dto a la lista dto, que es la que se retorna
			listacompetencias.addCompetencia(competencia);
		}
		
		tx.commit();
		
		
		return listacompetencias;
	}
	
	public static Competencia getCompetencia(long id_competencia){
		
		/*metodos para hacer la conexion*/
		
		Transaction tx = CrearSesion.session.beginTransaction();
		//Creo la consulta
		Query query = CrearSesion.session.createQuery("from Competencia s where s.id_competencia=?");
		query.setParameter(0, id_competencia);
		//Hago la consulta
		Competencia competencia= new Competencia();
		competencia = (Competencia) query.uniqueResult();
		
		tx.commit();
		
		return competencia;
	}

	public static void actualizarCompetencia(Competencia competencia) {
				
		Transaction tx = CrearSesion.session.beginTransaction();
		CrearSesion.session.merge(competencia);
		
		tx.commit();
		
	}

	public static boolean validarNombre(String text) {
		boolean retorno = false;
		Transaction tx = CrearSesion.session.beginTransaction();
		//Creo la consulta
		Query query = CrearSesion.session.createQuery("from Competencia s where s.nombre=?");
		query.setParameter(0, text);
		//Hago la consulta
		Competencia competencia= new Competencia();
		competencia = (Competencia) query.uniqueResult();
		
		tx.commit();
		
		if(competencia == null)
			retorno = true;
		else
			retorno = false;
		
		return retorno;
	}

	public static boolean validarMail(String text) {
		boolean retorno = false;
		Transaction tx = CrearSesion.session.beginTransaction();
		//Creo la consulta
		Query query = CrearSesion.session.createQuery("from Participante p where p.email=?");
		query.setParameter(0, text);
		//Hago la consulta
		Participante participante= new Participante();
		participante = (Participante) query.uniqueResult();
		
		tx.commit();
		
		if(participante == null)
			retorno = true;
		else
			retorno = false;
		
		return retorno;
	}
	
	public static boolean validarNombreP(String text) {
		boolean retorno = false;
		Transaction tx = CrearSesion.session.beginTransaction();
		//Creo la consulta
		Query query = CrearSesion.session.createQuery("from Participante p where p.nombre=?");
		query.setParameter(0, text);
		//Hago la consulta
		Participante participante= new Participante();
		participante = (Participante) query.uniqueResult();
		
		tx.commit();
		
		if(participante == null)
			retorno = true;
		else
			retorno = false;
		
		return retorno;
	}

	public static Estado getEstado(long id_estado) {
		Transaction tx = CrearSesion.session.beginTransaction();
		Query query = CrearSesion.session.createQuery("from Estado e where e.id=?");
		query.setParameter(0, id_estado);
		Estado estado = new Estado();
		estado = (Estado) query.uniqueResult();
		return estado;
	}
}
