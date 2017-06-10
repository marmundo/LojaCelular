package com.phonesaragao.dao;

import java.sql.SQLException;
import java.util.Calendar;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ContatoDAO {

	public static void main(String[] args) throws SQLException {

		// conectando
        Connection con = (Connection) new AbstractDAO().getConnection();

        // cria um preparedStatement
        String sql = "insert into contatos" +
                " (nome,email,endereco,dataNascimento)" +
                " values (?,?,?,?)";
        PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

        // preenche os valores
        stmt.setString(1, "Caelum");
        stmt.setString(2, "contato@caelum.com.br");
        stmt.setString(3, "R. Vergueiro 3185 cj57");
        stmt.setDate(4, new java.sql.Date(
                Calendar.getInstance().getTimeInMillis()));

        // executa
        stmt.execute();
        stmt.close();

        System.out.println("Gravado!");

        con.close();
    }
}
