package com.listUser.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.listUser.dao.util.Conexao;

/**
 * Servlet implementation class IndexController
 */
@WebServlet("/public")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public IndexController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarRequisicao(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarRequisicao(request, response);
		doGet(request, response);
	}
	
	//Aqui será tratada a requisição
	protected void processarRequisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");// pegando o dado do link novo usuario através do parametro acao
		// Tratativa do parametro acao
		try {
			switch (acao) {
			case "novo":
				novoUsuario(request, response);
				break;
			}
		}catch(Exception ex) {
			throw new ServletException(ex);
		}
	}
	
	private void novoUsuario(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
			Connection conexaoJDBC = Conexao.getConexao();
			
			if (conexaoJDBC != null) {
				System.out.println("Conexão aberta");
			}else {
				System.out.println("Sem conexão");
			}
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("public/public-new-user.jsp");
			dispatcher.forward(request, response);
		}
	}



