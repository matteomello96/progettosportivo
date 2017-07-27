import javax.swing.JPanel;
import java.awt.GridBagLayout;

import java.awt.GridBagConstraints;

import java.awt.Insets;





import javax.swing.JLabel;
import javax.swing.JEditorPane;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import ComboTesserato.Combogiorno;
import ComboTesserato.Comboorario;
import view_tesserato.FrameTesserato;

public class prova extends JPanel {
	private static JComboBox  JCombobox ;
	private static JComboBox Combogiorno; 
	private JTable table;
	private JTable table_2;
	
	/**
	 * Create the panel.
	 */
	public prova() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{42, 0, 158, 0, 148, 75, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 36, 40, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Scelta turno");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
			JLabel lblNewLabel_1 = new JLabel("Sei iscritto a:");
			lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.gridwidth = 2;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 2;
			add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		add(comboBox, gbc_comboBox);
			
			JLabel lblNewLabel_2 = new JLabel("Livello:");
			lblNewLabel_2.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.gridwidth = 2;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 3;
			add(lblNewLabel_2, gbc_lblNewLabel_2);
			
			JComboBox comboBox_3 = new JComboBox();
			GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
			gbc_comboBox_3.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox_3.gridx = 2;
			gbc_comboBox_3.gridy = 3;
			add(comboBox_3, gbc_comboBox_3);
			
			JLabel lblNewLabel_3 = new JLabel("Orario:");
			lblNewLabel_3.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.gridwidth = 2;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 0;
			gbc_lblNewLabel_3.gridy = 4;
			add(lblNewLabel_3, gbc_lblNewLabel_3);
			
			JComboBox comboBox_1 = new JComboBox();
			GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
			gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox_1.gridx = 2;
			gbc_comboBox_1.gridy = 4;
			add(comboBox_1, gbc_comboBox_1);
			
			JLabel lblNewLabel_4 = new JLabel("Giorno:");
			lblNewLabel_4.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.gridwidth = 2;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 0;
			gbc_lblNewLabel_4.gridy = 5;
			add(lblNewLabel_4, gbc_lblNewLabel_4);
			
			JComboBox comboBox_2 = new JComboBox();
			GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
			gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox_2.gridx = 2;
			gbc_comboBox_2.gridy = 5;
			add(comboBox_2, gbc_comboBox_2);
		
		

			
			JButton btnNewButton = new JButton("Conferma");
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
			gbc_btnNewButton.gridx = 2;
			gbc_btnNewButton.gridy = 7;
			add(btnNewButton, gbc_btnNewButton);
			
			JButton btnNewButton_1 = new JButton("New button");
			GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
			gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
			gbc_btnNewButton_1.gridx = 4;
			gbc_btnNewButton_1.gridy = 7;
			add(btnNewButton_1, gbc_btnNewButton_1);
			
			
			
	}
}
