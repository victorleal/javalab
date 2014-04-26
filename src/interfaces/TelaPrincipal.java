package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	static TelaPrincipal frame;
	
	final static TelaConsultaTransportadora tcontrans = new TelaConsultaTransportadora ();
	final static TelaCadastroTransportadora tcadtrans = new TelaCadastroTransportadora ();
	final static TelaConsultaPedido tconped = new TelaConsultaPedido();
	final static TelaControle tcont= new TelaControle();
	final static TelaConsultaCliente tconcli = new TelaConsultaCliente();
	final static TelaCadastroProduto tcadprod = new TelaCadastroProduto();
	final static TelaCadastroPedido tcadped = new TelaCadastroPedido();
	final static TelaConsultaProduto tconprod = new TelaConsultaProduto();
	final static TelaCadastroCliente tcadcli = new TelaCadastroCliente();
	
	final static TelaAlterarCliente taltcli = new TelaAlterarCliente();
	final static TelaAlterarProduto taltprod = new TelaAlterarProduto();
	final static TelaAlterarTransportadora talttrans = new TelaAlterarTransportadora();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		setLookAndFeel();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new TelaPrincipal("ByteForte - Sitema de Vendas");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 * @param titulo 
	 */
	public TelaPrincipal(String titulo) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				frame.setIconImage(new ImageIcon(getClass().getResource("computer.png")).getImage());
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		setTitle(titulo);
		
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
				EscondePaineis();
				frame.getContentPane().add(tcont);
				tcont.setVisible(true);
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
				EscondePaineis();
				frame.getContentPane().add(tcadcli);
				tcadcli.setVisible(true);
				frame.validate();
				
			}
		});
		mnCliente.add(mntmCadastrar);
		
		JMenuItem mntmConsultar_3 = new JMenuItem("Consultar");
		mntmConsultar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EscondePaineis();
				frame.getContentPane().add(tconcli);
				tconcli.setVisible(true);
				frame.validate();
				
			}
		});
		mnCliente.add(mntmConsultar_3);
		
		JMenu mnProduto = new JMenu("Produto");
		menuBar.add(mnProduto);
	
		JMenuItem mntmCadastrar_1 = new JMenuItem("Cadastrar");
		mntmCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EscondePaineis();
				frame.getContentPane().add(tcadprod);
				tcadprod.setVisible(true);
				frame.validate();
				
			}
		});
		mnProduto.add(mntmCadastrar_1);
		
		JMenuItem mntmConsultar_2 = new JMenuItem("Consultar");
		mntmConsultar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EscondePaineis();
				frame.getContentPane().add(tconprod);
				tconprod.setVisible(true);
				frame.validate();
			}
		});
		mnProduto.add(mntmConsultar_2);
		
		JMenu mnPedido = new JMenu("Pedido");
		menuBar.add(mnPedido);
		
		JMenuItem mntmCadastrar_2 = new JMenuItem("Cadastrar");
		mntmCadastrar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EscondePaineis();
				frame.getContentPane().add(tcadped);
				tcadped.setVisible(true);
				frame.validate();
			}
		});
		mnPedido.add(mntmCadastrar_2);
		
		JMenuItem mntmConsultar_1 = new JMenuItem("Consultar");
		mntmConsultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EscondePaineis();
				frame.getContentPane().add(tconped);
				tconped.setVisible(true);
				frame.validate();
			}
		});
		mnPedido.add(mntmConsultar_1);
		
		JMenu mnTransportadora = new JMenu("Transportadora");
		menuBar.add(mnTransportadora);
		
		JMenuItem mntmCadastrar_3 = new JMenuItem("Cadastrar");
		mntmCadastrar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EscondePaineis();
				frame.getContentPane().add(tcadtrans);
				tconped.setVisible(true);
				frame.validate();
			}
		});
		mnTransportadora.add(mntmCadastrar_3);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EscondePaineis();
				frame.getContentPane().add(tcontrans);
				tconped.setVisible(true);
				frame.validate();
			}
		});
		mnTransportadora.add(mntmConsultar);
		
		JMenu mnSobre = new JMenu("Sobre");
		menuBar.add(mnSobre);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	public static void EscondePaineis() 
	{
		frame.remove(tcontrans);
		frame.remove(tcadtrans);
		frame.remove(tconped);
		frame.remove(tcadped);
		frame.remove(tcadprod);
		frame.remove(tconprod);
		frame.remove(tconcli);
		frame.remove(tcadcli);
		frame.remove(tcont);
		frame.remove(taltcli);
		frame.remove(talttrans);
		frame.remove(taltprod);
		
		frame.repaint();
	}
	
	

}
