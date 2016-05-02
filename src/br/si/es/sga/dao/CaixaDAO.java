package br.si.es.sga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.si.es.sga.dto.CaixaDTO;
import br.si.es.sga.dto.ModalidadeDTO;
import br.si.es.sga.exeception.PersistenciaException;
import br.si.es.sga.jdbc.ConexaoUtil;

public class CaixaDAO implements GenericDAO<CaixaDTO> {

	@Override
	public void inserir(CaixaDTO caixaDTO) throws PersistenciaException {
	try{
			
			Connection connection =  ConexaoUtil.getInstance().getConnection();
			
			String sql ="INSERT INTO CAIXA(valorDiario, valorTotal )" + " VALUES(?,?)";
			PreparedStatement Statement = connection.prepareStatement(sql);
			Statement.setDouble(1, caixaDTO.getValorDiario());
			Statement.setDouble(2, caixaDTO.getValorTotal());
			
			
			Statement.execute();
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(),e ) ;
		}
	}

	@Override
	public void atualizar(CaixaDTO caixaDTO) throws PersistenciaException {
		try{

			Connection connection =  ConexaoUtil.getInstance().getConnection();

			String sql =  "UPDATE CAIXA " + "SET valorDiario =?," + "valorTotal =?,"
					 +
					"WHERE idCaixa = ? ";
			
			PreparedStatement Statement = connection.prepareStatement(sql);
			Statement.setDouble(1, caixaDTO.getValorDiario());
			Statement.setDouble(2, caixaDTO.getValorTotal());

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
			String sql = "DELETE FROM CAIXA";
			
			PreparedStatement Statement = connection.prepareStatement(sql);
			Statement.execute();
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(),e);
		}
		
	}

	@Override
	public List<CaixaDTO> listarTodos() throws PersistenciaException {
		List<CaixaDTO> listaCaixas = new ArrayList<CaixaDTO>();
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM CAIXA";
			
			 PreparedStatement statement = connection.prepareStatement(sql);
			 ResultSet resultSet = statement.executeQuery();
			 
			 while(resultSet.next()){ 
				 CaixaDTO caixaDTO = new CaixaDTO();
				 caixaDTO.setIdCaixa(resultSet.getInt("idCaixa"));
				 caixaDTO.setValorDiario(resultSet.getDouble("valorDiario"));
				 caixaDTO.setValorTotal(resultSet.getDouble("valorTotal"));
				
				 listaCaixas.add(caixaDTO);
			 }
			 connection.close();

		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		return listaCaixas;

	}

	@Override
	public CaixaDTO buscarPorId(Integer id) throws PersistenciaException {
		CaixaDTO caixaDTO = null;
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();

			String sql ="SELECT * FROM CAIXA WHERE idCaixa = ?";
			PreparedStatement statement =  connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()){
				caixaDTO = new CaixaDTO();
				caixaDTO.setIdCaixa(resultSet.getInt("idCaixa"));
				caixaDTO.setValorDiario(resultSet.getDouble("valorDiario"));
				caixaDTO.setValorTotal(resultSet.getDouble("valor"));

			}
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		return caixaDTO;
	}

}
