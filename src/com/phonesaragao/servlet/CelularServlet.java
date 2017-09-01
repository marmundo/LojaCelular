package com.phonesaragao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.NetworkChannel;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phonesaragao.dao.CelularDAO;
import com.phonesaragao.modelo.Celular;

public class CelularServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idCelular=(String) req.getParameter("id");
		CelularDAO celularDao=new CelularDAO();
		Celular celular=celularDao.getCelular(idCelular);
		
		ServletAragao serv=new ServletAragao();
		String html= serv.getListarCelular(celular);
		
		PrintWriter out = resp.getWriter();
		out.print(html);
	}
}
