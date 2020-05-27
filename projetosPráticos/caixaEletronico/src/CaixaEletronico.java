package caixaEletronico.src;

import caixaEletronico.src.exception.SaldoInsuficienteException;

public class CaixaEletronico {
	private ContaCorrente contaCorrente;
	private ServicoRemoto servicoRemoto;
	private Hardware hardware;
	
	public CaixaEletronico(Hardware hardware, ServicoRemoto servicoRemoto) {
		this.hardware = hardware;
		this.servicoRemoto = servicoRemoto;
	}
	
	public String logar(String senha) {
		try {
			String numeroDaConta = hardware.pegarNumeroDaContaCartao();
			this.contaCorrente = servicoRemoto.recuperarConta(numeroDaConta);
			return "Usuário Autenticado";
		} catch (Exception e) {
			return "Não foi possível autenticar o usuário";
		}
	}
	
	public String sacar(double dinheiroASerSacado) {
		try {
			contaCorrente.subtraiDoSaldo(dinheiroASerSacado);
			servicoRemoto.persistirConta();
			hardware.entregarDinheiro();
			
			return "Retire seu dinheiro";
		} catch (SaldoInsuficienteException e) {
			return e.getMessage();
		}
	}
	
	public String depositar(double dinheiroASerDepositado) {
		hardware.lerEnvelope();
		contaCorrente.adicionaAoSaldo(dinheiroASerDepositado);
		servicoRemoto.persistirConta();
		return "Depósito recebido com sucesso";
	}
	
	public String saldo(){
		return "O saldo é R$ " + contaCorrente.getSaldo();
	}

}
