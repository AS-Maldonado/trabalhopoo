package Entities;

import java.util.List;

public class Cliente extends Usuario {
	private List<Imovel> listaFavoritos;
	private List<Reserva> historicoReservas;
	
	public Cliente(String nome, String email, String telefone, int senha, List<Imovel> listaFavoritos,
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
	
	public void BuscarImovel() {
		//TODO
	}
	
	public String ReservarImovel() {
		//TODO
		return "";
	}
	
	public String CancelarReserva() {
		//TODO
		return "";
	}
	
	public void AdicionarFavoritos() {
		//TODO
	}
}
