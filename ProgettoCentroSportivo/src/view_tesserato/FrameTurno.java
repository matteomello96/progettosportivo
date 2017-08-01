package view_tesserato;


import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import ClassiDaoTesserato.Invia_Turno_Dao;

import ComboTesserato.Combodis;
import ComboTesserato.Combogiorno;
import ComboTesserato.Comboorario;
import ComboTesserato.combolivello;



public class FrameTurno extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public JButton btnNewButton;
	public static JFrame frame;
	public static Comboorario Comboorario;
	public static Combogiorno Combogiorno;
	public static Combodis Combodis;
	public static combolivello Combolivello;
	public String disciplina;
	public String livello;
	public String ora;
	public String giorno;
	public JButton btnNewButton_1;
	

	public FrameTurno(String disciplina2, String livello2, String giorno2, String ora2) {
		final DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		
		frame = new JFrame("Testimonianze");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 605, 391);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		frame.setAlwaysOnTop(true);
		
		
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{42, 0, 158, 0, 148, 75, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 36, 40, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.setLayout(gridBagLayout);	
		
		JLabel lblNewLabel = new JLabel("Scelta turno");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		frame.add(lblNewLabel, gbc_lblNewLabel);
	
		JLabel lblNewLabel_1 = new JLabel("Sei iscritto a:");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		frame.add(lblNewLabel_1, gbc_lblNewLabel_1);
			
		
		
	
		

		
		 Combodis = new Combodis();
		 Combodis.setEnabled(true);
		 GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 2;
			gbc_comboBox.gridy = 2;
			frame.add(Combodis, gbc_comboBox);
		
			JLabel lblNewLabel_2 = new JLabel("Livello:");
			lblNewLabel_2.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.gridwidth = 2;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 3;
			frame.add(lblNewLabel_2, gbc_lblNewLabel_2);
			
			
			
			Combolivello = new combolivello(disciplina2);
			 Combolivello.setEnabled(false);
			 GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
				gbc_comboBox_3.insets = new Insets(0, 0, 5, 5);
				gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox_3.gridx = 2;
				gbc_comboBox_3.gridy = 3;
				frame.add(Combolivello, gbc_comboBox_3);
				
				
				JLabel lblNewLabel_4 = new JLabel("Orario:");
				lblNewLabel_4.setFont(new Font("Sylfaen", Font.PLAIN, 18));
				GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
				gbc_lblNewLabel_4.gridwidth = 2;
				gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_4.gridx = 0;
				gbc_lblNewLabel_4.gridy = 5;
				frame.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		 Comboorario = new Comboorario(livello2,disciplina2,giorno2);
		 Comboorario.setEnabled(false);
		 
		 GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
			gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox_2.gridx = 2;
			gbc_comboBox_2.gridy = 5;
			frame.add(Comboorario, gbc_comboBox_2);
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
			frame.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		
		
		      Combogiorno = new Combogiorno(livello2,disciplina2);
		      Combogiorno.setEnabled(false);
		      GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
				gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
				gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox_1.gridx = 2;
				gbc_comboBox_1.gridy = 4;
				frame.add(Combogiorno, gbc_comboBox_1);
				
			

			btnNewButton = new JButton("step successivo>>");
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
			gbc_btnNewButton.gridx = 2;
			gbc_btnNewButton.gridy = 7;
			  btnNewButton.setEnabled(true);
			frame.add(btnNewButton, gbc_btnNewButton);
			
			
			
			

			
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					disciplina=Combodis.getSelectedItem().toString();
					livello=Combolivello.getSelectedItem().toString();
					ora=Comboorario.getSelectedItem().toString();
					giorno=Combogiorno.getSelectedItem().toString();
				
					  btnNewButton.setEnabled(true);
					
					if(disciplina2=="null"){
					if(disciplina=="disciplina"){
						JOptionPane.showMessageDialog(FrameTurno.frame, "perfavore inserisci una disciplina"," ",JOptionPane.WARNING_MESSAGE);				
					}	
						
					else{		
					frame.dispose();
				  
					new FrameTurno(disciplina,livello,giorno,ora);	
					Combodis.setEnabled(false);
					Combolivello.setEnabled(true);
					Comboorario.setEnabled(false);
					Combogiorno.setEnabled(false);
					
					}
					} 
					else if(livello2=="livello"){
						
						if(livello=="livello"){
							JOptionPane.showMessageDialog(FrameTurno.frame, "perfavore inserisci un livello"," ",JOptionPane.WARNING_MESSAGE);				
						}	
						else{
						frame.dispose();
						new FrameTurno(disciplina2,livello,giorno,ora);	
						Combodis.setEnabled(false);
						Combolivello.setEnabled(false);
						Comboorario.setEnabled(false);
						Combogiorno.setEnabled(true);
						
						}
					}
					
			
					else if(giorno2=="giorno"&& livello=="livello"){
						
						if(giorno=="giorno"){
							JOptionPane.showMessageDialog(FrameTurno.frame, "perfavore inserisci correttamente il giorno"," ",JOptionPane.WARNING_MESSAGE);				
						}	
						else{
						frame.dispose();
						
						new FrameTurno(disciplina2,livello2,giorno,ora);	
						Combodis.setEnabled(false);
						Combolivello.setEnabled(false);
						Comboorario.setEnabled(true);
						Combogiorno.setEnabled(false);
					  
						}
						
					}
					else{
						
						if(ora=="orario"){
							JOptionPane.showMessageDialog(FrameTurno.frame, "perfavore inserisci un orario corretto"," ",JOptionPane.WARNING_MESSAGE);				
						}
						else{
					   Invia_Turno_Dao.Invia(disciplina2,livello2,giorno2,ora);
						
					
						
						
				
						}
					}
				
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
