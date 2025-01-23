package com.listUser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.listUser.dao.util.Conexao;
import com.listUser.model.Papel;
import com.listUser.model.Usuario;

public class PapelDAO {
	
		private Connection connection;
		
		// Se a conexão for igual a null ou estiver aberta retorne conexão ocupada
		private void conectar() throws SQLException {
			if (connection == null || connection.isClosed()) {
				connection = Conexao.getConexao();// Se for igual a null ou a connection tiver sido fechada pegue uma conexão do pool de conexões.
			}
		}

		// Se a conexão for diferente de null e for fechada ou seja a conexão que tinha aberta terminou devolva para o pool de conexão deixando disponivel
		private void desconectar() throws SQLException {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
		
		// Esse método recebera como parametro o tipo de papel e vai retorna um objeto Papel com id e tipo de papel
		public Papel buscarPapelPorTipo(String tipo) throws SQLException {
	        Papel papel = null;
	        
	        // Selecione todos os papeis onde o tipo = ? que pode ser 'User', 'Admin' ou 'biblio'
	        String sql = "SELECT * FROM papel WHERE tipo_papel LIKE ?";
	         
	        // Conectar na pool
	        conectar();
	         
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setString(1, tipo);
	         
	        ResultSet resultSet = statement.executeQuery();
	         
	        // Se houve algum retorno pegue os dados que foram selecionados o id e o tipo
	        if (resultSet.next()) {
	        	long id = resultSet.getLong("id");
	        	String tipoPapel = resultSet.getString("tipo_papel");

				papel = new Papel(id, tipoPapel);
			}
	        
	        // Após isso fechamos o resultSet
	        resultSet.close();
	        // fechamos o statement
	        statement.close();
	        
	        // Desconectar do pool
	        desconectar();
	        
	        // Retornando o objeto papel
	        return papel;
	    }
		
		public void atribuirPapelUsuario(Papel papel, Usuario usuario) throws SQLException{
			String sql = "INSERT INTO usuario_papel (usuario_id, papel_id)"
					+ " VALUES (?, ?)";// Inseri um id do usuário e um id do papel fazendo o relacionamento entre os 2 na tabela		    
			
			conectar();// Ocupa uma conexão no pool

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, usuario.getId());// Pegando o id do usuário e passando na interrogação numero 1 de VALUES
			statement.setLong(2, papel.getId());// Pegando o id do papel e passando na interrogação numero 2 de VALUES
			
			statement.executeUpdate();// Execução da query
			statement.close();// Fecho o statement

			desconectar(); // desconecta do pool, devolvendo a conexão ao pool
			
		}
		
		public List<Papel> buscarPapelUsuario(Usuario usuario) throws SQLException {
			List<Papel> listaPapeis = new ArrayList<Papel>();
	        String sql = "SELECT papel.id, papel.tipo_papel" +
	        	  	     "  FROM papel " +
	        		     "  JOIN usuario_papel " +
	        		     "    ON usuario_papel.papel_id = papel.id " +
	        		     "  JOIN usuario " +
	        		     "    ON usuario.id = usuario_papel.usuario_id " +
	        		     " WHERE usuario.id = ?";
	         
	        conectar();
	         
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setLong(1, usuario.getId());
	         
	        ResultSet resultSet = statement.executeQuery();
	         
	        while (resultSet.next()) {
	        	long id = resultSet.getLong("id");
	        	String tipoPapel = resultSet.getString("tipo_papel");

				Papel papel = new Papel(id, tipoPapel);
				listaPapeis.add(papel);
			}
	         
	        resultSet.close();
	        statement.close();
	        
	        desconectar();
	        
	        // Retornando a lista de papeis de cada usuário
	        return listaPapeis;
	    }



}
