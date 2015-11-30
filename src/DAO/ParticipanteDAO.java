package DAO;

import org.hibernate.Transaction;

import Inicio.CrearSesion;
import capanegocios.Competencia;
import capanegocios.Participante;

public class ParticipanteDAO {

	public static boolean agregarParticipante(Participante participante){
		boolean bool=false;
		/*Configuration cfg = new Configuration();
		cfg.configure ("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();*/
		Transaction tx = CrearSesion.session.beginTransaction();
		
		System.out.println(participante.getId_participante());
		CrearSesion.session.saveOrUpdate(participante);
		

		tx.commit();
		if(tx.getStatus().COMMITTED != null){
			bool=true;
		}
		
		
		return bool;
		
	}
	
}
