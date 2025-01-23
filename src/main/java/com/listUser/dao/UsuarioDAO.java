package com.listUser.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.listUser.dao.util.Conexao;
import com.listUser.model.Papel;
import com.listUser.model.Usuario;

public class UsuarioDAO {
	
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
	
	// Método de listar todos os usuários
	public List<Usuario> listarTodosUsuarios() throws SQLException {
		
		PapelDAO papelDAO = new PapelDAO();
		
		// Variavel do tipo List<Usuario> onde as linhas de dados ficarão armazenadas
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();

		// Listando os usuários no banco e colocando dentro da variavel sql
		String sql = "SELECT * FROM usuario";

		conectar();

		Statement statement = connection.createStatement();
		
		// Dentro da variavel resultSet do tipo ResultSet sql colocamos a variave sql
		ResultSet resultSet = statement.executeQuery(sql);
		
		// enquanto o resultSet tiver mais uma linha de dados na tabela repita o procedimento de pegar os dados para repetir colocamos o .next()
		while (resultSet.next()) {
			long id = resultSet.getLong("id");// pegue a coluna chamada id
			String nome = resultSet.getString("nome");// pegue a coluna chamada nome no banco e assim sucessivamente
			String cpf = resultSet.getString("cpf");
			Date nascimento = new Date(resultSet.getDate("data_nascimento").getTime());
			String email = resultSet.getString("email");
			String password = resultSet.getString("password");
			String user = resultSet.getString("login");
			boolean ativo = resultSet.getBoolean("ativo");
			
			// Colocamos todos os dados do banco dentro do objeto usuário do tipo Usuário
			Usuario usuario = new Usuario(nome, cpf, nascimento, email, password, user, ativo);
			usuario.setId(id);
			
			// Pegando os papeis do usuário
			List<Papel> papeis = papelDAO.buscarPapelUsuario(usuario);
			
			//Inserindo os papeis no objeto usuário dentro da lista: List<Papel> papeis;
			usuario.setPapeis(papeis);
			
			// Agora colocaremos todos os dados que estár como objeto dentro da varivel listaUsuário
			listaUsuarios.add(usuario);
		}
		
		// Quando saimos do while fechamos o resultSet e o statement que foram abertos em cima
		resultSet.close();
		statement.close();

		desconectar();// A finalizar o get desconecte a conexao do pool de conexão, para deixar uma conexão livre do pool

		// Após toda a lista ser alimentada com os dados do while linha por linha retornamos a lista "listaUsuario"
		return listaUsuarios;
	}
	
	public  boolean apagarUsuario(Usuario usuario) throws Exception{
		
		// instrução sql que deleta o usuario de acordor com id
		String sql = "DELETE FROM usuario where id = ?";
		
		// Conexão ao pool
		conectar();
		
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, usuario.getId());
		
		// Se esse valor for maior que 0 ele apaga o objeto do banco de dados
		boolean linhaApagada = statement.executeUpdate() > 0;
		// Fechando meu statement para na sequencia desconectar do meu pool ou do meu banco de dados
		statement.close();
		
		// Deconexão do pool e devolvendo uma conexão livre no pool
		desconectar();
		
		// Se linhaApagada for true ou seja maior que 0 retorne linhaApagada
		return linhaApagada;
	}

}
