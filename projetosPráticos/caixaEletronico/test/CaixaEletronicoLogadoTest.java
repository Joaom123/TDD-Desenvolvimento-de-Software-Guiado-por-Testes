package caixaEletronico.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import caixaEletronico.src.CaixaEletronico;
import caixaEletronico.src.ContaCorrente;
import caixaEletronico.test.mock.HardwareMock;
import caixaEletronico.test.mock.ServicoRemotoMock;

public class CaixaEletronicoLogadoTest {
	private ContaCorrente contaCorrente;
	private CaixaEletronico caixaEletronico;
	private HardwareMock hardwareMock;
	private ServicoRemotoMock servicoRemotoMock;
	
	@Before
	public void setUp() {
		hardwareMock = new HardwareMock();
		servicoRemotoMock = new ServicoRemotoMock();
		contaCorrente = new ContaCorrente("123123", "senha", 100.0);
		
		servicoRemotoMock.setContaCorrenteRecuperada(contaCorrente);
		hardwareMock.setNumeroDaContaCartao(contaCorrente.getNumero());
		
		caixaEletronico = new CaixaEletronico(hardwareMock, servicoRemotoMock);
		caixaEletronico.logar("senha");
	}
	
	@Test
	public void depositarEExibeMensagem() {
		double dinheiroASerDepositado = 230.0;
		String mensagem = caixaEletronico.depositar(dinheiroASerDepositado);
		
		assertEquals(330.0, contaCorrente.getSaldo(), 0);
		assertEquals("Depósito recebido com sucesso", mensagem);
	}
	
	@Test
	public void sacarValorInferiorAoSaldoEExibeMensagem(){
		double dinheiroASerSacado = 50.0;
		
		String mensagem = caixaEletronico.sacar(dinheiroASerSacado);
		
		assertEquals(50.0, contaCorrente.getSaldo(), 0);
		assertEquals("Retire seu dinheiro", mensagem);
	}

	@Test
	public void sacarValorIgualAoSaldoEExibeMensagem(){
		double dinheiroASerSacado = 100.0;
		
		String mensagem = caixaEletronico.sacar(dinheiroASerSacado);
		
		assertEquals(0.0, contaCorrente.getSaldo(), 0);
		assertEquals("Retire seu dinheiro", mensagem);
	}

	@Test
	public void sacarValorSuperiorAoSaldoEExibeMensagem(){
		double dinheiroASerSacado = 150.0;
		
		String mensagem = caixaEletronico.sacar(dinheiroASerSacado);
		
		assertEquals(100.0, contaCorrente.getSaldo(), 0);
		assertEquals("Saldo insuficiente", mensagem);
	}
	
	@Test
	public void exibeSaldo(){
		String mensagemCorreta = "O saldo é R$ 100.0";
		String mensagemRecebida = caixaEletronico.saldo();
		
		assertEquals(mensagemCorreta, mensagemRecebida);
	}
}
