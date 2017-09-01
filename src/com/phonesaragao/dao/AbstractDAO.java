package com.phonesaragao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbstractDAO {

	protected Connection conexao;
	
	public AbstractDAO() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/eletronicos?useSSL=true", "root", "123456");
		} catch (SQLException e) {
			System.out.println("\nNão foi possível conectar ao banco: \n\t" + e);
		}
	}
	
	public void close() {
		try {
			conexao.close();
		} catch (SQLException e) {
			System.out.println("\nErro ao finalizar conexão com o banco de dados \n\t" + e);
		}
	}

}
