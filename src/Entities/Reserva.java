package Entities;

import java.util.Date;

public class Reserva {
	private Imovel imovel;
	private Date dataInicio;
	private Date dataFim;
	private String status;
	
	public Reserva(Imovel imovel, Date dataInicio, Date dataFim) {
		this.imovel = imovel;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}


	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
}
