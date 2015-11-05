package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import DTO.ListaLugaresDTO;
import DTO.LugarDTO;
import capanegocios.Deporte;
import capanegocios.Lugar;
import capanegocios.Provincia;

public class LugarDAO {

		public static ListaLugaresDTO getListado(){
			/*metodos para hacer la conexion*/
			Configuration cfg = new Configuration();
			cfg.configure ("hibernate.cfg.xml");
			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
			
			Transaction tx = session.beginTransaction();
			
			//Creo la consulta
			Query query = session.createQuery("from Lugar");
			//Hago la consulta y la cargo a una lista de lugares
			List<Lugar> lugares= (List<Lugar>) query.list();
			
			tx.commit();
			
			session.close();
			factory.close();
			ListaLugaresDTO listalugares= new ListaLugaresDTO();
			
				
			//armo con los lugares una ListaLugaresDTO y los retorno
			for(Lugar object: lugares){
				
				
				LugarDTO  lugar = new LugarDTO();
				lugar.setNombre(object.getNombre());
				lugar.setDescripcion(object.getDescripcion());
				lugar.setId(object.getId());	
				listalugares.addLugar(lugar);
			}
			return listalugares;
		}
}
