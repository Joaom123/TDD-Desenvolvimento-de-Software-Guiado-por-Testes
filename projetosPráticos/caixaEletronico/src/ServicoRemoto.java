package caixaEletronico.src;

import caixaEletronico.src.exception.NumeroDaContaNaoEncontradoException;

public interface ServicoRemoto {
	public ContaCorrente recuperarConta(String numero) throws NumeroDaContaNaoEncontradoException;
	
	public void persistirConta(ContaCorrente contaCorrente);
}
