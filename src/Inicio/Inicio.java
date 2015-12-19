package Inicio;

import igrafica.*;

public class Inicio {
	
	public static void main(String[] args){
	CrearSesion.empezarSesion();

	

	long id_usuario = 1;

	//Cu018 cu = new Cu018(196,199,200,1);
	pantallainicio cu = new pantallainicio();


	cu.main(null);
	//cu.setVisible(true);
	
	}
}