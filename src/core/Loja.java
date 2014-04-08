package core;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Loja {

	private Map<String, Cliente> clientes;
	private Map<Integer, Pedido> pedidos;
	private Map<String, Transportadora> transportadoras;
	private Map<Integer, Produto> produtos;

	private enum Categorias {
		COMPUTADORES, TELEFONIA, VIDEOSOM, TABLETS, GAMES
	};

	public Loja() {
		clientes = new HashMap<String, Cliente>();
		pedidos = new HashMap<Integer, Pedido>();
		transportadoras = new HashMap<String, Transportadora>();
		produtos = new HashMap<Integer, Produto>();
	}

	/********** CLIENTES **********/
	public void cadastrarCliente() {
		Endereco endereco = new Endereco("Rua r", "Bairro", "", "546",
				"78445-989", "Limeira", "São Paulo", "Brasil");
		Cliente c = new Cliente("Paulo", "879465231", "paulo@gmail.com",
				"3232-9898", "9898-3232", endereco, true, "Gold", "45123");

		if (!clientes.containsKey(c.getCpf())) {
			clientes.put(c.getCpf(), c);
		}
	}

	public Cliente consultarCliente(String cpf) {
		Cliente c = null;
		if (clientes.containsKey(cpf)) {
			c = clientes.get(cpf);
		}
		return c;
	}

	public void removerCliente(String cpf) {
		if (clientes.containsKey(cpf)
				&& clientes.get(cpf).getPedidosCliente().isEmpty()) {
			clientes.remove(cpf);
		} else {
			System.out.println("O Cliente com o CPF " + cpf
					+ " não foi encontrado.");
		}
	}

	public void alterarCliente(String cpf) {
		Cliente c = null;
		if (clientes.containsKey(cpf)) {
			c = clientes.get(cpf);
			c.setCelular("8282-2929");
			c.setEmail("email@email.com");
			c.setEndereco(new Endereco("Rua Nova", "Bairro Novo",
					"Complemento Novo", "789", "12345-789", "Campinas", "SP",
					"Brasil"));
			c.setIsClienteFidelidade(true);
			c.setNome("Jonas");
			c.setNumeroFidelidade("7");
			c.setProgramaFidelidade("Platinium");
			c.setTelefone("7984-7856");
		} else {
			System.out.println("O Cliente com o CPF " + cpf
					+ " não foi encontrado.");
		}
	}

	/********** PEDIDOS **********/
	public void cadastrarPedido() {
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 3, 25);
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2014, 4, 5);
		Endereco endereco = new Endereco("Rua r", "Bairro", "", "546",
				"78445-989", "Limeira", "São Paulo", "Brasil");
		Cliente cliente = clientes.get("879465231");
		Transportadora transportadora = transportadoras.get("6451238465");
		Produto prod = produtos.get(1);
		Pedido p = new Pedido(1, 78.00, "Crediário", cal, cal2, endereco,
				cliente, , transportadora);

		cliente.adicionaPedido(p);
		transportadora.adicionaPedido(p);
		pedidos.put(1, p);
	}

	public Pedido consultarPedido(Integer numero) {
		Pedido p = null;
		if (pedidos.containsKey(numero)) {
			p = pedidos.get(numero);
		}
		return p;
	}

	public void cancelarPedido(Integer numero) {
		if (pedidos.containsKey(numero)) {
			List<ItemPedido> lista = pedidos.get(numero).getProdutosPedido();
			for (ItemPedido ip : lista) {
				Produto p = ip.getProdutosPedido();
				this.devolverQuantidadeEstoque(p, ip.getQtde());
			}

			pedidos.remove(numero);
		}
	}

	/********** PRODUTOS **********/
	public void cadastrarProduto() {
		Produto p = new Produto(1, Categorias.COMPUTADORES.name(),
				"Processador e Cooler", "Processador AMD", 200.0, 155.0, 5);
		produtos.put(1, p);
	}

	public void removerProduto(Integer id) {
		if (produtos.containsKey(id)) {
			produtos.remove(id);
		}
	}

	public Produto consultarProduto(Integer id) {
		Produto p = null;
		if (produtos.containsKey(id)) {
			p = produtos.get(id);
		}
		return p;
	}

	public void alterarProduto(Produto prod, double valor) {
		Produto p = null;
		if (produtos.containsKey(prod.getId())) {
			p = produtos.get(prod.getId());
			p.setValorUnitario(valor);
		}
	}

	public void alterarProduto(Produto prod, int estoque) {
		Produto p = null;
		if (produtos.containsKey(prod.getId())) {
			p = produtos.get(prod.getId());
			p.setQtdeEstoque(estoque);
		}
	}

	public void devolverQuantidadeEstoque(Produto p, int qtde) {
		int qtdeAtual = p.getQtdeEstoque();
		int qtdeNova = qtdeAtual + qtde;
		p.setQtdeEstoque(qtdeNova);
	}

	/********** TRANSPORTADORA **********/
	public void cadastrarTransportadora() {
		Endereco endereco = new Endereco("Rua r", "Bairro", "", "546",
				"78445-989", "Limeira", "São Paulo", "Brasil");
		Transportadora t = new Transportadora("6451238465", "Belo Transportes",
				"Transportadora S/A", 90, 645.00, endereco);
		transportadoras.put("6451238465", t);
	}

	public void removerTransportadora(String cnpj) {
		if (transportadoras.containsKey(cnpj)) {
			transportadoras.remove(cnpj);
		}
	}

	public Transportadora consultarTransportadora(String cnpj) {
		Transportadora t = null;
		if (transportadoras.containsKey(cnpj)) {
			t = transportadoras.get(cnpj);
		}
		return t;
	}

	public void alterarTransportadora(Transportadora transp, int prazo) {
		Transportadora t = null;
		if (transportadoras.containsKey(transp.getCnpj())) {
			t = transportadoras.get(transp.getCnpj());
			t.setPrazoEntrega(prazo);
		}
	}

	public void alterarTransportadora(Transportadora transp, double taxa) {
		Transportadora t = null;
		if (transportadoras.containsKey(transp.getCnpj())) {
			t = transportadoras.get(transp.getCnpj());
			t.setTaxaEntrega(taxa);
		}
	}

	/********** METODOS ADICIONAIS **********/
	public double getFaturamentoBruto() {
		double faturamento = 0;
		for (Pedido pedido : pedidos.values()) {
			faturamento += pedido.getValorTotal();
		}
		return faturamento;
	}

	public double getValorDevidoTransportadora(String cnpj) {
		double valorDevido = 0;
		for (Pedido pedido : pedidos.values()) {
			Transportadora t = pedido.getTransportadora();
			if (t.getCnpj() == cnpj) {
				valorDevido += t.getTaxaEntrega();
			}
		}
		return valorDevido;
	}

	public double getValorDevidoTotal() {
		double valorDevido = 0;
		for (Transportadora t : transportadoras.values()) {
			if (!t.getPedidosTransportadora().isEmpty()) {
				valorDevido += t.getTaxaEntrega();
			}
		}
		return valorDevido;
	}

	public double getFaturamentoLiquido() {
		return getFaturamentoBruto() - getValorDevidoTotal();
	}

	public void limparPedidos() {
		Calendar dataAtual = Calendar.getInstance();
		for (Pedido pedido : pedidos.values()) {
			if (pedido.getDataEntrega().before(dataAtual.getTime())) {
				pedidos.remove(pedido);
			}
		}
	}
}
