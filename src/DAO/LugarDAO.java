package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import DTO.ListaLugaresDTO;
import DTO.LugarDTO;
import Inicio.CrearSesion;
import capanegocios.Lugar;
import capanegocios.SeRealizaEn;

public class LugarDAO {

		public static ListaLugaresDTO getListado(){
			/*metodos para hacer la conexion*/
			
			Transaction tx = CrearSesion.session.beginTransaction();
			
			//Creo la consulta
			Query query = CrearSesion.session.createQuery("from Lugar");
			//Hago la consulta y la cargo a una lista de lugares
			List<Lugar> lugares= (List<Lugar>) query.list();
			
			tx.commit();
			
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
		
		public static ListaLugaresDTO getListado(long idDeporte){
			/*metodos para hacer la conexion*/
			Transaction tx = CrearSesion.session.beginTransaction();
			//Creo la consulta
			Query query = CrearSesion.session.createQuery("from SeRealizaEn s where s.iddeporte=?");
			query.setParameter(0, idDeporte);
			//Hago la consulta y la cargo a una lista de lugares
			List<SeRealizaEn> serealizaen= (List<SeRealizaEn>) query.list();
			
			tx.commit();
			
			
			ListaLugaresDTO listalugares= new ListaLugaresDTO();
			
			
			//armo con los luga,res una ListaLugaresDTO y los retorno
			for(SeRealizaEn object: serealizaen){
	
				LugarDTO  lugar = new LugarDTO();
				lugar.setNombre(object.getLugar().getNombre());
				lugar.setDescripcion(object.getLugar().getDescripcion());
				lugar.setId(object.getLugar().getId());
				listalugares.addLugar(lugar);
				
			}
			
			return listalugares;
		}

		public static Lugar getLugar(LugarDTO lugar) {
			Transaction tx = CrearSesion.session.beginTransaction();
			//Creo la consulta
			Query query = CrearSesion.session.createQuery("from Lugar l where l.nombre=?");
			query.setParameter(0, lugar.getNombre());
			//Hago la consulta y la cargo a una lista de lugares
			Lugar lugarencontrado = (Lugar) query.uniqueResult();
			
			tx.commit();
			
			return lugarencontrado;
		}
}