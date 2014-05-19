package core;

import java.util.Calendar;
import java.util.Map;

import exceptions.ParametroException;

public class Pedido extends PersistentObject {

	private static final long serialVersionUID = 1L;
	
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

	private void setFormaPagamento(String formaPagamento)
			throws ParametroException {
		if (formaPagamento == null || formaPagamento.isEmpty()) {
			throw new ParametroException("Forma Pagamento");
		} else {
			this.formaPagamento = formaPagamento;
		}
	}

	private void setDataCompra(Calendar dataCompra) throws ParametroException {
		if (dataCompra == null) {
			throw new ParametroException("Data Compra");
		} else {
			this.dataCompra = dataCompra;
		}
	}

	private void setDataEntrega(Calendar dataEntrega) throws ParametroException {
		if (dataEntrega == null) {
			throw new ParametroException("Data Entrega");
		} else {
			this.dataEntrega = dataEntrega;
		}
	}

	private void setEndereco(Endereco endereco) throws ParametroException {
		if (endereco == null) {
			throw new ParametroException("endereco");
		} else {
			this.endereco = endereco;
		}
	}

	private void setCliente(Cliente cliente) throws ParametroException {
		if (cliente == null) {
			throw new ParametroException("cliente");
		} else {
			this.cliente = cliente;
		}
	}

	public Pedido(Integer numero, double valorTotal, String formaPagamento,
			Calendar dataCompra, Calendar dataEntrega, Endereco endereco,
			Cliente cliente, Map<Produto, Integer> produtosPedido,
			Transportadora transportadora) throws ParametroException {
		super("Pedido", numero.toString());
		this.numero = numero;
		this.valorTotal = valorTotal;
		if (produtosPedido == null) {
			System.out.println("Lista Vazia");
		}
		this.produtosPedido = produtosPedido;
		this.transportadora = transportadora;

		setCliente(cliente);
		setEndereco(endereco);
		setFormaPagamento(formaPagamento);
		setDataCompra(dataCompra);
		setDataEntrega(dataEntrega);

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
