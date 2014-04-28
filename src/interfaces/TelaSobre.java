package interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaSobre extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaSobre dialog = new TelaSobre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaSobre() {
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[]", "[][][][][][][][][]"));
		{
			JLabel lblByteforteSistemas = new JLabel("ByteForte - Sistemas de Vendas ");
			contentPanel.add(lblByteforteSistemas, "cell 0 0");
		}
		{
			JLabel label = new JLabel("® 2014 ");
			contentPanel.add(label, "cell 0 1");
		}
		{
			JLabel lblFeitoPor = new JLabel("Feito por:");
			contentPanel.add(lblFeitoPor, "cell 0 3");
		}
		{
			JLabel lblGuilhermeNogueira = new JLabel("Guilherme Nogueira");
			contentPanel.add(lblGuilhermeNogueira, "cell 0 4");
		}
		{
			JLabel lblPauloRicardoMaroo = new JLabel("Paulo Ricardo Maroço Paraluppi");
			contentPanel.add(lblPauloRicardoMaroo, "cell 0 5");
		}
		{
			JLabel lblVictorLeal = new JLabel("Victor Leal");
			contentPanel.add(lblVictorLeal, "cell 0 6");
		}
		{
			JLabel lblUniversidadeEstadualDe = new JLabel("Universidade Estadual de Campinas");
			contentPanel.add(lblUniversidadeEstadualDe, "cell 0 8");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Ok, obrigado");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//this.dispose();
						TelaSobre.this.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);

				
				
				
			}
		}
	}

}
