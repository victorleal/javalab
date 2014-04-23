package interfaces;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class TelaCadastroProduto extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public TelaCadastroProduto() {
		setLayout(new MigLayout("", "[][grow]", "[][][][][][][][]"));
		
		JLabel label = new JLabel("ID:");
		add(label, "cell 0 0,alignx right");
		
		textField = new JTextField();
		add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso:");
		add(lblPeso, "cell 0 1,alignx trailing");
		
		textField_3 = new JTextField();
		add(textField_3, "cell 1 1,growx");
		textField_3.setColumns(10);
		
		JLabel lblValorUnitrio = new JLabel("Valor Unitário:");
		add(lblValorUnitrio, "cell 0 2,alignx trailing");
		
		textField_4 = new JTextField();
		add(textField_4, "cell 1 2,growx");
		textField_4.setColumns(10);
		
		JLabel lblQuantidadeNoEstoque = new JLabel("Quantidade no Estoque:");
		add(lblQuantidadeNoEstoque, "cell 0 3,alignx trailing");
		
		textField_5 = new JTextField();
		add(textField_5, "cell 1 3,growx");
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Categoria:");
		add(lblNewLabel_1, "cell 0 4,alignx right");
		
		JComboBox comboBox = new JComboBox();
		add(comboBox, "cell 1 4,growx");
		
		JLabel lblNewLabel = new JLabel("Conteúdo da Caixa:");
		add(lblNewLabel, "cell 0 5,alignx trailing");
		
		textField_1 = new JTextField();
		add(textField_1, "cell 1 5,growx");
		textField_1.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descrição:");
		add(lblDescrio, "cell 0 6,alignx trailing");
		
		textField_2 = new JTextField();
		add(textField_2, "cell 1 6,growx");
		textField_2.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		add(btnCancelar, "flowx,cell 1 7,alignx right,aligny bottom");
		
		JButton btnSalvar = new JButton("Salvar");
		add(btnSalvar, "cell 1 7,alignx right,aligny bottom");

	}

}
