package mock;

public class ContaCorrente implements ServicoRemoto {
	private int numero;
	private double saldo;
	
	public ContaCorrente(int numero, double saldo) {
		this.numero = numero;
		this.saldo = saldo;
	}

	public static ContaCorrente recuperarConta(int numero) throws RuntimeException{
		if (numero != 123)
			throw new RuntimeException("Conta não existe");
		return new ContaCorrente(numero, 100.0);
	}

	@Override
	public void persistirConta() {
		
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void adicionaAoSaldo(double dinheiroASerAdicionado) {
		saldo += dinheiroASerAdicionado;
	}
	
	public void subtraiDoSaldo(double dinheiroASerSubtraido) throws SaldoInsuficienteException {
		if(saldo < dinheiroASerSubtraido)
			throw new SaldoInsuficienteException("Saldo insuficiente");
			
		saldo -= dinheiroASerSubtraido;
	}

}
