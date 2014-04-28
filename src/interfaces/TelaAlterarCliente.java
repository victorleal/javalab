package interfaces;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import core.Loja;

public class TelaAlterarCliente extends JPanel {
	
	//textField
	private JTextField txtNome;
	private JTextField txtCelular;
	private JTextField txtTelefone;
	private JTextField txtEndNum;
	private JTextField txtEndereco;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCep;
	private JTextField txtPais;
	private JTextField txtEstado;
	private JTextField txtCidade;
	private JTextField txtFidNum;
	private JTextField txtEmail;
	
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
	

	/**
	 * Create the panel.
	 */
	public TelaAlterarCliente(Loja loja) {
		setBorder(new TitledBorder(null, "Alterar Cliente", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma",
				Font.PLAIN, 16)));
		
setLayout(new MigLayout("", "[55.00,grow][114.00,grow][][pref!][][91.00,grow]", "[][][][][][][grow,bottom]"));
		
		lblNome = new JLabel("Nome:");
		add(lblNome, "cell 0 0,alignx right");
		
		txtNome = new JTextField();
		add(txtNome, "cell 1 0 5 1,growx");
		txtNome.setColumns(10);
		
		lblCelular = new JLabel("Celular:");
		add(lblCelular, "cell 0 1,alignx right");
		
		txtCelular = new JTextField();
		add(txtCelular, "cell 1 1,growx");
		txtCelular.setColumns(10);
		
		lblTelefone  = new JLabel("Telefone:");
		add(lblTelefone, "cell 2 1,alignx right");
		
		txtTelefone = new JTextField();
		add(txtTelefone, "cell 3 1,growx");
		txtTelefone.setColumns(10);
		
		lblEmail = new JLabel("Email:");
		add(lblEmail, "cell 4 1,alignx trailing");
		
		txtEmail = new JTextField();
		add(txtEmail, "cell 5 1,growx");
		txtEmail.setColumns(10);
		
		lblEndereo = new JLabel("Endere\u00E7o:");
		add(lblEndereo, "cell 0 2,alignx trailing");
		
		txtEndereco = new JTextField();
		add(txtEndereco, "cell 1 2 3 1,growx");
		txtEndereco.setColumns(10);
		
		lblNmero = new JLabel("Número:");
		add(lblNmero, "cell 4 2,alignx trailing");
		
		txtEndNum = new JTextField();
		add(txtEndNum, "cell 5 2,growx");
		txtEndNum.setColumns(10);
		
		lblComplemento = new JLabel("Complemento:");
		add(lblComplemento, "cell 0 3,alignx trailing");
		
		txtComplemento = new JTextField();
		add(txtComplemento, "cell 1 3,growx");
		txtComplemento.setColumns(10);
		
		lblBairro = new JLabel("Bairro:");
		add(lblBairro, "cell 2 3,alignx trailing");
		
		txtBairro = new JTextField();
		add(txtBairro, "cell 3 3,growx");
		txtBairro.setColumns(10);
		
		lblCep = new JLabel("CEP:");
		add(lblCep, "cell 4 3,alignx trailing");
		
		txtCep = new JTextField();
		add(txtCep, "cell 5 3,growx");
		txtCep.setColumns(10);
		
		lblCidade = new JLabel("Cidade:");
		add(lblCidade, "cell 0 4,alignx trailing");
		
		txtCidade = new JTextField();
		add(txtCidade, "cell 1 4,growx");
		txtCidade.setColumns(10);
		
		lblEstado = new JLabel("Estado:");
		add(lblEstado, "cell 2 4,alignx trailing");
		
		txtEstado = new JTextField();
		add(txtEstado, "cell 3 4,growx");
		txtEstado.setColumns(10);
		
		lblPas = new JLabel("País:");
		add(lblPas, "cell 4 4,alignx trailing");
		
		txtPais = new JTextField();
		add(txtPais, "cell 5 4,growx");
		txtPais.setColumns(10);
		
		lblClienteFidelidade = new JLabel("Cliente Fidelidade?");
		add(lblClienteFidelidade, "cell 0 5,alignx right");
		
		JComboBox cmbFidelidade = new JComboBox();
		add(cmbFidelidade, "cell 1 5,growx");
		
		lblPrograma = new JLabel("Programa:");
		add(lblPrograma, "cell 2 5,alignx right");
		
		JComboBox cmbFidProg = new JComboBox();
		add(cmbFidProg, "cell 3 5,growx");
		
		JLabel lblNmero_1 = new JLabel("Número:");
		add(lblNmero_1, "cell 4 5,alignx right");
		
		txtFidNum = new JTextField();
		add(txtFidNum, "cell 5 5,growx");
		txtFidNum.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnCancelar, "flowx,cell 0 6 6 1,alignx right");
		
		btnSalvar = new JButton("Salvar");
		add(btnSalvar, "cell 0 6 6 1,alignx right");
		


	}

}
