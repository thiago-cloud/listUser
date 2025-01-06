package com.listUser.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

public class Conexao {
	
	// Pool de conexão
	private static final String RESOURCE = "java:/comp/env/jdbc/postgresql";
	
	// Retornando um objeto do tipo connection
	public static Connection getConexao() {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup(RESOURCE);			
			return ds.getConnection(); // Retornando uma conexão do pool de conexão
		} catch (SQLException | NamingException e) {
			throw new RuntimeException("Erro ao conectar ao banco de dados", e);
		}
		
	}
}
