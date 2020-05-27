package caixaEletronico.test.mock;

import caixaEletronico.src.Hardware;

public class HardwareMock implements Hardware {

	@Override
	public String pegarNumeroDaContaCartao() {
		return "123123";
	}

	@Override
	public void entregarDinheiro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lerEnvelope() {
		// TODO Auto-generated method stub
		
	}

}
