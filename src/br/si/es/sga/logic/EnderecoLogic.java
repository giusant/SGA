package br.si.es.sga.logic;


import br.si.es.sga.dao.EnderecoDAO;
import br.si.es.sga.dao.ModalidadeDAO;
import br.si.es.sga.dto.EnderecoDTO;
import br.si.es.sga.dto.ModalidadeDTO;
import br.si.es.sga.exeception.LogicException;

public class EnderecoLogic {
	public int cadastrar (EnderecoDTO enderecoDTO) throws LogicException{
		int id;
		try{
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		  id = enderecoDAO.inserir(enderecoDTO);
		}catch(Exception e){
			throw  new LogicException(e.getMessage());
		}
		return id;
	}
	public void atualizar (EnderecoDTO enderecoDTO) throws LogicException{
		try{
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		enderecoDAO.atualizar(enderecoDTO);
		}catch(Exception e){
			throw  new LogicException(e.getMessage());
		}
	}
	public void removerEndereco (int idEndereco) throws LogicException{
		try{
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		enderecoDAO.deletar(idEndereco);
		}catch(Exception e){
			throw  new LogicException(e.getMessage());
		}
	}
	public EnderecoDTO getEndereco(int idEndereco) throws LogicException{
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		try{
			
			enderecoDTO = enderecoDAO.buscarPorId(idEndereco);
			
		}catch(Exception e ){
			throw new LogicException(e.getMessage(), e);
		}
		return enderecoDTO;
	}
}
