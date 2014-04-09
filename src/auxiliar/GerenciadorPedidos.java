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
			for (Pedido ped : temp) {
				if (ped.equals(p)) {
					temp.remove(ped);
				}
			}
			clienteXPedido.put(c, temp);
		}
	}

	protected void removeTransportadoraXPedido(Transportadora t, Pedido p) {
		if (transportadoraXPedido.containsKey(t)) {
			temp = transportadoraXPedido.get(t);
			for (Pedido ped : temp) {
				if (ped.equals(p)) {
					temp.remove(ped);
				}
			}
			transportadoraXPedido.put(t, temp);
		}
	}

	protected void removeProdutoXPedido(Produto prod, Pedido p) {
		if (produtoXPedido.containsKey(prod)) {
			temp = produtoXPedido.get(prod);
			for (Pedido ped : temp) {
				if (ped.equals(p)) {
					temp.remove(ped);
				}
			}
			produtoXPedido.put(prod, temp);
		}
	}
}
