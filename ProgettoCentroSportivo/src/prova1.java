import java.awt.BorderLayout;


import javax.swing.JButton;
import javax.swing.JDialog;


import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

public class prova1 extends JDialog {
	private JLabel lblNewLabel;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			prova1 dialog = new prova1();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public prova1() {
		setBounds(100, 100, 450, 300);
		{
			lblNewLabel = new JLabel("                                                     Sei iscritto alle discipline");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setToolTipText("");
			lblNewLabel.setLabelFor(this);
			getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		}
		{
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null},
					{null, null},
				},
				new String[] {
					"IdDisciplina", "Nomedisciplina"
				}
			));
			getContentPane().add(table, BorderLayout.WEST);
		}
		{
			JComboBox comboBox = new JComboBox();
			getContentPane().add(comboBox, BorderLayout.CENTER);
		}
		{
			JComboBox comboBox = new JComboBox();
			getContentPane().add(comboBox, BorderLayout.EAST);
		}
		{
			JButton btnNewButton = new JButton("Conferma");
			getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		}
	
	}

}
