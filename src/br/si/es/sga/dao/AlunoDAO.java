package br.si.es.sga.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;



import br.si.es.sga.dto.AlunoDTO;
import br.si.es.sga.exeception.PersistenciaException;
import br.si.es.sga.jdbc.ConexaoUtil;

public class AlunoDAO implements GenericDAO<AlunoDTO> {

	@Override
	public void inserir(AlunoDTO alunoDTO) throws PersistenciaException {
		try{
			//int chaveEnd = insereEndereco(alunoDTO.getIdEndereco());
			Connection connection =  ConexaoUtil.getInstance().getConnection();
			
			String sql ="INSERT INTO TB_ALUNO(nomeAluno, dataNasc, dataVencimento, foto, dataMatricula, "
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Integer id) throws PersistenciaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AlunoDTO> listarTodos() throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlunoDTO buscarPorId(Integer id) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

}
