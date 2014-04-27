package auxiliar;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import core.Transportadora;

public class ComboBoxTransportadoraRenderer extends JLabel implements
		ListCellRenderer<Transportadora> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(
			JList<? extends Transportadora> list, Transportadora value,
			int index, boolean isSelected, boolean cellHasFocus) {
		Transportadora t = (Transportadora) value;
		setText(t.getNomeFantasia());
		return this;
	}
}
