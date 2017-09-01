package com.phonesaragao.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phonesaragao.dao.CelularDAO;
import com.phonesaragao.modelo.Celular;

public class AddCelularServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException{
		response.sendRedirect("adicionarCelular.html");
	}
	
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException{
		
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		String ram = request.getParameter("ram");
		String processador = request.getParameter("processador");
		String velocidade_processador = request.getParameter("velocidade_processador");
		String preco = request.getParameter("preco");
		String tela = request.getParameter("tela");
		String armazenamento = request.getParameter("armazenamento");
		String camera_frontal = request.getParameter("camera_frontal");
		String camera_traseira = request.getParameter("camera_traseira");
		String url_img = request.getParameter("url_img");
		
		Celular umCelular = new Celular();
		umCelular.setMarca(marca);
		umCelular.setModelo(modelo);
		umCelular.setRam(Double.parseDouble(ram));
		umCelular.setProcessador(processador);
		umCelular.setVelocidade_processador(Double.parseDouble(velocidade_processador));
		umCelular.setPreco(Double.parseDouble(preco));
		umCelular.setTela(Double.parseDouble(tela));
		umCelular.setArmazenamento(Integer.parseInt(armazenamento));
		umCelular.setCamera_frontal(Double.parseDouble(camera_frontal));
		umCelular.setCamera_traseira(Double.parseDouble(camera_traseira));
		umCelular.setUrl_img(url_img);
		
		CelularDAO celularDAO = new CelularDAO();
		if(celularDAO.cadastrarCelular(umCelular)){
			response.sendRedirect("cadastrado.html");
		} else {
			response.sendRedirect("erroCadastro.html");
		}
	}
}
