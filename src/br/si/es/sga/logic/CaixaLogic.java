package br.si.es.sga.logic;


import java.util.Date;
import java.util.List;

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
	public void deletar () throws LogicException{
		try{
		CaixaDAO caixaDAO = new CaixaDAO();
		caixaDAO.deletar();
		}catch(Exception e){
			throw  new LogicException(e.getMessage());
		}
	}
	public Date getDataDoMes() throws LogicException{
		List<CaixaDTO> lista;
		CaixaDTO caixaDTO = new CaixaDTO();
		try{
			CaixaDAO caixaDAO = new CaixaDAO();
			 lista = caixaDAO.listarTodos();
			 caixaDTO = lista.get(0);
			 
			}catch(Exception e){
				throw  new LogicException(e.getMessage());
			}
		return caixaDTO.getData();
		
	}
	public List<CaixaDTO> listar () throws LogicException{
		List<CaixaDTO> lista;
		try{
		CaixaDAO caixaDAO = new CaixaDAO();
		lista = caixaDAO.listarTodos();
		}catch(Exception e){
			throw  new LogicException(e.getMessage());
		}
		return lista;
	}
}
