package caixaEletronico.test.mock;

import caixaEletronico.src.Hardware;
import caixaEletronico.src.exception.ProblemaHardwareException;

public class HardwareMock implements Hardware {
	private String numeroDaContaCartao;

	@Override
	public String pegarNumeroDaContaCartao() throws ProblemaHardwareException {
		if (numeroDaContaCartao != null)
			return numeroDaContaCartao;
		throw new ProblemaHardwareException(); 
	}

	@Override
	public void entregarDinheiro() throws ProblemaHardwareException {
		return ;
	}

	@Override
	public void lerEnvelope() throws ProblemaHardwareException {
		return ;
	}
	
	public void setNumeroDaContaCartao(String numeroDaContaCartao) {
		this.numeroDaContaCartao = numeroDaContaCartao;
	}

}
