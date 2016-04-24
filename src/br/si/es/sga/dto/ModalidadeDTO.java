package br.si.es.sga.dto;

public class ModalidadeDTO {
	private int idModalidade;
	private String nomeModalidade;
	private double valor;
	private String descrição;
	
	public int getIdModalidade() {
		return idModalidade;
	}
	public void setIdModalidade(int idModalidade) {
		this.idModalidade = idModalidade;
	}
	public String getNomeModalidade() {
		return nomeModalidade;
	}
	public void setNomeModalidade(String nomeModalidade) {
		this.nomeModalidade = nomeModalidade;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getDescrição() {
		return descrição;
	}
	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
}
