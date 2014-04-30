package auxiliar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import core.Cliente;
import core.Pedido;
import core.Produto;
import core.Transportadora;

/**
 * 
 * Esta classe gerencia os pedidos realizados. Ela relaciona um pedido com a
 * respectiva transportadora, o respectivo cliente, e com os produtos do pedido.
 * 
 */
public class GerenciadorPedidos {

	private Map<Cliente, List<Pedido>> clienteXPedido;
	private Map<Transportadora, List<Pedido>> transportadoraXPedido;
	private Map<Produto, List<Pedido>> produtoXPedido;
	private List<Pedido> temp;

	public GerenciadorPedidos() {
		clienteXPedido = new HashMap<Cliente, List<Pedido>>();
		transportadoraXPedido = new HashMap<Transportadora, List<Pedido>>();
		produtoXPedido = new HashMap<Produto, List<Pedido>>();
		temp = new ArrayList<Pedido>();
	}

	/***** Consultas ****/

	/**
	 * @param c
	 * @return true se a lista de pedidos do cliente estiver vazia
	 */
	public boolean consultaPedidosCliente(Cliente c) {
		temp = clienteXPedido.get(c);
		if (temp != null && !temp.isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean consultaPedidosTransportadora(Transportadora t) {
		temp = transportadoraXPedido.get(t);
		if (temp != null && !temp.isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean consultaPedidosProduto(Produto p) {
		temp = produtoXPedido.get(p);
		if (temp != null && !temp.isEmpty()) {
			return false;
		}
		return true;
	}
	
	/***** Retorna Pedidos ****/
	public List<Pedido> getPedidosCliente(Cliente c) {
		return clienteXPedido.get(c);
	}
	
	public List<Pedido> getPedidosTransportadora(Transportadora t) {
		return transportadoraXPedido.get(t);
	}
	
	public List<Pedido> getPedidosProduto(Produto p) {
		return produtoXPedido.get(p);
	}

	/***** Adições ****/

	public void adicionaPedido(Cliente c, Transportadora t,
			Set<Produto> produtos, Pedido p) {
		adicionaClienteXPedido(c, p);
		adicionaTransportadoraXPedido(t, p);

		for (Produto prod : produtos) {
			adicionaProdutoXPedido(prod, p);
		}
	}

	public void removePedido(Cliente c, Transportadora t,
			Set<Produto> produtos, Pedido p) {
		removeClienteXPedido(c, p);
		removeTransportadoraXPedido(t, p);

		for (Produto prod : produtos) {
			removeProdutoXPedido(prod, p);
		}
	}

	protected void adicionaTransportadoraXPedido(Transportadora t, Pedido p) {
		if (transportadoraXPedido.containsKey(t)) {
			temp = transportadoraXPedido.get(t);
			temp.add(p);
		} else {
			temp.add(p);
		}
		transportadoraXPedido.put(t, temp);
	}

	protected void adicionaProdutoXPedido(Produto prod, Pedido p) {
		if (produtoXPedido.containsKey(prod)) {
			temp = produtoXPedido.get(prod);
			temp.add(p);
		} else {
			temp.add(p);
		}
		produtoXPedido.put(prod, temp);
	}

	protected void adicionaClienteXPedido(Cliente c, Pedido p) {
		if (clienteXPedido.containsKey(c)) {
			temp = clienteXPedido.get(c);
			temp.add(p);
		} else {
			temp.add(p);
		}
		clienteXPedido.put(c, temp);
	}

	/***** Remoções ****/

	protected void removeClienteXPedido(Cliente c, Pedido p) {
		if (clienteXPedido.containsKey(c)) {
			temp = clienteXPedido.get(c);
			for (int i = 0; i < temp.size(); i++) {
				if (temp.get(i).equals(p)) {
					temp.remove(temp.get(i));
					--i;
				}
			}
			clienteXPedido.put(c, temp);
		}
	}

	protected void removeTransportadoraXPedido(Transportadora t, Pedido p) {
		if (transportadoraXPedido.containsKey(t)) {
			temp = transportadoraXPedido.get(t);
			for (int i = 0; i < temp.size(); i++) {
				if (temp.get(i).equals(p)) {
					temp.remove(temp.get(i));
					--i;
				}
			}
			transportadoraXPedido.put(t, temp);
		}
	}

	protected void removeProdutoXPedido(Produto prod, Pedido p) {
		if (produtoXPedido.containsKey(prod)) {
			temp = produtoXPedido.get(prod);
			for (int i = 0; i < temp.size(); i++) {
				if (temp.get(i).equals(p)) {
					temp.remove(temp.get(i));
					--i;
				}
			}
			produtoXPedido.put(prod, temp);
		}
	}
}
