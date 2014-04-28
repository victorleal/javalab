package interfaces;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class TelaInicial extends JPanel {

	/**
	 * Create the panel.
	 */
	public TelaInicial() {
		setLayout(new MigLayout("", "[][][grow]", "[grow,center]"));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaInicial.class.getResource("byteforte.png")));
		add(label, "cell 2 0,alignx center");

	}
	
}
	