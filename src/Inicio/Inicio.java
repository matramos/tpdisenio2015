package Inicio;

import igrafica.*;

public class Inicio {
	
	public static void main(String[] args){
	CrearSesion.empezarSesion();

	

	long id_usuario = 1;

	//Cu018 cu = new Cu018(315,318,319,1);
	menuprincipal cu = new menuprincipal(id_usuario);

	//cu.main(null);
	cu.setVisible(true);
	
	}
}