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

	/***** Adições ****/
	
	public void adicionaPedido(Cliente c, Transportadora t, Produto prod,
			Pedido p) {
		adicionaClienteXPedido(c, p);
		adicionaTransportadoraXPedido(t, p);
		adicionaProdutoXPedido(prod, p);
	}

	public void removePedido(Cliente c, Transportadora t,
			Set<Produto> produtos, Pedido p) {
		removeClienteXPedido(c, p);
		removeTransportadoraXPedido(t, p);

		for (Produto prod : produtos) {
			removeProdutoXPedido(prod, p);
		}
	}

	public void adicionaTransportadoraXPedido(Transportadora t, Pedido p) {
		if (transportadoraXPedido.containsKey(t)) {
			temp = transportadoraXPedido.get(t);
			temp.add(p);
		} else {
			temp.add(p);
		}
		transportadoraXPedido.put(t, temp);
	}

	public void adicionaProdutoXPedido(Produto prod, Pedido p) {
		if (produtoXPedido.containsKey(prod)) {
			temp = produtoXPedido.get(prod);
			temp.add(p);
		} else {
			temp.add(p);
		}
		produtoXPedido.put(prod, temp);
	}

	public void adicionaClienteXPedido(Cliente c, Pedido p) {
		if (clienteXPedido.containsKey(c)) {
			temp = clienteXPedido.get(c);
			temp.add(p);
		} else {
			temp.add(p);
		}
		clienteXPedido.put(c, temp);
	}

	/***** Remoções ****/
	
	public void removeClienteXPedido(Cliente c, Pedido p) {
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

	public void removeTransportadoraXPedido(Transportadora t, Pedido p) {
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

	public void removeProdutoXPedido(Produto prod, Pedido p) {
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
