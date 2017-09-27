package visteIstruttore;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ClassiDAOIstruttore.ModificaAttDAO;
import listener.Listen;
import listener.VariListener;
import modelliTabelleIstruttore.ComboSpazioAltro;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;





public class FrameModificaAtt extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private JPanel contentPane,Panel1,Panel2,PanelBottom
	;
	
	@SuppressWarnings("rawtypes")
	private JComboBox combofasciaor;
	@SuppressWarnings("rawtypes")
	private JComboBox combogiornoset;
	private JTextField comboprendisp;
	private boolean bool;
	public static ComboSpazioAltro combospazio;
	public ClassiDao.GetInfoDB a;
	public String disciplina="";
	public String livello="";
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FrameModificaAtt(String disciplina,String livello) {
		 disciplina=(String) FrameAttIstr.table.getValueAt(FrameAttIstr.table.getSelectedRow(), 0);
		 livello=(String) FrameAttIstr.table.getValueAt(FrameAttIstr.table.getSelectedRow(), 1);
		 
		frame = new JFrame("Modifica  attività  ");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.setSize(450, 300);
        frame.setTitle("Modifica  attività della disciplina: "+disciplina+" livello: "+livello+" ");
       
        frame.setVisible(true);
        
        
	if(FrameModificaAtt.frame==null)
			frame.setLocationRelativeTo(null);
			else
			frame.setLocation(FrameModificaAtt.frame.getLocation());
	JMenuBar menuBar = new JMenuBar();
	frame.setJMenuBar(menuBar);
		
	JMenu mnNewMenu = new JMenu("Pagina Iniziale");
	menuBar.add(mnNewMenu);
	
	JMenuItem mntmTornaAllaPagina = new JMenuItem("Torna al pannello di controllo");

	mnNewMenu.add(mntmTornaAllaPagina);
	mntmTornaAllaPagina.addActionListener(new Listen(this));
	mntmTornaAllaPagina.setActionCommand("Vai_istr1");
		
	
		
		
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
		
		JLabel lbl= new JLabel("Modifica attività");
		
		btn.setVisible(true);
		lbl.setVisible(true);
 
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
		

		

		
		Panel1 = new JPanel();
 		Panel1.setBackground(new Color(60, 179, 113));
 		Panel1.setLayout(new GridBagLayout());
 		
 		
 		
 		
		
		
		
		
		
		
		
		
		
		
		
		
		contentPane.add(VariListener.SettaPannelloTitolo(im3, Panel1, 1, 0, "Form di modifica dell'attività"), BorderLayout.NORTH);	
		
		
		Panel2 = new JPanel();
		Panel2.setLayout(new GridBagLayout());
		Panel2.setBackground(new Color (60,179,113));
		
		
		
		
		
		
		
		
		VariListener.SettaPannelloTitolo(im3, Panel2, 1, 0, "Dati sull'orario");
	
		
		JLabel lblFasciaoraria = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblFasciaoraria, "Fascia oraria", 0, 3);
		
		combofasciaor = new JComboBox();
		combofasciaor.setModel(new DefaultComboBoxModel(new String[] {"08:30-09:30","09:30-10:30","10:30-11:30","11:30-12:30","12:30-13:30","15:30-16:30","16:30-17:30","17:30-18:30","18:30-19:30","19:30-20:30","20:30-21:30",}));
		VariListener.SettaBox(Panel2, combofasciaor, 1, 3);
		
		JLabel lblGiornoset = new JLabel("Giorno della settimana");
		VariListener.SettaLabelGen(Panel2,lblGiornoset, "Giorno settimanale", 0, 4);
			
		combogiornoset = new JComboBox();
		combogiornoset.setModel(new DefaultComboBoxModel(new String[] {"lunedi","martedi","mercoledi","giovedi","venerdi","sabato"}));
		VariListener.SettaBox(Panel2, combogiornoset, 1, 4);
		
	
		JLabel lblSpazio = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblSpazio, "Spazio", 0, 5);
		
		combospazio = new ComboSpazioAltro();
		VariListener.SettaBox(Panel2, combospazio, 1, 5);
		
		JLabel lblPrenDisp = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblPrenDisp, "Posti disponibili", 0, 6);
		
		JLabel lblErrVia = new JLabel("Il campo non deve contenere lettere");
		VariListener.SettaErr("Il campo non deve contenere lettere",lblErrVia, 2, 6, Panel2);
		
		comboprendisp = new JTextField();
		VariListener.SettaTextField(Panel2, comboprendisp, "Inserire prenotazioni", 1,6);
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
		
		
		
		
        contentPane.add(Panel2,BorderLayout.CENTER);
		
		
		PanelBottom = new JPanel();
		PanelBottom.setLayout(new GridBagLayout());
		PanelBottom.setBackground(new Color (60,179,113));

		
        VariListener.SettaBtn(PanelBottom, btn, lbl,"Modifica attività", 2, 2,im2,true);
		
		btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			
			
			

			
		
		
		
			if(comboprendisp.getText().isEmpty())
			{
				lblPrenDisp.setForeground(Color.BLUE);
				lblPrenDisp.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblErrVia.setText("Il campo è nullo");
				lblErrVia.setVisible(true);
			
			JOptionPane.showMessageDialog(frame, "Riempire tutti i campi obbligatori"," ",JOptionPane.WARNING_MESSAGE);
		    }
		
		
			
			bool=ModificaAttDAO.modificaatt( ClassiDao.GetInfoDB.getcombinazionelivdis((String)FrameAttIstr.table.getValueAt(FrameAttIstr.table.getSelectedRow(), 0),(String)FrameAttIstr.table.getValueAt(FrameAttIstr.table.getSelectedRow(), 1)),combofasciaor.getSelectedItem().toString(),combogiornoset.getSelectedItem().toString(),combospazio.getSelectedItem().toString(),comboprendisp.getText());
			
		
		if(bool)
		{
			frame.setVisible(false); 
			frame.dispose();
			
			new FrameAttIstr();
			
	}
								
		
			}	
		
	});
		
		
		
		
	
		 contentPane.add(PanelBottom,BorderLayout.SOUTH);
	
		

	}
		
	

}

