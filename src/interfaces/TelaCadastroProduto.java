package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import net.miginfocom.swing.MigLayout;
import core.Loja;

public class TelaCadastroProduto extends GeneralPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private JFormattedTextField textFieldPeso;
	private JFormattedTextField textFieldValorUnitario;
	private JTextField textFieldQtdeEstoque;

	// Mascaras
	private MaskFormatter mascaraPeso;
	//private MaskFormatter mascaraValor;
	//private DecimalFormat mascaraValor;
	private NumberFormatter mascaraValor; 
	
	// ComboBox
	private JComboBox<String> comboBoxCategoria;

	// Buttons
	private JButton btnCancelar;
	private JButton btnCadastrar;
	private JButton btnLimpar;

	/**
	 * Create the panel.
	 */
	public TelaCadastroProduto(Loja l) {
		super(l);

		setBorder(new TitledBorder(null, "Cadastrar Produto",
				TitledBorder.LEADING, TitledBorder.TOP, this.fonte));
		setLayout(new MigLayout("", "[][grow]", "[][][][][][][][grow,bottom]"));
		
		try {	        
			mascaraPeso = new MaskFormatter("####,##");
			mascaraPeso.setPlaceholderCharacter('_');
			
			mascaraValor = new NumberFormatter(new DecimalFormat("$ #,###.00"));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		lblId = new JLabel("ID:");
		add(lblId, "flowx,cell 0 0,alignx right");

		textFieldId = new JTextField();
		textFieldId.setEditable(false);
		Integer id = loja.getIdPedido();
		String idPedido = id.toString();
		textFieldId.setText(idPedido);
		add(textFieldId, "cell 1 0,growx");
		textFieldId.setColumns(10);

		lblPeso = new JLabel("Peso:");
		add(lblPeso, "cell 0 1,alignx right");

		textFieldPeso = new JFormattedTextField(mascaraPeso);
		add(textFieldPeso, "cell 1 1,growx");
		textFieldPeso.setColumns(10);

		lblValorUnitario = new JLabel("Valor Unitário:");
		add(lblValorUnitario, "cell 0 2,alignx right");

		textFieldValorUnitario = new JFormattedTextField(mascaraValor);
		//textFieldValorUnitario.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		add(textFieldValorUnitario, "cell 1 2,growx");
		textFieldValorUnitario.setColumns(10);

		lblQuantidadeNoEstoque = new JLabel("Quantidade no Estoque:");
		add(lblQuantidadeNoEstoque, "cell 0 3,alignx right");

		textFieldQtdeEstoque = new JTextField();
		add(textFieldQtdeEstoque, "cell 1 3,growx");
		textFieldQtdeEstoque.setColumns(10);

		lblCategoria = new JLabel("Categoria:");
		add(lblCategoria, "cell 0 4,alignx right");

		comboBoxCategoria = new JComboBox<String>();
		comboBoxCategoria.addItem("COMPUTADORES");
		comboBoxCategoria.addItem("TELEFONIA");
		comboBoxCategoria.addItem("VIDEOSOM");
		comboBoxCategoria.addItem("TABLETS");
		comboBoxCategoria.addItem("GAMES");
		add(comboBoxCategoria, "cell 1 4,growx");

		lblConteudo = new JLabel("Conteúdo da Caixa:");
		add(lblConteudo, "cell 0 5,alignx right");

		textFieldConteudo = new JTextField();
		add(textFieldConteudo, "cell 1 5,growx");
		textFieldConteudo.setColumns(10);

		lblDescricao = new JLabel("Descrição:");
		add(lblDescricao, "cell 0 6,alignx right");

		textFieldDescricao = new JTextField();
		add(textFieldDescricao, "cell 1 6,growx");
		textFieldDescricao.setColumns(10);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTelaPrincipal();
			}
		});
		add(btnCancelar, "flowx,cell 0 7 2 1,alignx right,aligny bottom");

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});
		add(btnLimpar, "cell 0 7,alignx right,aligny bottom");

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String categoria = (String) comboBoxCategoria.getSelectedItem();
				String conteudodaCaixa = textFieldConteudo.getText();
				String descricao = textFieldDescricao.getText();
				double peso = Double.parseDouble(textFieldPeso.getText());
				double valorUnitario = Double
						.parseDouble(textFieldValorUnitario.getText());
				int qtdeEstoque = Integer.parseInt(textFieldQtdeEstoque
						.getText());

				loja.cadastrarProduto(categoria, conteudodaCaixa, descricao,
						peso, valorUnitario, qtdeEstoque);

				showMensagemSucesso("Produto cadastrado com sucesso!");
				showTelaPrincipal();
			}
		});
		add(btnCadastrar, "cell 0 7,alignx right,aligny bottom");
	}

	@Override
	public void limparCampos() {
		textFieldConteudo.setText("");
		textFieldDescricao.setText("");
		textFieldId.setText("");
		textFieldPeso.setText("");
		textFieldQtdeEstoque.setText("");
		textFieldValorUnitario.setText("");
	}

}
