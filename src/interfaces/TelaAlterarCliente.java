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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import auxiliar.SelectListener;
import net.miginfocom.swing.MigLayout;
import core.Cliente;
import core.Endereco;
import core.Loja;

public class TelaAlterarCliente extends GeneralPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//textField
	private JTextField textFieldNome;
	private JTextField textFieldCelular;
	private JTextField textFieldEndNum;
	private JTextField textFieldEndereco;
	private JTextField textFieldComplemento;
	private JTextField textFieldBairro;
	private JTextField textFieldCep;
	private JTextField textFieldPais;
	private JTextField textFieldEstado;
	private JTextField textFieldCidade;
	private JTextField textFieldTelefone;
	private JTextField textFieldEmail;
	private JTextField textFieldNumeroFidelidade;
	
	//Buttons
	private JButton btnCancelar;
	private JButton btnSalvar;
	
	//Labels
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

	// ComboBox
	private JComboBox<String> comboBoxFidelidade;
	private JComboBox<Integer> comboBoxPrograma;


	/**
	 * Create the panel.
	 */
	public TelaAlterarCliente(Loja l) {
		super(l);
		Cliente c = loja.getClienteAlteracao();
		
		setBorder(new TitledBorder(null, "Alterar Cliente", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma",
				Font.PLAIN, 16)));
		
setLayout(new MigLayout("", "[55.00,grow][114.00,grow][][pref!,grow][][91.00,grow]", "[][][][][][][grow,bottom]"));
		
		lblNome = new JLabel("Nome:");
		add(lblNome, "cell 0 0,alignx right");
		
		textFieldNome = new JTextField();
		textFieldNome.setText(c.getNome());
		add(textFieldNome, "cell 1 0 5 1,growx");
		textFieldNome.setColumns(10);
		
		lblCelular = new JLabel("Celular:");
		add(lblCelular, "cell 0 1,alignx right");
		
		textFieldCelular = new JTextField();
		textFieldCelular.setText(c.getCelular());
		add(textFieldCelular, "cell 1 1,growx");
		textFieldCelular.setColumns(10);
		
		lblTelefone  = new JLabel("Telefone:");
		add(lblTelefone, "cell 2 1,alignx trailing");
		
		textFieldTelefone = new JTextField();
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
		
		textFieldCep = new JTextField();
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
		
		textFieldEstado = new JTextField();
		textFieldEstado.setText(c.getEndereco().getEstado());
		add(textFieldEstado, "cell 3 4,growx");
		textFieldEstado.setColumns(10);
		
		lblPas = new JLabel("País:");
		add(lblPas, "cell 4 4,alignx trailing");
		
		textFieldPais = new JTextField();
		textFieldPais.setText(c.getEndereco().getPais());
		add(textFieldPais, "cell 5 4,growx");
		textFieldPais.setColumns(10);
		
		lblClienteFidelidade = new JLabel("Cliente Fidelidade?");
		add(lblClienteFidelidade, "cell 0 5,alignx right");
		
		comboBoxFidelidade = new JComboBox<String>();
		comboBoxFidelidade.addItem("Não");
		comboBoxFidelidade.addItem("Sim");
		ArrayList<JComponent> components = new ArrayList<JComponent>();
		components.add(comboBoxPrograma);
		components.add(textFieldNumeroFidelidade);
		comboBoxFidelidade
				.addItemListener(new SelectListener("Sim", components));
		add(comboBoxFidelidade, "cell 1 5,growx");
		
		lblPrograma = new JLabel("Programa:");
		add(lblPrograma, "cell 2 5,alignx right");
		
		comboBoxPrograma = new JComboBox<Integer>();
		comboBoxPrograma.setEnabled(false);
		add(comboBoxPrograma, "cell 3 5,growx");
		
		JLabel lblNmero_1 = new JLabel("Número:");
		add(lblNmero_1, "cell 4 5,alignx right");
		
		textFieldNumeroFidelidade = new JTextField();
		textFieldNumeroFidelidade.setText(c.getNumeroFidelidade());
		add(textFieldNumeroFidelidade, "cell 5 5,growx");
		textFieldNumeroFidelidade.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTelaPrincipal(true);
			}
		});
		add(btnCancelar, "flowx,cell 0 6 6 1,alignx right");
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String nome = textFieldNome.getText();
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
					String numero = textFieldEndNum.getText();
					String cidade = textFieldBairro.getText();
					String estado = textFieldEstado.getText();
					String pais = textFieldPais.getText();
					String complemento = textFieldComplemento.getText();
					String cep = textFieldCep.getText();
					Endereco endereco = new Endereco(rua, bairro, complemento,
							numero, cep, cidade, estado, pais);

					loja.cadastrarCliente(nome, null, email, telefone, celular,
							isClienteFidelidade, programaFidelidade,
							numeroFidelidade, endereco);

					JOptionPane.showMessageDialog(panel,
							"Cliente alterado com sucesso!", "Sucesso",
							JOptionPane.INFORMATION_MESSAGE);
					showTelaPrincipal(true);
			}
		});
		add(btnSalvar, "cell 0 6 6 1,alignx right");
		}


		@Override
		public void limparCampos() {
			// TODO Auto-generated method stub
			
		}
}
