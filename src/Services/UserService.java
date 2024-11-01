package Services;

import java.util.List;

import Entities.Usuario;

public class UserService {
	public static Usuario BuscarUsuario(String nome, List<Usuario> usuariosCadastrados) {
		for(int i=0; i<usuariosCadastrados.size(); i++) {
			if(usuariosCadastrados.get(i).getNome().equals(nome)) {
				return usuariosCadastrados.get(i);
			}
		}
		
		return null;
	}
}
