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
public FrameDiscAttive() {
	
	
	
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
	
	
	
	JLabel lblNewLabel_1 = new JLabel("STATO ISCRIZIONE");
	lblNewLabel_1.setForeground(Color.BLACK);
	lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
	
	gbc.insets = new Insets(0, 0, 5, 5);
	gbc.gridwidth = 4;
	gbc.gridx = 3;
	gbc.gridy = 0;
	contentPane.add(lblNewLabel_1, gbc);
	
	table_1 = new JTable();
	model = new disc_attive(elencoattivitaattivedao.elencoiniziale());
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

		
	bottone = new JButton("Modifica Iscrizione");
	gbc.anchor = GridBagConstraints.WEST;
	gbc.insets = new Insets(0, 0, 5, 5);
	gbc.gridx = 2;
	gbc.gridy = 4;
	contentPane.add(bottone,gbc);
	

	bottone.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			String a,b;
			a=(String)FrameDiscAttive.table_1.getValueAt(FrameDiscAttive.table_1.getSelectedRow(), 0);
			b=(String)FrameDiscAttive.table_1.getValueAt(FrameDiscAttive.table_1.getSelectedRow(), 1);
		//	JOptionPane.showMessageDialog(frame, "'"+a+"','"+b+"'");
		new framemodificaturno(a,b,null,null);
		frame.setVisible(false);
			
		}
	});
	
	
	
	
	
	frame.addWindowListener(new java.awt.event.WindowAdapter() {
		   @Override
		   public void windowClosing(java.awt.event.WindowEvent windowEvent) 
		    {
			   FrameTesserato.frame.setVisible(true);
		    
		    }
		});
	
	
		
		
}
}
