package visteadmin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import ClassiDao.GetInfoDB;
import VisteUtenteGenerico.setupTableWidths;
import classiDAOResponsabile.GestioneDetIscrizioniDAO;
import classiDAOResponsabile.GestioneIscrizioniDAO;
import classiDAOResponsabile.Uccidi_iscrizione;
import classiDAOResponsabile.dettagliiscrizionedao;
import classiDAOResponsabile.modificaordinedao;
import listener.Listen;
import modelliTabelleRespo.modellidettagli;

public class FrameDettagliAcc extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JFrame frame;
	
	public static JTable table_2,tablemod2;
	private modellidettagli model;
	public JPanel contentPane,pannello;
	public JButton bottone;
	public JButton bottone1,bottone3;
	
	
	public FrameDettagliAcc(int cod) {
		frame = new JFrame("FrameDettagliDaAccResp");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setTitle("Dettagli dell'ordine numero "+cod+"");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1000, 1000);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		
	
		JMenu mnNewMenu = new JMenu("Pannello Ordini");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Torna agli ordini");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new Listen(this));
		mntmNewMenuItem.setActionCommand("ordacc");
		
		pannello= new JPanel();
		pannello.setBackground(new Color (255,193,20));
		pannello.setLayout(new BorderLayout());
		
		
		
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JScrollPane scroll = new JScrollPane(pannello);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
		
		
	    JLabel lblUtentiS = new JLabel("Dettagli ordine accettato");
		lblUtentiS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUtentiS.setForeground(Color.WHITE);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 1;
		pannello.add(lblUtentiS,BorderLayout.NORTH);
		
	
		
		table_2 = new JTable();
		model = new modellidettagli(dettagliiscrizionedao.elencoiniziale(cod));
		table_2.setCellSelectionEnabled(true);
		table_2.setModel(model);
		
		tablemod2 = setupTableWidths.setupTableWidths(table_2);

		tablemod2.setForeground(new Color(255, 255, 255));
		tablemod2.setBackground(new Color(240, 220, 130));

		JScrollPane scrollt2 = new JScrollPane();

		scrollt2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollt2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollt2.setBackground(new Color(255, 193, 20));
		scrollt2.setViewportView(tablemod2);
		
		
		pannello.add(scrollt2,BorderLayout.CENTER);
		
       
	
					
				
				
				
		 
	
	
	
	
	

	}
	    
	
}
