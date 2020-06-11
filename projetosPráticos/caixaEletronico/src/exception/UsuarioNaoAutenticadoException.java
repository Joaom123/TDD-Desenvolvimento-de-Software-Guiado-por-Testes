package caixaEletronico.src.exception;

public class UsuarioNaoAutenticadoException extends Exception {
	
	private static final long serialVersionUID = -3207527838693083461L;

	public UsuarioNaoAutenticadoException() {
		super("Usuário não autenticado");
	}

}
