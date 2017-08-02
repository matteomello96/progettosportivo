package view_tesserato;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;


import ClassiDaoTesserato.elencoattivitaattivedao;
import ModelliTabelle_Tesserato.disc_attive;


public class FrameDiscAttive extends JPanel {

public static JTable table_1;
public static JFrame frame;
private disc_attive model;
/**
 * Create the panel.
 */
public FrameDiscAttive() {
	
	
	
	frame = new JFrame("Riepilogo");
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setBounds(100, 100, 605, 391);
	frame.setVisible(true);
	frame.setAutoRequestFocus(true);
	frame.setResizable(true);
	frame.setAlwaysOnTop(true);
	
	
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[]{0, 66, 69, 93, 96, 83, 80, 96, 81, 37, 0};
	gridBagLayout.rowHeights = new int[]{0, 0, 123, 95, 49, 64, 0};
	gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	frame.setLayout(gridBagLayout);
	
		
		
	JLabel lblNewLabel_1 = new JLabel("STATO ISCRIZIONE");
	lblNewLabel_1.setForeground(Color.BLACK);
	lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
	GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
	gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
	gbc_lblNewLabel_1.gridwidth = 4;
	gbc_lblNewLabel_1.gridx = 3;
	gbc_lblNewLabel_1.gridy = 0;
	frame.add(lblNewLabel_1, gbc_lblNewLabel_1);
	
	table_1 = new JTable();
	model = new disc_attive(elencoattivitaattivedao.elencoiniziale());
	table_1.setCellSelectionEnabled(true);
	table_1.setModel(model);
	GridBagConstraints gbc_table_1 = new GridBagConstraints();
	gbc_table_1.gridheight = 2;
	gbc_table_1.gridwidth = 6;
	gbc_table_1.insets = new Insets(0, 0, 5, 5);
	gbc_table_1.fill = GridBagConstraints.BOTH;
	gbc_table_1.gridx = 2;
	gbc_table_1.gridy = 2;
	frame.add(table_1, gbc_table_1);

		
		
		
		
}
}
