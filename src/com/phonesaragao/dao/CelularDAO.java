package com.phonesaragao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.phonesaragao.dao.AbstractDAO;
import com.phonesaragao.modelo.Celular;

public class CelularDAO extends AbstractDAO {

	public CelularDAO() {
		super();

	}

	public boolean inserir(Celular celular) throws SQLException {
		String sql = "INSERT INTO celular(marca,modelo,memoria_ram,processador,velocidade_processador,preco,tamanho_tela,memoria_armazenamento,resolucao_camera_frontal,resolucao_camera_traseira) values (?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);

		// preenche os valores
		
		stmt.setString(1, celular.getMarca());
		stmt.setString(2, celular.getModelo());
		stmt.setDouble(3, celular.getMemoriaRam());
		stmt.setString(4, celular.getProcessador());
		stmt.setDouble(5, celular.getVelocidadeProcessador());
		stmt.setDouble(6, celular.getPreco());
		stmt.setDouble(7, celular.getTamanhoTela());
		stmt.setDouble(8, celular.getMemoriaArmazenamento());
		stmt.setDouble(9, celular.getResolucaoCameraFrontal());
		stmt.setDouble(10, celular.getResolucaoCameraTraseira());
		// executa
		stmt.execute();
		stmt.close();

		return true;

	}

	public List<Celular> listarTodosCelulares() throws SQLException {

		PreparedStatement stmt = null;
		List<Celular> cs = new ArrayList<Celular>();
		ResultSet rs;

		String celularQuery = "select * from celular as c";
		stmt = (PreparedStatement) conexao.prepareStatement(celularQuery);
		rs = stmt.executeQuery();

		while (rs.next()) {
			Celular c = new Celular();
			c.setMarca(rs.getString(2));
			c.setModelo(rs.getString(3));
			c.setMemoriaRam(rs.getDouble(4));
			c.setProcessador(rs.getString(5));
			c.setPreco(rs.getDouble(6));
			c.setTamanhoTela(rs.getInt(7));
			c.setMemoriaArmazenamento(rs.getInt(8));
			c.setResolucaoCameraFrontal(rs.getDouble(9));
			c.setResolucaoCameraTraseira(rs.getDouble(10));
			cs.add(c);
		}
		return cs;
	}
}
