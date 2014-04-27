package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import core.Loja;

public class TelaConsultaTransportadora extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public TelaConsultaTransportadora(Loja loja) {

		setLayout(new MigLayout("", "[1.00][grow]", "[][][][][][][][grow][]"));
		
		JLabel lblConsultarTransportadoras = new JLabel("Consultar Transportadoras");
		add(lblConsultarTransportadoras, "cell 0 0 2 1,alignx center");
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		add(lblCnpj, "cell 0 2,alignx trailing");
		
		textField = new JTextField();
		add(textField, "cell 1 2,growx");
		textField.setColumns(10);
		
		JLabel lblRazoSocial = new JLabel("Razão Social:");
		add(lblRazoSocial, "cell 0 3,alignx trailing");
		
		textField_1 = new JTextField();
		add(textField_1, "cell 1 3,growx");
		textField_1.setColumns(10);
		
		JLabel lblNomeFantasia = new JLabel("Nome Fantasia");
		add(lblNomeFantasia, "cell 0 4,alignx trailing");
		
		textField_2 = new JTextField();
		add(textField_2, "cell 1 4,growx");
		textField_2.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		add(btnBuscar, "cell 1 5,alignx right");
		
		JLabel lblTransportadorasEncontradas = new JLabel("Transportadoras Encontradas");
		add(lblTransportadorasEncontradas, "cell 0 6 2 1,alignx center");
		
		JList list = new JList();
		add(list, "cell 0 7 2 1,grow");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.EscondePaineis();
			}
		});
		add(btnCancelar, "flowx,cell 1 8,alignx right,aligny bottom");
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.EscondePaineis();
				TelaPrincipal.frame.getContentPane().add(TelaPrincipal.talttrans);
				TelaPrincipal.talttrans.setVisible(true);
				TelaPrincipal.frame.validate();
			}
		});
		add(btnAlterar, "cell 1 8");
		
		JButton btnExcluir = new JButton("Excluir");
		add(btnExcluir, "cell 1 8,alignx right");	
		
	

	}

}
