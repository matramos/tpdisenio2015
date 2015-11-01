package Prueba;

import DAO.UsuarioDAO;
import antlr.collections.List;

public class Prueba {

	
	private static UsuarioDAO ej=new UsuarioDAO();
	public static void main(String[] arg){
		/*Student s = new Student();
		s.setName("Mukesh");
		s.setRoll("101");
		s.setPhone("1212");
		s.setDegree("trolo");
		ej.guardar(s);
		System.out.println("listorti");
		*/
		String grado = ej.obtenerGrado();
		System.out.println(grado);
		
	}
}