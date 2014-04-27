package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import core.Loja;

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
	public TelaCadastroProduto(Loja loja) {
		setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][][]"));
		
		JLabel lblCadastrarProduto = new JLabel("Cadastrar Produto");
		add(lblCadastrarProduto, "cell 0 0 2 1,alignx center");
		
		JLabel label = new JLabel("ID:");
		add(label, "cell 0 2,alignx right");
		
		textField = new JTextField();
		add(textField, "cell 1 2,growx");
		textField.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso:");
		add(lblPeso, "cell 0 3,alignx trailing");
		
		textField_3 = new JTextField();
		add(textField_3, "cell 1 3,growx");
		textField_3.setColumns(10);
		
		JLabel lblValorUnitrio = new JLabel("Valor Unitário:");
		add(lblValorUnitrio, "cell 0 4,alignx trailing");
		
		textField_4 = new JTextField();
		add(textField_4, "cell 1 4,growx");
		textField_4.setColumns(10);
		
		JLabel lblQuantidadeNoEstoque = new JLabel("Quantidade no Estoque:");
		add(lblQuantidadeNoEstoque, "cell 0 5,alignx trailing");
		
		textField_5 = new JTextField();
		add(textField_5, "cell 1 5,growx");
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Categoria:");
		add(lblNewLabel_1, "cell 0 6,alignx right");
		
		JComboBox comboBox = new JComboBox();
		add(comboBox, "cell 1 6,growx");
		
		JLabel lblNewLabel = new JLabel("Conteúdo da Caixa:");
		add(lblNewLabel, "cell 0 7,alignx trailing");
		
		textField_1 = new JTextField();
		add(textField_1, "cell 1 7,growx");
		textField_1.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descrição:");
		add(lblDescrio, "cell 0 8,alignx trailing");
		
		textField_2 = new JTextField();
		add(textField_2, "cell 1 8,growx");
		textField_2.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.EscondePaineis();
			}
		});
		add(btnCancelar, "flowx,cell 1 10,alignx right,aligny bottom");
		
		JButton btnCadastrar = new JButton("Cadastrar");
		add(btnCadastrar, "cell 1 10");

	}

}
