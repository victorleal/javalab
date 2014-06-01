package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import core.Loja;

/*
 * Conjunto de operações
 * 
 * Criar produto;
 * Criar produto;
 * Criar Cliente;
 * Criar Transportadora;
 * Criar pedido;
 * Alterar produto/cliente;
 * Excluir Transportadora.
 */

public class ThreadMain {

	public static void main(String[] args) {
		Loja loja = new Loja();

		// Rodando sem thread
		Threadless threadless = new Threadless(loja);
		threadless.run();

		// Rodando com threads
		runningThreads();
	}

	public static void runningThreads() {
		Loja loja = new Loja();
		Threadness[] threads = new Threadness[7];
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 7; i++) {
			threads[i] = new Threadness(loja, i + 1);
		}
		
		// Run threads
		for (int i = 0; i < 7; i++) {
			executor.execute(threads[i]);
		}
		
		executor.shutdown();
	}

}
