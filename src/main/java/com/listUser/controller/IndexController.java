package com.listUser.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.listUser.controller.util.ManipulacaoDado;
import com.listUser.dao.UsuarioDAO;
import com.listUser.dao.util.Conexao;
import com.listUser.model.Usuario;

/**
 * Servlet implementation class IndexController
 */
@WebServlet("/public")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UsuarioDAO usuarioDAO;
	
	
    public IndexController() {
        super();
    }
    
    // Inicializando a classe UsuarioDAO para que possa ser utilizada
    public void init() {
    	usuarioDAO = new UsuarioDAO();
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
			case "inserir":
				salvarUsuario(request, response);
				break;
			}
		}catch(Exception ex) {
			throw new ServletException(ex);
		}
	}
	
	private void novoUsuario(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("public/public-new-user.jsp");
			dispatcher.forward(request, response);
		}

	private void salvarUsuario(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException, SQLException {
		
			// Capturando os dados do input através do getParameter
			String name = request.getParameter("nome");
			String cpf = request.getParameter("cpf");
			String email = request.getParameter("email");
			String user = request.getParameter("user");
			String password = request.getParameter("password");
			String dataNascimento = request.getParameter("nascimento");
			
			// Intanciando a classe ManipulacaoDado e utilizando o método conversor de string para date
			ManipulacaoDado manipulacaoData = new ManipulacaoDado();
			Date date = manipulacaoData.converterStringData(dataNascimento);
			
			// capturando os dados de usuário
			Usuario usuario = new Usuario(name, cpf, date, email, password, user, false);
			
			// Inserindo os dados no usuarioDAO
			usuarioDAO.inserirUsuario(usuario);
		}
	}




