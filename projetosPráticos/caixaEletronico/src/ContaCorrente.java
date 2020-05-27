package caixaEletronico.src;

import caixaEletronico.src.exception.SaldoInsuficienteException;

public class ContaCorrente {
	private String numero;
	private String senha;
	private double saldo;
	
	public ContaCorrente(String numero, String senha, double saldo) {
		this.numero = numero;
		this.senha = senha;
		this.saldo = saldo;
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
