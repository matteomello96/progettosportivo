package view_tesserato;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import VisteUtenteGenerico.FrameRegistrazione;


public class FrameDiscAttive extends JPanel {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public static JTable table_1;
public static JFrame frame;
private disc_attive model;
public JPanel contentPane;
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
	
	contentPane = new JPanel();
	contentPane.setBackground(new Color (255,36,0));
	contentPane.setLayout(new GridBagLayout());
	
	JScrollPane scroll = new JScrollPane(contentPane);
	scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	scroll.setBounds(50, 30, 300, 50);			
    frame.getContentPane().add(scroll);
	

		
	GridBagConstraints gbc = new GridBagConstraints();
	
	
	
	JLabel lblNewLabel_1 = new JLabel("Completa la scelta degli orari");
	lblNewLabel_1.setForeground(Color.BLACK);
	lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
	
	gbc.insets = new Insets(0, 0, 5, 5);
	gbc.gridwidth = 4;
	gbc.gridx = 3;
	gbc.gridy = 0;
	contentPane.add(lblNewLabel_1, gbc);
	
	table_1 = new JTable();
	model = new disc_attive(elencoattivitaattivedao.elencodopo(momento));
	table_1.setCellSelectionEnabled(true);
	table_1.setModel(model);
	
	
	
	JScrollPane pane2 = new JScrollPane(table_1);
	pane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	pane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	gbc.anchor = GridBagConstraints.LINE_END;
	gbc.gridheight = 2;
	gbc.gridwidth = 6;
	gbc.insets = new Insets(0, 0, 5, 5);
	gbc.fill = GridBagConstraints.BOTH;
	gbc.gridx = 2;
	gbc.gridy = 2;
	contentPane.add(pane2, gbc);

		
	bottone = new JButton("Continua Iscrizione");
	gbc.anchor = GridBagConstraints.WEST;
	gbc.insets = new Insets(0, 0, 5, 5);
	gbc.gridx = 2;
	gbc.gridy = 4;
	contentPane.add(bottone,gbc);
	

	bottone.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			String a="",b="";
		
			a=(String)FrameDiscAttive.table_1.getValueAt(FrameDiscAttive.table_1.getSelectedRow(), 0);
			b=(String)FrameDiscAttive.table_1.getValueAt(FrameDiscAttive.table_1.getSelectedRow(), 1);
		
		new FrameInserisciTurno(a,b,null,null,momento);
		frame.setVisible(false);
		
			
		}
	});
	
	JButton bottone2 = new JButton("Fine inserimento");
	gbc.anchor = GridBagConstraints.WEST;
	gbc.insets = new Insets(0, 0, 5, 5);
	gbc.gridx = 3;
	gbc.gridy = 4;
	contentPane.add(bottone2,gbc);
	bottone2.addActionListener(new ActionListener(){

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
				bottone2.setVisible(true);
				bottone.setVisible(false);
			}
				
			else
			{
				bottone2.setVisible(false);
				}
	
	
	frame.addWindowListener(new java.awt.event.WindowAdapter() {
		   @Override
		   public void windowClosing(java.awt.event.WindowEvent windowEvent) 
		    {
			   FrameAttivitaTes.frame.setVisible(true);
		    
		    }
		});
	
	
		
		
}
}
