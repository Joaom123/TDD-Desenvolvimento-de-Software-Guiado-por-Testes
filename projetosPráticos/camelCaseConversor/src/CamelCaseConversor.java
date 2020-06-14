package camelCaseConversor.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import camelCaseConversor.src.exception.ComecaComNumeroException;
import camelCaseConversor.src.exception.TemCaractereEspecialException;

public class CamelCaseConversor {
	private static List<String> palavrasSeparadas;
	private static String palavraSeparada;
	
	public static List<String> converterCamelCase (String fraseCamelCase) 
			throws ComecaComNumeroException, TemCaractereEspecialException {
		inicializaVariaveis();
		lancaExcecaoCasoComeceComNumero(fraseCamelCase);
		
		for (int i = 0; i < fraseCamelCase.length(); i++) {
		    char letra = fraseCamelCase.charAt(i);

		    lancaExcecaoCasoSejaCaractereEspecial(letra);
		    quebraPalavra(letra);
		    adicionaLetraAPalavraSeparada(letra);
		}
		
		adicionaPalavraNaoVazia(palavraSeparada); //adiciona última palavra separada
		formataPalavrasSeparadas();

		return palavrasSeparadas;
	}
	
	private static void inicializaVariaveis() {
		limpaPalavrasSeparadas();
		limpaPalavraSeparada();
	}
	
	private static void quebraPalavra(char letra) {
		adicionaPalavraNaoVaziaCasoLetraMaiuscula(letra);
	    adicionaPalavraNaoVaziaCasoNumero(letra);
	}
	
	private static void lancaExcecaoCasoComeceComNumero (String fraseCamelCase) 
			throws ComecaComNumeroException {
		if(Character.isDigit(fraseCamelCase.charAt(0)))
			throw new ComecaComNumeroException();
	}
	
	private static void lancaExcecaoCasoSejaCaractereEspecial (char letra) 
			throws TemCaractereEspecialException {
		if(!Character.isAlphabetic(letra) && !Character.isDigit(letra))
			throw new TemCaractereEspecialException();
	}
	
	private static void adicionaPalavraNaoVaziaCasoLetraMaiuscula (char ch) {
		if(Character.isUpperCase(ch)) {
    		adicionaPalavraNaoVazia(palavraSeparada);
    		limpaPalavraSeparada();
	    }
	}
	
	private static void adicionaPalavraNaoVaziaCasoNumero (char ch) {
		if(Character.isDigit(ch)) {
	    	adicionaPalavraNaoVazia(palavraSeparada);
	    	limpaPalavraSeparada();
	    }
	}
	
	private static void adicionaLetraAPalavraSeparada (char ch) {
		palavraSeparada += Character.toLowerCase(ch);
	}
	
	private static void adicionaPalavraNaoVazia(String palavra) {
		if(!palavra.isEmpty())
			palavrasSeparadas.add(palavra);
	}
	
	private static void limpaPalavraSeparada() {
		palavraSeparada = "";
	}
	
	private static void limpaPalavrasSeparadas() {
		palavrasSeparadas = new ArrayList<String>();
	}
	
	private static void formataPalavrasSeparadas() {
		List<String> palavrasSeparadasComSiglasENumeros = new ArrayList<String>();
		String palavraNumero = "";
		String palavraSigla = "";
		
		Iterator<String> palavraI = palavrasSeparadas.iterator();
		
		while(palavraI.hasNext()) {
			String palavra = palavraI.next();
			
			if(éPalavraCompleta(palavra)) {
				palavraNumero = adicionaPalavraNaoVaziaELimpa(palavrasSeparadasComSiglasENumeros, palavraNumero);
				palavraSigla = adicionaPalavraNaoVaziaELimpa(palavrasSeparadasComSiglasENumeros, palavraSigla);
				palavrasSeparadasComSiglasENumeros.add(palavra);
			} else {
				char elemento = palavra.charAt(0);
				
				if(Character.isDigit(elemento)) {
					palavraNumero += palavra;
					palavraSigla = adicionaPalavraNaoVaziaELimpa(palavrasSeparadasComSiglasENumeros, palavraSigla);
				}
				
				if(Character.isAlphabetic(elemento)) {
					palavraSigla += palavra.toUpperCase();
					palavraNumero = adicionaPalavraNaoVaziaELimpa(palavrasSeparadasComSiglasENumeros, palavraNumero);
				}
			}
			
		}

		palavraNumero = adicionaPalavraNaoVaziaELimpa(palavrasSeparadasComSiglasENumeros, palavraNumero);
		palavraSigla = adicionaPalavraNaoVaziaELimpa(palavrasSeparadasComSiglasENumeros, palavraSigla);
		
		palavrasSeparadas = palavrasSeparadasComSiglasENumeros;
	}
	
	
	private static String adicionaPalavraNaoVaziaELimpa(
			List<String> palavrasSeparadasComSiglasENumeros, String palavra
			) {
		if(!palavra.isEmpty()) {
			palavrasSeparadasComSiglasENumeros.add(palavra);
			palavra = "";
		}
		return palavra;
	}

	private static boolean éPalavraCompleta(String palavra) {
		if(palavra.length() == 1)
			return false;
		return true;
	}

}
