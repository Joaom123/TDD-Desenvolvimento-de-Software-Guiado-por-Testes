package caixaEletronico.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import caixaEletronico.src.CaixaEletronico;
import caixaEletronico.src.ContaCorrente;

public class CaixaEletronicoTest {
	private ContaCorrente contaCorrente;
	private CaixaEletronico caixaEletronico;
	
	@Before
	public void inicializaContaCorrente() {
		contaCorrente = new ContaCorrente(123, 100.0);
		caixaEletronico = new CaixaEletronico();
	}
	
	@Test
	public void logarCorretamente() {
		String mensagem = caixaEletronico.logar(123);
		
		assertEquals("Usuário Autenticado", mensagem); 
	}
	
	@Test
	public void logarFalhando(){
		String mensagem = caixaEletronico.logar(1234);
		
		assertEquals("Não foi possível autenticar o usuário", mensagem);
	}

	@Test
	public void depositarEExibirSaldo() {
		double dinheiroASerDepositado = 230.0;
		caixaEletronico.logar(123);
		String mensagem = caixaEletronico.depositar(dinheiroASerDepositado);
		
		assertEquals(330.0, contaCorrente.getSaldo(), 0);
		assertEquals("Depósito recebido com sucesso", mensagem);
	}
	
	@Test
	public void sacarValorInferiorAoSaldo(){
		double dinheiroASerSacado = 50.0;
		
		String mensagem = caixaEletronico.sacar(dinheiroASerSacado);
		
		assertEquals(50.0, contaCorrente.getSaldo(), 0);
		assertEquals("Retire seu dinheiro", mensagem);
	}

	@Test
	public void sacarValorIgualAoSaldo(){
		double dinheiroASerSacado = 100.0;
		
		String mensagem = caixaEletronico.sacar(dinheiroASerSacado);
		
		assertEquals(0.0, contaCorrente.getSaldo(), 0);
		assertEquals("Retire seu dinheiro", mensagem);
	}

	@Test
	public void sacarValorSuperiorAoSaldo(){
		double dinheiroASerSacado = 150.0;
		
		String mensagem = caixaEletronico.sacar(dinheiroASerSacado);
		
		assertEquals(100.0, contaCorrente.getSaldo(), 0);
		assertEquals("Saldo insuficiente", mensagem);
	}
	
	@Test
	public void mensagemDeSaldo(){
		String mensagemCorreta = "O saldo é R$ 100.0";
		String mensagemRecebida = caixaEletronico.saldo();
		
		assertEquals(mensagemCorreta, mensagemRecebida);
	}
}
