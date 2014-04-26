package interfaces;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAlterarTransportadora extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public TelaAlterarTransportadora() {
		setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][][]"));
		
		JLabel lblAlterarTransportadora = new JLabel("Alterar Transportadora");
		add(lblAlterarTransportadora, "cell 0 0 2 1,alignx center");
		
		JLabel lblPrazoMximoDe = new JLabel("Prazo Máximo de Entrega:");
		add(lblPrazoMximoDe, "cell 0 2,alignx trailing");
		
		textField = new JTextField();
		add(textField, "cell 1 2,growx");
		textField.setColumns(10);
		
		JLabel lblValorDoFrete = new JLabel("Valor do Frete:");
		add(lblValorDoFrete, "cell 0 3,alignx trailing");
		
		textField_1 = new JTextField();
		add(textField_1, "cell 1 3,growx");
		textField_1.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.EscondePaineis();
			}
		});
		add(btnCancelar, "flowx,cell 0 10 2 1,alignx right,aligny bottom");
		
		JButton btnSalvar = new JButton("Salvar");
		add(btnSalvar, "cell 0 10,alignx right,aligny bottom");

	}

}
