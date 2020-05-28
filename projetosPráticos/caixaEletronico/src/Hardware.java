package caixaEletronico.src;

import caixaEletronico.src.exception.ProblemaHardwareException;

public interface Hardware {
	public String pegarNumeroDaContaCartao() throws ProblemaHardwareException;
	
	public void entregarDinheiro() throws ProblemaHardwareException;
	
	public void lerEnvelope() throws ProblemaHardwareException;
}
