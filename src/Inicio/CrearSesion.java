package Inicio;


import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;


public class CrearSesion {

	
	public static Configuration cfg;
	public static SessionFactory factory;
	public static Session session;
	
	public static void empezarSesion(){
		Configuration cfg = new Configuration();
		cfg.configure ("hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
		session = factory.openSession();
		
		
	}
	
	public static void terminarSesion(){
		session.close();
		factory.close();
	}
	
}