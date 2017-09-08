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
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import javax.swing.JScrollPane;

import javax.swing.JButton;






public class FrameModificaCal extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private JPanel contentPane;
	
	
	private JTextField textliv;
	
	private boolean bool;
	
	
	
	
	public FrameModificaCal(String evento) {
	    evento=(String) FrameGestione.table8.getValueAt(FrameGestione.table8.getSelectedRow(), 0);
		frame = new JFrame("Modifica  calendario "+evento+"  ");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.setSize(450, 300);
        frame.setTitle("Modifica  calendario "+evento+"  ");
		if(FrameModificaCal.frame==null)
			frame.setLocationRelativeTo(null);
			else
			frame.setLocation(FrameModificaCal.frame.getLocation());
		
		
		
		
	
		
		
		
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
		
		JMenuItem mntmTornaAllaPagina = new JMenuItem("Torna alla pagina iniziale della gestione");
	
		mnNewMenu.add(mntmTornaAllaPagina);
		mntmTornaAllaPagina.addActionListener(new Listen(this));
		mntmTornaAllaPagina.setActionCommand("Vai_ges_da_mod_cal");
		
		
		
		JLabel lblFormDiModifica = new JLabel("Form di Modifica del Calendario");
		lblFormDiModifica.setOpaque(true);
		lblFormDiModifica.setBackground(new Color(128, 120, 120));
		lblFormDiModifica.setForeground(new Color(255, 255, 255));
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		contentPane.add(lblFormDiModifica, gbc);
		
		
		

		JLabel lblLiv = new JLabel("Nome del calendario che vuoi inserire");
		lblLiv.setOpaque(true);
		lblLiv.setBackground(new Color(128, 120, 120));
		lblLiv.setForeground(new Color(255, 255, 255));
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 2;
		contentPane.add(lblLiv, gbc);
		
		JLabel lblErrNome = new JLabel("Il calendario non deve contenere numeri");
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
		
		contentPane.add(lblErrNome,gbc);
		
		textliv = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(textliv, gbc);
		textliv.setColumns(10);
		
		
		textliv.addKeyListener(new KeyListener(){
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
		
		
		
		JButton btnRegistratiAlNostro = new JButton("Modifica calendario");
		btnRegistratiAlNostro.setBackground(new Color(128, 120, 0));
		btnRegistratiAlNostro.setForeground(new Color(255, 255, 255));
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 14;
		contentPane.add(btnRegistratiAlNostro, gbc);
		
		btnRegistratiAlNostro.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
			
			lblLiv.setForeground(Color.BLACK);
			lblLiv.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
			
		
		
		if(textliv.getText().isEmpty())
		
			{
				lblLiv.setForeground(Color.RED);
				lblLiv.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblErrNome.setText("Il campo è vuoto");
				lblErrNome.setVisible(true);
			}
			
		else
			
			bool=GestioneDAO.modificacal((String) FrameGestione.table8.getValueAt(FrameGestione.table8.getSelectedRow(), 0),textliv.getText());
			
		
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

