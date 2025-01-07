package com.listUser.controller.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ManipulacaoDado {
	
	// Essa classe será responsavel pelo método que recebe uma string e devolve um objeto do tipo Date
	
	// Método converte o dado string em dado do tipo date
	public Date converterStringData(String dataString) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date data = null;
		try {
			data = format.parse(dataString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return data; // Retornando o objeto do tipo date
	}
	
	
}
