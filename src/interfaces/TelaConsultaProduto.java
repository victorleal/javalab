package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import core.Loja;

public class TelaConsultaProduto extends JPanel {

	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public TelaConsultaProduto(Loja loja) {

		setLayout(new MigLayout("", "[1.00][grow]", "[][][][][][][grow][]"));

		JLabel lblConsultarProduto = new JLabel("Consultar Produto");
		add(lblConsultarProduto, "cell 0 0 2 1,alignx center");

		JLabel label = new JLabel("ID:");
		add(label, "cell 0 2,alignx right");

		textField = new JTextField();
		add(textField, "cell 1 2,growx");
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Categoria:");
		add(lblNewLabel_1, "cell 0 3,alignx right");

		JComboBox comboBox = new JComboBox();
		add(comboBox, "cell 1 3,growx");

		JButton btnBuscar = new JButton("Buscar");
		add(btnBuscar, "cell 1 4,alignx right");

		JLabel lblProdutosEncontrados = new JLabel("Produtos Encontrados");
		add(lblProdutosEncontrados, "cell 0 5 2 1,alignx center");

		JList list = new JList();
		add(list, "cell 0 6 2 1,grow");

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnCancelar, "flowx,cell 1 7,alignx right,aligny bottom");

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnAlterar, "cell 1 7");

		JButton btnExcluir = new JButton("Excluir");
		add(btnExcluir, "cell 1 7,alignx right");

	}

}
