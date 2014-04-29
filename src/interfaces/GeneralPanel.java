package interfaces;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import core.Loja;

public abstract class GeneralPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Controla o parent
	private Container parent;

	// Controla o CardLayout
	private CardLayout cl;

	// Controla o panel
	protected JPanel panel;

	// Controla a loja
	protected Loja loja;

	// Controla a fonte
	protected Font fonte;

	public GeneralPanel(Loja l) {
		this.loja = l;
		panel = this;
		panel.addAncestorListener(new AtivoListener());
		fonte = new Font("Tahoma", Font.PLAIN, 16);
	}

	public abstract void limparCampos();
	
	public void inicializar(){
		
	}

	public void addTela(JComponent tela, String nome) {
		parent = panel.getParent();
		parent.add(tela, nome);
	};

	public void showTela(String tela) {
		parent = panel.getParent();
		cl = (CardLayout) parent.getLayout();
		cl.show(parent, tela);
	}

	public void showTelaPrincipal(boolean removerPanel) {
		parent = panel.getParent();
		cl = (CardLayout) parent.getLayout();
		cl.show(parent, "Inicial");

		/*
		 * Removemos os paineis que sofrem influencia de cadastro/alteracao em
		 * outros paineis.
		 */
		if (removerPanel) {
			cl.removeLayoutComponent(panel);
		}
	}

	public void showMensagemSucesso(String mensagem) {
		JOptionPane.showMessageDialog(panel, mensagem, "Sucesso",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void showMensagemErro(String mensagem) {
		JOptionPane.showMessageDialog(panel, mensagem, "Atenção",
				JOptionPane.ERROR_MESSAGE);
	}

	class AtivoListener implements AncestorListener {

		@Override
		public void ancestorAdded(AncestorEvent arg0) {
			limparCampos();
			inicializar();
		}

		@Override
		public void ancestorMoved(AncestorEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void ancestorRemoved(AncestorEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

}
