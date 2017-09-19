package visteadmin;



import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

import classiDAOResponsabile.GestioneDAO;

import listener.Listen;
import listener.VariListener;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
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
		
		
		
		
	
		
		
		
		
		
		
		frame.setVisible(true);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Pagina Gestione");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmTornaAllaPagina = new JMenuItem("Torna alla pagina iniziale della gestione");
	
		mnNewMenu.add(mntmTornaAllaPagina);
		mntmTornaAllaPagina.addActionListener(new Listen(this));
		mntmTornaAllaPagina.setActionCommand("Vai_ges_da_mod_cal");
		
		
	
		
		
		ImageIcon im=new ImageIcon("src/immaginijava/bottone4.png");
        ImageIcon im2=new ImageIcon("src/immaginijava/bottone5.png");
        ImageIcon im3=new ImageIcon("src/immaginijava/titolo2.png");
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (255,185,0));
		contentPane.setLayout(new BorderLayout());
		
		
		
 
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
		

		

		
		JPanel Panel1 = new JPanel();
 		Panel1.setBackground(new Color(255,185,0));
 		Panel1.setLayout(new GridBagLayout());
		
		
		
    contentPane.add(VariListener.SettaPannelloTitolo(im3, Panel1, 1, 0, "Form di modifica calendario"), BorderLayout.NORTH);	
		
		
		

    JPanel Panel2 = new JPanel();
  	Panel2.setLayout(new GridBagLayout());
  	Panel2.setBackground(new Color (255,185,0));
  	
  	
  	JLabel lblLiv = new JLabel();
  	VariListener.SettaLabelGen(Panel2,lblLiv, "nome del calendario da inserire", 0, 1);
		
		
		
	JLabel lblErrNome = new JLabel("");
	VariListener.SettaErr("la disciplina non deve contenere errori",lblErrNome, 2, 1, Panel2);
		
	
		
	textliv= new JTextField();
	VariListener.SettaTextField(Panel2, textliv, "Modifica", 1,1);
	VariListener.SettaFocus(textliv);

		
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
		
		
		
		JPanel PanelBottom = new JPanel();
		PanelBottom.setLayout(new GridBagLayout());
		PanelBottom.setBackground(new Color (255,185,0));
		
		 JButton btnRegistratiAlNostro = new JButton(im);
		 JLabel lbl= new JLabel();
		
		  VariListener.SettaBtn(PanelBottom, btnRegistratiAlNostro, lbl,"Modifica calendario", 1, 1,im2,true);
		
		btnRegistratiAlNostro.addActionListener(new ActionListener() {
		
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
		contentPane.add(Panel2,BorderLayout.NORTH);
		contentPane.add(PanelBottom,BorderLayout.CENTER);
		

}}

