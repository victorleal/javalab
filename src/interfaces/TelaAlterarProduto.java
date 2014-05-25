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
import exceptions.ParametroException;

public class TelaAlterarProduto extends GeneralPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel lblId;
	private JLabel lblPeso;
	private JLabel lblValorUnitrio;
	private JLabel lblQuantidadeNoEstoque;
	private JLabel lblConteudo;
	private JLabel lblDescricao;

	// Fields
	private JTextField textFieldId;
	private JTextField textFieldConteudo;
	private JTextField textFieldDescricao;
	private JTextField textFieldPeso;
	private JTextField textFieldValorUnitario;
	private JTextField textFieldQtdeEstoque;

	// Buttons
	private JButton btnCancelar;
	private JButton btnSalvar;

	// Labels



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
		setLayout(new MigLayout("", "[][grow]", "[][][][][][][grow,bottom][]"));

		lblId = new JLabel("ID:");
		add(lblId, "flowx,cell 0 0,alignx right");

		textFieldId = new JTextField();
		textFieldId.setEnabled(false);
		textFieldId.setEditable(false);
		textFieldId.setText(String.valueOf(new Integer(p
				.getId())));
		add(textFieldId, "cell 1 0,growx");
		textFieldId.setColumns(10);
		
		lblPeso = new JLabel("Peso:");
		add(lblPeso, "cell 0 1,alignx right");

		textFieldPeso = new JTextField();
		textFieldPeso.setEnabled(false);
		textFieldPeso.setEditable(false);
		textFieldPeso.setText(String.valueOf(new Double(p
				.getPeso())));
		add(textFieldPeso, "cell 1 1,growx");
		textFieldPeso.setColumns(10);
		
		lblDescricao = new JLabel("Descrição:");
		add(lblDescricao, "cell 0 2,alignx right");
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setEditable(false);
		textFieldDescricao.setEnabled(false);
		textFieldDescricao.setText(p.getDescricao());
		add(textFieldDescricao, "cell 1 2,growx");
				textFieldDescricao.setColumns(10);
		
		lblConteudo = new JLabel("Conteúdo da Caixa:");
		add(lblConteudo, "cell 0 3,alignx right");
		
		textFieldConteudo = new JTextField();
		textFieldConteudo.setEditable(false);
		textFieldConteudo.setEnabled(false);
		textFieldConteudo.setText(p.getConteudodaCaixa());
		add(textFieldConteudo, "cell 1 3,growx");
		textFieldConteudo.setColumns(10);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTela("ConsultarProduto");
			}
		});
		
				lblQuantidadeNoEstoque = new JLabel("Quantidade no Estoque:");
				add(lblQuantidadeNoEstoque, "cell 0 4,alignx trailing");
		
				textFieldQtdeEstoque = new JTextField();
				textFieldQtdeEstoque.setText(String.valueOf(new Integer(p
						.getQtdeEstoque())));
				add(textFieldQtdeEstoque, "cell 1 4,growx");
				textFieldQtdeEstoque.setColumns(10);
		
		
		lblValorUnitrio = new JLabel("Valor Unitário:");
		add(lblValorUnitrio, "cell 0 5,alignx trailing");
		
				textFieldValorUnitario = new JTextField();
				textFieldValorUnitario.setText(String.valueOf(new Double(p
						.getValorUnitario())));
				add(textFieldValorUnitario, "cell 1 5,growx");
				textFieldValorUnitario.setColumns(10);
		add(btnCancelar, "flowx,cell 0 6 2 1,alignx right");

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					double valorUnitario = Double
							.parseDouble(textFieldValorUnitario.getText());
					int qtdeEstoque = Integer.parseInt(textFieldQtdeEstoque
							.getText());
					loja.alterarProduto(p, qtdeEstoque);
					loja.alterarProduto(p, valorUnitario);
					showMensagemSucesso("Produto alterado com sucesso!");
					//showTelaPrincipal();
					showTela("ConsultarProduto");
				} catch (NumberFormatException nfe) {
					showMensagemErro("Por favor verifique o preenchimento dos campos Valor Unitario ou Quantidade em Estoque!");
				} catch (ParametroException e1) {
					showMensagemErro(e1.getMessage());
				}

			}
		});
		add(btnSalvar, "cell 0 6 2 1,alignx right");

	}

	@Override
	public void limparCampos() {
		// TODO Auto-generated method stub

	}

}
