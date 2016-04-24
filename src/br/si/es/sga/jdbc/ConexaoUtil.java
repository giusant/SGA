package br.si.es.sga.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class ConexaoUtil {
	
	private static ResourceBundle config;
	private static ConexaoUtil conexaoUtil;
	
	private ConexaoUtil(){
		config = ResourceBundle.getBundle("config");
	}
	
	public static ConexaoUtil getInstance(){
		if (conexaoUtil == null){
			conexaoUtil = new ConexaoUtil();
		}
		return conexaoUtil;
	}
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName(config.getString("br.si.es.sga.mysql"));
		return DriverManager.getConnection(config.getString("br.si.es.sga.conexao"),
				config.getString("br.si.es.sga.bd.usuario"),config.getString("br.si.es.sga.bd.senha"));
	}
	
	public static void main(String[] args) {
		try{
			System.out.println(getInstance().getConnection());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
