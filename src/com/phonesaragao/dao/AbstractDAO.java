package com.phonesaragao.dao;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class AbstractDAO {
	
	public Connection conexao;
	
	public AbstractDAO(){
		conexao=getConnection();
	}

	public Connection getConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            return (Connection) DriverManager.getConnection(
          "jdbc:mysql://localhost/loja_eletronicos", "aluno", "aluno");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void fechar(){
		try {
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
