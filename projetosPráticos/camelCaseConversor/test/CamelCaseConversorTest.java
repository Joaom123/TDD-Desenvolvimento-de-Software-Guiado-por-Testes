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
	private List<String> palavrasSeparadas;
	private String fraseCamelCase;
	
	@Before
	public void setUp() {
		palavrasSeparadas = new ArrayList<String>();
	}

	@Test
	public void converteUmaPalavraQueComecaMinuscula() 
			throws ComecaComNumeroException, TemCaractereEspecialException 
	{
		fraseCamelCase = "primeiro";

		palavrasSeparadas.add("primeiro");
		
		assertEquals(palavrasSeparadas, CamelCaseConversor.converterCamelCase(fraseCamelCase));
	}
	
	@Test
	public void converteUmaPalavraQueComecaMaiuscula() 
			throws ComecaComNumeroException, TemCaractereEspecialException 
	{
		fraseCamelCase = "Primeiro";

		palavrasSeparadas.add("primeiro");
		
		assertEquals(palavrasSeparadas, CamelCaseConversor.converterCamelCase(fraseCamelCase));
	}
	
	@Test
	public void converteDuasPalavrasQueComecaMinuscula() 
			throws ComecaComNumeroException, TemCaractereEspecialException
	{
		fraseCamelCase = "primeiroSegundo";

		palavrasSeparadas.add("primeiro");
		palavrasSeparadas.add("segundo");
		
		assertEquals(palavrasSeparadas, CamelCaseConversor.converterCamelCase(fraseCamelCase));
	}
	
	@Test
	public void converteDuasPalavrasQueComecaMaiuscula() 
			throws ComecaComNumeroException, TemCaractereEspecialException
	{
		fraseCamelCase = "PrimeiroSegundo";

		palavrasSeparadas.add("primeiro");
		palavrasSeparadas.add("segundo");
		
		assertEquals(palavrasSeparadas, CamelCaseConversor.converterCamelCase(fraseCamelCase));
	}
	
	@Test
	public void converteSigla() 
			throws ComecaComNumeroException, TemCaractereEspecialException
	{
		fraseCamelCase = "CPF";

		palavrasSeparadas.add("CPF");
		
		assertEquals(palavrasSeparadas, CamelCaseConversor.converterCamelCase(fraseCamelCase));
	}

	@Test
	public void converteDuasPalavrasComSigla() 
			throws ComecaComNumeroException, TemCaractereEspecialException
	{
		fraseCamelCase = "numeroCPF";

		palavrasSeparadas.add("numero");
		palavrasSeparadas.add("CPF");
		
		assertEquals(palavrasSeparadas, CamelCaseConversor.converterCamelCase(fraseCamelCase));
	}
	
	@Test
	public void converteTresPalavrasComSiglaNoMeio() 
			throws ComecaComNumeroException, TemCaractereEspecialException
	{
		fraseCamelCase = "numeroCPFContribuinte";

		palavrasSeparadas.add("numero");
		palavrasSeparadas.add("CPF");
		palavrasSeparadas.add("contribuinte");
		
		assertEquals(palavrasSeparadas, CamelCaseConversor.converterCamelCase(fraseCamelCase));
	}
	
	@Test
	public void converteTresPalavrasComNumeroNoMeio() 
			throws ComecaComNumeroException, TemCaractereEspecialException
	{
		fraseCamelCase = "recupera10Primeiros";

		palavrasSeparadas.add("recupera");
		palavrasSeparadas.add("10");
		palavrasSeparadas.add("primeiros");
		
		assertEquals(palavrasSeparadas, CamelCaseConversor.converterCamelCase(fraseCamelCase));
	}
	
	@Test
	public void converteCasoTenhaConjunçõesCoordenativas() 
			throws ComecaComNumeroException, TemCaractereEspecialException
	{
		fraseCamelCase = "estadoEEscolaEFamília";

		palavrasSeparadas.add("estado");
		palavrasSeparadas.add("E");
		palavrasSeparadas.add("escola");
		palavrasSeparadas.add("E");
		palavrasSeparadas.add("família");
		
		assertEquals(palavrasSeparadas, CamelCaseConversor.converterCamelCase(fraseCamelCase));
	}
	
	@Test(expected=ComecaComNumeroException.class)
	public void naoConverteComNumeroNoInicio() 
			throws ComecaComNumeroException, TemCaractereEspecialException
	{
		fraseCamelCase = "10Primeiros";
		
		CamelCaseConversor.converterCamelCase(fraseCamelCase);
	}
	
	@Test(expected=TemCaractereEspecialException.class)
	public void naoConverteComCaractereEspecial() 
			throws ComecaComNumeroException, TemCaractereEspecialException
	{
		fraseCamelCase = "nome#Composto";
		
		CamelCaseConversor.converterCamelCase(fraseCamelCase);
	}
	
	@Test
	public void converteCasoNumerosESiglasEstejamJuntos() 
			throws ComecaComNumeroException, TemCaractereEspecialException
	{
		fraseCamelCase = "Tenho2CNPJ";

		palavrasSeparadas.add("tenho");
		palavrasSeparadas.add("2");
		palavrasSeparadas.add("CNPJ");
		
		assertEquals(palavrasSeparadas, CamelCaseConversor.converterCamelCase(fraseCamelCase));
	}
	
	@Test
	public void converteCasoVariasSiglasENumerosEPalavrasCompostas() 
			throws ComecaComNumeroException, TemCaractereEspecialException
	{
		fraseCamelCase = "Tenho2CNPJ34CPFSeguinte43CMPP21";

		palavrasSeparadas.add("tenho");
		palavrasSeparadas.add("2");
		palavrasSeparadas.add("CNPJ");
		palavrasSeparadas.add("34");
		palavrasSeparadas.add("CPF");
		palavrasSeparadas.add("seguinte");
		palavrasSeparadas.add("43");
		palavrasSeparadas.add("CMPP");
		palavrasSeparadas.add("21");
		
		assertEquals(palavrasSeparadas, CamelCaseConversor.converterCamelCase(fraseCamelCase));
	}
}
