package com.phonesaragao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phonesaragao.classes.Celular;
import com.phonesaragao.dao.CelularDAO;

public class servletAragao extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter imprimir = response.getWriter();
		
		imprimir.println("<html>");
		imprimir.println("<head>");
		imprimir.println("<title>Primeira Servlet</title>");
		imprimir.println("</head>");
		imprimir.println("<body>");
		imprimir.println("<h1>Olá, ó grande Servlet!!!</h1>");
		imprimir.println("<h2>Celulares:</h2>");
		imprimir.println("<ul>");
		imprimir.println(getListarCelulares());
		imprimir.println("</ul>");
		imprimir.println("</body>");
		imprimir.println("</html>");
		
	}
	
	String getListarCelulares() {
		CelularDAO cel_dao = new CelularDAO();
		List<Celular> listaCelular = cel_dao.listarCelulares();
		
		String listaCelularString = "";
		String modeloCelular = "";
		
		for (Celular celular : listaCelular) {
			modeloCelular = "<li>" + celular.getModelo() + "</li>";
			listaCelularString = listaCelularString + modeloCelular;
		}
		
		return listaCelularString;
	}

}
