package caixaEletronico.src;

import caixaEletronico.src.exception.UsuarioNaoAutenticadoException;

public class CaixaEletronico {
	private ContaCorrente contaCorrente;
	private ServicoRemoto servicoRemoto;
	private Hardware hardware;
	private boolean logado = false;
	
	public CaixaEletronico(Hardware hardware, ServicoRemoto servicoRemoto) {
		this.hardware = hardware;
		this.servicoRemoto = servicoRemoto;
	}
	
	public String logar(String senha) {
		try {
			String numeroDaConta = hardware.pegarNumeroDaContaCartao();
			this.contaCorrente = servicoRemoto.recuperarConta(numeroDaConta);
			
			if(this.contaCorrente.getSenha() != senha)
				throw new UsuarioNaoAutenticadoException();
			
			this.logado = true;
			return "Usuário Autenticado";
		} catch(UsuarioNaoAutenticadoException e) {
			return e.getMessage();
		} catch (Exception e) {
			return e.getMessage();
		}
		
	}
	
	private boolean naoEstaLogado() {
		return !this.logado;
	}
	
	public String sacar(double dinheiroASerSacado) { 
		try {
			if(naoEstaLogado())
				throw new UsuarioNaoAutenticadoException();
			
			contaCorrente.subtraiDoSaldo(dinheiroASerSacado);
			servicoRemoto.persistirConta(contaCorrente);
			hardware.entregarDinheiro();
			
			return "Retire seu dinheiro";
			
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String depositar(double dinheiroASerDepositado) {
		try {
			if(naoEstaLogado())
				throw new UsuarioNaoAutenticadoException();
			
			hardware.lerEnvelope();
			contaCorrente.adicionaAoSaldo(dinheiroASerDepositado);
			servicoRemoto.persistirConta(contaCorrente);

			return "Depósito recebido com sucesso";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String saldo() {
		try {
			if(naoEstaLogado())
				throw new UsuarioNaoAutenticadoException();
			
			return "O saldo é R$ " + contaCorrente.getSaldo();			
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
