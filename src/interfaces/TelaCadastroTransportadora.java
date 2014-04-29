package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import core.Endereco;
import core.Loja;

public class TelaCadastroTransportadora extends GeneralPanel {
	private static final long serialVersionUID = 1L;

	// Labels
	private JLabel lblNomeFantasia;
	private JLabel lblRazaoSocial;
	private JLabel lblCnpj;
	private JLabel lblPrazoEntrega;
	private JLabel lblTaxaDeEntrega;
	private JLabel lblEndereco;
	private JLabel lblNumero;
	private JLabel lblComplemento;
	private JLabel lblBairro;
	private JLabel lblCep;
	private JLabel lblCidade;
	private JLabel lblEstado;
	private JTextField txtNomeFantasia;
	private JLabel lblPais;

	// TextFields
	private JTextField txtCnpj;
	private JTextField txtPrazoEntrega;
	private JTextField txtTaxaEntrega;
	private JTextField textFieldEndereco;
	private JTextField txtEndNum;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtPais;
	private JTextField txtRazaoSocial;
	private JTextField txtCep;

	// Buttons
	private JButton btnCancelar;
	private JButton btnCadastrar;
	private JButton btnLimpar;

	/**
	 * Create the panel.
	 */
	public TelaCadastroTransportadora(Loja l) {
		super(l);

		setBorder(new TitledBorder(null, "Cadastrar Transportadora",
				TitledBorder.LEADING, TitledBorder.TOP, this.fonte));

		setLayout(new MigLayout("", "[55.00][113.00,grow][][pref!][][91.00,grow]", "[][][][][][][grow,bottom]"));

		lblNomeFantasia = new JLabel("Nome Fantasia:");
		add(lblNomeFantasia, "cell 0 0,alignx right");

		txtNomeFantasia = new JTextField();
		add(txtNomeFantasia, "cell 1 0 5 1,growx");
		txtNomeFantasia.setColumns(10);

		lblRazaoSocial = new JLabel("Raz\u00E3o Social:");
		add(lblRazaoSocial, "cell 0 1,alignx trailing");

		txtRazaoSocial = new JTextField();
		add(txtRazaoSocial, "cell 1 1 5 1,growx");
		txtRazaoSocial.setColumns(10);

		lblCnpj = new JLabel("CNPJ:");
		add(lblCnpj, "cell 0 2,alignx right");

		txtCnpj = new JTextField();
		add(txtCnpj, "cell 1 2,growx");
		txtCnpj.setColumns(10);

		lblPrazoEntrega = new JLabel("Prazo Entrega:");
		add(lblPrazoEntrega, "cell 2 2");

		txtPrazoEntrega = new JTextField();
		add(txtPrazoEntrega, "cell 3 2,growx");
		txtPrazoEntrega.setColumns(10);

		lblTaxaDeEntrega = new JLabel("Taxa de Entrega:");
		add(lblTaxaDeEntrega, "cell 4 2,alignx trailing");

		txtTaxaEntrega = new JTextField();
		add(txtTaxaEntrega, "cell 5 2,growx");
		txtTaxaEntrega.setColumns(10);

		lblEndereco = new JLabel("Endere\u00E7o:");
		add(lblEndereco, "cell 0 3,alignx trailing");

		textFieldEndereco = new JTextField();
		add(textFieldEndereco, "cell 1 3 3 1,growx");
		textFieldEndereco.setColumns(10);

		lblNumero = new JLabel("N\u00FAmero:");
		add(lblNumero, "cell 4 3,alignx trailing");

		txtEndNum = new JTextField();
		add(txtEndNum, "cell 5 3,growx");
		txtEndNum.setColumns(10);

		lblComplemento = new JLabel("Complemento:");
		add(lblComplemento, "cell 0 4,alignx trailing");

		txtComplemento = new JTextField();
		add(txtComplemento, "cell 1 4,growx");
		txtComplemento.setColumns(10);

		lblBairro = new JLabel("Bairro:");
		add(lblBairro, "cell 2 4,alignx trailing");

		txtBairro = new JTextField();
		add(txtBairro, "cell 3 4,growx");
		txtBairro.setColumns(10);

		lblCep = new JLabel("CEP:");
		add(lblCep, "cell 4 4,alignx trailing");

		txtCep = new JTextField();
		add(txtCep, "cell 5 4,growx");
		txtCep.setColumns(10);

		lblCidade = new JLabel("Cidade:");
		add(lblCidade, "cell 0 5,alignx trailing");

		txtCidade = new JTextField();
		add(txtCidade, "cell 1 5,growx");
		txtCidade.setColumns(10);

		lblEstado = new JLabel("Estado:");
		add(lblEstado, "cell 2 5,alignx trailing");

		txtEstado = new JTextField();
		add(txtEstado, "cell 3 5,growx");
		txtEstado.setColumns(10);

		lblPais = new JLabel("Pa\u00EDs:");
		add(lblPais, "cell 4 5,alignx trailing");

		txtPais = new JTextField();
		add(txtPais, "cell 5 5,growx,aligny top");
		txtPais.setColumns(10);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTelaPrincipal();
			}
		});
		add(btnCancelar, "flowx,cell 0 6 6 1,alignx right");
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();	
			}
		});
		add(btnLimpar, "cell 0 6,alignx right,aligny bottom");

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cnpj = txtCnpj.getText();
				String nomeFantasia = txtNomeFantasia.getText();
				String razaoSocial = txtRazaoSocial.getText();
				int prazoEntrega = Integer.parseInt(txtPrazoEntrega.getText());
				double taxaEntrega = Double.parseDouble(txtTaxaEntrega
						.getText());
				String rua = textFieldEndereco.getText();
				String bairro = txtBairro.getText();
				String complemento = txtComplemento.getText();
				String numero = txtEndNum.getText();
				String cep = txtCep.getText();
				String cidade = txtCidade.getText();
				String estado = txtEstado.getText();
				String pais = txtPais.getText();
				Endereco endereco = new Endereco(rua, bairro, complemento,
						numero, cep, cidade, estado, pais);
				
				loja.cadastrarTransportadora(cnpj, nomeFantasia, razaoSocial,
						prazoEntrega, taxaEntrega, endereco);
				
				showMensagemSucesso("Transportadora cadastrada com sucesso!");
				showTelaPrincipal();
			}
		});
		add(btnCadastrar, "cell 0 6 6 1,alignx right");
	}

	@Override
	public void limparCampos() {
		txtNomeFantasia.setText("");
		txtCnpj.setText("");
		txtPrazoEntrega.setText("");
		txtTaxaEntrega.setText("");
		textFieldEndereco.setText("");
		txtEndNum.setText("");
		txtComplemento.setText("");
		txtBairro.setText("");
		txtCidade.setText("");
		txtEstado.setText("");
		txtPais.setText("");
		txtRazaoSocial.setText("");
		txtCep.setText("");
	}
	
	
}
