package caixaEletronico.test.mock;

import caixaEletronico.src.ContaCorrente;
import caixaEletronico.src.ServicoRemoto;

public class ServicoRemotoMock implements ServicoRemoto {

	@Override
	public ContaCorrente recuperarConta(String numero) {
		return new ContaCorrente();
	}

	@Override
	public void persistirConta() {
		// TODO Auto-generated method stub
		
	}

}
