package view_tesserato;


import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;


import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import org.apache.pdfbox.exceptions.COSVisitorException;

import org.apache.pdfbox.pdmodel.PDDocument;

import ClassiDao.GetInfoDB;
import ClassiDaoTesserato.TriggerOrdine;
import ComboTesserato.Combocon;











public class Confermaordine {
	public JButton btnConferma;
	public static Combocon ComboP;
	private JLabel lblTotaleOrdineEur;
	private JLabel part;
	public JButton btnTornaAlCarrello;
	public String nomedistinta="";
	public String percorso="";
	public static String testodistinta;
	public static PDDocument documentoPDF=null;
	public static boolean d=true,d2=true;
    public static JDialog frame;
    public String pagamento;
    public String momento;
	

public Confermaordine(){
		final DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		
		
		frame = new JDialog(FrameAttivitaTes.frame,true);
		frame.setTitle("Conferma ordine");
		frame.setBounds(100, 100, 803, 364);
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color (255,36,0));

		lblTotaleOrdineEur = new JLabel("TOTALE ISCRIZIONE:");
		lblTotaleOrdineEur.setToolTipText("");
		lblTotaleOrdineEur.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotaleOrdineEur.setBounds(26, 46, 145, 14);
		frame.getContentPane().add(lblTotaleOrdineEur);
		
		part = new JLabel("VALORE");
		part.setHorizontalAlignment(SwingConstants.TRAILING);
		part.setText(df.format(FrameAttivitaTes.totale)+" EUR");
		part.setFont(new Font("Tahoma", Font.PLAIN, 14));
		part.setBounds(171, 46, 118, 14);
		frame.getContentPane().add(part);
		
		

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
				FrameAttivitaTes.frame.setEnabled(true);
				FrameAttivitaTes.frame.setAlwaysOnTop(true);
				FrameAttivitaTes.frame.setAlwaysOnTop(false);
			}
		});
		btnTornaAlCarrello.setBounds(21, 295, 138, 28);
		frame.getContentPane().add(btnTornaAlCarrello);
		
		btnConferma = new JButton("Conferma");
		btnConferma.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConferma.setEnabled(false);
		btnConferma.setBounds(668, 295, 115, 28);
		frame.getContentPane().add(btnConferma);
		
		
		
	
		
		
		final JButton btnGeneraDistinta = new JButton("Genera distinta");
		btnGeneraDistinta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGeneraDistinta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagamento=ComboP.getSelectedItem().toString();
				testodistinta=TriggerOrdine.scriviDistinta();
				documentoPDF = TriggerOrdine.writePDF(pagamento,momento);
				
				try {
					TriggerOrdine.writePDF(pagamento,momento).close();
				} catch (IOException f) {
					// TODO Auto-generated catch block
					f.printStackTrace();
				}
				
				JFileChooser fc = new JFileChooser();
				 int sel = fc.showSaveDialog(frame);
			      if (sel == JFileChooser.APPROVE_OPTION) {
			         nomedistinta=(fc.getSelectedFile().getName());
			         percorso =(fc.getCurrentDirectory().toString());
			         File fdistinta = new File(percorso+"\\"+nomedistinta+"(TXT).txt");
				     BufferedWriter writer = null;
			         try {	     
						writer = new BufferedWriter(new FileWriter(fdistinta));
						writer.write(testodistinta);
						writer.close();								
						documentoPDF.save(percorso+"\\"+nomedistinta+"(PDF).pdf");
						documentoPDF.close();
						 String ObjButtons[] = {"        Sì        ","      No      "};
					        int PromptResult = JOptionPane.showOptionDialog(frame,"Ho salvato la distinta in "+percorso+" in formato PDF e TXT.\r\nVuoi aprire adesso il documento PDF? \r\n","Distinta",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,ObjButtons,ObjButtons[0]);
					        if(PromptResult==JOptionPane.YES_OPTION)
					        {
					        	if (Desktop.isDesktopSupported()) {
								    try {
								        File myFile = new File(percorso+"\\"+nomedistinta+"(PDF).pdf");
								        Desktop.getDesktop().open(myFile);
								    } catch (IOException ex) {
								    	JOptionPane.showMessageDialog(frame,"Non sono riuscito ad aprire il file "+ex.getMessage(),"Errore",JOptionPane.ERROR_MESSAGE);
								    }
						    	
					        }

						}

						d=false;
					} catch (COSVisitorException e2) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(frame,"Errore durante la scrittura del file. Provare a scegliere un nome o un percorso diverso. \r\n"+e2.getMessage(),"Errore",JOptionPane.ERROR_MESSAGE);
						e2.printStackTrace();
					} catch (IOException e2) {
						JOptionPane.showMessageDialog(frame,"Errore durante la scrittura del file. Provare a scegliere un nome o un percorso diverso. \r\n"+e2.getMessage(),"Errore",JOptionPane.ERROR_MESSAGE);
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
			         
			         
		
			      }
			      
			      
			      else if (sel == JFileChooser.CANCEL_OPTION) {
			        
			      }
			      }
			
			
		
			
		});
		
	
	//	btnGeneraDistinta.setBounds(100, 145, 301, 128);
		btnGeneraDistinta.setBounds(549, 352, 145, 28);
		btnGeneraDistinta.setEnabled(true);
		frame.getContentPane().add(btnGeneraDistinta);
		
		final JButton btnFine = new JButton("Salva documento");
		btnFine.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnFine.setEnabled(false);
		btnFine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(d){

					BufferedWriter writer = null;

					try {
						 File fdistinta2 = new File(System.getProperty("user.home")+"\\desktop\\DISTINTA_"+GetInfoDB.getDateOnly()+"(TXT).txt");
							writer = new BufferedWriter(new FileWriter(fdistinta2));
							writer.write(testodistinta);
							writer.close();
							String nome=System.getProperty("user.home")+"\\desktop\\DISTINTA_"+GetInfoDB.getDateOnly()+"(PDF).pdf";
						documentoPDF.save(nome);
						documentoPDF.close();
						 String ObjButtons[] = {"        Sì        ","      No      "};
					        int PromptResult = JOptionPane.showOptionDialog(frame,"Ho salvato la distinta sul desktop in PDF e TXT.\r\nVuoi aprire adesso il documento PDF? \r\n","Distinta",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,ObjButtons,ObjButtons[0]);
					        if(PromptResult==JOptionPane.YES_OPTION)
					        {
					        	if (Desktop.isDesktopSupported()) {
								    try {
								        File myFile = new File(nome);
								        Desktop.getDesktop().open(myFile);
								    } catch (IOException ex) {
								    	JOptionPane.showMessageDialog(frame,"Non sono riuscito ad aprire il file "+ex.getMessage(),"Errore",JOptionPane.ERROR_MESSAGE);
								    }
						    	
					        }

						}
						
						d=true;	
					} catch (COSVisitorException | IOException e) {
						JOptionPane.showMessageDialog(null,"Errore durante la scrittura del file. Provare a scegliere un nome o un percorso diverso. \r\n"+e.getMessage(),"Errore",JOptionPane.ERROR_MESSAGE);
						d2=false;
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		      d=true;
				if(d2){
				frame.setVisible(false);
				
				frame.dispose();
				FrameAttivitaTes.frame.dispose();
				new FrameDiscAttive(momento);
				/*FrameAttivitaTes.frame.setEnabled(true);
				FrameAttivitaTes.frame.setAlwaysOnTop(true);
				FrameAttivitaTes.frame.setAlwaysOnTop(false);
				FrameAttivitaTes.invia.setEnabled(false);
				FrameAttivitaTes.svuotacarrello.doClick();*/
				d2=true;
				}
				
			
			}});
		btnFine.setBounds(698, 352, 89, 28);
		frame.getContentPane().add(btnFine);
		
		

			btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				momento=TriggerOrdine.getDate();	
			pagamento=ComboP.getSelectedItem().toString();
			
		    TriggerOrdine.insOrdine(pagamento);

			
				String a2="",a3="";
				for(int c=0;c<FrameAttivitaTes.table_1.getRowCount();c++)
				{
						
					a2=FrameAttivitaTes.table_1.getValueAt(c,0).toString();
					a3=FrameAttivitaTes.table_1.getValueAt(c,1).toString();
	
					TriggerOrdine.insdetiscr(a3 , a2 , momento);
				
				
					
					
				}
				
				frame.setBounds(100, 100, 803, 447);
				frame.setLocationRelativeTo(null);
				Point lp=frame.getLocation();
				frame.setBounds(lp.x,lp.y+26 , 803, 419);
				btnConferma.setEnabled(false);
				btnConferma.setBounds(0,0,0,0);
				btnTornaAlCarrello.setBounds(0, 0, 0, 0);
				
				btnGeneraDistinta.setEnabled(true);
				btnFine.setEnabled(true);
			
			
				testodistinta=TriggerOrdine.scriviDistinta();
				documentoPDF = TriggerOrdine.writePDF(pagamento,momento);
				try {
					TriggerOrdine.writePDF(pagamento,momento).close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			//	FrameAttivitaTes.tease();
				
			//	FrameAttivitaTes.svuotacarrello.doClick();
				
				

				
				
				
				
				
			}
		});
		
		
	}
}
