package interfaces;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.miginfocom.swing.MigLayout;
import core.Loja;
import core.Pedido;
import exceptions.ParametroException;

public class TelaConsultaPedido extends GeneralPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblPedidosEncontrados;
	private JButton btnCancelar;
	
	// Controla Pedido Selecionado
	private Pedido pedidoSelecionado;

	/**
	 * Create the panel Pedido.
	 */
	public TelaConsultaPedido(Loja l) {
		super(l);
		setBorder(new TitledBorder(null, "Consultar Pedido",
				TitledBorder.LEADING, TitledBorder.TOP, this.fonte));

		setLayout(new MigLayout("", "[1.00][grow]", "[][grow][bottom]"));

		lblPedidosEncontrados = new JLabel("Pedidos Encontrados");
		add(lblPedidosEncontrados, "cell 0 0 2 1,alignx center");

		Pedido[] lista = {};
		lista = (Pedido[]) loja.getPedidos().toArray(lista);
		JList list = new JList(lista);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setCellRenderer(new Renderer());
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					JList<?> source = (JList<?>) event.getSource();
					pedidoSelecionado = (Pedido) source
							.getSelectedValue();
				}
			}
		});
		JScrollPane listScroller = new JScrollPane(list);
		add(listScroller, "cell 0 1 2 1,grow");

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTelaPrincipal();
			}
		});
		add(btnCancelar, "flowx,cell 1 2,alignx right,aligny bottom");

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pedidoSelecionado != null) {
					try {
						loja.cancelarPedido(pedidoSelecionado.getNumero());
						showMensagemSucesso("Pedido removido com sucesso");
						showTelaPrincipal();
					} catch (ParametroException e1) {
						showMensagemErro();
					}
				} else {
					showMensagemErro("Nenhum pedido selecionado");
				}
			}
		});
		add(btnExcluir, "cell 1 2,alignx right");

	}

	class Renderer extends DefaultListCellRenderer {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public Component getListCellRendererComponent(JList<?> list,
				Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Pedido p = (Pedido) value;
			Component c = super.getListCellRendererComponent(list, value,
					index, isSelected, cellHasFocus);
			if (isSelected) {
				c.setBackground(new Color(255, 128, 128));
			}
			setText(p.getNumero() + " - Cliente: " + p.getCliente().getNome() + " - Valor Total: "
					+ p.getValorTotal());
			return c;
		}
	}

	@Override
	public void limparCampos() {
		// TODO Auto-generated method stub

	}

}
