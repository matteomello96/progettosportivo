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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("NuovoPolisportivo");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 6;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblLeNostreDiscipline = new JLabel("Le nostre discipline");
		lblLeNostreDiscipline.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLeNostreDiscipline.setForeground(Color.ORANGE);
		GridBagConstraints gbc_lblLeNostreDiscipline = new GridBagConstraints();
		gbc_lblLeNostreDiscipline.insets = new Insets(0, 0, 5, 5);
		gbc_lblLeNostreDiscipline.gridx = 0;
		gbc_lblLeNostreDiscipline.gridy = 1;
		contentPane.add(lblLeNostreDiscipline, gbc_lblLeNostreDiscipline);
		
		table = new JTable();
		model = new ModDiscIni(ElencoDisciplineDAO.elencoiniziale());
		JScrollPane scrollPane = new JScrollPane();
		
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		contentPane.add(scrollPane, gbc_scrollPane);
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table.setCellSelectionEnabled(true);
		table.setModel(model);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.anchor = GridBagConstraints.NORTH;
		gbc_table.gridwidth = 12;
		gbc_table.fill = GridBagConstraints.HORIZONTAL;
		gbc_table.gridx = 2;
		gbc_table.gridy = 3;
		contentPane.add(table, gbc_table);
	}
	

}
