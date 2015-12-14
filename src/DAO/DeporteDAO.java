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
import Inicio.CrearSesion;
import capanegocios.Deporte;


public class DeporteDAO {
	
	public static ListaDeportesDTO getListado(){
		
		Transaction tx = CrearSesion.session.beginTransaction();
		Query query = CrearSesion.session.createQuery("from Deporte");
		
		List<Deporte> deportes= (List<Deporte>) query.list();

		ListaDeportesDTO listadeportes= new ListaDeportesDTO();
		for(Deporte object: deportes){
			
			
			DeporteDTO  deporte = new DeporteDTO();
			deporte.setNombre(object.getNombre());
		
			deporte.setId(object.getId());	
			listadeportes.addDeporte(deporte);
		}
		
		tx.commit();
		
		return listadeportes;
	}
	
	public static DeporteDTO getDeporteDTO(String deporte){
		DeporteDTO depDTO = new DeporteDTO();

		Transaction tx = CrearSesion.session.beginTransaction();
		
		Query query = CrearSesion.session.createQuery("from Deporte d where d.nombre=?");
		query.setParameter(0, deporte);
		
		Deporte deporteRec = (Deporte) query.uniqueResult();

		tx.commit();
		
		depDTO.setId(deporteRec.getId());
		depDTO.setNombre(deporteRec.getNombre());
		
		return depDTO;
	}
	
	public static Deporte getDeporte(String deporte){
		
		Transaction tx = CrearSesion.session.beginTransaction();
		
		Query query = CrearSesion.session.createQuery("from Deporte d where d.nombre=?");
		query.setParameter(0, deporte);
		
		Deporte deporteRec = (Deporte) query.uniqueResult();

		tx.commit();
		
		return deporteRec;
	}
	
}
