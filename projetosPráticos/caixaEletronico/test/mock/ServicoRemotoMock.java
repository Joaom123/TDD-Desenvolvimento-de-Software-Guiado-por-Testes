package caixaEletronico.test.mock;

import caixaEletronico.src.ContaCorrente;
import caixaEletronico.src.ServicoRemoto;
import caixaEletronico.src.exception.NumeroDaContaNaoEncontradoException;

public class ServicoRemotoMock implements ServicoRemoto {
	private ContaCorrente contaCorrenteRecuperada;

	@Override
	public ContaCorrente recuperarConta(String numeroDaConta) throws NumeroDaContaNaoEncontradoException {
		if(numeroDaConta == this.contaCorrenteRecuperada.getNumero())
			return contaCorrenteRecuperada;
		throw new NumeroDaContaNaoEncontradoException();
	}

	@Override
	public void persistirConta(ContaCorrente contaCorrenteAPersistir) {
		// TODO Auto-generated method stub
		
	}
	
	public void setContaCorrenteRecuperada(ContaCorrente contaCorrente) {
		this.contaCorrenteRecuperada = contaCorrente;
	}
	

}
