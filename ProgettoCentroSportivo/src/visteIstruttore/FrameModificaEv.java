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
import ClassiDAOIstruttore.ModificaEventoDAO;
import Model.Home;
import VisteUtenteGenerico.*;
import listener.Listen;
import modelliTabelleIstruttore.ComboSpazio;
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






public class FrameModificaEv extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private JPanel contentPane;
	
	
	private JTextField textdescrizione;
	private JTextField textnomeevento;
	private JTextField textcostoev;
	private JComboBox comboinfopag;
	private JComboBox  combotipoev;
	private JComboBox  combobiscert;
	private JComboBox combofasciaor;
	private JComboBox combogiornoset;
	private JTextField comboprendisp;
	private boolean bool;
	public static ComboSpazio combospazio;
	
	
	
	public FrameModificaEv( String evento) {
		 evento=(String) FrameEventiIstr.table.getValueAt(FrameEventiIstr.table.getSelectedRow(), 0);
		frame = new JFrame("Modifica  evento  ");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.setSize(450, 300);
        frame.setTitle("Modifica  evento "+evento+"  ");
		if(FrameModificaEv.frame==null)
			frame.setLocationRelativeTo(null);
			else
			frame.setLocation(FrameModificaEv.frame.getLocation());
		
		
		
		
	
		
		
		
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
		mntmTornaAllaPagina.setActionCommand("Vai_istr");
		
		
		
		JLabel lblFormDiModifica = new JLabel("Form di Modifica dell'Evento");
		lblFormDiModifica.setOpaque(true);
		Border bordo2 = BorderFactory.createLineBorder(new Color(255, 205, 255));
		lblFormDiModifica.setBorder(bordo2);
		lblFormDiModifica.setForeground(new Color(255, 255, 255));
		lblFormDiModifica.setBackground(new Color(0, 133, 217));
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		contentPane.add(lblFormDiModifica, gbc);
		
		JLabel lblDatiEvento= new JLabel("Dati dell'evento");
		lblDatiEvento.setOpaque(true);
		lblDatiEvento.setBorder(bordo2);
		lblDatiEvento.setForeground(new Color(255, 255, 255));
		lblDatiEvento.setBackground(new Color(245, 222, 179));
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		contentPane.add(lblDatiEvento, gbc);
		

		JLabel lblNomeEvento = new JLabel("Nome dell'evento");
		lblNomeEvento.setOpaque(true);
		lblNomeEvento.setBorder(bordo2);
		lblNomeEvento.setForeground(new Color(255, 255, 255));
		lblNomeEvento.setBackground(new Color(245, 222, 179));
		gbc.anchor =  GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 3;
		contentPane.add(lblNomeEvento, gbc);
		
		JLabel lblErrNE = new JLabel("");
		lblErrNE.setOpaque(true);
		lblErrNE.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrNE.setBackground(new Color(128, 0, 0));
		lblErrNE.setForeground(new Color(255, 255, 255));
		lblErrNE.setBounds(25, 30, 10, 10);
		lblErrNE.setVisible(false);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(lblErrNE,gbc);
		
		textnomeevento = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(textnomeevento, gbc);
		textnomeevento.setColumns(10);
		
		JLabel lblDescrizione = new JLabel("Descrizione dell'evento");
		lblDescrizione.setOpaque(true);
		lblDescrizione.setBorder(bordo2);
		lblDescrizione.setForeground(new Color(255, 255, 255));
		lblDescrizione.setBackground(new Color(245, 222, 179));
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 4;
		contentPane.add(lblDescrizione, gbc);
		
		JLabel lblErrD = new JLabel("");
		lblErrD.setOpaque(true);
		lblErrD.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrD.setBackground(new Color(128, 0, 0));
		lblErrD.setForeground(new Color(255, 255, 255));
		lblErrD.setBounds(25, 30, 10, 10);
		lblErrD.setVisible(false);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(lblErrD,gbc);
		
		textdescrizione = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(textdescrizione, gbc);
		textdescrizione.setColumns(10);
		
		JLabel lblInfopag = new JLabel("Info pagamento");
		lblInfopag.setOpaque(true);
		lblInfopag.setBorder(bordo2);
		lblInfopag.setForeground(new Color(255, 255, 255));
		lblInfopag.setBackground(new Color(245, 222, 179));
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 5;
		contentPane.add(lblInfopag, gbc);
		
		comboinfopag = new JComboBox();
		comboinfopag.setModel(new DefaultComboBoxModel(new String[] {"Gratuito","A pagamento"}));
		comboinfopag.setEnabled(true);
		comboinfopag.setVisible(true);
		comboinfopag.setEditable(false);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 5;
		contentPane.add(comboinfopag, gbc);
		
		
		JLabel lblCostoEv = new JLabel("Costo dell'evento");
		lblCostoEv.setOpaque(true);
		lblCostoEv.setBorder(bordo2);
		lblCostoEv.setForeground(new Color(255, 255, 255));
		lblCostoEv.setBackground(new Color(245, 222, 179));
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 6;
		contentPane.add(lblCostoEv, gbc);
		
		JLabel lblErrCE = new JLabel("Il campo deve essere numerico");
		lblErrCE.setOpaque(true);
		lblErrCE.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrCE.setBackground(new Color(128, 0, 0));
		lblErrCE.setForeground(new Color(255, 255, 255));
		lblErrCE.setBounds(25, 30, 10, 10);
		lblErrCE.setVisible(false);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(lblErrNE,gbc);
		
		textcostoev = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(textcostoev, gbc);
		textcostoev.setColumns(10);
		
		textcostoev.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent ke)
		
		{
				
				if(!(ke.getKeyChar()+"").matches("[0-9]+$")){
                lblErrCE.setVisible(true);
                }
				else
				{
				lblErrCE.setVisible(false);
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
		
		JLabel lblTipoEvento = new JLabel("Tipo evento");
		lblTipoEvento.setOpaque(true);
		lblTipoEvento.setBorder(bordo2);
		lblTipoEvento.setForeground(new Color(255, 255, 255));
		lblTipoEvento.setBackground(new Color(245, 222, 179));
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 7;
		contentPane.add(lblTipoEvento, gbc);
		
		combotipoev = new JComboBox();
		combotipoev.setModel(new DefaultComboBoxModel(new String[] {"Gara","Stage"}));
		combotipoev.setVisible(true);
		combotipoev.setEnabled(true);
		combotipoev.setEditable(false);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 7;
		contentPane.add(combotipoev, gbc);
		
		JLabel lblBiscert = new JLabel("Bisogno certificato");
		lblBiscert.setOpaque(true);
		lblBiscert.setBorder(bordo2);
		lblBiscert.setForeground(new Color(255, 255, 255));
		lblBiscert.setBackground(new Color(245, 222, 179));
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 8;
		contentPane.add(lblBiscert, gbc);
		
		combobiscert = new JComboBox();
		combobiscert.setModel(new DefaultComboBoxModel(new String[] {"Si","No"}));
		combobiscert.setEnabled(true);
		combobiscert.setVisible(true);
		combobiscert.setEditable(false);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 8;
		contentPane.add(combobiscert, gbc);
		
		
		
		
		JLabel lblDatiorario = new JLabel("Dati sull'orario");
		lblDatiorario.setOpaque(true);
		lblDatiorario.setBorder(bordo2);
		lblDatiorario.setForeground(new Color(255, 255, 255));
		lblDatiorario.setBackground(new Color(245, 222, 179));
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 9;
		contentPane.add(lblDatiorario, gbc);
		
		
		JLabel lblFasciaoraria = new JLabel("Fascia oraria");
		lblFasciaoraria.setOpaque(true);
		lblFasciaoraria.setBorder(bordo2);
		lblFasciaoraria.setForeground(new Color(255, 255, 255));
		lblFasciaoraria.setBackground(new Color(245, 222, 179));
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 10;
		contentPane.add(lblFasciaoraria, gbc);
		
		combofasciaor = new JComboBox();
		combofasciaor.setModel(new DefaultComboBoxModel(new String[] {"08:30-09:30","09:30-10:30","10:30-11:30","11:30-12:30","12:30-13:30","15:30-16:30","16:30-17:30","17:30-18:30","18:30-19:30","19:30-20:30","20:30-21:30",}));
		combofasciaor.setVisible(true);
		combofasciaor.setEnabled(true);
		combofasciaor.setEditable(false);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 10;
		contentPane.add(combofasciaor, gbc);
		
		JLabel lblGiornoset = new JLabel("Giorno della settimana");
		lblGiornoset.setOpaque(true);
		lblGiornoset.setBorder(bordo2);
		lblGiornoset.setForeground(new Color(255, 255, 255));
		lblGiornoset.setBackground(new Color(245, 222, 179));
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 11;
		contentPane.add(lblGiornoset, gbc);
			
		combogiornoset = new JComboBox();
		combogiornoset.setModel(new DefaultComboBoxModel(new String[] {"lunedi","martedi","mercoledi","giovedi","venerdi","sabato"}));
		combogiornoset.setVisible(true);
		combogiornoset.setEnabled(true);
		combogiornoset.setEditable(false);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 11;
		contentPane.add(combogiornoset, gbc);
		
	
		JLabel lblSpazio = new JLabel("Spazio");
		lblSpazio.setOpaque(true);
		lblSpazio.setBorder(bordo2);
		lblSpazio.setForeground(new Color(255, 255, 255));
		lblSpazio.setBackground(new Color(245, 222, 179));
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 12;
		contentPane.add(lblSpazio, gbc);
		
		combospazio = new ComboSpazio();
		combospazio.setEnabled(true);
		combospazio.setVisible(true);
		combospazio.setEditable(false);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 12;
		contentPane.add(combospazio, gbc);
		
		JLabel lblPrenDisp = new JLabel("Prenotazioni disponibili");
		lblPrenDisp.setOpaque(true);
		lblPrenDisp.setBorder(bordo2);
		lblPrenDisp.setForeground(new Color(255, 255, 255));
		lblPrenDisp.setBackground(new Color(245, 222, 179));
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 13;
		contentPane.add(lblPrenDisp, gbc);
		
		JLabel lblErrPD = new JLabel("Il campo deve essere numerico");
		lblErrPD.setOpaque(true);
		lblErrPD.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrPD.setBackground(new Color(128, 0, 0));
		lblErrPD.setForeground(new Color(255, 255, 255));
		lblErrPD.setBounds(25, 30, 10, 10);
		lblErrPD.setVisible(false);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 13;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(lblErrPD,gbc);
		
		comboprendisp = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 13;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(comboprendisp, gbc);
		comboprendisp.setColumns(10);

		comboprendisp.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent ke)
		
		{
				
				if(!(ke.getKeyChar()+"").matches("[0-9]+$")){
                lblErrPD.setVisible(true);
                }
				else
				{
				lblErrPD.setVisible(false);
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
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 14;
		contentPane.add(btnRegistratiAlNostro, gbc);
		
		btnRegistratiAlNostro.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
			
			lblDescrizione.setForeground(Color.BLACK);
			lblDescrizione.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
			lblCostoEv.setForeground(Color.BLACK);
			lblCostoEv.setFont(new Font("Tahoma", Font.PLAIN, 11));

			lblPrenDisp.setForeground(Color.BLACK);
			lblPrenDisp.setFont(new Font("Tahoma", Font.PLAIN, 11));
			
		
		
			if(textnomeevento.getText().isEmpty()||textdescrizione.getText().isEmpty()||textcostoev.getText().isEmpty()||comboprendisp.getText().isEmpty())
			{
				
				if(textnomeevento.getText().isEmpty())
				{
					lblNomeEvento.setForeground(Color.RED);
					lblNomeEvento.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblErrNE.setText("Il campo è nullo");
					lblErrNE.setVisible(true);
				}
				if(textdescrizione.getText().isEmpty())
				{
					lblDescrizione.setForeground(Color.RED);
					lblDescrizione.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblErrD.setText("Il campo è nullo");
					lblErrD.setVisible(true);
				}
				if(textcostoev.getText().isEmpty())
				{
					lblCostoEv.setForeground(Color.RED);
					lblCostoEv.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblErrCE.setText("Il campo è nullo");
					lblErrCE.setVisible(true);
				}
				if(comboprendisp.getText().isEmpty())
				{
					lblPrenDisp.setForeground(Color.RED);
					lblPrenDisp.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblErrPD.setText("Il campo è nullo");
					lblErrPD.setVisible(true);
				}
			JOptionPane.showMessageDialog(frame, "Riempire tutti i campi obbligatori"," ",JOptionPane.WARNING_MESSAGE);
		}
		
		else
			
			bool=ModificaEventoDAO.modificaevento((String) FrameEventiIstr.table.getValueAt(FrameEventiIstr.table.getSelectedRow(), 0),textnomeevento.getText(),textdescrizione.getText(),textcostoev.getText(),comboinfopag.getSelectedItem().toString(),combotipoev.getSelectedItem().toString(),combobiscert.getSelectedItem().toString(),combofasciaor.getSelectedItem().toString(),combogiornoset.getSelectedItem().toString(),combospazio.getSelectedItem().toString(),comboprendisp.getText());
			
		
		if(bool)
		{
			frame.setVisible(false); 
			frame.dispose();
			new FrameEventiIstr();
			FrameEventiIstr.frame.setVisible(true);
			FrameEventiIstr.frame.setEnabled(true);
			
	}
								
		
			}	
		
	})
		
		
		;
		
		
		
	//	gbc_combotipoutente.setModel(new DefaultComboBoxModel(new String[] {"tesserato", "istruttore"}));
		
		

}}

