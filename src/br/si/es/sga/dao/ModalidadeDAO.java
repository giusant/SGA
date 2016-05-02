package br.si.es.sga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.si.es.sga.dto.ModalidadeDTO;
import br.si.es.sga.exeception.PersistenciaException;
import br.si.es.sga.jdbc.ConexaoUtil;

public class ModalidadeDAO implements GenericDAO<ModalidadeDTO>{

	@Override
	public void inserir(ModalidadeDTO modalidadeDTO) throws PersistenciaException {
		try{
			
			Connection connection =  ConexaoUtil.getInstance().getConnection();
			
			String sql ="INSERT INTO MODALIDADE(nomeModalidade, valor, descricao )" + " VALUES(?,?,?)";
			PreparedStatement Statement = connection.prepareStatement(sql);
			Statement.setString(1, modalidadeDTO.getNomeModalidade());
			Statement.setDouble(2, modalidadeDTO.getValor());
			Statement.setString(3,modalidadeDTO.getDescrição());
			
			Statement.execute();
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(),e ) ;
		}
		
	}

	@Override
	public void atualizar(ModalidadeDTO modalidadeDTO) throws PersistenciaException {
		try{

			Connection connection =  ConexaoUtil.getInstance().getConnection();

			String sql =  "UPDATE MODALIDADE " + "SET nomeModalidade =?," + "valor =?," + "descricao =? "
					 +
					"WHERE idModalidade =?";
			
			PreparedStatement Statement = connection.prepareStatement(sql);
			Statement.setString(1, modalidadeDTO.getNomeModalidade());
			Statement.setDouble(2, modalidadeDTO.getValor());
			Statement.setString(3,modalidadeDTO.getDescrição());
			Statement.setInt(4,modalidadeDTO.getIdModalidade());
			
			Statement.execute();
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(),e ) ;
		}


	}

	@Override
	public void deletar(Integer id) throws PersistenciaException {
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "DELETE FROM MODALIDADE WHERE idModalidade = ?";
			
			PreparedStatement Statement = connection.prepareStatement(sql);
			Statement.setInt(1,id);
			Statement.execute();
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(),e);
		}
	}

	@Override
	public List<ModalidadeDTO> listarTodos() throws PersistenciaException {
		List<ModalidadeDTO> listaModalidades = new ArrayList<ModalidadeDTO>();
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM MODALIDADE";
			
			 PreparedStatement statement = connection.prepareStatement(sql);
			 ResultSet resultSet = statement.executeQuery();
			 
			 while(resultSet.next()){ 
				 ModalidadeDTO modalidadeDTO = new ModalidadeDTO();
				 modalidadeDTO.setIdModalidade(resultSet.getInt("idModalidade"));
				 modalidadeDTO.setNomeModalidade(resultSet.getString("nomeModalidade"));
				 modalidadeDTO.setValor(resultSet.getDouble("valor"));
				 modalidadeDTO.setDescrição(resultSet.getString("descricao"));
				
				 listaModalidades.add(modalidadeDTO);
			 }
			 connection.close();

		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		return listaModalidades;
	
	}

	@Override
	public ModalidadeDTO buscarPorId(Integer id) throws PersistenciaException {
		 ModalidadeDTO modalidadeDTO = null;
			try{
				Connection connection = ConexaoUtil.getInstance().getConnection();
				
				String sql ="SELECT * FROM MODALIDADE WHERE idModalidade = ?";
				PreparedStatement statement =  connection.prepareStatement(sql);
				statement.setInt(1, id);
				ResultSet resultSet = statement.executeQuery();
				if(resultSet.next()){
					 modalidadeDTO = new ModalidadeDTO();
					 modalidadeDTO.setIdModalidade(resultSet.getInt("idModalidade"));
					 modalidadeDTO.setNomeModalidade(resultSet.getString("nomeModalidade"));
					 modalidadeDTO.setValor(resultSet.getDouble("valor"));
					 modalidadeDTO.setDescrição(resultSet.getString("descricao"));
					 
				}
				connection.close();
			}catch(Exception e){
				e.printStackTrace();
				throw new PersistenciaException(e.getMessage(), e);
			}
			return modalidadeDTO;
		
	}
	public ModalidadeDTO buscarPorNome(String nome) throws PersistenciaException {
		 ModalidadeDTO modalidadeDTO = null;
			try{
				Connection connection = ConexaoUtil.getInstance().getConnection();
				
				String sql ="SELECT * FROM MODALIDADE WHERE nomeModalidade = ?";
				PreparedStatement statement =  connection.prepareStatement(sql);
				statement.setString(1, nome);
				ResultSet resultSet = statement.executeQuery();
				if(resultSet.next()){
					 modalidadeDTO = new ModalidadeDTO();
					 modalidadeDTO.setIdModalidade(resultSet.getInt("idModalidade"));
					 modalidadeDTO.setNomeModalidade(resultSet.getString("nomeModalidade"));
					 modalidadeDTO.setValor(resultSet.getDouble("valor"));
					 modalidadeDTO.setDescrição(resultSet.getString("descricao"));
					 
				}
				connection.close();
			}catch(Exception e){
				e.printStackTrace();
				throw new PersistenciaException(e.getMessage(), e);
			}
			return modalidadeDTO;
		
	}

}
