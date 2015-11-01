package DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import antlr.collections.List;
import Prueba.Student;

public class UsuarioDAO {

		public void guardar(Student s){
			Configuration cfg = new Configuration();
			cfg.configure ("hibernate.cfg.xml");
			cfg.addClass(Prueba.Student.class);
			
			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
			
			Transaction tx = session.beginTransaction();
			session.save(s);
			tx.commit();
			session.close();
			factory.close();
		}
		
		public String obtenerGrado(){
			Configuration cfg = new Configuration();
			cfg.configure ("hibernate.cfg.xml");
			cfg.addClass(Prueba.Student.class);
			
			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
			
			Transaction tx = session.beginTransaction();
			
			Query query = session.createQuery("SELECT s.degree FROM Student as s");
			
			return (String) query.uniqueResult();
			
			
		}
		
		public Student obtenerStudent(){
			Student student;
			Long id = (long) 0;
			
			Configuration cfg = new Configuration();
			cfg.configure ("hibernate.cfg.xml");
			cfg.addClass(Prueba.Student.class);
			
			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
			
			Transaction tx = session.beginTransaction();
			
			student = session.get(Student.class, id);
			
			return student;
		}
}
