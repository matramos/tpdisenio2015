package Inicio;

import igrafica.*;

public class Inicio {
	
	public static void main(String[] args){
	CrearSesion.empezarSesion();

	

	long id_usuario = 1;

	//Cu018 cu = new Cu018(184,187,188,1);
	menuprincipal cu = new menuprincipal(id_usuario);

	//cu.main(null);
	cu.setVisible(true);
	
}
}