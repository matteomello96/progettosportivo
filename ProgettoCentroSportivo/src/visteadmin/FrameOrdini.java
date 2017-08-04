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
import classiDAOResponsabile.ConfermaDao;
import classiDAOResponsabile.RichiesteDao;
import view_tesserato.FrameDiscAttive;
import view_tesserato.FrameTesserato;

public class FrameOrdini extends JPanel {

	public static JFrame frame;
	
	public static JTable table_2;
	private modelisc model;
	public JPanel contentPane;

	
	public FrameOrdini() {
		frame = new JFrame("FrameOrdini");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 700, 400);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		//frame.setAlwaysOnTop(true);
		
	
		
	/*	GridBagLayout gridBagLayout = new GridBagLayout();
	   gridBagLayout.columnWidths = new int[]{0, 110, 101, 106, 138, 88, 105, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 213, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.setLayout(gridBagLayout);*/
		

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
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a;
				
				a=(int) table_2.getValueAt(table_2.getSelectedRow(), 0);
				
				
			
//JOptionPane.showMessageDialog(null, "Il nome utente \""+a+"\" e\\o l'email \""+a+"\" sono già in uso, sceglierne altri"," ",JOptionPane.WARNING_MESSAGE);				
		   ConfermaDao.Confermaiscrizione(a);
		   frame.dispose();
		   new FrameOrdini();
			
			}
		});
		
		
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a,b;
				
				a=(int) table_2.getValueAt(table_2.getSelectedRow(), 0);
				b=(int) table_2.getValueAt(table_2.getSelectedRow(), 6);
				if(b==1){
					JOptionPane.showMessageDialog(frame, "non à possibilie modificare i dettagli delle attività. Il pagamento è annullato!! ");
				}
				else{
				new framedettagli(a);
			frame.setVisible(false);

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
