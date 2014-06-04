package thread;

import java.util.Calendar;
import java.util.HashMap;

import core.Cliente;
import core.Endereco;
import core.Loja;
import core.Loja.Categorias;
import core.Produto;
import core.Transportadora;
import exceptions.ParametroException;

public class Threadness implements Runnable {

	private Loja loja;

	private Endereco enderecoTransportadora;
	private Endereco enderecoCliente;

	public Threadness(Loja l, int i) {
		this.loja = l;

		try {
			enderecoTransportadora = new Endereco("Rua r", "Bairro", "", "546",
					"78445-989", "Limeira", "Sao Paulo", "Brasil");
			enderecoCliente = new Endereco("Rua X", "Vl. Chapeco", "", "78",
					"13000-000", "Campinas", "SP", "Brasil");
			insereProduto1();
			insereProduto2();
			insereCliente();
			insereTransportadora();
		} catch (ParametroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		inserePedido();
	}

	public void insereProduto1() {
		try {
			loja.cadastrarProduto(Categorias.TABLETS.name(),
					"Tablet e carregador", "Tablet Samsung Galaxy Note", 500,
					798.00, 100);
		} catch (ParametroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insereProduto2() {
		try {
			loja.cadastrarProduto(Categorias.TELEFONIA.name(),
					"Celular e carregador", "Smartphone iPhone 5S 32GB", 450,
					2500.00, 100);
		} catch (ParametroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insereCliente() {
		try {
			loja.cadastrarCliente("Guilherme Nogueira", "325.841.021-61",
					"guilherme@email.com", "(19)3232-3232", "(19)99999-9898",
					true, "Gold", "1234", enderecoCliente);
		} catch (ParametroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insereTransportadora() {
		try {
			loja.cadastrarTransportadora("86.866.847/0001-79",
					"Transportadora Java", "JSE Transportes", 90, 125.00,
					enderecoTransportadora);
		} catch (ParametroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void inserePedido() {
		// Insere o tablet no pedido (qtde = 2)
		HashMap<Produto, Integer> itensPedido = new HashMap<Produto, Integer>();
		Produto[] lista = {};
		Produto[] produtos = (Produto[]) loja.getProdutos().toArray(lista);
		itensPedido.put(produtos[0], 2);

		Calendar compra = Calendar.getInstance();
		compra.set(2014, 3, 25);
		Calendar entrega = Calendar.getInstance();
		entrega.set(2014, 7, 25);

		Cliente[] listaClientes = {};
		Cliente[] clientes = (Cliente[]) loja.getClientes().toArray(
				listaClientes);

		Transportadora[] listaTransportadoras = {};
		Transportadora[] transportadoras = (Transportadora[]) loja
				.getTransportadoras().toArray(listaTransportadoras);
		try {
			loja.cadastrarPedido((produtos[0].getValorUnitario() * 2),
					"A vista", compra, entrega, enderecoCliente, clientes[0],
					itensPedido, transportadoras[0]);
			if (produtos[0].getQtdeEstoque() <= 0) {
				System.out.println("AE CARALHO FUDEU TUDO " + produtos[0].getQtdeEstoque());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}

	public void alteraProduto() {

	}

	public void excluiTransportadora() {

	}

}
