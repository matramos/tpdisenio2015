package DAO;

import java.util.List;

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
import DTO.ModalidadDTO;
import capanegocios.Competencia;
import capanegocios.Deporte;
import capanegocios.FormaPuntuacion;
import capanegocios.Modalidad;

public class CompetenciaDAO {
	
	public static FormaPuntuacion getFormaPuntuacion(long idforma){
		Configuration cfg = new Configuration();
		cfg.configure ("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from FormaPuntuacion f where f.id_formadepuntuacion=?");
		query.setParameter(0, idforma);
		
		FormaPuntuacion formaRec = (FormaPuntuacion) query.uniqueResult();

		tx.commit();
		session.close();
		factory.close();
		
		return formaRec;
	}
	
	public static Modalidad getModalidad(long idmodalidad){
		Configuration cfg = new Configuration();
		cfg.configure ("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Modalidad m where m.id_modalidad=?");
		query.setParameter(0, idmodalidad);
		
		Modalidad modalidadRec = (Modalidad) query.uniqueResult();

		tx.commit();
		session.close();
		factory.close();
		
		return modalidadRec;
	}
	
	public static void agregarCompetencia(Competencia competencia){
		Configuration cfg = new Configuration();
		cfg.configure ("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.persist(competencia);
		

		tx.commit();
		session.close();
		factory.close();
		
	}
	
	public static ListaCompetenciasDTO getListado(){
		Configuration cfg = new Configuration();
		cfg.configure ("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Competencia");
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
			modalidad.setElminatoriaSimple(object.getModalidad().getElminatoriasimple());
			modalidad.setId_modalidad(object.getModalidad().getId_modalidad());
			modalidad.setLiga(object.getModalidad().liga);
			competencia.setModalidad(modalidad);
			estado.setId_estado(object.getEstado().getId_estado());
			estado.setNombre(object.getEstado().getNombre());
			competencia.setEstado(estado);
			deporte.setId(object.getDeporte().getId());
			deporte.setNombre(object.getNombre());
			competencia.setDeporte(deporte);
			
			//se agrega el dto a la lista dto, que es la que se retorna
			listacompetencias.addCompetencia(competencia);
		}
		
		tx.commit();
		session.close();
		factory.close();
		
		return listacompetencias;
	}

}
