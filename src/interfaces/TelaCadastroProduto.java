package interfaces;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import core.Loja;
import core.Produto;

public class TelaCadastroProduto extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Labels
	private JLabel lblCadastrarProduto;
	private JLabel lblId;
	private JLabel lblPeso;
	private JLabel lblValorUnitario;
	private JLabel lblQuantidadeNoEstoque;
	private JLabel lblCategoria;
	private JLabel lblConteudo;
	private JLabel lblDescricao;

	// Fields
	private JTextField textFieldId;
	private JTextField textFieldConteudo;
	private JTextField textFieldDescricao;
	private JTextField textFieldPeso;
	private JTextField textFieldValorUnitario;
	private JTextField textFieldQtdeEstoque;

	// ComboBox
	private JComboBox<String> comboBoxCategoria;

	// Buttons
	private JButton btnCancelar;
	private JButton btnCadastrar;

	// Controla o panel
	private JPanel panel;

	// Controla a loja
	private Loja loja;

	/**
	 * Create the panel.
	 */
	public TelaCadastroProduto(Loja l) {
		panel = this;
		this.loja = l;

		setLayout(new MigLayout("", "[][][grow]",
				"[][30.00][][][][][][][][43.00][]"));

		lblCadastrarProduto = new JLabel("Cadastrar Produto");
		lblCadastrarProduto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblCadastrarProduto, "cell 0 0 3 1,alignx center");

		lblId = new JLabel("ID:");
		add(lblId, "flowx,cell 0 2,alignx right");

		textFieldId = new JTextField();
		add(textFieldId, "cell 1 2,growx");
		textFieldId.setColumns(10);

		lblPeso = new JLabel("Peso:");
		add(lblPeso, "cell 0 3,alignx right");

		textFieldPeso = new JTextField();
		add(textFieldPeso, "cell 1 3,growx");
		textFieldPeso.setColumns(10);

		lblValorUnitario = new JLabel("Valor Unitário:");
		add(lblValorUnitario, "cell 0 4,alignx right");

		textFieldValorUnitario = new JTextField();
		add(textFieldValorUnitario, "cell 1 4,growx");
		textFieldValorUnitario.setColumns(10);

		lblQuantidadeNoEstoque = new JLabel("Quantidade no Estoque:");
		add(lblQuantidadeNoEstoque, "cell 0 5,alignx right");

		textFieldQtdeEstoque = new JTextField();
		add(textFieldQtdeEstoque, "cell 1 5,growx");
		textFieldQtdeEstoque.setColumns(10);

		lblCategoria = new JLabel("Categoria:");
		add(lblCategoria, "cell 0 6,alignx right");

		comboBoxCategoria = new JComboBox<String>();
		comboBoxCategoria.addItem("COMPUTADORES");
		comboBoxCategoria.addItem("TELEFONIA");
		comboBoxCategoria.addItem("VIDEOSOM");
		comboBoxCategoria.addItem("TABLETS");
		comboBoxCategoria.addItem("GAMES");
		add(comboBoxCategoria, "cell 1 6 2 1,growx");

		lblConteudo = new JLabel("Conteúdo da Caixa:");
		add(lblConteudo, "cell 0 7,alignx right");

		textFieldConteudo = new JTextField();
		add(textFieldConteudo, "cell 1 7 2 1,growx");
		textFieldConteudo.setColumns(10);

		lblDescricao = new JLabel("Descrição:");
		add(lblDescricao, "cell 0 8,alignx right");

		textFieldDescricao = new JTextField();
		add(textFieldDescricao, "cell 1 8 2 1,growx");
		textFieldDescricao.setColumns(10);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container parent = panel.getParent();
				CardLayout cl = (CardLayout) parent.getLayout();
				cl.show(parent, "Inicial");
			}
		});
		add(btnCancelar, "flowx,cell 2 10,alignx right,aligny bottom");

		btnCadastrar = new JButton("Cadastrar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(textFieldId.getText());
				String categoria = (String) comboBoxCategoria.getSelectedItem();
				String conteudodaCaixa = textFieldConteudo.getText();
				String descricao = textFieldDescricao.getText();
				double peso = Double.parseDouble(textFieldPeso.getText());
				double valorUnitario = Double
						.parseDouble(textFieldValorUnitario.getText());
				int qtdeEstoque = Integer.parseInt(textFieldQtdeEstoque
						.getText());
				Produto p = new Produto(id, categoria, conteudodaCaixa,
						descricao, peso, valorUnitario, qtdeEstoque);
				loja.cadastrarProduto(p);
			}
		});
		add(btnCadastrar, "cell 2 10");

	}

}
