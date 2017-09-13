package view_tesserato;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.sql.Blob;
import java.text.DecimalFormat;


import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import org.apache.pdfbox.exceptions.COSVisitorException;

import org.apache.pdfbox.pdmodel.PDDocument;

import ClassiDao.GetInfoDB;

import ClassiDaoTesserato.ordineeventodao;
import ComboTesserato.Combocon;











public class sendeventframe {
	public 	JPanel contentPane;
	public JButton btnConferma;
	public static Combocon ComboP;
	private JLabel lblTotaleOrdineEur;
	private JLabel part;
	public JButton btnTornaAlCarrello;
	public String nomedistinta="";
	public String percorso="";
	public String path="";
	public String pathprecedente="";
    public static JDialog frame;
    public String pagamento;
    public JTextField Casella;
    public int costo;
    public int evento;
public sendeventframe(String tipoevento){
		final DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		
		
		frame = new JDialog(FrameAttivitaTes.frame,true);
		frame.setTitle("Conferma ordine");
		frame.setBounds(100, 100, 803, 364);
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (255,36,0));
		contentPane.setLayout(new BorderLayout());
		
		
		GridBagConstraints gbc = new GridBagConstraints();
 
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
		
	    
	    
	    lblTotaleOrdineEur = new JLabel("FRAME ISCRIZIONE:");
		lblTotaleOrdineEur.setToolTipText("");
		lblTotaleOrdineEur.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotaleOrdineEur.setBounds(26, 46, 145, 14);
		contentPane.add(lblTotaleOrdineEur,BorderLayout.NORTH);
		
		
		
		JPanel Pan1 = new JPanel();
		Pan1.setBackground(new Color (255,36,0));
		Pan1.setLayout(new GridBagLayout());
		

		JPanel Pan2 = new JPanel();
		Pan2.setBackground(new Color (255,36,0));
		Pan2.setLayout(new GridBagLayout());
    
		JLabel lblEventi = new JLabel("Modalità di pagamento:");
		lblEventi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEventi.setForeground(Color.BLACK);
		gbc.insets = new Insets(5, 0, 0, 5);
		gbc.gridx =0;
		gbc.gridy =1;
		Pan1.add(lblEventi,gbc);
		
		
		
		ComboP = new Combocon();
		ComboP.setEnabled(true);
		gbc.insets = new Insets(5, 0, 0, 5);
		gbc.gridx = 1;
		gbc.gridy = 1;
		Pan1.add(ComboP,gbc);
		ComboP.setBounds(30, 145, 301, 28);
		ComboP.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(ComboP.getSelectedIndex()<=0)
					btnConferma.setEnabled(false);
				else btnConferma.setEnabled(true);
			}
		});
		
		JLabel lblEventi2 = new JLabel("Certificato di sana e robusta costituzione:");
		lblEventi2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEventi2.setForeground(Color.BLACK);
		gbc.insets = new Insets(5, 0, 0, 5);
		gbc.gridx =0;
		gbc.gridy =2;
		Pan1.add(lblEventi2,gbc);
		
		
		
		
		
		btnTornaAlCarrello = new JButton("Torna al carrello");
		btnTornaAlCarrello.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		btnTornaAlCarrello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.setVisible(false);
				
				frame.dispose();
				FrameEventi.frame.setEnabled(true);
				FrameEventi.frame.setAlwaysOnTop(true);
				FrameEventi.frame.setAlwaysOnTop(false);
			}
		});
		btnTornaAlCarrello.setBounds(21, 295, 138, 28);
		gbc.gridx = 1;
		gbc.gridy = 1;
		Pan2.add(btnTornaAlCarrello,gbc);
		
		btnConferma = new JButton("Conferma");
		btnConferma.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConferma.setEnabled(false);
		btnConferma.setBounds(668, 295, 115, 28);
		gbc.gridx = 2;
		gbc.gridy = 1;
		Pan2.add(btnConferma,gbc);
		
		
		
	
		
		
/*		final JButton btnGeneraDistinta = new JButton("Genera distinta");
		btnGeneraDistinta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGeneraDistinta.addActionListener(new ActionListener() {
			@SuppressWarnings("resource")
			public void actionPerformed(ActionEvent e) {
				
		
		
				JFileChooser fc = new JFileChooser();
				 int sel = fc.showSaveDialog(frame);
			      if (sel == JFileChooser.APPROVE_OPTION) {
			         nomedistinta=(fc.getSelectedFile().getName());
			         percorso =(fc.getCurrentDirectory().toString());
			    File fdistinta = new File(percorso+"\\"+nomedistinta+"");
				    Casella.setText(nomedistinta);
				    
				    
				    
				    
				    
			     //Leggere il file        
						try {
							FileReader f;
							f= new FileReader(fdistinta);
							 BufferedReader read;
							read = new BufferedReader(f);
						String s;
						s=read.readLine();
						
						
						 while(true) {
						      s=read.readLine();
						      if(s==null)
						        break;
						      System.out.println(s);
						    }
					//	  System.out.println(s);
						//JOptionPane.showMessageDialog(sendeventframe.frame, "'"+s+"'");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				
														
						
					    

				
			      
			      }
			      }
			
		
			
		});
		
	
	//	btnGeneraDistinta.setBounds(100, 145, 301, 128);
		btnGeneraDistinta.setBounds(549, 352, 145, 28);
		btnGeneraDistinta.setEnabled(true);
		frame.getContentPane().add(btnGeneraDistinta);
	*/	
		
		Casella= new JTextField();
		Casella.setEnabled(false);
		Casella.setBounds(400, 352, 145, 28);
		gbc.insets = new Insets(5, 0, 0, 5);
		gbc.gridx =1;
		gbc.gridy =2;
		Pan1.add(Casella,gbc);
		Casella.setVisible(false);
		
		
		final JButton btnFine = new JButton("Sfoglia");
		btnFine.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
					 
					 
		
		
		btnFine.setEnabled(true);
		btnFine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int c;
			for(c=0;c<FrameEventi.table_1.getRowCount();c++)	{
				
				
				pagamento=ComboP.getSelectedItem().toString();
				costo=(int) FrameEventi.table_1.getValueAt(c, 7);
				// File fdistinta = new File(percorso+"\\"+nomedistinta+"");
				 evento=(int) FrameEventi.table_1.getValueAt(c, 8);
				 if (tipoevento.equals("Stage"))
				 {
					 path="null";
					 pathprecedente="null";
					 nomedistinta="null";
					 Casella.setVisible(true);
				 }
//	JOptionPane.showMessageDialog(sendeventframe.frame, " \""+pagamento+"\" \\o \""+costo+"\","+evento+" "," ",JOptionPane.INFORMATION_MESSAGE);
				 else{
				 
				 JFileChooser fc = new JFileChooser();
				 int sel = fc.showOpenDialog(frame);
			      if (sel == JFileChooser.APPROVE_OPTION) {
			    	 pathprecedente=(fc.getSelectedFile().getPath());
			         nomedistinta=(fc.getSelectedFile().getName());
			         percorso =("src/certificati");
			         path=percorso+"/"+nomedistinta;
			    
				    }
			      
			      Casella.setText(nomedistinta);
			/*		try {
						FileReader f;
						f= new FileReader(fdistinta);
						 BufferedReader read;
						read = new BufferedReader(f);
					String s;
				
					s=read.readLine();
					
					
					
					 while(true) {
					      s=read.readLine();
					      if(s==null)
					        break;
					      System.out.println(s);
					   
					    }
				//	  System.out.println(s);
					//JOptionPane.showMessageDialog(sendeventframe.frame, "'"+s+"'");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} */
			      
					
			      }
			}}
			

			
			
//JOptionPane.showMessageDialog(sendeventframe.frame, " \""+pagamento+"\" \\o \""+pagamento+"\","+pagamento+" "," ",JOptionPane.INFORMATION_MESSAGE);	
	           
				
				
		}
			
			);
	
		gbc.insets = new Insets(5, 0, 0, 5);
		gbc.gridx =2;
		gbc.gridy =2;
		Pan1.add(btnFine,gbc);
		
		contentPane.add(Pan1,BorderLayout.CENTER);
		contentPane.add(Pan2,BorderLayout.SOUTH);
			btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 ordineeventodao.insdetiscr(pagamento,path,pathprecedente, evento, costo,tipoevento);
					frame.dispose();	
					FrameEventi.frame.setEnabled(true);
					FrameEventi.frame.setAlwaysOnTop(true);
					FrameEventi.frame.setAlwaysOnTop(false);
				
				
				/*frame.setBounds(100, 100, 803, 447);
				frame.setLocationRelativeTo(null);
				Point lp=frame.getLocation();
				frame.setBounds(lp.x,lp.y+26 , 803, 419);
				btnConferma.setEnabled(false);
				btnConferma.setBounds(0,0,0,0);
				btnTornaAlCarrello.setBounds(0, 0, 0, 0);*/
				
			//	btnGeneraDistinta.setEnabled(true);
				Casella.setVisible(true);  
				
             
				
				
				
				
				
			}
		});
		
			
			
			
		
	}
}
