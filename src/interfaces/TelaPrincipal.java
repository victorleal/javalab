package interfaces;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;

import core.Loja;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	private JFrame frame;

	private Loja loja;

	/**
	 * Create the frame.
	 * 
	 * @param titulo
	 */
	public TelaPrincipal(String titulo) {
		loja = new Loja();
		frame = this;

		this.setIconImage(new ImageIcon(getClass().getResource("computer.png"))
				.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 700, 500);
		setTitle(titulo);

		adicionarMenus();

		contentPane = new JPanel(new CardLayout());
		contentPane.add(new TelaInicial(), "Inicial");

		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		setContentPane(contentPane);

		setLookAndFeel();

		this.setVisible(true);
	}

	public void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
	}

	public void adicionarMenus() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		JMenuItem mntmGerenciamento = new JMenuItem("Gerenciamento");
		mntmGerenciamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.add(new TelaControle(loja), "Controle");
				CardLayout cl = (CardLayout) (contentPane.getLayout());
				cl.show(contentPane, "Controle");
				frame.validate();
			}
		});
		mnArquivo.add(mntmGerenciamento);
		mnArquivo.add(mntmSair);

		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);

		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.add(new TelaCadastroCliente(loja),
						"CadastrarCliente");
				CardLayout cl = (CardLayout) (contentPane.getLayout());
				cl.show(contentPane, "CadastrarCliente");
				frame.validate();
			}
		});
		mnCliente.add(mntmCadastrar);

		JMenuItem mntmConsultar_3 = new JMenuItem("Consultar");
		mntmConsultar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.add(new TelaConsultaCliente(loja),
						"ConsultarCliente");
				CardLayout cl = (CardLayout) (contentPane.getLayout());
				cl.show(contentPane, "ConsultarCliente");
				frame.validate();

			}
		});
		mnCliente.add(mntmConsultar_3);

		JMenu mnProduto = new JMenu("Produto");
		menuBar.add(mnProduto);

		JMenuItem mntmCadastrar_1 = new JMenuItem("Cadastrar");
		mntmCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.add(new TelaCadastroProduto(loja),
						"CadastrarProduto");
				CardLayout cl = (CardLayout) (contentPane.getLayout());
				cl.show(contentPane, "CadastrarProduto");
				frame.validate();
			}
		});
		mnProduto.add(mntmCadastrar_1);

		JMenuItem mntmConsultar_2 = new JMenuItem("Consultar");
		mntmConsultar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.add(new TelaConsultaProduto(loja),
						"ConsultarProduto");
				CardLayout cl = (CardLayout) (contentPane.getLayout());
				cl.show(contentPane, "ConsultarProduto");
				frame.validate();
			}
		});
		mnProduto.add(mntmConsultar_2);

		JMenu mnPedido = new JMenu("Pedido");
		menuBar.add(mnPedido);

		JMenuItem mntmCadastrar_2 = new JMenuItem("Cadastrar");
		mntmCadastrar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane
						.add(new TelaCadastroPedido(loja), "CadastrarPedido");
				CardLayout cl = (CardLayout) (contentPane.getLayout());
				cl.show(contentPane, "CadastrarPedido");
				frame.validate();
			}
		});
		mnPedido.add(mntmCadastrar_2);

		JMenuItem mntmConsultar_1 = new JMenuItem("Consultar");
		mntmConsultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane
						.add(new TelaConsultaPedido(loja), "ConsultarPedido");
				CardLayout cl = (CardLayout) (contentPane.getLayout());
				cl.show(contentPane, "ConsultarPedido");
				frame.validate();
			}
		});
		mnPedido.add(mntmConsultar_1);
		
		JMenuItem mntmApagarPedidosAntigos = new JMenuItem("Apagar Pedidos Entregues");
		mntmApagarPedidosAntigos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loja.limparPedidos();
				JOptionPane.showMessageDialog(frame, "Pedidos entregues foram limpos com sucesso!", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		mnPedido.add(mntmApagarPedidosAntigos);

		JMenu mnTransportadora = new JMenu("Transportadora");
		menuBar.add(mnTransportadora);

		JMenuItem mntmCadastrar_3 = new JMenuItem("Cadastrar");
		mntmCadastrar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.add(new TelaCadastroTransportadora(loja),
						"CadastrarTransportadora");
				CardLayout cl = (CardLayout) (contentPane.getLayout());
				cl.show(contentPane, "CadastrarTransportadora");
				frame.validate();
			}
		});
		mnTransportadora.add(mntmCadastrar_3);

		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.add(new TelaConsultaTransportadora(loja),
						"ConsultarTransportadora");
				CardLayout cl = (CardLayout) (contentPane.getLayout());
				cl.show(contentPane, "ConsultarTransportadora");
				frame.validate();
			}
		});
		mnTransportadora.add(mntmConsultar);

		JMenu mnAjuda = new JMenu("Ajuda");
		mnAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		menuBar.add(mnAjuda);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSobre tsobre = new TelaSobre();
				tsobre.setVisible(true);
			}
		});
		mnAjuda.add(mntmSobre);
	}
}
