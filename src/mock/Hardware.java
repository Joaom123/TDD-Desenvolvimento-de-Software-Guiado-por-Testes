package mock;

public interface Hardware {
	//ler o número da conta do cartão para o login
	//retorna uma String com o número da conta
	public String pegarNumeroDaContaCartao();
	
	//entrega o dinheiro no caso do saque
	public void entregarDinheiro();
	
	//recebe o envelope com dinheiro na operação de depósito
	public void lerEnvelope();
}
