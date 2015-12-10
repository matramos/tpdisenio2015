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
import capanegocios.FormaPuntuacion;
import capanegocios.Modalidad;
import capanegocios.SeRealizaEn;

public class CompetenciaDAO {
	
	public static FormaPuntuacion getFormaPuntuacion(int idforma){
		/*Configuration cfg = new Configuration();
		cfg.configure ("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();*/
		
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
		/*Configuration cfg = new Configuration();
		cfg.configure ("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();*/
		
		Transaction tx = CrearSesion.session.beginTransaction();
		
		Query query = CrearSesion.session.createQuery("from Modalidad m where m.id_modalidad=?");
		query.setParameter(0, idmodalidad);
		
		Modalidad modalidadRec = (Modalidad) query.uniqueResult();

		tx.commit();
		
		
		return modalidadRec;
	}
	
	public static ArrayList<Competencia> buscarCompetencias(String nombre, int deporteID, int modalidadID, int estadoID, long usuarioID){
		/*Configuration cfg = new Configuration();
		cfg.configure ("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();*/
		
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
		/*Configuration cfg = new Configuration();
		cfg.configure ("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();*/
		
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
			/*Aca van el seteo de cada dto competencia que es lo que se devuelve,
			 setea solamente lo que se va a mostrar por pantalla, el resto ya fue*/
			
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
		/*session.close();
		factory.close();*/
		//System.out.println(competencia.getNombre()); al participante le cargas los puntos y todo eso?si, aca
		return competencia;
	}

	public static void actualizarCompetencia(Competencia competencia) {
		
		// METODO 1 - ERROR EN tx.commit();
		/*Transaction tx = CrearSesion.session.beginTransaction();
		CrearSesion.session.update(competencia);
		tx.commit();*/
		
		/* METODO 2 - ERROR EN tx.commit();
		Transaction tx = CrearSesion.session.beginTransaction();
		Competencia nuevacomp = (Competencia) CrearSesion.session.get(Competencia.class,competencia.getId_competencia());
		CrearSesion.session.update(nuevacomp);
		tx.commit();*/
		
		
		// Session session = factory.openSession();
		//METODO 3
      //Transaction tx = null;
		Transaction tx = CrearSesion.session.beginTransaction();
      try{
         tx = CrearSesion.session.beginTransaction();
         Competencia nuevacomp = (Competencia) CrearSesion.session.get(Competencia.class, competencia.getId_competencia()); 
		 //CrearSesion.session.merge(nuevacomp); 
		 CrearSesion.session.merge(nuevacomp);
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         CrearSesion.session.close(); 
      }
	}
}
