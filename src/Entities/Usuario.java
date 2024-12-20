package Entities;

public abstract class Usuario {
	private String nome;
	private String email;
	private String telefone;
	private int senha;
	
	public Usuario(String nome, String email, String telefone, int senha) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}

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
	
	public void DetalharUsuario() {
		System.out.println("NOME: " + this.nome);
		System.out.println("EMAIL: " + this.email);
		System.out.println("TELEFONE: " + this.telefone);
	}
}
