package com.phonesaragao.principal;

import java.sql.SQLException;

import com.phonesaragao.dao.CelularDAO;
import com.phonesaragao.modelo.Celular;

public class Principal {
	
	private Celular criaCelular(){
		Celular c=new Celular();
		c.setMarca("Samsung");
		c.setMemoriaArmazenamento(16);
		c.setMemoriaRam(2);
		c.setModelo("A10");
		c.setPreco(800.00);
		c.setProcessador("Qualcom");
		c.setResolucaoCameraFrontal(5);
		c.setResolucaoCameraTraseira(10);
		c.setTamanhoTela(5);
		c.setVelocidadeProcessador(2);
		return c;
	}

	public static void main(String[] args) {
	
		Principal p=new Principal();
		Celular c=p.criaCelular();
		
		CelularDAO cDao=new CelularDAO();
		try {
			System.out.println(cDao.listarTodosCelulares().toString());
		/*	if(cDao.inserir(c)){
				System.out.println("Celular inserido!");
			}*/
			cDao.fechar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
