

public class ItemPedido {
	private int qtde;
	private Produto produto;
	
	public ItemPedido(int qtde, Produto produto) {
		this.qtde = qtde;
		this.produto = produto;
	}
	
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	public Produto getProdutosPedido() {
		return produto;
	}
	public void setProdutosPedido(Produto produtosPedido) {
		this.produto = produtosPedido;
	}
}
