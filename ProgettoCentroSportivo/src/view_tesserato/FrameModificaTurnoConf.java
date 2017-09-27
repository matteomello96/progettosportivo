package view_tesserato;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
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
import ClassiDaoTesserato.ElencoGiornoOraDAO;
import ClassiDaoTesserato.Modifica_Turno_Dao;
import ComboTesserato.Combogiorno;
import ComboTesserato.Comboorario;
import ModelliTabelle_Tesserato.ModGiornoOra;
import listener.Listen;
import listener.VariListener;










public class FrameModificaTurnoConf extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public JButton btnNewButton;
	public static JFrame frame;
	public static Comboorario Comboorario;
	public static Combogiorno Combogiorno;
	public String ora=(String) FrameDettagliConfTess.table_2.getValueAt(FrameDettagliConfTess.table_2.getSelectedRow(), 6);
	public String giorno=(String) FrameDettagliConfTess.table_2.getValueAt(FrameDettagliConfTess.table_2.getSelectedRow(), 5);
	public JButton btnNewButton_1;
    public JPanel contentPane,Panel1,PanelBottom2;
    public String giorno2;
	public String orario2;
	public static JTable table2;



	public JTable tablemod2;
	public ModGiornoOra model2;
	
	private int codiceturno;
	private int postidisponibili;
	
	
	public FrameModificaTurnoConf(String disciplina, String livello,int tesserato) {
		final DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		
		frame = new JFrame("Modifica turno disciplina:"+disciplina+" livello: "+livello+"");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 605, 391);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		frame.setAlwaysOnTop(true);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		
	
		JMenu mnNewMenu = new JMenu("Pannello Ordini");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Torna agli ordini confermati");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new Listen(this));
		mntmNewMenuItem.setActionCommand("mt2");
		
		URL url1 = ClassLoader.getSystemResource("immaginijava/bottone8.png");
		URL url2 = ClassLoader.getSystemResource("immaginijava/bottone9.png");
		URL url3 = ClassLoader.getSystemResource("immaginijava/titolo4.png");
        ImageIcon im=new ImageIcon(url1);
        ImageIcon im2=new ImageIcon(url2);
        ImageIcon im3=new ImageIcon(url3);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (42,82,190));
		contentPane.setLayout(new BorderLayout());
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (42,82,190));
		contentPane.setLayout(new BorderLayout());
		

		
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
		
	    Panel1 = new JPanel();
		Panel1.setBackground(new Color (42,82,190));
		Panel1.setLayout(new GridBagLayout());
		
		
		contentPane.add(VariListener.SettaPannelloTitolo(im3, Panel1, 2, 2,"Giorni e fasce orarie disponibili"), BorderLayout.NORTH);
		
		table2 = new JTable();
		model2 = new ModGiornoOra(ElencoGiornoOraDAO.elencoiniziale(disciplina, livello));
        contentPane.add(VariListener.SettaScroll(table2,50,model2), BorderLayout.CENTER);
		
		PanelBottom2 = new JPanel();
		PanelBottom2.setLayout(new GridBagLayout());
		PanelBottom2.setBackground(new Color (42,82,190));

		JButton btn = new JButton(im);
		JLabel lbl= new JLabel();
        VariListener.SettaBtn(PanelBottom2, btn, lbl,"Modifica giorno e ora", 2, 2,im2,true);
		btn.setMnemonic('e');
		btn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if(table2.getSelectedRow()!=-1){
						
				   String  giorno2 =	(String) FrameModificaTurnoConf.table2.getValueAt(FrameModificaTurnoConf.table2.getSelectedRow(), 0);
				   String orario2= (String) FrameModificaTurnoConf.table2.getValueAt(FrameModificaTurnoConf.table2.getSelectedRow(), 1);
				    codiceturno = GetInfoDB.getcodiceturno2(disciplina,livello ,giorno2 ,orario2);
			        int iddet= GetInfoDB.getiddet3(disciplina, livello, tesserato,(String) FrameDettagliConfTess.table_2.getValueAt(FrameDettagliConfTess.table_2.getSelectedRow(), 5), (String) FrameDettagliConfTess.table_2.getValueAt(FrameDettagliConfTess.table_2.getSelectedRow(), 6));
			        JOptionPane.showMessageDialog(frame,""+iddet+""+""+giorno2+""+orario2+"");
			        int codturnoprec=GetInfoDB.getcodiceturno2(disciplina, livello, (String) FrameDettagliConfTess.table_2.getValueAt(FrameDettagliConfTess.table_2.getSelectedRow(), 5), (String) FrameDettagliConfTess.table_2.getValueAt(FrameDettagliConfTess.table_2.getSelectedRow(), 6));
					postidisponibili = GetInfoDB.getprenotazioni(codiceturno);
					if(postidisponibili==0){
						JOptionPane.showMessageDialog(FrameDettagliConfTess.frame, "Posti massimi raggiunti"," ",JOptionPane.WARNING_MESSAGE);	
					}
					else{
					
					Modifica_Turno_Dao.ModificaDaConf(livello,disciplina,giorno2,orario2,tesserato,iddet,codturnoprec);
					
			        JOptionPane.showMessageDialog(frame,"La modifica è stata apportata.Attendi la conferma da parte del responsabile!");
					frame.dispose();
					new FrameIscrDisc();
					}
					}
					else
						JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
								JOptionPane.WARNING_MESSAGE);
						
						
		}}
					);
			
		
			
			
			
			

			
		contentPane.add(PanelBottom2,BorderLayout.SOUTH);
			

			
			
	}

}
