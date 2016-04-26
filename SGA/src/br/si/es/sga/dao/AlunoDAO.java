package br.si.es.sga.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;







import br.edu.devmedia.jdbc.dto.PessoaDTO;
import br.si.es.sga.dto.AlunoDTO;
import br.si.es.sga.exeception.PersistenciaException;
import br.si.es.sga.jdbc.ConexaoUtil;

public class AlunoDAO implements GenericDAO<AlunoDTO> {

	@Override
	public void inserir(AlunoDTO alunoDTO) throws PersistenciaException {
		try{
			//int chaveEnd = insereEndereco(alunoDTO.getIdEndereco());
			Connection connection =  ConexaoUtil.getInstance().getConnection();
			
			String sql ="INSERT INTO ALUNO(nomeAluno, dataNasc, dataVencimento, foto, dataMatricula, "
					+ "telefoneAluno, modalidade_idModalidade, Endereco_idEndereco )" + " VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement Statement = connection.prepareStatement(sql);
			Statement.setString(1, alunoDTO.getNomeAluno());
			Statement.setDate(2, alunoDTO.getDataNasc());
			Statement.setDate(3,alunoDTO.getDataVencimento());
			Statement.setObject(4, alunoDTO.getFoto());
			Statement.setDate(5, alunoDTO.getDataMatricula());
			Statement.setString(6, alunoDTO.getTelefoneAluno());
			Statement.setInt(7, alunoDTO.getIdModalidade().getIdModalidade());
			Statement.setInt(8, alunoDTO.getIdEndereco().getIdEndereco());
			
			Statement.execute();
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(),e ) ;
		}
		
		
	}

	@Override
	public void atualizar(AlunoDTO alunoDTO) throws PersistenciaException {
		try{
			Connection connection =  ConexaoUtil.getInstance().getConnection();
			
			String sql =  "UPDATE ALUNO " + "SET nomeAluno =?," + "Telefone =?," + "Modalidade_idModalidade =? "
			 +
			"WHERE idAluno =?";
			
			PreparedStatement Statement = connection.prepareStatement(sql);
			Statement.setString(1, alunoDTO.getNomeAluno());
			Statement.setString(2, alunoDTO.getTelefoneAluno());
			Statement.setString(3, alunoDTO.getTelefoneAluno());
			Statement.setInt(4,alunoDTO.getIdModalidade().getIdModalidade());
				
			Statement.execute();
			connection.close();
			// atualiza agr o relacionamento endereço pessoa 
			//atualizaEndereco(alunoDTO.getEnderecoDTO());
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		
	}

	@Override
	public void deletar(Integer idAluno) throws PersistenciaException {
		try{
			Connection  connection = ConexaoUtil.getInstance().getConnection();
		
			String sql = "DELETE FROM ALUNO WHERE idAluno = ?";
			
			PreparedStatement Statement = connection.prepareStatement(sql);
			Statement.setInt(1,idAluno);
			
			Statement.execute();
			connection.close();
			
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
	
		
	}

	@Override
	public List<AlunoDTO> listarTodos() throws PersistenciaException {
		List<AlunoDTO> listaPessoas = new ArrayList<AlunoDTO>();
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM ALUNO";
			
			 PreparedStatement statement = connection.prepareStatement(sql);
			 ResultSet resultSet = statement.executeQuery();
			 
			 while(resultSet.next()){ 
				 AlunoDTO alunoDTO = new AlunoDTO();
				 alunoDTO.setIdAluno(resultSet.getInt("idAluno"));
				 alunoDTO.setNomeAluno(resultSet.getString("nomeAluno"));
				 alunoDTO.setDataNasc(resultSet.getDate("dataNasc"));
				 alunoDTO.setDataVencimento(resultSet.getDate("dataVencimento"));
				 alunoDTO.setFoto(resultSet.getBytes("foto"));
				 alunoDTO.setDataMatricula(resultSet.getDate("dataMatricula"));
				 alunoDTO.setIdModalidade(buscarModalidadePorID(resultSet.getInt("Modalidade_idModalidade")));
				 alunoDTO.setIdEndereco(buscarEnderecoPorID(resultSet.getInt("Endereco_idEndereco")));
				
				 listaPessoas.add(alunoDTO);
			 }
			 connection.close();

		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		return listaPessoas;
	}

	@Override
	public AlunoDTO buscarPorId(Integer id) throws PersistenciaException {
		 AlunoDTO alunoDTO = null;
			try{
				Connection connection = ConexaoUtil.getInstance().getConnection();
				
				String sql ="SELECT * FROM ALUNO WHERE idALUNO = ?";
				PreparedStatement statement =  connection.prepareStatement(sql);
				statement.setInt(1, id);
				ResultSet resultSet = statement.executeQuery();
				if(resultSet.next()){
					 alunoDTO = new AlunoDTO();
					 alunoDTO.setIdAluno(resultSet.getInt("idAluno"));
					 alunoDTO.setNomeAluno(resultSet.getString("nomeAluno"));
					 alunoDTO.setDataNasc(resultSet.getDate("dataNasc"));
					 alunoDTO.setDataVencimento(resultSet.getDate("dataVencimento"));
					 alunoDTO.setFoto(resultSet.getBytes("foto"));
					 alunoDTO.setIdModalidade(buscarModalidadePorID(resultSet.getInt("Modalidade_idModalidade")));
					 alunoDTO.setIdEndereco(buscarEnderecoPorID(resultSet.getInt("Endereco_idEndereco")));
				}
				connection.close();
			}catch(Exception e){
				e.printStackTrace();
				throw new PersistenciaException(e.getMessage(), e);
			}
			return alunoDTO;
	}

}
