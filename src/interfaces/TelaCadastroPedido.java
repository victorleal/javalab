package interfaces;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import auxiliar.ComboBoxTransportadoraRenderer;
import auxiliar.TabelaPedidosCellRenderer;
import auxiliar.TableModel;
import core.Cliente;
import core.Endereco;
import core.Loja;
import core.Produto;
import core.Transportadora;

public class TelaCadastroPedido extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Labels
	private JLabel lblCadastrarPedido;
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
	private JTextField textFieldCpfCliente;
	private JTable table;
	private JTextField textFieldValorTotal;
	private JTextField textFieldNome;
	private JTextField textFieldDataCompra;
	private JTextField textFieldDataEntrega;

	// ComboBox
	private JComboBox<String> comboBoxFormaPagamento;
	private JComboBox<Transportadora> comboBoxTransportadora;

	// Buttons
	private JButton buttonAdicionarProduto;
	private JButton btnCancelar;
	private JButton btnCadastrar;
	private JButton btnBuscaCliente;
	private JButton btnAdicionarEndereco;

	// Controla o panel
	private JPanel panel;
	private JPanel panelProdutos;
	private JPanel panelTransportadora;

	// Controla a loja
	private Loja loja;

	// Controla cliente
	private Cliente c;

	// Controla TelaEnderecoEntrega
	private TelaEnderecoEntregaPedido te;

	/**
	 * Create the panel.
	 */
	public TelaCadastroPedido(Loja l) {
		panel = this;
		this.loja = l;
		te = new TelaEnderecoEntregaPedido();

		setLayout(new MigLayout("",
				"[][][][grow][grow][][grow][][45.00,grow][67.00]",
				"[][][][14.00][][][][][][]"));

		lblCadastrarPedido = new JLabel("Cadastrar Pedido");
		lblCadastrarPedido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblCadastrarPedido, "cell 0 0 10 1,alignx center");

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
		add(lblCpfCliente, "cell 4 1,alignx right");

		textFieldCpfCliente = new JTextField();
		add(textFieldCpfCliente, "cell 5 1 4 1,growx");
		textFieldCpfCliente.setColumns(10);

		btnBuscaCliente = new JButton("Buscar");
		btnBuscaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = textFieldCpfCliente.getText();
				c = loja.consultarCliente(cpf);
				if (c != null) {
					textFieldNome.setText(c.getNome());
					panelProdutos.setVisible(true);
					panelTransportadora.setVisible(true);
					comboBoxFormaPagamento.setEnabled(true);
					textFieldDataCompra.setEnabled(true);
					btnCadastrar.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(panel,
							"Cliente não encontrado", "Atenção",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		add(btnBuscaCliente, "cell 9 1,alignx center");

		lblNome = new JLabel("Nome:");
		add(lblNome, "cell 0 2,alignx right");

		textFieldNome = new JTextField();
		add(textFieldNome, "cell 1 2 8 1,growx");
		textFieldNome.setColumns(10);
		textFieldNome.setEditable(false);

		panelProdutos = new JPanel();
		panelProdutos.setBorder(new TitledBorder(null, "Produtos",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panelProdutos, "cell 0 3 10 2,grow");
		panelProdutos.setLayout(new MigLayout("",
				"[][grow][grow][grow][grow][grow][]", "[][][][][]"));
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
				Produto p = loja.consultarProduto(Integer
						.parseInt(textFieldCodigoProduto.getText()));
				TableModel model = (TableModel) table.getModel();
				model.addRow(new Object[] { p, textFieldQtdeProduto.getText() });
				Double valorTotal = Double.parseDouble(textFieldValorTotal
						.getText());
				double qtde = Double.parseDouble(textFieldQtdeProduto.getText());
				valorTotal += (p.getValorUnitario() * qtde);
				textFieldValorTotal.setText(valorTotal.toString());
				textFieldCodigoProduto.setText("");
				textFieldQtdeProduto.setText("");
			}
		});
		panelProdutos.add(buttonAdicionarProduto, "cell 4 0,growx");

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
		panelProdutos.add(textFieldValorTotal, "cell 4 4,growx");
		textFieldValorTotal.setColumns(10);

		panelTransportadora = new JPanel();
		panelTransportadora.setBorder(new TitledBorder(null, "Transportadora",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panelTransportadora, "cell 0 5 10 1,grow");
		panelTransportadora.setLayout(new MigLayout("",
				"[][grow][grow][grow][][45.00,grow][67.00]", "[]"));
		panelTransportadora.setVisible(false);

		lblNomeTransportadora = new JLabel("Nome:");
		panelTransportadora.add(lblNomeTransportadora, "cell 0 0,alignx right");

		comboBoxTransportadora = new JComboBox<Transportadora>();
		for (Transportadora trans : loja.getTransportadoras()) {
			comboBoxTransportadora.addItem(trans);
		}
		comboBoxTransportadora
				.setRenderer(new ComboBoxTransportadoraRenderer());
		panelTransportadora.add(comboBoxTransportadora, "cell 1 0 3 1,growx");

		lblDataDeEntrega = new JLabel("Data de Entrega:");
		panelTransportadora.add(lblDataDeEntrega, "cell 4 0,alignx right");

		textFieldDataEntrega = new JTextField();
		panelTransportadora.add(textFieldDataEntrega, "cell 5 0 2 1,growx");
		textFieldDataEntrega.setColumns(10);

		lblFormaDePagamento = new JLabel("Forma de Pagamento:");
		add(lblFormaDePagamento, "cell 0 7,alignx right");

		comboBoxFormaPagamento = new JComboBox<String>();
		comboBoxFormaPagamento.addItem("A vista");
		comboBoxFormaPagamento.addItem("Cartão Crédito");
		comboBoxFormaPagamento.addItem("Parcelamento");
		add(comboBoxFormaPagamento, "cell 1 7 4 1,growx");
		comboBoxFormaPagamento.setEnabled(false);

		lblDataDeCompra = new JLabel("Data de Compra:");
		add(lblDataDeCompra, "cell 5 7,alignx right");

		textFieldDataCompra = new JTextField();
		add(textFieldDataCompra, "cell 6 7 4 1,growx");
		textFieldDataCompra.setColumns(10);
		textFieldDataCompra.setEnabled(false);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container parent = panel.getParent();
				CardLayout cl = (CardLayout) parent.getLayout();
				cl.show(parent, "Inicial");
			}
		});

		btnAdicionarEndereco = new JButton("Adicionar Endereço Entrega");
		btnAdicionarEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container parent = panel.getParent();
				parent.add(te, "EnderecoEntrega");
				CardLayout cl = (CardLayout) parent.getLayout();
				cl.show(parent, "EnderecoEntrega");
			}
		});
		add(btnAdicionarEndereco, "cell 5 8 5 1,growx");
		add(btnCancelar, "cell 0 9 9 1,alignx right");

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel.isVisible()) {
					Transportadora t = (Transportadora) comboBoxTransportadora
							.getSelectedItem();
					Endereco endereco = te.getEnderecoEntrega();
					if (endereco == null) {
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
						} catch (ParseException ex) {
							ex.printStackTrace();
						}
						loja.cadastrarPedido(valorTotal, formaPagamento,
								calDataCompra, calDataEntrega, endereco, c,
								null, t);
					} else {
						JOptionPane.showMessageDialog(panel,
								"Nenhum endereço de entrega foi encontrado",
								"Atenção", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		add(btnCadastrar, "cell 9 9,alignx right");
	}

}
