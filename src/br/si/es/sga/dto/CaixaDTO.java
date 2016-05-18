package br.si.es.sga.dto;

import java.util.Date;

public class CaixaDTO {
	private int idCaixa;
	private double valorDiario;
	private double valorTotal;
	private double valorSaida;
	private Date data;
	
	public int getIdCaixa() {
		return idCaixa;
	}
	public void setIdCaixa(int idCaixa) {
		this.idCaixa = idCaixa;
	}
	public double getValorDiario() {
		return valorDiario;
	}
	public void setValorDiario(double valorDiario) {
		this.valorDiario = valorDiario;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getValorSaida() {
		return valorSaida;
	}
	public void setValorSaida(double valorSaida) {
		this.valorSaida = valorSaida;
	}
}
