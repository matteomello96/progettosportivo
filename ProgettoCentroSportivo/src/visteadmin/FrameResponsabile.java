package visteadmin;

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



import java.awt.ComponentOrientation;

import Model.Utente;
import ModelliTabelleRespo.ModElUtenti;
import VisteUtenteGenerico.FrameCambia;
import classiDAOResponsabile.ElencoUtentiDAO;
import Listener.Listen;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class FrameResponsabile extends JFrame {
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
    private ModElUtenti model;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public FrameResponsabile() {
		frame = new JFrame("Pagina iniziale Responsabile");
		String username=""+Utente.getUsername()+"";
		frame.setTitle("Benvenuto responsabile "+username+"");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1000, 1000);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		
	
		JMenu mnNewMenu = new JMenu("Home");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Logout");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new Listen(this));
		mntmNewMenuItem.setActionCommand("iniresp");
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("CambiaPassword");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrameCambia();
			
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem MenuOrdini = new JMenuItem("Visualizza richieste di pagamento");
		MenuOrdini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrameOrdini();
				
				
			}
		});
		mnNewMenu.add(MenuOrdini);

		JMenuItem MenuDiscipline = new JMenuItem("Discipline");
		MenuDiscipline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new framediscdisp();
				
			
			}
		});
		
		
		mnNewMenu.add(MenuDiscipline);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (255,193,20));
		contentPane.setLayout(new GridBagLayout());
		 
		GridBagConstraints gbc = new GridBagConstraints();
 
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
		
		
		JLabel lblUtenti = new JLabel("Elenco degli utenti");
		lblUtenti.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUtenti.setForeground(Color.WHITE);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 1;
		contentPane.add(lblUtenti, gbc);
		
		table = new JTable();
		model = new ModElUtenti(ElencoUtentiDAO.elencoiniziale());
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
