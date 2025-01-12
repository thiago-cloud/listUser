package com.listUser.controller.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nUtil {
	
	public String getMensagem(Locale locale, String chave) {		
		
		// O resources.message faz referencia a pasta e aos arquivos de tradução e o e variavél que pode ser pt-BR ou en-US
	    ResourceBundle bundle = ResourceBundle.getBundle("resources.message", locale);

	    // A variavél mensagem vai pegar o arquivo de tradução de acordo com lógicae inserir o parametro chave que no caso e mensagem
	    String mensagem = bundle.getString(chave);
	    
	    // Retorne a mensagem
	    return mensagem;
	}

}
