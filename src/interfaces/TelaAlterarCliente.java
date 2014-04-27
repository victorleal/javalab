package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import core.Loja;

public class TelaAlterarCliente extends JPanel {

	private JTextField textField;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_2;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public TelaAlterarCliente(Loja loja) {

		setLayout(new MigLayout("",
				"[55.00,grow][114.00,grow][][pref!][][91.00,grow]",
				"[][][][][][][][][][]"));

		JLabel lblAlterarCliente = new JLabel("Alterar Cliente");
		add(lblAlterarCliente, "cell 0 0 6 1,alignx center");

		JLabel lblNome = new JLabel("Nome:");
		add(lblNome, "cell 0 2,alignx right");

		textField = new JTextField();
		add(textField, "cell 1 2 5 1,growx");
		textField.setColumns(10);

		JLabel lblCelular = new JLabel("Celular:");
		add(lblCelular, "cell 0 3,alignx right");

		textField_4 = new JTextField();
		add(textField_4, "cell 1 3,growx");
		textField_4.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		add(lblTelefone, "cell 2 3,alignx right");

		textField_5 = new JTextField();
		add(textField_5, "cell 3 3,growx");
		textField_5.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		add(lblEmail, "cell 4 3,alignx trailing");

		textField_1 = new JTextField();
		add(textField_1, "cell 5 3,growx");
		textField_1.setColumns(10);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		add(lblEndereo, "cell 0 4,alignx trailing");

		textField_6 = new JTextField();
		add(textField_6, "cell 1 4 3 1,growx");
		textField_6.setColumns(10);

		JLabel lblNmero = new JLabel("Número:");
		add(lblNmero, "cell 4 4,alignx trailing");

		textField_2 = new JTextField();
		add(textField_2, "cell 5 4,growx");
		textField_2.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento:");
		add(lblComplemento, "cell 0 5,alignx trailing");

		textField_7 = new JTextField();
		add(textField_7, "cell 1 5,growx");
		textField_7.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		add(lblBairro, "cell 2 5,alignx trailing");

		textField_8 = new JTextField();
		add(textField_8, "cell 3 5,growx");
		textField_8.setColumns(10);

		JLabel lblCep = new JLabel("CEP:");
		add(lblCep, "cell 4 5,alignx trailing");

		textField_9 = new JTextField();
		add(textField_9, "cell 5 5,growx");
		textField_9.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		add(lblCidade, "cell 0 6,alignx trailing");

		textField_12 = new JTextField();
		add(textField_12, "cell 1 6,growx");
		textField_12.setColumns(10);

		JLabel lblEstado = new JLabel("Estado:");
		add(lblEstado, "cell 2 6,alignx trailing");

		textField_11 = new JTextField();
		add(textField_11, "cell 3 6,growx");
		textField_11.setColumns(10);

		JLabel lblPas = new JLabel("País:");
		add(lblPas, "cell 4 6,alignx trailing");

		textField_10 = new JTextField();
		add(textField_10, "cell 5 6,growx");
		textField_10.setColumns(10);

		JLabel lblClienteFidelidade = new JLabel("Cliente Fidelidade?");
		add(lblClienteFidelidade, "cell 0 7,alignx right");

		JComboBox comboBox = new JComboBox();
		add(comboBox, "cell 1 7,growx");

		JLabel lblPrograma = new JLabel("Programa:");
		add(lblPrograma, "cell 2 7,alignx right");

		JComboBox comboBox_1 = new JComboBox();
		add(comboBox_1, "cell 3 7,growx");

		JLabel lblNmero_1 = new JLabel("Número:");
		add(lblNmero_1, "cell 4 7,alignx right");

		textField_13 = new JTextField();
		add(textField_13, "cell 5 7,growx");
		textField_13.setColumns(10);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnCancelar, "flowx,cell 0 9 6 1,alignx right");

		JButton btnCadastrar = new JButton("Cadastrar");
		add(btnCadastrar, "cell 0 9 6 1,alignx right");

	}

}
