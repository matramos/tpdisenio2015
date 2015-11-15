package Inicio;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import capanegocios.Competencia;
import capanegocios.Participante;
import capanegocios.TipoDocumento;
import capanegocios.Usuario;
import igrafica.Cu004;
import igrafica.Cu008;
import igrafica.menuprincipal;

public class Inicio {
	
	public static void main(String[] args){
	CrearSesion.empezarSesion();
	//menuprincipal menu = new menuprincipal();
	//menu.setVisible(true);
	
	
	Transaction tx = CrearSesion.session.beginTransaction();
	/*List<Participante> participantes = new ArrayList<Participante>();
	Competencia comp = new Competencia();
	comp.setNombre("Liguilla pre sudamericana");
	Participante part = new Participante();
	part.setNombre("aldosivi");
	part.setEmail("aldosivi_campeones@gmail.com");
	participantes.add(part);
	comp.setParticipantes(participantes);
	
	CrearSesion.session.saveOrUpdate(comp);*/
	
	
	Query query = CrearSesion.session.createQuery("from Competencia c where c.id_competencia=?");
	query.setParameter(0, (long)0);
	
	Competencia comp = new Competencia();
	comp = (Competencia) query.uniqueResult();
	
	tx.commit();
	
	System.out.println(comp.getNombre());
	System.out.println(comp.getParticipantes().get(0).getNombre());

	CrearSesion.terminarSesion();
	}
	
}
	
