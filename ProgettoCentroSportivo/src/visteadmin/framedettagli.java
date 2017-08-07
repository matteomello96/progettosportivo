package visteadmin;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import ClassiDao.GetInfoDB;
import ModelliTabelleRespo.modellidettagli;
import classiDAOResponsabile.Uccidi_iscrizione;
import classiDAOResponsabile.dettagliiscrizionedao;
import classiDAOResponsabile.modificaordinedao;

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
	public JButton bottone1;
	
	
	public framedettagli(int cod) {
		frame = new JFrame("FrameDettagli");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 700, 400);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		frame.setAlwaysOnTop(true);
		
		
		
		
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
		
        bottone= new JButton("Conferma/Annulla Modifiche");
        bottone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bottone.setForeground(Color.BLACK);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridwidth = 3;
		gbc.gridx = 2;
		gbc.gridy = 3;
		contentPane.add(bottone,gbc);
		
		
		 bottone1= new JButton("elimina attività ");
	        bottone1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			bottone1.setForeground(Color.BLACK);
			gbc.anchor = GridBagConstraints.LINE_END;
			gbc.gridwidth = 3;
			gbc.gridx = 0;
			gbc.gridy = 3;
			contentPane.add(bottone1,gbc);
		
		
	bottone.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			int iddet,tesserato,codiceturno;
			String disciplina,livello,giorno,orario;
			
			disciplina= (String) table_2.getValueAt(table_2.getSelectedRow(), 0);
					livello=(String) table_2.getValueAt(table_2.getSelectedRow(), 1);
					tesserato=(int) FrameOrdini.table_2.getValueAt(FrameOrdini.table_2.getSelectedRow(), 2);
		
			giorno=(String) table_2.getValueAt(table_2.getSelectedRow(), 4);
			orario=(String) table_2.getValueAt(table_2.getSelectedRow(), 5);
			iddet= GetInfoDB.getiddet(disciplina,livello,tesserato);
			codiceturno= GetInfoDB.getcodiceturno(disciplina, livello, giorno, orario);
			
			
			
		
				modificaordinedao.modifica(iddet,tesserato,codiceturno);
				frame.dispose();
				new framedettagli(cod);
		
		}
	}
			);	
	
	
	
	
	
	bottone1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			int iddet,tesserato,codiceturno,conf;
			String disciplina,livello,giorno,orario;
			
			disciplina= (String) table_2.getValueAt(table_2.getSelectedRow(), 0);
			livello=(String) table_2.getValueAt(table_2.getSelectedRow(), 1);
			tesserato=(int) FrameOrdini.table_2.getValueAt(FrameOrdini.table_2.getSelectedRow(), 2);
		    conf=(int) table_2.getValueAt(table_2.getSelectedRow(), 2);
			giorno=(String) table_2.getValueAt(table_2.getSelectedRow(), 4);
			orario=(String) table_2.getValueAt(table_2.getSelectedRow(), 5);
			iddet= GetInfoDB.getiddet(disciplina,livello,tesserato);
			codiceturno= GetInfoDB.getcodiceturno(disciplina, livello, giorno, orario);
			
			
			
		
				Uccidi_iscrizione.Uccidi_isc(iddet,codiceturno,tesserato,conf);
				
				frame.dispose();
				new framedettagli(cod);
		
		}
	}
			);	
	
	
	frame.addWindowListener(new java.awt.event.WindowAdapter() {
		   @Override
		   public void windowClosing(java.awt.event.WindowEvent windowEvent) 
		    {
		    FrameOrdini.frame.setVisible(true);
		    }
		});
		
		

	

	}
}
