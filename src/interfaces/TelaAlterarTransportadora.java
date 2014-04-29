package interfaces;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import core.Endereco;
import core.Loja;
import core.Produto;
import core.Transportadora;

public class TelaAlterarTransportadora extends GeneralPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//textFields
	private JTextField txtPrazoEntrega;
	private JTextField txtValorFrete;

	//Labels 
	private JLabel lblPrazoMximoDe;
	private JLabel lblValorDoFrete;
	
	//Buttons
	private JButton btnCancelar;
	private JButton btnSalvar;
	
	
	/**
	 * Create the panel.
	 */
	public TelaAlterarTransportadora(Loja l) {
		super(l);
		Transportadora t = loja.getTransportadoraAlteracao();
		
		setBorder(new TitledBorder(null, "Alterar Transportadora", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma",
				Font.PLAIN, 16)));
		setLayout(new MigLayout("", "[][grow]", "[][][grow,bottom]"));
		
		lblPrazoMximoDe = new JLabel("Prazo Máximo de Entrega:");
		add(lblPrazoMximoDe, "cell 0 0,alignx trailing");
		
		txtPrazoEntrega = new JTextField();
		txtPrazoEntrega.setText(String.valueOf(new Double(t.getPrazoEntrega())));
		add(txtPrazoEntrega, "cell 1 0,growx");
		txtPrazoEntrega.setColumns(10);
		
		lblValorDoFrete = new JLabel("Valor do Frete:");
		add(lblValorDoFrete, "cell 0 1,alignx trailing");
		
		txtValorFrete = new JTextField();
		txtValorFrete.setText(String.valueOf(new Double(t.getTaxaEntrega())));
		add(txtValorFrete, "cell 1 1,growx");
		txtValorFrete.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTelaPrincipal(true);
			}
		});
		add(btnCancelar, "flowx,cell 0 2 2 1,alignx right,aligny bottom");
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int prazoEntrega = Integer.parseInt(txtPrazoEntrega.getText());
				double taxaEntrega = Double.parseDouble(txtValorFrete
						.getText());
				
				loja.cadastrarTransportadora(null, null, null,
						prazoEntrega, taxaEntrega, null);
				
				JOptionPane.showMessageDialog(panel,
						"Transportadora alterada com sucesso!", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
				showTelaPrincipal(true);
			}
		});
		add(btnSalvar, "cell 0 2,alignx right,aligny bottom");

	}


	@Override
	public void limparCampos() {
		// TODO Auto-generated method stub
		
	}

}
