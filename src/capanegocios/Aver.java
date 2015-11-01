package capanegocios;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Aver {
public static void main (String[] args){
		
		
		Configuration cfg = new Configuration();
		cfg.configure ("hibernate.cfg.xml");
		/*cfg.addClass(capanegocios.Localidad.class);
		cfg.addClass(capanegocios.Provincia.class);*/

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		/*
		Localidad localidad1 = new Localidad();
		Localidad localidad2 = new Localidad();
		Localidad localidad3 = new Localidad();
		
		localidad1.setNombre("Santa Fe");
		localidad2.setNombre("Rosario");
		localidad3.setNombre("Santaasdsd");
		localidad3.setId(4);
		localidad1.setId(0);
		localidad2.setId(2);
		Provincia provincia1 = new Provincia();
		provincia1.setNombre("SantaFe");
		provincia1.addLocalidad(localidad1);
		provincia1.addLocalidad(localidad2);
		session.persist(provincia1);
		tx.commit();
		Provincia santa_fe= (Provincia) query.uniqueResult();
		
		session.saveOrUpdate(provincia1);
		*/
		
		Query query = session.createQuery("from Provincia");
		
		List<Provincia> provincias= (List<Provincia>) query.list();
		
		tx.commit();
		
		Provincia p1 = provincias.get(1);
		Localidad l1 = (Localidad) p1.getLocalidades().get(0);
		System.out.println(l1.getNombre());
		System.out.println("Hay" + provincias.size() + "provincias");
		session.close();
		factory.close();
		
	}
}
