package core;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import exceptions.ParametroException;

/*
 * @author Victor Leal
 * This class handles the core operations of the system
 */
public class Loja {

	private FileManager fileManager;

	private Map<String, Cliente> clientes;
	private Map<Integer, Pedido> pedidos;
	private Map<String, Transportadora> transportadoras;
	private Map<Integer, Produto> produtos;

	private Map<Produto, Integer> itensPedidoTemp;

	private static int idPedido = 0;
	private static int idProduto = 0;

	// Controla objetos entre as telas de alteracao
	private Cliente clienteAlteracao;
	private Produto produtoAlteracao;
	private Pedido pedidoDetalhe;
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
		// create();
		// load();
	}

	/**********
	 * CLIENTES
	 * 
	 * @throws ParametroException
	 **********/
	public synchronized void cadastrarCliente(String nome, String cpf,
			String email, String telefone, String celular,
			boolean isClienteFidelidade, String programaFidelidade,
			String numeroFidelidade, Endereco endereco)
			throws ParametroException {
		Cliente c;
		try {
			c = new Cliente(nome, cpf, email, telefone, celular, endereco,
					isClienteFidelidade, programaFidelidade, numeroFidelidade);
			persist(c);
		} catch (ParametroException e) {
			throw e;
		}

		if (!clientes.containsKey(c.getCpf())) {
			clientes.put(c.getCpf(), c);
		}
	}

	public Cliente consultarCliente(String cpf) throws Exception {
		if (clientes.containsKey(cpf)) {
			return clientes.get(cpf);
		} else {
			throw new Exception("Cliente não encontrado");
		}
	}

	public synchronized void removerCliente(String cpf) throws Exception {
		if (clientes.containsKey(cpf)) {
			if (clientes.get(cpf).getPedidosCliente().isEmpty()) {
				delete(clientes.get(cpf));
				clientes.remove(cpf);
			} else {
				throw new Exception(
						"O cliente não pode ser removido pois ele ainda tem pedidos cadastrados!");
			}
		} else {
			throw new Exception("Cliente não encontrado");
		}
	}

	public synchronized void alterarCliente(String nome, String cpf,
			String email, String telefone, String celular,
			boolean isClienteFidelidade, String programaFidelidade,
			String numeroFidelidade, Endereco endereco)
			throws ParametroException {
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
			persist(c);
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
	public synchronized void cadastrarPedido(double valorTotal,
			String formaPagamento, Calendar dataCompra, Calendar dataEntrega,
			Endereco endereco, Cliente cliente,
			Map<Produto, Integer> produtosPedido, Transportadora transportadora)
			throws ParametroException {
		Pedido p;

		try {
			boolean produtosQtdeEstoqueSuficiente = true;
			for (Produto p1 : produtosPedido.keySet()) {
				if (this.verificaQuantidadeDisponivel(p1,
						produtosPedido.get(p1)) <= 0) {
					produtosQtdeEstoqueSuficiente = false;
					break;
				}
			}

			if (produtosQtdeEstoqueSuficiente) {
				p = new Pedido(idPedido, valorTotal, formaPagamento,
						dataCompra, dataEntrega, endereco, cliente,
						produtosPedido, transportadora);
				adicionaPedido(cliente, produtosPedido, transportadora, p);
				pedidos.put(idPedido, p);
				persist(p);
				idPedido++;
			}
		} catch (ParametroException e) {
			throw e;
		}
	}

	public Pedido consultarPedido(Integer numero) throws Exception {
		if (pedidos.containsKey(numero)) {
			return pedidos.get(numero);
		} else {
			throw new Exception("Pedido não encontrado");
		}
	}

	public void setPedidoDetalhe(Pedido p) {
		this.pedidoDetalhe = p;
	}

	public Pedido getPedidoDetalhe() {
		return this.pedidoDetalhe;
	}

	public void cancelarPedido(Integer numero) throws ParametroException {
		if (pedidos.containsKey(numero)) {
			Pedido p = pedidos.get(numero);
			Cliente cliente = p.getCliente();
			Transportadora transportadora = p.getTransportadora();
			itensPedidoTemp = p.getProdutosPedido();
			for (Produto prod : itensPedidoTemp.keySet()) {
				int qtdeAtual = prod.getQtdeEstoque();
				int qtdePedido = itensPedidoTemp.get(prod);
				try {
					prod.setQtdeEstoque(qtdePedido + qtdeAtual);
				} catch (ParametroException e) {
					throw e;
				}
			}
			removePedido(cliente, itensPedidoTemp.keySet(), transportadora, p);
			delete(p);
			pedidos.remove(numero);
		}
	}

	public Collection<Pedido> getPedidos() {
		return this.pedidos.values();
	}

	/********** PRODUTOS **********/
	public void cadastrarProduto(String categoria, String conteudodaCaixa,
			String descricao, double peso, double valorUnitario, int qtdeEstoque)
			throws ParametroException {
		Produto p;

		try {
			p = new Produto(idProduto, categoria, conteudodaCaixa, descricao,
					peso, valorUnitario, qtdeEstoque);
			if (!produtos.containsKey(p.getId())) {
				produtos.put(p.getId(), p);
				persist(p);
				idProduto++;
			}
		} catch (ParametroException e) {
			throw e;
		}
	}

	public void removerProduto(Integer id) throws Exception {
		if (produtos.containsKey(id)) {
			if (produtos.get(id).getPedidosProduto().isEmpty()) {
				delete(produtos.get(id));
				produtos.remove(id);
			} else {
				throw new Exception(
						"O produto não pode ser removido pois ele está presente em pedidos cadastrados!");
			}
		} else {
			throw new Exception("Produto não encontrado");
		}
	}

	public Produto consultarProduto(Integer id) throws Exception {
		if (produtos.containsKey(id)) {
			return produtos.get(id);
		} else {
			throw new Exception("Produto não encontrado");
		}
	}

	public void alterarProduto(Produto prod, double valor)
			throws ParametroException {
		Produto p = null;
		if (produtos.containsKey(prod.getId())) {
			p = produtos.get(prod.getId());
			p.setValorUnitario(valor);
			persist(p);
		}
	}

	public void alterarProduto(Produto prod, int estoque)
			throws ParametroException {
		Produto p = null;
		if (produtos.containsKey(prod.getId())) {
			p = produtos.get(prod.getId());
			p.setQtdeEstoque(estoque);
			persist(p);
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

	public void atualizarEstoque(Produto p, int qtdeComprada) {
		try {
			p.setQtdeEstoque((p.getQtdeEstoque() - qtdeComprada));
		} catch (ParametroException e) {
			e.getMessage();
		}
	}

	public void devolverQuantidadeEstoque(Produto p, int qtde)
			throws ParametroException {
		int qtdeAtual = p.getQtdeEstoque();
		int qtdeNova = qtdeAtual + qtde;
		p.setQtdeEstoque(qtdeNova);

	}

	/********** TRANSPORTADORA **********/
	public void cadastrarTransportadora(String cnpj, String nomeFantasia,
			String razaoSocial, int prazoEntrega, double taxaEntrega,
			Endereco endereco) throws ParametroException {
		Transportadora t;
		try {
			t = new Transportadora(cnpj, nomeFantasia, razaoSocial,
					prazoEntrega, taxaEntrega, endereco);
			persist(t);
		} catch (ParametroException e) {
			throw e;
		}

		if (!transportadoras.containsKey(t.getCnpj())) {
			transportadoras.put(cnpj, t);
		}
	}

	public void removerTransportadora(String cnpj) throws Exception {
		if (transportadoras.containsKey(cnpj)) {
			if (transportadoras.get(cnpj).getPedidosTransportadora().isEmpty()) {
				delete(transportadoras.get(cnpj));
				transportadoras.remove(cnpj);
			} else {
				throw new Exception(
						"A transportadora não pode ser removida pois ela está presente em pedidos cadastrados!");
			}
		} else {
			throw new Exception("Transportadora não encontrada");
		}
	}

	public Transportadora consultarTransportadora(String cnpj) throws Exception {
		if (transportadoras.containsKey(cnpj)) {
			return transportadoras.get(cnpj);
		} else {
			throw new Exception("Transportadora n�o encontrada");
		}
	}

	public void alterarTransportadora(Transportadora transp, int prazo)
			throws ParametroException {
		Transportadora t = null;
		try {
			if (transportadoras.containsKey(transp.getCnpj())) {
				t = transportadoras.get(transp.getCnpj());
				t.setPrazoEntrega(prazo);
				persist(t);
			}
		} catch (ParametroException e) {
			throw e;
		}
	}

	public void alterarTransportadora(Transportadora transp, double taxa)
			throws ParametroException {
		Transportadora t = null;
		if (transportadoras.containsKey(transp.getCnpj())) {
			t = transportadoras.get(transp.getCnpj());
			t.setTaxaEntrega(taxa);
			persist(t);
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
	public int verificaQuantidadeDisponivel(Produto p, int qtde) {
		return p.getQtdeEstoque() - qtde;
	}

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
			// Pedido p = pedido.getValorTotal();

			if (t.getCnpj().equals(cnpj)) {
				valorDevido += pedido.getValorTotal() / t.getTaxaEntrega();
			}
		}
		return valorDevido;
	}

	public double getValorDevidoTotal() {
		double valorDevido = 0;
		for (Pedido p : pedidos.values()) {
			valorDevido += p.getValorTotal()
					/ p.getTransportadora().getTaxaEntrega();
		}
		return valorDevido;
	}

	public double getFaturamentoLiquido() {
		return getFaturamentoBruto() - getValorDevidoTotal();
	}

	public void limparPedidos() {
		Calendar dataAtual = Calendar.getInstance();
		for (Pedido pedido : pedidos.values()) {
			if (pedido.getDataEntrega().before(dataAtual)) {
				Cliente cliente = pedido.getCliente();
				Transportadora transportadora = pedido.getTransportadora();
				itensPedidoTemp = pedido.getProdutosPedido();
				removePedido(cliente, itensPedidoTemp.keySet(), transportadora,
						pedido);
				pedidos.remove(pedido.getNumero());
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

	public void adicionaPedido(Cliente c, Map<Produto, Integer> produtos,
			Transportadora t, Pedido p) {
		c.adicionaPedido(p);
		t.adicionaPedido(p);
		for (Produto prod : produtos.keySet()) {
			int qtdeComprada = produtos.get(prod);
			atualizarEstoque(prod, qtdeComprada);
			prod.adicionaPedido(p);
		}
	}

	public void removePedido(Cliente c, Set<Produto> produtos,
			Transportadora t, Pedido p) {
		c.removePedido(p);
		t.removePedido(p);
		for (Produto prod : produtos) {
			prod.removePedido(p);
		}
	}

	/***** Metodos Persistencia *****/
	public void persist(PersistentObject o) {
		/*
		 * fileManager = new FileManager(o.getClassName());
		 * fileManager.writeObject(o);
		 */
	}

	public List<PersistentObject> readObjects(PersistentObject o) {
		fileManager = new FileManager(o.getClassName());
		return fileManager.readList();
	}

	public void delete(PersistentObject o) {
		fileManager = new FileManager(o.getClassName());
		fileManager.delete(o);
	}

	public void load() {
		// Carrega os clientes
		List<PersistentObject> clientes = readObjects(new PersistentObject(
				"Cliente"));
		for (PersistentObject p : clientes) {
			Cliente cliente = (Cliente) p;
			this.clientes.put(cliente.getCpf(), cliente);
		}

		// Carrega as transportadoras
		List<PersistentObject> transp = readObjects(new PersistentObject(
				"Transportadora"));
		for (PersistentObject p : transp) {
			Transportadora t = (Transportadora) p;
			this.transportadoras.put(t.getCnpj(), t);
		}

		// Carrega os produtos
		List<PersistentObject> produtos = readObjects(new PersistentObject(
				"Produto"));
		for (PersistentObject p : produtos) {
			Produto prod = (Produto) p;
			idProduto = prod.getId();
			this.produtos.put(prod.getId(), prod);
		}

		// Carrega os pedidos
		List<PersistentObject> pedidos = readObjects(new PersistentObject(
				"Pedido"));
		for (PersistentObject p : pedidos) {
			Pedido pedido = (Pedido) p;
			idPedido = pedido.getNumero();
			this.pedidos.put(pedido.getNumero(), pedido);
		}

		idPedido++;
		idProduto++;
	}

	public void create() {
		Endereco enderecoTransportadora = null;
		Endereco enderecoCliente = null;

		idPedido++;
		idProduto++;

		try {
			enderecoTransportadora = new Endereco("Rua r", "Bairro", "", "546",
					"78445-989", "Limeira", "São Paulo", "Brasil");
			enderecoCliente = new Endereco("Rua X", "Vl. Chapecó", "", "78",
					"13000-000", "Campinas", "SP", "Brasil");
			cadastrarCliente("Victor Leal", "594.521.307-17",
					"victor@email.com", "(19)3232-3232", "(19)99999-9898",
					true, "Normal", "1234", enderecoCliente);
			cadastrarCliente("Paulo Paraluppi", "785.441.267-74",
					"paulo@email.com", "(19)3232-3232", "(19)99999-9898", true,
					"Gold", "1234", enderecoCliente);
			cadastrarCliente("Guilherme Nogueira", "325.841.021-61",
					"guilherme@email.com", "(19)3232-3232", "(19)99999-9898",
					true, "Gold", "1234", enderecoCliente);
			cadastrarTransportadora("86.866.847/0001-79",
					"Transportadora Java", "JSE Transportes", 90, 125.00,
					enderecoTransportadora);
			cadastrarTransportadora("21.643.533/0001-61",
					"Transportadora Oracle", "JSE Transportes", 90, 125.00,
					enderecoTransportadora);
			cadastrarProduto(Categorias.TABLETS.name(), "Tablet e carregador",
					"Tablet Samsung Galaxy Note", 500, 798.00, 10);
			cadastrarProduto(Categorias.TELEFONIA.name(),
					"Celular e carregador", "Smartphone iPhone 5S 32GB", 450,
					2500.00, 10);
			cadastrarProduto(Categorias.GAMES.name(), "DVD game e manual",
					"FIFA 14", 100, 98.00, 10);
			cadastrarProduto(Categorias.VIDEOSOM.name(),
					"Leitor de Bluray e cabos conexao",
					"Leitor de Bluray Sony", 420, 300.00, 10);
			cadastrarProduto(Categorias.COMPUTADORES.name(),
					"HD e cabos conexao", "HD SATA III Western Digital 1TB",
					320, 210.00, 10);

			// Insere o tablet no pedido (qtde = 2)
			HashMap<Produto, Integer> itensPedido = new HashMap<Produto, Integer>();
			itensPedido.put(produtos.get(1), 2);

			Calendar compra = Calendar.getInstance();
			compra.set(2014, 3, 25);
			Calendar entrega = Calendar.getInstance();
			entrega.set(2014, 7, 25);

			cadastrarPedido((produtos.get(1).getValorUnitario() * 2),
					"A vista", compra, entrega, enderecoCliente,
					clientes.get("594.521.307-17"), itensPedido,
					transportadoras.get("86.866.847/0001-79"));
		} catch (ParametroException e) {
			System.out.println("CREATE: " + e.getMessage());
		}
	}
}
