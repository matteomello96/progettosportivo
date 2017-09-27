package view_tesserato;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

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
import classiDAOResponsabile.dettagliiscrizionedao;
import listener.Listen;
import listener.VariListener;
import modelliTabelleRespo.modellidettagli;

public class FrameDettagliModTess2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JFrame frame;
	
	public static JTable table_2,tablemod2;
	private modellidettagli model;
	public JPanel contentPane,pannello,PanelBottom2,Panel1;
	public JButton bottone;
	public JButton bottone1,bottone3;
	
	
	public FrameDettagliModTess2(int cod) {
		frame = new JFrame("FrameDettagliDaAccTess");
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
		mntmNewMenuItem.setActionCommand("elord2");
		
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
		
		
		contentPane.add(VariListener.SettaPannelloTitolo(im3, Panel1, 2, 2,"Dettagli ordine modificato"), BorderLayout.NORTH);
		
		
		
		table_2 = new JTable();
		model = new modellidettagli(dettagliiscrizionedao.elencoiniziale(cod));
		contentPane.add(VariListener.SettaScroll(table_2,50,model), BorderLayout.CENTER);
		
		PanelBottom2 = new JPanel();
		PanelBottom2.setLayout(new GridBagLayout());
		PanelBottom2.setBackground(new Color (42,82,190));

		JButton btn = new JButton(im);
		JLabel lbl= new JLabel();
        VariListener.SettaBtn(PanelBottom2, btn, lbl,"Modifica parte dell'ordine", 2, 2,im2,true);
		btn.setMnemonic('e');
		btn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if(table_2.getSelectedRow()!=-1){
			int tesserato;
			String disciplina,livello,giorno,orario;
			
			        disciplina= (String) table_2.getValueAt(table_2.getSelectedRow(), 0);
					livello=(String) table_2.getValueAt(table_2.getSelectedRow(), 1);
					tesserato=(int) FrameIscrDisc.table3.getValueAt(FrameIscrDisc.table3.getSelectedRow(), 2);
		
			giorno=(String) table_2.getValueAt(table_2.getSelectedRow(), 5);
			orario=(String) table_2.getValueAt(table_2.getSelectedRow(), 6);
			
			
				frame.dispose();
				new FrameModificaTurnoMod(disciplina,livello,tesserato);
			
		}
		
		else
			JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
					JOptionPane.WARNING_MESSAGE);
				
				}}
	
			);		
				
				
				
	
	contentPane.add(PanelBottom2,BorderLayout.SOUTH);
	
	}
	
	
	
	
	

	
	    
	
}
