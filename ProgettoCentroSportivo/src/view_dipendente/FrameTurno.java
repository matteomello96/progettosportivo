package view_dipendente;


import javax.swing.JButton;
import javax.swing.JDialog;


import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

public class FrameTurno {
	private JLabel lblNewLabel;
	private JTable table;
	public JComboBox<Object> comboBox ;
	public JButton btnNewButton;
	public static JDialog frame;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public FrameTurno() {
		final DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		
		frame = new JDialog(FrameTesserato.frame,true);
		frame.setTitle("Scegli orario e giorno");
		frame.setBounds(100, 100, 803, 364);
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
		frame.setResizable(false);
		
		{
			lblNewLabel = new JLabel("                                                     Sei iscritto alle discipline");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

			frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
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
			frame.getContentPane().add(table, BorderLayout.WEST);
		}
		{
			 comboBox = new JComboBox<Object>();
			frame.getContentPane().add(comboBox, BorderLayout.CENTER);
		}
		{
			comboBox = new JComboBox<Object>();
			frame.getContentPane().add(comboBox, BorderLayout.EAST);
		}
		{
			btnNewButton = new JButton("Conferma");
			frame.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		}
	
	}

}
