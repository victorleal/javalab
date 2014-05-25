package interfaces;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import net.miginfocom.swing.MigLayout;
import auxiliar.ComboBoxTransportadoraRenderer;
import auxiliar.TabelaPedidosCellRenderer;
import auxiliar.TableModel;
import core.Cliente;
import core.Endereco;
import core.Loja;
import core.Pedido;
import core.Produto;
import core.Transportadora;
import exceptions.ParametroException;

public class TelaDetalhesPedido extends GeneralPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNumero;
	private JLabel lblCpfCliente;
	private JLabel lblNome;
	private JLabel lblCdigoProduto;
	private JLabel lblQuantidade;
	private JLabel lblValorTotal;
	private JLabel lblFormaDePagamento;
	private JLabel lblDataDeCompra;
	private JLabel lblNomeTransportadora;
	private JLabel lblDataDeEntrega;

	// TextFields
	private JTextField textFieldCodigoProduto;
	private JTextField textFieldQtdeProduto;
	private JTextField textFieldNumero;
	private JFormattedTextField textFieldCpfCliente;
	private JTable table;
	private JTextField textFieldValorTotal;
	private JTextField textFieldNome;
	private JFormattedTextField textFieldDataCompra;
	private JFormattedTextField textFieldDataEntrega;

	// ComboBox
	private JComboBox<String> comboBoxFormaPagamento;
	private JComboBox<Transportadora> comboBoxTransportadora;

	private JButton btnCancelar;
	private JButton btnCadastrar;
	private JButton btnLimpar;
	private JButton btnBuscaCliente;
	private JButton btnAdicionarEndereco;

	// Mascaras
	private MaskFormatter mascaraCpf;
	private MaskFormatter mascaraData;

	// Controla os panels
	private JPanel panelProdutos;
	private JPanel panelTransportadora;

	// Controla cliente
	private Cliente c;

	// Controla TelaEnderecoEntrega
	private TelaEnderecoEntregaPedido te;

	// Controla lista de produtos
	Map<Produto, Integer> produtos;

	// Controla produto recem adicionado
	int produtosAdicionados = 0;
	
	// Controla quantidade disponivel
	int qtdeDisponivel = 0;

	// Controla o Pedido
	Pedido p;
	
	/**
	 * Create the panel.
	 */
	public TelaDetalhesPedido(Loja l) {
		super(l);
		p = loja.getPedidoDetalhe();
		te = new TelaEnderecoEntregaPedido();
		produtos = new HashMap<Produto, Integer>();
		

		setBorder(new TitledBorder(null, "Detalhes do Pedido",
				TitledBorder.LEADING, TitledBorder.TOP, this.fonte));
		setLayout(new MigLayout("", "[][][grow][][grow][67.00]",
				"[][][][14.00][][][][][][grow,bottom]"));

		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setPlaceholderCharacter('_');
			mascaraData = new MaskFormatter("##/##/####");
			mascaraData.setPlaceholderCharacter('_');
		} catch (ParseException e2) {
			showMensagemErro();
		}

		lblNumero = new JLabel("Número:");
		add(lblNumero, "cell 0 1,alignx right");
	//	Integer id = loja.getIdPedido();
	//	String idPedido = id.toString();

		textFieldNumero = new JTextField();
		textFieldNumero.setText(String.valueOf(new Integer(p
				.getId())));;
		textFieldNumero.setEditable(false);
		add(textFieldNumero, "cell 1 1,growx");
		textFieldNumero.setColumns(10);

		/*lblCpfCliente = new JLabel("CPF Cliente:");
		add(lblCpfCliente, "cell 2 1,alignx right");
		textFieldCpfCliente = new JFormattedTextField(mascaraCpf);
		textFieldCpfCliente.setText(c.getCpf());
		textFieldCpfCliente.setEditable(false);
		add(textFieldCpfCliente, "cell 3 1 2 1,growx");
		textFieldCpfCliente.setColumns(10);


		//String cpf = ((String) textFieldCpfCliente.getValue());
		//c = loja.consultarCliente(cpf);
		textFieldNome.setText(c.getNome());*/
		panelProdutos.setVisible(true);
		panelTransportadora.setVisible(true);
		comboBoxFormaPagamento.setEnabled(true);
		textFieldDataCompra.setEnabled(true);


		lblNome = new JLabel("Nome:");
		add(lblNome, "cell 0 2,alignx right");

		textFieldNome = new JTextField();
		add(textFieldNome, "cell 1 2 4 1,growx");
		textFieldNome.setColumns(10);
		textFieldNome.setEditable(false);

		panelProdutos = new JPanel();
		panelProdutos.setBorder(new TitledBorder(null, "Produtos",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panelProdutos, "cell 0 3 6 2,grow");
		panelProdutos.setLayout(new MigLayout("", "[][grow][grow][grow][grow]",
				"[][][][][]"));
		panelProdutos.setVisible(false);

		lblCdigoProduto = new JLabel("Código Produto:");
		panelProdutos.add(lblCdigoProduto, "cell 0 0,alignx right");

		textFieldCodigoProduto = new JTextField();
		textFieldCodigoProduto.setEditable(false);
		panelProdutos.add(textFieldCodigoProduto, "cell 1 0,growx");
		textFieldCodigoProduto.setColumns(10);

		lblQuantidade = new JLabel("Quantidade:");
		panelProdutos.add(lblQuantidade, "cell 2 0,alignx right");

		textFieldQtdeProduto = new JTextField();
		textFieldQtdeProduto.setEditable(false);
		panelProdutos.add(textFieldQtdeProduto, "cell 3 0,growx");
		textFieldQtdeProduto.setColumns(10);

		String[] cabecalho = { "Produto", "Quantidade" };
		int linhas = 0;
		TableModel model = new TableModel(linhas, cabecalho);
		model.setColumnIdentifiers(cabecalho);
		table = new JTable(model);
		table.getColumn("Produto").setCellRenderer(
				new TabelaPedidosCellRenderer());
		JScrollPane scrollPane = new JScrollPane(table);
		// table.setFillsViewportHeight(true);
		panelProdutos.add(scrollPane, "cell 0 1 5 3,grow");

		lblValorTotal = new JLabel("Valor Total:");
		panelProdutos.add(lblValorTotal, "cell 3 4,alignx right");

		textFieldValorTotal = new JTextField();
		textFieldValorTotal.setText(String.valueOf(new Double(p.getValorTotal())));
		textFieldValorTotal.setEditable(false);
		panelProdutos.add(textFieldValorTotal, "cell 4 4,growx");
		textFieldValorTotal.setColumns(10);

		lblNomeTransportadora = new JLabel("Nome:");
		panelTransportadora.add(lblNomeTransportadora, "cell 0 0,alignx right");

		comboBoxTransportadora = new JComboBox<Transportadora>();
		comboBoxTransportadora
				.setRenderer(new ComboBoxTransportadoraRenderer());
		panelTransportadora.add(comboBoxTransportadora, "cell 1 0 3 1,growx");

		lblDataDeEntrega = new JLabel("Data de Entrega:");
		panelTransportadora.add(lblDataDeEntrega, "cell 4 0,alignx right");

		textFieldDataEntrega = new JFormattedTextField(mascaraData);
		//textFieldDataEntrega = setText((String.valueOf(new Data(p.getDataEntrega());
		textFieldDataEntrega.setEditable(false);
		panelTransportadora.add(textFieldDataEntrega, "cell 5 0 2 1,growx");
		textFieldDataEntrega.setColumns(10);

		lblFormaDePagamento = new JLabel("Forma de Pagamento:");
		add(lblFormaDePagamento, "cell 0 7,alignx right");

		comboBoxFormaPagamento = new JComboBox<String>();
		comboBoxFormaPagamento.addItem("A vista");
		comboBoxFormaPagamento.addItem("Cartão Crédito");
		comboBoxFormaPagamento.addItem("Parcelamento");
		add(comboBoxFormaPagamento, "cell 1 7 2 1,growx");
		comboBoxFormaPagamento.setEnabled(false);

		lblDataDeCompra = new JLabel("Data de Compra:");
		add(lblDataDeCompra, "cell 3 7,alignx right");

		textFieldDataCompra = new JFormattedTextField(mascaraData);
		textFieldDataCompra.setEditable(false);
		add(textFieldDataCompra, "cell 4 7 2 1,growx");
		textFieldDataCompra.setColumns(10);

		btnAdicionarEndereco = new JButton("Adicionar Endereço Entrega");
		btnAdicionarEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container parent = panel.getParent();
				parent.add(te, "EnderecoEntrega");
				CardLayout cl = (CardLayout) parent.getLayout();
				cl.show(parent, "EnderecoEntrega");
			}
		});
		add(btnAdicionarEndereco, "cell 3 8 3 1,growx");

		btnCancelar = new JButton("Ok");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTelaPrincipal();	
			}
		});
		add(btnCancelar, "flowx,cell 0 9 6 1,alignx right");


	}

	@Override
	public void limparCampos() {
		// TODO Auto-generated method stub
		
	}	
}
