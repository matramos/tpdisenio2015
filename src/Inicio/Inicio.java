package Inicio;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import DTO.CompetenciaDTO;
import DTO.ListaParticipantesDTO;
import DTO.ParticipanteDTO;
import capanegocios.Competencia;
import capanegocios.Deporte;
import capanegocios.Disponibilidad;
import capanegocios.Lugar;
import capanegocios.Participante;
import capanegocios.Provincia;
import capanegocios.SeRealizaEn;
import capanegocios.TipoDocumento;
import capanegocios.Usuario;
import gestores.GestorCompetencias;
import igrafica.Cu003;
import igrafica.Cu004;
import igrafica.Cu008;
import igrafica.Cu009;
import igrafica.Cu018;
import igrafica.Cu020;
import igrafica.Cu021;
import igrafica.menuprincipal;
import igrafica.pantallainicio;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Inicio {
	
	public static void main(String[] args){
	CrearSesion.empezarSesion();

	//menuprincipal menu = new menuprincipal();
	//menu.setVisible(true);
	//Cu009 cu009 = new Cu009((long)1);
	//cu009.setVisible(true);

	
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
=======
	/*Transaction tx = CrearSesion.session.beginTransaction();
	List<Participante> participantes = new ArrayList<Participante>();
>>>>>>> branch 'master' of https://github.com/matramos/tpdisenio2015.git
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
	
<<<<<<< HEAD
=======
>>>>>>> branch 'master' of https://github.com/matramos/tpdisenio2015.git
	CrearSesion.session.saveOrUpdate(comp);
	
	
	Query query = CrearSesion.session.createQuery("from Competencia c where c.id_competencia=?");
	query.setParameter(0, (long)0);
	
	Competencia comp = new Competencia();
	comp = (Competencia) query.uniqueResult()
	
	tx.commit();*/


	/*Calendar fecha = new GregorianCalendar();
	int año= fecha.get(Calendar.YEAR);
	int mes = fecha.get(Calendar.MONTH)+1;
	int dia = fecha.get(Calendar.DAY_OF_MONTH);
	String fechaActual = año+"/"+mes+"/"+dia+"";
	java.sql.Date hoy = java.sql.Date.valueOf(fechaActual);
	System.out.println(fechaActual);*/
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
	
	Query query = CrearSesion.session.createQuery("from Deporte");
	
	
	List<Deporte> dep = new ArrayList<Deporte>();
	dep = (ArrayList<Deporte>) query.list();
	tx.commit();
	
	System.out.println(dep.get(0).getId());
	System.out.println(dep.get(0).getSerealizaen().size());
	Query query = CrearSesion.session.createQuery("from Deporte");
	
	
	List<Deporte> dep = new ArrayList<Deporte>();
	dep = (ArrayList<Deporte>) query.list();
	tx.commit();
	
	System.out.println(dep.size());
	menuprincipal cu = new menuprincipal();
	cu.setVisible(true);
	
	
	CompetenciaDTO competencia = GestorCompetencias.getCompetencia(id_competencia);
	System.out.println(competencia.getParticipantes().size());
	System.out.println(competencia.getParticipantes().get(0).getPuntaje());
	*/
	long id_competencia = 1;
	long id_ronda = 1;
	long id_encuentro = 1;
	Cu018 cu = new Cu018(id_competencia,id_ronda,id_encuentro);
	//menuprincipal cu = new menuprincipal(id);
	//cu.main(null);
	
	cu.setVisible(true);
	//CrearSesion.terminarSesion();
}
}