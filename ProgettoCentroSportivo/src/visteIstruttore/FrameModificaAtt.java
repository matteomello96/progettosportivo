package visteIstruttore;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent.KeyBinding;

import ClassiDAOIstruttore.InserisciEventoDAO;
import ClassiDAOIstruttore.ModificaAttDAO;
import ClassiDAOIstruttore.ModificaEventoDAO;
import Model.Home;
import VisteUtenteGenerico.*;
import listener.Listen;
import modelliTabelleIstruttore.ComboSpazio;
import modelliTabelleIstruttore.ComboSpazioAltro;
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
import javax.swing.BorderFactory;
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
	public String disciplina="";
	public String livello="";
	
	public FrameModificaAtt(String disciplina,String livello) {
		 disciplina=(String) FrameAttIstr.table.getValueAt(FrameAttIstr.table.getSelectedRow(), 0);
		 livello=(String) FrameAttIstr.table.getValueAt(FrameAttIstr.table.getSelectedRow(), 1);
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
		
		JMenu mnNewMenu = new JMenu("Pagina Iniziale Attività");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmTornaAllaPagina = new JMenuItem("Torna alle attività");
	
		mnNewMenu.add(mntmTornaAllaPagina);
		mntmTornaAllaPagina.addActionListener(new Listen(this));
		mntmTornaAllaPagina.setActionCommand("Vai_istr1");
		
		
		
		JLabel lblFormDiModifica = new JLabel("Form di Modifica dell'Attività");
		lblFormDiModifica.setOpaque(true);
		Border bordo2 = BorderFactory.createLineBorder(new Color(255, 205, 255));
		lblFormDiModifica.setBorder(bordo2);
		lblFormDiModifica.setForeground(new Color(255, 255, 255));
		lblFormDiModifica.setBackground(new Color(0, 47, 167));
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		contentPane.add(lblFormDiModifica, gbc);
		
		
		
		
		
		
		
		
		
		
		
		JLabel lblDatiorario = new JLabel("Dati sull'orario");
		lblDatiorario.setOpaque(true);
		lblDatiorario.setBorder(bordo2);
		lblDatiorario.setForeground(new Color(255, 255, 255));
		lblDatiorario.setBackground(new Color(0, 47, 167));
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 2;
		contentPane.add(lblDatiorario, gbc);
		
		
		JLabel lblFasciaoraria = new JLabel("Fascia oraria");
		lblFasciaoraria.setOpaque(true);
		lblFasciaoraria.setBorder(bordo2);
		lblFasciaoraria.setForeground(new Color(255, 255, 255));
		lblFasciaoraria.setBackground(new Color(0, 168, 107));
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
		lblGiornoset.setOpaque(true);
		lblGiornoset.setBorder(bordo2);
		lblGiornoset.setForeground(new Color(255, 255, 255));
		lblGiornoset.setBackground(new Color(0, 168, 107));
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
		lblSpazio.setOpaque(true);
		lblSpazio.setBorder(bordo2);
		lblSpazio.setForeground(new Color(255, 255, 255));
		lblSpazio.setBackground(new Color(0, 168, 107));
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
		lblPrenDisp.setOpaque(true);
		lblPrenDisp.setBorder(bordo2);
		lblPrenDisp.setForeground(new Color(255, 255, 255));
		lblPrenDisp.setBackground(new Color(0, 168, 107));
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 6;
		contentPane.add(lblPrenDisp, gbc);
		
		JLabel lblErrVia = new JLabel("Il campo non deve contenere lettere");
		lblErrVia.setOpaque(true);
		lblErrVia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrVia.setBackground(new Color(128, 0, 0));
		lblErrVia.setForeground(new Color(255, 255, 255));
		lblErrVia.setBounds(25, 30, 10, 10);
		lblErrVia.setVisible(false);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		comboprendisp = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(comboprendisp, gbc);
		comboprendisp.setColumns(10);

		comboprendisp.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent ke)
		
		{
				
				if(!(ke.getKeyChar()+"").matches("[0-9]+$")){
                lblErrVia.setVisible(true);
                }
				else
				{
				lblErrVia.setVisible(false);
				}
		}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}});
		
		JButton btnRegistratiAlNostro = new JButton("Modifica evento");
		btnRegistratiAlNostro.setBorder(bordo2);
		btnRegistratiAlNostro.setForeground(new Color(255, 255, 255));
		btnRegistratiAlNostro.setBackground(new Color(0, 47, 167));
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
				lblErrVia.setText("Il campo è nullo");
				lblErrVia.setVisible(true);
			
			JOptionPane.showMessageDialog(frame, "Riempire tutti i campi obbligatori"," ",JOptionPane.WARNING_MESSAGE);
		    }
		
		
			
			bool=ModificaAttDAO.modificaatt( ClassiDao.GetInfoDB.getcombinazionelivdis((String)FrameAttIstr.table.getValueAt(FrameAttIstr.table.getSelectedRow(), 0),(String)FrameAttIstr.table.getValueAt(FrameAttIstr.table.getSelectedRow(), 1)),combofasciaor.getSelectedItem().toString(),combogiornoset.getSelectedItem().toString(),combospazio.getSelectedItem().toString(),comboprendisp.getText());
			
		
		if(bool)
		{
			frame.setVisible(false); 
			frame.dispose();
			
			new FrameAttIstr();
			
	}
								
		
			}	
		
	})
		
		
		;
		
		
		
	//	gbc_combotipoutente.setModel(new DefaultComboBoxModel(new String[] {"tesserato", "istruttore"}));
		
		

}}

