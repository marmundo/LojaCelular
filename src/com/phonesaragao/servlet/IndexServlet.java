package com.phonesaragao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phonesaragao.dao.CelularDAO;
import com.phonesaragao.modelo.Celular;

public class IndexServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException{
		PrintWriter out=response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html><head><meta charset='UTF-8'>");
		out.print("<title>Loja Celular!</title></head><body>"
				+ "<h1>Loja Celular SERVLET!</h1>");
		out.print("<h2>Lista Celulares</h2>");
		out.print("<ul>");
		out.print(listarCelulares());
		out.print("</ul>");
		out.print("</body></html>");
		
	}
	
	String listarCelulares(){
		CelularDAO dao= new CelularDAO();
		List<Celular> listaCelular;
		String listaCelularString="";
		String modeloCelular="";
		try {
			listaCelular = dao.listarTodosCelulares();
			
			for (Celular celular : listaCelular) {
				modeloCelular="<li>"+celular.getModelo()+"</li>";
				listaCelularString=listaCelularString+modeloCelular;
			}
			return listaCelularString;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaCelularString;
	}

}
