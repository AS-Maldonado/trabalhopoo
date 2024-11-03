package Entities;

import java.util.List;

public class Administrador extends Usuario {
	private List<Imovel> listaFavoritos;
	private List<Reserva> historicoReservas;

	public Administrador(String nome, String email, String telefone, int senha, List<Imovel> listaFavoritos,
			List<Reserva> historicoReservas) {
		super(nome, email, telefone, senha);
		this.listaFavoritos = listaFavoritos;
		this.historicoReservas = historicoReservas;
	}

	public List<Imovel> getListaFavoritos() {
		return listaFavoritos;
	}

	public void setListaFavoritos(List<Imovel> listaFavoritos) {
		this.listaFavoritos = listaFavoritos;
	}

	public List<Reserva> getHistoricoReservas() {
		return historicoReservas;
	}

	public void setHistoricoReservas(List<Reserva> historicoReservas) {
		this.historicoReservas = historicoReservas;
	}

	public void GerenciarUsuarios() {
		//TODO
	}


}
