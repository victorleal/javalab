package interfaces;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class TelaInicial extends JPanel {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaInicial() {
		setLayout(new MigLayout("", "[][][grow]", "[grow,center]"));

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaInicial.class
				.getResource("byteforte.png")));
		add(label, "cell 2 0,alignx center");

	}

}
