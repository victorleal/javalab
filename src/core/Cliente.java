package core;

import java.util.ArrayList;
import java.util.List;

import exceptions.ParametroException;

public class Cliente extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	private Boolean isClienteFidelidade;
	private String programaFidelidade;
	private String numeroFidelidade;
	private List<Pedido> pedidosCliente;

	public Boolean getIsClienteFidelidade() {
		return isClienteFidelidade;
	}

	public void setIsClienteFidelidade(Boolean isClienteFidelidade) {
		this.isClienteFidelidade = isClienteFidelidade;
	}

	public String getProgramaFidelidade() {
		return programaFidelidade;
	}

	public void setProgramaFidelidade(String programaFidelidade) {
		this.programaFidelidade = programaFidelidade;
	}

	public String getNumeroFidelidade() {
		return numeroFidelidade;
	}

	public void setNumeroFidelidade(String numeroFidelidade) {
		this.numeroFidelidade = numeroFidelidade;
	}

	public Cliente(String nome, String cpf, String email, String telefone,
			String celular, Endereco endereco, Boolean isClienteFidelidade,
			String programaFidelidade, String numeroFidelidade) throws ParametroException {
		super(nome, cpf, email, telefone, celular, endereco, "Cliente");
		this.isClienteFidelidade = isClienteFidelidade;
		this.programaFidelidade = programaFidelidade;
		this.numeroFidelidade = numeroFidelidade;
		this.pedidosCliente = new ArrayList<Pedido>();
	}

	public List<Pedido> getPedidosCliente() {
		return pedidosCliente;
	}

	public void setPedidosCliente(List<Pedido> pedidosCliente) {
		this.pedidosCliente = pedidosCliente;
	}

	public void adicionaPedido(Pedido pedido) {
		this.pedidosCliente.add(pedido);
	}

	public void removePedido(Pedido pedido) {
		this.pedidosCliente.remove(pedido);
	}

}
