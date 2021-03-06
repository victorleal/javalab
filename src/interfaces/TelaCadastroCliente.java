package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import net.miginfocom.swing.MigLayout;
import auxiliar.SelectListener;
import core.Endereco;
import core.Loja;
import exceptions.ParametroException;

public class TelaCadastroCliente extends GeneralPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private JFormattedTextField textFieldCpf;
	private JTextField textFieldEmail;
	private JFormattedTextField textFieldCelular;
	private JFormattedTextField textFieldTelefone;
	private JTextField textFieldNumero;
	private JTextField textFieldEndereco;
	private JTextField textFieldComplemento;
	private JTextField textFieldBairro;
	private JFormattedTextField textFieldCep;
	private JTextField textFieldPais;
	private JTextField textFieldCidade;
	private JTextField textFieldNumeroFidelidade;

	// ComboBox
	private JComboBox<String> comboBoxFidelidade;
	private JComboBox<String> comboBoxPrograma;
	private JComboBox<String> comboBoxEstado;

	// Buttons
	private JButton btnCancelar;
	private JButton btnCadastrar;
	private JButton btnLimpar;

	// Mascaras
	private MaskFormatter mascaraCpf;
	private MaskFormatter mascaraCelular;
	private MaskFormatter mascaraTelefone;
	private MaskFormatter mascaraCEP;

	/**
	 * Create the panel.
	 */
	public TelaCadastroCliente(Loja l) {
		super(l);

		setBorder(new TitledBorder(null, "Cadastrar Cliente",
				TitledBorder.LEADING, TitledBorder.TOP, this.fonte));
		setLayout(new MigLayout("",
				"[69.00][114.00,grow][][grow][][91.00,grow]",
				"[][][][][][][][grow,bottom]"));

		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setPlaceholderCharacter('_');
			mascaraCelular = new MaskFormatter("(##)#####-####");
			mascaraCelular.setPlaceholderCharacter('_');
			mascaraTelefone = new MaskFormatter("(##)####-####");
			mascaraTelefone.setPlaceholderCharacter('_');
			mascaraCEP = new MaskFormatter("#####-###");
			mascaraCEP.setPlaceholderCharacter('_');
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		lblNome = new JLabel("Nome:");
		add(lblNome, "cell 0 0,alignx right");

		textFieldNome = new JTextField();
		add(textFieldNome, "cell 1 0 5 1,growx");
		textFieldNome.setColumns(10);

		lblCpf = new JLabel("CPF:");
		add(lblCpf, "cell 0 1,alignx right");

		textFieldCpf = new JFormattedTextField(mascaraCpf);
		add(textFieldCpf, "cell 1 1,growx");
		textFieldCpf.setColumns(10);

		lblCelular = new JLabel("Celular:");
		add(lblCelular, "cell 2 1,alignx right");

		textFieldCelular = new JFormattedTextField(mascaraCelular);
		add(textFieldCelular, "cell 3 1,growx");
		textFieldCelular.setColumns(10);

		lblTelefone = new JLabel("Telefone:");
		add(lblTelefone, "cell 4 1,alignx right");

		textFieldTelefone = new JFormattedTextField(mascaraTelefone);
		add(textFieldTelefone, "cell 5 1,growx");
		textFieldTelefone.setColumns(10);

		lblEmail = new JLabel("Email:");
		add(lblEmail, "cell 0 2,alignx right");

		textFieldEmail = new JTextField();
		add(textFieldEmail, "cell 1 2 5 1,growx");
		textFieldEmail.setColumns(10);

		lblEndereco = new JLabel("Endere\u00E7o:");
		add(lblEndereco, "cell 0 3,alignx right");

		textFieldEndereco = new JTextField();
		add(textFieldEndereco, "cell 1 3 3 1,growx");
		textFieldEndereco.setColumns(10);

		lblNumero = new JLabel("N\u00FAmero:");
		add(lblNumero, "cell 4 3,alignx trailing");

		textFieldNumero = new JTextField();
		add(textFieldNumero, "cell 5 3,growx");
		textFieldNumero.setColumns(10);

		lblComplemento = new JLabel("Complemento:");
		add(lblComplemento, "cell 0 4,alignx right");

		textFieldComplemento = new JTextField();
		add(textFieldComplemento, "cell 1 4,growx");
		textFieldComplemento.setColumns(10);

		lblBairro = new JLabel("Bairro:");
		add(lblBairro, "cell 2 4,alignx trailing");

		textFieldBairro = new JTextField();
		add(textFieldBairro, "cell 3 4,growx");
		textFieldBairro.setColumns(10);

		lblCep = new JLabel("CEP:");
		add(lblCep, "cell 4 4,alignx trailing");

		textFieldCep = new JFormattedTextField(mascaraCEP);
		add(textFieldCep, "cell 5 4,growx");
		textFieldCep.setColumns(10);

		lblCidade = new JLabel("Cidade:");
		add(lblCidade, "cell 0 5,alignx right");

		textFieldCidade = new JFormattedTextField();
		add(textFieldCidade, "cell 1 5,growx");
		textFieldCidade.setColumns(10);

		lblEstado = new JLabel("Estado:");
		add(lblEstado, "cell 2 5,alignx trailing");

		comboBoxEstado = new JComboBox<String>(this.estados);
		comboBoxEstado.setEnabled(true);
		add(comboBoxEstado, "cell 3 5,growx");

		lblPais = new JLabel("País:");
		add(lblPais, "cell 4 5,alignx trailing");

		textFieldPais = new JTextField();
		add(textFieldPais, "cell 5 5,growx");
		textFieldPais.setColumns(10);

		lblClienteFidelidade = new JLabel("Cliente Fidelidade?");
		add(lblClienteFidelidade, "cell 0 6,alignx right");

		lblPrograma = new JLabel("Programa:");
		add(lblPrograma, "cell 2 6,alignx right");

		comboBoxPrograma = new JComboBox<String>();
		comboBoxPrograma.addItem("Gold");
		comboBoxPrograma.addItem("Platinium");
		comboBoxPrograma.addItem("Normal");
		comboBoxPrograma.setEnabled(false);
		add(comboBoxPrograma, "cell 3 6,growx");

		lblNumeroFidelidade = new JLabel("Número:");
		add(lblNumeroFidelidade, "cell 4 6,alignx right");

		textFieldNumeroFidelidade = new JTextField();
		textFieldNumeroFidelidade.setEnabled(false);
		add(textFieldNumeroFidelidade, "cell 5 6,growx");
		textFieldNumeroFidelidade.setColumns(10);

		comboBoxFidelidade = new JComboBox<String>();
		comboBoxFidelidade.addItem("Não");
		comboBoxFidelidade.addItem("Sim");
		ArrayList<JComponent> components = new ArrayList<JComponent>();
		components.add(comboBoxPrograma);
		components.add(textFieldNumeroFidelidade);
		comboBoxFidelidade
				.addItemListener(new SelectListener("Sim", components));
		add(comboBoxFidelidade, "cell 1 6,growx");

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTelaPrincipal();
			}
		});
		add(btnCancelar, "flowx,cell 0 7 6 1,alignx right");

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});
		add(btnLimpar, "cell 0 7 6 1,alignx right");

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldNome.getText();
				String cpf = (String)textFieldCpf.getValue();
				String email = textFieldEmail.getText();
				String telefone = ((String) textFieldTelefone.getText());
				String celular = ((String) textFieldCelular.getText());
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
				String estado = (String) comboBoxEstado.getSelectedItem();
				String pais = textFieldPais.getText();
				String complemento = textFieldComplemento.getText();
				String cep = ((String) textFieldCep.getText());
				Endereco endereco = null;

				try {
					endereco = new Endereco(rua, bairro, complemento, numero,
							cep, cidade, estado, pais);
					loja.cadastrarCliente(nome, cpf, email, telefone, celular,
							isClienteFidelidade, programaFidelidade,
							numeroFidelidade, endereco);
					showMensagemSucesso("Cliente cadastrado com sucesso!");
					showTelaPrincipal();
				} catch (ParametroException exception) {
					showMensagemErro(exception.getMessage());
				}
			}
		});
		add(btnCadastrar, "cell 0 7 6 1,alignx right");
	}

	@Override
	public void limparCampos() {
		textFieldNome.setText("");
		textFieldCpf.setText("");
		textFieldEmail.setText("");
		textFieldTelefone.setText("");
		textFieldCelular.setText("");
		textFieldEndereco.setText("");
		textFieldBairro.setText("");
		textFieldNumero.setText("");
		textFieldBairro.setText("");
		// comboBoxEstado.setSelectedItem(");
		textFieldPais.setText("");
		textFieldComplemento.setText("");
		textFieldCep.setText("");
	}
}
