package com.phonesaragao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phonesaragao.dao.CelularDAO;
import com.phonesaragao.modelo.Celular;

public class ServletAragao extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException{
		
		PrintWriter out = response.getWriter();

		out.print(getEstruturaInicio());
		out.print (getListarCelulares());
		out.print(getEstruturaFim());
		
	}
	
	String getEstruturaInicio() {
		return "<!DOCTYPE html>"
		+ "<html>"
			+ "<head>"
				+ "<title>Listagem</title>"
				+ "<meta charset='utf-8'>"
				+ "<meta http-equiv='X-UA-Compatible' content='IE=edge'>"
				+ "<!-- Última versão CSS compilada e minificada -->"
				+ "<link rel='stylesheet'"
					+ "href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'"
					+ "integrity='sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7'"
					+ "crossorigin='anonymous'>"
				+ "<link rel='stylesheet' type='text/css' href='style-estrutura.css'>"
				+ "<link rel='shortcut icon' href='resources/img/622.ico'"
					+ "type='image/x-icon'/>"
				+ "<script"
					+ "src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script>"
				+ "<script"
					+ "src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script>"
			+ "</head>"
			+ "<body>"
				+ "<div>"
					+ "<nav id='menu' class='navbar navbar-default navbar-fixed-top'>"
						+ "<div class='container-fluid'>"
							+ "<div class='navbar-header'>"
								+ "<button type='button' class='navbar-toggle' data-toggle='collapse'"
									+ "data-target='#myNavbar'>"
									+ "<span class='icon-bar'></span> <span class='icon-bar'></span> <span"
										+ "class='icon-bar'></span>"
								+ "</button>"
								+ "<a href='index.html' class='navbar-left'><img height='50px'"
									+ "src='resources/img/622.png'></a>"
							+ "</div>"
							+ "<div class='collapse navbar-collapse' id='myNavbar'>"
								+ "<ul class='nav navbar-nav navbar-left'>"
									+ "<li class='active'><a src='com.phonesaragao.servlet.ServletAragao'>Listagem dos celulares</a></li>"
									+ "<li><a href='adicionarCelular.html'>Cadastrar celular</a></li>"
								+ "</ul>"
								+ "<form class='navbar-form navbar-right' role='search'>"
									+ "<div class='form-group'>"
										+ "<input type='text' class='form-control' placeholder='Pesquisar'>"
									+ "</div>"
									+ "<button type='submit' class='btn btn-inverse'>"
										+ "<span class='glyphicon glyphicon-search'></span>"
									+ "</button>"
								+ "</form>"
							+ "</div>"
						+ "</div>"
					+ "</nav>"
				+ "</div>"
					
				+ "<div class='container'>" 
					+ "<div class='row'>" ;
			      				
	}
	
	String getEstruturaFim() {

		return "</div>" 
			+ "</div>"
				
		+ "<footer id='footer'>"
			+ "<div class='container'>"
				+ "<div class='row copyright text-center'>"
					+ "<div class='col-md-12'>"
						+ "<p id='desenvolvedor' class='roboto'>"
							+ "Copyright &copy;2017 - <a href='https://github.com/jancywdson'"
							+ "target='_blank'>Phones Aragão</a>"
						+ "</p>"
					+ "</div>"
				+ "</div>"
			+ "</div>"
		+ "</footer>"	
	
	+ "</body>"
+ "</html>";
	}

	String getListarCelulares() {
		CelularDAO cel_dao = new CelularDAO();
		List<Celular> listaCelular = cel_dao.listarCelulares();

		String listaCelularString = "";
		String modeloCelular = "";
		String imgCelular = "";
		String precoCelular;
		String auxiliar;
		String inicio;
		String fim;

		for (Celular celular : listaCelular) {
			inicio = "<div class='col-sm-4 col-md-2'>" + "<div class='thumbnail'>";
			imgCelular = "<img src='" + celular.getUrl_img() + "' height=\"100\" width=\"150\"/>";
			auxiliar = "<div class=\"caption\">";
			modeloCelular = "<h3 id='modelo'>" + celular.getModelo() + "</h3>";
			precoCelular = "<h3 id='preco'>R$" + celular.getPreco() + "0</h3>";
			fim = "<p><a href='#' class='btn btn-primary' role='button'>Ver mais</a></p>" + "</div>"
				+ "</div>" + "</div>";
			listaCelularString = listaCelularString + inicio + imgCelular + auxiliar + modeloCelular + precoCelular + fim;
		}

		return listaCelularString;
	}

}
