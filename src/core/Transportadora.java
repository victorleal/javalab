package core;

import java.util.HashMap;
import java.util.Map;

public class Transportadora {

	private String cnpj;
	private String nomeFantasia;
	private String razaoSocial;
	private int prazoEntrega;
	private double taxaEntrega;
	private Endereco endereco;
	private Map<Integer, Pedido> pedidosTransportadora;

	public String getCnpj() {
		return cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public Map<Integer, Pedido> getPedidosTransportadora() {
		return pedidosTransportadora;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public int getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(int prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	public double getTaxaEntrega() {
		return taxaEntrega;
	}

	public void setTaxaEntrega(double taxaEntrega) {
		this.taxaEntrega = taxaEntrega;
	}

	public Transportadora(String cnpj, String nomeFantasia, String razaoSocial,
			int prazoEntrega, double taxaEntrega, Endereco endereco) {
		super();
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.prazoEntrega = prazoEntrega;
		this.taxaEntrega = taxaEntrega;
		this.endereco = endereco;
		this.pedidosTransportadora = new HashMap<Integer, Pedido>();
	}

	public void adicionaPedido(Pedido pedido) {
		this.pedidosTransportadora.put(pedido.getNumero(), pedido);
	}

	public void removePedido(Pedido pedido) {
		if (pedidosTransportadora.containsKey(pedido.getNumero())) {
			this.pedidosTransportadora.remove(pedido);
		}
	}

}
