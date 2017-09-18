package visteIstruttore;

import java.awt.BorderLayout;
import ClassiDAOIstruttore.ElencoAttDAO;
import ClassiDAOIstruttore.GestioneIstruttoreDAO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;                                   
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import ClassiDao.GetInfoDB;
import Model.Utente;
import javax.swing.JScrollPane;
import listener.Listen;
import listener.VariListener;
import modelliTabelleIstruttore.ModElAttIstr;


public class FrameAttIstr extends JFrame {
	

	private static final long serialVersionUID = 1L;
	

	public static JFrame frame;

	public JPanel contentPane, PanelBottom,Panel1,Panel2,Panel3;
	public static JTable table;
	private ModElAttIstr model;
	
	int cordx;
	int cordy;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 */
	public FrameAttIstr() {
		String username=""+Utente.getUsername()+"";
		FrameAttIstr.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("Pagina iniziale");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(200, 200, 705, 491);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);

		frame.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent ev) {
				cordx = ev.getX();
				cordy = ev.getY();
			}
		});

		frame.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent evt) {
				int x = evt.getXOnScreen() - cordx;
				int y = evt.getYOnScreen() - cordy;
				frame.setLocation(x, y);

			}
		});

		

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenuItem MenuRegistra = new JMenuItem("Torna al panello di controllo");

		menuBar.add(MenuRegistra);
		MenuRegistra.addActionListener(new Listen(this));
		MenuRegistra.setActionCommand("Vai_pan_da_att");

		ImageIcon im=new ImageIcon("src/immaginijava/bottone4.png");
        ImageIcon im2=new ImageIcon("src/immaginijava/bottone5.png");
        ImageIcon im3=new ImageIcon("src/immaginijava/titolo2.png");
		
		
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
 		
 		
 		
 		contentPane.add(VariListener.SettaPannelloTitolo(im3, Panel1, 1, 0, "Le tue attività"), BorderLayout.NORTH);
		

		

		
		int matricola = GetInfoDB.getidIstr(username);
		table = new JTable();
		model =   new ModElAttIstr(ElencoAttDAO.elencoiniziale(matricola));
		contentPane.add(VariListener.SettaScroll(table,50,model), BorderLayout.CENTER);

		PanelBottom = new JPanel();
		PanelBottom.setLayout(new GridBagLayout());
		PanelBottom.setBackground(new Color (60,179,113));

		JButton btn = new JButton(im);
		JLabel lbl= new JLabel();
        VariListener.SettaBtn(PanelBottom, btn, lbl,"Inserisci attività", 2, 2,im2,true);
		btn.setMnemonic('e');
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl.setForeground(Color.WHITE);
				FrameAttIstr.frame.dispose();
				new FrameInserisciAtt();
			}
		});	
		
		
		
		
		
		
		JButton btn2 = new JButton(im);
		JLabel lbl2= new JLabel();
        VariListener.SettaBtn(PanelBottom, btn2, lbl2,"Dettagli attività", 3, 2,im2,true);
		btn2.setMnemonic('c');
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1){
					lbl2.setForeground(Color.WHITE);
				new DetAtt((String) FrameAttIstr.table.getValueAt(FrameAttIstr.table.getSelectedRow(), 1),(String) FrameAttIstr.table.getValueAt(FrameAttIstr.table.getSelectedRow(), 1));
				FrameAttIstr.frame.dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "Seleziona un'attività dall'elenco","Errore attività",JOptionPane.WARNING_MESSAGE);
			}
		});	
		
		
		
		JButton btn3 = new JButton(im);
		JLabel lbl3= new JLabel();
        VariListener.SettaBtn(PanelBottom, btn3, lbl3,"Modifica attività", 4, 2,im2,true);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1)
				{
				lbl3.setForeground(Color.WHITE);	
				FrameAttIstr.frame.dispose();
				new FrameModificaAtt((String) FrameAttIstr.table.getValueAt(FrameAttIstr.table.getSelectedRow(), 0),(String) FrameAttIstr.table.getValueAt(FrameAttIstr.table.getSelectedRow(),1));
				}
				else
					JOptionPane.showMessageDialog(null, "Seleziona un'attività dall'elenco","Errore attività",JOptionPane.WARNING_MESSAGE);
			}
		});	
		
		
		JButton btn4 = new JButton(im);
		JLabel lbl4= new JLabel();
        VariListener.SettaBtn(PanelBottom, btn4, lbl4,"Elimina attività",5, 2,im2,true);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1){
					lbl4.setBackground(Color.WHITE);
				boolean bool= GestioneIstruttoreDAO.eliminaatt(ClassiDao.GetInfoDB.getcombinazionelivdis((String) FrameAttIstr.table.getValueAt(FrameAttIstr.table.getSelectedRow(), 0),(String) FrameAttIstr.table.getValueAt(FrameAttIstr.table.getSelectedRow(), 1)));
				
				if(bool)
				{
					 frame.dispose();
					 new FrameAttIstr();
					 FrameAttIstr.frame.setVisible(true);
					 FrameAttIstr.frame.setEnabled(true);
					
				}
				}
				else
					JOptionPane.showMessageDialog(null, "Seleziona un'attività dall'elenco","Errore attività",JOptionPane.WARNING_MESSAGE);
			}
		});	
		

		contentPane.add(PanelBottom, BorderLayout.SOUTH);

	}

}
