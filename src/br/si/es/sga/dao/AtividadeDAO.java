package br.si.es.sga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import br.si.es.sga.dto.AtividadeDTO;
import br.si.es.sga.exeception.PersistenciaException;
import br.si.es.sga.jdbc.ConexaoUtil;

public class AtividadeDAO implements GenericDAO<AtividadeDTO> {
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	@Override
	public void inserir(AtividadeDTO atividadeDTO) throws PersistenciaException {
		try{
			//int chaveEnd = enderecoDAO.inserir(alunoDTO.getIdEndereco());
			Connection connection =  ConexaoUtil.getInstance().getConnection();
			
			String sql ="INSERT INTO ATIVIDADE (tipo, referencia, valor, data,  "
					+ "login )" + " VALUES(?,?,?,?,?)";
			PreparedStatement Statement = connection.prepareStatement(sql);
			Statement.setString( 1,atividadeDTO.getTipo());
			Statement.setString(2, atividadeDTO.getReferencia());
			Statement.setDouble(3,atividadeDTO.getValor());
			Statement.setDate(4, atividadeDTO.getData());
			Statement.setString(5, atividadeDTO.getUsuario().getLogin());
			
			
			Statement.execute();
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(),e ) ;
		}
	}

	@Override
	public void atualizar(AtividadeDTO obj) throws PersistenciaException {
		
	}

	@Override
	public void deletar(Integer id) throws PersistenciaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AtividadeDTO> listarTodos() throws PersistenciaException {
		List<AtividadeDTO> listaAtividades = new ArrayList<AtividadeDTO>();
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM ATIVIDADE";
			
			 PreparedStatement statement = connection.prepareStatement(sql);
			 ResultSet resultSet = statement.executeQuery();
			 
			 while(resultSet.next()){ 
				 AtividadeDTO atividadeDTO = new AtividadeDTO();
				 atividadeDTO.setIdAtividade(resultSet.getInt("idAtividade"));
				 atividadeDTO.setTipo(resultSet.getString("tipo"));
				 atividadeDTO.setReferencia(resultSet.getString("referencia"));
				 atividadeDTO.setValor(resultSet.getDouble("valor"));
				 atividadeDTO.setData(resultSet.getDate("data"));
				 atividadeDTO.setUsuario(usuarioDAO.buscarPorId(resultSet.getString("login")));
				
				 listaAtividades.add(atividadeDTO);
			 }
			 connection.close();

		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		return listaAtividades;
	}

	@Override
	public AtividadeDTO buscarPorId(Integer id) throws PersistenciaException {
		 AtividadeDTO atividadeDTO = null;
			try{
				Connection connection = ConexaoUtil.getInstance().getConnection();
				
				String sql ="SELECT * FROM ATIVIDADE WHERE idAtividade = ?";
				PreparedStatement statement =  connection.prepareStatement(sql);
				statement.setInt(1, id);
				ResultSet resultSet = statement.executeQuery();
				if(resultSet.next()){
					 atividadeDTO = new AtividadeDTO();
					 atividadeDTO.setIdAtividade(resultSet.getInt("idAtividade"));
					 atividadeDTO.setTipo(resultSet.getString("tipo"));
					 atividadeDTO.setReferencia(resultSet.getString("referencia"));
					 atividadeDTO.setValor(resultSet.getDouble("valor"));
					 atividadeDTO.setData(resultSet.getDate("data"));
					 atividadeDTO.setUsuario(usuarioDAO.buscarPorId(resultSet.getString("login")));
					 
				}
				connection.close();
			}catch(Exception e){
				e.printStackTrace();
				throw new PersistenciaException(e.getMessage(), e);
			}
			return atividadeDTO;
	}

}
