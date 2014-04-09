import core.Loja;


public class Principal {

	public static void main(String[] args) {
		Loja l = new Loja();
		l.cadastrarCliente();
		l.cadastrarProduto();
		l.cadastrarTransportadora();
		l.cadastrarPedido();
		l.consultarCliente("879465231");

	}

}
