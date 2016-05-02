package br.si.es.sga.logic;


import java.util.List;

import br.si.es.sga.dao.ModalidadeDAO;
import br.si.es.sga.dao.UsuarioDAO;
import br.si.es.sga.dto.ModalidadeDTO;
import br.si.es.sga.dto.UsuarioDTO;
import br.si.es.sga.exeception.LogicException;

public class UsuarioLogic {
	public void cadastrar(UsuarioDTO usuarioDTO) throws LogicException{
		try{
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.inserir(usuarioDTO);
			}catch(Exception e){
				throw  new LogicException(e.getMessage());
			}
	}
	
	public void atualizar(UsuarioDTO usuarioDTO) throws LogicException{
		try{
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.atualizar(usuarioDTO);
			}catch(Exception e){
				throw  new LogicException(e.getMessage());
			}
	}
	
	public void removerUsuario(String login, int idEndereco) throws LogicException{
		try{
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.deletar(login, idEndereco);
			}catch(Exception e){
				throw  new LogicException(e.getMessage());
			}
	}
	public List<UsuarioDTO> listarUsuario() throws LogicException{
		List<UsuarioDTO> lista = null;
		try{
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			lista = usuarioDAO.listarTodos(); 
		}catch(Exception e){
			e.printStackTrace();
			throw new LogicException(e.getMessage(), e);
		}
		return lista;
	}
	public UsuarioDTO getUsuario(String nomeUsuario) throws LogicException{
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		try{
			
			usuarioDTO = usuarioDAO.buscarPorNome(nomeUsuario);
			
		}catch(Exception e ){
			throw new LogicException(e.getMessage(), e);
		}
		return usuarioDTO;
	}
	public UsuarioDTO getUsuarioPorLogin(String login) throws LogicException{
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		try{
			
			usuarioDTO = usuarioDAO.buscarPorLogin(login);
			
		}catch(Exception e ){
			throw new LogicException(e.getMessage(), e);
		}
		return usuarioDTO;
	}
	
}
