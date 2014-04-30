package interfaces;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import core.Loja;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

public class TelaControle extends GeneralPanel {
	
	//Button
	private JButton btnFaturamentoBruto;
	private JButton btnFaturamentoLquido;
	private JButton btnATransportadoras;
	private JButton btnTotal;
	private JButton btnLimparPedidosEntregues;
	
	//TextField
	private JTextField textFieldFaturamentoBruto;
	private JTextField textFieldFaturamentoLiquido;
	private JTextField textFieldValorDevidoTransp;
	private JTextField textFieldValorDevidoTotal;

	/**
	 * Create the panel.
	 */
	public TelaControle(final Loja loja) {
		super(loja);
		setBorder(new TitledBorder(null, "Gerenciamento do Sistema",
				TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16)));
		setLayout(new MigLayout("", "[grow][grow]", "[][][][]"));

		btnFaturamentoBruto = new JButton("Faturamento Bruto");
		btnFaturamentoBruto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldFaturamentoBruto.setText(String.valueOf(new Double(loja.getFaturamentoBruto())));
			}
		});
		add(btnFaturamentoBruto, "cell 0 0,alignx center");
		
		textFieldFaturamentoBruto = new JTextField();
		textFieldFaturamentoBruto.setEditable(false);
		add(textFieldFaturamentoBruto, "cell 1 0,growx");
		textFieldFaturamentoBruto.setColumns(10);

		btnFaturamentoLquido = new JButton("Faturamento Líquido");
		btnFaturamentoLquido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldFaturamentoLiquido.setText(String.valueOf(new Double(loja.getFaturamentoLiquido())));
			}
		});
		add(btnFaturamentoLquido, "cell 0 1,alignx center");
		
		textFieldFaturamentoLiquido = new JTextField();
		textFieldFaturamentoLiquido.setEditable(false);
		add(textFieldFaturamentoLiquido, "cell 1 1,growx");
		textFieldFaturamentoLiquido.setColumns(10);

		btnATransportadoras = new JButton("Valor Devido a Transportadoras");
		btnATransportadoras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cnpj = JOptionPane.showInputDialog("Digite o CNPJ");
				textFieldValorDevidoTransp.setText(String.valueOf(new Double(loja.getValorDevidoTransportadora(cnpj))));
			}
		});
		add(btnATransportadoras, "cell 0 2,alignx center");
		
		textFieldValorDevidoTransp = new JTextField();
		textFieldValorDevidoTransp.setEditable(false);
		add(textFieldValorDevidoTransp, "cell 1 2,growx");
		textFieldValorDevidoTransp.setColumns(10);

		btnTotal = new JButton("Valor Devido Total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldValorDevidoTotal.setText(String.valueOf(new Double(loja.getValorDevidoTotal())));
			}
		});
		add(btnTotal, "cell 0 3,alignx center");
		
		textFieldValorDevidoTotal = new JTextField();
		textFieldValorDevidoTotal.setEditable(false);
		add(textFieldValorDevidoTotal, "cell 1 3,growx");
		textFieldValorDevidoTotal.setColumns(10);

		btnLimparPedidosEntregues = new JButton(
				"Limpar Pedidos Entregues");
		btnLimparPedidosEntregues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loja.limparPedidos();
				JOptionPane.showMessageDialog(panel,
						"Pedidos entregues foram limpos com sucesso!", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

	}

	@Override
	public void limparCampos() {
		// TODO Auto-generated method stub
		
	}

}
