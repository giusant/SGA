package br.si.es.sga.logic;


import br.si.es.sga.dao.CaixaDAO;
import br.si.es.sga.dto.CaixaDTO;
import br.si.es.sga.exeception.LogicException;

public class CaixaLogic {
	public void cadastrar (CaixaDTO caixaDTO) throws LogicException{
		try{
		CaixaDAO caixaDAO = new CaixaDAO();
		caixaDAO.inserir(caixaDTO);
		}catch(Exception e){
			throw  new LogicException(e.getMessage());
		}
	}
	public void atualizar (CaixaDTO caixaDTO) throws LogicException{
		try{
		CaixaDAO caixaDAO = new CaixaDAO();
		caixaDAO.atualizar(caixaDTO);
		}catch(Exception e){
			throw  new LogicException(e.getMessage());
		}
	}
}
