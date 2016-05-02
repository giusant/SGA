package br.si.es.sga.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.si.es.sga.dto.AlunoDTO;
import br.si.es.sga.dto.EnderecoDTO;
import br.si.es.sga.exeception.PersistenciaException;
import br.si.es.sga.jdbc.ConexaoUtil;

public class AlunoDAO implements GenericDAO<AlunoDTO> {
	ModalidadeDAO modalidadeDAO = new ModalidadeDAO();
	EnderecoDAO enderecoDAO = new EnderecoDAO();
	//private DateFormat dateFormtBD = new SimpleDateFormat("YYYY/MM/DD");
	@Override
	public void inserir(AlunoDTO alunoDTO) throws PersistenciaException {
		try{
			int chaveEnd = enderecoDAO.inserir(alunoDTO.getIdEndereco());
			Connection connection =  ConexaoUtil.getInstance().getConnection();
			
			String sql ="INSERT INTO ALUNO(nomeAluno, dataNasc, dataVencimento, foto, dataMatricula, "
					+ "telefoneAluno, modalidade_idModalidade, Endereco_idEndereco, sexo )" + " VALUES(?,?,?,?,?,?,?,?,?)";
			PreparedStatement Statement = connection.prepareStatement(sql);
			Statement.setString(1, alunoDTO.getNomeAluno());
			Statement.setDate(2, new Date(alunoDTO.getDataNasc().getTime()));
			Statement.setDate(3,(Date) alunoDTO.getDataVencimento());
			Statement.setObject(4, alunoDTO.getFoto());
			Statement.setDate(5, (Date) alunoDTO.getDataMatricula());
			Statement.setString(6, alunoDTO.getTelefoneAluno());
			Statement.setInt(7, alunoDTO.getIdModalidade().getIdModalidade());
			Statement.setInt(8, chaveEnd);
			Statement.setString(9, alunoDTO.getSexo());
			
			Statement.execute();
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(),e ) ;
		}
		
		
	}
	public void inserirParcial(AlunoDTO alunoDTO) throws PersistenciaException {
		try{
			int chaveEnd = enderecoDAO.inserir(alunoDTO.getIdEndereco());
			Connection connection =  ConexaoUtil.getInstance().getConnection();
			
			String sql ="INSERT INTO ALUNO(nomeAluno, dataNasc, dataMatricula, "
					+ "telefoneAluno, Endereco_idEndereco, sexo )" + " VALUES(?,?,?,?,?,?)";
			PreparedStatement Statement = connection.prepareStatement(sql);
			Statement.setString(1, alunoDTO.getNomeAluno());
			Statement.setDate(2,  new Date(alunoDTO.getDataNasc().getTime()));
			//Statement.setDate(3,(Date) alunoDTO.getDataVencimento());
			//Statement.setObject(4, alunoDTO.getFoto());
			Statement.setDate(3, new Date( alunoDTO.getDataMatricula().getTime()));
			Statement.setString(4, alunoDTO.getTelefoneAluno());
			//Statement.setInt(7, alunoDTO.getIdModalidade().getIdModalidade());
			Statement.setInt(5, chaveEnd);
			Statement.setString(6, alunoDTO.getSexo());
			
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
			
			String sql =  "UPDATE ALUNO " + "SET nomeAluno =?," + "telefoneAluno =?," 
			 + "sexo = ?, " +"dataNasc = ? " + 
			"WHERE idAluno =?";
			
			PreparedStatement Statement = connection.prepareStatement(sql);
			Statement.setString(1, alunoDTO.getNomeAluno());
			Statement.setString(2, alunoDTO.getTelefoneAluno());
			Statement.setString(3, alunoDTO.getSexo());
			Statement.setDate(4, new Date( alunoDTO.getDataNasc().getTime()));
			Statement.setInt(5, alunoDTO.getIdAluno());
			//Statement.setInt(5,alunoDTO.getIdModalidade().getIdModalidade());
				
			Statement.execute();
			connection.close();
			// atualiza agr o relacionamento endereço pessoa 
			enderecoDAO.atualizar(alunoDTO.getIdEndereco());
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
		List<AlunoDTO> listaAluno = new ArrayList<AlunoDTO>();
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM ALUNO";
			
			 PreparedStatement statement = connection.prepareStatement(sql);
			 ResultSet resultSet = statement.executeQuery();
			 
			 while(resultSet.next()){ 
				 AlunoDTO alunoDTO = new AlunoDTO();
				 alunoDTO.setIdAluno(resultSet.getInt("idAluno"));
				 alunoDTO.setNomeAluno(resultSet.getString("nomeAluno"));
			//	 alunoDTO.setDataNasc(resultSet.getDate("dataNasc"));
				 alunoDTO.setDataVencimento(resultSet.getDate("dataVencimento"));
				 alunoDTO.setFoto(resultSet.getBytes("foto"));
			//	alunoDTO.setDataMatricula(resultSet.getDate("dataMatricula"));
				 alunoDTO.setIdModalidade(modalidadeDAO.buscarPorId(resultSet.getInt("Modalidade_idModalidade")));
				 alunoDTO.setIdEndereco(enderecoDAO.buscarPorId(resultSet.getInt("Endereco_idEndereco")));
				 alunoDTO.setSexo(resultSet.getString("sexo"));
				 alunoDTO.setTelefoneAluno(resultSet.getString("telefoneAluno"));
				 
				 listaAluno.add(alunoDTO);
			 }
			 connection.close();

		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		return listaAluno;
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
					 alunoDTO.setIdModalidade(modalidadeDAO.buscarPorId(resultSet.getInt("Modalidade_idModalidade")));
					 alunoDTO.setIdEndereco(enderecoDAO.buscarPorId(resultSet.getInt("Endereco_idEndereco")));
					 alunoDTO.setSexo(resultSet.getString("sexo"));
					 alunoDTO.setTelefoneAluno(resultSet.getString("telefoneAluno"));
				}
				connection.close();
			}catch(Exception e){
				e.printStackTrace();
				throw new PersistenciaException(e.getMessage(), e);
			}
			return alunoDTO;
	}
	public List<AlunoDTO> buscarAlunoPorNome(String nome) throws PersistenciaException {
		List<AlunoDTO> listaAluno = new ArrayList<AlunoDTO>();
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM ALUNO WHERE nomeAluno LIKE '%" + nome + "%' ";
			
			 PreparedStatement statement = connection.prepareStatement(sql);
			 ResultSet resultSet = statement.executeQuery();
			 
			 while(resultSet.next()){ 
				 AlunoDTO alunoDTO = new AlunoDTO();
				 alunoDTO.setIdAluno(resultSet.getInt("idAluno"));
				 alunoDTO.setNomeAluno(resultSet.getString("nomeAluno"));
				 alunoDTO.setDataNasc(resultSet.getDate("dataNasc"));
				 alunoDTO.setDataVencimento(resultSet.getDate("dataVencimento"));
				 alunoDTO.setFoto(resultSet.getBytes("foto"));
			//	alunoDTO.setDataMatricula(resultSet.getDate("dataMatricula"));
				 alunoDTO.setIdModalidade(modalidadeDAO.buscarPorId(resultSet.getInt("Modalidade_idModalidade")));
				 alunoDTO.setIdEndereco(enderecoDAO.buscarPorId(resultSet.getInt("Endereco_idEndereco")));
				 alunoDTO.setTelefoneAluno(resultSet.getString("telefoneAluno"));
				 
				 alunoDTO.setSexo(resultSet.getString("sexo"));
				 
				 listaAluno.add(alunoDTO);
			 }
			 connection.close();

		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		return listaAluno;
	}


}
