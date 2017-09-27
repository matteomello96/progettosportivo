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
import ComboTesserato.Combogiorno;
import ComboTesserato.Comboorario;









public class FrameInserisciTurno extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public JButton btnNewButton;
	public static JFrame frame;
	public static Comboorario Comboorario;
	public static Combogiorno Combogiorno;
	public String ora;
	public String giorno;
	public JButton btnNewButton_1;
    public JPanel contentPane;
    public String giorno2;
	public String orario2;
	
	private int codiceturno;
	private int postidisponibili;
	
	
	public FrameInserisciTurno(String disciplina, String livello,String giorno,String orario,String momento) {
		final DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		
		frame = new JFrame("Inserisci turno");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 605, 391);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		frame.setAlwaysOnTop(true);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (42,82,190));
		contentPane.setLayout(new GridBagLayout());
		
		
		
		
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
	    
	    
	    GridBagConstraints gbc = new GridBagConstraints();
	    
	    
		
		JLabel lblNewLabel = new JLabel("Inserisci turno");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 25));
		
		gbc.gridwidth = 2;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 0;
		contentPane.add(lblNewLabel, gbc);
	
		JLabel lblNewLabel_1 = new JLabel("Giorno:");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		
		gbc.gridwidth = 2;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc);
			
		
		
	
		

		
		Combogiorno = new Combogiorno(livello,disciplina);
		 
		
			gbc.insets = new Insets(0, 0, 5, 5);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 2;
			gbc.gridy = 2;
			contentPane.add(Combogiorno, gbc);
		
			JLabel lblNewLabel_2 = new JLabel("Orario:");
			lblNewLabel_2.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			
			gbc.gridwidth = 2;
			gbc.insets = new Insets(0, 0, 5, 5);
			gbc.gridx = 0;
			gbc.gridy = 3;
			contentPane.add(lblNewLabel_2, gbc);
			
			
			
			Comboorario = new Comboorario(disciplina,livello,giorno);
			 Comboorario.setEnabled(false);
			
				gbc.insets = new Insets(0, 0, 5, 5);
				gbc.fill = GridBagConstraints.HORIZONTAL;
				gbc.gridx = 2;
				gbc.gridy = 3;
				contentPane.add(Comboorario, gbc);
				
				
		

				btnNewButton = new JButton("step successivo>>");
				
				gbc.fill = GridBagConstraints.HORIZONTAL;
				gbc.insets = new Insets(0, 0, 0, 5);
				gbc.gridx = 2;
				gbc.gridy = 5;
				  btnNewButton.setEnabled(true);
				contentPane.add(btnNewButton, gbc);
				
				
			
				
	
			
				btnNewButton.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						giorno2=Combogiorno.getSelectedItem().toString();
						orario2=Comboorario.getSelectedItem().toString();
						
						
				if(giorno==null && orario==null){	
			
				if(giorno2=="giorno"){
					JOptionPane.showMessageDialog(frame,"inserisci il giorno");
				}
				else{
						frame.dispose();
						new FrameInserisciTurno(livello,disciplina,giorno2,orario,momento);
						//JOptionPane.showMessageDialog(frame, "  '"+disciplina+"','"+livello+"','"+giorno2+"','"+orario+"',  ");
						Comboorario.setEnabled(true);
						Combogiorno.setEnabled(false);
				}	
				}
				
				
				else if(giorno!=null && orario==null){
				if(orario2=="orario")	{
					JOptionPane.showMessageDialog(frame,"inserisci l'orario");
				}
				else{
			
				    codiceturno = GetInfoDB.getcodiceturno2(livello, disciplina, giorno, orario2);
			
					postidisponibili = GetInfoDB.getprenotazioni(codiceturno);
					if(postidisponibili==0){
						JOptionPane.showMessageDialog(FrameInserisciTurno.frame, "Posti massimi raggiunti"," ",JOptionPane.WARNING_MESSAGE);	
						frame.dispose();
						new FrameInserisciTurno(livello,disciplina,null,null,momento);
					}
					else{
					
					Invia_Turno_Dao.Invia(livello,disciplina,giorno,orario2);
					
			JOptionPane.showMessageDialog(frame,"L'inserimento è stato apportato.Attendi la conferma da parte del responsabile!");
					frame.dispose();
					new FrameDiscAttive(momento);
					}	
	
				}	
				}
				
				
				
				
						
					}
					
					
					
				});
			
		
			
			
			
			

			
	
			

			
			frame.addWindowListener(new java.awt.event.WindowAdapter() {
				   @Override
				   public void windowClosing(java.awt.event.WindowEvent windowEvent) 
				    {
					   FrameDiscAttive.frame.setVisible(true);
				    
				    }
				});
	}

}
