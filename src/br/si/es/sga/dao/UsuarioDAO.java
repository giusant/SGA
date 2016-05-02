package br.si.es.sga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;











import br.si.es.sga.dto.AlunoDTO;
import br.si.es.sga.dto.ModalidadeDTO;
import br.si.es.sga.dto.UsuarioDTO;
import br.si.es.sga.exeception.PersistenciaException;
import br.si.es.sga.jdbc.ConexaoUtil;

public class UsuarioDAO implements GenericDAO<UsuarioDTO>{
	EnderecoDAO enderecoDAO =  new EnderecoDAO();
	@Override
	public void inserir(UsuarioDTO usuarioDTO) throws PersistenciaException {
		try{
			int chaveEnd = enderecoDAO.inserir(usuarioDTO.getEndereco());
			Connection connection =  ConexaoUtil.getInstance().getConnection();
			
			String sql ="INSERT INTO USUARIO(nomeUsuario , isGerente, login, senha, telefoneUsuario, "
					+ " Endereco_idEndereco )" + " VALUES(?,?,?,?,?,?)";
			PreparedStatement Statement = connection.prepareStatement(sql);
			Statement.setString(1, usuarioDTO.getNomeUsuario());
			Statement.setBoolean(2, usuarioDTO.isGerente());
			Statement.setString(3,usuarioDTO.getLogin());
			Statement.setString(4, usuarioDTO.getSenha());
			Statement.setString(5, usuarioDTO.getTelefoneUsuario());
			Statement.setInt(6, chaveEnd);
		
			
			Statement.execute();
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(),e ) ;
		}
		
	}

	@Override
	public void atualizar(UsuarioDTO usuarioDTO) throws PersistenciaException {
		try{
			Connection connection =  ConexaoUtil.getInstance().getConnection();
			
			String sql =  "UPDATE USUARIO " + "SET nomeUsuario =?, " + "isGerente = ?, " + "senha =?, " + " telefoneUsuario =? "
			  + 
			" WHERE login =?";
			
			PreparedStatement Statement = connection.prepareStatement(sql);
			Statement.setString(1, usuarioDTO.getNomeUsuario());
			Statement.setBoolean(2, usuarioDTO.isGerente());
			Statement.setString(3, usuarioDTO.getSenha());
			Statement.setString(4,usuarioDTO.getTelefoneUsuario());
			Statement.setString(5,usuarioDTO.getLogin());
				
			Statement.execute();
			connection.close();
			// atualiza agr o relacionamento endereço pessoa 
			enderecoDAO.atualizar(usuarioDTO.getEndereco());
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
	
		
	}

	public void deletar(String id, int idEndereco) throws PersistenciaException {
		try{
			Connection  connection = ConexaoUtil.getInstance().getConnection();
		
			String sql = "DELETE FROM USUARIO WHERE login = ?";
			
			PreparedStatement Statement = connection.prepareStatement(sql);
			Statement.setString(1,id);
			
			Statement.execute();
			connection.close();
			//Apagando Endereço releacionado
			enderecoDAO.deletar(idEndereco);
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		
	}

	@Override
	public List<UsuarioDTO> listarTodos() throws PersistenciaException {
		List<UsuarioDTO> listaUsuarios = new ArrayList<UsuarioDTO>();
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM USUARIO";
			
			 PreparedStatement statement = connection.prepareStatement(sql);
			 ResultSet resultSet = statement.executeQuery();
			 
			 while(resultSet.next()){ 
				 UsuarioDTO usuarioDTO = new UsuarioDTO();
				 usuarioDTO.setLogin(resultSet.getString("login"));
				 usuarioDTO.setNomeUsuario(resultSet.getString("nomeUsuario"));
				 usuarioDTO.setGerente(resultSet.getBoolean("isGerente"));
				 usuarioDTO.setSenha(resultSet.getString("senha"));
				 usuarioDTO.setTelefoneUsuario(resultSet.getString("telefoneUsuario"));
				 usuarioDTO.setEndereco(enderecoDAO.buscarPorId(resultSet.getInt("Endereco_idEndereco")));
				
				 listaUsuarios.add(usuarioDTO);
			 }
			 connection.close();

		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		return listaUsuarios;
	}

	public UsuarioDTO buscarPorId(String id) throws PersistenciaException {
		 UsuarioDTO usuarioDTO = null;
			try{
				Connection connection = ConexaoUtil.getInstance().getConnection();
				
				String sql ="SELECT * FROM USUARIO WHERE login = ?";
				PreparedStatement statement =  connection.prepareStatement(sql);
				statement.setString(1, id);
				ResultSet resultSet = statement.executeQuery();
				if(resultSet.next()){
					 usuarioDTO = new UsuarioDTO();
					 usuarioDTO.setLogin(resultSet.getString("login"));
					 usuarioDTO.setNomeUsuario(resultSet.getString("nomeUsuario"));
					 usuarioDTO.setGerente(resultSet.getBoolean("isGerente"));
					 usuarioDTO.setSenha(resultSet.getString("senha"));
					 usuarioDTO.setTelefoneUsuario(resultSet.getString("telefoneUsuario"));
					 usuarioDTO.setEndereco(enderecoDAO.buscarPorId(resultSet.getInt("Endereco_idEndereco")));
				}
				connection.close();
			}catch(Exception e){
				e.printStackTrace();
				throw new PersistenciaException(e.getMessage(), e);
			}
			return usuarioDTO;

	}
	public UsuarioDTO buscarPorNome(String nome) throws PersistenciaException {
		 UsuarioDTO usuarioDTO = null;
			try{
				Connection connection = ConexaoUtil.getInstance().getConnection();
				
				String sql ="SELECT * FROM Usuario WHERE nomeUsuario = ?";
				PreparedStatement statement =  connection.prepareStatement(sql);
				statement.setString(1, nome);
				ResultSet resultSet = statement.executeQuery();
				if(resultSet.next()){
					 usuarioDTO = new UsuarioDTO();
					 usuarioDTO.setLogin(resultSet.getString("login"));
					 usuarioDTO.setNomeUsuario(resultSet.getString("nomeUsuario"));
					 usuarioDTO.setGerente(resultSet.getBoolean("isGerente"));
					 usuarioDTO.setSenha(resultSet.getString("senha"));
					 usuarioDTO.setTelefoneUsuario(resultSet.getString("telefoneUsuario"));
					 usuarioDTO.setEndereco(enderecoDAO.buscarPorId(resultSet.getInt("Endereco_idEndereco")));
					 
				}
				connection.close();
			}catch(Exception e){
				e.printStackTrace();
				throw new PersistenciaException(e.getMessage(), e);
			}
			return usuarioDTO;
		
	}

	@Override
	public void deletar(Integer id) throws PersistenciaException {
		// TODO Auto-generated method stub
		
	}

	public UsuarioDTO buscarPorLogin(String login) throws PersistenciaException {
		UsuarioDTO usuarioDTO = null;
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql ="SELECT * FROM Usuario WHERE login = ?";
			PreparedStatement statement =  connection.prepareStatement(sql);
			statement.setString(1, login);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()){
				 usuarioDTO = new UsuarioDTO();
				 usuarioDTO.setLogin(resultSet.getString("login"));
				 usuarioDTO.setNomeUsuario(resultSet.getString("nomeUsuario"));
				 usuarioDTO.setGerente(resultSet.getBoolean("isGerente"));
				 usuarioDTO.setSenha(resultSet.getString("senha"));
				 usuarioDTO.setTelefoneUsuario(resultSet.getString("telefoneUsuario"));
				 usuarioDTO.setEndereco(enderecoDAO.buscarPorId(resultSet.getInt("Endereco_idEndereco")));
				 
			}
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		return usuarioDTO;	}

	@Override
	public UsuarioDTO buscarPorId(Integer id) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

}
