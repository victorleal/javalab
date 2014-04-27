package core;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import auxiliar.GerenciadorPedidos;

public class Loja {

	private Map<String, Cliente> clientes;
	private Map<Integer, Pedido> pedidos;
	private Map<String, Transportadora> transportadoras;
	private Map<Integer, Produto> produtos;

	private Map<Produto, Integer> itensPedidoTemp;

	private GerenciadorPedidos gerenciadorPedidos;

	private static int idPedido;
	private static int idProduto;

	public enum Categorias {
		COMPUTADORES, TELEFONIA, VIDEOSOM, TABLETS, GAMES
	};

	public Loja() {
		clientes = new HashMap<String, Cliente>();
		pedidos = new HashMap<Integer, Pedido>();
		transportadoras = new HashMap<String, Transportadora>();
		produtos = new HashMap<Integer, Produto>();
		itensPedidoTemp = new HashMap<Produto, Integer>();
		gerenciadorPedidos = new GerenciadorPedidos();
		idPedido = 1;
		create();
	}

	/********** CLIENTES **********/
	public void cadastrarCliente(String nome, String cpf, String email,
			String telefone, String celular, boolean isClienteFidelidade,
			String programaFidelidade, String numeroFidelidade,
			Endereco endereco) {
		Cliente c = new Cliente(nome, cpf, email, telefone, celular, endereco,
				isClienteFidelidade, programaFidelidade, numeroFidelidade);

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
				&& gerenciadorPedidos.consultaPedidosCliente(clientes.get(cpf))) {
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
	public void cadastrarPedido(double valorTotal, String formaPagamento,
			Calendar dataCompra, Calendar dataEntrega, Endereco endereco,
			Cliente cliente, Map<Produto, Integer> produtosPedido,
			Transportadora transportadora) {
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 3, 25);
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2014, 4, 5);

		Pedido p = new Pedido(idPedido, valorTotal, formaPagamento, cal, cal2,
				endereco, cliente, produtosPedido, transportadora);
		gerenciadorPedidos.adicionaPedido(cliente, transportadora,
				produtosPedido.keySet(), p);
		pedidos.put(idPedido, p);
		idPedido++;
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
			Pedido p = pedidos.get(numero);
			Cliente cliente = p.getCliente();
			Transportadora transportadora = p.getTransportadora();
			itensPedidoTemp = p.getProdutosPedido();
			gerenciadorPedidos.removePedido(cliente, transportadora,
					itensPedidoTemp.keySet(), p);
			pedidos.remove(numero);
		}
	}

	/********** PRODUTOS **********/
	public void cadastrarProduto(String categoria, String conteudodaCaixa,
			String descricao, double peso, double valorUnitario, int qtdeEstoque) {
		Produto p = new Produto(idProduto, categoria, conteudodaCaixa,
				descricao, peso, valorUnitario, qtdeEstoque);
		if (!produtos.containsKey(p.getId())) {
			produtos.put(p.getId(), p);
			idProduto++;
		}
	}

	public void removerProduto(Integer id) {
		if (produtos.containsKey(id)
				&& gerenciadorPedidos.consultaPedidosProduto(produtos.get(id))) {
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
	public void cadastrarTransportadora(String cnpj, String nomeFantasia,
			String razaoSocial, int prazoEntrega, double taxaEntrega,
			Endereco endereco) {
		Transportadora t = new Transportadora(cnpj, nomeFantasia, razaoSocial,
				prazoEntrega, taxaEntrega, endereco);

		if (!transportadoras.containsKey(t.getCnpj())) {
			transportadoras.put(cnpj, t);
		}
	}

	public void removerTransportadora(String cnpj) {
		if (transportadoras.containsKey(cnpj)
				&& gerenciadorPedidos
						.consultaPedidosTransportadora(transportadoras
								.get(cnpj))) {
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

	public Collection<Transportadora> getTransportadoras() {
		return this.transportadoras.values();
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
				Cliente cliente = pedido.getCliente();
				Transportadora transportadora = pedido.getTransportadora();
				itensPedidoTemp = pedido.getProdutosPedido();
				gerenciadorPedidos.removePedido(cliente, transportadora,
						itensPedidoTemp.keySet(), pedido);
				pedidos.remove(pedido);
			}
		}
	}

	public int getIdPedido() {
		return idPedido;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void create() {
		Endereco enderecoTransportadora = new Endereco("Rua r", "Bairro", "",
				"546", "78445-989", "Limeira", "São Paulo", "Brasil");
		Endereco enderecoCliente = new Endereco("Rua X", "Vl. Chapecó", "",
				"78", "13000-000", "Campinas", "SP", "Brasil");
		cadastrarCliente("Victor Leal", "1", "victor@email.com", "3232-3232",
				"9999-9898", true, "Gold", "1234", enderecoCliente);
		cadastrarCliente("Paulo Paraluppi", "2", "paulo@email.com",
				"3232-3232", "9999-9898", true, "Gold", "1234", enderecoCliente);
		cadastrarCliente("Guilherme Nogueira", "3", "guilherme@email.com",
				"3232-3232", "9999-9898", true, "Gold", "1234", enderecoCliente);
		cadastrarTransportadora("1", "Transportadora Java", "JSE Transportes",
				90, 125.00, enderecoTransportadora);
		cadastrarTransportadora("2", "Transportadora Oracle",
				"JSE Transportes", 90, 125.00, enderecoTransportadora);
		cadastrarProduto(Categorias.TABLETS.name(), "Tablet e carregador",
				"Tablet Samsung Galaxy Note", 500, 798.00, 10);
		cadastrarProduto(Categorias.TELEFONIA.name(), "Celular e carregador",
				"Smartphone iPhone 5S 32GB", 450, 2500.00, 10);
		cadastrarProduto(Categorias.GAMES.name(), "DVD game e manual",
				"FIFA 14", 100, 98.00, 10);
		cadastrarProduto(Categorias.VIDEOSOM.name(),
				"Leitor de Bluray e cabos conexão", "Leitor de Bluray Sony",
				420, 300.00, 10);
		cadastrarProduto(Categorias.COMPUTADORES.name(), "HD e cabos conexão",
				"HD SATA III Western Digital 1TB", 320, 210.00, 10);
	}
}
