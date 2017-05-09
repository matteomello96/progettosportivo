package Viste;


import javax.swing.*;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.*;

import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.tree.TreeSelectionModel;

import java.awt.Color;

import ClassiDao.ElencoDiscipline;
import DBInterfaccia.DbConnection;



public class FrameLogin extends JFrame {
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	public JTextField CasellaPassword;
	public JTextField CasellaNomeutenteOLD;
	//private JTextField nullfield;
	public JPasswordField passwordField;
	public static JTable tabelladisc;
	public JTextField CasellaNomeutente;
	public final JButton baccedi;
	public static boolean crypt=true;
	int xi;
	int yi;
	
	public FrameLogin(){
		//FrameLogin.setDefaultLookAndFeelDecorated(true);
		
		frame = new JFrame("Accesso centropolisportivo");
		frame.setTitle("Pagina iniziale Centro Polisportivo");
		frame.getContentPane().setBackground(new Color(0,204,255));
		frame.setResizable(false);
		
		frame.setBounds(0,0,1400, 800);
		//frame.setMinimumSize(new Dimension(500, 300));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		
		
		 
		 frame.addMouseListener(new MouseAdapter(){
		       public void mousePressed(MouseEvent ev){
		        xi = ev.getX();
		        yi = ev.getY();
		       }
		    });
		   
		    frame.addMouseMotionListener(new MouseMotionAdapter() {
		                public void mouseDragged(MouseEvent evt) {
		                    int x = evt.getXOnScreen()-xi;
		                    int y = evt.getYOnScreen()-yi;
		                   System.out.println(x+","+y+"     "+xi+","+yi);
		                    frame.setLocation(x,y); 

		                }
		            });

		    JMenuBar menuBar = new JMenuBar();
			frame.setJMenuBar(menuBar);
			JMenu mnAccedi = new JMenu("Accedi");
			menuBar.add(mnAccedi);

			JMenuItem mntmRegistra = new JMenuItem("Registrati al portale");
			mntmRegistra.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Registrazione();
					frame.setEnabled(false);
				}
			});
			mnAccedi.add(mntmRegistra);

		baccedi = new JButton("Registrati!");
		baccedi.setEnabled(true);
	
		frame.getRootPane().setDefaultButton(baccedi); //RENDE ACCEDI PULSANTE PREDEFINITO PER ENTER

		baccedi.setToolTipText("Esegui l'accesso");
		baccedi.setFont(new Font("Dialog", Font.PLAIN, 12));
		baccedi.setBounds(1215, 0, 150, 24);
		frame.getContentPane().setLayout(null);
		

		baccedi.setContentAreaFilled(true);

		frame.getContentPane().add(baccedi);

		
		
		

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1400, 800);
		frame.getContentPane().add(layeredPane);

		final JLabel lblNomeUtente = new JLabel("Nome utente");
		lblNomeUtente.setForeground(Color.GRAY);
		lblNomeUtente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNomeUtente.setBounds(912, 0, 150, 24);
		layeredPane.add(lblNomeUtente,2,0);
				


		CasellaNomeutente = new JTextField();
		layeredPane.setLayer(CasellaNomeutente, 0);
		
		Border border1 = BorderFactory.createLineBorder(Color.BLACK);
		CasellaNomeutente.setBorder(border1);
		
		
		CasellaNomeutente.setToolTipText("Inserire il nome utente");
		CasellaNomeutente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		CasellaNomeutente.setBounds(912, 0, 150, 24);
		layeredPane.add(CasellaNomeutente);
		CasellaNomeutente.setColumns(10);
		CasellaNomeutente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				lblNomeUtente.setBounds(0, 0, 0, 0);
			
				
				

			}
			public void focusLost(FocusEvent arg0) {
				CasellaNomeutente.setBackground(Color.WHITE);
			
				if(CasellaNomeutente.getText().isEmpty())
					lblNomeUtente.setBounds(920, 0, 150, 24);
				

			}
		});


		final JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(1075, 0, 150, 24);
		layeredPane.add(lblPassword,2,0);
		lblPassword.setForeground(Color.GRAY);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('•');
		passwordField.setToolTipText("Inserire la password");
		passwordField.setBounds(1065, 0, 150, 24);
		passwordField.setBorder(border1);
		layeredPane.add(passwordField);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				lblPassword.setBounds(0, 0, 0, 0);

			}
			@SuppressWarnings("deprecation")
			public void focusLost(FocusEvent arg0) {
				passwordField.setBackground(Color.WHITE);
			
				if(passwordField.getText().isEmpty())
					lblPassword.setBounds(1075, 0, 150, 24);
				

			}
		});
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordField.setForeground(Color.BLACK);



		
		
			
		//CasellaNomeutente.requestFocusInWindow();
	
		

	



		passwordField.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			public void keyReleased(KeyEvent e) { //ascolta i keystrokes
				if(CasellaNomeutente.getText().isEmpty() || passwordField.getText().isEmpty())
					baccedi.setEnabled(false);
				else
				{
					baccedi.setEnabled(true);
				}
			}
		});



		


		if(CasellaNomeutente.getText().isEmpty()||CasellaPassword.getText().isEmpty())
			baccedi.setEnabled(false);
		else
			baccedi.setEnabled(true);

		

		CasellaNomeutente.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			public void keyReleased(KeyEvent e) { //ascolta i keystrokes
				if(CasellaNomeutente.getText().isEmpty() || passwordField.getText().isEmpty())
					baccedi.setEnabled(false);
				else
				{
					baccedi.setEnabled(true);
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 5, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);
		
		
		tabelladisc.setModel(ElencoDiscipline.elencoiniziale());
		tabelladisc = new JTable();
		scrollPane.setViewportView(tabelladisc);
		final DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		final DefaultTableCellRenderer lead1 = new DefaultTableCellRenderer();
		lead1.setHorizontalAlignment( JLabel.LEADING);
		
		
		tabelladisc.setFillsViewportHeight(true);
		tabelladisc.setShowGrid(false);
		tabelladisc.setRowHeight(20);
		
		
		tabelladisc.getTableHeader().setReorderingAllowed(false);
		tabelladisc.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tabelladisc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tabelladisc.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent me) {
		        JTable table =(JTable) me.getSource();
		        Point p = me.getPoint();
		        table.rowAtPoint(p);
		    }
		});
		
		
		tabelladisc.setAutoCreateRowSorter(true);
	}
		
		
}



