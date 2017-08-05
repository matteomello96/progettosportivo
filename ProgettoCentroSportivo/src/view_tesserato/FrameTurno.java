package view_tesserato;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import ClassiDao.GetInfoDB;
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
    public JPanel contentPane;
	private int codiceturno;
	private int postidisponibili;

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
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (255,36,0));
		contentPane.setLayout(new GridBagLayout());
		
		
		
		
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
	    
	    
	    GridBagConstraints gbc = new GridBagConstraints();
	    
	    
		
		JLabel lblNewLabel = new JLabel("Scelta turno");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 25));
		
		gbc.gridwidth = 2;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 0;
		contentPane.add(lblNewLabel, gbc);
	
		JLabel lblNewLabel_1 = new JLabel("Sei iscritto a:");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		
		gbc.gridwidth = 2;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc);
			
		
		
	
		

		
		 Combodis = new Combodis();
		 Combodis.setEnabled(true);
		
			gbc.insets = new Insets(0, 0, 5, 5);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 2;
			gbc.gridy = 2;
			contentPane.add(Combodis, gbc);
		
			JLabel lblNewLabel_2 = new JLabel("Livello:");
			lblNewLabel_2.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			
			gbc.gridwidth = 2;
			gbc.insets = new Insets(0, 0, 5, 5);
			gbc.gridx = 0;
			gbc.gridy = 3;
			contentPane.add(lblNewLabel_2, gbc);
			
			
			
			Combolivello = new combolivello(disciplina2);
			 Combolivello.setEnabled(false);
			
				gbc.insets = new Insets(0, 0, 5, 5);
				gbc.fill = GridBagConstraints.HORIZONTAL;
				gbc.gridx = 2;
				gbc.gridy = 3;
				contentPane.add(Combolivello, gbc);
				
				
				JLabel lblNewLabel_4 = new JLabel("Orario:");
				lblNewLabel_4.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			
				gbc.gridwidth = 2;
				gbc.insets = new Insets(0, 0, 5, 5);
				gbc.gridx = 0;
				gbc.gridy = 5;
				contentPane.add(lblNewLabel_4, gbc);
		
		 Comboorario = new Comboorario(livello2,disciplina2,giorno2);
		 Comboorario.setEnabled(false);
		 
		
			gbc.insets = new Insets(0, 0, 5, 5);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 2;
			gbc.gridy = 5;
			contentPane.add(Comboorario, gbc);
	
			JLabel lblNewLabel_3 = new JLabel("Giorno:");
			lblNewLabel_3.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			
			gbc.gridwidth = 2;
			gbc.insets = new Insets(0, 0, 5, 5);
			gbc.gridx = 0;
			gbc.gridy = 4;
			contentPane.add(lblNewLabel_3, gbc);
		
		
		
		      Combogiorno = new Combogiorno(livello2,disciplina2);
		      Combogiorno.setEnabled(false);
		    
				gbc.insets = new Insets(0, 0, 5, 5);
				gbc.fill = GridBagConstraints.HORIZONTAL;
				gbc.gridx = 2;
				gbc.gridy = 4;
				contentPane.add(Combogiorno, gbc);
				
			

			btnNewButton = new JButton("step successivo>>");
			
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.insets = new Insets(0, 0, 0, 5);
			gbc.gridx = 2;
			gbc.gridy = 7;
			  btnNewButton.setEnabled(true);
			contentPane.add(btnNewButton, gbc);
			
			
		
			
			
			
			

			
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
						
						codiceturno=GetInfoDB.getcodiceturno(disciplina2, livello2, giorno2, ora);
						postidisponibili= GetInfoDB.getprenotazioni(codiceturno)	;
						if(postidisponibili==0){
							JOptionPane.showMessageDialog(FrameTurno.frame, "Posti massimi raggiunti"," ",JOptionPane.WARNING_MESSAGE);	
							frame.dispose();
							new FrameTurno(null,null,null,null);
						}
						else{
					   Invia_Turno_Dao.Invia(disciplina2,livello2,giorno2,ora);
					   JOptionPane.showMessageDialog(FrameTurno.frame, "Giorno e orario inseriti"," ",JOptionPane.INFORMATION_MESSAGE);
						}
						
						
				
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
				    	FrameTesserato.frame.setVisible(true);
				    
				    }
				});
	}

}
