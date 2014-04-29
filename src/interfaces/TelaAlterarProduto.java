package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import core.Loja;
import core.Produto;

public class TelaAlterarProduto extends GeneralPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// textField
	private JTextField textFieldValorUnitario;
	private JTextField textFieldQtdeEstoque;

	// Buttons
	private JButton btnCancelar;
	private JButton btnSalvar;

	// Labels
	private JLabel lblValorUnitrio;
	private JLabel lblQuantidadeNoEstoque;

	// Controla o produto
	Produto p;

	/**
	 * Create the panel.
	 */
	public TelaAlterarProduto(Loja l) {
		super(l);
		p = loja.getProdutoAlteracao();

		setBorder(new TitledBorder(null, "Alterar Produto",
				TitledBorder.LEADING, TitledBorder.TOP, this.fonte));
		setLayout(new MigLayout("", "[][grow]", "[][][grow,bottom]"));

		lblValorUnitrio = new JLabel("Valor Unitário:");
		add(lblValorUnitrio, "cell 0 0,alignx trailing");

		textFieldValorUnitario = new JTextField();
		textFieldValorUnitario.setText(String.valueOf(new Double(p
				.getValorUnitario())));
		add(textFieldValorUnitario, "cell 1 0,growx");
		textFieldValorUnitario.setColumns(10);

		lblQuantidadeNoEstoque = new JLabel("Quantidade no Estoque:");
		add(lblQuantidadeNoEstoque, "cell 0 1,alignx trailing");

		textFieldQtdeEstoque = new JTextField();
		textFieldQtdeEstoque.setText(String.valueOf(new Integer(p
				.getQtdeEstoque())));
		add(textFieldQtdeEstoque, "cell 1 1,growx");
		textFieldQtdeEstoque.setColumns(10);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTelaPrincipal();
			}
		});
		add(btnCancelar, "flowx,cell 0 2 2 1,alignx right");

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double valorUnitario = Double
						.parseDouble(textFieldValorUnitario.getText());
				int qtdeEstoque = Integer.parseInt(textFieldQtdeEstoque
						.getText());
				loja.alterarProduto(p, qtdeEstoque);
				loja.alterarProduto(p, valorUnitario);

				showMensagemSucesso("Produto alterado com sucesso!");
				showTelaPrincipal();
			}
		});
		add(btnSalvar, "cell 0 2,alignx right");

	}

	@Override
	public void limparCampos() {
		// TODO Auto-generated method stub

	}

}
