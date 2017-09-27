package visteIstruttore;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ClassiDAOIstruttore.ElencoLivDisDAO;
import ClassiDAOIstruttore.InserisciAttDAO;
import Model.Utente;
import listener.Listen;
import listener.VariListener;
import modelliTabelleIstruttore.ComboDis;
import modelliTabelleIstruttore.ComboLivelloIs;
import modelliTabelleIstruttore.ComboSpazioAltro;
import modelliTabelleIstruttore.ModLivDis;
import ClassiDao.GetInfoDB;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;






public class FrameInserisciAtt extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private JPanel contentPane,Panel1,Panel2,PanelBottom,Panel3;
	public ModLivDis model1;
	public static JTable table1,tablemod;
	@SuppressWarnings("rawtypes")
	private JComboBox combofasciaor;
	@SuppressWarnings("rawtypes")
	private JComboBox combogiornoset;
	private JTextField comboprendisp;
	private boolean bool;
	public static ComboSpazioAltro combospazio;
	public static ComboDis combodis;
	public static ComboLivelloIs combolivellois;
	public String disciplina="";
	public String livello="";
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FrameInserisciAtt() {
		
		frame = new JFrame("Inserimento attività");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.setSize(450, 300);
        frame.setTitle("Inserisci una nuova attività");
		if(FrameInserisciAtt.frame==null)
			frame.setLocationRelativeTo(null);
			else
			frame.setLocation(FrameInserisciAtt.frame.getLocation());
		frame.setVisible(true);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Torna alle attività");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmTornaAllaPagina = new JMenuItem("Torna alle attività");
	
		mnNewMenu.add(mntmTornaAllaPagina);
		mntmTornaAllaPagina.addActionListener(new Listen(this));
		mntmTornaAllaPagina.setActionCommand("Vai_home4");
		
		String username=""+Utente.getUsername()+"";
		int matricola = GetInfoDB.getidIstr(username);
	
		URL url1 = ClassLoader.getSystemResource("immaginijava/bottone4.png");
		URL url2 = ClassLoader.getSystemResource("immaginijava/bottone5.png");
		URL url3 = ClassLoader.getSystemResource("immaginijava/titolo2.png");
        ImageIcon im=new ImageIcon(url1);
        ImageIcon im2=new ImageIcon(url2);
        ImageIcon im3=new ImageIcon(url3);

		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (60,179,113));
		contentPane.setLayout(new BorderLayout());
		
        JButton btn = new JButton(im);
		
		JLabel lbl= new JLabel("Inserisci attività");
		
 
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
		

		

		
		Panel1 = new JPanel();
 		Panel1.setBackground(new Color(60, 179, 113));
 		Panel1.setLayout(new GridBagLayout());
 		
 		
 		
 		
		
		
		
		
		
		
		
		
		
		VariListener.SettaPannelloTitolo(im3, Panel1, 1, 4, "Dati sulle discipline disponibili");
		
		
		contentPane.add(VariListener.SettaPannelloTitolo(im3, Panel1, 1, 0, "Form di inserimento dell'attività"), BorderLayout.NORTH);		
		
		
		table1 = new JTable();
		model1 = new ModLivDis(ElencoLivDisDAO.elencoiniziale(matricola));
		contentPane.add(VariListener.SettaScroll(table1,50,model1), BorderLayout.CENTER);
		
		Panel3 = new JPanel();
		Panel3.setLayout(new BorderLayout());
		Panel3.setBackground(new Color (60,179,113));
		
		
		Panel2 = new JPanel();
		Panel2.setLayout(new GridBagLayout());
		Panel2.setBackground(new Color (60,179,113));
	
		
		
		VariListener.SettaPannelloTitolo(im3, Panel2, 1, 5, "Dati sull'orario");
		
		
		JLabel lblFasciaoraria = new JLabel("Fascia oraria");
		VariListener.SettaLabelGen(Panel2,lblFasciaoraria, "Fascia oraria", 0, 6);
		
		combofasciaor = new JComboBox();
		combofasciaor.setModel(new DefaultComboBoxModel(new String[] {"08:30-09:30","09:30-10:30","10:30-11:30","11:30-12:30","12:30-13:30","15:30-16:30","16:30-17:30","17:30-18:30","18:30-19:30","19:30-20:30","20:30-21:30",}));
		VariListener.SettaBox(Panel2, combofasciaor, 1, 6);
		
		JLabel lblGiornoset = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblGiornoset, "Giorno settimanale", 0, 7);
			
		combogiornoset = new JComboBox();
		combogiornoset.setModel(new DefaultComboBoxModel(new String[] {"lunedi","martedi","mercoledi","giovedi","venerdi","sabato"}));
		VariListener.SettaBox(Panel2, combogiornoset, 1, 7);
		
	
		JLabel lblSpazio = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblSpazio, "Spazio", 0, 8);
		
		combospazio = new ComboSpazioAltro();
		VariListener.SettaBox(Panel2, combospazio, 1, 8);
		
		JLabel lblPrenDisp = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblPrenDisp, "Posti disponibili", 0, 9);
		
		JLabel lblErrVia = new JLabel();
		VariListener.SettaErr("Il campo non deve contenere lettere",lblErrVia, 2, 9, Panel2);
		
		comboprendisp = new JTextField();
		VariListener.SettaTextField(Panel2, comboprendisp, "Inserire prenotazioni", 1,9);
		VariListener.SettaFocus(comboprendisp);
		
		
		comboprendisp.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke)
		
		{
				
				if(!(ke.getKeyChar()+"").matches("[0-9]+$")){
                lblErrVia.setVisible(true);
                btn.setVisible(false);
                lbl.setVisible(false);
                }
				else
				{
				lblErrVia.setVisible(false);
				btn.setVisible(true);
                lbl.setVisible(true);
				}
		}

			});
		
		Panel3.add(Panel2,BorderLayout.NORTH);
		
		
		PanelBottom = new JPanel();
		PanelBottom.setLayout(new GridBagLayout());
		PanelBottom.setBackground(new Color (60,179,113));

		
        VariListener.SettaBtn(PanelBottom, btn, lbl,"Inserisci attività", 2, 2,im2,true);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			

			
			
		
		
		if(comboprendisp.getText().isEmpty())
		{
			
			
			if(comboprendisp.getText().isEmpty())
			{
				lblPrenDisp.setForeground(Color.BLUE);
				lblPrenDisp.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblErrVia.setText("Il campo è nullo");
				lblErrVia.setVisible(true);
				btn.setVisible(false);
                lbl.setVisible(false);
			}
			JOptionPane.showMessageDialog(frame, "Riempire tutti i campi obbligatori"," ",JOptionPane.WARNING_MESSAGE);
		}
		
		else
		{	
			btn.setVisible(true);
        lbl.setVisible(true);
        lbl.setForeground(Color.WHITE);
			bool=InserisciAttDAO.registraatt((String)FrameInserisciAtt.table1.getValueAt(FrameInserisciAtt.table1.getSelectedRow(), 0),(String)FrameInserisciAtt.table1.getValueAt(FrameInserisciAtt.table1.getSelectedRow(),1),combofasciaor.getSelectedItem().toString(),combogiornoset.getSelectedItem().toString(),combospazio.getSelectedItem().toString(),comboprendisp.getText());
			
		
		if(bool)
		{
			frame.setVisible(false); 
			frame.dispose();
			new FrameAttIstr();
			
			
	}
		}						
		
			}	
		
	})
		
		
		;
		
		Panel3.add(PanelBottom,BorderLayout.CENTER);
		
		contentPane.add(Panel3,BorderLayout.SOUTH);
		
		

}}

