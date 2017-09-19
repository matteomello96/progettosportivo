package view_tesserato;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import ClassiDaoTesserato.ordineeventodao;
import ComboTesserato.Combocon;
import listener.Listen;
import listener.VariListener;











public class sendeventframe {
	public 	JPanel contentPane,Panel1;
	public JButton btnConferma;
	public static Combocon ComboP;
	public JButton btnTornaAlCarrello;
	public String nomedistinta="";
	public String percorso="";
	public String path="";
	public String pathprecedente="";
    public static JDialog frame;
    public String pagamento;
    public JTextField Casella;
    public int costo;
    public int evento;
public sendeventframe(String tipoevento){
		final DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		
		
		frame = new JDialog(FrameAttivitaTes.frame,true);
		frame.setTitle("Conferma ordine");
		frame.setBounds(100, 100, 803, 364);
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
	
		
		JMenu mnNewMenu = new JMenu("Torna al Pannello di Controllo");
		menuBar.add(mnNewMenu);
		
		
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Pannello di controllo");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new Listen(this));
		mntmNewMenuItem.setActionCommand("send");
		
		
		ImageIcon im=new ImageIcon("src/immaginijava/bottone8.png");
        ImageIcon im2=new ImageIcon("src/immaginijava/bottone9.png");
        ImageIcon im3=new ImageIcon("src/immaginijava/titolo4.png");
		
		
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
		
		
		contentPane.add(VariListener.SettaPannelloTitolo(im3, Panel1, 2, 2,"Altri dettagli"), BorderLayout.NORTH);
		
		
		
		JPanel Pan1 = new JPanel();
		Pan1.setBackground(new Color (42,82,190));
		Pan1.setLayout(new GridBagLayout());
		

		JPanel Pan2 = new JPanel();
		Pan2.setBackground(new Color (42,82,190));
		Pan2.setLayout(new GridBagLayout());
    
		JLabel lblEventi = new JLabel();
		VariListener.SettaLabelGen(Pan1,lblEventi, "Modalità di pagamento", 1, 2);
		
		
		
		
		
		
		ComboP = new Combocon();
		ComboP.setEnabled(true);
		VariListener.SettaBox(Pan1, ComboP, 2, 2);
		
		
		JLabel lblEventi2 = new JLabel("Certificato di sana e robusta costituzione:");
		VariListener.SettaLabelGen(Pan1,lblEventi2," Certificato di sana e robusta costituzione:", 1, 3);
		
		
		
		
		
		JButton btnTornaAlCarrello = new JButton(im);
		JLabel lbl= new JLabel();
        VariListener.SettaBtn(Pan2, btnTornaAlCarrello, lbl,"Torna al carrello", 2, 1,im2,true);
		btnTornaAlCarrello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.setVisible(false);
				
				frame.dispose();
				FrameEventi.frame.setEnabled(true);
				FrameEventi.frame.setAlwaysOnTop(true);
				FrameEventi.frame.setAlwaysOnTop(false);
			}
		});
		
		
		
		
		
		
		
		
	
		
		Casella= new JTextField();
		VariListener.SettaTextField(Pan1, Casella, "Certificato", 2, 3);
		VariListener.SettaFocus(Casella);
		Casella.setEnabled(false);
		Casella.setVisible(false);
		
		
		JButton btnFine = new JButton(im);
		JLabel lbl3= new JLabel();
        VariListener.SettaBtn(Pan1, btnFine,lbl3,"Sfoglia", 3, 3,im2,true);
        
        
         if (tipoevento.equals("Stage"))
		 {
        	 evento=(int) FrameEventi.table_1.getValueAt(0, 8);
        	 costo = 0;
			 pagamento="gratuito";
			 path="null";
			 pathprecedente="null";
			 nomedistinta="null";
			 Casella.setVisible(false);
			 lblEventi.setVisible(false);
			 btnFine.setVisible(false);
			 ComboP.setVisible(false);
			 lblEventi2.setVisible(false);
		 }
        
        
		btnFine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				pagamento=ComboP.getSelectedItem().toString();
				costo=(int) FrameEventi.table_1.getValueAt(0, 7);
				
			    evento=(int) FrameEventi.table_1.getValueAt(0, 8);
				 
				 

				
				 
				 JFileChooser fc = new JFileChooser();
				 int sel = fc.showOpenDialog(frame);
			      if (sel == JFileChooser.APPROVE_OPTION) {
			    	 pathprecedente=(fc.getSelectedFile().getPath());
			         nomedistinta=(fc.getSelectedFile().getName());
			         percorso =("src/certificati");
			         path=percorso+"/"+nomedistinta;
			    
				    }
			      Casella.setVisible(true);
			      Casella.setText(nomedistinta);
			
					
			     
			}}
			

			
			

	           
				
				
		
			
			);
	
		
		
		    JButton btnConferma = new JButton(im);
		    JLabel lbl2= new JLabel();
            VariListener.SettaBtn(Pan2, btnTornaAlCarrello, lbl2,"Conferma", 2, 2,im2,true);
			btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(sendeventframe.frame, pagamento+" "+ path +" "+pathprecedente+" "+evento+" "+costo+" "+" "+tipoevento,null,JOptionPane.WARNING_MESSAGE);
				ordineeventodao.insdetiscr(pagamento,path,pathprecedente, evento, costo,tipoevento);
					frame.dispose();	
					FrameEventi.frame.setEnabled(true);
					FrameEventi.frame.setAlwaysOnTop(true);
					FrameEventi.frame.setAlwaysOnTop(false);
				
				
				
				Casella.setVisible(true);  
				
             
				
				
				
				
				
			}
		});
		
			
			contentPane.add(Pan1,BorderLayout.CENTER);
		contentPane.add(Pan2,BorderLayout.SOUTH);
			
		
	}
}
