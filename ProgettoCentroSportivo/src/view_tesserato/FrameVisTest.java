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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import ClassiDaoTesserato.DistruggiTestimonianza;
import ClassiDaoTesserato.ElencoTestDao;
import ClassiDaoTesserato.ModificaCommDao;

import ModelliTabelle_Tesserato.disc_testimonianza;
import listener.Listen;

public class FrameVisTest extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table_1;
	public static JFrame frame;
	 private disc_testimonianza model;
	 public String disciplina;
	 public String livello;
	 public String commento;
	 public JPanel contentPane;
	
	/**
	 * Create the panel.
	 */
	public FrameVisTest() {
		
		
		frame = new JFrame("Visualizza Testimonianze");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 705, 391);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		frame.setAlwaysOnTop(true);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
	
		JMenu mnNewMenu = new JMenu("Pannello di controllo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Torna al pannello di controllo");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new Listen(this));
		mntmNewMenuItem.setActionCommand("vaitest");	
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (255,36,0));
		contentPane.setLayout(new GridBagLayout());
		
		
		
		
		
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
	    
	    GridBagConstraints gbc = new GridBagConstraints();
		
	  
		
			
		JLabel lblNewLabel_1 = new JLabel("Le tue testimonianze");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridwidth = 4;
		gbc.gridx = 3;
		gbc.gridy = 0;
		contentPane.add(lblNewLabel_1, gbc);
		
		table_1 = new JTable();
		model = new disc_testimonianza(ElencoTestDao.elencoiniziale());
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
		gbc.gridx = 3;
		gbc.gridy = 2;
		contentPane.add(pane2, gbc);
		
		
		JButton btnNewButton = new JButton("EliminaTestimonianza");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
	
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 3;
		gbc.gridy = 4;
		contentPane.add(btnNewButton, gbc);
		
	
		
		JButton btnNewButton_2 = new JButton("Modifica Commento");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
	
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 7;
		gbc.gridy = 4;
		contentPane.add(btnNewButton_2, gbc);

		
		JButton btnNewButton_3 = new JButton("Inserisci Commento");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
	
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 9;
		gbc.gridy = 4;
		contentPane.add(btnNewButton_3, gbc);
			
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				disciplina=(String) table_1.getValueAt(table_1.getSelectedRow(), 0);
				livello=(String) table_1.getValueAt(table_1.getSelectedRow(), 1);
				DistruggiTestimonianza.EliminaTest(disciplina,livello);
				frame.dispose();
				new FrameVisTest();
			}
			
		});
		
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				new FrameInsTest();
			}
			
		});
		

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commento=(String) table_1.getValueAt(table_1.getSelectedRow(), 2);
				disciplina=(String) table_1.getValueAt(table_1.getSelectedRow(), 0);
				livello=(String) table_1.getValueAt(table_1.getSelectedRow(), 1);
				ModificaCommDao.Mod_Comm(commento,disciplina,livello);
				
			
			}
			
		});	
		
		
		
	}
}
