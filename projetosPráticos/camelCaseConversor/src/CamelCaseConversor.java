package camelCaseConversor.src;

import java.util.ArrayList;
import java.util.List;

/**
 * 10Primeiros - Inválido → não deve começar com números
 * nome#Composto - Inválido → caracteres especiais não são permitidos, somente letras e números
 */

public class CamelCaseConversor {
	public static List<String> palavrasSeparadas;
	public static String palavraSeparada = "";
	
	
	public static List<String> converterCamelCase (String original) {
		palavrasSeparadas = new ArrayList<String>();
		palavraSeparada = "";
		
		for (int i = 0; i < original.length(); i++) {
		    char letra = original.charAt(i);

		    //TODO: Caso comece com número, lançar exceção
		    //TODO: Caso contenha caracteres especiais, lançar exceção
		    
		    adicionaPalavraNaoVaziaCasoLetraMaiuscula(letra);
		    adicionaPalavraNaoVaziaCasoNumero(letra);
		    palavraSeparada += Character.toLowerCase(letra);
		}
		
		adicionaPalavraNaoVazia(palavraSeparada); //adicionar a úçtima palavra formada
		
		return pegaListaDePalavrasEJuntaSiglas(palavrasSeparadas);
	}
	
	public static void adicionaPalavraNaoVazia(String palavra) {
		if(!palavra.isEmpty())
			palavrasSeparadas.add(palavra);
	}
	
	public static void adicionaPalavraNaoVaziaCasoLetraMaiuscula (char ch) {
		if(Character.isUpperCase(ch)) {
    		adicionaPalavraNaoVazia(palavraSeparada);
    		palavraSeparada = "";
	    }
	}
	
	public static void adicionaPalavraNaoVaziaCasoNumero (char ch) {
		if(Character.isDigit(ch)) {
	    	adicionaPalavraNaoVazia(palavraSeparada);
	    	palavraSeparada = "";
	    }
	}
	
	public static List<String> pegaListaDePalavrasEJuntaSiglas(List<String> palavras) {
		List<String> palavrasAux = new ArrayList<String>();
		String aux = "";
		
		for (String palavra : palavras) {
			if (palavra.length() == 1) {
				aux += palavra;
			}else {
				if(!aux.isEmpty()) {
					palavrasAux.add(aux.toUpperCase());
					aux = "";
				}
				palavrasAux.add(palavra);
			}
		}
		
		//Caso sigla no final
		if(!aux.isEmpty()) {
			palavrasAux.add(aux.toUpperCase());
			aux = "";
		}
		
		return palavrasAux;
	}

}
