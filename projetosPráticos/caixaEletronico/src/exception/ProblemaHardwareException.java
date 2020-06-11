package caixaEletronico.src.exception;

public class ProblemaHardwareException extends Exception {

	private static final long serialVersionUID = -6639719911472265833L;

	public ProblemaHardwareException() {
		super("Houve um erro no hardware");
	}
}
