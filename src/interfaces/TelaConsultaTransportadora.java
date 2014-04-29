package interfaces;

import java.awt.Font;
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

public class TelaConsultaTransportadora extends GeneralPanel {
	//TextField
	private JTextField txtCnpj;
	private JTextField txtRazaoSocial;
	private JTextField txtNomeFantasia;
	
	//Label
	private JLabel lblCnpj;
	private JLabel lblRazoSocial;
	private JLabel lblNomeFantasia;
	private JLabel lblTransportadorasEncontradas;
	
	//Button
	private JButton btnBuscar;
	private JButton btnCancelar;
	private JButton btnExcluir;
	private JButton btnAlterar;
	

	/**
	 * Create the panel.
	 */
	public TelaConsultaTransportadora(Loja l) {
		super(l);
		
		setBorder(new TitledBorder(null, "Consultar Transportadora", TitledBorder.LEADING, TitledBorder.TOP, this.fonte));

		setLayout(new MigLayout("", "[1.00][grow]", "[][][][][][grow][bottom]"));
		
		lblCnpj = new JLabel("CNPJ:");
		add(lblCnpj, "cell 0 0,alignx trailing");
		
		txtCnpj = new JTextField();
		add(txtCnpj, "cell 1 0,growx");
		txtCnpj.setColumns(10);
		
		lblRazoSocial = new JLabel("Razão Social:");
		add(lblRazoSocial, "cell 0 1,alignx trailing");
		
		txtRazaoSocial = new JTextField();
		add(txtRazaoSocial, "cell 1 1,growx");
		txtRazaoSocial.setColumns(10);
		
		lblNomeFantasia = new JLabel("Nome Fantasia");
		add(lblNomeFantasia, "cell 0 2,alignx trailing");
		
		txtNomeFantasia = new JTextField();
		add(txtNomeFantasia, "cell 1 2,growx");
		txtNomeFantasia.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		add(btnBuscar, "cell 1 3,alignx right");
		
		lblTransportadorasEncontradas = new JLabel("Transportadoras Encontradas");
		add(lblTransportadorasEncontradas, "cell 0 4 2 1,alignx center");
		
		JList list = new JList();
		add(list, "cell 0 5 2 1,grow");
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnCancelar, "flowx,cell 1 6,alignx right,aligny bottom");
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//contentPane.add(new TelaAlterarTransportadora(loja),"AlterarTransportadora");
			}
		});
		add(btnAlterar, "cell 1 6");
		
		btnExcluir = new JButton("Excluir");
		add(btnExcluir, "cell 1 6,alignx right");	
		
	

	}


	@Override
	public void limparCampos() {
		// TODO Auto-generated method stub
		
	}

}
