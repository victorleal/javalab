package auxiliar;

import java.awt.CardLayout;

import javax.swing.JComponent;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class PanelListener implements AncestorListener {

	private CardLayout cl;

	public PanelListener(CardLayout card) {
		this.cl = card;
	}

	@Override
	public void ancestorAdded(AncestorEvent event) {
		JComponent c = event.getComponent();
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
