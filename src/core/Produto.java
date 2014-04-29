package core;

import java.util.HashMap;
import java.util.Map;

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

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public int getQtdeEstoque() {
		return qtdeEstoque;
	}

	public void setQtdeEstoque(int qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}

	public Produto(int id, String categoria, String conteudodaCaixa,
			String descricao, double peso, double valorUnitario, int qtdeEstoque) {
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
