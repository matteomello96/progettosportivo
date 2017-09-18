package visteIstruttore;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import listener.Listen;
import listener.VariListener;
import modelliTabelleIstruttore.ModDetOrariAtt;
import ClassiDao.GetInfoDB;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import ClassiDAOIstruttore.DettagliOrariAttDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DetAtt {

	public static JFrame frame;
	public JPanel contentPane,tabellaPnl,bottoniPnl1,Panel1,Panel2;
	public static JTable table1;
    private ModDetOrariAtt model1; 
   
    
    
	public  DetAtt(String disciplina,String livello) {
		 disciplina=(String) FrameAttIstr.table.getValueAt(FrameAttIstr.table.getSelectedRow(), 0);
		 livello=(String) FrameAttIstr.table.getValueAt(FrameAttIstr.table.getSelectedRow(), 1);
		
		
		frame = new JFrame("Dettaglio attività");
		frame.setTitle("Dettaglio dell'attività con disciplina: "+disciplina+" livello: "+livello+"");
		frame.setBounds(100, 100, 956, 523);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setAutoRequestFocus(true);
		
		frame.setResizable(true);
		
		

		

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenuItem MenuRegistra = new JMenuItem("Torna alle attività");

		menuBar.add(MenuRegistra);
		MenuRegistra.addActionListener(new Listen(this));
		MenuRegistra.setActionCommand("Vai_att");

		ImageIcon im=new ImageIcon("src/immaginijava/bottone4.png");
        ImageIcon im2=new ImageIcon("src/immaginijava/bottone5.png");
        ImageIcon im3=new ImageIcon("src/immaginijava/titolo2.png");

		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (60,179,113));
		contentPane.setLayout(new BorderLayout());
		
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		scroll.setBounds(100, 100, 605, 391);
		frame.getContentPane().add(scroll);
		
		
		Panel1 = new JPanel();
 		Panel1.setBackground(new Color(60, 179, 113));
 		Panel1.setLayout(new GridBagLayout());
 		
 		
 		
 		contentPane.add(VariListener.SettaPannelloTitolo(im3, Panel1,2, 2, "Turni disponibili"), BorderLayout.NORTH);
		
		
		
		
		table1 = new JTable();
		model1 = new ModDetOrariAtt(DettagliOrariAttDAO.elencoorario(ClassiDao.GetInfoDB.getcombinazionelivdis(disciplina,livello)));
		contentPane.add(VariListener.SettaScroll(table1,50,model1), BorderLayout.CENTER);
		
        bottoniPnl1 = new JPanel();
        bottoniPnl1.setBackground(new Color (60,179,113));
		bottoniPnl1.setLayout(new GridBagLayout());
        
		JButton btn = new JButton(im);
		JLabel lbl= new JLabel();
        VariListener.SettaBtn(bottoniPnl1, btn, lbl,"Elenco partecipanti",0, 2,im2,true);
		btn.setMnemonic('c');
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table1.getSelectedRow()!=-1)
				{
			   lbl.setForeground(Color.WHITE);
			   
				new DetPartAtt();
				frame.setVisible(false);
			   frame.dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "Seleziona un turno dall'elenco","Errore turno",JOptionPane.WARNING_MESSAGE);
			}
		});	
		
		VariListener.SettaPannelloTitolo(im3, bottoniPnl1, 0, 3, "Altre info");
		
		
		
		JLabel costoatt = new JLabel();
		VariListener.SettaLabelGen(bottoniPnl1,costoatt,"Costo mensile dell'attività:", 0, 4);
		
		JLabel costoatt2 = new JLabel();
		VariListener.SettaErr2("'"+GetInfoDB.getcostoatt(disciplina,livello)+"'",costoatt2, 1, 4,bottoniPnl1);
		
		
		 
		contentPane.add(bottoniPnl1, BorderLayout.SOUTH);		
		
		
		
	}
}
