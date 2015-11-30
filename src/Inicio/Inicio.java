package Inicio;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import capanegocios.Competencia;
import capanegocios.Deporte;
import capanegocios.Disponibilidad;
import capanegocios.Lugar;
import capanegocios.Participante;
import capanegocios.Provincia;
import capanegocios.SeRealizaEn;
import capanegocios.TipoDocumento;
import capanegocios.Usuario;
import igrafica.Cu003;
import igrafica.Cu004;
import igrafica.Cu008;
import igrafica.Cu009;
import igrafica.menuprincipal;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Inicio {
	
	public static void main(String[] args){
	CrearSesion.empezarSesion();
	

	
	//Transaction tx = CrearSesion.session.beginTransaction();
	//Competencia comp = new Competencia();
	
	//Query query = CrearSesion.session.createQuery("from Competencia d where d.id_competencia=?");
	//query.setParameter(0, (long)86);
	
	//Competencia compRecuperada = (Competencia) query.uniqueResult();
	
	//comp.setNombre("pruebacompetencia");
	//comp.setDeporte((Deporte)query.uniqueResult());
	//System.out.println(compRecuperada.getDeporte().getNombre());
	//CrearSesion.session.saveOrUpdate(comp);
	//tx.commit();
	/*List<Participante> participantes = new ArrayList<Participante>();

	/*Transaction tx = CrearSesion.session.beginTransaction();
	List<Participante> participantes = new ArrayList<Participante>();

	Competencia comp = new Competencia();
	comp.setNombre("Liguilla pre libertadores");
	Participante part = new Participante();
	Participante par2 = new Participante();
	par2.setNombre("wieuqoe");
	par2.setEmail("qwewqe");
	part.setNombre("San lorenzo");
	part.setEmail("asdasda");
	participantes.add(part);
	participantes.add(par2);
	comp.setParticipantes(participantes);
	System.out.println(comp.getParticipantes().get(1).getNombre());

	

	CrearSesion.session.saveOrUpdate(comp);
	
	
	Query query = CrearSesion.session.createQuery("from Competencia c where c.id_competencia=?");
	query.setParameter(0, (long)0);
	
	Competencia comp = new Competencia();
	comp = (Competencia) query.uniqueResult()
	
	tx.commit();*/
	

	

	/*System.out.println(comp.getNombre());
	System.out.println(comp.getParticipantes().get(0).getNombre());
		CrearSesion.terminarSesion();
CrearSesion.terminarSesion();
	
	Cu004 cu = new Cu004();
	cu.setVisible(true);
	menuprincipal cu = new menuprincipal();
	cu.setVisible(true);
=======

	Calendar fecha = new GregorianCalendar();
	int año= fecha.get(Calendar.YEAR);
	int mes = fecha.get(Calendar.MONTH)+1;
	int dia = fecha.get(Calendar.DAY_OF_MONTH);
	String fechaActual = año+"/"+mes+"/"+dia+"";
	java.sql.Date hoy = java.sql.Date.valueOf(fechaActual);
	System.out.println(fechaActual);
	/*Transaction tx = CrearSesion.session.beginTransaction();
	
	Competencia comp = new Competencia();
	List<Disponibilidad> lugares = new ArrayList<Disponibilidad>();
	Lugar l1 = new Lugar();
	l1.setNombre("asdasdasd");
	l1.setDescripcion("asdasd");
	
	Disponibilidad d1 = new Disponibilidad();
	d1.setLugar(l1);
	d1.setDisponibilidad(3);
	lugares.add(d1);
	comp.setNombre("prueba");
	comp.setLugares(lugares);
	
	CrearSesion.session.save(comp);
	tx.commit();
		Query query = CrearSesion.session.createQuery("from Deporte");
	
	
	List<Deporte> dep = new ArrayList<Deporte>();
	dep = (ArrayList<Deporte>) query.list();

	tx.commit();
	System.out.println(dep.size());

	for(Deporte depor: dep){
		System.out.println(depor.getNombre());
		System.out.println(depor.getSerealizaen().size());

	}
	menuprincipal cu = new menuprincipal();
	cu.setVisible(true);
*/
	menuprincipal cu = new menuprincipal();
	cu.setVisible(true);
	//CrearSesion.terminarSesion();
	}
	
}

	
