package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import core.Endereco;
import core.Loja;
import core.Loja.Categorias;
import exceptions.ParametroException;

/*
 * Conjunto de opera��es
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
	
	private static Endereco enderecoTransportadora;
	private static Endereco enderecoCliente;
	private static Loja loja;

	public static void main(String[] args) {
		loja = new Loja();
		try {
			enderecoCliente = new Endereco("Rua a", "Bairro ", "", "78", "79452-831", "Campinas", "SP", "BRASIL");
			enderecoTransportadora = new Endereco("Rua a", "Bairro ", "", "78", "79452-831", "Campinas", "SP", "BRASIL");
		} catch (ParametroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		insereProduto1();
		insereProduto2();

		// Rodando sem thread
		Threadless threadless = new Threadless(loja);
		// threadless.run();

		// Rodando com threads
		runningThreads();
	}

	public static void runningThreads() {
		int totalThreads = 1000;
		Threadness[] threads = new Threadness[totalThreads];
		ExecutorService executor = Executors.newCachedThreadPool();

		for (int i = 0; i < totalThreads; i++) {
			threads[i] = new Threadness(loja, i + 1);
		}

		// Run threads
		for (int i = 0; i < totalThreads; i++) {
			executor.execute(threads[i]);
		}

		executor.shutdown();

		while (!executor.isTerminated()) {
		}
	}

	public static void insereProduto1() {
		try {
			loja.cadastrarProduto(Categorias.TABLETS.name(),
					"Tablet e carregador", "Tablet Samsung Galaxy Note", 500,
					798.00, 100);
		} catch (ParametroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void insereProduto2() {
		try {
			loja.cadastrarProduto(Categorias.TELEFONIA.name(),
					"Celular e carregador", "Smartphone iPhone 5S 32GB", 450,
					2500.00, 100);
		} catch (ParametroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
