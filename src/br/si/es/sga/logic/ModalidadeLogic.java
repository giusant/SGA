package br.si.es.sga.logic;

import java.util.List;






import org.w3c.dom.ls.LSInput;

import br.si.es.sga.dao.AlunoDAO;
import br.si.es.sga.dao.ModalidadeDAO;
import br.si.es.sga.dto.AlunoDTO;
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
	public String [][] Listagem(List<Integer> idsModalidades) throws LogicException{
		int numCols = 3;
		String [][]listaRetorno = null;
	
		try{
			ModalidadeDAO modalidadeDAO = new ModalidadeDAO();
			List<ModalidadeDTO> lista = modalidadeDAO.listarTodos();
			listaRetorno = new String[lista.size()][numCols];
			for(int i = 0;i<lista.size();i++){ 
				ModalidadeDTO modalidadeDTO = lista.get(i);
				//EnderecoDTO enderecoDTO = pessoa.getEnderecoDTO();

				listaRetorno [i][0] = String.valueOf(modalidadeDTO.getIdModalidade());
				idsModalidades.add(modalidadeDTO.getIdModalidade());
				listaRetorno [i][1] = modalidadeDTO.getNomeModalidade().toString();
				listaRetorno[i][2] = String.valueOf(modalidadeDTO.getValor());
			}
			
		}catch(Exception e){
			e.printStackTrace();
			throw  new LogicException(e.getMessage());
		}
		return listaRetorno;
	}
	public ModalidadeDTO getModalidade(int idModalidade) throws LogicException{
		ModalidadeDTO modalidadeDTO = new ModalidadeDTO();
		ModalidadeDAO modalidadeDAO = new ModalidadeDAO();
		try{
			
			modalidadeDTO = modalidadeDAO.buscarPorId(idModalidade);
			
		}catch(Exception e ){
			throw new LogicException(e.getMessage(), e);
		}
		return modalidadeDTO;
	}
	
}
