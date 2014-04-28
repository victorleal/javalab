package interfaces;

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

public class TelaConsultaCliente extends JPanel {
	private JTextField txtCpf;
	private JTextField txtNome;

	/**
	 * Create the panel.
	 */
	public TelaConsultaCliente(Loja loja) {
		setBorder(new TitledBorder(null, "Consultar Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
setLayout(new MigLayout("", "[1.00][grow]", "[][][][][grow][]"));
		
		JLabel lblCpf = new JLabel("CPF:");
		add(lblCpf, "cell 0 0,alignx trailing");
		
		txtCpf = new JTextField();
		add(txtCpf, "cell 1 0,growx");
		txtCpf.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		add(lblNome, "cell 0 1,alignx trailing");
		
		txtNome = new JTextField();
		add(txtNome, "cell 1 1,growx");
		txtNome.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		add(btnBuscar, "cell 1 2,alignx right");
		
		JLabel lblClientesEncontrados = new JLabel("Clientes Encontrados");
		add(lblClientesEncontrados, "cell 0 3 2 1,alignx center");
		
		JList list = new JList();
		add(list, "cell 0 4 2 1,grow");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnCancelar, "flowx,cell 1 5,alignx right,aligny bottom");
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(btnAlterar, "cell 1 5");
		
		JButton btnExcluir = new JButton("Excluir");
		add(btnExcluir, "cell 1 5,alignx right");	

	}

}
