package camelCaseConversor.src;

import java.util.ArrayList;
import java.util.List;
import camelCaseConversor.src.exception.ComecaComNumeroException;
import camelCaseConversor.src.exception.TemCaractereEspecialException;

public class CamelCaseConversor {
	public static List<String> palavrasSeparadas;
	public static String palavraSeparada;
	
	public static List<String> converterCamelCase (String fraseCamelCase) 
			throws ComecaComNumeroException, TemCaractereEspecialException {
		inicializaVariaveis();
		lancaExcecaoCasoComeceComNumero(fraseCamelCase);
		
		for (int i = 0; i < fraseCamelCase.length(); i++) {
		    char letra = fraseCamelCase.charAt(i);

		    lancaExcecaoCasoSejaCaractereEspecial(letra);
		    
		    adicionaPalavraNaoVaziaCasoLetraMaiuscula(letra);
		    adicionaPalavraNaoVaziaCasoNumero(letra);
		    
		    palavraSeparada += Character.toLowerCase(letra);
		}
		
		adicionaPalavraNaoVazia(palavraSeparada); //adiciona última palavra formada
		juntaSiglas();
		
		return palavrasSeparadas;
	}
	
	public static void inicializaVariaveis() {
		palavrasSeparadas = new ArrayList<String>();
		palavraSeparada = "";
	}
	
	public static void lancaExcecaoCasoComeceComNumero (String fraseCamelCase) 
			throws ComecaComNumeroException {
		if(Character.isDigit(fraseCamelCase.charAt(0)))
			throw new ComecaComNumeroException();
	}
	
	public static void lancaExcecaoCasoSejaCaractereEspecial (char letra) 
			throws TemCaractereEspecialException {
		if(!Character.isAlphabetic(letra) && !Character.isDigit(letra))
			throw new TemCaractereEspecialException();
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
	
	public static void adicionaPalavraNaoVazia(String palavra) {
		if(!palavra.isEmpty())
			palavrasSeparadas.add(palavra);
	}
	
	public static void juntaSiglas() {
		List<String> palavrasAux = new ArrayList<String>();
		String palavraAux = "";
		
		for (String palavraSeparada : palavrasSeparadas) {
			if (palavraSeparada.length() == 1) {
				palavraAux += palavraSeparada;
			}else {
				if(!palavraAux.isEmpty()) {
					palavrasAux.add(palavraAux.toUpperCase());
					palavraAux = "";
				}
				palavrasAux.add(palavraSeparada);
			}
		}
		
		//Caso sigla no final
		if(!palavraAux.isEmpty()) {
			palavrasAux.add(palavraAux.toUpperCase());
			palavraAux = "";
		}
		
		palavrasSeparadas = palavrasAux;
	}

}
