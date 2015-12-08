package DAO;

import org.hibernate.Query;
import org.hibernate.Transaction;

import Inicio.CrearSesion;
import capanegocios.Competencia;
import capanegocios.Encuentro;

public class EncuentroDAO {

	public static Encuentro getEncuentro(long id_encuentro){
		
		/*metodos para hacer la conexion*/
		
		Transaction tx = CrearSesion.session.beginTransaction();
		//Creo la consulta
		Query query = CrearSesion.session.createQuery("from Encuentro s where s.id_encuentro=?");
		query.setParameter(0, id_encuentro);
		//Hago la consulta
		Encuentro encuentro= new Encuentro();
		encuentro = (Encuentro) query.uniqueResult();
		
		tx.commit();
		/*session.close();
		factory.close();*/
		//System.out.println(listalugares.getLugares().get(0).getNombre());
		return encuentro;
	}
}
