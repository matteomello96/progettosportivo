package view_tesserato;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import ClassiDao.GetInfoDB;
import ClassiDaoTesserato.TestimnianzaDao;
import ClassiDaoTesserato.TriggerOrdine;
import ComboTesserato.Comboliv;
import ComboTesserato.Combotest;
import Model.Utente;

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
	public JPanel contentPane;
	
	
	
	
	public FrameTestimonianze(String Disciplina,String Livello,String Commento) {
		
		frame = new JFrame("Testimonianze");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 705, 391);
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
		
		JLabel lblNewLabel = new JLabel("Testimonianze");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	
		gbc.gridwidth = 2;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 4;
		gbc.gridy = 0;
		contentPane.add(lblNewLabel, gbc);
		
		JEditorPane editorPane = new JEditorPane();
		
		editorPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editorPane.setText("Scrivi un commento...");
		gbc.gridwidth = 7;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 3;
		
		contentPane.add(editorPane, gbc);
		
		
			
			
			
			combotest = new Combotest();
			 combotest.setEnabled(true);
				
				gbc.gridwidth = 3;
				gbc.insets = new Insets(0, 0, 5, 5);
				gbc.fill = GridBagConstraints.HORIZONTAL;
				gbc.gridx = 1;
				gbc.gridy = 4;
				contentPane.add(combotest, gbc);
		
				
				comboliv = new Comboliv(disciplina);
				 comboliv.setEnabled(true);
				
					gbc.insets = new Insets(0, 0, 5, 5);
					gbc.fill = GridBagConstraints.HORIZONTAL;
					gbc.gridx = 4;
					gbc.gridy = 4;
					contentPane.add(comboliv, gbc);
					
				combotest.setEnabled(true);
				comboliv.setEnabled(false);
				disciplina=combotest.getSelectedItem().toString();
				livello=comboliv.getSelectedItem().toString();
				commento=editorPane.getText();
				
				
				JButton btnNewButton = new JButton("invia");
				
				gbc.insets = new Insets(0, 0, 5, 5);
				gbc.gridx = 5;
				gbc.gridy = 7;
				contentPane.add(btnNewButton, gbc);

			
			JLabel lblNewLabel_1 = new JLabel("seleziona disciplina");
			lblNewLabel_1.setForeground(Color.black);
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			
			gbc.insets = new Insets(0, 0, 0, 5);
			gbc.gridwidth = 4;
			gbc.gridx = 3;
			gbc.gridy = 5;
			contentPane.add(lblNewLabel_1, gbc);
			lblNewLabel_1.setVisible(true);
			
			JLabel lblNewLabel_2 = new JLabel("seleziona livello");
			lblNewLabel_2.setForeground(Color.black);
			lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
			gbc.insets = new Insets(0, 0, 0, 5);
			gbc.gridwidth = 4;
			gbc.gridx = 3;
			gbc.gridy = 5;
			contentPane.add(lblNewLabel_2, gbc);
			
			
			JLabel lblNewLabel_3 = new JLabel("Inserisci la tua testimonianza");
			lblNewLabel_3.setForeground(Color.black);
			lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			
			gbc.insets = new Insets(0, 0, 0, 5);
			gbc.gridwidth = 4;
			gbc.gridx = 3;
			gbc.gridy = 5;
			contentPane.add(lblNewLabel_3, gbc);
			
			
			JLabel lblNewLabel_4 = new JLabel("Conferma l'invio testimonianza");
			lblNewLabel_4.setForeground(Color.black);
			lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			
			gbc.insets = new Insets(0, 0, 0, 5);
			gbc.gridwidth = 4;
			gbc.gridx = 3;
			gbc.gridy = 5;
			contentPane.add(lblNewLabel_4, gbc);
			
			
	if(Disciplina==null && Livello==null && Commento==null)		{	
			
			lblNewLabel_3.setVisible(false);
			lblNewLabel_1.setVisible(true);
			lblNewLabel_2.setVisible(false);
			lblNewLabel_4.setVisible(false);
			editorPane.setVisible(false);
	}
	
	
	if(Livello==null && Disciplina!=null && Commento==null){	
	lblNewLabel_3.setVisible(false);
	lblNewLabel_1.setVisible(false);
	lblNewLabel_2.setVisible(true);
	editorPane.setVisible(false);
	lblNewLabel_4.setVisible(false);
	}
	
	if (Commento==null && Livello!=null && Disciplina!=null){
		
		lblNewLabel_3.setVisible(true);
		lblNewLabel_1.setVisible(false);
		lblNewLabel_2.setVisible(false);
		editorPane.setVisible(true);
		lblNewLabel_4.setVisible(false);
	}

	
	if (Commento!=null && Livello!=null && Disciplina!=null){
		

		lblNewLabel_3.setVisible(false);
		lblNewLabel_1.setVisible(false);
		lblNewLabel_2.setVisible(false);
		editorPane.setVisible(false);
		lblNewLabel_4.setVisible(true);
	}


	
	
	
	
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					disciplina=combotest.getSelectedItem().toString();
					livello=comboliv.getSelectedItem().toString();
					commento=editorPane.getText();
					
//JOptionPane.showMessageDialog(null, "Il nome utente \""+disciplina+"\" e\\o l'email \""+commento+"\" sono già in uso, sceglierne altri"," ",JOptionPane.WARNING_MESSAGE);		
					
			if(Disciplina==null && Livello==null && Commento==null)		{
				
				if(disciplina=="disciplina"){
					JOptionPane.showMessageDialog(FrameTestimonianze.frame, "perfavore seleziona disciplina"," ",JOptionPane.WARNING_MESSAGE);
				}
				else{
				frame.dispose();
				  
				new FrameTestimonianze(disciplina,Livello,Commento);	
				combotest.setEnabled(false);
				comboliv.setEnabled(true);
				}
			//	JOptionPane.showMessageDialog(null, "Il nome utente \""+Commento+"\" e\\o l'email \""+Livello+"\" sono già in uso, sceglierne altri \""+Disciplina+"\" "," ",JOptionPane.WARNING_MESSAGE);			
			
			}
			if(Livello==null && Disciplina!=null && Commento==null){
				
				if(livello=="livello"){
					
					JOptionPane.showMessageDialog(FrameTestimonianze.frame, "perfavore seleziona livello"," ",JOptionPane.WARNING_MESSAGE);
				}
				else{
				frame.dispose();
				new FrameTestimonianze(Disciplina,livello,Commento);
				
				combotest.setEnabled(false);
				comboliv.setEnabled(false);
				}
				//JOptionPane.showMessageDialog(FrameTestimonianze.frame, "Il nome utente \""+Commento+"\" e\\o l'email \""+Livello+"\" sono già in uso, sceglierne altri \""+Disciplina+"\" "," ",JOptionPane.WARNING_MESSAGE);			
			}
		if (Commento==null && Livello!=null && Disciplina!=null){
			
		
			frame.dispose();
		
			new FrameTestimonianze(Disciplina,Livello,commento);
	
			    combotest.setEnabled(false);
				comboliv.setEnabled(false);
				
		
				
				
			
			}

		
		if (Commento!=null && Livello!=null && Disciplina!=null){
			
			  String ObjButtons[] = {"        Sì        ","      No      "};
		        int PromptResult = JOptionPane.showOptionDialog(FrameTestimonianze.frame,"Vuoi procedere con l'invio. Potrai visualizzare e modificare il tuo commento in seguito. ","",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        {
		        	TestimnianzaDao.instest(Disciplina,Livello,Commento);
		        }	
			FrameTesserato.frame.setEnabled(true);
			frame.dispose();
			
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
