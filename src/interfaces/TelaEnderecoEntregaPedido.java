package interfaces;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import core.Endereco;

public class TelaEnderecoEntregaPedido extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldRua;
	private JTextField textFieldNumero;
	private JTextField textFieldBairro;
	private JTextField textFieldCidade;
	private JTextField textFieldEstado;
	private JTextField textFieldPais;
	private JTextField textFieldComplemento;
	private JTextField textFieldCep;

	// Controla o panel
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public TelaEnderecoEntregaPedido() {
		panel = this;
		
		setLayout(new MigLayout("", "[45.00][222.00,grow][63.00][grow]",
				"[][][][][][][][][][]"));

		JLabel lblEndereoEntrega = new JLabel("Endere\u00E7o Entrega");
		lblEndereoEntrega.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblEndereoEntrega, "cell 0 0 4 1,alignx center");

		JLabel lblRua = new JLabel("Rua:");
		add(lblRua, "cell 0 2,alignx trailing");

		textFieldRua = new JTextField();
		add(textFieldRua, "cell 1 2,growx");
		textFieldRua.setColumns(10);

		JLabel lblNumero = new JLabel("N\u00FAmero:");
		add(lblNumero, "cell 2 2,alignx trailing");

		textFieldNumero = new JTextField();
		add(textFieldNumero, "cell 3 2,growx");
		textFieldNumero.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		add(lblBairro, "cell 0 3,alignx trailing");

		textFieldBairro = new JTextField();
		add(textFieldBairro, "cell 1 3,growx");
		textFieldBairro.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		add(lblCidade, "cell 0 4,alignx trailing");

		textFieldCidade = new JTextField();
		add(textFieldCidade, "cell 1 4,growx");
		textFieldCidade.setColumns(10);

		JLabel lblEstado = new JLabel("Estado:");
		add(lblEstado, "cell 2 4,alignx trailing");

		textFieldEstado = new JTextField();
		add(textFieldEstado, "cell 3 4,growx");
		textFieldEstado.setColumns(10);

		JLabel lblPas = new JLabel("Pa\u00EDs:");
		add(lblPas, "cell 0 5,alignx trailing");

		textFieldPais = new JTextField();
		add(textFieldPais, "cell 1 5,growx");
		textFieldPais.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento:");
		add(lblComplemento, "cell 0 6,alignx trailing");

		textFieldComplemento = new JTextField();
		add(textFieldComplemento, "cell 1 6,growx");
		textFieldComplemento.setColumns(10);

		JLabel lblCep = new JLabel("CEP:");
		add(lblCep, "cell 2 6,alignx trailing");

		textFieldCep = new JTextField();
		add(textFieldCep, "cell 3 6,growx");
		textFieldCep.setColumns(10);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container parent = panel.getParent();
				CardLayout cl = (CardLayout) parent.getLayout();
				cl.show(parent, "CadastrarPedido");
			}
		});
		add(btnOk, "cell 3 9,growx");

	}

	public Endereco getEnderecoEntrega() {
		String rua = textFieldRua.getText();
		String numero = textFieldNumero.getText();
		String bairro = textFieldBairro.getText();
		String complemento = textFieldComplemento.getText();
		String cidade = textFieldCidade.getText();
		String estado = textFieldEstado.getText();
		String pais = textFieldPais.getText();
		String cep = textFieldCep.getText();
		Endereco e = new Endereco(rua, bairro, complemento, numero, cep,
				cidade, estado, pais);
		return e;
	}

}
