package interfaces;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import core.Loja;

public class TelaAlterarTransportadora extends JPanel {
	
	//textFields
	private JTextField txtPrazoMaxEntrega;
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
	public TelaAlterarTransportadora(Loja loja) {
		setBorder(new TitledBorder(null, "Alterar Transportadora", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma",
				Font.PLAIN, 16)));
		setLayout(new MigLayout("", "[][grow]", "[][][grow,bottom]"));
		
		lblPrazoMximoDe = new JLabel("Prazo Máximo de Entrega:");
		add(lblPrazoMximoDe, "cell 0 0,alignx trailing");
		
		txtPrazoMaxEntrega = new JTextField();
		add(txtPrazoMaxEntrega, "cell 1 0,growx");
		txtPrazoMaxEntrega.setColumns(10);
		
		lblValorDoFrete = new JLabel("Valor do Frete:");
		add(lblValorDoFrete, "cell 0 1,alignx trailing");
		
		txtValorFrete = new JTextField();
		add(txtValorFrete, "cell 1 1,growx");
		txtValorFrete.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnCancelar, "flowx,cell 0 2 2 1,alignx right,aligny bottom");
		
		btnSalvar = new JButton("Salvar");
		add(btnSalvar, "cell 0 2,alignx right,aligny bottom");

	}

}
