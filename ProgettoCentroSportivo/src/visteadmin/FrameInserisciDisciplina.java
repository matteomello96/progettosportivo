package visteadmin;



import java.awt.Color;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

import classiDAOResponsabile.GestioneDAO;



import listener.Listen;


import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;




import java.awt.GridBagLayout;


import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;


import javax.swing.JScrollPane;

import javax.swing.JFileChooser;
import javax.swing.JButton;






public class FrameInserisciDisciplina extends JFrame {
	
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
	public String pathprecedente="";
	public File fileprec;
	
	public FrameInserisciDisciplina() {
	  
		frame = new JFrame("Inserisci disciplina"  );
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.setSize(450, 300);
        frame.setTitle("Inserisci disciplina");
		if(FrameInserisciDisciplina.frame==null)
			frame.setLocationRelativeTo(null);
			else
			frame.setLocation(FrameInserisciDisciplina.frame.getLocation());
		
		
		
		
	
		
		
		
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
		mntmTornaAllaPagina.setActionCommand("Vai_ges_da_ins_disc");
		
		
		
		JLabel lblFormDiModifica = new JLabel("Form di Inserimento della disciplina");
		lblFormDiModifica.setOpaque(true);
		lblFormDiModifica.setBackground(new Color(128, 120, 120));
		lblFormDiModifica.setForeground(new Color(255, 255, 255));
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		contentPane.add(lblFormDiModifica, gbc);
		
		
		

		JLabel lblNomeD = new JLabel("Nome della disciplina");
		lblNomeD.setOpaque(true);
		lblNomeD.setBackground(new Color(128, 120, 120));
		lblNomeD.setForeground(new Color(255, 255, 255));
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 2;
		contentPane.add(lblNomeD, gbc);
		
		JLabel lblErrNome = new JLabel("La disciplina non deve contenere numeri");
		lblErrNome.setOpaque(true);
		lblErrNome.setBackground(new Color(128, 0, 0));
		lblErrNome.setForeground(new Color(255, 255, 255));
		lblErrNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrNome.setBounds(25, 30, 10, 10);
		lblErrNome.setVisible(false);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		textnomed = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(textnomed, gbc);
		textnomed.setColumns(10);
		
		textnomed.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent ke)
		
		{
				
				if((ke.getKeyChar()+"").matches("[0-9]+$")){
                lblErrNome.setVisible(true);
                }
				else
				{
				lblErrNome.setVisible(false);
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
		
		
		JLabel lblDesc = new JLabel("Descrizione");
		lblDesc.setOpaque(true);
		lblDesc.setBackground(new Color(128, 120, 120));
		lblDesc.setForeground(new Color(255, 255, 255));
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 3;
		contentPane.add(lblDesc, gbc);
		
		JLabel lblErrNome2 = new JLabel("");
		lblErrNome2.setOpaque(true);
		lblErrNome2.setBackground(new Color(128, 0, 0));
		lblErrNome2.setForeground(new Color(255, 255, 255));
		lblErrNome2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrNome2.setBounds(25, 30, 10, 10);
		lblErrNome2.setVisible(false);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		descr = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(descr, gbc);
		descr.setColumns(10);
		
		JLabel lblCal = new JLabel("Scegli calendario");
		lblCal.setOpaque(true);
		lblCal.setBackground(new Color(128, 120, 120));
		lblCal.setForeground(new Color(255, 255, 255));
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
		lblIm.setOpaque(true);
		lblIm.setBackground(new Color(128, 120, 120));
		lblIm.setForeground(new Color(255, 255, 255));
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 5;
		contentPane.add(lblIm, gbc);
		
		immagine = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(immagine, gbc);
		immagine.setColumns(10);
		
		JButton sfoglia = new JButton("Sfoglia:");
		sfoglia.setBackground(new Color(28, 220, 157));
		sfoglia.setForeground(new Color(255, 255, 255));
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 2;
		gbc.gridy = 5;
		contentPane.add(sfoglia, gbc);
		
		sfoglia.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {
			{
				 JFileChooser fc = new JFileChooser();
				 int sel = fc.showOpenDialog(frame);
			      if (sel == JFileChooser.APPROVE_OPTION) {
			    	
			    	 pathprecedente=(fc.getSelectedFile().getPath());
			         nomefile=(fc.getSelectedFile().getName());
			         percorso =("src/risorse");
			         path=percorso+"/"+nomefile;
              	    
				    immagine.setText(nomefile);
			
			
			
			
			
			
			
		}}}});
		
		
		
		
		
		JButton btninsdisc = new JButton("Inserisci disciplina");
		btninsdisc.setBackground(new Color(28, 140, 220));
		btninsdisc.setForeground(new Color(255, 255, 255));
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
			
		
		
		if(textnomed.getText().isEmpty()||descr.getText().isEmpty()){
			if(textnomed.getText().isEmpty())
			{
				lblNomeD.setForeground(Color.RED);
				lblNomeD.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblErrNome.setText("Il campo è vuoto");
				lblErrNome.setVisible(true);
				
			}	
			if(descr.getText().isEmpty())
			{
				lblDesc.setForeground(Color.RED);
				lblDesc.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblErrNome2.setText("Il campo è vuoto");
				lblErrNome2.setVisible(true);
			}
			}
			
		else
			
			bool=GestioneDAO.inserimentodisc(textnomed.getText(),descr.getText(),combocal.getSelectedItem().toString(),path,nomefile,pathprecedente);
			
		
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

