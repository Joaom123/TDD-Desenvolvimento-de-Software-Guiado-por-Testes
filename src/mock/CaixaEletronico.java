package mock;

public class CaixaEletronico {
	private ContaCorrente contaCorrente;
	
	public CaixaEletronico(int numeroDaConta) {
		this.contaCorrente = ContaCorrente.recuperarConta(numeroDaConta);
	}
	
	public String logar(int numeroDaConta) {
		try {
			ContaCorrente.recuperarConta(numeroDaConta);
			return "Usuário Autenticado";
		} catch (Exception e) {
			return "Não foi possível autenticar o usuário";
		}
	}
	
	public String sacar(double dinheiroASerSacado) {
		try {
			contaCorrente.subtraiDoSaldo(dinheiroASerSacado);
			return "Retire seu dinheiro";
		} catch (SaldoInsuficienteException e) {
			return e.getMessage();
		}
	}
	
	public String depositar(double dinheiroASerDepositado) {
		contaCorrente.adicionaAoSaldo(dinheiroASerDepositado);
		return "Depósito recebido com sucesso";
	}
	
	public String saldo(){
		return "O saldo é R$ " + contaCorrente.getSaldo();
	}

}
