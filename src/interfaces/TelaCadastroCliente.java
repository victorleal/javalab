package interfaces;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class TelaCadastroCliente extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public TelaCadastroCliente() {
		setLayout(new MigLayout("", "[15px][4px][55px,grow][4px][67px][4px][42px][4px][71px][4px][105px][96px]", "[1px][25px][][][][][][][]"));
		
		JLabel lblNome = new JLabel("Nome:");
		add(lblNome, "cell 0 0,alignx left,aligny center");
		
		textField = new JTextField();
		add(textField, "cell 2 0 9 1,grow");
		textField.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		add(lblCpf, "cell 0 1,alignx left,aligny center");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		add(textField_1, "cell 2 1 9 1,growx");
		
		JLabel lblCelular = new JLabel("Celular:");
		add(lblCelular, "cell 0 2,alignx left,aligny center");
		
		JLabel lblTelefone = new JLabel("Telefone:");
		add(lblTelefone, "cell 0 3,alignx left,aligny center");
		
		JLabel lblEmail = new JLabel("Email:");
		add(lblEmail, "cell 0 4,alignx left,aligny center");
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		add(lblEndereo, "cell 0 5,alignx left,aligny center");
		
		JButton btnCadastrar = new JButton("Cadastrar");
		add(btnCadastrar, "cell 10 8,alignx center,aligny center");
		
		JButton btnCancelar = new JButton("Cancelar");
		add(btnCancelar, "cell 11 8,alignx center,aligny center");

	}

}
