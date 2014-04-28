package interfaces;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import core.Loja;

public class TelaConsultaProduto extends JPanel {
	//TextField
	private JTextField txtIdProduto;

	//Label
	private JLabel lblId;
	private JLabel lblCategoria;
	private JLabel lblProdutosEncontrados;
	
	
	
	//Button
	private JButton btnBuscar;
	private JButton btnCancelar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	
	/**
	 * Create the panel.
	 */
	public TelaConsultaProduto(Loja loja) {
		setBorder(new TitledBorder(null, "Consultar Produto", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma",
				Font.PLAIN, 16)));
		
setLayout(new MigLayout("", "[1.00][grow]", "[][][][][grow][bottom]"));
		
		lblId = new JLabel("ID:");
		add(lblId, "cell 0 0,alignx right");
		
		txtIdProduto = new JTextField();
		add(txtIdProduto, "cell 1 0,growx");
		txtIdProduto.setColumns(10);
		
		lblCategoria = new JLabel("Categoria:");
		add(lblCategoria, "cell 0 1,alignx right");
		
		JComboBox cmbCategoria = new JComboBox();
		add(cmbCategoria, "cell 1 1,growx");
		
		btnBuscar = new JButton("Buscar");
		add(btnBuscar, "cell 1 2,alignx right");
		
		lblProdutosEncontrados = new JLabel("Produtos Encontrados");
		add(lblProdutosEncontrados, "cell 0 3 2 1,alignx center");
		
		JList list = new JList();
		add(list, "cell 0 4 2 1,grow");
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnCancelar, "flowx,cell 1 5,alignx right,aligny bottom");
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnAlterar, "cell 1 5");
		
		btnExcluir = new JButton("Excluir");
		add(btnExcluir, "cell 1 5,alignx right");

	}

}
