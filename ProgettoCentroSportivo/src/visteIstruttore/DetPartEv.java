package visteIstruttore;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import VisteUtenteGenerico.FrameIniziale;
import VisteUtenteGenerico.setupTableWidths;
import listener.Listen;
import modelliTabelleIstruttore.ModDetOrariAtt;
import modelliTabelleIstruttore.ModDetOrariEv;
import modelliTabelleIstruttore.ModElPart;
import ClassiDao.DettagliIstruttoreDAO;
import ClassiDao.DettagliLivelloDAO;
import ClassiDao.DettagliOrariDAO;
import ClassiDao.DettagliTestimonianzeDAO;
import ClassiDao.ElencoDisciplineDAO;
import ClassiDao.GetInfoDB;
import ModelliTabelle.ModDetIstr;
import ModelliTabelle.ModDetLiv;
import ModelliTabelle.ModDetOrari;
import ModelliTabelle.ModDetTest;
import ModelliTabelle.ModDiscIni;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.plaf.TableHeaderUI;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.tree.TreeSelectionModel;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;

import ClassiDAOIstruttore.DettagliOrariAttDAO;
import ClassiDAOIstruttore.DettagliOrariEvDAO;
import ClassiDAOIstruttore.ElencoPartecipantiAttDAO;
import ClassiDAOIstruttore.ElencoPartecipantiEvDAO;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DetPartEv {

	public static JFrame frame;
	public JPanel contentPane,tabellaPnl,tabellaPnl2,tabellaPnl3,tabellaPnl4;
	public static JTable table1,table2,table3,table4,tablemod;
    private ModElPart model1; 
    private ModDetIstr model2;
    private ModDetTest model3;
    private ModDetOrari model4;
    public String nomedistinta="";
	public String percorso="";
	public static String testodistinta;
	public static PDDocument documentoPDF=null;
	public static boolean d=true,d2=true;
	
    
	public DetPartEv(String giornoset,String fasciaoraria,String spazio) {
		
		
		
		 giornoset=(String) DetEv.table1.getValueAt(DetEv.table1.getSelectedRow(), 0);
	 fasciaoraria=(String) DetEv.table1.getValueAt(DetEv.table1.getSelectedRow(), 1);
		 spazio=(String) DetEv.table1.getValueAt(DetEv.table1.getSelectedRow(), 2);
		frame = new JFrame();
		frame.setTitle("Dettaglio dei partecipanti all'evento il giorno: "+giornoset+" alle ore: "+fasciaoraria+" nello spazio "+spazio+"");
		frame.setBounds(100, 100, 956, 523);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setAutoRequestFocus(true);
		
		frame.setResizable(true);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenuItem MenuRegistra = new JMenuItem("Torna alle attività");

		menuBar.add(MenuRegistra);
		MenuRegistra.addActionListener(new Listen(this));
		MenuRegistra.setActionCommand("Vai_ev_det");

		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (255,193,20));
		contentPane.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(30, 400, 300, 30);	
	    frame.getContentPane().add(scroll);
		
	    JLabel lblTurni = new JLabel("Turni disponibili:");
		lblTurni.setForeground(new Color(0, 123, 167));
		lblTurni.setBackground(new Color(0, 133, 217));
		Border b = BorderFactory.createLineBorder(new Color(255, 205, 255));
		lblTurni.setBorder(b);
		lblTurni.setBounds(29, 38, 353, 14);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		contentPane.add(lblTurni, gbc);
		
		table1 = new JTable();
		model1 = new ModElPart(ElencoPartecipantiEvDAO.elencoiniziale(ClassiDao.GetInfoDB.getcodiceturnoevento(fasciaoraria,giornoset,spazio)));
		table1.setRowHeight(20);
		table1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table1.setCellSelectionEnabled(true);
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table1.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table1.setModel(model1);
		

		Font font2 = new Font("Comic Sans", Font.PLAIN, 25);
		table1.setFont(font2);
		tablemod = setupTableWidths.setupTableWidths(table1);

		tablemod.setForeground(new Color(255, 255, 255));
		tablemod.setBackground(new Color(240, 220, 130));

		JScrollPane scrollt1 = new JScrollPane();

		scrollt1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollt1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollt1.setBackground(new Color(255, 193, 20));
		scrollt1.setViewportView(tablemod);
		gbc.gridx = 0;
		gbc.gridy = 1;
		contentPane.add(scrollt1, gbc);
		
		
		final JButton btnGeneraDistinta = new JButton("Genera elenco");
		btnGeneraDistinta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		
		btnGeneraDistinta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				testodistinta=TriggerPartecipantiEv.scriviDistinta();
				documentoPDF = TriggerPartecipantiEv.writePDF((String) DetEv.table1.getValueAt(DetEv.table1.getSelectedRow(), 0),(String) DetEv.table1.getValueAt(DetEv.table1.getSelectedRow(), 1),(String) DetEv.table1.getValueAt(DetEv.table1.getSelectedRow(), 2));
				
				try {
					TriggerPartecipantiEv.writePDF((String) DetEv.table1.getValueAt(DetEv.table1.getSelectedRow(), 0),(String) DetEv.table1.getValueAt(DetEv.table1.getSelectedRow(), 1),(String) DetEv.table1.getValueAt(DetEv.table1.getSelectedRow(), 2)).close();
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
		gbc.gridx = 0;
		gbc.gridy = 2;
		contentPane.add(btnGeneraDistinta, gbc);
		
		final JButton btnFine = new JButton("Fine");
		btnFine.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnFine.setEnabled(true);
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
				FrameEventiIstr.frame.setEnabled(true);
				FrameEventiIstr.frame.setAlwaysOnTop(true);
				FrameEventiIstr.frame.setAlwaysOnTop(false);
				
				d2=true;
				}
				
			
			}});
		btnFine.setBounds(698, 352, 89, 28);
		gbc.gridx = 1;
		gbc.gridy = 2;
		
		contentPane.add(btnFine,gbc);
		
		
		
		
		
		
	}
}
