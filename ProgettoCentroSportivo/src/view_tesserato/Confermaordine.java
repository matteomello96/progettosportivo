package view_tesserato;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import ClassiDao.GetInfoDB;
import ClassiDaoTesserato.TriggerOrdine;
import ComboTesserato.Combocon;
import listener.VariListener;











public class Confermaordine {
	public JButton btnConferma;
	public JPanel Panel1,PanelBottom2,contentPane,Panel2;
	public static Combocon ComboP;
	private JLabel lblTotaleOrdineEur;
	private JLabel part;
	public JButton btnTornaAlCarrello;
	public String nomedistinta="";
	public String percorso="";
	public static String testodistinta;
	public static PDDocument documentoPDF=null;
	public static boolean d=true,d2=true;
    public static JFrame frame;
    public String pagamento;
    public String momento;
	

public Confermaordine(){
		final DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		
		
		frame = new JFrame("Conferma ordine");
		frame.setTitle("Conferma ordine");
		frame.setBounds(100, 100, 803, 364);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setBounds(100, 100, 1334, 700);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (42,82,190));
		contentPane.setLayout(new BorderLayout());
		

		
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
		
	    Panel1 = new JPanel();
		Panel1.setBackground(new Color (42,82,190));
		Panel1.setLayout(new GridBagLayout());

		
		GridBagConstraints gbc = new GridBagConstraints();
		
		lblTotaleOrdineEur = new JLabel();
		VariListener.SettaLabelGen(Panel1,lblTotaleOrdineEur,"TOTALE ISCRIZIONE:", 0, 1);
		
		part = new JLabel("VALORE");
		VariListener.SettaLabelGen(Panel1,part,df.format(FrameAttivitaTes.totale)+" EUR", 1, 1);
		
		contentPane.add(Panel1,BorderLayout.NORTH);
		
		Panel2 = new JPanel();
		Panel2.setBackground(new Color (42,82,190));
		Panel2.setLayout(new GridBagLayout());
		
		
		JLabel lblEventi = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblEventi, "Modalità di pagamento", 0, 2);

		ComboP = new Combocon();
		VariListener.SettaBox(Panel2, ComboP, 1, 2);
		ComboP.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(ComboP.getSelectedIndex()<=0)
					btnConferma.setEnabled(false);
				else btnConferma.setEnabled(true);
			}
		});
		
		
		contentPane.add(Panel2,BorderLayout.CENTER);
		
		PanelBottom2 = new JPanel();
		PanelBottom2.setLayout(new GridBagLayout());
		PanelBottom2.setBackground(new Color (42,82,190));
		
		
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
		gbc.gridx=2;
		gbc.gridy=2;
		PanelBottom2.add(btnTornaAlCarrello,gbc);
		
		btnConferma = new JButton("Conferma");
		btnConferma.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConferma.setEnabled(false);
		btnConferma.setBounds(668, 295, 115, 28);
		gbc.gridx=0;
		gbc.gridy=1;
		PanelBottom2.add(btnConferma,gbc);
		
		
		
	
		
		
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
						
						JOptionPane.showMessageDialog(frame,"Errore durante la scrittura del file. Provare a scegliere un nome o un percorso diverso. \r\n"+e2.getMessage(),"Errore",JOptionPane.ERROR_MESSAGE);
						e2.printStackTrace();
					} catch (IOException e2) {
						JOptionPane.showMessageDialog(frame,"Errore durante la scrittura del file. Provare a scegliere un nome o un percorso diverso. \r\n"+e2.getMessage(),"Errore",JOptionPane.ERROR_MESSAGE);
						
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
		gbc.gridx=1;
		gbc.gridy=1;
		PanelBottom2.add(btnGeneraDistinta,gbc);
		
		final JButton btnFine = new JButton("Continua iscrizione");
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
						
						e.printStackTrace();
					}
				}
		      d=true;
				if(d2){
				frame.setVisible(false);
				
				frame.dispose();
				FrameAttivitaTes.frame.dispose();
				new FrameDiscAttive(momento);
				
				d2=true;
				}
				
			
			}});
		btnFine.setBounds(698, 352, 89, 28);
		gbc.gridx=2;
		gbc.gridy=1;
		PanelBottom2.add(btnFine,gbc);
		
		

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
					
					e.printStackTrace();
				}
				
			
				

				
				
				
				
				
			}
		});
		contentPane.add(PanelBottom2, BorderLayout.SOUTH);
		
	}
}
