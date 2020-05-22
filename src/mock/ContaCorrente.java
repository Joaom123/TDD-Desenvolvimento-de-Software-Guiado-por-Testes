package mock;

public class ContaCorrente implements ServicoRemoto {
	private int numero;
	private float saldo;

	@Override
	public float recuperarConta(int numero) {
		return saldo;
	}

	@Override
	public void persistirConta() {
		// TODO Auto-generated method stub
		
	}

}
