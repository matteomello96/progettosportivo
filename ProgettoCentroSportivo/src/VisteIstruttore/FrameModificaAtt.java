package VisteIstruttore;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent.KeyBinding;

import ClassiDAOIstruttore.InserisciEventoDAO;
import ClassiDAOIstruttore.ModificaAttDAO;
import ClassiDAOIstruttore.ModificaEventoDAO;
import Listener.Listen;
import Model.Home;
import ModelliTabelleIstruttore.ComboSpazio;
import ModelliTabelleIstruttore.ComboSpazioAltro;
import VisteUtenteGenerico.*;

import ClassiDao.Reg_dao;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import java.awt.Component;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;





public class FrameModificaAtt extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private JPanel contentPane;
	
	
	
	private JComboBox combofasciaor;
	private JComboBox combogiornoset;
	private JTextField comboprendisp;
	private boolean bool;
	public static ComboSpazioAltro combospazio;
	public ClassiDao.GetInfoDB a;
	
	public FrameModificaAtt() {
		String disciplina=(String) FrameIstruttore.table2.getValueAt(FrameIstruttore.table2.getSelectedRow(), 0);
		String livello=(String) FrameIstruttore.table2.getValueAt(FrameIstruttore.table2.getSelectedRow(), 1);
		frame = new JFrame("Modifica  attività  ");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.setSize(450, 300);
        frame.setTitle("Modifica  attività della disciplina: "+disciplina+" livello: "+livello+" ");
       
		if(FrameModificaAtt.frame==null)
			frame.setLocationRelativeTo(null);
			else
			frame.setLocation(FrameModificaAtt.frame.getLocation());
		
		
		
		
	
		
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (64,224,208));
		contentPane.setLayout(new GridBagLayout());
		 
		 GridBagConstraints gbc = new GridBagConstraints();
 
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
		
		
		frame.setVisible(true);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Pagina Iniziale");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmTornaAllaPagina = new JMenuItem("Torna alla pagina iniziale dell'istruttore");
	
		mnNewMenu.add(mntmTornaAllaPagina);
		mntmTornaAllaPagina.addActionListener(new Listen(this));
		mntmTornaAllaPagina.setActionCommand("Vai_istr1");
		
		
		
		JLabel lblFormDiModifica = new JLabel("Form di Modifica dell'Attività");
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		contentPane.add(lblFormDiModifica, gbc);
		
		
		
		
		
		
		
		
		
		
		
		JLabel lblDatiorario = new JLabel("Dati sull'orario");
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 2;
		contentPane.add(lblDatiorario, gbc);
		
		
		JLabel lblFasciaoraria = new JLabel("Fascia oraria");
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 3;
		contentPane.add(lblFasciaoraria, gbc);
		
		combofasciaor = new JComboBox();
		combofasciaor.setModel(new DefaultComboBoxModel(new String[] {"08:30-09:30","09:30-10:30","10:30-11:30","11:30-12:30","12:30-13:30","15:30-16:30","16:30-17:30","17:30-18:30","18:30-19:30","19:30-20:30","20:30-21:30",}));
		combofasciaor.setVisible(true);
		combofasciaor.setEnabled(true);
		combofasciaor.setEditable(false);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 3;
		contentPane.add(combofasciaor, gbc);
		
		JLabel lblGiornoset = new JLabel("Giorno della settimana");
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 4;
		contentPane.add(lblGiornoset, gbc);
			
		combogiornoset = new JComboBox();
		combogiornoset.setModel(new DefaultComboBoxModel(new String[] {"lunedi","martedi","mercoledi","giovedi","venerdi","sabato"}));
		combogiornoset.setVisible(true);
		combogiornoset.setEnabled(true);
		combogiornoset.setEditable(false);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 4;
		contentPane.add(combogiornoset, gbc);
		
	
		JLabel lblSpazio = new JLabel("Spazio");
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 5;
		contentPane.add(lblSpazio, gbc);
		
		combospazio = new ComboSpazioAltro();
		combospazio.setEnabled(true);
		combospazio.setVisible(true);
		combospazio.setEditable(false);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 5;
		contentPane.add(combospazio, gbc);
		
		JLabel lblPrenDisp = new JLabel("Prenotazioni disponibili");
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 6;
		contentPane.add(lblPrenDisp, gbc);
		
		comboprendisp = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(comboprendisp, gbc);
		comboprendisp.setColumns(10);

		
		
		JButton btnRegistratiAlNostro = new JButton("Modifica evento");
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 8;
		contentPane.add(btnRegistratiAlNostro, gbc);
		
		btnRegistratiAlNostro.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
			
			

			lblPrenDisp.setForeground(Color.BLACK);
			lblPrenDisp.setFont(new Font("Tahoma", Font.PLAIN, 11));
			
		
		
		
			if(comboprendisp.getText().isEmpty())
			{
				lblPrenDisp.setForeground(Color.RED);
				lblPrenDisp.setFont(new Font("Tahoma", Font.BOLD, 11));
			
			JOptionPane.showMessageDialog(frame, "Riempire tutti i campi obbligatori"," ",JOptionPane.WARNING_MESSAGE);
		    }
		
		
			
			bool=ModificaAttDAO.modificaatt( ClassiDao.GetInfoDB.getcombinazionelivdis(disciplina,livello),combofasciaor.getSelectedItem().toString(),combogiornoset.getSelectedItem().toString(),combospazio.getSelectedItem().toString(),comboprendisp.getText());
			
		
		if(bool)
		{
			frame.setVisible(false); 
			frame.dispose();
			FrameIstruttore.frame.dispose();
			new FrameIstruttore();
			
	}
								
		
			}	
		
	})
		
		
		;
		
		
		
	//	gbc_combotipoutente.setModel(new DefaultComboBoxModel(new String[] {"tesserato", "istruttore"}));
		
		

}}

