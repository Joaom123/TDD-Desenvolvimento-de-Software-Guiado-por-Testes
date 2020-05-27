package pilha.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import pilha.src.Pilha;
import pilha.src.exception.PilhaCheiaException;
import pilha.src.exception.PilhaVaziaException;

public class PilhaTest {
	private Pilha pilha;
	
	@Before
	public void inicializaPilha() {
		pilha = new Pilha(10);
	}
	
	@Test
	public void pilhaVazia() {
		assertTrue(pilha.estaVazia());
		assertEquals(0, pilha.tamanho());
	}
	
	@Test
	public void empilhaUmElemento() {
		pilha.empilha("Primeiro");
		assertFalse(pilha.estaVazia());
		assertEquals(1, pilha.tamanho());
		assertEquals("Primeiro", pilha.topo());
	}
	
	@Test
	public void empilhaEDesempilha() {
		pilha.empilha("primeiro");
		pilha.empilha("segundo");
		
		Object desempilhado = pilha.desempilha();
		assertFalse(pilha.estaVazia());
		assertEquals(1, pilha.tamanho());
		assertEquals("segundo", desempilhado);
	}
	
	@Test(expected=PilhaVaziaException.class)
	public void desempilhaDePilhaVazia() {
		pilha.desempilha();
	}
	
	@Test(expected=PilhaCheiaException.class)
	public void adicionaNaPilhaCheia() {
		for (int i = 0; i < 10; i++) {
			pilha.empilha("elemento" + i);
		}
		
		pilha.empilha("Não pode");
	}
}
