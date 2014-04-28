package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import core.Loja;

public class TelaAlterarProduto extends JPanel {
	private JTextField txtValorUnitario;
	private JTextField txtQtdeEstoque;

	/**
	 * Create the panel.
	 */
	public TelaAlterarProduto(Loja loja) {
		setBorder(new TitledBorder(null, "Alterar Produto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[][grow]", "[][][][][][][][]"));
		
		JLabel lblValorUnitrio = new JLabel("Valor Unitário:");
		add(lblValorUnitrio, "cell 0 0,alignx trailing");
		
		txtValorUnitario = new JTextField();
		add(txtValorUnitario, "cell 1 0,growx");
		txtValorUnitario.setColumns(10);
		
		JLabel lblQuantidadeNoEstoque = new JLabel("Quantidade no Estoque:");
		add(lblQuantidadeNoEstoque, "cell 0 1,alignx trailing");
		
		txtQtdeEstoque = new JTextField();
		add(txtQtdeEstoque, "cell 1 1,growx");
		txtQtdeEstoque.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnCancelar, "flowx,cell 0 7 2 1,alignx right");
		
		JButton btnSalvar = new JButton("Salvar");
		add(btnSalvar, "cell 0 7,alignx right");

	}

}
