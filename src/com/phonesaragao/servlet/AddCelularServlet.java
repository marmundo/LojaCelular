package com.phonesaragao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
		PrintWriter out=response.getWriter();
		out.print(getPaginaHTML());
	}
	
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException{
		PrintWriter out=response.getWriter();
		
			String marca=request.getParameter("marca");
			
			Celular umCelular= new Celular();
			umCelular.setMarca(marca);
			
			CelularDAO celularDAO=new CelularDAO();
			try {
				if(celularDAO.inserir(umCelular)){
					out.println(getSucessoInserirCelular());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private String getSucessoInserirCelular() {
		/*Retorna Pagina em caso de sucesso*/
		return null;
	}
	
	private String getFalhaInserirCelular() {
		/*Retorna Pagina em caso de fracasso*/
		return null;
	}

	private String getPaginaHTML(){
		return "<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset='utf-8'>"
				+ "<meta http-equiv='X-UA-Compatible' content='IE=edge'>"
				+ "<title>Cadastra Celular</title>"
				+ "<style>label,input{"
				+ "margin:2px 20px;"
				+ "}</style>"
				+ "</head>"
				+ "<body>"
				+ "<h1>Cadastro Celular</h1>"
				+ "<form action='cadastraCelular' method='post' accept-charset='utf-8'>"
				+ "<label for='marca'> Marca</label>"
				+ "<input type='text' name='marca' value='Marca' placeholder='Marca'>"
				+ "<br>"
				+ "<label for='modelo'> Modelo</label>"
				+ "<input type='text' name='modelo' value='Modelo' placeholder='Modelo'>"
				+ "<br>"
				+ "<label for='memoria_ram'> Memoria RAM</label>"
				+ "<input type='number' name='memoria_ram' value='2' placeholder='Memoria RAM'>"
				+ "<br>"
				+ "<label for='processador'> Processador</label>"
				+ "<input type='text' name='processador' value='Inter' placeholder='Processador'>"
				+ "<br>"
				+ "<label for='velocidade_processador'> Velocidade Processador</label>"
				+ "<input type='number' name='velocidade_processador' value='200' placeholder='Velocidade Processador'>"
				+ "<br>"
				+ "<label for='preco'> Preco</label>"
				+ "<input type='number' name='preco' value='2000' placeholder='Preco'>"
				+ "<br>"
				+ "<label for='tamanho_tela'> Tamanho Tela</label>"
				+ "<input type='number' name='tamanho_tela' value='7' placeholder='Tamanho Tela'>"
				+ "<br>"
				+ "<label for='memoria_armazenamento'> Memoria Armazenamento</label>"
				+ "<input type='number' name='memoria_armazenamento' value='2' placeholder='Memoria Armazenamento'>"
				+ "<br>"
				+ "<label for='resolucao_camera_frontal'>Resolucao Camera Frontal</label>"
				+ "<input type='number' name='resolucao_camera_frontal' value='10' placeholder='Resolucao Camera Frontal'>"
				+ "<br>"
				+ "<label for='resolucao_camera_traseira'>Resolucao Camera Traseira</label>"
				+ "<input type='number' name='resolucao_camera_traseira' value='12' placeholder='Resolucao Camera Traseira'"
				+ "<br>"
				+ "<div><input type='submit' name='cadastrar' value='Cadastrar'></div>"
				+ "</form>"
				+ "</body>"
				+ "</html>";
	}
}
