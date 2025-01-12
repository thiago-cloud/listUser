package com.listUser.controller.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Essa importação e traz consigo a classe Hex responsavel por gravar criptografia no banco de dados
import org.apache.commons.codec.binary.Hex;

// Essa classe será responsável por fazer a criptografia da senha no banco  de dados
public class Criptografia {
	
	// Método responsável pela criptografia MD5
	public static String converterParaMD5(String senha) throws NoSuchAlgorithmException {
		
		// O MessageDigest vai criar o objeto  que se transformara em um MD5 que se chamara md para criptografar a senha
		MessageDigest md = MessageDigest.getInstance("MD5");
		
		// Pegando a senha e gerando criptografia em cima da senha
		md.update(senha.getBytes());
		
		// Pegando essa senha que foi gerada a criptografia e transformando no array de byte
	    byte[] digest = md.digest();	    
	    
	    // Para gravar no banco de dados e necessário transformar em hexadecimal a classe Hex pertence a dependência commons-codec do pom.xml
	    String resultado = new String(Hex.encodeHex(digest));
	    
	    // retornando a criptografia em hexadecimanl para o banco de dados 
		return resultado;
	}


}
