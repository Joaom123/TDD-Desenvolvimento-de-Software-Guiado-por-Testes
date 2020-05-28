package caixaEletronico.src;

import caixaEletronico.src.exception.NumeroDaContaNaoEncontradoException;
import caixaEletronico.src.exception.ProblemaHardwareException;
import caixaEletronico.src.exception.SaldoInsuficienteException;

public class CaixaEletronico {
	private ContaCorrente contaCorrente;
	private ServicoRemoto servicoRemoto;
	private Hardware hardware;
	
	public CaixaEletronico(Hardware hardware, ServicoRemoto servicoRemoto) {
		this.hardware = hardware;
		this.servicoRemoto = servicoRemoto;
	}
	
	public String logar(String senha) 
			throws RuntimeException, ProblemaHardwareException, NumeroDaContaNaoEncontradoException{
		String numeroDaConta = hardware.pegarNumeroDaContaCartao();
		this.contaCorrente = servicoRemoto.recuperarConta(numeroDaConta);
		
		if(this.contaCorrente.getSenha() != senha)
			throw new RuntimeException("erro");
		
		return "Usuário Autenticado";
	}
	
	public String sacar(double dinheiroASerSacado) 
			throws SaldoInsuficienteException, ProblemaHardwareException {
		contaCorrente.subtraiDoSaldo(dinheiroASerSacado);
		servicoRemoto.persistirConta(contaCorrente);
		hardware.entregarDinheiro();
		
		return "Retire seu dinheiro";
	}
	
	public String depositar(double dinheiroASerDepositado) 
			throws ProblemaHardwareException {
		hardware.lerEnvelope();
		contaCorrente.adicionaAoSaldo(dinheiroASerDepositado);
		servicoRemoto.persistirConta(contaCorrente);
		return "Depósito recebido com sucesso";
	}
	
	public String saldo(){
		return "O saldo é R$ " + contaCorrente.getSaldo();
	}

}
