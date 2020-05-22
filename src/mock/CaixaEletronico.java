package mock;

public class CaixaEletronico {
	private ContaCorrente contaCorrente;
	
	public CaixaEletronico(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
	
	public String logar() {
		return "Logado";
	}
	
	public String sacar() {
		return "Dinheiro sacado";
	}
	
	public String depositar() {
		return "Dinheiro depositado";
	}
	
	public String saldo(){
		return "O saldo é R$";
	}

}
