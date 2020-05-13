package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import camelCaseConversor.CamelCaseConversor;

public class CamelCaseConversorTest {
	private List<String> listaComPalavras;
	private String palavraASerQuebrada;
	
	@Before
	public void inicializaArray() {
		listaComPalavras = new ArrayList<String>();
	}

	@Test
	public void converteUmaPalavraQueComecaMinuscula() {
		listaComPalavras.add("primeiro");
		palavraASerQuebrada = "primeiro";
		
		assertEquals(listaComPalavras, CamelCaseConversor.converterCamelCase(palavraASerQuebrada));
	}
	
	@Test
	public void converteUmaPalavraQueComecaMaiuscula() {
		listaComPalavras.add("primeiro");
		palavraASerQuebrada = "Primeiro";
		
		assertEquals(listaComPalavras, CamelCaseConversor.converterCamelCase(palavraASerQuebrada));
	}
	
	@Test
	public void converteDuasPalavrasQueComecaMinuscula(){
		listaComPalavras.add("primeiro");
		listaComPalavras.add("segundo");
		palavraASerQuebrada = "PrimeiroSegundo";
		
		assertEquals(listaComPalavras, CamelCaseConversor.converterCamelCase(palavraASerQuebrada));
	}
	
	@Test
	public void converteDuasPalavrasQueComecaMaiuscula(){
		listaComPalavras.add("primeiro");
		listaComPalavras.add("segundo");
		palavraASerQuebrada = "primeiroSegundo";
		
		assertEquals(listaComPalavras, CamelCaseConversor.converterCamelCase(palavraASerQuebrada));
	}
	
	@Test
	public void converteSigla(){
		listaComPalavras.add("CPF");
		palavraASerQuebrada = "CPF";
		
		assertEquals(listaComPalavras, CamelCaseConversor.converterCamelCase(palavraASerQuebrada));
	}

}
