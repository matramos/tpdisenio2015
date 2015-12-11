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

	
	long id_competencia = 1;
	long id_usuario = 1;
	long id_encuentro = 1;
	//Cu020 cu = new Cu020(id_competencia,id_usuario);
	menuprincipal cu = new menuprincipal(id_usuario);
	//cu.main(null);
	cu.setVisible(true);
	//CrearSesion.terminarSesion();en que momento se le carga el atributo puntaje?
}
}//tira el mismo error? cambiaste las cosas?