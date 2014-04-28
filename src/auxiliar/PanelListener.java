package auxiliar;

import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class PanelListener implements AncestorListener {

	private JPanel panel;

	public PanelListener(JPanel panel) {
		this.panel = panel;
	}

	@Override
	public void ancestorAdded(AncestorEvent arg0) {System.out.println("Added");
		panel.invalidate();
		panel.revalidate();
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
