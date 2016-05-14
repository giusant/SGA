package br.si.es.sga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.si.es.sga.dto.AlunoHasModalidadeDTO;
import br.si.es.sga.dto.CaixaDTO;
import br.si.es.sga.exeception.PersistenciaException;
import br.si.es.sga.jdbc.ConexaoUtil;

public class AlunoHasModalidadeDAO implements GenericDAO<AlunoHasModalidadeDTO>{

	@Override
	public void inserir(AlunoHasModalidadeDTO alunoHasModalidadeDTO) throws PersistenciaException {
		try{

			Connection connection =  ConexaoUtil.getInstance().getConnection();

			String sql ="INSERT INTO aluno_has_modalidade (idAluno, idModalidade )" + " VALUES(?,?)";
			PreparedStatement Statement = connection.prepareStatement(sql);
			Statement.setInt(1, alunoHasModalidadeDTO.getIdAluno());
			Statement.setInt(2, alunoHasModalidadeDTO.getIdModalidade());


			Statement.execute();
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(),e ) ;
		}
		
	}

	@Override
	public void atualizar(AlunoHasModalidadeDTO alunoHasModalidadeDTO) throws PersistenciaException {
		try{

			Connection connection =  ConexaoUtil.getInstance().getConnection();

			String sql =  "UPDATE aluno_has_modalidade " + "SET idAluno =?," + "idModalidade =?,"
					 +
					"WHERE idCaixa = ? AND idModalidade =? ";
			PreparedStatement Statement = connection.prepareStatement(sql);
			Statement.setInt(1, alunoHasModalidadeDTO.getIdAluno());
			Statement.setInt(2, alunoHasModalidadeDTO.getIdModalidade());


			Statement.execute();
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(),e ) ;
		}
		
	}

	
	public void deletarRegistro(Integer idAluno) throws PersistenciaException {
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "DELETE FROM aluno_has_modalidade WHERE idAluno = "+ idAluno  +  " ;";
			
		
			PreparedStatement Statement = connection.prepareStatement(sql);
			Statement.execute();
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(),e);
		}
		
		
	}

	@Override
	public List<AlunoHasModalidadeDTO> listarTodos() throws PersistenciaException {
		List<AlunoHasModalidadeDTO> listaAlunoHasModalidade = new ArrayList<AlunoHasModalidadeDTO>();
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM aluno_has_modalidade";
			
			 PreparedStatement statement = connection.prepareStatement(sql);
			 ResultSet resultSet = statement.executeQuery();
			 
			 while(resultSet.next()){ 
				 AlunoHasModalidadeDTO alunoHasModalidadeDTO = new AlunoHasModalidadeDTO();
				 alunoHasModalidadeDTO.setIdAluno(resultSet.getInt("idAluno"));
				 alunoHasModalidadeDTO.setIdModalidade(resultSet.getInt("idModalidade"));
				
				 listaAlunoHasModalidade.add(alunoHasModalidadeDTO);
			 }
			 connection.close();

		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		return listaAlunoHasModalidade;

	}
	public List<AlunoHasModalidadeDTO> listarPorIdAluno(Integer idAluno) throws PersistenciaException {
		List<AlunoHasModalidadeDTO> listaAlunoHasModalidade = new ArrayList<AlunoHasModalidadeDTO>();
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM aluno_has_modalidade where idAluno = " + idAluno +" ";
			
			 PreparedStatement statement = connection.prepareStatement(sql);
			 ResultSet resultSet = statement.executeQuery();
			 
			 while(resultSet.next()){ 
				 AlunoHasModalidadeDTO alunoHasModalidadeDTO = new AlunoHasModalidadeDTO();
				 alunoHasModalidadeDTO.setIdAluno(resultSet.getInt("idAluno"));
				 alunoHasModalidadeDTO.setIdModalidade(resultSet.getInt("idModalidade"));
				
				 listaAlunoHasModalidade.add(alunoHasModalidadeDTO);
			 }
			 connection.close();

		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		return listaAlunoHasModalidade;

	}
	@Override
	public AlunoHasModalidadeDTO buscarPorId(Integer id) throws PersistenciaException {
		AlunoHasModalidadeDTO alunoHasModalidadeDTO = null;
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();

			String sql ="SELECT * FROM CAIXA WHERE idCaixa = ?";
			PreparedStatement statement =  connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()){
				alunoHasModalidadeDTO = new AlunoHasModalidadeDTO();
				alunoHasModalidadeDTO.setIdAluno(resultSet.getInt("idAluno"));
				alunoHasModalidadeDTO.setIdModalidade(resultSet.getInt("idModalidade"));

			}
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		return alunoHasModalidadeDTO;
	}

	@Override
	public void deletar(Integer id) throws PersistenciaException {
		// TODO Auto-generated method stub
		
	}

}
