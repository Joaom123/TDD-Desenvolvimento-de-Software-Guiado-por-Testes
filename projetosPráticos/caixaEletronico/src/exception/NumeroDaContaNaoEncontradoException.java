package caixaEletronico.src.exception;

public class NumeroDaContaNaoEncontradoException extends Exception {

	private static final long serialVersionUID = 7034178586356685811L;

	public NumeroDaContaNaoEncontradoException() {
		super("Número da conta não foi encontrado");
	}
}
