package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import core.Loja;

public class TelaAlterarProduto extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public TelaAlterarProduto(Loja loja) {
		setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][]"));

		JLabel lblAlterarProduto = new JLabel("Alterar Produto");
		add(lblAlterarProduto, "cell 0 0 2 1,alignx center");

		JLabel lblValorUnitrio = new JLabel("Valor Unitário:");
		add(lblValorUnitrio, "cell 0 2,alignx trailing");

		textField = new JTextField();
		add(textField, "cell 1 2,growx");
		textField.setColumns(10);

		JLabel lblQuantidadeNoEstoque = new JLabel("Quantidade no Estoque:");
		add(lblQuantidadeNoEstoque, "cell 0 3,alignx trailing");

		textField_1 = new JTextField();
		add(textField_1, "cell 1 3,growx");
		textField_1.setColumns(10);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.EscondePaineis();
			}
		});
		add(btnCancelar, "flowx,cell 0 9 2 1,alignx right");

		JButton btnSalvar = new JButton("Salvar");
		add(btnSalvar, "cell 0 9,alignx right");

	}

}
