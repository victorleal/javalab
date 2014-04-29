package auxiliar;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JTextField;

public class SelectListener implements ItemListener {
	private String expectedAnswer;
	private ArrayList<JComponent> components;

	public SelectListener(String expectedAnswer,
			ArrayList<JComponent> components) {
		this.expectedAnswer = expectedAnswer;
		this.components = components;
	}

	public void enableComponents() {
		if (components != null) {
			for (JComponent component : components) {
				component.setEnabled(true);
			}
		}
	}

	public void disableComponents() {
		if (components != null) {
			for (JComponent component : components) {
				component.setEnabled(false);
				if (component instanceof JTextField) {
					((JTextField) component).setText("");
				}
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent itemEvent) {
		if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
			String item = (String) itemEvent.getItem();
			if (item.equals(expectedAnswer)) {
				enableComponents();
			} else {
				disableComponents();
			}
		}
	}

}
