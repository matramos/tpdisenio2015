package Inicio;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import capanegocios.Competencia;
import capanegocios.Participante;
import capanegocios.TipoDocumento;
import capanegocios.Usuario;
import igrafica.Cu003;
import igrafica.Cu004;
import igrafica.Cu008;
import igrafica.Cu009;
import igrafica.menuprincipal;

public class Inicio {
	
	public static void main(String[] args){
	CrearSesion.empezarSesion();
	//menuprincipal menu = new menuprincipal();
	//menu.setVisible(true);
	Cu009 cu009 = new Cu009((long)1);
	cu009.setVisible(true);
	
	/*Transaction tx = CrearSesion.session.beginTransaction();
	List<Participante> participantes = new ArrayList<Participante>();
	Competencia comp = new Competencia();
	comp.setNombre("Liguilla pre sudamericana");
	Participante part = new Participante();
	part.setNombre("aldosivi");
	part.setEmail("aldosivi_campeones@gmail.com");
	participantes.add(part);
	comp.setParticipantes(participantes);
	
	CrearSesion.session.saveOrUpdate(comp);
	
	
	Query query = CrearSesion.session.createQuery("from Competencia c where c.id_competencia=?");
	query.setParameter(0, (long)0);
	
	Competencia comp = new Competencia();
	comp = (Competencia) query.uniqueResult()
	
	tx.commit();*/
	


	//CrearSesion.terminarSesion();
	}
	
}

/*
 * 
 * File archivo = null;
					byte[] buffer = null;
					if(!panel.url.isEmpty()){
						try {
							archivo = new File(panel.url);
							InputStream ee = new FileInputStream(archivo);
							buffer = new byte[(int) archivo.length()];
							ee.read(buffer);
							
						} catch (Exception e1) {
							
							e1.printStackTrace();
						}
						
						*/
 
	
