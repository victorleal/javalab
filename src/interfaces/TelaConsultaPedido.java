package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import core.Loja;

public class TelaConsultaPedido extends JPanel {
	private JTextField txtNumPed;
	private JTextField txtCpfCliente;

	/**
	 * Create the panel.
	 */
	public TelaConsultaPedido(Loja loja) {
		setBorder(new TitledBorder(null, "Consultar Pedido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
setLayout(new MigLayout("", "[1.00][grow]", "[][][][][grow][]"));
		
		JLabel lblNmeroPedido = new JLabel("Número Pedido:");
		add(lblNmeroPedido, "cell 0 0,alignx trailing");
		
		txtNumPed = new JTextField();
		add(txtNumPed, "cell 1 0,growx");
		txtNumPed.setColumns(10);
		
		JLabel lblCpfCliente = new JLabel("CPF Cliente:");
		add(lblCpfCliente, "cell 0 1,alignx trailing");
		
		txtCpfCliente = new JTextField();
		add(txtCpfCliente, "cell 1 1,growx");
		txtCpfCliente.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		add(btnBuscar, "cell 1 2,alignx right");
		
		JLabel lblPedidosEncontrados = new JLabel("Pedidos Encontrados");
		add(lblPedidosEncontrados, "cell 0 3 2 1,alignx center");
		
		JList list = new JList();
		add(list, "cell 0 4 2 1,grow");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnCancelar, "flowx,cell 1 5,alignx right,aligny bottom");
		
		JButton btnExcluir = new JButton("Excluir");
		add(btnExcluir, "cell 1 5,alignx right");	
		

	}

}
