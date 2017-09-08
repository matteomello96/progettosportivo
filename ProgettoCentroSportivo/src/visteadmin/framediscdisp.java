package visteadmin;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import classiDAOResponsabile.dettagliiscrizionedao;
import modelliTabelleRespo.modellidettagli;

public class framediscdisp {

	public static JFrame frame;
	
	public JTable table_2;
	private modellidettagli model;
	
	
	public framediscdisp() {
		frame = new JFrame("FrameDettagli");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 700, 400);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		//frame.setAlwaysOnTop(true);
		
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 110, 101, 106, 138, 88, 105, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 213, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Info");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		frame.add(lblNewLabel, gbc_lblNewLabel);
		
		
	
		
		table_2 = new JTable();
	//	model = new modellidettagli(dettagliiscrizionedao.elencoiniziale());
		table_2.setCellSelectionEnabled(true);
		table_2.setModel(model);
		GridBagConstraints gbc_table_2 = new GridBagConstraints();
		gbc_table_2.gridwidth = 3;
		gbc_table_2.insets = new Insets(0, 0, 5, 5);
		gbc_table_2.fill = GridBagConstraints.BOTH;
		gbc_table_2.gridx = 2;
		gbc_table_2.gridy = 2;
		frame.add(table_2, gbc_table_2);
		

		
		
		
		

	

	}
}
