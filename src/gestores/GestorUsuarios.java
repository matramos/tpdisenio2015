package gestores;

import DAO.UsuarioDAO;

public class GestorUsuarios {
	
	public static void buscarPaises(){
	
	}
	
	public static long autenticarUsuario(String email, String contrasena){
		long id_usuario = UsuarioDAO.sesionUsuario(email, contrasena);
		return id_usuario;
		
	}
}