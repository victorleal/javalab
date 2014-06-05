package thread;

import java.util.Calendar;
import java.util.HashMap;

import core.Cliente;
import core.Endereco;
import core.Loja;
import core.Produto;
import core.Transportadora;
import exceptions.ParametroException;

public class Threadness implements Runnable {

	private Loja loja;

	public Threadness(Loja l, int i) {
		this.loja = l;
	}

	@Override
	public void run() {
		insereCliente();
		inserePedido();
	}

	public void insereCliente() {
		try {
			Endereco enderecoCliente = new Endereco("Rua a", "Bairro ", "",
					"78", "79452-831", "Campinas", "SP", "BRASIL");
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
			Endereco enderecoTransportadora = new Endereco("Rua a", "Bairro ",
					"", "78", "79452-831", "Campinas", "SP", "BRASIL");
			loja.cadastrarTransportadora("86.866.847/0001-79",
					"Transportadora Java", "JSE Transportes", 90, 125.00,
					enderecoTransportadora);
		} catch (ParametroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void inserePedido() {
		Endereco enderecoCliente = null;
		try {
			enderecoCliente = new Endereco("Rua a", "Bairro ", "", "78",
					"79452-831", "Campinas", "SP", "BRASIL");
		} catch (ParametroException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}

}
