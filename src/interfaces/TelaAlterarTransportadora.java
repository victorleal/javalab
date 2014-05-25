package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import net.miginfocom.swing.MigLayout;
import core.Loja;
import core.Transportadora;
import exceptions.ParametroException;

public class TelaAlterarTransportadora extends GeneralPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// textFields
	private JTextField txtPrazoEntrega;
	private JTextField txtValorFrete;
	private JTextField txtNome;
	private JFormattedTextField txtCnpj;
	private JTextField txtRazaoSocial;

	// Labels
	private JLabel lblPrazoMximoDe;
	private JLabel lblValorDoFrete;
	private JLabel lblCnpj;
	private JLabel lblNome;
	private JLabel lblRazoSocial;

	// Mascara
	private MaskFormatter mascaraCnpj;
	private MaskFormatter mascaraTelefone;
	private MaskFormatter mascaraCEP;

	// Buttons
	private JButton btnCancelar;
	private JButton btnSalvar;

	// Controla a Transportadora
	Transportadora t;

	


	/**
	 * Create the panel.
	 */
	public TelaAlterarTransportadora(Loja l) {
		super(l);
		t = loja.getTransportadoraAlteracao();

		setBorder(new TitledBorder(null, "Alterar Transportadora",
				TitledBorder.LEADING, TitledBorder.TOP, this.fonte));
		setLayout(new MigLayout("", "[][grow]", "[][][][][][grow,bottom]"));
		
		try {
			mascaraCnpj = new MaskFormatter("##.###.###/####-##");
			mascaraCnpj.setPlaceholderCharacter('_');
			mascaraTelefone = new MaskFormatter("(##)####-####");
			mascaraTelefone.setPlaceholderCharacter('_');
			mascaraCEP = new MaskFormatter("#####-###");
			mascaraCEP.setPlaceholderCharacter('_');
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		lblNome = new JLabel("Nome Fantasia:");
		add(lblNome, "cell 0 0,alignx trailing");
		
		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setEditable(false);
		add(txtNome, "cell 1 0,growx");
		txtNome.setText(t.getNomeFantasia());
		txtNome.setColumns(10);
		
		lblRazoSocial = new JLabel("Razão Social:");
		add(lblRazoSocial, "cell 0 1,alignx trailing");
		
		txtRazaoSocial = new JTextField();
		txtRazaoSocial.setEnabled(false);
		txtRazaoSocial.setEditable(false);
		txtRazaoSocial.setText(t.getRazaoSocial());
		add(txtRazaoSocial, "cell 1 1,growx");
		txtRazaoSocial.setColumns(10);
		
		lblCnpj = new JLabel("CNPJ:");
		add(lblCnpj, "cell 0 2,alignx trailing");
		
		txtCnpj = new JFormattedTextField(mascaraCnpj);
		txtCnpj.setEditable(false);
		txtCnpj.setEnabled(true);
		txtCnpj.setText(t.getCnpj());
		add(txtCnpj, "cell 1 2,growx");
		txtCnpj.setColumns(10);

		lblPrazoMximoDe = new JLabel("Prazo Máximo de Entrega:");
		add(lblPrazoMximoDe, "cell 0 3,alignx trailing");

		txtPrazoEntrega = new JTextField();
		txtPrazoEntrega
				.setText(String.valueOf(new Integer(t.getPrazoEntrega())));
		add(txtPrazoEntrega, "cell 1 3,growx");
		txtPrazoEntrega.setColumns(10);

		lblValorDoFrete = new JLabel("Taxa de Entrega (%):");
		add(lblValorDoFrete, "cell 0 4,alignx trailing");

		txtValorFrete = new JTextField();
		txtValorFrete.setText(String.valueOf(new Double(t.getTaxaEntrega())));
		add(txtValorFrete, "cell 1 4,growx");
		txtValorFrete.setColumns(10);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTela("ConsultarTransportadora");
			}
		});
		add(btnCancelar, "flowx,cell 0 5 2 1,alignx right,aligny bottom");

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try{
				int prazoEntrega = Integer.parseInt(txtPrazoEntrega.getText());
				double taxaEntrega = Double.parseDouble(txtValorFrete.getText());
			
				loja.alterarTransportadora(t, taxaEntrega);
				loja.alterarTransportadora(t, prazoEntrega);

				showMensagemSucesso("Transportadora alterada com sucesso!");
				//showTelaPrincipal(); 
				showTela("ConsultarTransportadora");
			} catch (NumberFormatException nfe) {
				showMensagemErro("Por favor verifique o preenchimento dos campos Prazo de Entrega e Taxa de Entrega!");
			} catch (ParametroException exception) {
				showMensagemErro(exception.getMessage());
			}
			}
		});
		add(btnSalvar, "cell 0 5 2 1,alignx right,aligny bottom");

	}

	@Override
	public void limparCampos() {
		// TODO Auto-generated method stub

	}

}
