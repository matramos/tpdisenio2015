package DAO;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import DTO.DeporteDTO;
import DTO.ListaDeportesDTO;
import DTO.ListaLugaresDTO;
import DTO.LugarDTO;
import DTO.SeRealizaEnDTO;
import Inicio.CrearSesion;
import capanegocios.Deporte;
import capanegocios.Lugar;
import capanegocios.SeRealizaEn;

public class DeporteDAO {
	
	public static ListaDeportesDTO getListado(){
		/*Configuration cfg = new Configuration();
		cfg.configure ("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Deporte");*/
		Transaction tx = CrearSesion.session.beginTransaction();
		Query query = CrearSesion.session.createQuery("from Deporte");
		
		List<Deporte> deportes= (List<Deporte>) query.list();

		ListaDeportesDTO listadeportes= new ListaDeportesDTO();
		for(Deporte object: deportes){
			
			
			DeporteDTO  deporte = new DeporteDTO();
			deporte.setNombre(object.getNombre());
		
			/*for(SeRealizaEn obj : object.getSerealizaen()){
				SeRealizaEnDTO sreDTO = new SeRealizaEnDTO();
				sreDTO.setId_deporte(obj.getIddeporte());
				sreDTO.setId_lugar(obj.getIdlugar());
				deporte.addSerealizaen(sreDTO);
			}*/
			
			deporte.setId(object.getId());	
			listadeportes.addDeporte(deporte);
		}
		
		tx.commit();
		/*tx.commit();
		session.close();
		factory.close();*/
		
		return listadeportes;
	}
	
	public static DeporteDTO getDeporteDTO(String deporte){
		DeporteDTO depDTO = new DeporteDTO();
		/*Configuration cfg = new Configuration();
		cfg.configure ("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		*/
		Transaction tx = CrearSesion.session.beginTransaction();
		
		Query query = CrearSesion.session.createQuery("from Deporte d where d.nombre=?");
		query.setParameter(0, deporte);
		
		Deporte deporteRec = (Deporte) query.uniqueResult();

		tx.commit();
		
		depDTO.setId(deporteRec.getId());
		depDTO.setNombre(deporteRec.getNombre());
		/*session.close();
		factory.close();*/
		
		return depDTO;
	}
	
	public static Deporte getDeporte(String deporte){
		/*Configuration cfg = new Configuration();
		cfg.configure ("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		*/
		Transaction tx = CrearSesion.session.beginTransaction();
		
		Query query = CrearSesion.session.createQuery("from Deporte d where d.nombre=?");
		query.setParameter(0, deporte);
		
		Deporte deporteRec = (Deporte) query.uniqueResult();

		tx.commit();
		
		
		/*session.close();
		factory.close();*/
		
		return deporteRec;
	}
	
}
