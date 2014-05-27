package interfaces;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import core.Transportadora;

public class TelaConsultaTransportadora extends GeneralPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblTransportadorasEncontradas;
	private JButton btnCancelar;
	private JButton btnExcluir;
	private JButton btnAlterar;

	/**
	 * Create the panel.
	 */
	public TelaConsultaTransportadora(Loja l) {
		super(l);

		setBorder(new TitledBorder(null, "Consultar Transportadora",
				TitledBorder.LEADING, TitledBorder.TOP, this.fonte));

		setLayout(new MigLayout("", "[1.00][grow]", "[][grow][bottom]"));

		lblTransportadorasEncontradas = new JLabel(
				"Transportadoras Encontradas");
		add(lblTransportadorasEncontradas, "cell 0 0 2 1,alignx center");

		Transportadora[] lista = {};
		lista = (Transportadora[]) loja.getTransportadoras().toArray(lista);
		JList list = new JList(lista);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setCellRenderer(new Renderer());
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					JList<?> source = (JList<?>) event.getSource();
					Transportadora transportadoraSelecionada = (Transportadora) source
							.getSelectedValue();

					loja.setTransportadoraAlteracao(transportadoraSelecionada);
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

		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loja.getTransportadoraAlteracao() != null) {
					addTela(new TelaAlterarTransportadora(loja),
							"AlterarTransportadora");
					showTela("AlterarTransportadora");
				} else {
					showMensagemErro("Nenhuma transportadora selecionada");
				}
			}
		});
		add(btnAlterar, "cell 1 2");

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loja.getTransportadoraAlteracao() != null) {
					try {
						loja.removerTransportadora(loja
								.getTransportadoraAlteracao().getCnpj());
						showMensagemSucesso("Transportadora removida com sucesso");
						showTelaPrincipal();
					} catch (Exception e1) {
						showMensagemErro("Transportadora não encontrada");
					}
				} else {
					showMensagemErro("Nenhuma transportadora selecionada");
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
			Transportadora t = (Transportadora) value;
			Component c = super.getListCellRendererComponent(list, value,
					index, isSelected, cellHasFocus);
			if (isSelected) {
				c.setBackground(new Color(255, 128, 128));
			}
			setText(t.getNomeFantasia());
			return c;
		}
	}

	@Override
	public void limparCampos() {
		// TODO Auto-generated method stub

	}

}
