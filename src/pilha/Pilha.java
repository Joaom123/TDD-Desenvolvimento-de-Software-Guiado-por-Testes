package pilha;

public class Pilha {
	private int quantidade = 0;
	private Object[] elementos;

	public Pilha(int tamanhoMaximo) {
		elementos = new Object[tamanhoMaximo];
	}

	public boolean estaVazia() {
		return quantidade == 0;
	}

	public int tamanho() {
		return quantidade;
	}

	public void empilha(Object object) {
		if(quantidade == elementos.length) {
			throw new PilhaCheiaException("Esta cheia");
		}
		
		this.elementos[quantidade] = object;
		quantidade++;
	}
	
	public Object desempilha() {
		if(estaVazia()) {
			throw new PilhaVaziaException("Esta vazia");
		}
		
		Object aux = topo();
		//this.elementos[quantidade-1] = null;
		quantidade--;
		
		return aux;
	}

	public Object topo() {
		return elementos[quantidade-1];
	}
	

}
