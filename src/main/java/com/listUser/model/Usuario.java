package com.listUser.model;

import java.util.Date;

public class Usuario {
	private Long id;
	private String nome;
	private String cpf;
	private Date dataNascimento;
	private String  email;
	private String password;
	private String Usuario;
	private boolean ativo;
	
	
	// Construtor vazio
	public Usuario() {
		super();
	}
	
	
	
	public Usuario(String nome, String cpf, Date dataNascimento, String email, String password, String usuario,
			boolean ativo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.password = password;
		Usuario = usuario;
		this.ativo = ativo;
	}


	// Testar se os métodos estão sendo pegos
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", email=" + email
				+ ", password=" + password + ", Usuario=" + Usuario + ", ativo=" + ativo + "]";
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
