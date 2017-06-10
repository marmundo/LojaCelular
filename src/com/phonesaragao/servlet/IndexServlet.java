package com.phonesaragao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
				+ "<h1>Loja Celular SERVLET!</h1>"
				+ "</body></html>");
		
	}

}
