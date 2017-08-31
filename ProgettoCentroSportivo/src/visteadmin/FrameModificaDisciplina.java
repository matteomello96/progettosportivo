package visteadmin;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent.KeyBinding;

import ClassiDAOIstruttore.InserisciEventoDAO;
import ClassiDAOIstruttore.ModificaEventoDAO;
import Listener.Listen;
import Model.Home;
import Model_Responsabile.DisciplinaElenco;
import ModelliTabelleIstruttore.ComboSpazio;
import ModelliTabelleRespo.ComboDiscipline;
import VisteUtenteGenerico.*;
import classiDAOResponsabile.InserisciDisciplinaDAO;
import classiDAOResponsabile.InserisciModPagDAO;
import classiDAOResponsabile.ModificaDisciplinaDAO;
import classiDAOResponsabile.ModificaModPagDAO;
import ClassiDao.ElencoDisciplineDAO;
import ClassiDao.GetInfoDB;
import ClassiDao.Reg_dao;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.GridBagLayout;
import java.awt.Image;

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
import javax.swing.JFileChooser;
import javax.swing.JButton;






public class FrameModificaDisciplina extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private JPanel contentPane;
	
	
	private JTextField textnomed;
	private JTextField descr;
	private Combocal combocal;
	private JTextField immagine;
	private boolean bool;
	public String nomefile="";
	public String percorso="";
	public String path="";
	public String pathprecimg=""+GetInfoDB.getPath((String)FrameGestione.table.getValueAt(FrameGestione.table.getSelectedRow(), 0))+"";
	public String pathnuovo="";
	//public String pathprec="";
	public File fileprec;
	public String path2="";
	public FrameModificaDisciplina(String disc) {
	    String disciplina = ((String)FrameGestione.table.getValueAt(FrameGestione.table.getSelectedRow(), 0));
		frame = new JFrame("Modifica disciplina "+disciplina+""  );
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.setSize(450, 300);
        frame.setTitle("Inserisci disciplina");
		if(FrameModificaDisciplina.frame==null)
			frame.setLocationRelativeTo(null);
			else
			frame.setLocation(FrameModificaDisciplina.frame.getLocation());
		
		
		
		
	
		
		
		
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
		
		JMenuItem mntmTornaAllaPagina = new JMenuItem("Torna alla pagina iniziale della gestione");
	
		mnNewMenu.add(mntmTornaAllaPagina);
		mntmTornaAllaPagina.addActionListener(new Listen(this));
		mntmTornaAllaPagina.setActionCommand("Vai_ges_da_mod_disc");
		
		
		
		JLabel lblFormDiModifica = new JLabel("Form di Modifica della disciplina "+disciplina+"");
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		contentPane.add(lblFormDiModifica, gbc);
		
		
		

		JLabel lblNomeD = new JLabel("Nome della disciplina");
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 2;
		contentPane.add(lblNomeD, gbc);
		
		textnomed = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(textnomed, gbc);
		textnomed.setColumns(10);
		
		JLabel lblDesc = new JLabel("Descrizione");
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 3;
		contentPane.add(lblDesc, gbc);
		
		descr = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(descr, gbc);
		descr.setColumns(10);
		
		JLabel lblCal = new JLabel("Scegli calendario");
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 4;
		contentPane.add(lblCal, gbc);
		
		combocal = new Combocal();
		combocal.setEnabled(true);
		combocal.setVisible(true);
		combocal.setEditable(false);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 4;
		contentPane.add(combocal, gbc);
		
		
		
		JLabel lblIm = new JLabel("Inserisci immagine");
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 5;
		contentPane.add(lblIm, gbc);
		
		
		String pathprec =""+GetInfoDB.getPath((String)FrameGestione.table.getValueAt(FrameGestione.table.getSelectedRow(), 0))+"";
		String newS = pathprec.substring(12);
		nomefile=newS;
		
		immagine = new JTextField(newS,50);
		immagine.setEditable(false);
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(immagine, gbc);
		immagine.setColumns(10);
		
		JButton sfoglia = new JButton("Sfoglia:");
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 2;
		gbc.gridy = 5;
		contentPane.add(sfoglia, gbc);
		
		sfoglia.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {
			{
				 JFileChooser fc = new JFileChooser();
				 int sel = fc.showOpenDialog(frame);
			      if (sel == JFileChooser.APPROVE_OPTION) {
			    	 
			    	 pathprecimg=(fc.getSelectedFile().getPath());
			    
			         nomefile=(fc.getSelectedFile().getName());
			         percorso =("src/risorse");
			         pathnuovo=percorso+"/"+nomefile;
		        	 JOptionPane.showMessageDialog(FrameModificaDisciplina.frame,"  \""+pathprecimg+"\"  VS   \""+pathprec+"\" ","Modifica riuscita! ",JOptionPane.INFORMATION_MESSAGE);	
                    
				      immagine.setText(nomefile);
			
			
			
			
			
			
			
		}}}});
		
		
		
		
		
		JButton btninsdisc = new JButton("Modifica disciplina");
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 14;
		contentPane.add(btninsdisc, gbc);
		
		btninsdisc.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
			
			lblNomeD.setForeground(Color.BLACK);
			lblNomeD.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
			lblDesc.setForeground(Color.BLACK);
			lblDesc.setFont(new Font("Tahoma", Font.PLAIN, 11));
			
		
		
		if(textnomed.getText().isEmpty()||descr.getText().isEmpty())
		
			{
				lblNomeD.setForeground(Color.RED);
				lblNomeD.setFont(new Font("Tahoma", Font.BOLD, 11));
				
				lblDesc.setForeground(Color.RED);
				lblDesc.setFont(new Font("Tahoma", Font.BOLD, 11));
			}
			
		else
			
			bool=ModificaDisciplinaDAO.modificadisc(pathprecimg,(String)FrameGestione.table.getValueAt(FrameGestione.table.getSelectedRow(), 0),textnomed.getText(),descr.getText(),combocal.getSelectedItem().toString(),pathnuovo,nomefile,pathprec);
			
		
		if(bool)
		{
			frame.setVisible(false); 
			frame.dispose();
			FrameGestione.frame.dispose();
			new FrameGestione();
			
	}
								
		
			}	
		
	})
		
		
		;
		
		
		
	//	gbc_combotipoutente.setModel(new DefaultComboBoxModel(new String[] {"tesserato", "istruttore"}));
		
		

}}

