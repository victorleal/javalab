package core;

import java.util.ArrayList;
import java.util.List;

import exceptions.ParametroException;
import exceptions.Validadores;

public class Transportadora extends PersistentObject {

	private static final long serialVersionUID = 1L;

	private String cnpj;
	private String nomeFantasia;
	private String razaoSocial;
	private int prazoEntrega;
	private double taxaEntrega;
	private Endereco endereco;
	private List<Pedido> pedidosTransportadora;

	public String getCnpj() {
		return cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public List<Pedido> getPedidosTransportadora() {
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

	public void setPrazoEntrega(int prazoEntrega) throws ParametroException {
		if (prazoEntrega <= 0) {
			throw new ParametroException("Prazo de Entrega");
		} else {
			this.prazoEntrega = prazoEntrega;
		}
	}

	public double getTaxaEntrega() {
		return taxaEntrega;
	}

	public void setTaxaEntrega(double taxaEntrega) throws ParametroException {
		if (taxaEntrega <= 0) {
			throw new ParametroException("Taxa de Entrega");
		} else {
			this.taxaEntrega = taxaEntrega;
		}
	}

	private void setCnpj(String cnpj) throws ParametroException {
		if (cnpj == null || cnpj.isEmpty() || !Validadores.validaCNPJ(cnpj)) {
			throw new ParametroException("CNPJ");
		} else {
			this.cnpj = cnpj;
		}
	}

	private void setNomeFantasia(String nomeFantasia) throws ParametroException {
		if (nomeFantasia == null || nomeFantasia.isEmpty()) {
			throw new ParametroException("Nome Fantasia");
		} else {
			this.nomeFantasia = nomeFantasia;
		}
	}

	private void setRazaoSocial(String razaoSocial) throws ParametroException {
		if (razaoSocial == null || razaoSocial.isEmpty()) {
			throw new ParametroException("Razão Social");
		} else {
			this.razaoSocial = razaoSocial;
		}
	}

	private void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Transportadora(String cnpj, String nomeFantasia, String razaoSocial,
			int prazoEntrega, double taxaEntrega, Endereco endereco)
			throws ParametroException {
		// Substitui a barra / por # para evitar problemas na persistencia
		super("Transportadora", cnpj.replace("/", "#"));
		setCnpj(cnpj);
		setRazaoSocial(razaoSocial);
		setNomeFantasia(nomeFantasia);
		setPrazoEntrega(prazoEntrega);
		setTaxaEntrega(taxaEntrega);
		setEndereco(endereco);
		this.pedidosTransportadora = new ArrayList<Pedido>();
	}

	public void adicionaPedido(Pedido pedido) {
		this.pedidosTransportadora.add(pedido);
	}

	public void removePedido(Pedido pedido) {
		if (pedidosTransportadora.contains(pedido)) {
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
