package Inicio;

import igrafica.*;

public class Inicio {
	
	public static void main(String[] args){
	CrearSesion.empezarSesion();

	

	long id_usuario = 1;

	//Cu018 cu = new Cu018(196,199,200,1);

	menuprincipal cu = new menuprincipal(1);

	//cu.main(null);
	cu.setVisible(true);
	
	}
}