package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import core.Loja;

public class TelaCadastroPedido extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Create the panel.
	 */
	public TelaCadastroPedido(Loja loja) {
		setLayout(new MigLayout("", "[][grow][grow][grow][grow][grow]", "[][][][][][][24.00,grow][][][][][]"));
		
		JLabel lblCadastrarPedido = new JLabel("Cadastrar Pedido");
		add(lblCadastrarPedido, "cell 0 0 5 1,alignx center");
		
		JLabel lblNmero = new JLabel("Número:");
		add(lblNmero, "cell 0 2,alignx right");
		
		textField_2 = new JTextField();
		add(textField_2, "cell 1 2,growx");
		textField_2.setColumns(10);
		
		JLabel lblCpfCliente = new JLabel("CPF Cliente:");
		add(lblCpfCliente, "cell 2 2,alignx right");
		
		textField_3 = new JTextField();
		add(textField_3, "cell 3 2 2 1,growx");
		textField_3.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		add(lblNome, "cell 0 3,alignx right");
		
		textField_5 = new JTextField();
		add(textField_5, "cell 1 3 4 1,growx");
		textField_5.setColumns(10);
		
		JLabel lblProduto = new JLabel("Produto");
		add(lblProduto, "cell 0 4 6 1,alignx center");
		
		JLabel lblCdigoProduto = new JLabel("Código Produto:");
		add(lblCdigoProduto, "cell 0 5,alignx right");
		
		textField = new JTextField();
		add(textField, "cell 1 5,growx");
		textField.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		add(lblQuantidade, "cell 2 5,alignx right");
		
		textField_1 = new JTextField();
		add(textField_1, "cell 3 5,growx");
		textField_1.setColumns(10);
		
		JButton button = new JButton("+");
		add(button, "cell 4 5,growx");
		
		table = new JTable();
		add(table, "cell 1 6 4 1,grow");
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		add(lblValorTotal, "cell 3 7,alignx right");
		
		textField_4 = new JTextField();
		add(textField_4, "cell 4 7,growx");
		textField_4.setColumns(10);
		
		JLabel lblFormaDePagamento = new JLabel("Forma de Pagamento");
		add(lblFormaDePagamento, "cell 0 8,alignx right");
		
		JComboBox comboBox = new JComboBox();
		add(comboBox, "cell 1 8,growx");
		
		JLabel lblDataDeCompra = new JLabel("Data de Compra:");
		add(lblDataDeCompra, "cell 3 8,alignx right");
		
		textField_6 = new JTextField();
		add(textField_6, "cell 4 8,growx");
		textField_6.setColumns(10);
		
		JLabel lblTransportadora = new JLabel("Transportadora");
		add(lblTransportadora, "cell 0 9 6 1,alignx center");
		
		JLabel lblNome_1 = new JLabel("Nome:");
		add(lblNome_1, "cell 0 10,alignx right");
		
		JComboBox comboBox_1 = new JComboBox();
		add(comboBox_1, "cell 1 10,growx");
		
		JLabel lblDataDeEntrega = new JLabel("Data de Entrega:");
		add(lblDataDeEntrega, "cell 3 10,alignx right");
		
		textField_7 = new JTextField();
		add(textField_7, "cell 4 10,growx");
		textField_7.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnCancelar, "flowx,cell 0 11 5 1,alignx right");
		
		JButton btnCadastrar = new JButton("Cadastrar");
		add(btnCadastrar, "cell 0 11 5 1,alignx right");
		
		

	}

}
