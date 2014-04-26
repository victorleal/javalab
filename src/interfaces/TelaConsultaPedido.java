package interfaces;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaConsultaPedido extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public TelaConsultaPedido() {
		
setLayout(new MigLayout("", "[1.00][grow]", "[][][][][][][grow][]"));
		
		JLabel lblConsultarPedido = new JLabel("Consultar Pedido");
		add(lblConsultarPedido, "cell 0 0 2 1,alignx center");
		
		JLabel lblNmeroPedido = new JLabel("Número Pedido:");
		add(lblNmeroPedido, "cell 0 2,alignx trailing");
		
		textField = new JTextField();
		add(textField, "cell 1 2,growx");
		textField.setColumns(10);
		
		JLabel lblCpfCliente = new JLabel("CPF Cliente:");
		add(lblCpfCliente, "cell 0 3,alignx trailing");
		
		textField_1 = new JTextField();
		add(textField_1, "cell 1 3,growx");
		textField_1.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		add(btnBuscar, "cell 1 4,alignx right");
		
		JLabel lblPedidosEncontrados = new JLabel("Pedidos Encontrados");
		add(lblPedidosEncontrados, "cell 0 5 2 1,alignx center");
		
		JList list = new JList();
		add(list, "cell 0 6 2 1,grow");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.EscondePaineis();
			}
		});
		add(btnCancelar, "flowx,cell 1 7,alignx right,aligny bottom");
		
		JButton btnExcluir = new JButton("Excluir");
		add(btnExcluir, "cell 1 7,alignx right");	
		

	}

}
