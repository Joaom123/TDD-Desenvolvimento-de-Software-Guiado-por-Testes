package caixaEletronico.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import caixaEletronico.src.CaixaEletronico;
import caixaEletronico.src.ContaCorrente;
import caixaEletronico.test.mock.HardwareMock;
import caixaEletronico.test.mock.ServicoRemotoMock;

public class CaixaEletronicoNaoLogado {
	
	private HardwareMock hardwareMock;
	private ServicoRemotoMock servicoRemotoMock;
	private ContaCorrente contaCorrente;
	private CaixaEletronico caixaEletronico;	
	private String mensagemDeErroPadrão = "Usuário não autenticado";

	@Before
	public void setUp() {
		hardwareMock = new HardwareMock();
		servicoRemotoMock = new ServicoRemotoMock();
		contaCorrente = new ContaCorrente("123123", "senha", 100.0);
		
		servicoRemotoMock.setContaCorrenteRecuperada(contaCorrente);
		hardwareMock.setNumeroDaContaCartao(contaCorrente.getNumero());
		
		caixaEletronico = new CaixaEletronico(hardwareMock, servicoRemotoMock);
		caixaEletronico.logar("senhaErrada");
	}

	@Test
	public void tentaSacar() {
		double dinheiroASerSacado = 80.0;
		double dinheiroAntes = contaCorrente.getSaldo();
		
		String mensagem = caixaEletronico.sacar(dinheiroASerSacado);
		
		double dinheiroDepois = contaCorrente.getSaldo();
		
		assertEquals(dinheiroDepois - dinheiroAntes, 0.0, 0);
		assertEquals(mensagemDeErroPadrão, mensagem);
	}
	
	@Test
	public void tentarVerSaldo() {
		String mensagem = caixaEletronico.saldo();
		
		assertEquals(mensagemDeErroPadrão, mensagem);
	}
	
	@Test
	public void tentarDepositar() {
		String mensagem = caixaEletronico.depositar(50.0);
		
		assertEquals(mensagemDeErroPadrão, mensagem);
	}

}
