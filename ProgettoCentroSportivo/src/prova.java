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
import java.awt.Color;

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
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 93, 96, 83, 42, 70, 0, 37, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 177, 81, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Testimonianze");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
			
			
		
		JEditorPane dtrpnScriviUnCommento = new JEditorPane();
		dtrpnScriviUnCommento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dtrpnScriviUnCommento.setText("Scrivi un commento...");
		GridBagConstraints gbc_dtrpnScriviUnCommento = new GridBagConstraints();
		gbc_dtrpnScriviUnCommento.gridwidth = 7;
		gbc_dtrpnScriviUnCommento.insets = new Insets(0, 0, 5, 5);
		gbc_dtrpnScriviUnCommento.fill = GridBagConstraints.BOTH;
		gbc_dtrpnScriviUnCommento.gridx = 0;
		gbc_dtrpnScriviUnCommento.gridy = 3;
		
		add(dtrpnScriviUnCommento, gbc_dtrpnScriviUnCommento);
			
			JComboBox comboBox_3 = new JComboBox();
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.gridwidth = 3;
			gbc_comboBox.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 1;
			gbc_comboBox.gridy = 4;
			add(comboBox_3, gbc_comboBox);
	
			
			JComboBox comboliv = new JComboBox();
			GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
			gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox_1.gridx = 4;
			gbc_comboBox_1.gridy = 4;
			add(comboliv, gbc_comboBox_1);
			
			JButton btnNewButton = new JButton("invia");
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
			gbc_btnNewButton.gridx = 5;
			gbc_btnNewButton.gridy = 4;
		add(btnNewButton, gbc_btnNewButton);
		
			
			
		JLabel lblNewLabel_1 = new JLabel("Inserisci la tua testimonianza");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridwidth = 4;
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 5;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

			
			
			
			
	}
}
