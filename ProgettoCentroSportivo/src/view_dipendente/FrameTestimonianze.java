package view_dipendente;

import javax.swing.JPanel;

import ClassiDaoTesserato.TestimnianzaDao;
import ClassiDaoTesserato.TriggerOrdine;

import java.awt.GridBagLayout;

import java.awt.GridBagConstraints;

import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;

public class FrameTestimonianze extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	public static JFrame frame;
	public static Combotest combotest;
	public static String disciplina;
	public static Comboliv comboliv;
	public static String livello;
	public static String commento;
	
	
	
	
	public FrameTestimonianze() {
		
		frame = new JFrame("Testimonianze");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 705, 391);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		frame.setAlwaysOnTop(true);
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 93, 96, 83, 42, 70, 0, 37, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 177, 81, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Testimonianze");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 0;
		frame.add(lblNewLabel, gbc_lblNewLabel);
		
	    JEditorPane editorPane = new JEditorPane();
		GridBagConstraints gbc_editorPane = new GridBagConstraints();
		gbc_editorPane.gridwidth = 7;
		gbc_editorPane.insets = new Insets(0, 0, 5, 5);
		gbc_editorPane.fill = GridBagConstraints.BOTH;
		gbc_editorPane.gridx = 0;
		gbc_editorPane.gridy = 3;
		frame.add(editorPane, gbc_editorPane);
		
		JLabel lblNewLabel_1 = new JLabel("Inserisci la tua testimonianza");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridwidth = 4;
		gbc_lblNewLabel_1.gridx = 7;
		gbc_lblNewLabel_1.gridy = 3;
		frame.add(lblNewLabel_1, gbc_lblNewLabel_1);
			
			
			
			combotest = new Combotest();
			 combotest.setEnabled(true);
			 GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.gridwidth = 3;
				gbc_comboBox.insets = new Insets(0, 0, 5, 5);
				gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox.gridx = 1;
				gbc_comboBox.gridy = 4;
				frame.add(combotest, gbc_comboBox);
				
				comboliv = new Comboliv();
				 comboliv.setEnabled(true);
				GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
				gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
				gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox_1.gridx = 4;
				gbc_comboBox_1.gridy = 4;
				frame.add(comboliv, gbc_comboBox_1);
				
				
				
				JButton btnNewButton = new JButton("invia");
				GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
				gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
				gbc_btnNewButton.gridx = 5;
				gbc_btnNewButton.gridy = 4;
				frame.add(btnNewButton, gbc_btnNewButton);

			
			
			
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					disciplina=combotest.getSelectedItem().toString();
					livello=comboliv.getSelectedItem().toString();
					commento=editorPane.getText();
//JOptionPane.showMessageDialog(null, "Il nome utente \""+disciplina+"\" e\\o l'email \""+commento+"\" sono già in uso, sceglierne altri"," ",JOptionPane.WARNING_MESSAGE);				
			   TestimnianzaDao.instest(disciplina,livello,commento);
				
				}
			});
			
			
	frame.addWindowListener(new java.awt.event.WindowAdapter() {
		   @Override
		   public void windowClosing(java.awt.event.WindowEvent windowEvent) 
		    {
		    	if(FrameTesserato.frame!=null)
		    		FrameTesserato.frame.setEnabled(true);
		    
		    }
		});
	
	
	
	}

}
