package Entities;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nome;
	private String email;
	private String telefone;
	private int senha;
	private String tipo;

	private static List<Usuario> usuarios = new ArrayList<>();

	public Usuario(String nome, String email, String telefone, int senha) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		Registrar();
	}

	public static Usuario criarUsuario(String nome, String email, String telefone, int senha, String tipo) {
		Usuario novoUsuario = new Usuario(nome, email, telefone, senha);
		novoUsuario.setTipo(tipo);
		usuarios.add(novoUsuario);
		return novoUsuario;
	}

	public Usuario(){}

//	public UsuarioComTipo(String nome, String email, String telefone, int senha, String tipo) {
//		this.nome = nome;
//		this.email = email;
//		this.telefone = telefone;
//		this.senha = senha;
//		this.tipo = tipo;
//	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void DetalharUsuario() {
		System.out.println("NOME: " + this.nome);
		System.out.println("EMAIL: " + this.email);
		System.out.println("TELEFONE: " + this.telefone);
		System.out.println("TIPO: "+this.tipo);
	}

	public void Registrar() {
		/* ACHO QUE O IDEAL É COLOCAR ESSES DADOS EM UM ARQUIVO SÓ PRA SIMULAR UM BANCO DE DADOS
		 * AÍ A GNT PODE PEGAR OS DADOS PELO MENU, CRIAR O OBJETO COM O CONSTRUTOR NORMAL
		 * E AÍ CHAMAR ESSE MÉTODO SÓ PRA ADICIONAR OS DADOS NO ARQUIVO
		 */

		System.out.println("USUÁRIO REGISTRADO COM SUCESSO!");
	}

	public void EditarRegistro() {
		System.out.println("REGISTRO EDITADO COM SUCESSO!");
	}

	public boolean autenticar(int senha) {
		return this.senha == senha;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public static Usuario getUsuarioPorEmail(String email) {
		for (Usuario usuario : usuarios) {
			if (usuario.getEmail().equalsIgnoreCase(email)) {
				return usuario;
			}
		}
		return null;
	}
}
