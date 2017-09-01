package com.phonesaragao.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.phonesaragao.modelo.Celular;

public class CelularDAO extends AbstractDAO {

	public CelularDAO() {
		super();
	}

	public boolean cadastrarCelular(Celular celular) {

		int cadastrado = 0;

		PreparedStatement comando;
		try {
			comando = conexao.prepareStatement("INSERT INTO celular (marca, modelo, ram, processador, "
					+ "velocidade_processador, preco, tela, armazenamento, camera_frontal, camera_traseira, url_img) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			comando.setString(1, celular.getMarca());
			comando.setString(2, celular.getModelo());
			comando.setDouble(3, celular.getRam());
			comando.setString(4, celular.getProcessador());
			comando.setDouble(5, celular.getVelocidade_processador());
			comando.setDouble(6, celular.getPreco());
			comando.setDouble(7, celular.getTela());
			comando.setInt(8, celular.getArmazenamento());
			comando.setDouble(9, celular.getCamera_frontal());
			comando.setDouble(10, celular.getCamera_traseira());
			comando.setString(11, celular.getUrl_img());

			cadastrado = comando.executeUpdate();

		} catch (SQLException e) {
			cadastrado = 0;
			System.out.println("\nErro: " + e);
		}

		return cadastrado == 1;

	}

	public boolean removerCelular(Celular celular) {

		int removido = 0;

		PreparedStatement comando;
		try {
			comando = conexao.prepareStatement("DELETE FROM celular WHERE marca = ? AND modelo = ?");

			comando.setString(1, celular.getMarca());
			comando.setString(2, celular.getModelo());

			removido = comando.executeUpdate();

		} catch (SQLException e) {
			System.out.println("\nErro: " + e);
		}

		return removido == 1;

	}

	public boolean atualizarCelular(Celular celular, double novoPreco) {

		int atualizado;

		try {
			PreparedStatement comando = conexao
					.prepareStatement("UPDATE celular SET preco = ? WHERE marca = ? AND modelo = ?");

			comando.setDouble(1, novoPreco);
			comando.setString(2, celular.getMarca());
			comando.setString(3, celular.getModelo());

			atualizado = comando.executeUpdate();

		} catch (SQLException e) {
			atualizado = 0;
			System.out.println("\nErro: " + e);
		}

		return atualizado == 1;

	}

	public List<Celular> listarCelulares() {
		Celular celular = null;

		List<Celular> lista = new ArrayList<Celular>();

		PreparedStatement comando;
		try {
			comando = conexao.prepareStatement("SELECT * FROM celular");

			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {
				celular = new Celular();

				celular.setId(resultado.getInt("id"));
				celular.setMarca(resultado.getString("marca"));
				celular.setModelo(resultado.getString("modelo"));
				celular.setRam(resultado.getDouble("ram"));
				celular.setProcessador(resultado.getString("processador"));
				celular.setVelocidade_processador(resultado.getDouble("velocidade_processador"));
				celular.setPreco(resultado.getDouble("preco"));
				celular.setTela(resultado.getDouble("tela"));
				celular.setArmazenamento(resultado.getInt("armazenamento"));
				celular.setCamera_frontal(resultado.getDouble("camera_frontal"));
				celular.setCamera_traseira(resultado.getDouble("camera_traseira"));
				celular.setUrl_img(resultado.getString("url_img"));

				lista.add(celular);
			}

		} catch (SQLException e) {
			celular = null;
			System.out.println("\nErro: " + e);
		}

		return lista;

	}

	public Celular getCelular(String idCelular) {

		Celular celular = null;

		PreparedStatement comando;
		try {
			comando = conexao.prepareStatement("SELECT * FROM celular WHERE id=" + idCelular);

			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {
				celular = new Celular();

				celular.setId(resultado.getInt("id"));
				celular.setMarca(resultado.getString("marca"));
				celular.setModelo(resultado.getString("modelo"));
				celular.setRam(resultado.getDouble("ram"));
				celular.setProcessador(resultado.getString("processador"));
				celular.setVelocidade_processador(resultado.getDouble("velocidade_processador"));
				celular.setPreco(resultado.getDouble("preco"));
				celular.setTela(resultado.getDouble("tela"));
				celular.setArmazenamento(resultado.getInt("armazenamento"));
				celular.setCamera_frontal(resultado.getDouble("camera_frontal"));
				celular.setCamera_traseira(resultado.getDouble("camera_traseira"));
				celular.setUrl_img(resultado.getString("url_img"));

				return celular;
			}

		} catch (SQLException e) {
			celular = null;
			System.out.println("\nErro: " + e);
		}
		return celular;

	}

}