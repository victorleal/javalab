package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import core.Loja;

public class TelaConsultaCliente extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public TelaConsultaCliente(Loja loja) {

		setLayout(new MigLayout("", "[1.00][grow]", "[][][][][][][grow][]"));

		JLabel lblConsultarCliente = new JLabel("Consultar Cliente");
		add(lblConsultarCliente, "cell 0 0 2 1,alignx center");

		JLabel lblCpf = new JLabel("CPF:");
		add(lblCpf, "cell 0 2,alignx trailing");

		textField = new JTextField();
		add(textField, "cell 1 2,growx");
		textField.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		add(lblNome, "cell 0 3,alignx trailing");

		textField_1 = new JTextField();
		add(textField_1, "cell 1 3,growx");
		textField_1.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		add(btnBuscar, "cell 1 4,alignx right");

		JLabel lblClientesEncontrados = new JLabel("Clientes Encontrados");
		add(lblClientesEncontrados, "cell 0 5 2 1,alignx center");

		JList list = new JList();
		add(list, "cell 0 6 2 1,grow");

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.EscondePaineis();
			}
		});
		add(btnCancelar, "flowx,cell 1 7,alignx right,aligny bottom");

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPrincipal.EscondePaineis();
				TelaPrincipal.frame.getContentPane().add(TelaPrincipal.taltcli);
				TelaPrincipal.taltcli.setVisible(true);
				TelaPrincipal.frame.validate();
			}
		});
		add(btnAlterar, "cell 1 7");

		JButton btnExcluir = new JButton("Excluir");
		add(btnExcluir, "cell 1 7,alignx right");

	}

}
