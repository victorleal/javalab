package auxiliar;

import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TableModel(int numRows, String[] cabecalho) {
		super(numRows, cabecalho.length);
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
