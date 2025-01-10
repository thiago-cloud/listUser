package com.listUser.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.listUser.dao.UsuarioDAO;
import com.listUser.model.Usuario;


@WebServlet("/auth/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// Definindo a minha referência(classe) UsuarioDAO no controller
	private UsuarioDAO usuarioDAO;
	
    public AdminController() {
        super();
    }
    
    // Inicializando a classe UsuarioDAO para que possa ser utilizada
    public void init() {
    	// Instanciando o meu usuárioDAO para poder utilizar
    	usuarioDAO = new UsuarioDAO();
    }
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarRequisicao(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarRequisicao(request, response);
	}
	
	//Aqui será tratada a requisição
		protected void processarRequisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String acao = request.getParameter("acao");// pegando o dado do link novo usuario através do parametro acao
			// Tratativa do parametro acao
			try {
				switch (acao) {
				case "listar":
					listarUsuario(request, response);
					break;
				case "apagar":
					apagarUsuario(request, response);
					break;
				}
			}catch(Exception ex) {
				throw new ServletException(ex);
			}
		}

	private void listarUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		// Pegando o método de listarTodosUsuarios do usuarioDAO
		List<Usuario> usuario = usuarioDAO.listarTodosUsuarios();
		
		// Pegando o objeto usuario que contém o metodo listarUsuarios e apelidando de listarUsuários para chamar na página jsp
		request.setAttribute("listarUsuarios", usuario);
		
		// A variavel path e responsavel por cocantenar /auth/admin/admin-list-user.jsp
		String path = request.getServletPath() + "/admin-list-user.jsp";
		
		// Faça um dispache(redirecinamento) para esse caminho "path"
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		
		//O código dispatcher.forward(request, response); é usado em aplicações web baseadas no Java Servlet para encaminhar uma solicitação e resposta para outro recurso no servidor, como um Servlet, JSP ou outro controlador.
		dispatcher.forward(request, response);
	}
	
	private void apagarUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// Pegando o id em formato de string e convertendo para um long e passando para a variavel do tipo long
		long id = Long.parseLong(request.getParameter("id"));
		
		// Criando o obejeto usuario
		Usuario usuario = new Usuario();
		
		// Colocando o objeto dentro dele
		usuario.setId(id);
		
		// Usuario apagado
		usuarioDAO.apagarUsuario(usuario);
		
		// Listando todos os usuarios apagados
		// Request.getContextPath() retorna essa parte da url http://localhost:8080/listUser
		// Request.getServletPath() retorna essa parte da url /auth/admin
		String path = request.getContextPath() + request.getServletPath() + "?acao=listar";
		response.sendRedirect(path);
	}

}
