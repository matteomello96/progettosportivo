package visteIstruttore;

import java.awt.BorderLayout;
import ClassiDAOIstruttore.ElencoEventiDAO;
import ClassiDAOIstruttore.EliminaEventoDAO;
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
import java.net.URL;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import ClassiDao.GetInfoDB;
import Model.Utente;
import javax.swing.JScrollPane;
import listener.Listen;
import listener.VariListener;
import modelliTabelleIstruttore.ModElEventiIstr;

public class FrameEventiIstr extends JFrame {
	

	private static final long serialVersionUID = 1L;
	

	public static JFrame frame;

	public JPanel contentPane,Panel1,Panel2, panelCenter, PanelBottom;
	public static JTable table;
	private ModElEventiIstr model;
	int cordx;
	int cordy;

	
	public FrameEventiIstr() {
		String username=""+Utente.getUsername()+"";
		FrameEventiIstr.setDefaultLookAndFeelDecorated(true);
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
				// System.out.println(x+","+y+" "+xi+","+yi);
				frame.setLocation(x, y);

			}
		});

		
		
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenuItem MenuRegistra = new JMenuItem("Torna al panello di controllo");

		menuBar.add(MenuRegistra);
		MenuRegistra.addActionListener(new Listen(this));
		MenuRegistra.setActionCommand("Vai_pan");

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
 		
 		
 		
 		contentPane.add(VariListener.SettaPannelloTitolo(im3, Panel1, 1, 0, "Elenco dei tuoi eventi"), BorderLayout.NORTH);

		
		
		int matricola = GetInfoDB.getidIstr(username);
		table = new JTable();
		model = new ModElEventiIstr(ElencoEventiDAO.elencoiniziale(matricola));
		contentPane.add(VariListener.SettaScroll(table,50,model), BorderLayout.CENTER);

		PanelBottom = new JPanel();
		PanelBottom.setLayout(new GridBagLayout());
		PanelBottom.setBackground(new Color (60,179,113));

		
		JButton btn = new JButton(im);
		JLabel lbl= new JLabel();
        VariListener.SettaBtn(PanelBottom, btn, lbl,"Inserisci evento", 2, 2,im2,true);
		btn.setMnemonic('e');
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl.setForeground(Color.WHITE);
				FrameEventiIstr.frame.dispose();
				new FrameInserisciEv();
			}
		});	
		
		
		
		
		
		JButton btn2 = new JButton(im);
		JLabel lbl2= new JLabel();
        VariListener.SettaBtn(PanelBottom, btn2, lbl2,"Dettagli evento", 3, 2,im2,true);
		btn2.setMnemonic('c');
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1){
					frame.dispose();
				new DetEv((String) FrameEventiIstr.table.getValueAt(FrameEventiIstr.table.getSelectedRow(), 0));
				lbl2.setForeground(Color.WHITE);
				}
				else
					JOptionPane.showMessageDialog(null, "Seleziona un evento dall'elenco","Errore evento",JOptionPane.WARNING_MESSAGE);
			}
		});	
		
		
		
		JButton btn3 = new JButton(im);
		JLabel lbl3= new JLabel();
        VariListener.SettaBtn(PanelBottom, btn3, lbl3,"Modifica evento", 4, 2,im2,true);
		btn3.setMnemonic('d');
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1)
				{
				lbl3.setForeground(Color.WHITE);
			    frame.dispose();
				new FrameModificaEv((String) FrameEventiIstr.table.getValueAt(FrameEventiIstr.table.getSelectedRow(), 0));	
				}
				
				else
					JOptionPane.showMessageDialog(null, "Seleziona un evento dall'elenco","Errore evento",JOptionPane.WARNING_MESSAGE);
			}
		});	
		
		
		JButton btn4 = new JButton(im);
		JLabel lbl4= new JLabel();
        VariListener.SettaBtn(PanelBottom, btn4, lbl4,"Elimina evento",5, 2,im2,true);
		btn4.setMnemonic('e');
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1)
				{
				lbl.setForeground(Color.WHITE);
				boolean bool=EliminaEventoDAO.eliminaevento((String) FrameEventiIstr.table.getValueAt(FrameEventiIstr.table.getSelectedRow(), 0));
				if(bool)
				{
					 frame.dispose();
					 new FrameEventiIstr();
					 FrameEventiIstr.frame.setVisible(true);
					 FrameEventiIstr.frame.setEnabled(true);
					
				}
				}
				else
					JOptionPane.showMessageDialog(null, "Seleziona un evento dall'elenco","Errore evento",JOptionPane.WARNING_MESSAGE);
			}
		});	
		

		contentPane.add(PanelBottom, BorderLayout.SOUTH);

	}

}
