package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import DTO.DeporteDTO;
import DTO.ListaDeportesDTO;
import DTO.ListaLugaresDTO;
import DTO.LugarDTO;
import capanegocios.Deporte;
import capanegocios.Lugar;

public class DeporteDAO {
	
	public static ListaDeportesDTO getListado(){
		Configuration cfg = new Configuration();
		cfg.configure ("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Deporte");
		
		List<Deporte> deportes= (List<Deporte>) query.list();

		tx.commit();
		
		session.close();
		factory.close();
		
		ListaDeportesDTO listadeportes= new ListaDeportesDTO();
		
		for(Deporte object: deportes){
			
			
			DeporteDTO  deporte = new DeporteDTO();
			deporte.setNombre(object.getNombre());
			deporte.setSerealizaen(object.getSerealizaen());
			deporte.setId(object.getId());	
			listadeportes.addDeporte(deporte);
		}
		
		return listadeportes;
	}
}
