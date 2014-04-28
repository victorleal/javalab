package interfaces;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import core.Loja;

public class TelaControle extends JPanel {

	/**
	 * Create the panel.
	 */
	public TelaControle(Loja loja) {
		setBorder(new TitledBorder(null, "Gerenciamento do Sistema",
				TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16)));
		setLayout(new MigLayout("", "[grow]", "[][][][][][][][][][][]"));

		JLabel lblGerenciamento = new JLabel("Gerenciamento");
		add(lblGerenciamento, "cell 0 0,alignx center");

		JLabel lblFaturamento = new JLabel("Faturamento:");
		add(lblFaturamento, "cell 0 2,alignx center");

		JButton btnFaturamentoBruto = new JButton("Faturamento Bruto");
		add(btnFaturamentoBruto, "cell 0 3,alignx center");

		JButton btnFaturamentoLquido = new JButton("Faturamento Líquido");
		add(btnFaturamentoLquido, "cell 0 4,alignx center");

		JLabel lblValoresDevidos = new JLabel("Valores Devidos:");
		add(lblValoresDevidos, "cell 0 5,alignx center");

		JButton btnATransportadoras = new JButton("A Transportadoras");
		add(btnATransportadoras, "cell 0 6,alignx center");

		JButton btnTotal = new JButton("Total");
		add(btnTotal, "cell 0 7,alignx center");

		JLabel lblManuteno = new JLabel("Manutenção:");
		add(lblManuteno, "cell 0 8,alignx center");

		JButton btnLimparPedidosEntregues = new JButton(
				"Limpar Pedidos Entregues");
		add(btnLimparPedidosEntregues, "cell 0 9,alignx center");

	}

}
