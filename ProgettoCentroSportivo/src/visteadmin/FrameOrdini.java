package visteadmin;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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

import ClassiDao.GetInfoDB;
import ModelliTabelleRespo.modelisc;
import ModelliTabelleRespo.modellidettagli;
import classiDAOResponsabile.ConfermaDao;
import classiDAOResponsabile.RichiesteDao;
import classiDAOResponsabile.Uccidi_iscrizione;
import classiDAOResponsabile.dettagliiscrizionedao;
import classiDAOResponsabile.rimuoviordinedao;
import view_tesserato.FrameDiscAttive;
import view_tesserato.FrameTesserato;

public class FrameOrdini extends JPanel {

	public static JFrame frame;
	
	public static JTable table_2;
	public static JTable table;
	private modelisc model;
	private modellidettagli model1;
	public JPanel contentPane;

	
	public FrameOrdini() {
		frame = new JFrame("FrameOrdini");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 700, 400);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);

		
	
		

		

		contentPane = new JPanel();
		contentPane.setBackground(new Color (255,193,20));
		contentPane.setLayout(new GridBagLayout());
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
	    
	    
	    
		JLabel lblNewLabel = new JLabel("Richieste iscrizione dai Tesserati");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		gbc.gridwidth = 4;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 0;
		contentPane.add(lblNewLabel, gbc);
		
		
		table_2 = new JTable();
		model = new modelisc(RichiesteDao.elencoiniziale());
		table_2.setCellSelectionEnabled(true);
		table_2.setModel(model);

		
		
		JScrollPane pane2 = new JScrollPane(table_2);
		pane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 2;
		gbc.gridy = 2;
		
		contentPane.add(pane2, gbc);

		
		JButton btnNewButton = new JButton("Conferma/Annulla Pagamento");
		btnNewButton .setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton .setForeground(Color.BLACK);
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 4;
		contentPane.add(btnNewButton, gbc);
		
		JButton btnNewButton_1 = new JButton("Conferma modifiche iscrizioni ");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setForeground(Color.BLACK);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 4;
		gbc.gridy = 4;
		contentPane.add(btnNewButton_1, gbc);
		
		
		JButton btnNewButton_2 = new JButton("Elimina ordine");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setForeground(Color.BLACK);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 6;
		gbc.gridy = 4;
		contentPane.add(btnNewButton_2, gbc);
		
		
		
	
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idordine;
				
				idordine=(int) table_2.getValueAt(table_2.getSelectedRow(), 0);
				
				
			

		   ConfermaDao.Confermaiscrizione(idordine);
		   frame.dispose();
		   new FrameOrdini();
			
			}
		});
		
		
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		int idordine;
				
			idordine=(int) table_2.getValueAt(table_2.getSelectedRow(), 0);
				
				
	      new framedettagli(idordine);
			frame.setVisible(false);

				
		   
			
			}
		});
		
		
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	int i;
	int cont=0;
	Object idordine;
	idordine=table_2.getValueAt(table_2.getSelectedRow(), 0);
	
	
	
	
	table = new JTable();
	model1 = new modellidettagli(dettagliiscrizionedao.elencoiniziale(idordine));
	table.setCellSelectionEnabled(true);
	table.setModel(model1);
	JOptionPane.showMessageDialog(frame, "'"+idordine+"'");
	JOptionPane.showMessageDialog(frame, "'"+table.getRowCount()+"'");
	
	for(i=0;i<table.getRowCount();i++){
	
	cont=cont+1;	
		
		
	}	
	JOptionPane.showMessageDialog(frame, "'"+cont+"'");	
if(cont==0){
	
	
	rimuoviordinedao.Uccidi_isc(idordine);
	JOptionPane.showMessageDialog(frame, "Ordine rimosso dal database!!");
frame.dispose();
new FrameOrdini();
	
}
    else{
    	JOptionPane.showMessageDialog(frame, "Ci sono ancora discipline registrate in questo ordine.Perfavore elimina prima le discipline!!");
    	cont=0;
    
    }			
				
	     
		

				
		   
			
			}
		});
		

	

		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			   @Override
			   public void windowClosing(java.awt.event.WindowEvent windowEvent) 
			    {
			    FrameResponsabile.frame.setVisible(true);
			    }
			});
		
		
	
		
	}

}
