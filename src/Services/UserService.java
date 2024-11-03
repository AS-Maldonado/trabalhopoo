package Services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Entities.Imovel;
import Entities.Usuario;

public class UserService {
	private Map<String, Usuario> usuariosCadastrados;

	public UserService() {
		usuariosCadastrados = new HashMap<>();
	}

	public static Usuario BuscarUsuario(String nome, List<Usuario> usuariosCadastrados) {
		for(int i=0; i<usuariosCadastrados.size(); i++) {
			if(usuariosCadastrados.get(i).getNome().equals(nome)) {
				return usuariosCadastrados.get(i);
			}
		}
		
		return null;
	}
	public static void cadastrarUsuario(List<Usuario> usuariosCadastrados, String nome, String email, String telefone, int senha, String tipo){
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setNome(nome);
		usuario.setTelefone(telefone);
		usuario.setSenha(senha);
		usuario.setTipo(tipo);
		usuariosCadastrados.add(usuario.criarUsuario(nome, email, telefone, senha, tipo));
	}

	public int autenticarUsuario(String email, int senha, int tipoLogin, List<Usuario> usuarios) {
		Usuario usuario = new Usuario();
		for (Usuario usu : usuarios){
			usu = Usuario.getUsuarioPorEmail(email);
			if (usu != null){
				usuario = usu;
			}else{
				usuario = null;
			}
		}

		if (usuario == null) {
			System.out.println("Usuário não encontrado.");
			return  -1;
		}

		if (!usuario.autenticar(senha)) {
			System.out.println("Senha incorreta.");
			return -1;
		}

		switch (tipoLogin) {
			case 1: // Visitante
				if (usuario.getTipo().equals("V")) {
					System.out.println("VISITANTE LOGADO COM SUCESSO!\n");
					return 1;
				}
				break;

			case 2:
				if (usuario.getTipo().equals("C")) {
					System.out.println("CLIENTE LOGADO COM SUCESSO!\n");
					return 2;
				}
				break;

			case 3:
				if (usuario.getTipo().equals("A")) {
					System.out.println("ADMINISTRADOR LOGADO COM SUCESSO!\n");
					return 3;
				}
				break;

			case 4:
				if (usuario.getTipo().equals("P")) {
					System.out.println("PROPRIETARIO LOGADO COM SUCESSO!\n");
					return 4;
				}
				break;

			default:
				System.out.println("Tipo de login inválido.");
				return -1;
		}

		System.out.println("Tipo de login não corresponde ao tipo do usuário.");
		return  -1;
	}
}
