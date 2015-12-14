package DAO;

import org.hibernate.Query;
import org.hibernate.Transaction;
import Inicio.CrearSesion;
import capanegocios.Usuario;

public class UsuarioDAO {

		public static long sesionUsuario(String email, String contrasena){
			Transaction tx = CrearSesion.session.beginTransaction();
			
			Query query = CrearSesion.session.createQuery("from Usuario u where u.email=? and u.contrasena=?");
			query.setParameter(0, email);
			query.setParameter(1, contrasena);

			
			Usuario usr = (Usuario) query.uniqueResult();

			tx.commit();
			
			long id_usuario = usr.getId();
			
			return id_usuario;
		}

		public static Usuario getUsuario(long idUsuario) {
			Transaction tx = CrearSesion.session.beginTransaction();
			
			Query query = CrearSesion.session.createQuery("from Usuario u where u.id=?");
			query.setParameter(0, idUsuario);


			
			Usuario usr = (Usuario) query.uniqueResult();

			tx.commit();
			return usr;
		}
}
