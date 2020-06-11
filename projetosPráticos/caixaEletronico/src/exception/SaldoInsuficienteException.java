package caixaEletronico.src.exception;

public class SaldoInsuficienteException extends Exception {
	
	private static final long serialVersionUID = -1847806209769794795L;

	public SaldoInsuficienteException(String mensagem) {
		super(mensagem);
	}
}
