package view_tesserato;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import ClassiDao.GetInfoDB;
import ClassiDaoTesserato.ElencoGiornoOraDAO;
import ClassiDaoTesserato.Invia_Turno_Dao;
import ClassiDaoTesserato.Modifica_Turno_Dao;
import ClassiDaoTesserato.RichiesteDaoTes;
import ComboTesserato.Combogiorno;
import ComboTesserato.Comboorario;
import ModelliTabelle_Tesserato.ModGiornoOra;
import VisteUtenteGenerico.setupTableWidths;
import modelliTabelleRespo.modelisc;









public class FrameModificaTurno extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public JButton btnNewButton;
	public static JFrame frame;
	public static Comboorario Comboorario;
	public static Combogiorno Combogiorno;
	public String ora=(String) FrameDettagliDaAccTess.table_2.getValueAt(FrameDettagliDaAccTess.table_2.getSelectedRow(), 6);
	public String giorno=(String) FrameDettagliDaAccTess.table_2.getValueAt(FrameDettagliDaAccTess.table_2.getSelectedRow(), 5);
	public JButton btnNewButton_1;
    public JPanel contentPane;
    public String giorno2;
	public String orario2;
	public static JTable table2;



	public JTable tablemod2;
	public ModGiornoOra model2;
	
	private int codiceturno;
	private int postidisponibili;
	
	
	public FrameModificaTurno(String disciplina, String livello,int tesserato) {
		final DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		
		frame = new JFrame("Modifica turno disciplina:"+disciplina+" livello: "+livello+"");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 605, 391);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		frame.setAlwaysOnTop(true);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (255,36,0));
		contentPane.setLayout(new BorderLayout());
		
		
		
		
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
	    
	    
	    GridBagConstraints gbc = new GridBagConstraints();
	    
	    
		
	    JLabel lblUtentiS = new JLabel("Giorni e fasce orarie disponibili");
		lblUtentiS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUtentiS.setForeground(Color.WHITE);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 1;
		contentPane.add(lblUtentiS,BorderLayout.NORTH);
		
		table2 = new JTable();
		model2 = new ModGiornoOra(ElencoGiornoOraDAO.elencoiniziale(disciplina, livello));
		table2.setRowHeight(50);
		table2.setRowHeight(3, 50);
		table2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table2.setCellSelectionEnabled(true);
		// .
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table2.setModel(model2);
		
		
		tablemod2 = setupTableWidths.setupTableWidths(table2);

		tablemod2.setForeground(new Color(255, 255, 255));
		tablemod2.setBackground(new Color(240, 220, 130));

		JScrollPane scrollt2 = new JScrollPane();

		scrollt2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollt2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollt2.setBackground(new Color(255, 193, 20));
		scrollt2.setViewportView(tablemod2);

		contentPane.add(scrollt2, BorderLayout.CENTER);
				
		JButton bottone= new JButton("Modifica Parte dell'Ordine");
        bottone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bottone.setForeground(Color.BLACK);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 3;
		contentPane.add(bottone,BorderLayout.SOUTH);
			
				bottone.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent arg0) {
				   String  giorno2 =	(String) FrameModificaTurno.table2.getValueAt(FrameModificaTurno.table2.getSelectedRow(), 0);
				   String orario2= (String) FrameModificaTurno.table2.getValueAt(FrameModificaTurno.table2.getSelectedRow(), 1);
				    codiceturno = GetInfoDB.getcodiceturno2(disciplina,livello ,giorno2 ,orario2);
			        int iddet= GetInfoDB.getiddet3(disciplina, livello, tesserato,(String) FrameDettagliDaAccTess.table_2.getValueAt(FrameDettagliDaAccTess.table_2.getSelectedRow(), 5), (String) FrameDettagliDaAccTess.table_2.getValueAt(FrameDettagliDaAccTess.table_2.getSelectedRow(), 6));
			        JOptionPane.showMessageDialog(frame,""+iddet+""+""+giorno2+""+orario2+"");
			        int codturnoprec=GetInfoDB.getcodiceturno2(disciplina, livello, (String) FrameDettagliDaAccTess.table_2.getValueAt(FrameDettagliDaAccTess.table_2.getSelectedRow(), 5), (String) FrameDettagliDaAccTess.table_2.getValueAt(FrameDettagliDaAccTess.table_2.getSelectedRow(), 6));
					postidisponibili = GetInfoDB.getprenotazioni(codiceturno);
					if(postidisponibili==0){
						JOptionPane.showMessageDialog(FrameDettagliDaAccTess.frame, "Posti massimi raggiunti"," ",JOptionPane.WARNING_MESSAGE);	
					}
					else{
					
					Modifica_Turno_Dao.ModificaDaAcc(livello,disciplina,giorno2,orario2,tesserato,iddet,codturnoprec);
					
			        JOptionPane.showMessageDialog(frame,"La modifica è stata apportata.Attendi la conferma da parte del responsabile!");
					frame.dispose();
					new FrameIscrDisc();
					}	
	
				}});
			
		
			
			
			
			

			
	
			

			
			frame.addWindowListener(new java.awt.event.WindowAdapter() {
				   @Override
				   public void windowClosing(java.awt.event.WindowEvent windowEvent) 
				    {
					   FrameDettagliDaAccTess.frame.setVisible(true);
				    
				    }
				});
	}

}
