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
import core.Cliente;
import core.Loja;
import core.Produto;

public class TelaConsultaProduto extends GeneralPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblProdutosEncontrados;
	private JButton btnCancelar;
	private JButton btnAlterar;
	private JButton btnExcluir;

	/**
	 * Create the panel.
	 */
	public TelaConsultaProduto(Loja l) {
		super(l);

		setBorder(new TitledBorder(null, "Consultar Produto",
				TitledBorder.LEADING, TitledBorder.TOP, this.fonte));

		setLayout(new MigLayout("", "[1.00][grow]", "[][grow][bottom]"));

		lblProdutosEncontrados = new JLabel("Produtos Encontrados");
		add(lblProdutosEncontrados, "cell 0 0 2 1,alignx center");

		Produto[] lista = {};
		lista = (Produto[]) loja.getProdutos().toArray(lista);
		JList list = new JList(lista);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setCellRenderer(new Renderer());
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					JList<?> source = (JList<?>) event.getSource();
					Produto produtoSelecionado = (Produto) source
							.getSelectedValue();

					loja.setProdutoAlteracao(produtoSelecionado);
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
				if (loja.getProdutoAlteracao() != null) {
					addTela(new TelaAlterarProduto(loja), "AlterarProduto");
					showTela("AlterarProduto");
				} else {
					showMensagemErro("Nenhum produto selecionado");
				}
			}
		});
		add(btnAlterar, "cell 1 2");

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loja.getProdutoAlteracao() != null) {
					loja.removerProduto(loja.getProdutoAlteracao().getId());
					showMensagemSucesso("Produto removido com sucesso");
					showTelaPrincipal();
				} else {
					showMensagemErro("Nenhum produto selecionado");
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
			Produto p = (Produto) value;
			Component c = super.getListCellRendererComponent(list, value,
					index, isSelected, cellHasFocus);
			if (isSelected) {
				c.setBackground(new Color(255, 128, 128));
			}
			setText(p.getDescricao());
			return c;
		}
	}

	@Override
	public void limparCampos() {
		// TODO Auto-generated method stub

	}

}
