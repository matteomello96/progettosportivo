package VisteUtenteGenerico;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import ClassiDao.ElencoDisciplineDAO;

import java.awt.Scrollbar;
import java.awt.ComponentOrientation;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import Model.Home;
import ModelliTabelle.ModDiscIni;
import Listener.Listen;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class FrameIniziale extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public static JFrame frame;
	
	public JPanel contentPane;
	public JTable table;
    private ModDiscIni model;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public FrameIniziale() {
		frame = new JFrame("Pagina iniziale");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 605, 391);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		
		
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
		contentPane.setBackground(new Color (64,224,208));
		contentPane.setLayout(new GridBagLayout());
		 
		GridBagConstraints gbc = new GridBagConstraints();
 
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
		
		JLabel lblNewLabel = new JLabel("NuovoPolisportivo");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 6;
		gbc.gridy = 0;
		contentPane.add(lblNewLabel, gbc);
		
		JLabel lblLeNostreDiscipline = new JLabel("Le nostre discipline");
		lblLeNostreDiscipline.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLeNostreDiscipline.setForeground(Color.ORANGE);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 1;
		contentPane.add(lblLeNostreDiscipline, gbc);
		
		table = new JTable();
		model = new ModDiscIni(ElencoDisciplineDAO.elencoiniziale());
		table.setRowHeight(20);
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table.setCellSelectionEnabled(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(model);
		
		
		JScrollPane pane2 = new JScrollPane(table);
		pane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridwidth = 2;
		gbc.gridx = 2;
		gbc.gridy = 3;
		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
		contentPane.add(pane2,gbc);
		
	}
	

}
