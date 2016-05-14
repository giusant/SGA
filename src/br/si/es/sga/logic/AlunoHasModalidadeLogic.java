package br.si.es.sga.logic;

import java.util.List;

import br.si.es.sga.dao.AlunoDAO;
import br.si.es.sga.dao.AlunoHasModalidadeDAO;
import br.si.es.sga.dao.UsuarioDAO;
import br.si.es.sga.dto.AlunoDTO;
import br.si.es.sga.dto.AlunoHasModalidadeDTO;
import br.si.es.sga.dto.UsuarioDTO;
import br.si.es.sga.exeception.LogicException;

public class AlunoHasModalidadeLogic {
	public void cadastrar (AlunoHasModalidadeDTO alunoHasModalidadeDTO) throws LogicException{
		try{
			AlunoHasModalidadeDAO alunoHasModalidadeDAO = new AlunoHasModalidadeDAO();
			alunoHasModalidadeDAO.inserir(alunoHasModalidadeDTO);
		}catch(Exception e){
			throw  new LogicException(e.getMessage());
		}
	}
	public void atualizar (AlunoHasModalidadeDTO alunoHasModalidadeDTO) throws LogicException{
		try{
			AlunoHasModalidadeDAO alunoHasModalidadeDAO = new AlunoHasModalidadeDAO();
			alunoHasModalidadeDAO.atualizar(alunoHasModalidadeDTO);
		}catch(Exception e){
			throw  new LogicException(e.getMessage());
		}
	}
	public void deletar (Integer idAluno) throws LogicException{
		try{
			AlunoHasModalidadeDAO alunoHasModalidadeDAO = new AlunoHasModalidadeDAO();
			alunoHasModalidadeDAO.deletarRegistro(idAluno);
		}catch(Exception e){
			throw  new LogicException(e.getMessage());
		}
	}	
	public AlunoHasModalidadeDTO getAlunoHasModalidade(Integer idAluno) throws LogicException{
		AlunoHasModalidadeDTO alunoHasModalidadeDTO = new AlunoHasModalidadeDTO();
		AlunoHasModalidadeDAO alunoHasModalidadeDAO = new AlunoHasModalidadeDAO();
		try{

			alunoHasModalidadeDTO = alunoHasModalidadeDAO.buscarPorId(idAluno);

		}catch(Exception e ){
			throw new LogicException(e.getMessage(), e);
		}
		return alunoHasModalidadeDTO;
	}

	public List<AlunoHasModalidadeDTO> listarAlunoHasModalidade(Integer idAluno) throws LogicException{
		List<AlunoHasModalidadeDTO> lista = null;
		try{
			AlunoHasModalidadeDAO alunoHasModalidadeDAO = new AlunoHasModalidadeDAO();
			lista = alunoHasModalidadeDAO.listarPorIdAluno(idAluno); 
		}catch(Exception e){
			e.printStackTrace();
			throw new LogicException(e.getMessage(), e);
		}
		return lista;
	}
}