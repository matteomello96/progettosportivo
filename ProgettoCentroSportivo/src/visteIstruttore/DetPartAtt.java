package visteIstruttore;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import listener.Listen;
import listener.VariListener;
import modelliTabelleIstruttore.ModElPart;
import ClassiDao.GetInfoDB;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import ClassiDAOIstruttore.ElencoPartecipantiAttDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class DetPartAtt {

	public static JFrame frame;
	public JPanel contentPane,Panel1,PanelBottom;
	public static JTable table1;
    private ModElPart model1; 
    public String nomedistinta="";
	public String percorso="";
	public static String testodistinta;
	public static PDDocument documentoPDF=null;
	public static boolean d=true,d2=true;
	
    
	public DetPartAtt() {
		String giornoset=(String) DetAtt.table1.getValueAt(DetAtt.table1.getSelectedRow(), 0);
		String fasciaoraria=(String) DetAtt.table1.getValueAt(DetAtt.table1.getSelectedRow(), 1);
		String spazio=(String) DetAtt.table1.getValueAt(DetAtt.table1.getSelectedRow(), 2);
		frame = new JFrame();
		frame.setTitle("Dettaglio dei partecipanti all'attività il giorno: "+giornoset+" alle ore: "+fasciaoraria+" nello spazio "+spazio+"");
		frame.setBounds(100, 100, 956, 523);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setAutoRequestFocus(true);
		
		frame.setResizable(true);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenuItem MenuRegistra = new JMenuItem("Torna al dettaglio attività");

		menuBar.add(MenuRegistra);
		MenuRegistra.addActionListener(new Listen(this));
		MenuRegistra.setActionCommand("Vai_att_det");
		
		
		URL url1 = ClassLoader.getSystemResource("immaginijava/bottone4.png");
		URL url2 = ClassLoader.getSystemResource("immaginijava/bottone5.png");
		URL url3 = ClassLoader.getSystemResource("immaginijava/titolo2.png");
        ImageIcon im=new ImageIcon(url1);
        ImageIcon im2=new ImageIcon(url2);
        ImageIcon im3=new ImageIcon(url3);

		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (60,179,113));
		contentPane.setLayout(new BorderLayout());
		
		
		
 
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
		

		

		
		Panel1 = new JPanel();
 		Panel1.setBackground(new Color(60, 179, 113));
 		Panel1.setLayout(new GridBagLayout());
 		
 		
 		
 		contentPane.add(VariListener.SettaPannelloTitolo(im3, Panel1, 1, 0, "Turni disponibili"), BorderLayout.NORTH);
		
		table1 = new JTable();
		model1 = new ModElPart(ElencoPartecipantiAttDAO.elencoiniziale(ClassiDao.GetInfoDB.getcodiceturno(giornoset,fasciaoraria,spazio)));
		contentPane.add(VariListener.SettaScroll(table1,50,model1), BorderLayout.CENTER);
		
		
		PanelBottom = new JPanel();
		PanelBottom.setLayout(new GridBagLayout());
		PanelBottom.setBackground(new Color (60,179,113));

		JButton btn = new JButton(im);
		JLabel lbl= new JLabel();
        VariListener.SettaBtn(PanelBottom, btn, lbl,"Genera elenco", 0, 2,im2,true);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				testodistinta=TriggerPartecipantiAtt.scriviDistinta();
				documentoPDF = TriggerPartecipantiAtt.writePDF(giornoset,fasciaoraria,spazio);
				
				try {
					TriggerPartecipantiAtt.writePDF(giornoset,fasciaoraria,spazio).close();
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
		
	
	   
		
		JButton btn2 = new JButton(im);
		JLabel lbl2= new JLabel();
        VariListener.SettaBtn(PanelBottom, btn2, lbl2,"Attività", 2, 2,im2,true);
		btn2.setEnabled(true);
		btn2.addActionListener(new ActionListener() {
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
				FrameAttIstr.frame.setEnabled(true);
				FrameAttIstr.frame.setAlwaysOnTop(true);
				FrameAttIstr.frame.setAlwaysOnTop(false);
				
				d2=true;
				}
				
			
			}});
		contentPane.add(PanelBottom,BorderLayout.SOUTH);
		
		

			
				
				

				
				
				
				
				
			}
		
		
		
		
		
		
	
}
