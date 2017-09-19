package visteadmin;



import java.awt.BorderLayout;
import java.awt.Color;


import javax.swing.JFrame;
import javax.swing.JPanel;




import listener.Listen;
import listener.VariListener;
import modelliTabelleRespo.ModDetIstr;

import modelliTabelleRespo.ModLivDis;
import classiDAOResponsabile.ElencoDiscLivDispDAO;
import classiDAOResponsabile.GestioneDAO;
import classiDAOResponsabile.DettagliIstruttoreDAO;


import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import java.awt.GridBagLayout;


import javax.swing.JLabel;


import javax.swing.ScrollPaneConstants;


import javax.swing.JScrollPane;
import javax.swing.JTable;




import javax.swing.ImageIcon;
import javax.swing.JButton;







public class FrameInserisciIstrDisp extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private JPanel contentPane;
	public ModLivDis model2;
	public ModDetIstr model1;
	public static JTable table1,table2,tablemod1,tablemod2;
	
	private boolean bool;
	
	
	
	public FrameInserisciIstrDisp( ) {
		
		frame = new JFrame("Inserimento istruttore disponibile");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.setSize(450, 300);
        frame.setTitle("Inserisci un nuovo istruttore disponibile");
		if(FrameInserisciIstrDisp.frame==null)
			frame.setLocationRelativeTo(null);
			else
			frame.setLocation(FrameInserisciIstrDisp.frame.getLocation());
		
		
		
		
		
		
		
		frame.setVisible(true);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Pagina Gestione");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmTornaAllaPagina = new JMenuItem("Torna alla pagina Gestione");
	
		mnNewMenu.add(mntmTornaAllaPagina);
		mntmTornaAllaPagina.addActionListener(new Listen(this));
		mntmTornaAllaPagina.setActionCommand("Vai_home_da_ins_istr");
		
		
		
		ImageIcon im=new ImageIcon("src/immaginijava/bottone4.png");
        ImageIcon im2=new ImageIcon("src/immaginijava/bottone5.png");
        ImageIcon im3=new ImageIcon("src/immaginijava/titolo2.png");
		
		
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
		
		
		
    contentPane.add(VariListener.SettaPannelloTitolo(im3, Panel1, 1, 0, "Form di inserimento istruttore disponibile"), BorderLayout.NORTH);	
		
   /* JPanel Panel4 = new JPanel();
  		Panel4.setBackground(new Color(255,185,0));
  		Panel4.setLayout(new BorderLayout());
		
*/
		
    JPanel Panel2 = new JPanel();
		Panel2.setBackground(new Color(255,185,0));
		Panel2.setLayout(new BorderLayout());
		  	
		
		JPanel Panelco = new JPanel();
 		Panelco.setBackground(new Color(255,185,0));
 		Panelco.setLayout(new GridBagLayout());
		  	
 		 Panel2.add(VariListener.SettaPannelloTitolo(im3, Panelco, 1, 1, "Elenco delle discipline"), BorderLayout.EAST);
 		
		
		  	
	
			
 		table2 = new JTable();
		model2 = new ModLivDis(ElencoDiscLivDispDAO.elencoiniziale());
		Panel2.add(VariListener.SettaScroll(table2,50,model2), BorderLayout.EAST);
		
		
		
		
		
		
	
	 	Panel2.add(VariListener.SettaPannelloTitolo(im3, Panelco, 2, 0, "Elenco degli istruttori"), BorderLayout.WEST);
		table1 = new JTable();
	 	model1 = new ModDetIstr(DettagliIstruttoreDAO.elencoistruttore());
	
		Panel2.add(VariListener.SettaScroll(table1,50,model1), BorderLayout.WEST);
		
		contentPane.add(Panel2,BorderLayout.EAST);
		
		
	
		JPanel PanelBottom = new JPanel();
		PanelBottom.setLayout(new GridBagLayout());
		PanelBottom.setBackground(new Color (255,185,0));
		
		 JButton btnNewButton12 = new JButton(im);
		 JLabel lbl= new JLabel();
		
		  VariListener.SettaBtn(PanelBottom, btnNewButton12, lbl,"Inserisci istruttore disp", 1, 1,im2,true);
		btnNewButton12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
			if((table1.getSelectedRow()!=-1)&&(table2.getSelectedRow()!=-1))
			{
			
			bool = GestioneDAO.inseriscicombis(((String) FrameInserisciIstrDisp.table1.getValueAt(FrameInserisciIstrDisp.table1.getSelectedRow(), 0)),((String) FrameInserisciIstrDisp.table1.getValueAt(FrameInserisciIstrDisp.table1.getSelectedRow(), 1)),((String) FrameInserisciIstrDisp.table2.getValueAt(FrameInserisciIstrDisp.table2.getSelectedRow(), 0)),((String) FrameInserisciIstrDisp.table2.getValueAt(FrameInserisciIstrDisp.table2.getSelectedRow(), 1)));
			}
					
			else{	
			JOptionPane.showMessageDialog(null, "Seleziona una combinazione dall'elenco","Errore combinazione",JOptionPane.WARNING_MESSAGE);
			}
			}			
			
		});	
	
		
	
		if(bool)
		{
			frame.setVisible(false); 
			frame.dispose();
			FrameGestione.frame.dispose();
			new FrameGestione();
			FrameGestione.frame.setVisible(true);
			FrameGestione.frame.setEnabled(true);	
	}	
								
		
		
		contentPane.add(PanelBottom,BorderLayout.SOUTH);		
		
	
		
		
		
	//	gbc_combotipoutente.setModel(new DefaultComboBoxModel(new String[] {"tesserato", "istruttore"}));
		
		

}}

