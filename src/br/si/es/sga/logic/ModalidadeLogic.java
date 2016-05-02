package br.si.es.sga.logic;

import java.util.List;



import br.si.es.sga.dao.ModalidadeDAO;
import br.si.es.sga.dto.ModalidadeDTO;
import br.si.es.sga.exeception.LogicException;

public class ModalidadeLogic {
	
	public void cadastrar (ModalidadeDTO modalidadeDTO) throws LogicException{
		try{
		ModalidadeDAO modalidadeDAO = new ModalidadeDAO();
		modalidadeDAO.inserir(modalidadeDTO);
		}catch(Exception e){
			throw  new LogicException(e.getMessage());
		}
	}
	public List<ModalidadeDTO> listarModalidade() throws LogicException{
		List<ModalidadeDTO> lista = null;
		try{
			ModalidadeDAO modalidadeDAO = new ModalidadeDAO();
			lista = modalidadeDAO.listarTodos(); 
		}catch(Exception e){
			e.printStackTrace();
			throw new LogicException(e.getMessage(), e);
		}
		return lista;
	}
	
	public void removerModalidade(Integer idModalidade) throws LogicException{
		try{
			ModalidadeDAO modalidadeDAO = new ModalidadeDAO();
			modalidadeDAO.deletar(idModalidade);
			
		}catch(Exception e){
			e.printStackTrace();
			throw  new LogicException(e.getMessage());
		}
	}
	public void ataulizar(ModalidadeDTO modalidadeDTO) throws LogicException{
		try{
			ModalidadeDAO modalidadeDAO = new ModalidadeDAO();
			modalidadeDAO.atualizar(modalidadeDTO);
		}catch(Exception e){
			throw  new LogicException(e.getMessage());
		}
	}
	public ModalidadeDTO getModalidade(String nomeModalidade) throws LogicException{
		ModalidadeDTO modalidadeDTO = new ModalidadeDTO();
		ModalidadeDAO modalidadeDAO = new ModalidadeDAO();
		try{
			
			modalidadeDTO = modalidadeDAO.buscarPorNome(nomeModalidade);
			
		}catch(Exception e ){
			throw new LogicException(e.getMessage(), e);
		}
		return modalidadeDTO;
	}
	
}
