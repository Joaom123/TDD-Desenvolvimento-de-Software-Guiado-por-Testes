package mock;

public class CaixaEletronico {
	private ContaCorrente contaCorrente;
	
	public CaixaEletronico(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
	
	public String logar() {
		return "Logado";
	}
	
	public String sacar(double dinheiroASerSacado) {
		contaCorrente.subtraiDoSaldo(dinheiroASerSacado);
		return "Retire seu dinheiro";
	}
	
	public String depositar(double dinheiroASerDepositado) {
		contaCorrente.adicionaAoSaldo(dinheiroASerDepositado);
		return "Depósito recebido com sucesso";
	}
	
	public String saldo(){
		return "O saldo é R$ " + contaCorrente.getSaldo();
	}

}
