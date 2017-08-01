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

import ComboTesserato.Combodis;
import ComboTesserato.Combogiorno;
import ComboTesserato.Comboorario;
import ComboTesserato.combolivello;
import ModelliTabelleRespo.modelisc;
import classiDAOResponsabile.RichiesteDao;
import view_tesserato.FrameTesserato;
import java.awt.Color;

public class prova extends JPanel {
	
	private JTable table_2;
	private JTable table;
	
	/**
	 * Create the panel.
	 */
	public prova() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{42, 0, 158, 72, 148, 75, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 36, 40, 0, 0, 0, 0, 119, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
			
		
		
	
		

		
		 JComboBox Combodis = new Combodis();
		 Combodis.setEnabled(true);
		 GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 2;
			gbc_comboBox.gridy = 2;
		add(Combodis, gbc_comboBox);
		
			JLabel lblNewLabel_2 = new JLabel("Livello:");
			lblNewLabel_2.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.gridwidth = 2;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 3;
			add(lblNewLabel_2, gbc_lblNewLabel_2);
			
			
			
			JComboBox Combolivello=new combolivello();
			 Combolivello.setEnabled(false);
			 GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
				gbc_comboBox_3.insets = new Insets(0, 0, 5, 5);
				gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox_3.gridx = 2;
				gbc_comboBox_3.gridy = 3;
				add(Combolivello, gbc_comboBox_3);
				
				
				JLabel lblNewLabel_4 = new JLabel("Orario:");
				lblNewLabel_4.setFont(new Font("Sylfaen", Font.PLAIN, 18));
				GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
				gbc_lblNewLabel_4.gridwidth = 2;
				gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_4.gridx = 0;
				gbc_lblNewLabel_4.gridy = 5;
				add(lblNewLabel_4, gbc_lblNewLabel_4);
		
				JComboBox Comboorario = new Comboorario();
		 Comboorario.setEnabled(false);
		 
		 GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
			gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox_2.gridx = 2;
			gbc_comboBox_2.gridy = 5;
			add(Comboorario, gbc_comboBox_2);
		// Comboorario.addItemListener(new ItemListener() {
			//public void itemStateChanged(ItemEvent e) {
			//	if(Comboorario.getSelectedIndex()<=0)
				//	btnConferma.setEnabled(false);
				//else btnConferma.setEnabled(true);
			//}
		//});
		
			JLabel lblNewLabel_3 = new JLabel("Giorno:");
			lblNewLabel_3.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.gridwidth = 2;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 0;
			gbc_lblNewLabel_3.gridy = 4;
			add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		
		
			JComboBox Combogiorno = new Combogiorno();
		      Combogiorno.setEnabled(false);
		      GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
				gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
				gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox_1.gridx = 2;
				gbc_comboBox_1.gridy = 4;
			add(Combogiorno, gbc_comboBox_1);
				
			

			JButton btnNewButton = new JButton("step successivo>>");
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
			gbc_btnNewButton.gridx = 2;
			gbc_btnNewButton.gridy = 7;
			 
			add(btnNewButton, gbc_btnNewButton);
			
			table = new JTable();
			GridBagConstraints gbc_table = new GridBagConstraints();
			gbc_table.gridwidth = 3;
			gbc_table.insets = new Insets(0, 0, 0, 5);
			gbc_table.fill = GridBagConstraints.BOTH;
			gbc_table.gridx = 2;
			gbc_table.gridy = 9;
			add(table, gbc_table);
			
			
			
			
	}
}
