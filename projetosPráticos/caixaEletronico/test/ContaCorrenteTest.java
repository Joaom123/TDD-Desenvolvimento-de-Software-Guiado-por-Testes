package caixaEletronico.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import caixaEletronico.src.ContaCorrente;
import caixaEletronico.src.exception.SaldoInsuficienteException;

public class ContaCorrenteTest {
	private ContaCorrente contaCorrente;

	@Before
	public void setUp() {
		contaCorrente = new ContaCorrente("joao", "123", 100.0);
	}
	
	@Test
	public void testaAdicionarSaldo() {
		contaCorrente.adicionaAoSaldo(100.0);
		assertEquals(200.0, contaCorrente.getSaldo(), 0);
	}
	
	@Test
	public void testaSubtrairMenosDaConta() throws SaldoInsuficienteException {
		contaCorrente.subtraiDoSaldo(99.0);
		assertEquals(1.0, contaCorrente.getSaldo(), 0);
	}
	
	@Test(expected = SaldoInsuficienteException.class)
	public void testaSubtraitMaisDaConta() throws SaldoInsuficienteException {
		contaCorrente.subtraiDoSaldo(101.0);
	}
	
	@Test
	public void testaSubtrairIgualDaConta() throws SaldoInsuficienteException {
		contaCorrente.subtraiDoSaldo(100.0);
		assertEquals(0.0, contaCorrente.getSaldo(), 0);
	}

}
