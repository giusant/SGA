package br.si.es.sga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import br.si.es.sga.dto.ModalidadeDTO;
import br.si.es.sga.exeception.PersistenciaException;
import br.si.es.sga.jdbc.ConexaoUtil;

public class ModalidadeDAO implements GenericDAO<ModalidadeDTO>{

	@Override
	public void inserir(ModalidadeDTO modalidadeDTO) throws PersistenciaException {
		try{
			
			Connection connection =  ConexaoUtil.getInstance().getConnection();
			
			String sql ="INSERT INTO MODALIDADE(nomeModalidade, valor, descrição )" + " VALUES(?,?,?)";
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

			String sql =  "UPDATE MODALIDADE " + "SET nomeModalidade =?," + "valor =?," + "descrição =? "
					 +
					"WHERE idModalidade =?";
			
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
	public void deletar(Integer id) throws PersistenciaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ModalidadeDTO> listarTodos() throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModalidadeDTO buscarPorId(Integer id) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

}
