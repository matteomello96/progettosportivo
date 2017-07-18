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
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.TreeSelectionModel;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Component;

public class prova extends JPanel {
	private JTable table;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public prova() {
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(240, 240, 240));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{47, 225, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{50, 0, 0, 21, 33, 96, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		table.setEnabled(false);
		//table.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		//table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "Disciplina ", "orari ", "Livello"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 4;
		gbc_table.fill = GridBagConstraints.HORIZONTAL;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.anchor = GridBagConstraints.NORTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		add(table, gbc_table);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.fill = GridBagConstraints.BOTH;
		gbc_table_1.gridwidth = 4;
		gbc_table_1.insets = new Insets(0, 0, 5, 5);
		gbc_table_1.gridx = 4;
		gbc_table_1.gridy = 1;
		add(table_1, gbc_table_1);
		
		JButton btnDettagliOrario = new JButton("Dettagli orario");
		GridBagConstraints gbc_btnDettagliOrario = new GridBagConstraints();
		gbc_btnDettagliOrario.insets = new Insets(0, 0, 5, 5);
		gbc_btnDettagliOrario.gridx = 1;
		gbc_btnDettagliOrario.gridy = 2;
		add(btnDettagliOrario, gbc_btnDettagliOrario);
		
		JButton Aggiungi = new JButton("Aggiungi");
		GridBagConstraints gbc_Aggiungi = new GridBagConstraints();
		gbc_Aggiungi.gridwidth = 2;
		gbc_Aggiungi.insets = new Insets(0, 0, 5, 5);
		gbc_Aggiungi.gridx = 2;
		gbc_Aggiungi.gridy = 2;
		add(Aggiungi, gbc_Aggiungi);
		
		JButton rimuovi = new JButton("rimuovi");
		GridBagConstraints gbc_rimuovi = new GridBagConstraints();
		gbc_rimuovi.insets = new Insets(0, 0, 5, 5);
		gbc_rimuovi.gridx = 4;
		gbc_rimuovi.gridy = 2;
		add(rimuovi, gbc_rimuovi);
		
		JButton svuotacarrello = new JButton("svuotacarrello");
		GridBagConstraints gbc_svuotacarrello = new GridBagConstraints();
		gbc_svuotacarrello.insets = new Insets(0, 0, 5, 5);
		gbc_svuotacarrello.gridx = 5;
		gbc_svuotacarrello.gridy = 2;
		add(svuotacarrello, gbc_svuotacarrello);
		
		JButton invia = new JButton("invia");
		GridBagConstraints gbc_invia = new GridBagConstraints();
		gbc_invia.insets = new Insets(0, 0, 5, 5);
		gbc_invia.gridx = 6;
		gbc_invia.gridy = 2;
		add(invia, gbc_invia);
	

	}

}
