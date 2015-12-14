package DAO;

import org.hibernate.Transaction;

import Inicio.CrearSesion;
import capanegocios.Participante;

public class ParticipanteDAO {

	public static boolean agregarParticipante(Participante participante){
		boolean bool=false;
		
		Transaction tx = CrearSesion.session.beginTransaction();
		CrearSesion.session.saveOrUpdate(participante);
		

		tx.commit();
		if(tx.getStatus().COMMITTED != null){
			bool=true;
		}
		
		
		return bool;
		
	}
	
}
