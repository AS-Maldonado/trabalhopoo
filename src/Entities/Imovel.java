package Entities;
import java.util.List;
import java.util.Date;

public class Imovel {
	private String tipo;
	private float area;
	private String endereco;
	private int qtd_quartos;
	private int qtd_banheiros;
	private float valor_diaria;
	private float valor_semanal;
	private float valor_mensal;
	private List<Date> datas_disponibilidade;
	private String descricao;
	private List<String> fotos; //GUARDA OS CAMINHOS PARA AS IMAGENS
	
	public Imovel(String tipo, float area, String endereco, int qtd_quartos, int qtd_banheiros, float valor_diaria,
			float valor_semanal, float valor_mensal, List<Date> datas_disponibilidade, String descricao,
			List<String> fotos) {

		this.tipo = tipo;
		this.area = area;
		this.endereco = endereco;
		this.qtd_quartos = qtd_quartos;
		this.qtd_banheiros = qtd_banheiros;
		this.valor_diaria = valor_diaria;
		this.valor_semanal = valor_semanal;
		this.valor_mensal = valor_mensal;
		this.datas_disponibilidade = datas_disponibilidade;
		this.descricao = descricao;
		this.fotos = fotos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getQtd_quartos() {
		return qtd_quartos;
	}

	public void setQtd_quartos(int qtd_quartos) {
		this.qtd_quartos = qtd_quartos;
	}

	public int getQtd_banheiros() {
		return qtd_banheiros;
	}

	public void setQtd_banheiros(int qtd_banheiros) {
		this.qtd_banheiros = qtd_banheiros;
	}

	public float getValor_diaria() {
		return valor_diaria;
	}

	public void setValor_diaria(float valor_diaria) {
		this.valor_diaria = valor_diaria;
	}

	public float getValor_semanal() {
		return valor_semanal;
	}

	public void setValor_semanal(float valor_semanal) {
		this.valor_semanal = valor_semanal;
	}

	public float getValor_mensal() {
		return valor_mensal;
	}

	public void setValor_mensal(float valor_mensal) {
		this.valor_mensal = valor_mensal;
	}

	public List<Date> getDatas_disponibilidade() {
		return datas_disponibilidade;
	}

	public void setDatas_disponibilidade(List<Date> datas_disponibilidade) {
		this.datas_disponibilidade = datas_disponibilidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<String> getFotos() {
		return fotos;
	}

	public void setFotos(List<String> fotos) {
		this.fotos = fotos;
	}
	
	public void DetalharImovel() {
		//TODO
	}
	
	public void VerificarDisponibilidade(Date date) {
		/*VERIFICA SE A DATA PASSADA ESTA NA LISTA DE DATAS
		  SE NÃO ESTIVER ENTÃO ESTÁ DISPONÍVEL
		*/
	}
	
	public void AtualizarDisponibilidade(Date date) {
		//REMOVE A DATA PASSADA COMO PARAMETRO DA LISTA DE DATAS
	}
	
}
