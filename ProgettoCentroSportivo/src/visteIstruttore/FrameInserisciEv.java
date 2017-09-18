package visteIstruttore;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ClassiDAOIstruttore.ElencoLivDisDAO;
import ClassiDAOIstruttore.InserisciEventoDAO;
import Model.Utente;
import listener.Listen;
import listener.VariListener;
import modelliTabelleIstruttore.ComboSpazio;
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






public class FrameInserisciEv extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private JPanel contentPane,Panel1,Panel2,PanelBottom,Panel3;
	
	private JTextField textnomeevento;
	private JTextField textdescrizione;
	private JTextField textcostoev;
	@SuppressWarnings("rawtypes")
	private JComboBox comboinfopag;
	@SuppressWarnings("rawtypes")
	private JComboBox  combotipoev;
	@SuppressWarnings("rawtypes")
	private JComboBox  combobiscert;
	@SuppressWarnings("rawtypes")
	private JComboBox combofasciaor;
	@SuppressWarnings("rawtypes")
	private JComboBox combogiornoset;
	private JTextField comboprendisp;
	private boolean bool;
	public static ComboSpazio combospazio;
	public static JTable table1,tablemod;
	public ModLivDis model1;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FrameInserisciEv() {
		String username=""+Utente.getUsername()+"";
		int matricola = GetInfoDB.getidIstr(username);
		frame = new JFrame("Inserimento eventi");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.setSize(450, 300);
        frame.setTitle("Inserisci un nuovo evento");
		if(FrameInserisciEv.frame==null)
			frame.setLocationRelativeTo(null);
			else
			frame.setLocation(FrameInserisciEv.frame.getLocation());
		
		
		frame.setVisible(true);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Pagina Eventi");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmTornaAllaPagina = new JMenuItem("Torna alla pagina eventi");
	
		mnNewMenu.add(mntmTornaAllaPagina);
		mntmTornaAllaPagina.addActionListener(new Listen(this));
		mntmTornaAllaPagina.setActionCommand("Vai_home3");
		
	
		
		
		
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
 		
 		
 		
 		
		
        JButton btn = new JButton(im);
		
		JLabel lbl= new JLabel("Inserisci evento");
		
		
		
		
		
		
		
		VariListener.SettaPannelloTitolo(im3, Panel1, 1, 4, "Dati sulle discipline disponibili");
		
		
		contentPane.add(VariListener.SettaPannelloTitolo(im3, Panel1, 1, 0, "Form di inserimento dell'evento"), BorderLayout.NORTH);	
				
		table1 = new JTable();
		model1 = new ModLivDis(ElencoLivDisDAO.elencoiniziale(matricola));
		contentPane.add(VariListener.SettaScroll(table1,50,model1), BorderLayout.CENTER);
		
		Panel3 = new JPanel();
		Panel3.setLayout(new BorderLayout());
		Panel3.setBackground(new Color (60,179,113));
		
		
		Panel2 = new JPanel();
		Panel2.setLayout(new GridBagLayout());
		Panel2.setBackground(new Color (60,179,113));
		
		
		JLabel lblNomeEvento = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblNomeEvento, "Nome dell'evento", 0, 3);
		
		JLabel lblErrNE = new JLabel("");
		VariListener.SettaErr("",lblErrNE, 2, 3, Panel2);
		
		textnomeevento = new JTextField();
		VariListener.SettaTextField(Panel2, textnomeevento, "Inserire nome", 1,3);
		VariListener.SettaFocus(textnomeevento);
		
		JLabel lblDescrizione = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblDescrizione, "Descrizione", 0, 4);
		
		JLabel lblErrD = new JLabel();
		VariListener.SettaErr("",lblErrD, 2, 4, Panel2);
		
		textdescrizione = new JTextField();
		VariListener.SettaTextField(Panel2, textdescrizione, "Inserire descrizione", 1,4);
		VariListener.SettaFocus(textdescrizione);
		
		JLabel lblInfopag = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblInfopag, "Info pagamento", 0, 5);
		
		comboinfopag = new JComboBox();
		comboinfopag.setModel(new DefaultComboBoxModel(new String[] {"Gratuito","A pagamento"}));
		VariListener.SettaBox(Panel2, comboinfopag, 1, 5);
		
		JLabel lblCostoEv = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblCostoEv, "Costo dell'evento", 0, 6);
		
		JLabel lblErrCE = new JLabel();
		VariListener.SettaErr("Il campo non deve contenere lettere",lblErrCE, 2, 6, Panel2);
		
		textcostoev = new JTextField();
		VariListener.SettaTextField(Panel2, textcostoev, "Inserire costo", 1,6);
		VariListener.SettaFocus(textcostoev);
		
		textcostoev.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke)
		
		{
				
				if(!(ke.getKeyChar()+"").matches("[0-9]+$")){
                lblErrCE.setVisible(true);
                btn.setVisible(false);
                lbl.setVisible(false);
                }
				else
				{
				lblErrCE.setVisible(false);
				btn.setVisible(true);
                lbl.setVisible(true);
				}
		}

			});
		
		JLabel lblTipoEvento = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblTipoEvento, "Tipo evento", 0, 7);
		
		combotipoev = new JComboBox();
		combotipoev.setModel(new DefaultComboBoxModel(new String[] {"Gara","Stage"}));
		VariListener.SettaBox(Panel2, combotipoev, 1, 7);
		
		JLabel lblBiscert = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblBiscert, "Bisogno certificato", 0, 8);
		
		combobiscert = new JComboBox();
		combobiscert.setModel(new DefaultComboBoxModel(new String[] {"Si","No"}));
		VariListener.SettaBox(Panel2, combobiscert, 1, 8);
		
		
		
		
		
		VariListener.SettaPannelloTitolo(im3, Panel2, 1, 9, "Dati sull'orario");
		
		
		JLabel lblFasciaoraria = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblFasciaoraria, "Fascia oraria", 0, 10);
		
		combofasciaor = new JComboBox();
		combofasciaor.setModel(new DefaultComboBoxModel(new String[] {"08:30-09:30","09:30-10:30","10:30-11:30","11:30-12:30","12:30-13:30","15:30-16:30","16:30-17:30","17:30-18:30","18:30-19:30","19:30-20:30","20:30-21:30",}));
		VariListener.SettaBox(Panel2, combofasciaor, 1, 10);
		
		JLabel lblGiornoset = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblGiornoset, "Giorno settimanale", 0, 11);
			
		combogiornoset = new JComboBox();
		combogiornoset.setModel(new DefaultComboBoxModel(new String[] {"lunedi","martedi","mercoledi","giovedi","venerdi","sabato"}));
		VariListener.SettaBox(Panel2, combogiornoset, 1, 11);
		
	
		JLabel lblSpazio = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblSpazio, "Spazio", 0, 12);
		
		combospazio = new ComboSpazio();
		VariListener.SettaBox(Panel2, combospazio, 1, 12);
		
		JLabel lblPrenDisp = new JLabel("Prenotazioni disponibili");
		VariListener.SettaLabelGen(Panel2,lblPrenDisp, "Posti disponibili", 0, 13);
		
		JLabel lblErrPD = new JLabel();
		VariListener.SettaErr("Il campo non deve contenere lettere",lblErrPD, 2, 13, Panel2);
		
		comboprendisp = new JTextField();
		VariListener.SettaTextField(Panel2, comboprendisp, "Inserire prenotazioni", 1,13);
		VariListener.SettaFocus(comboprendisp);

		comboprendisp.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke)
		
		{
				
				if(!(ke.getKeyChar()+"").matches("[0-9]+$")){
                lblErrPD.setVisible(true);
                btn.setVisible(false);
                lbl.setVisible(false);
                }
				else
				{
				lblErrPD.setVisible(false);
				btn.setVisible(true);
                lbl.setVisible(true);
				}
		}

			});
		
		Panel3.add(Panel2,BorderLayout.NORTH);
		
		PanelBottom = new JPanel();
		PanelBottom.setLayout(new GridBagLayout());
		PanelBottom.setBackground(new Color (60,179,113));

		
        VariListener.SettaBtn(PanelBottom, btn, lbl,"Inserisci evento", 2, 2,im2,true);
		
		btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			
			
		
		
		if(textnomeevento.getText().isEmpty()||textdescrizione.getText().isEmpty()||textcostoev.getText().isEmpty()||comboprendisp.getText().isEmpty())
		{
			btn.setVisible(false);
            lbl.setVisible(false);
			if(textnomeevento.getText().isEmpty())
			{
				lblNomeEvento.setForeground(Color.BLUE);
				lblNomeEvento.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblErrNE.setText("Il campo è nullo");
				lblErrNE.setVisible(true);
			}
			if(textdescrizione.getText().isEmpty())
			{
				lblDescrizione.setForeground(Color.BLUE);
				lblDescrizione.setFont(new Font("Tahoma", Font.BOLD,16));
				lblErrD.setText("Il campo è nullo");
				lblErrD.setVisible(true);
			}
			if(textcostoev.getText().isEmpty())
			{
				lblCostoEv.setForeground(Color.BLUE);
				lblCostoEv.setFont(new Font("Tahoma", Font.BOLD,16));
				lblErrCE.setText("Il campo è nullo");
				lblErrCE.setVisible(true);
			}
			if(comboprendisp.getText().isEmpty())
			{
				lblPrenDisp.setForeground(Color.BLUE);
				lblPrenDisp.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblErrPD.setText("Il campo è nullo");
				lblErrPD.setVisible(true);
			}
			JOptionPane.showMessageDialog(frame, "Riempire tutti i campi obbligatori"," ",JOptionPane.WARNING_MESSAGE);
		}
		
		else
			
			bool=InserisciEventoDAO.registraevento(GetInfoDB.getcombinazionelivdis((String)FrameInserisciEv.table1.getValueAt(FrameInserisciEv.table1.getSelectedRow(), 0),(String)FrameInserisciEv.table1.getValueAt(FrameInserisciEv.table1.getSelectedRow(),1)),textnomeevento.getText(),textdescrizione.getText(),textcostoev.getText(),comboinfopag.getSelectedItem().toString(),combotipoev.getSelectedItem().toString(),combobiscert.getSelectedItem().toString(),combofasciaor.getSelectedItem().toString(),combogiornoset.getSelectedItem().toString(),combospazio.getSelectedItem().toString(),comboprendisp.getText());
			
		
		if(bool)
		{
			frame.setVisible(false); 
			frame.dispose();
			new FrameEventiIstr();
			FrameEventiIstr.frame.setVisible(true);
			FrameEventiIstr.frame.setEnabled(true);
			
	}
								
		
			}	
		
	})
		
		
		;
		
		Panel3.add(PanelBottom,BorderLayout.CENTER);
		
		contentPane.add(Panel3,BorderLayout.SOUTH);
		
		

	}
	




}

