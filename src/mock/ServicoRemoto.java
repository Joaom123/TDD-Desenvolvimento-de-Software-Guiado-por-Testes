package mock;

public interface ServicoRemoto {
//	recupera uma conta baseada no seu número
	public double recuperarConta(int numero);
	
//	grava alterações, como uma mudança no saldo devido a um saque ou depósito.
	public void persistirConta();
}
