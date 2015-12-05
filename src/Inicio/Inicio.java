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
import igrafica.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Inicio {
	
	public static void main(String[] args){
	CrearSesion.empezarSesion();

	//menuprincipal menu = new menuprincipal();
	//menu.setVisible(true);

	Cu020 ventana = new Cu020((long)1);
	ventana.setVisible(true);

	}
}
