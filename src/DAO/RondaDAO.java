package DAO;

import org.hibernate.Query;
import org.hibernate.Transaction;

import Inicio.CrearSesion;
import capanegocios.Competencia;
import capanegocios.Ronda;

public class RondaDAO {

	public static Ronda getRonda(long id_ronda){
		
		/*metodos para hacer la conexion*/
		
		Transaction tx = CrearSesion.session.beginTransaction();
		//Creo la consulta
		Query query = CrearSesion.session.createQuery("from Ronda s where s.id_ronda=?");
		query.setParameter(0, id_ronda);
		//Hago la consulta
		Ronda ronda= new Ronda();
		ronda = (Ronda) query.uniqueResult();
		
		tx.commit();
		/*session.close();
		factory.close();*/
		//System.out.println(listalugares.getLugares().get(0).getNombre());
		return ronda;
	}
}
