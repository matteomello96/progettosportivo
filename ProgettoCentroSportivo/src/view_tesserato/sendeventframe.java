package view_tesserato;


import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.apache.pdfbox.exceptions.COSVisitorException;

import org.apache.pdfbox.pdmodel.PDDocument;

import ClassiDao.GetInfoDB;

import ClassiDaoTesserato.ordineeventodao;
import ComboTesserato.Combocon;











public class sendeventframe {
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
public sendeventframe(){
		final DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		
		
		frame = new JDialog(FrameTesserato.frame,true);
		frame.setTitle("Conferma ordine");
		frame.setBounds(100, 100, 803, 364);
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color (255,36,0));

		lblTotaleOrdineEur = new JLabel("FRAME ISCRIZIONE:");
		lblTotaleOrdineEur.setToolTipText("");
		lblTotaleOrdineEur.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotaleOrdineEur.setBounds(26, 46, 145, 14);
		frame.getContentPane().add(lblTotaleOrdineEur);
		
		
		
		

		 ComboP = new Combocon();
		ComboP.setEnabled(true);
		ComboP.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(ComboP.getSelectedIndex()<=0)
					btnConferma.setEnabled(false);
				else btnConferma.setEnabled(true);
			}
		});
		
		
		ComboP.setBounds(30, 145, 301, 28);
		frame.getContentPane().add(ComboP);
		
		
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
		frame.getContentPane().add(btnTornaAlCarrello);
		
		btnConferma = new JButton("Conferma");
		btnConferma.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConferma.setEnabled(false);
		btnConferma.setBounds(668, 295, 115, 28);
		frame.getContentPane().add(btnConferma);
		
		
		
	
		
		
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
		frame.getContentPane().add(Casella);
		Casella.setVisible(false);
		
		
		final JButton btnFine = new JButton("Inserisci certificato");
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
//	JOptionPane.showMessageDialog(sendeventframe.frame, " \""+pagamento+"\" \\o \""+costo+"\","+evento+" "," ",JOptionPane.INFORMATION_MESSAGE);
				 JFileChooser fc = new JFileChooser();
				 int sel = fc.showSaveDialog(frame);
			      if (sel == JFileChooser.APPROVE_OPTION) {
			    	 pathprecedente=(fc.getSelectedFile().getPath());
			         nomedistinta=(fc.getSelectedFile().getName());
			         percorso =("src/certificati");
			         path=percorso+"/"+nomedistinta;
			    
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
				  
					ordineeventodao.insdetiscr(pagamento,path,pathprecedente, evento, costo);
			      }
				 
	

			}
			
//JOptionPane.showMessageDialog(sendeventframe.frame, " \""+pagamento+"\" \\o \""+pagamento+"\","+pagamento+" "," ",JOptionPane.INFORMATION_MESSAGE);	
	
				frame.dispose();	
				FrameEventi.frame.setEnabled(true);
				FrameEventi.frame.setAlwaysOnTop(true);
				FrameEventi.frame.setAlwaysOnTop(false);
				
				}
				
			
			});
		btnFine.setBounds(698, 352, 89, 28);
		frame.getContentPane().add(btnFine);
		
		

			btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				frame.setBounds(100, 100, 803, 447);
				frame.setLocationRelativeTo(null);
				Point lp=frame.getLocation();
				frame.setBounds(lp.x,lp.y+26 , 803, 419);
				btnConferma.setEnabled(false);
				btnConferma.setBounds(0,0,0,0);
				btnTornaAlCarrello.setBounds(0, 0, 0, 0);
				
			//	btnGeneraDistinta.setEnabled(true);
				Casella.setVisible(true);  
				
             
				
				
				
				
				
			}
		});
		
			
			
			
		
	}
}
