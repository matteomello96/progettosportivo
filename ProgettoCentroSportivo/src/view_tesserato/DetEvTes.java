package view_tesserato;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import listener.Listen;
import listener.VariListener;
import modelliTabelleIstruttore.ModDetOrariEv;
import visteIstruttore.DetEv;
import visteIstruttore.DetPartEv;
import ClassiDao.GetInfoDB;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import ClassiDAOIstruttore.DettagliOrariEvDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;


public class DetEvTes {

	public static JFrame frame;
	public JPanel contentPane,tabellaPnl,tabellaPnl2,tabellaPnl3,tabellaPnl4,bottoniPnl1,Panel1;
	public static JTable table1,table2,table3,table4;
    private ModDetOrariEv model1; 
    
    
    
	public DetEvTes() {
     String evento=(String) FrameEventi.table.getValueAt(FrameEventi.table.getSelectedRow(), 0);
		setFrame(new JFrame());
		getFrame().setTitle("Dettaglio Evento: "+evento+"");
		getFrame().setBounds(100, 100, 956, 523);
		getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getFrame().setVisible(true);
		getFrame().setLocationRelativeTo(null);
		getFrame().setAutoRequestFocus(true);
		
		getFrame().setResizable(true);
		
		JMenuBar menuBar = new JMenuBar();
		getFrame().setJMenuBar(menuBar);

		JMenuItem MenuRegistra = new JMenuItem("Torna agli eventi");

		menuBar.add(MenuRegistra);
		MenuRegistra.addActionListener(new Listen(this));
		MenuRegistra.setActionCommand("Vai_ev2");
		
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
		contentPane.setBackground(new Color (60,179,113));
		contentPane.setLayout(new BorderLayout());
		
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		scroll.setBounds(100, 100, 605, 391);
		getFrame().getContentPane().add(scroll);
		
		
		Panel1 = new JPanel();
 		Panel1.setBackground(new Color(60, 179, 113));
 		Panel1.setLayout(new GridBagLayout());
 		
 		
 		
 		contentPane.add(VariListener.SettaPannelloTitolo(im3, Panel1,2, 2, "Turni disponibili"), BorderLayout.NORTH);
		
		table1 = new JTable();
		model1 = new ModDetOrariEv(DettagliOrariEvDAO.elencoorario(evento));
		contentPane.add(VariListener.SettaScroll(table1,50,model1), BorderLayout.CENTER);
		
		bottoniPnl1 = new JPanel();
        bottoniPnl1.setBackground(new Color (60,179,113));
		bottoniPnl1.setLayout(new GridBagLayout());
        
        
		JButton btn = new JButton(im);
		JLabel lbl= new JLabel();
        VariListener.SettaBtn(bottoniPnl1, btn, lbl,"Elenco partecipanti",0, 2,im2,true);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table1.getSelectedRow()!=-1)
				{
			   lbl.setForeground(Color.WHITE);
			   
			   
				new DetPartEv((String) DetEv.table1.getValueAt(DetEv.table1.getSelectedRow(), 0),(String) DetEv.table1.getValueAt(DetEv.table1.getSelectedRow(), 1),(String) DetEv.table1.getValueAt(DetEv.table1.getSelectedRow(), 2));
				DetEv.frame.setVisible(false);
				DetEv.frame.dispose();
				
				}
				else
					JOptionPane.showMessageDialog(null, "Seleziona un turno dall'elenco","Errore turno",JOptionPane.WARNING_MESSAGE);
			}
		});	
		
		
        VariListener.SettaPannelloTitolo(im3, bottoniPnl1, 0, 3, "Altre info");
		
		
		
		JLabel costoatt = new JLabel();
		VariListener.SettaLabelGen(bottoniPnl1,costoatt,"Costo mensile dell'attività:", 0, 4);
		
		JLabel costoatt2 = new JLabel();
		VariListener.SettaErr2("'"+GetInfoDB.getcosto(evento)+"'",costoatt2, 1, 4,bottoniPnl1);
		
		
		
		 
		contentPane.add(bottoniPnl1, BorderLayout.SOUTH);		
		
		
	}



	public static JFrame getFrame() {
		return frame;
	}



	public static void setFrame(JFrame frame) {
		DetEvTes.frame = frame;
	}
}
