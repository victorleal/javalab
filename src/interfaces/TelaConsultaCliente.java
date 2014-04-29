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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.miginfocom.swing.MigLayout;
import core.Cliente;
import core.Loja;

public class TelaConsultaCliente extends GeneralPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// TextField
	private JTextField txtCpf;
	private JTextField txtNome;

	// Labels
	private JLabel lblCpf;
	private JLabel lblNome;
	private JLabel lblClientesEncontrados;

	// Buttons
	private JButton btnExcluir;
	private JButton btnAlterar;
	private JButton btnCancelar;
	private JButton btnBuscar;

	/**
	 * Create the panel.
	 */
	public TelaConsultaCliente(Loja l) {
		super(l);
		
		setBorder(new TitledBorder(null, "Consultar Cliente",
				TitledBorder.LEADING, TitledBorder.TOP, this.fonte));

		setLayout(new MigLayout("", "[1.00][grow]", "[][][][][grow][bottom]"));

		lblCpf = new JLabel("CPF:");
		add(lblCpf, "cell 0 0,alignx trailing");

		txtCpf = new JTextField();
		add(txtCpf, "cell 1 0,growx");
		txtCpf.setColumns(10);

		lblNome = new JLabel("Nome:");
		add(lblNome, "cell 0 1,alignx trailing");

		txtNome = new JTextField();
		add(txtNome, "cell 1 1,growx");
		txtNome.setColumns(10);

		btnBuscar = new JButton("Buscar");
		add(btnBuscar, "cell 1 2,alignx right");

		lblClientesEncontrados = new JLabel("Clientes Encontrados");
		add(lblClientesEncontrados, "cell 0 3 2 1,alignx center");

		Cliente[] lista = {};
		lista = (Cliente[]) l.getClientes().toArray(lista);
		JList<Cliente> list = new JList<Cliente>(lista);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setCellRenderer(new Renderer());
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					JList<?> source = (JList<?>) event.getSource();
					Cliente clienteSelecionado = (Cliente) source.getSelectedValue();
					
					loja.setClienteAlteracao(clienteSelecionado);
				}
			}
		});
		JScrollPane listScroller = new JScrollPane(list);
		add(listScroller, "cell 0 4 2 1,grow");

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTelaPrincipal(true);
			}
		});
		add(btnCancelar, "flowx,cell 1 5,alignx right,aligny bottom");

		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addTela(new TelaAlterarCliente(loja), "AlterarCliente");
				showTela("AlterarCliente");
			}
		});
		add(btnAlterar, "cell 1 5");

		btnExcluir = new JButton("Excluir");
		add(btnExcluir, "cell 1 5,alignx right");

	}

	class Renderer extends DefaultListCellRenderer {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			Cliente cliente = (Cliente) value;
			Component c = super.getListCellRendererComponent(list, value,
					index, isSelected, cellHasFocus);
			if (isSelected) {
				c.setBackground(Color.RED);
			}
			setText(cliente.getNome());
			return c;
		}
	}

	@Override
	public void limparCampos() {
		// TODO Auto-generated method stub
		
	}
}
