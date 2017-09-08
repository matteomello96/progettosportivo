package visteadmin;



import java.awt.Color;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

import classiDAOResponsabile.GestioneDAO;

import listener.Listen;

import modelliTabelleRespo.ComboDiscipline;
import modelliTabelleRespo.ComboLivelli;


import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.GridBagLayout;


import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import javax.swing.ScrollPaneConstants;


import javax.swing.JScrollPane;



import javax.swing.JButton;






public class FrameModificaDiscDisp extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private JPanel contentPane;
	
	
	
	private JTextField costomensile;
	private boolean bool;
	public static ComboDiscipline combodis;
	public static ComboLivelli combolivelli;
	public String disciplina="";
	public String livello="";
	public String costm="";
	
	
	public FrameModificaDiscDisp(String disciplina,String livello,float f) {
		disciplina=(String) FrameGestione.table3.getValueAt(FrameGestione.table3.getSelectedRow(), 0);
		livello=(String) FrameGestione.table3.getValueAt(FrameGestione.table3.getSelectedRow(), 1);
		f =(float) FrameGestione.table3.getValueAt(FrameGestione.table3.getSelectedRow(), 2);
		frame = new JFrame("Modifica combinazione disciplina "+disciplina+" "+livello+" con costo mensile "+f+"");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.setSize(450, 300);
        frame.setTitle("Inserisci una nuova disciplina disponibile");
		if(FrameModificaDiscDisp.frame==null)
			frame.setLocationRelativeTo(null);
			else
			frame.setLocation(FrameModificaDiscDisp.frame.getLocation());
		
		
	
	
		
		
		
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
		
		JMenu mnNewMenu = new JMenu("Pagina Gestione");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmTornaAllaPagina = new JMenuItem("Torna alla pagina Gestione");
	
		mnNewMenu.add(mntmTornaAllaPagina);
		mntmTornaAllaPagina.addActionListener(new Listen(this));
		mntmTornaAllaPagina.setActionCommand("Vai_home_da_mod_disc");
		
		
		
		JLabel lblFormDiInserimento = new JLabel("Form di Modifica della disciplina");
		lblFormDiInserimento.setOpaque(true);
		lblFormDiInserimento.setBackground(new Color(18, 220, 150));
		lblFormDiInserimento.setForeground(new Color(255, 255, 255));
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		contentPane.add(lblFormDiInserimento, gbc);
		
		
				
		
		
		
		

		
	
		
		
		
		JLabel lblCostomensile = new JLabel("Nuovo costo mensile");
		lblCostomensile.setOpaque(true);
		lblCostomensile.setBackground(new Color(18, 220, 150));
		lblCostomensile.setForeground(new Color(255, 255, 255));
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy =9;
		contentPane.add(lblCostomensile, gbc);
		
		JLabel lblErrNome = new JLabel("Il livello non deve contenere numeri");
		lblErrNome.setOpaque(true);
		lblErrNome.setBackground(new Color(128, 0, 0));
		lblErrNome.setForeground(new Color(255, 255, 255));
		lblErrNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrNome.setBounds(25, 30, 10, 10);
		lblErrNome.setVisible(false);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 9;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		contentPane.add(lblErrNome,gbc);
		
		costomensile = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 9;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(costomensile, gbc);
		costomensile.setColumns(10);

		costomensile.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent ke)
		
		{
				
				if(!(ke.getKeyChar()+"").matches("[0-9]+$")){
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
		
		
		JButton btnRegistratiAlNostro = new JButton("Modifica la  disciplina disponibile");
		btnRegistratiAlNostro.setBackground(new Color(174, 20, 200));
		btnRegistratiAlNostro.setForeground(new Color(255, 255, 255));
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 14;
		contentPane.add(btnRegistratiAlNostro, gbc);
		
		btnRegistratiAlNostro.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			

			costomensile.setForeground(Color.BLACK);
			costomensile.setFont(new Font("Tahoma", Font.PLAIN, 11));
			
		
		
		if(costomensile.getText().isEmpty())
		{
			
			
			if(costomensile.getText().isEmpty())
			{
				costomensile.setForeground(Color.RED);
				costomensile.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblErrNome.setText("Il campo è vuoto");
				lblErrNome.setVisible(true);
			}
			JOptionPane.showMessageDialog(frame, "Riempire tutti i campi obbligatori"," ",JOptionPane.WARNING_MESSAGE);
		}
		
		else
	
			bool=GestioneDAO.modificadiscdisp((String) FrameGestione.table3.getValueAt(FrameGestione.table3.getSelectedRow(), 0),(String) FrameGestione.table3.getValueAt(FrameGestione.table3.getSelectedRow(), 1),(float) FrameGestione.table3.getValueAt(FrameGestione.table3.getSelectedRow(), 2), costomensile.getText());
			
		
		if(bool)
		{
			frame.setVisible(false); 
			frame.dispose();
			FrameGestione.frame.dispose();
			new FrameGestione();
			FrameGestione.frame.setVisible(true);
			FrameGestione.frame.setEnabled(true);
			
	}
								
		
			}	
		
	})
		
		
		;
		
		
		
	//	gbc_combotipoutente.setModel(new DefaultComboBoxModel(new String[] {"tesserato", "istruttore"}));
		
		

}}

