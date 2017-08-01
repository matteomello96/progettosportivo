package visteadmin;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTable;



import ModelliTabelle.modelisc;
import classiDAOResponsabile.ConfermaDao;
import classiDAOResponsabile.RichiesteDao;

public class FrameOrdini extends JPanel {

	public static JFrame frame;
	
	public JTable table_2;
	private modelisc model;
	
	
	public FrameOrdini() {
		frame = new JFrame("Iscrizione");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 700, 400);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		//frame.setAlwaysOnTop(true);
		
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 110, 101, 106, 138, 88, 105, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 213, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Richieste iscrizione dai Tesserati");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		frame.add(lblNewLabel, gbc_lblNewLabel);
		
		
		table_2 = new JTable();
		model = new modelisc(RichiesteDao.elencoiniziale());
		table_2.setCellSelectionEnabled(true);
		table_2.setModel(model);
		GridBagConstraints gbc_table_2 = new GridBagConstraints();
		gbc_table_2.gridwidth = 3;
		gbc_table_2.insets = new Insets(0, 0, 5, 5);
		gbc_table_2.fill = GridBagConstraints.BOTH;
		gbc_table_2.gridx = 2;
		gbc_table_2.gridy = 2;
		frame.add(table_2, gbc_table_2);
		
		JButton btnNewButton = new JButton("Conferma/Annulla Iscrizione");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 4;
		frame.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Dettagli Ordine");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 4;
		frame.add(btnNewButton_1, gbc_btnNewButton_1);
		
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
		
		
		
		
		/*btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a;
				
				a=(int) table_2.getValueAt(table_2.getSelectedRow(), 0);
				
				
				
			
//JOptionPane.showMessageDialog(null, "Il nome utente \""+a+"\" e\\o l'email \""+a+"\" sono già in uso, sceglierne altri"," ",JOptionPane.WARNING_MESSAGE);				
		   ConfermaDao.Confermaiscrizione(a);
		   
			
			}
		});*/
	

	}

}
