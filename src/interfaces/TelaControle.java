package interfaces;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import core.Loja;

public class TelaControle extends JPanel {
	//Label
	private JLabel lblFaturamento;
	private JLabel lblValoresDevidos;
	private JLabel lblManuteno;
	
	//Button
	private JButton btnFaturamentoBruto;
	private JButton btnFaturamentoLquido;
	private JButton btnATransportadoras;
	private JButton btnTotal;
	private JButton btnLimparPedidosEntregues;

	/**
	 * Create the panel.
	 */
	public TelaControle(Loja loja) {
		setBorder(new TitledBorder(null, "Gerenciamento do Sistema",
				TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16)));
		setLayout(new MigLayout("", "[grow]", "[][][][][][][][][][]"));

		lblFaturamento = new JLabel("Faturamento:");
		add(lblFaturamento, "cell 0 1,alignx center");

		btnFaturamentoBruto = new JButton("Faturamento Bruto");
		add(btnFaturamentoBruto, "cell 0 2,alignx center");

		btnFaturamentoLquido = new JButton("Faturamento Líquido");
		add(btnFaturamentoLquido, "cell 0 3,alignx center");

		lblValoresDevidos = new JLabel("Valores Devidos:");
		add(lblValoresDevidos, "cell 0 4,alignx center");

		btnATransportadoras = new JButton("A Transportadoras");
		add(btnATransportadoras, "cell 0 5,alignx center");

		btnTotal = new JButton("Total");
		add(btnTotal, "cell 0 6,alignx center");

		lblManuteno = new JLabel("Manutenção:");
		add(lblManuteno, "cell 0 7,alignx center");

		btnLimparPedidosEntregues = new JButton(
				"Limpar Pedidos Entregues");
		add(btnLimparPedidosEntregues, "cell 0 8,alignx center");

	}

}
