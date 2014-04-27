package interfaces;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listeners.SelectListener;
import net.miginfocom.swing.MigLayout;
import core.Endereco;
import core.Loja;

public class TelaCadastroCliente extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Labels
	private JLabel lblCadastrarCliente;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JLabel lblCelular;
	private JLabel lblTelefone;
	private JLabel lblEmail;
	private JLabel lblEndereco;
	private JLabel lblNumero;
	private JLabel lblComplemento;
	private JLabel lblBairro;
	private JLabel lblCep;
	private JLabel lblCidade;
	private JLabel lblEstado;
	private JLabel lblPais;
	private JLabel lblClienteFidelidade;
	private JLabel lblPrograma;
	private JLabel lblNumeroFidelidade;

	// TextFields
	private JTextField textFieldNome;
	private JTextField textFieldCpf;
	private JTextField textFieldEmail;
	private JTextField textFieldCelular;
	private JTextField textFieldTelefone;
	private JTextField textFieldNumero;
	private JTextField textFieldEndereco;
	private JTextField textFieldComplemento;
	private JTextField textFieldBairro;
	private JTextField textFieldCep;
	private JTextField textFieldPais;
	private JTextField textFieldEstado;
	private JTextField textFieldCidade;
	private JTextField textFieldNumeroFidelidade;

	// ComboBox
	private JComboBox<String> comboBoxFidelidade;
	private JComboBox<Integer> comboBoxPrograma;

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
	public TelaCadastroCliente(Loja l) {
		panel = this;
		this.loja = l      ;

		setLayout(new MigLayout("",
				"[69.00][114.00,grow][][grow][][91.00,grow]",
				"[][30.00][][][][][][][][43.00][]"));

		lblCadastrarCliente = new JLabel("Cadastrar Cliente");
		lblCadastrarCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblCadastrarCliente, "cell 0 0 6 1,alignx center");

		lblNome = new JLabel("Nome:");
		add(lblNome, "cell 0 2,alignx left");

		textFieldNome = new JTextField();
		add(textFieldNome, "cell 1 2 3 1,growx");
		textFieldNome.setColumns(10);

		lblCpf = new JLabel("CPF:");
		add(lblCpf, "cell 0 3,alignx left");

		textFieldCpf = new JTextField();
		add(textFieldCpf, "cell 1 3,growx");
		textFieldCpf.setColumns(10);

		lblCelular = new JLabel("Celular:");
		add(lblCelular, "cell 2 3,alignx right");

		textFieldCelular = new JTextField();
		add(textFieldCelular, "cell 3 3,growx");
		textFieldCelular.setColumns(10);

		lblTelefone = new JLabel("Telefone:");
		add(lblTelefone, "cell 4 3,alignx right");

		textFieldTelefone = new JTextField();
		add(textFieldTelefone, "cell 5 3,growx");
		textFieldTelefone.setColumns(10);

		lblEmail = new JLabel("Email:");
		add(lblEmail, "cell 0 4,alignx left");

		textFieldEmail = new JTextField();
		add(textFieldEmail, "cell 1 4 3 1,growx");
		textFieldEmail.setColumns(10);

		lblEndereco = new JLabel("Endere\u00E7o:");
		add(lblEndereco, "cell 0 5,alignx left");

		textFieldEndereco = new JTextField();
		add(textFieldEndereco, "cell 1 5 3 1,growx");
		textFieldEndereco.setColumns(10);

		lblNumero = new JLabel("N\u00FAmero:");
		add(lblNumero, "cell 4 5,alignx trailing");

		textFieldNumero = new JTextField();
		add(textFieldNumero, "cell 5 5,growx");
		textFieldNumero.setColumns(10);

		lblComplemento = new JLabel("Complemento:");
		add(lblComplemento, "cell 0 6,alignx left");

		textFieldComplemento = new JTextField();
		add(textFieldComplemento, "cell 1 6,growx");
		textFieldComplemento.setColumns(10);

		lblBairro = new JLabel("Bairro:");
		add(lblBairro, "cell 2 6,alignx trailing");

		textFieldBairro = new JTextField();
		add(textFieldBairro, "cell 3 6,growx");
		textFieldBairro.setColumns(10);

		lblCep = new JLabel("CEP:");
		add(lblCep, "cell 4 6,alignx trailing");

		textFieldCep = new JTextField();
		add(textFieldCep, "cell 5 6,growx");
		textFieldCep.setColumns(10);

		lblCidade = new JLabel("Cidade:");
		add(lblCidade, "cell 0 7,alignx left");

		textFieldCidade = new JTextField();
		add(textFieldCidade, "cell 1 7,growx");
		textFieldCidade.setColumns(10);

		lblEstado = new JLabel("Estado:");
		add(lblEstado, "cell 2 7,alignx trailing");

		textFieldEstado = new JTextField();
		add(textFieldEstado, "cell 3 7,growx");
		textFieldEstado.setColumns(10);

		lblPais = new JLabel("País:");
		add(lblPais, "cell 4 7,alignx trailing");

		textFieldPais = new JTextField();
		add(textFieldPais, "cell 5 7,growx");
		textFieldPais.setColumns(10);

		lblClienteFidelidade = new JLabel("Cliente Fidelidade?");
		add(lblClienteFidelidade, "cell 0 8,alignx left");

		lblPrograma = new JLabel("Programa:");
		add(lblPrograma, "cell 2 8,alignx right");

		comboBoxPrograma = new JComboBox<Integer>();
		comboBoxPrograma.setEnabled(false);
		add(comboBoxPrograma, "cell 3 8,growx");

		lblNumeroFidelidade = new JLabel("Número:");
		add(lblNumeroFidelidade, "cell 4 8,alignx right");

		textFieldNumeroFidelidade = new JTextField();
		textFieldNumeroFidelidade.setEnabled(false);
		add(textFieldNumeroFidelidade, "cell 5 8,growx");
		textFieldNumeroFidelidade.setColumns(10);

		comboBoxFidelidade = new JComboBox<String>();
		comboBoxFidelidade.addItem("Não");
		comboBoxFidelidade.addItem("Sim");
		ArrayList<JComponent> components = new ArrayList<JComponent>();
		components.add(comboBoxPrograma);
		components.add(textFieldNumeroFidelidade);
		comboBoxFidelidade
				.addItemListener(new SelectListener("Sim", components));
		add(comboBoxFidelidade, "cell 1 8,growx");

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container parent = panel.getParent();
				CardLayout cl = (CardLayout) parent.getLayout();
				cl.show(parent, "Inicial");
			}
		});
		add(btnCancelar, "flowx,cell 0 10 6 1,alignx right");

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldNome.getText();
				String cpf = textFieldCpf.getText();
				String email = textFieldEmail.getText();
				String telefone = textFieldTelefone.getText();
				String celular = textFieldCelular.getText();
				String clienteFidelidade = (String) comboBoxFidelidade
						.getSelectedItem();
				boolean isClienteFidelidade = false;
				if (clienteFidelidade.equals("Sim")) {
					isClienteFidelidade = true;
				}
				String programaFidelidade = (String) comboBoxFidelidade
						.getSelectedItem();
				String numeroFidelidade = textFieldNumeroFidelidade.getText();

				// Endereco
				String rua = textFieldEndereco.getText();
				String bairro = textFieldBairro.getText();
				String numero = textFieldNumero.getText();
				String cidade = textFieldBairro.getText();
				String estado = textFieldEstado.getText();
				String pais = textFieldPais.getText();
				String complemento = textFieldComplemento.getText();
				String cep = textFieldCep.getText();
				Endereco endereco = new Endereco(rua, bairro, complemento,
						numero, cep, cidade, estado, pais);

				loja.cadastrarCliente(nome, cpf, email, telefone, celular,
						isClienteFidelidade, programaFidelidade,
						numeroFidelidade, endereco);
			}
		});
		add(btnCadastrar, "cell 0 10 6 1,alignx right");
	}
}
