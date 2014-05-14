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
import core.Produto;
import core.Transportadora;
import exceptions.ParametroException;

public class TelaCadastroPedido extends GeneralPanel {
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

	// Buttons
	private JButton buttonAdicionarProduto;
	private JButton btnRemoverProduto;
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

	/**
	 * Create the panel.
	 */
	public TelaCadastroPedido(Loja l) {
		super(l);
		te = new TelaEnderecoEntregaPedido();
		produtos = new HashMap<Produto, Integer>();

		setBorder(new TitledBorder(null, "Cadastrar Pedido",
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
		Integer id = loja.getIdPedido();
		String idPedido = id.toString();

		textFieldNumero = new JTextField();
		textFieldNumero.setText(idPedido);
		textFieldNumero.setEditable(false);
		add(textFieldNumero, "cell 1 1,growx");
		textFieldNumero.setColumns(10);

		lblCpfCliente = new JLabel("CPF Cliente:");
		add(lblCpfCliente, "cell 2 1,alignx right");

		textFieldCpfCliente = new JFormattedTextField(mascaraCpf);
		add(textFieldCpfCliente, "cell 3 1 2 1,growx");
		textFieldCpfCliente.setColumns(10);

		btnBuscaCliente = new JButton("Buscar");
		btnBuscaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					textFieldCpfCliente.commitEdit();

					String cpf = ((String) textFieldCpfCliente.getValue());
					System.out.println(textFieldCpfCliente.getValue());
					c = loja.consultarCliente(cpf);
					textFieldNome.setText(c.getNome());
					panelProdutos.setVisible(true);
					panelTransportadora.setVisible(true);
					comboBoxFormaPagamento.setEnabled(true);
					textFieldDataCompra.setEnabled(true);
				} catch (ParseException e2) {
					showMensagemErro("O CPF não foi preenchido");
				} catch (Exception e1) {
					showMensagemErro(e1.getMessage());
				}
			}
		});
		add(btnBuscaCliente, "cell 5 1,alignx center");

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
		panelProdutos.add(textFieldCodigoProduto, "cell 1 0,growx");
		textFieldCodigoProduto.setColumns(10);

		lblQuantidade = new JLabel("Quantidade:");
		panelProdutos.add(lblQuantidade, "cell 2 0,alignx right");

		textFieldQtdeProduto = new JTextField();
		panelProdutos.add(textFieldQtdeProduto, "cell 3 0,growx");
		textFieldQtdeProduto.setColumns(10);

		buttonAdicionarProduto = new JButton("+");
		buttonAdicionarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textFieldCodigoProduto.getText().isEmpty()) {
					Produto p;
					try {
						p = loja.consultarProduto(Integer
								.parseInt(textFieldCodigoProduto.getText()));
						int qtde = Integer.parseInt(textFieldQtdeProduto
								.getText());
						if (p.getQtdeEstoque() >= qtde) {
							produtosAdicionados++;
							TableModel model = (TableModel) table.getModel();
							model.addRow(new Object[] { p,
									textFieldQtdeProduto.getText() });
							Double valorTotal = Double
									.parseDouble(textFieldValorTotal.getText());
							valorTotal += (p.getValorUnitario() * qtde);
							produtos.put(p, qtde);
							textFieldValorTotal.setText(valorTotal.toString());
							textFieldCodigoProduto.setText("");
							textFieldQtdeProduto.setText("");
							btnRemoverProduto.setEnabled(true);
						} else {
							showMensagemErro("A quantidade desejada é maior que a quantidade em estoque. \nQuantidade em estoque atual: "
									+ p.getQtdeEstoque());
						}
					} catch (NumberFormatException nfe) {
						// Essa excecao so sera lancada para o parametro
						// quantidade
						showMensagemErro("Quantidade não informada ou o valor é inválido!");
					} catch (Exception e1) {
						showMensagemErro(e1.getMessage());
					}
				} else {
					showMensagemErro("Código Produto não informado!");
				}
			}
		});
		panelProdutos.add(buttonAdicionarProduto, "flowx,cell 4 0,alignx left");

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
		textFieldValorTotal.setText("0");
		textFieldValorTotal.setEditable(false);
		panelProdutos.add(textFieldValorTotal, "cell 4 4,growx");
		textFieldValorTotal.setColumns(10);

		btnRemoverProduto = new JButton("-");
		btnRemoverProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TableModel model = (TableModel) table.getModel();
				model.removeRow(produtosAdicionados - 1);
				produtosAdicionados--;
				if (model.getRowCount() == 0) {
					btnRemoverProduto.setEnabled(false);
				}
			}
		});
		btnRemoverProduto.setEnabled(false);
		panelProdutos.add(btnRemoverProduto, "cell 4 0");

		panelTransportadora = new JPanel();
		panelTransportadora.setBorder(new TitledBorder(null, "Transportadora",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panelTransportadora, "cell 0 5 6 1,grow");
		panelTransportadora.setLayout(new MigLayout("",
				"[][grow][grow][grow][][45.00,grow][67.00]", "[]"));
		panelTransportadora.setVisible(false);
		panelTransportadora.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				for (Transportadora trans : loja.getTransportadoras()) {
					comboBoxTransportadora.addItem(trans);
				}
			}
		});

		lblNomeTransportadora = new JLabel("Nome:");
		panelTransportadora.add(lblNomeTransportadora, "cell 0 0,alignx right");

		comboBoxTransportadora = new JComboBox<Transportadora>();
		comboBoxTransportadora
				.setRenderer(new ComboBoxTransportadoraRenderer());
		panelTransportadora.add(comboBoxTransportadora, "cell 1 0 3 1,growx");

		lblDataDeEntrega = new JLabel("Data de Entrega:");
		panelTransportadora.add(lblDataDeEntrega, "cell 4 0,alignx right");

		textFieldDataEntrega = new JFormattedTextField(mascaraData);
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
		add(textFieldDataCompra, "cell 4 7 2 1,growx");
		textFieldDataCompra.setColumns(10);
		textFieldDataCompra.setEnabled(false);

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

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTelaPrincipal();
			}
		});
		add(btnCancelar, "flowx,cell 0 9 6 1,alignx right");
		add(btnLimpar, "cell 0 9 6 1,alignx right");

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel.isVisible()) {
					Transportadora t = (Transportadora) comboBoxTransportadora
							.getSelectedItem();
					Endereco endereco = te.getEnderecoEntrega();
					if (endereco != null) {
						if (!produtos.isEmpty()) {
							double valorTotal = Double
									.parseDouble(textFieldValorTotal.getText());
							String formaPagamento = (String) comboBoxFormaPagamento
									.getSelectedItem();
							String dataCompra = textFieldDataCompra.getText();
							String dataEntrega = textFieldDataEntrega.getText();
							Calendar calDataCompra = Calendar.getInstance();
							Calendar calDataEntrega = Calendar.getInstance();
							try {
								SimpleDateFormat sdf = new SimpleDateFormat(
										"dd/MM/yyyy");
								calDataCompra.setTime(sdf.parse(dataCompra));
								calDataEntrega.setTime(sdf.parse(dataEntrega));

								loja.cadastrarPedido(valorTotal,
										formaPagamento, calDataCompra,
										calDataEntrega, endereco, c, produtos,
										t);

								showMensagemSucesso("Pedido cadastrado com sucesso!");
								showTelaPrincipal();
							} catch (ParseException ex) {
								showMensagemErro("Erro! Verifique os campos de data.");
							} catch (ParametroException exception) {
								showMensagemErro(exception.getMessage());
							}
						} else {
							showMensagemErro("Pedido sem produtos!");
						}
					} else {
						showMensagemErro("Endereço não cadastrado!");
					}
				}
			}

		});
		add(btnCadastrar, "cell 0 9 6 1,alignx right");
	}

	@Override
	public void limparCampos() {
		textFieldNome.setText("");
		textFieldCodigoProduto.setText("");
		textFieldCpfCliente.setText("");
		textFieldDataCompra.setText("");
		textFieldDataEntrega.setText("");
		textFieldNumero.setText("");
		textFieldQtdeProduto.setText("");
		textFieldValorTotal.setText("0");

		// Limpa tabela de produtos
		TableModel model = (TableModel) table.getModel();
		int rows = model.getRowCount();
		for (int i = rows - 1; i >= 0; i--) {
			model.removeRow(i);
		}

		panelProdutos.setVisible(false);
		panelTransportadora.setVisible(false);
		comboBoxFormaPagamento.setEnabled(false);
		textFieldDataCompra.setEnabled(false);
	}
}
