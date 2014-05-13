package core;

import java.util.HashMap;
import java.util.Map;

import exceptions.ParametroException;

public class Produto {

	private int id;
	private String categoria;
	private String conteudodaCaixa;
	private String descricao;
	private double peso;
	private double valorUnitario;
	private int qtdeEstoque;
	private Map<Integer, Pedido> pedidosProduto;

	public int getId() {
		return id;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getConteudodaCaixa() {
		return conteudodaCaixa;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getPeso() {
		return peso;
	}
	
	public double getValorUnitario() {
		return valorUnitario;
	}
	
	public int getQtdeEstoque() {
		return qtdeEstoque;
	}

	public void setConteudodaCaixa(String conteudodaCaixa) throws ParametroException {
		if (conteudodaCaixa == null || conteudodaCaixa.isEmpty()) {
			throw new ParametroException("Conteúdo da Caixa");
		} else {
			this.conteudodaCaixa = conteudodaCaixa;
		}
	}

	public void setDescricao(String descricao) throws ParametroException {
		if (descricao == null || descricao.isEmpty()) {
			throw new ParametroException("Descrição");
		} else {
			this.descricao = descricao;
		}
	}

	public void setPeso(double peso)  throws ParametroException {
		if (peso == 0) {
			throw new ParametroException("Peso");
		} else {
			this.peso = peso;
		}
	}

	public void setPedidosProduto(Map<Integer, Pedido> pedidosProduto) {
		this.pedidosProduto = pedidosProduto;
	}
	

	public void setValorUnitario(double valorUnitario) throws ParametroException {
		if (valorUnitario == 0) {
			throw new ParametroException("Valor Unitario");
		} else {
			this.valorUnitario = valorUnitario;
		}
	}

	public void setQtdeEstoque(int qtdeEstoque) throws ParametroException {
		if (qtdeEstoque == 0) {
			throw new ParametroException("Quantidade no Estoque");
		} else {
			this.qtdeEstoque = qtdeEstoque;
		}
	}

	public Produto(int id, String categoria, String conteudodaCaixa,
			String descricao, double peso, double valorUnitario, int qtdeEstoque) throws ParametroException {
		super();
		this.id = id;
		this.categoria = categoria;
		this.conteudodaCaixa = conteudodaCaixa;
		this.descricao = descricao;
		this.peso = peso;
		this.valorUnitario = valorUnitario;
		this.qtdeEstoque = qtdeEstoque;
		this.pedidosProduto = new HashMap<Integer, Pedido>();
	}

	public Produto() {
	}

	public Map<Integer, Pedido> getPedidosProduto() {
		return pedidosProduto;
	}

	public void adicionaPedido(Pedido pedido) {
		this.pedidosProduto.put(pedido.getNumero(), pedido);
	}

	public void removePedido(Pedido pedido) {
		if (pedidosProduto.containsKey(pedido.getNumero())) {
			this.pedidosProduto.remove(pedido);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(peso) != Double
				.doubleToLongBits(other.peso))
			return false;
		return true;
	}

}
