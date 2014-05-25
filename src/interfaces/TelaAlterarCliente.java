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
import core.Cliente;
import core.Endereco;
import core.Loja;
import exceptions.ParametroException;

public class TelaAlterarCliente extends GeneralPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// textField
	private JTextField textFieldNome;
	private JFormattedTextField textFieldCPF;
	private JFormattedTextField textFieldCelular;
	private JTextField textFieldEndNum;
	private JTextField textFieldEndereco;
	private JTextField textFieldComplemento;
	private JTextField textFieldBairro;
	private JFormattedTextField textFieldCep;
	private JTextField textFieldPais;
	//private JTextField textFieldEstado;
	private JTextField textFieldCidade;
	private JFormattedTextField textFieldTelefone;
	private JTextField textFieldEmail;
	private JTextField textFieldNumeroFidelidade;

	// Buttons
	private JButton btnCancelar;
	private JButton btnSalvar;

	// Labels
	private JLabel lblNome;
	private JLabel lblCelular;
	private JLabel lblTelefone;
	private JLabel lblBairro;
	private JLabel lblEndereo;
	private JLabel lblNmero;
	private JLabel lblCep;
	private JLabel lblClienteFidelidade;
	private JLabel lblPrograma;
	private JLabel lblPas;
	private JLabel lblComplemento;
	private JLabel lblEstado;
	private JLabel lblCidade;
	private JLabel lblEmail;
	private JLabel lblCpf;
	
	// Mascaras
	private MaskFormatter mascaraCpf;
	private MaskFormatter mascaraCelular;
	private MaskFormatter mascaraTelefone;
	private MaskFormatter mascaraCEP;

	// ComboBox
	private JComboBox<String> comboBoxFidelidade;
	private JComboBox<String> comboBoxPrograma;
	private JComboBox<String> comboBoxEstado;
	

	/**
	 * Create the panel.
	 */
	public TelaAlterarCliente(Loja l) {
		super(l);
		Cliente c = loja.getClienteAlteracao();

		setBorder(new TitledBorder(null, "Alterar Cliente",
				TitledBorder.LEADING, TitledBorder.TOP, this.fonte));

		setLayout(new MigLayout("",
				"[55.00][114.00,grow][][pref!,grow][][91.00,grow]",
				"[][][][][][][grow,bottom]"));
		
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
		textFieldNome.setText(c.getNome());
		add(textFieldNome, "cell 1 0 3 1,growx");
		textFieldNome.setColumns(10);

		lblCpf = new JLabel("CPF:");
		add(lblCpf, "cell 4 0,alignx trailing");

		textFieldCPF = new JFormattedTextField(mascaraCpf);
		textFieldCPF.setText(c.getCpf());
		textFieldCPF.setEditable(false);
		add(textFieldCPF, "cell 5 0,growx");
		textFieldCPF.setColumns(10);

		lblCelular = new JLabel("Celular:");
		add(lblCelular, "cell 0 1,alignx right");

		textFieldCelular = new JFormattedTextField(mascaraCelular);
		textFieldCelular.setText(c.getCelular());
		add(textFieldCelular, "cell 1 1,growx");
		textFieldCelular.setColumns(10);

		lblTelefone = new JLabel("Telefone:");
		add(lblTelefone, "cell 2 1,alignx trailing");

		textFieldTelefone = new JFormattedTextField(mascaraTelefone);
		textFieldTelefone.setText(c.getTelefone());
		add(textFieldTelefone, "cell 3 1,growx");
		textFieldTelefone.setColumns(10);

		lblEmail = new JLabel("Email:");
		add(lblEmail, "cell 4 1,alignx trailing");

		textFieldEmail = new JTextField();
		textFieldEmail.setText(c.getEmail());
		add(textFieldEmail, "cell 5 1,growx");
		textFieldEmail.setColumns(10);

		lblEndereo = new JLabel("Endere\u00E7o:");
		add(lblEndereo, "cell 0 2,alignx trailing");

		textFieldEndereco = new JTextField();
		textFieldEndereco.setText(c.getEndereco().getRua());
		add(textFieldEndereco, "cell 1 2 3 1,growx");
		textFieldEndereco.setColumns(10);

		lblNmero = new JLabel("Número:");
		add(lblNmero, "cell 4 2,alignx trailing");

		textFieldEndNum = new JTextField();
		textFieldEndNum.setText(c.getEndereco().getNumero());
		add(textFieldEndNum, "cell 5 2,growx");
		textFieldEndNum.setColumns(10);

		lblComplemento = new JLabel("Complemento:");
		add(lblComplemento, "cell 0 3,alignx trailing");

		textFieldComplemento = new JTextField();
		textFieldComplemento.setText(c.getEndereco().getComplemento());
		add(textFieldComplemento, "cell 1 3,growx");
		textFieldComplemento.setColumns(10);

		lblBairro = new JLabel("Bairro:");
		add(lblBairro, "cell 2 3,alignx trailing");

		textFieldBairro = new JTextField();
		textFieldBairro.setText(c.getEndereco().getBairro());
		add(textFieldBairro, "cell 3 3,growx");
		textFieldBairro.setColumns(10);

		lblCep = new JLabel("CEP:");
		add(lblCep, "cell 4 3,alignx trailing");

		textFieldCep = new JFormattedTextField(mascaraCEP);
		textFieldCep.setText(c.getEndereco().getCep());
		add(textFieldCep, "cell 5 3,growx");
		textFieldCep.setColumns(10);

		lblCidade = new JLabel("Cidade:");
		add(lblCidade, "cell 0 4,alignx trailing");

		textFieldCidade = new JTextField();
		textFieldCidade.setText(c.getEndereco().getCidade());
		add(textFieldCidade, "cell 1 4,growx");
		textFieldCidade.setColumns(10);

		lblEstado = new JLabel("Estado:");
		add(lblEstado, "cell 2 4,alignx trailing");

		comboBoxEstado = new JComboBox<String>(this.estados);
		comboBoxEstado.setEnabled(true);
		comboBoxEstado.setSelectedItem(c.getEndereco().getEstado());
		add(comboBoxEstado, "cell 3 4,growx");

		lblPas = new JLabel("País:");
		add(lblPas, "cell 4 4,alignx trailing");

		textFieldPais = new JTextField();
		textFieldPais.setText(c.getEndereco().getPais());
		add(textFieldPais, "cell 5 4,growx");
		textFieldPais.setColumns(10);

		lblClienteFidelidade = new JLabel("Cliente Fidelidade?");
		add(lblClienteFidelidade, "cell 0 5,alignx right");

		lblPrograma = new JLabel("Programa:");
		add(lblPrograma, "cell 2 5,alignx right");

		comboBoxPrograma = new JComboBox<String>();
		for (String p : loja.getProgramaFidelidade()) {
			comboBoxPrograma.addItem(p);
		}
		if (c.getProgramaFidelidade() != null) {
			comboBoxPrograma.setSelectedItem(c.getProgramaFidelidade());
		}
		comboBoxPrograma.setEnabled(false);
		add(comboBoxPrograma, "cell 3 5,growx");

		JLabel lblNmero_1 = new JLabel("Número:");
		add(lblNmero_1, "cell 4 5,alignx right");

		textFieldNumeroFidelidade = new JTextField();
		textFieldNumeroFidelidade.setText(c.getNumeroFidelidade());
		add(textFieldNumeroFidelidade, "cell 5 5,growx");
		textFieldNumeroFidelidade.setColumns(10);

		comboBoxFidelidade = new JComboBox<String>();
		comboBoxFidelidade.addItem("Não");
		comboBoxFidelidade.addItem("Sim");
		ArrayList<JComponent> components = new ArrayList<JComponent>();
		components.add(comboBoxPrograma);
		components.add(textFieldNumeroFidelidade);
		comboBoxFidelidade
				.addItemListener(new SelectListener("Sim", components));
		if (c.getIsClienteFidelidade() == true) {
			comboBoxFidelidade.setSelectedItem("Sim");
		} else {
			comboBoxFidelidade.setSelectedItem("Não");
		}
		add(comboBoxFidelidade, "cell 1 5,growx");

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTela("ConsultarCliente");
			}
		});
		add(btnCancelar, "flowx,cell 0 6 6 1,alignx right");

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldNome.getText();
				String cpf = textFieldCPF.getText();
				String email = textFieldEmail.getText();
				String telefone = textFieldTelefone.getText();
				String celular = textFieldCelular.getText();
				String clienteFidelidade = (String) comboBoxFidelidade
						.getSelectedItem();
				boolean isClienteFidelidade = false;
				if (clienteFidelidade.equals("Sim")) {
					isClienteFidelidade = true;
				}
				String programaFidelidade = (String) comboBoxPrograma
						.getSelectedItem();
				System.out.println(programaFidelidade);
				String numeroFidelidade = textFieldNumeroFidelidade.getText();

				// Endereco
				String rua = textFieldEndereco.getText();
				String bairro = textFieldBairro.getText();
				String numero = textFieldEndNum.getText();
				String cidade = textFieldBairro.getText();
				String estado = (String) comboBoxEstado.getSelectedItem();
				String pais = textFieldPais.getText();
				String complemento = textFieldComplemento.getText();
				String cep = textFieldCep.getText();
				Endereco endereco = null;
				try {
					endereco = new Endereco(rua, bairro, complemento,
							numero, cep, cidade, estado, pais);
		
					loja.alterarCliente(nome, cpf, email, telefone, celular,
							isClienteFidelidade, programaFidelidade,
							numeroFidelidade, endereco);
					
					showMensagemSucesso("Cliente alterado com sucesso");
					//showTelaPrincipal();
					showTela("ConsultarCliente");
				} catch (ParametroException exception) {
					showMensagemErro(exception.getMessage());
				}
			}
		});
		add(btnSalvar, "cell 0 6 6 1,alignx right");
	}

	@Override
	public void limparCampos() {
		// TODO Auto-generated method stub

	}
}
