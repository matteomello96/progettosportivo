package view_dipendente;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JMenu;
import java.awt.GridBagConstraints;
import javax.swing.JMenuBar;
import java.awt.Insets;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Listener.Listen;

public class FrameTesserato extends JPanel {
	private JTable table;
	public static JFrame frame;
	private JPanel contentPane;

	/**
	 * Create the panel.
	 */
	public FrameTesserato() {
		
		frame = new JFrame("Tesserato");
		frame.setTitle("Frame Tesserato");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 605, 391);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		/*GridBagConstraints gbc_menuBar = new GridBagConstraints();
		gbc_menuBar.anchor = GridBagConstraints.WEST;
		gbc_menuBar.insets = new Insets(0, 0, 5, 0);
		gbc_menuBar.gridx = 0;
		gbc_menuBar.gridy = 0;
		add(menuBar, gbc_menuBar);*/
		
		JMenu mnNewMenu = new JMenu("home");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Logout");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new Listen(this));
		mntmNewMenuItem.setActionCommand("ini");
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("CambiaPassword");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gridBagLayout);
		
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Discipline", "Orari", "Livello"},
				{null, null, null},
				{null, null, null},
			
			},
			new String[] {
				"Disciplina ", "orari ", "Livello"
			})
			
	        	
			
			
			
);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.anchor = GridBagConstraints.NORTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		contentPane.add(table, gbc_table);

	}

}


     





