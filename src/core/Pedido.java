package core;

import java.util.Calendar;
import java.util.Map;

public class Pedido {

	private Integer numero;
	private double valorTotal;
	private String formaPagamento;
	private Calendar dataCompra;
	private Calendar dataEntrega;
	private Endereco endereco;
	private Cliente cliente;
	private Map<Produto, Integer> produtosPedido;
	private Transportadora transportadora;

	public Integer getNumero() {
		return numero;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Map<Produto, Integer> getProdutosPedido() {
		return produtosPedido;
	}

	public Calendar getDataCompra() {
		return dataCompra;
	}

	public Calendar getDataEntrega() {
		return dataEntrega;
	}

	public Transportadora getTransportadora() {
		return this.transportadora;
	}
	

	private void setNumero(Integer numero) {
		this.numero = numero;
	}

	private void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	private void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	private void setDataCompra(Calendar dataCompra) {
		this.dataCompra = dataCompra;
	}

	private void setDataEntrega(Calendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	private void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	private void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	private void setTransportadora(Transportadora transportadora) {
		this.transportadora = transportadora;
	}

	public Pedido(Integer numero, double valorTotal, String formaPagamento,
			Calendar dataCompra, Calendar dataEntrega, Endereco endereco,
			Cliente cliente, Map<Produto, Integer> produtosPedido,
			Transportadora transportadora) {
		super();
		this.numero = numero;
		this.valorTotal = valorTotal;
		this.formaPagamento = formaPagamento;
		this.dataCompra = dataCompra;
		this.dataEntrega = dataEntrega;
		this.endereco = endereco;
		this.cliente = cliente;
		if (produtosPedido == null) {
			System.out.println("Lista Vazia");
		}
		this.produtosPedido = produtosPedido;
		this.transportadora = transportadora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result
				+ ((transportadora == null) ? 0 : transportadora.hashCode());
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
		Pedido other = (Pedido) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (transportadora == null) {
			if (other.transportadora != null)
				return false;
		} else if (!transportadora.equals(other.transportadora))
			return false;
		return true;
	}

}
