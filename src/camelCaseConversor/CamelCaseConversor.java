package camelCaseConversor;

import java.util.ArrayList;
import java.util.List;
/** Requisitos
 * nome - “nome” - Ok
 * Nome - “nome” - Ok
 * nomeComposto - “nome”, “composto” - Ok
 * NomeComposto - “nome”, “composto” - Ok
 * CPF - “CPF”
 * numeroCPF - “numero”, “CPF”
 * numeroCPFContribuinte - “numero”, “CPF”, “contribuinte”
 * recupera10Primeiros - “recupera”, “10”, “primeiros”
 * 10Primeiros - Inválido → não deve começar com números
 * nome#Composto - Inválido → caracteres especiais não são permitidos, somente letras e números
 */
public class CamelCaseConversor {
	
	public static List<String> converterCamelCase (String original) {
		List<String> listaComPalavras = new ArrayList<String>();
		
		String palavraSeparada = "";
		for (int i = 0; i < original.length(); i++) {
		    char c = original.charAt(i);
		    
		    if(Character.isUpperCase(c)) {
		    	if(palavraSeparada != "")
		    		listaComPalavras.add(palavraSeparada);
		    	palavraSeparada = "";
		    }
		    
		    palavraSeparada += Character.toLowerCase(c);;
		    
		}
		
		if(palavraSeparada != "")
			listaComPalavras.add(palavraSeparada);
		
		return listaComPalavras;
	}

}
