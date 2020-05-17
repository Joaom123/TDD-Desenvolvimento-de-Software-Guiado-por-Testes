package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import camelCaseConversor.CamelCaseConversor;

public class CamelCaseConversorTest {
	private List<String> listaComPalavrasQuebradas;
	private String palavraASerQuebrada;
	
	@Before
	public void inicializaArray() {
		listaComPalavrasQuebradas = new ArrayList<String>();
	}

	@Test
	public void converteUmaPalavraQueComecaMinuscula() {
		listaComPalavrasQuebradas.add("primeiro");
		palavraASerQuebrada = "primeiro";
		
		assertEquals(listaComPalavrasQuebradas, CamelCaseConversor.converterCamelCase(palavraASerQuebrada));
	}
	
	@Test
	public void converteUmaPalavraQueComecaMaiuscula() {
		listaComPalavrasQuebradas.add("primeiro");
		palavraASerQuebrada = "Primeiro";
		
		assertEquals(listaComPalavrasQuebradas, CamelCaseConversor.converterCamelCase(palavraASerQuebrada));
	}
	
	@Test
	public void converteDuasPalavrasQueComecaMinuscula(){
		listaComPalavrasQuebradas.add("primeiro");
		listaComPalavrasQuebradas.add("segundo");
		palavraASerQuebrada = "PrimeiroSegundo";
		
		assertEquals(listaComPalavrasQuebradas, CamelCaseConversor.converterCamelCase(palavraASerQuebrada));
	}
	
	@Test
	public void converteDuasPalavrasQueComecaMaiuscula(){
		listaComPalavrasQuebradas.add("primeiro");
		listaComPalavrasQuebradas.add("segundo");
		palavraASerQuebrada = "primeiroSegundo";
		
		assertEquals(listaComPalavrasQuebradas, CamelCaseConversor.converterCamelCase(palavraASerQuebrada));
	}
	
	@Test
	public void converteSigla(){
		listaComPalavrasQuebradas.add("CPF");
		palavraASerQuebrada = "CPF";
		
		assertEquals(listaComPalavrasQuebradas, CamelCaseConversor.converterCamelCase(palavraASerQuebrada));
	}

	@Test
	public void converteDuasPalavrasComSigla(){
		listaComPalavrasQuebradas.add("numero");
		listaComPalavrasQuebradas.add("CPF");
		palavraASerQuebrada = "numeroCPF";
		
		assertEquals(listaComPalavrasQuebradas, CamelCaseConversor.converterCamelCase(palavraASerQuebrada));
	}
	
	@Test
	public void converteTresPalavrasComSiglaNoMeio(){
		listaComPalavrasQuebradas.add("numero");
		listaComPalavrasQuebradas.add("CPF");
		listaComPalavrasQuebradas.add("contribuinte");
		palavraASerQuebrada = "numeroCPFContribuinte";
		
		assertEquals(listaComPalavrasQuebradas, CamelCaseConversor.converterCamelCase(palavraASerQuebrada));
	}
}
