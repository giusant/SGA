package br.si.es.sga.logic;

import java.util.Date;

import br.si.es.sga.dao.AtividadeDAO;
import br.si.es.sga.dto.AtividadeDTO;
import br.si.es.sga.exeception.LogicException;

public class AtividadeLogic {
	public void cadastrar (AtividadeDTO usuarioDTO) throws LogicException{
		try{
		AtividadeDAO atividadeDAO = new AtividadeDAO();
		atividadeDAO.inserir(usuarioDTO);
		}catch(Exception e){
			throw  new LogicException(e.getMessage());
		}
	}
	public void atualizar (AtividadeDTO usuarioDTO) throws LogicException{
		try{
		AtividadeDAO atividadeDAO = new AtividadeDAO();
		atividadeDAO.atualizar(usuarioDTO);
		}catch(Exception e){
			throw  new LogicException(e.getMessage());
		}
	}
	public void deletar (int  idUsuario) throws LogicException{
		try{
		AtividadeDAO atividadeDAO = new AtividadeDAO();
		atividadeDAO.deletar(idUsuario);
		}catch(Exception e){
			throw  new LogicException(e.getMessage());
		}
	}
	public double valorDiario (String data) throws LogicException{
		double valorDiario;
		try{
		AtividadeDAO atividadeDAO = new AtividadeDAO();
		valorDiario = atividadeDAO.valorDiario(data);
		}catch(Exception e){
			throw  new LogicException(e.getMessage());
		}
		return valorDiario;
	}
	public double valorTotalMes (String dataInicial, String dataFinal) throws LogicException{
		double valorTotalMes;
		try{
		AtividadeDAO atividadeDAO = new AtividadeDAO();
		valorTotalMes = atividadeDAO.valorTotalMes(dataInicial, dataFinal);
		}catch(Exception e){
			throw  new LogicException(e.getMessage());
		}
		return valorTotalMes;
	}
}
