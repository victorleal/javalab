package core;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import exceptions.ParametroException;
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

	// Controla objetos entre as telas de alteracao
	private Cliente clienteAlteracao;
	private Produto produtoAlteracao;
	private Transportadora transportadoraAlteracao;

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

	/********** CLIENTES 
	 * @throws ParametroException **********/
	public void cadastrarCliente(String nome, String cpf, String email,
			String telefone, String celular, boolean isClienteFidelidade,
			String programaFidelidade, String numeroFidelidade,
			Endereco endereco) throws ParametroException {
		Cliente c;
		try {
			c = new Cliente(nome, cpf, email, telefone, celular,
					endereco, isClienteFidelidade, programaFidelidade,
					numeroFidelidade);
		} catch (ParametroException e) {
			throw e;
		}

		if (!clientes.containsKey(c.getCpf())) {
			clientes.put(c.getCpf(), c);
		}
	}

	public Cliente consultarCliente(String cpf) {
		Cliente c = null;
		System.out.println(cpf);
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
					+ " n�o foi encontrado.");
		}
	}

	public void alterarCliente(String nome, String cpf, String email,
			String telefone, String celular, boolean isClienteFidelidade,
			String programaFidelidade, String numeroFidelidade,
			Endereco endereco) throws ParametroException {
		if (clientes.containsKey(cpf)) {
			Cliente c = clientes.get(cpf);
			c.setCelular(celular);
			c.setEmail(email);
			c.setEndereco(endereco);
			c.setIsClienteFidelidade(isClienteFidelidade);
			c.setNome(nome);
			c.setNumeroFidelidade(numeroFidelidade);
			c.setProgramaFidelidade(programaFidelidade);
			c.setTelefone(telefone);
		}
	}

	public Collection<Cliente> getClientes() {
		return this.clientes.values();
	}

	public void setClienteAlteracao(Cliente c) {
		this.clienteAlteracao = c;
	}

	public Cliente getClienteAlteracao() {
		return this.clienteAlteracao;
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

	public Collection<Pedido> getPedidos() {
		return this.pedidos.values();
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

	public Collection<Produto> getProdutos() {
		return this.produtos.values();
	}

	public void setProdutoAlteracao(Produto p) {
		this.produtoAlteracao = p;
	}

	public Produto getProdutoAlteracao() {
		return this.produtoAlteracao;
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

	public void setTransportadoraAlteracao(Transportadora t) {
		this.transportadoraAlteracao = t;
	}

	public Transportadora getTransportadoraAlteracao() {
		return this.transportadoraAlteracao;
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

			if (t.getCnpj().equals(cnpj)) {
				valorDevido += t.getTaxaEntrega();
			}
		}
		return valorDevido;
	}

	public double getValorDevidoTotal() {
		double valorDevido = 0;
		for (Pedido p : pedidos.values()) {
			valorDevido += p.getTransportadora().getTaxaEntrega();
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

	public String[] getProgramaFidelidade() {
		String[] programas = { "Gold", "Platinium", "Normal" };
		return programas;
	}

	public void create(){
		Endereco enderecoTransportadora = new Endereco("Rua r", "Bairro", "",
				"546", "78445-989", "Limeira", "S�o Paulo", "Brasil");
		Endereco enderecoCliente = new Endereco("Rua X", "Vl. Chapec�", "",
				"78", "13000-000", "Campinas", "SP", "Brasil");
		try{
			cadastrarCliente("Victor Leal", "594.521.307-17", "victor@email.com", "3232-3232",
					"9999-9898", true, "Normal", "1234", enderecoCliente);
			cadastrarCliente("Paulo Paraluppi", "785.441.267-74", "paulo@email.com",
					"3232-3232", "9999-9898", true, "Gold", "1234", enderecoCliente);
			cadastrarCliente("Guilherme Nogueira", "325.841.021-61", "guilherme@email.com",
					"3232-3232", "9999-9898", true, "Gold", "1234", enderecoCliente);
		}catch(ParametroException e){
			System.out.println(e.getMessage());
		}
		
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
				"Leitor de Bluray e cabos conex�o", "Leitor de Bluray Sony",
				420, 300.00, 10);
		cadastrarProduto(Categorias.COMPUTADORES.name(), "HD e cabos conex�o",
				"HD SATA III Western Digital 1TB", 320, 210.00, 10);
		HashMap<Produto, Integer> map = new HashMap<Produto, Integer>();
		map.put(produtos.get(1), 2);
		cadastrarPedido(1250, "A vista", Calendar.getInstance(),
				Calendar.getInstance(), enderecoCliente, clientes.get("2"),
				map, transportadoras.get("1"));
	}
}
