package camelCaseConversor.src;

import java.util.ArrayList;
import java.util.List;

/** Requisitos
 * nome - “nome” - Ok
 * Nome - “nome” - Ok
 * nomeComposto - “nome”, “composto” - Ok
 * NomeComposto - “nome”, “composto” - Ok
 * CPF - “CPF” - Ok
 * numeroCPF - “numero”, “CPF” - OK
 * numeroCPFContribuinte - “numero”, “CPF”, “contribuinte” - Ok
 * recupera10Primeiros - “recupera”, “10”, “primeiros”
 * 10Primeiros - Inválido → não deve começar com números
 * nome#Composto - Inválido → caracteres especiais não são permitidos, somente letras e números
 */

public class CamelCaseConversor {
	public static List<String> palavras;
	
	public static List<String> converterCamelCase (String original) {
		palavras = new ArrayList<String>();
		
		String palavraSeparada = "";
		
		for (int i = 0; i < original.length(); i++) {
		    char letraAtual = original.charAt(i);

		    if(Character.isUpperCase(letraAtual)) {
	    		adicionaPalavraNaoVazia(palavraSeparada);
		    	palavraSeparada = "";
		    }
		    
		    palavraSeparada += Character.toLowerCase(letraAtual);
		    
		}
		
		adicionaPalavraNaoVazia(palavraSeparada);
		
		return pegaListaDePalavrasEJuntaSiglas(palavras);
	}
	
	public static void adicionaPalavraNaoVazia(String palavra) {
		if(!palavra.isEmpty())
			adicionaPalavra(palavra);
	}
	
	public static void adicionaPalavra(String palavra) {
		palavras.add(palavra);
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
		
		//Caso sigla esteja no final
		if(!aux.isEmpty()) {
			palavrasAux.add(aux.toUpperCase());
			aux = "";
		}
		
		return palavrasAux;
	}

}
