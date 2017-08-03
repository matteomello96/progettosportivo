package visteadmin;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import ModelliTabelleRespo.modellidettagli;

import classiDAOResponsabile.dettagliiscrizionedao;

public class framedettagli extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JFrame frame;
	
	public static JTable table_2;
	private modellidettagli model;
	public JPanel contentPane;
	public JButton bottone;
	
	
	public framedettagli(int cod) {
		frame = new JFrame("FrameDettagli");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 700, 400);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		frame.setAlwaysOnTop(true);
		
		
		
		/*GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 110, 101, 106, 138, 88, 105, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 213, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.setLayout(gridBagLayout);
		*/
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (255,193,20));
		contentPane.setLayout(new GridBagLayout());
		
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
		
		JLabel lblNewLabel = new JLabel("Info");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		gbc.gridwidth = 4;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 0;
		contentPane.add(lblNewLabel, gbc);
		
		
	
		
		table_2 = new JTable();
		model = new modellidettagli(dettagliiscrizionedao.elencoiniziale(cod));
		table_2.setCellSelectionEnabled(true);
		table_2.setModel(model);
		
		
		JScrollPane pane2 = new JScrollPane(table_2);
		pane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridwidth = 3;
		gbc.gridx = 2;
		gbc.gridy = 2;
		contentPane.add(pane2,gbc);
		
        bottone= new JButton("Conferma Modifiche");
        bottone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bottone.setForeground(Color.BLACK);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridwidth = 3;
		gbc.gridx = 2;
		gbc.gridy = 3;
		contentPane.add(bottone,gbc);
		
		
		
		
		

	

	}
}
