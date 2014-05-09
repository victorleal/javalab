package interfaces;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import core.Endereco;

import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

public class TelaEnderecoEntregaPedido extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// TextField
	private JTextField textFieldRua;
	private JFormattedTextField textFieldNumero;
	private JTextField textFieldBairro;
	private JTextField textFieldCidade;
	private JTextField textFieldEstado;
	private JTextField textFieldPais;
	private JTextField textFieldComplemento;
	private JFormattedTextField textFieldCep;

	// Labels
	private JLabel lblRua;
	private JLabel lblNumero;
	private JLabel lblBairro;
	private JLabel lblCidade;
	private JLabel lblEstado;
	private JLabel lblPas;
	private JLabel lblComplemento;
	private JLabel lblCep;
	
	// Mascaras
	private MaskFormatter mascaraCEP;
	private MaskFormatter mascaraNumero;

	// Button
	private JButton btnOk;

	// Controla o panel
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public TelaEnderecoEntregaPedido() {
		setBorder(new TitledBorder(null, "Endere\u00E7o de Entrega",
				TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma",
						Font.PLAIN, 16)));
		panel = this;

		setLayout(new MigLayout("", "[45.00][222.00,grow][63.00][grow]",
				"[][][][][][grow,bottom]"));
		
		try {
			mascaraCEP = new MaskFormatter("#####-###");
			mascaraCEP.setPlaceholderCharacter('_');
			mascaraNumero = new MaskFormatter("#####");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		lblRua = new JLabel("Rua:");
		add(lblRua, "cell 0 0,alignx trailing");

		textFieldRua = new JTextField();
		add(textFieldRua, "cell 1 0,growx");
		textFieldRua.setColumns(10);

		lblNumero = new JLabel("N\u00FAmero:");
		add(lblNumero, "cell 2 0,alignx trailing");

		textFieldNumero = new JFormattedTextField(mascaraNumero);
		add(textFieldNumero, "cell 3 0,growx");
		textFieldNumero.setColumns(10);

		lblBairro = new JLabel("Bairro:");
		add(lblBairro, "cell 0 1,alignx trailing");

		textFieldBairro = new JTextField();
		add(textFieldBairro, "cell 1 1,growx");
		textFieldBairro.setColumns(10);

		lblCidade = new JLabel("Cidade:");
		add(lblCidade, "cell 0 2,alignx trailing");

		textFieldCidade = new JTextField();
		add(textFieldCidade, "cell 1 2,growx");
		textFieldCidade.setColumns(10);

		lblEstado = new JLabel("Estado:");
		add(lblEstado, "cell 2 2,alignx trailing");

		textFieldEstado = new JTextField();
		add(textFieldEstado, "cell 3 2,growx");
		textFieldEstado.setColumns(10);

		lblPas = new JLabel("Pa\u00EDs:");
		add(lblPas, "cell 0 3,alignx trailing");

		textFieldPais = new JTextField();
		add(textFieldPais, "cell 1 3,growx");
		textFieldPais.setColumns(10);

		lblComplemento = new JLabel("Complemento:");
		add(lblComplemento, "cell 0 4,alignx trailing");

		textFieldComplemento = new JTextField();
		add(textFieldComplemento, "cell 1 4,growx");
		textFieldComplemento.setColumns(10);

		lblCep = new JLabel("CEP:");
		add(lblCep, "cell 2 4,alignx trailing");

		textFieldCep = new JFormattedTextField(mascaraCEP);
		add(textFieldCep, "cell 3 4,growx");
		textFieldCep.setColumns(10);

		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container parent = panel.getParent();
				CardLayout cl = (CardLayout) parent.getLayout();
				cl.show(parent, "CadastrarPedido");
			}
		});
		add(btnOk, "cell 0 5 4 1,alignx right");

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

		Endereco e;
		if (rua != null && !rua.isEmpty()) {
			e = new Endereco(rua, bairro, complemento, numero, cep, cidade,
					estado, pais);
		} else {
			e = null;
		}
		return e;
	}

}
