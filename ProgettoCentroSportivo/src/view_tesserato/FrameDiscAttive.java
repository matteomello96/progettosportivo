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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import ClassiDaoTesserato.elencoattivitaattivedao;
import ModelliTabelle_Tesserato.disc_attive;
import listener.VariListener;



public class FrameDiscAttive extends JPanel {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public static JTable table_1;
public static JFrame frame;
private disc_attive model;
public JPanel contentPane,Panel1,PanelBottom2;
public JButton bottone;
/**
 * Create the panel.
 */
public FrameDiscAttive(String momento) {
	
	
	
	frame = new JFrame("Riepilogo");
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setBounds(100, 100, 605, 391);
	frame.setVisible(true);
	frame.setAutoRequestFocus(true);
	frame.setResizable(true);
	frame.setAlwaysOnTop(true);
	
	
	
	
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
	
	
	contentPane.add(VariListener.SettaPannelloTitolo(im3, Panel1, 2, 2,"Completa l'iscrizione"), BorderLayout.NORTH);
    
    
    
	table_1 = new JTable();
	model = new disc_attive(elencoattivitaattivedao.elencodopo(momento));
	contentPane.add(VariListener.SettaScroll(table_1,50,model), BorderLayout.CENTER);
		
	
	
	PanelBottom2 = new JPanel();
	PanelBottom2.setLayout(new GridBagLayout());
	PanelBottom2.setBackground(new Color (42,82,190));

	JButton btn = new JButton(im);
	JLabel lbl= new JLabel();
    VariListener.SettaBtn(PanelBottom2, btn, lbl,"Continua iscrizione", 2, 2,im2,true);
	btn.setMnemonic('e');
	btn.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(table_1.getSelectedRow()!=-1){
			String a="",b="";
		
			a=(String)FrameDiscAttive.table_1.getValueAt(FrameDiscAttive.table_1.getSelectedRow(), 0);
			b=(String)FrameDiscAttive.table_1.getValueAt(FrameDiscAttive.table_1.getSelectedRow(), 1);
		
		new FrameInserisciTurno(a,b,null,null,momento);
		frame.dispose();
		
			
		}
		
		else
			JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
					JOptionPane.WARNING_MESSAGE);
	}});
	
	
	
	JButton btn2 = new JButton(im);
	
	JLabel lbl2= new JLabel();
    VariListener.SettaBtn(PanelBottom2, btn2, lbl2,"Fine inserimento", 2, 3,im2,true);
	btn2.setMnemonic('f');
	btn2.setVisible(false);
	btn2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
	          frame.dispose();
	          new PannelloTesserato();
		}
	});
	
	
	
	int in=table_1.getRowCount();
	
	int count=table_1.getRowCount();
	String o="b";
	

		
		
		
		String[] array1= new String[in];
		String[] array2= new String[in];
			for(in=0;in<count;in++){
				if (table_1.getValueAt(in, 2)==null){
					array1[in]="";
						
				}else
				{
			array1[in] =  (String)table_1.getValueAt(in, 2);
				}
				if (table_1.getValueAt(in, 3)==null){
					array2[in]="";
				}else
				{	
			  array2[in] = (String)table_1.getValueAt(in, 3);
			    }
			}
			for (in=0;in<count;in++)
			{
				
				if(!(array1[in].equals(""))&&(!(array2[in].equals(""))))
				{
					o="a";
				}
				else{
					o="b";
				}
				
			}
			
			if (o.equals("a")){
				btn2.setVisible(true);
				btn.setVisible(false);
			}
				
			else
			{
				btn2.setVisible(false);
				}
	
	contentPane.add(PanelBottom2,BorderLayout.SOUTH);
	
	
	frame.addWindowListener(new java.awt.event.WindowAdapter() {
		   @Override
		   public void windowClosing(java.awt.event.WindowEvent windowEvent) 
		    {
			   FrameAttivitaTes.frame.setVisible(true);
		    
		    }
		});
	
	
		
		
}
}
