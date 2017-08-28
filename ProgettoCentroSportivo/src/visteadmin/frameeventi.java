package visteadmin;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import ModelliTabelleRespo.modeven;
import classiDAOResponsabile.confeven;
import classiDAOResponsabile.downloaddao;
import classiDAOResponsabile.elencoeventidao;
import classiDAOResponsabile.rimuovieventodao;



public class frameeventi extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JFrame frame;
	
	public static JTable table_2;
      private Object ideven;
      private String user;
	private modeven model;
    private Object codiceturno;
	public JPanel contentPane;
private JButton btnNewButton;

	
	public frameeventi() {
		frame = new JFrame("FrameEventi");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 700, 400);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);

		
	
		

		

		contentPane = new JPanel();
		contentPane.setBackground(new Color (255,193,20));
		contentPane.setLayout(new GridBagLayout());
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
	    
	    
	    
		JLabel lblNewLabel = new JLabel("Richieste iscrizione Eventi");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		gbc.gridwidth = 4;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 0;
		contentPane.add(lblNewLabel, gbc);
		
		
		table_2 = new JTable();
		model = new modeven(elencoeventidao.elencoeven());
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

		
		 btnNewButton = new JButton("Conferma/Annulla Partecipazione");
		btnNewButton .setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton .setForeground(Color.BLACK);
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 4;
		contentPane.add(btnNewButton, gbc);
		
		JButton btnNewButton_1 = new JButton("Download Certificato ");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setForeground(Color.BLACK);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 4;
		gbc.gridy = 4;
		contentPane.add(btnNewButton_1, gbc);
		

		
		
		JButton btnNewButton_2 = new JButton("Elimina Partecipazione");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setForeground(Color.BLACK);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 6;
		gbc.gridy = 4;
		contentPane.add(btnNewButton_2, gbc);
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
 
	ideven = table_2.getValueAt( table_2.getSelectedRow() , 0);
  user= (String) table_2.getValueAt( table_2.getSelectedRow() , 3);
  codiceturno= table_2.getValueAt( table_2.getSelectedRow() , 9);
//   JOptionPane.showMessageDialog(frameeventi.frame, "Il nome utente \""+table_2.getValueAt( table_2.getSelectedRow() , 0)+"\" e\\o l'email \""+table_2.getValueAt( table_2.getSelectedRow() , 0)+"\" sono già in uso, sceglierne altri"," ",JOptionPane.WARNING_MESSAGE);			
     
	   confeven.conf(ideven,user,codiceturno);
			frame.dispose();
			new frameeventi();
			}
		});
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Object a;
			String b;
			a=table_2.getValueAt( table_2.getSelectedRow() , 0);
			b=downloaddao.scarica(a);
			JOptionPane.showMessageDialog(frameeventi.frame, "'"+b+"'");
			}
		});	

		
		
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ideven = table_2.getValueAt( table_2.getSelectedRow() , 0);
				rimuovieventodao.uccudievento(ideven);
				JOptionPane.showMessageDialog(frame, "evento rimosso dal database!!");
			frame.dispose();
			new frameeventi();
				
			
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
