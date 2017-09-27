package visteadmin;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;


import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.GridBagLayout;
import javax.swing.JLabel;


import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;






import classiDAOResponsabile.ElencoUtentiDAO;
import classiDAOResponsabile.credenzialidao;
import listener.Listen;
import listener.VariListener;

import modelliTabelleRespo.ModElUtenti;

import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class FrameElencoUtenti extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public static JFrame frame;
	
	public JPanel GPane1,GPane2,GPane3,GPane4,contentPane,BotPnl1,BotPnl2,BotPnl3,BotPnl4;
	public JTable table,table2,table3,table4,tablemod,tablemod2,tablemod3,tablemod4;
    private ModElUtenti model,model2,model3,model4;

    private JTabbedPane tabed = new JTabbedPane();
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public FrameElencoUtenti() {
		frame = new JFrame("Pagina Iscritti");
		
		frame.setTitle("Elenco degli utenti");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1000, 1000);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		tabed = new JTabbedPane();
	
		JMenu mnNewMenu = new JMenu("Pannello di controllo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Torna al pannello di controllo");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new Listen(this));
		mntmNewMenuItem.setActionCommand("iniresp");
		
		

		
		
		URL url1 = ClassLoader.getSystemResource("immaginijava/bottone4.png");
		URL url2 = ClassLoader.getSystemResource("immaginijava/bottone5.png");
		URL url3 = ClassLoader.getSystemResource("immaginijava/titolo2.png");
        ImageIcon im=new ImageIcon(url1);
        ImageIcon im2=new ImageIcon(url2);
        ImageIcon im3=new ImageIcon(url3);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (255,185,0));
		contentPane.setLayout(new BorderLayout());
		
		
		
 
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
	    
		
		

		

	       JPanel Panel1 = new JPanel();
	  		Panel1.setBackground(new Color(255,185,0));
	  		Panel1.setLayout(new GridBagLayout());	
		
		
	    GPane1 = new JPanel();
		GPane1.setBackground(new Color (235,193,20));
		GPane1.setLayout(new BorderLayout());
		
		
		
		
		GPane1.add(VariListener.SettaPannelloTitolo(im3, Panel1, 1, 0, "elenco utenti attivi"), BorderLayout.NORTH);		
		
		
		
		table = new JTable();
		model = new ModElUtenti(ElencoUtentiDAO.elencoattivi());
		GPane1.add(VariListener.SettaScroll(table,50,model), BorderLayout.CENTER);

		
		
		
		
		BotPnl1 = new JPanel();
		BotPnl1.setBackground(new Color (235,193,20));
		BotPnl1.setLayout(new GridBagLayout());
		
		
		JButton btn = new JButton(im);
		JLabel lbl= new JLabel();
        VariListener.SettaBtn(BotPnl1, btn, lbl,"elimina iscritto", 2, 2,im2,true);
		btn.setMnemonic('e');
		btn.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow()!=-1){
				
				int b;
			
				b= (int) table.getValueAt(table.getSelectedRow(), 0);
		
			credenzialidao.eliminaiscr(b);
			frame.dispose();
			new FrameElencoUtenti();
			
		}	else
			JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
					JOptionPane.WARNING_MESSAGE);
		}});
		
		
		JButton btn1 = new JButton(im);
		JLabel lbl1= new JLabel();
        VariListener.SettaBtn(BotPnl1, btn1, lbl1,"blocca iscritto", 4, 2,im2,true);
		btn1.setMnemonic('e');
		btn1.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow()!=-1){
			
				int b;
			
				b= (int) table.getValueAt(table.getSelectedRow(), 0);
		
			credenzialidao.blocca(b);
			frame.dispose();
			new FrameElencoUtenti();
			
		}	else
			JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
					JOptionPane.WARNING_MESSAGE);
		}});
		
		GPane1.add(BotPnl1,BorderLayout.SOUTH);
		
		tabed.add("Utenti Attivi",GPane1);
		
		
		

		  JPanel Panel2 = new JPanel();
			Panel2.setBackground(new Color(255,185,0));
			Panel2.setLayout(new GridBagLayout());
			
			
			
			
			
		    GPane2 = new JPanel();
			GPane2.setBackground(new Color (255,185,0));
			GPane2.setLayout(new BorderLayout());
		
		
		
		
			GPane2.add(VariListener.SettaPannelloTitolo(im3, Panel2, 1, 0, "elenco richieste iscrizione"), BorderLayout.NORTH);		
		
		table2 = new JTable();
		model2 = new ModElUtenti(ElencoUtentiDAO.elencorichiesteiscr());

		GPane2.add(VariListener.SettaScroll(table2,50,model2), BorderLayout.CENTER);

		
		
		
		
		BotPnl2 = new JPanel();
		BotPnl2.setBackground(new Color (235,193,20));
		BotPnl2.setLayout(new GridBagLayout());
		
		
		JButton btn3 = new JButton(im);
		JLabel lbl3= new JLabel();
        VariListener.SettaBtn(BotPnl2, btn3, lbl3,"Accetta richiesta", 2, 2,im2,true);
		btn3.setMnemonic('e');
		btn3.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(table2.getSelectedRow()!=-1){
				
				int b;
			
				b= (int) table2.getValueAt(table2.getSelectedRow(), 0);
		
			credenzialidao.attiva(b);
			frame.dispose();
			new FrameElencoUtenti();
			
		}	else
			JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
					JOptionPane.WARNING_MESSAGE);
		}});
		
		
		JButton btn4 = new JButton(im);
		JLabel lbl4= new JLabel();
        VariListener.SettaBtn(BotPnl2, btn4, lbl4,"Elimina richiesta", 4, 2,im2,true);
		btn4.setMnemonic('e');
		btn4.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(table2.getSelectedRow()!=-1){
			
				int b;
			
				b= (int) table2.getValueAt(table2.getSelectedRow(), 0);
		
			credenzialidao.eliminaiscr(b);
			frame.dispose();
			new FrameElencoUtenti();
			
		}		else
			JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
					JOptionPane.WARNING_MESSAGE);
		}});
		
		GPane2.add(BotPnl2,BorderLayout.SOUTH);
		
		tabed.add("Richieste di iscrizione",GPane2);
		
		
		
		
		 JPanel Panel4 = new JPanel();
			Panel4.setBackground(new Color(255,185,0));
			Panel4.setLayout(new GridBagLayout());
			
			
		GPane3 = new JPanel();
		GPane3.setBackground(new Color (235,193,20));
		GPane3.setLayout(new BorderLayout());
		
		
		
		
		 GPane3.add(VariListener.SettaPannelloTitolo(im3, Panel4, 1, 0, "Elenco richieste modifica"), BorderLayout.NORTH);		
			
		table3 = new JTable();
		model3 = new ModElUtenti(ElencoUtentiDAO.elencorichiestemod());
		GPane3.add(VariListener.SettaScroll(table3,50,model3), BorderLayout.CENTER);

		
		
		
		
		BotPnl3 = new JPanel();
		BotPnl3.setBackground(new Color (235,193,20));
		BotPnl3.setLayout(new GridBagLayout());
		
		
		JButton btn6 = new JButton(im);
		JLabel lbl6= new JLabel();
        VariListener.SettaBtn(BotPnl3, btn6, lbl6,"Accetta modifiche", 2, 2,im2,true);
		btn6.setMnemonic('e');
		btn6.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(table3.getSelectedRow()!=-1){
		
				int b;
			
				b= (int) table3.getValueAt(table3.getSelectedRow(), 0);
		
			credenzialidao.accmod(b);
			frame.dispose();
			new FrameElencoUtenti();
			
		}else
			JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
					JOptionPane.WARNING_MESSAGE);
		}	
		});
		
		
		
		
		GPane3.add(BotPnl3,BorderLayout.SOUTH);
		
		tabed.add("Richieste di modifica",GPane3);
		
		 JPanel Panel5 = new JPanel();
			Panel5.setBackground(new Color(255,185,0));
			Panel5.setLayout(new GridBagLayout());
		
		GPane4 = new JPanel();
		GPane4.setBackground(new Color (235,193,20));
		GPane4.setLayout(new BorderLayout());
		
		
		
		
		GPane4.add(VariListener.SettaPannelloTitolo(im3, Panel5, 1, 0, "Utenti bloccati"), BorderLayout.NORTH);		
		
		
		table4 = new JTable();
		model4 = new ModElUtenti(ElencoUtentiDAO.elencobloccati());
		GPane4.add(VariListener.SettaScroll(table4,50,model4), BorderLayout.CENTER);

		
		
		
		
		BotPnl4 = new JPanel();
		BotPnl4.setBackground(new Color (235,193,20));
		BotPnl4.setLayout(new GridBagLayout());
		
		
		JButton btn9 = new JButton(im);
		JLabel lbl9= new JLabel();
	    VariListener.SettaBtn(BotPnl4, btn9, lbl9,"sblocca utente", 2, 2,im2,true);
		btn9.setMnemonic('e');
		btn9.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(table4.getSelectedRow()!=-1){
				
				int b;
			
				b= (int) table4.getValueAt(table4.getSelectedRow(), 0);
		
			credenzialidao.sblocca(b);
			frame.dispose();
			new FrameElencoUtenti();
			
		}else
			JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
					JOptionPane.WARNING_MESSAGE);
		}		
		});
		
		
		
		
		GPane4.add(BotPnl4,BorderLayout.SOUTH);
		
		tabed.add("Utenti Bloccati",GPane4);
		
		
		
		
		
		
		contentPane.add(tabed);
	}
	

}
