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

	public Transportadora() {
	}

	public void adicionaPedido(Pedido pedido) {
		this.pedidosTransportadora.put(pedido.getNumero(), pedido);
	}

	public void removePedido(Pedido pedido) {
		if (pedidosTransportadora.containsKey(pedido.getNumero())) {
			this.pedidosTransportadora.remove(pedido);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result
				+ ((nomeFantasia == null) ? 0 : nomeFantasia.hashCode());
		result = prime * result
				+ ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
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
		Transportadora other = (Transportadora) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (nomeFantasia == null) {
			if (other.nomeFantasia != null)
				return false;
		} else if (!nomeFantasia.equals(other.nomeFantasia))
			return false;
		if (razaoSocial == null) {
			if (other.razaoSocial != null)
				return false;
		} else if (!razaoSocial.equals(other.razaoSocial))
			return false;
		return true;
	}

}
