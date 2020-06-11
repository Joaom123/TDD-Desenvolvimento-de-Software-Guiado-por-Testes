package camelCaseConversor.test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import camelCaseConversor.src.CamelCaseConversor;
import camelCaseConversor.src.exception.ComecaComNumeroException;
import camelCaseConversor.src.exception.TemCaractereEspecialException;

public class CamelCaseConversorTest {
	private List<String> listaComPalavrasQuebradas;
	private String palavraASerQuebrada;
	
	@Before
	public void setUp() {
		listaComPalavrasQuebradas = new ArrayList<String>();
	}

	@Test
	public void converteUmaPalavraQueComecaMinuscula() throws ComecaComNumeroException, TemCaractereEspecialException {
		listaComPalavrasQuebradas.add("primeiro");
		
		palavraASerQuebrada = "primeiro";
		
		assertEquals(listaComPalavrasQuebradas, CamelCaseConversor.converterCamelCase(palavraASerQuebrada));
	}
	
	@Test
	public void converteUmaPalavraQueComecaMaiuscula() throws ComecaComNumeroException, TemCaractereEspecialException {
		listaComPalavrasQuebradas.add("primeiro");
		
		palavraASerQuebrada = "Primeiro";
		
		assertEquals(listaComPalavrasQuebradas, CamelCaseConversor.converterCamelCase(palavraASerQuebrada));
	}
	
	@Test
	public void converteDuasPalavrasQueComecaMinuscula() 
			throws ComecaComNumeroException, TemCaractereEspecialException
	{
		listaComPalavrasQuebradas.add("primeiro");
		listaComPalavrasQuebradas.add("segundo");
		
		palavraASerQuebrada = "primeiroSegundo";
		
		assertEquals(listaComPalavrasQuebradas, CamelCaseConversor.converterCamelCase(palavraASerQuebrada));
	}
	
	@Test
	public void converteDuasPalavrasQueComecaMaiuscula() 
			throws ComecaComNumeroException, TemCaractereEspecialException
	{
		listaComPalavrasQuebradas.add("primeiro");
		listaComPalavrasQuebradas.add("segundo");
		
		palavraASerQuebrada = "PrimeiroSegundo";
		
		assertEquals(listaComPalavrasQuebradas, CamelCaseConversor.converterCamelCase(palavraASerQuebrada));
	}
	
	@Test
	public void converteSigla() throws ComecaComNumeroException, TemCaractereEspecialException{
		listaComPalavrasQuebradas.add("CPF");
		
		palavraASerQuebrada = "CPF";
		
		assertEquals(listaComPalavrasQuebradas, CamelCaseConversor.converterCamelCase(palavraASerQuebrada));
	}

	@Test
	public void converteDuasPalavrasComSigla() throws ComecaComNumeroException, TemCaractereEspecialException{
		listaComPalavrasQuebradas.add("numero");
		listaComPalavrasQuebradas.add("CPF");
		
		palavraASerQuebrada = "numeroCPF";
		
		assertEquals(listaComPalavrasQuebradas, CamelCaseConversor.converterCamelCase(palavraASerQuebrada));
	}
	
	@Test
	public void converteTresPalavrasComSiglaNoMeio() throws ComecaComNumeroException, TemCaractereEspecialException{
		listaComPalavrasQuebradas.add("numero");
		listaComPalavrasQuebradas.add("CPF");
		listaComPalavrasQuebradas.add("contribuinte");
		
		palavraASerQuebrada = "numeroCPFContribuinte";
		
		assertEquals(listaComPalavrasQuebradas, CamelCaseConversor.converterCamelCase(palavraASerQuebrada));
	}
	
	@Test
	public void converteTresPalavrasComNumeroNoMeio() throws ComecaComNumeroException, TemCaractereEspecialException{
		listaComPalavrasQuebradas.add("recupera");
		listaComPalavrasQuebradas.add("10");
		listaComPalavrasQuebradas.add("primeiros");
		
		palavraASerQuebrada = "recupera10Primeiros";
		
		assertEquals(listaComPalavrasQuebradas, CamelCaseConversor.converterCamelCase(palavraASerQuebrada));
	}
	
	@Test
	public void converteCasoTenhaConjunçõesCoordenativas() 
			throws ComecaComNumeroException, TemCaractereEspecialException
	{
		listaComPalavrasQuebradas.add("estado");
		listaComPalavrasQuebradas.add("E");
		listaComPalavrasQuebradas.add("escola");
		listaComPalavrasQuebradas.add("E");
		listaComPalavrasQuebradas.add("família");
		
		palavraASerQuebrada = "estadoEEscolaEFamília";
		
		assertEquals(listaComPalavrasQuebradas, CamelCaseConversor.converterCamelCase(palavraASerQuebrada));
	}
	
	@Test(expected = ComecaComNumeroException.class)
	public void naoConverteComNumeroNoInicio() throws ComecaComNumeroException, TemCaractereEspecialException{
		palavraASerQuebrada = "10Primeiros";
		
		CamelCaseConversor.converterCamelCase(palavraASerQuebrada);
	}
	
	@Test(expected = TemCaractereEspecialException.class)
	public void naoConverteComCaractereEspecial() 
			throws ComecaComNumeroException, TemCaractereEspecialException
	{
		palavraASerQuebrada = "nome#Composto";
		
		CamelCaseConversor.converterCamelCase(palavraASerQuebrada);
	}
	
	@Test
	public void converteCasoNumerosESiglasEstejamJuntos() 
			throws ComecaComNumeroException, TemCaractereEspecialException
	{
		listaComPalavrasQuebradas.add("tenho");
		listaComPalavrasQuebradas.add("2");
		listaComPalavrasQuebradas.add("CPF");
		
		palavraASerQuebrada = "Tenho2CPF";
		
		assertEquals(listaComPalavrasQuebradas, CamelCaseConversor.converterCamelCase(palavraASerQuebrada));
	}
}
