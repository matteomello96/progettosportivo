package VisteUtenteGenerico;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.border.Border;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;


import ClassiDao.ElencoDisciplineDAO;


import java.awt.ComponentOrientation;
import java.awt.Dimension;

import ModelliTabelle.ModDiscIni;

import Listener.Listen;
import javax.swing.JScrollPane;
import VisteUtenteGenerico.setupTableWidths;
public class FrameIniziale extends JFrame {
	/**
	 * 
	 */
	
	private static  final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	public static  JFrame frame;
    
	public JPanel contentPane,tabellaPnl;
	public static JTable table,tablemod;
    private ModDiscIni model; 
	BufferedImage img;
	int cordx;
	int cordy;
		/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 
	 */
	public FrameIniziale()  {
		
		FrameIniziale.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("Pagina iniziale");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 605, 391);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		
		
		 frame.addMouseListener(new MouseAdapter(){
		       public void mousePressed(MouseEvent ev){
		        cordx = ev.getX();
		         cordy = ev.getY();
		       }
		    });
		   
		    frame.addMouseMotionListener(new MouseMotionAdapter() {
		                public void mouseDragged(MouseEvent evt) {
		                    int x = evt.getXOnScreen()-cordx;
		                    int y = evt.getYOnScreen()-cordy;
		                    //System.out.println(x+","+y+"     "+xi+","+yi);
		                    frame.setLocation(x,y); 

		                }
		            });
		
		
		
		
		
		
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem MenuRegistra = new JMenuItem("Registrati al portale");
	
		menuBar.add(MenuRegistra);
		MenuRegistra.addActionListener(new Listen(this));
		MenuRegistra.setActionCommand("Vai_reg");
		
		JMenuItem MenuAccedi = new JMenuItem("Accedi al portale");
		
		
		menuBar.add(MenuAccedi);
		MenuAccedi.addActionListener(new Listen(this));
		MenuAccedi.setActionCommand("Vai_log");
		contentPane = new JPanel();
		contentPane.setBackground(new Color (255,193,20));
		contentPane.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
        
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		scroll.setBounds(100, 100, 605, 391);
	    frame.getContentPane().add(scroll);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("src/immaginijava/logo.GIF"));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		
		lblNewLabel.setForeground(new Color (0,123,167));
		Border b = BorderFactory.createLineBorder(new Color (255,205,255));
		lblNewLabel.setBorder(b);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 0;
		
		contentPane.add(lblNewLabel, gbc);
		
		JLabel lblLeNostreDiscipline = new JLabel("Le nostre discipline");
		lblLeNostreDiscipline.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLeNostreDiscipline.setForeground(Color.WHITE);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 2;
		contentPane.add(lblLeNostreDiscipline, gbc);
		
		table = new JTable();
		model = new ModDiscIni(ElencoDisciplineDAO.elencoiniziale());
		table.setRowHeight(250);
		table.setRowHeight(3, 250);
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table.setCellSelectionEnabled(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(model);
		tablemod= setupTableWidths.setupTableWidths(table);
		//Dimension d= tablemod.getPreferredScrollableViewportSize();
		tablemod.setForeground(new Color (255,255,255));
		tablemod.setBackground(new Color (235,95,120));
		//tablemod.setSize(750,1000);
		JScrollPane scrollt1 = new JScrollPane();
		scrollt1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollt1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollt1.setBackground(new Color (255,193,20));
		
		
		
		
		
		
		
		
		
		scrollt1.setViewportView(tablemod);
		
		contentPane.add(scrollt1, gbc);
		
		JButton btnNewButton = new JButton("Dettagli Disciplina");
		btnNewButton.setMnemonic('d');
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1)
				new DetDisciplina();
				else
					JOptionPane.showMessageDialog(null, "Seleziona una disciplina dall'elenco","Errore disciplina",JOptionPane.WARNING_MESSAGE);
			}
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 5;
		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
		contentPane.add(btnNewButton,gbc);
		
	}
	
	

}
