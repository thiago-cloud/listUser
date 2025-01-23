package com.listUser.controller.i18n;

import java.io.IOException;
import java.util.Locale;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;


@WebServlet("/I18nController")
public class I18nController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public I18nController() {
        super();
    }
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
			String lingua = request.getParameter("lingua");
			
			// Esse array de string será responsavel por pegar pt_BR e en_US e cada um será uma parte em um indice como  indice 0=pt 1=BR
			String[] tk = new String[2];
			
			// Servirá para indicar que o separador será o _ da string pt_BR e en_US
			StringTokenizer tokenizer = new StringTokenizer(lingua, "_");
			
			// Inicie no indice 0
			int i = 0;
			
			// Enquanto o existir um elemento no indice incremente indice 0=pt indice 1=BR
			while(tokenizer.hasMoreElements()) {
				tk[i] = tokenizer.nextToken();
				i++;
			}
			
			// O construtor de Locale recebe como paramentro a linguagem 0 e o País 1.
			Locale locale = new Locale(tk[0], tk[1]);
			
			// O request.getSession() é o método responsavel por pegar a linguagem
			Config.set(request.getSession(), Config.FMT_LOCALE, locale);
			Config.set(request.getSession(), Config.FMT_FALLBACK_LOCALE, locale);

			// Redirecione para página index.jsp
			response.sendRedirect("index.jsp");
			
		
	}


}
