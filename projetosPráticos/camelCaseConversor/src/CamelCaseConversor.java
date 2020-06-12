package camelCaseConversor.src;

import java.util.ArrayList;
import java.util.Iterator;
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
		    quebraPalavra(letra);
		    adicionaLetraAPalavraSeparada(letra);
		}
		
		adicionaPalavraNaoVazia(palavraSeparada); //adiciona última palavra separada
		formataPalavrasSeparadas();

		return palavrasSeparadas;
	}
	
	public static void inicializaVariaveis() {
		limpaPalavrasSeparadas();
		limpaPalavraSeparada();
	}
	
	public static void quebraPalavra(char letra) {
		adicionaPalavraNaoVaziaCasoLetraMaiuscula(letra);
	    adicionaPalavraNaoVaziaCasoNumero(letra);
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
    		limpaPalavraSeparada();
	    }
	}
	
	public static void adicionaPalavraNaoVaziaCasoNumero (char ch) {
		if(Character.isDigit(ch)) {
	    	adicionaPalavraNaoVazia(palavraSeparada);
	    	limpaPalavraSeparada();
	    }
	}
	
	public static void adicionaLetraAPalavraSeparada (char ch) {
		palavraSeparada += Character.toLowerCase(ch);
	}
	
	public static void adicionaPalavraNaoVazia(String palavra) {
		if(!palavra.isEmpty())
			palavrasSeparadas.add(palavra);
	}
	
	public static void limpaPalavraSeparada() {
		palavraSeparada = "";
	}
	
	public static void limpaPalavrasSeparadas() {
		palavrasSeparadas = new ArrayList<String>();
	}
	
	public static void formataPalavrasSeparadas() {
		List<String> palavrasSeparadasComSiglasENumeros = new ArrayList<String>();
		String palavraNumero = "";
		String palavraSigla = "";
		
		Iterator<String> palavraI = palavrasSeparadas.iterator();
		
		while(palavraI.hasNext()) {
			String palavra = palavraI.next();
			
			if(éPalavraCompleta(palavra)) {
				if(!palavraNumero.isEmpty()) {
					palavrasSeparadasComSiglasENumeros.add(palavraNumero);
					palavraNumero = "";
				}

				if(!palavraSigla.isEmpty()) {
					palavrasSeparadasComSiglasENumeros.add(palavraSigla);
					palavraSigla = "";
				}
				
				palavrasSeparadasComSiglasENumeros.add(palavra);
			} else {
				char elemento = palavra.charAt(0);
				
				if(Character.isDigit(elemento)) {
					palavraNumero += palavra.toUpperCase();
					if(!palavraSigla.isEmpty()) {
						palavrasSeparadasComSiglasENumeros.add(palavraSigla);
						palavraSigla = "";
					}
				}
				
				if(Character.isAlphabetic(elemento)) {
					palavraSigla += palavra.toUpperCase();
					if(!palavraNumero.isEmpty()) {
						palavrasSeparadasComSiglasENumeros.add(palavraNumero);
						palavraNumero = "";
					}
				}
			}
			
		}

		if(!palavraNumero.isEmpty()) {
			palavrasSeparadasComSiglasENumeros.add(palavraNumero);
			palavraNumero = "";
		}
		
		if(!palavraSigla.isEmpty()) {
			palavrasSeparadasComSiglasENumeros.add(palavraSigla);
			palavraSigla = "";
		}
		
		palavrasSeparadas = palavrasSeparadasComSiglasENumeros;
	}
	
	public static void adicionaSiglaENumeroSeNaoVazio() {
		
	}
	
	
	
	public static boolean éPalavraCompleta(String palavra) {
		if(palavra.length() == 1)
			return false;
		return true;
	}

}
