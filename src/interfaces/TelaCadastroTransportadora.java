package interfaces;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class TelaCadastroTransportadora extends JPanel {
	private JTextField textField_14;

	/**
	 * Create the panel.
	 */
	public TelaCadastroTransportadora() {
		
setLayout(new MigLayout("", "[55.00,grow][114.00,grow][][][pref!][][][91.00,grow]", "[][][][][][][]"));
		
		JLabel lblNomeFantasia = new JLabel("Nome Fantasia:");
		add(lblNomeFantasia, "cell 0 0,alignx right");
		
		JTextField textField = new JTextField();
		add(textField, "cell 1 0 7 1,growx");
		textField.setColumns(10);
		
		JLabel lblRazoSocial = new JLabel("Razão Social:");
		add(lblRazoSocial, "cell 0 1,alignx trailing");
		
		textField_14 = new JTextField();
		add(textField_14, "cell 1 1 7 1,growx");
		textField_14.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		add(lblCnpj, "cell 0 2,alignx right");
		
		JTextField textField_1 = new JTextField();
		add(textField_1, "cell 1 2,growx");
		textField_1.setColumns(10);
		
		JLabel lblPrazoEntrega = new JLabel("Prazo Entrega:");
		add(lblPrazoEntrega, "cell 2 2");
		
		JTextField textField_4 = new JTextField();
		add(textField_4, "cell 4 2,growx");
		textField_4.setColumns(10);
		
		JLabel lblTaxaDeEntrga = new JLabel("Taxa de Entrga:");
		add(lblTaxaDeEntrga, "cell 6 2,alignx trailing");
		
		JTextField textField_5 = new JTextField();
		add(textField_5, "cell 7 2,growx");
		textField_5.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		add(lblEndereo, "cell 0 3,alignx trailing");
		
		JTextField textField_6 = new JTextField();
		add(textField_6, "cell 1 3 4 1,growx");
		textField_6.setColumns(10);
		
		JLabel lblNmero = new JLabel("Número:");
		add(lblNmero, "cell 6 3,alignx trailing");
		
		JTextField textField_2 = new JTextField();
		add(textField_2, "cell 7 3,growx");
		textField_2.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		add(lblComplemento, "cell 0 4,alignx trailing");
		
		JTextField textField_7 = new JTextField();
		add(textField_7, "cell 1 4,growx");
		textField_7.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		add(lblBairro, "cell 2 4,alignx trailing");
		
		JTextField textField_8 = new JTextField();
		add(textField_8, "cell 4 4,growx");
		textField_8.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		add(lblCep, "cell 6 4,alignx trailing");
		
		Component textField_9 = new JTextField();
		add(textField_9, "cell 7 4,growx");
		textField_9.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		add(lblCidade, "cell 0 5,alignx trailing");
		
		JTextField textField_12 = new JTextField();
		add(textField_12, "cell 1 5,growx");
		textField_12.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		add(lblEstado, "cell 2 5,alignx trailing");
		
		JTextField textField_11 = new JTextField();
		add(textField_11, "cell 4 5,growx");
		textField_11.setColumns(10);
		
		JLabel lblPas = new JLabel("País:");
		add(lblPas, "cell 6 5,alignx trailing");
		
		JTextField textField_10 = new JTextField();
		add(textField_10, "cell 7 5,growx");
		textField_10.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		add(btnCancelar, "flowx,cell 4 6,alignx right");
		
		JButton btnCadastrar = new JButton("Cadastrar");
		add(btnCadastrar, "cell 4 6,alignx right");
		

	}

}
