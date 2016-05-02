package br.si.es.sga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.si.es.sga.dto.EnderecoDTO;
import br.si.es.sga.exeception.PersistenciaException;
import br.si.es.sga.jdbc.ConexaoUtil;

import com.mysql.jdbc.Statement;

public class EnderecoDAO  {
	
	
	public int inserir (EnderecoDTO enderecoDTO) throws PersistenciaException{
		int chave = 0;
		try{
		
			Connection connection =  ConexaoUtil.getInstance().getConnection();
			
			String sql ="INSERT INTO ENDERECO( bairro, cidade, rua, cep, complemento, numero, estado)" +"VALUES(?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, enderecoDTO.getBairro());
			statement.setString(2, enderecoDTO.getCidade());
			statement.setString(3, enderecoDTO.getRua());
			statement.setInt(4, enderecoDTO.getCep());
			statement.setString(5, enderecoDTO.getComplemento());
			statement.setInt(6,enderecoDTO.getNumero());
			statement.setString(7,enderecoDTO.getEstado());

			statement.execute();
			 ResultSet result = statement.getGeneratedKeys();
			 if(result.next()){
				 chave = result.getInt(1);	
			 }
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(),e ) ;
		}
		return chave;
		
	}
	
	public void atualizar (EnderecoDTO enderecoDTO) throws PersistenciaException{
		try{
			Connection connection  =ConexaoUtil.getInstance().getConnection();
			String sql = "UPDATE ENDERECO " + "SET bairro =? ," + "cidade =?," + "rua =?, " + "cep =?, " + "complemento =?,"
			+ "numero =? ," + "estado =? " + 
			"WHERE idEndereco =?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, enderecoDTO.getBairro());
			preparedStatement.setString(2, enderecoDTO.getCidade());
			preparedStatement.setString(3, enderecoDTO.getRua());
			preparedStatement.setInt(4, enderecoDTO.getCep());
			preparedStatement.setString(5, enderecoDTO.getComplemento());
			preparedStatement.setInt(6, enderecoDTO.getNumero());
			preparedStatement.setString(7, enderecoDTO.getEstado());
			preparedStatement.setInt(8, enderecoDTO.getIdEndereco());
			
			preparedStatement.execute();
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);

		}
	}
	public void deletar (Integer idEndereco) throws PersistenciaException{
		try{
			Connection  connection = ConexaoUtil.getInstance().getConnection();
		
			String sql = "DELETE FROM ENDERECO WHERE idEndereco	 = ?";
			
			PreparedStatement Statement = connection.prepareStatement(sql);
			Statement.setInt(1,idEndereco);
			
			Statement.execute();
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
	}
	public EnderecoDTO buscarPorId(Integer idEndereco) throws PersistenciaException{
		EnderecoDTO enderecoDTO = null;
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();

			String sql = "SELECT * FROM ENDERECO WHERE idEndereco = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, idEndereco);

			ResultSet result = preparedStatement.executeQuery();
			if(result.next()){
				enderecoDTO = new EnderecoDTO();	
				enderecoDTO.setIdEndereco(result.getInt(1));
				enderecoDTO.setBairro(result.getString(2));
				enderecoDTO.setCidade(result.getString(3));
				enderecoDTO.setRua(result.getString(4));
				enderecoDTO.setCep(result.getInt(5));
				enderecoDTO.setComplemento(result.getString(6));
				enderecoDTO.setNumero(result.getInt(7));
				enderecoDTO.setEstado(result.getString(8));
				
			}
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(),e);
		}
		return enderecoDTO;
	}
}
