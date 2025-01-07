package com.listUser.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.listUser.dao.util.Conexao;
import com.listUser.model.Usuario;

public class UsuarioDAO {
	
private Connection connection;
	
	// Se a conexão for igual a null ou estiver aberta retorne conexão ocupada
	private void conectar() throws SQLException {
		if (connection == null || connection.isClosed()) {
			connection = Conexao.getConexao();
		}
	}

	// Se a conexão for diferente de null e for fechada ou seja a conexão que tinha aberta terminou devolva para o pool de conexão deixando disponivel
	private void desconectar() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	}
	
	// Método responsavel por inserir dados do tipo Usuario no banco de dados
	public Usuario inserirUsuario(Usuario usuario) throws SQLException {
		String sql = "INSERT INTO usuario (nome, cpf, data_nascimento, email, password, login, ativo)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";		    
		
		// O conectar serve para chamar o método conectar e assim operar em uma conexão do pool
		conectar();
		
		// Pegando os dados do arquivo e enviando para o values do método inserirUsuario
		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);// O Statement.RETURN_GENERATED_KEYS serve para gerar um id de forma automatica no banco
		statement.setString(1, usuario.getNome());// O 1 significa que o dado ficará na primeira ? e assim sucessivamente
		statement.setString(2, usuario.getCpf());
		Date nascimento = new Date(usuario.getDataNascimento().getTime());// Transformando primeiro em dados sql para poder inserir no banco de dados
		statement.setDate(3, nascimento);
		statement.setString(4, usuario.getEmail());
		statement.setString(5, usuario.getPassword());
		statement.setString(6, usuario.getUsuario());
		statement.setBoolean(7, usuario.isAtivo());
		
		// Após ser preenchido todo o values vou montar os dados no banco de dados
		statement.executeUpdate();
		
		// O id que foi gerado e colocado nesse objeto chamado resultSet do tipo ResultSet
		ResultSet resultSet = statement.getGeneratedKeys();
		long id = 0;
		if(resultSet.next())
			id = resultSet.getInt("id");
		statement.close();

		// Chamando o método responsavel por devolver conexão para o pool
		desconectar();
		
		usuario.setId(id);// Settando o id
		return usuario;
	}


}
