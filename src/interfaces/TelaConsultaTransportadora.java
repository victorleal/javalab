package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import core.Loja;

public class TelaConsultaTransportadora extends JPanel {
	private JTextField txtCnpj;
	private JTextField txtRazaoSocial;
	private JTextField txtNomeFantasia;

	/**
	 * Create the panel.
	 */
	public TelaConsultaTransportadora(Loja loja) {
		setBorder(new TitledBorder(null, "Consultar Transportadora", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		setLayout(new MigLayout("", "[1.00][grow]", "[][][][][][grow][]"));
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		add(lblCnpj, "cell 0 0,alignx trailing");
		
		txtCnpj = new JTextField();
		add(txtCnpj, "cell 1 0,growx");
		txtCnpj.setColumns(10);
		
		JLabel lblRazoSocial = new JLabel("Razão Social:");
		add(lblRazoSocial, "cell 0 1,alignx trailing");
		
		txtRazaoSocial = new JTextField();
		add(txtRazaoSocial, "cell 1 1,growx");
		txtRazaoSocial.setColumns(10);
		
		JLabel lblNomeFantasia = new JLabel("Nome Fantasia");
		add(lblNomeFantasia, "cell 0 2,alignx trailing");
		
		txtNomeFantasia = new JTextField();
		add(txtNomeFantasia, "cell 1 2,growx");
		txtNomeFantasia.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		add(btnBuscar, "cell 1 3,alignx right");
		
		JLabel lblTransportadorasEncontradas = new JLabel("Transportadoras Encontradas");
		add(lblTransportadorasEncontradas, "cell 0 4 2 1,alignx center");
		
		JList list = new JList();
		add(list, "cell 0 5 2 1,grow");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnCancelar, "flowx,cell 1 6,alignx right,aligny bottom");
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnAlterar, "cell 1 6");
		
		JButton btnExcluir = new JButton("Excluir");
		add(btnExcluir, "cell 1 6,alignx right");	
		
	

	}

}
