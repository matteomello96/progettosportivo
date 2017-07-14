import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JMenu;
import java.awt.GridBagConstraints;
import javax.swing.JMenuBar;
import java.awt.Insets;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class prova extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public prova() {
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(240, 240, 240));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{47, 225, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{50, 0, 0, 21, 33, 96, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Disciplina ", "orari ", "Livello"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.anchor = GridBagConstraints.NORTHWEST;
		gbc_table.gridx = 1;
		gbc_table.gridy = 1;
		add(table, gbc_table);

	}

}
