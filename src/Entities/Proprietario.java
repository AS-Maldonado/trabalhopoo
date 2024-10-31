package Entities;

import java.util.List;

public class Proprietario extends Usuario {
	private List<Imovel> listaImovel;

	public Proprietario(String nome, String email, String telefone, int senha, List<Imovel> listaImovel) {
		super(nome, email, telefone, senha);
		this.listaImovel = listaImovel;
	}

	public List<Imovel> getListaImovel() {
		return listaImovel;
	}

	public void setListaImovel(List<Imovel> listaImovel) {
		this.listaImovel = listaImovel;
	}
	
	public void CadastrarImovel() {
		//TODO
	}
	
	public void EditarImovel(Imovel imovel) {
		//TODO
	}
	
	public void ExcluirImovel(Imovel imovel) {
		//TODO
	}
}
