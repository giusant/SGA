package br.si.es.sga.logic;

import java.util.List;




import br.si.es.sga.dao.AlunoDAO;
import br.si.es.sga.dao.ModalidadeDAO;
import br.si.es.sga.dto.AlunoDTO;
import br.si.es.sga.dto.ModalidadeDTO;
import br.si.es.sga.exeception.LogicException;

public class AlunoLogic {
	public void cadastrar (AlunoDTO alunoDTO) throws LogicException{
		try{
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.inserirParcial(alunoDTO);
		}catch(Exception e){
			throw  new LogicException(e.getMessage());
		}
	}
	public void atualizar (AlunoDTO alunoDTO) throws LogicException{
		try{
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.atualizar(alunoDTO);
		}catch(Exception e){
			throw  new LogicException(e.getMessage());
		}
	}
	public void atualizarDataVencimento (AlunoDTO alunoDTO) throws LogicException{
		try{
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.atualizarDataVencimento(alunoDTO);
		}catch(Exception e){
			throw  new LogicException(e.getMessage());
		}
	}
	public String [][] Listagem(List<Integer> idsPessoas) throws LogicException{
		int numCols = 2;
		String [][]listaRetorno = null;
	
		try{
			AlunoDAO alunoDAO = new AlunoDAO();
			List<AlunoDTO> lista = alunoDAO.listarTodos();
			listaRetorno = new String[lista.size()][numCols];
			for(int i = 0;i<lista.size();i++){ 
				AlunoDTO alunoDTO = lista.get(i);
				//EnderecoDTO enderecoDTO = pessoa.getEnderecoDTO();

				listaRetorno [i][0] = String.valueOf(alunoDTO.getIdAluno());
				idsPessoas.add(alunoDTO.getIdAluno());
				listaRetorno [i][1] = alunoDTO.getNomeAluno().toString();
			}
			
		}catch(Exception e){
			e.printStackTrace();
			throw  new LogicException(e.getMessage());
		}
		return listaRetorno;
	}
	
	public List<AlunoDTO> listarAluno() throws LogicException{
		List<AlunoDTO> lista = null;
		try{
			AlunoDAO alunoDAO = new AlunoDAO();
			lista = alunoDAO.listarTodos(); 
		}catch(Exception e){
			e.printStackTrace();
			throw new LogicException(e.getMessage(), e);
		}
		return lista;
	}
	public AlunoDTO getAluno(int idAluno) throws LogicException{
		AlunoDTO AlunoDTO = new AlunoDTO();
		AlunoDAO alunoDAO = new AlunoDAO();
		try{
			
			AlunoDTO = alunoDAO.buscarPorId(idAluno);
			
		}catch(Exception e ){
			throw new LogicException(e.getMessage(), e);
		}
		return AlunoDTO;
	}
	public String [][] ListagemPorNome(List<Integer> idsPessoas, String nome) throws LogicException{
		int numCols = 2;
		String [][]listaRetorno = null;
	
		try{
			AlunoDAO alunoDAO = new AlunoDAO();
			List<AlunoDTO> lista = alunoDAO.buscarAlunoPorNome(nome);
			listaRetorno = new String[lista.size()][numCols];
			for(int i = 0;i<lista.size();i++){ 
				AlunoDTO alunoDTO = lista.get(i);
				//EnderecoDTO enderecoDTO = pessoa.getEnderecoDTO();
				listaRetorno [i][0] = String.valueOf(alunoDTO.getIdAluno());
				idsPessoas.add(alunoDTO.getIdAluno());
				listaRetorno [i][1] = alunoDTO.getNomeAluno().toString();
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			throw  new LogicException(e.getMessage());
		}
		return listaRetorno;
	}
	
}
