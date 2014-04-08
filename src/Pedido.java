import java.util.Calendar;
import java.util.List;

public class Pedido {

	private Integer numero;
	private double valorTotal;
	private String formaPagamento;
	private Calendar dataCompra;
	private Calendar dataEntrega;
	private Endereco endereco;
	private Cliente cliente;
	private List<ItemPedido> produtosPedido;
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

	public List<ItemPedido> getProdutosPedido() {
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

	public Pedido(Integer numero, double valorTotal, String formaPagamento,
			Calendar dataCompra, Calendar dataEntrega, Endereco endereco,
			Cliente cliente, List<ItemPedido> produtosPedido,
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

}
