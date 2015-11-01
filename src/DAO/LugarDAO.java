package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import capanegocios.Lugar;
import capanegocios.Provincia;

public class LugarDAO {

		public static List<Lugar> getListado(){
			Configuration cfg = new Configuration();
			cfg.configure ("hibernate.cfg.xml");
			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
			
			Transaction tx = session.beginTransaction();
			
			Query query = session.createQuery("from Lugar");
			
			List<Lugar> lugares= (List<Lugar>) query.list();
			
			tx.commit();
			
			session.close();
			factory.close();
			
			return lugares;
		}
}
