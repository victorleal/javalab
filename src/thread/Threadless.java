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

public class Threadless {

	private Loja loja;

	public Threadless(Loja l) {
		this.loja = l;
	}

	public void run() {
		// Define os enderecos
		Endereco enderecoTransportadora;
		Endereco enderecoCliente;
		try {
			enderecoTransportadora = new Endereco("Rua r", "Bairro", "", "546",
					"78445-989", "Limeira", "S�o Paulo", "Brasil");
			enderecoCliente = new Endereco("Rua X", "Vl. Chapec�", "", "78",
					"13000-000", "Campinas", "SP", "Brasil");

			loja.cadastrarProduto(Categorias.TABLETS.name(),
					"Tablet e carregador", "Tablet Samsung Galaxy Note", 500,
					798.00, 10);
			loja.cadastrarProduto(Categorias.TELEFONIA.name(),
					"Celular e carregador", "Smartphone iPhone 5S 32GB", 450,
					2500.00, 10);

			loja.cadastrarCliente("Guilherme Nogueira", "325.841.021-61",
					"guilherme@email.com", "(19)3232-3232", "(19)99999-9898",
					true, "Gold", "1234", enderecoCliente);

			loja.cadastrarTransportadora("86.866.847/0001-79",
					"Transportadora Java", "JSE Transportes", 90, 125.00,
					enderecoTransportadora);

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

			for (int i = 0; i < 100; i++) {
				loja.cadastrarPedido((produtos[0].getValorUnitario() * 2),
						"A vista", compra, entrega, enderecoCliente,
						clientes[0], itensPedido, transportadoras[0]);
			}
			System.out.println(produtos[0].getQtdeEstoque());
		} catch (ParametroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
