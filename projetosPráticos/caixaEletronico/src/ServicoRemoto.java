package caixaEletronico.src;

public interface ServicoRemoto {
	public ContaCorrente recuperarConta(String numero);
	
	public void persistirConta();
}
