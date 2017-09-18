package VisteUtenteGenerico;

import javax.swing.BorderFactory;

import javax.swing.JFrame;

import VisteUtenteGenerico.FrameIniziale;
import listener.Listen;
import listener.VariListener;
import ClassiDao.DettagliIstruttoreDAO;
import ClassiDao.DettagliLivelloDAO;
import ClassiDao.DettagliOrariDAO;
import ClassiDao.DettagliTestimonianzeDAO;
import ModelliTabelle.ModDetIstr;
import ModelliTabelle.ModDetLiv;
import ModelliTabelle.ModDetOrari;
import ModelliTabelle.ModDetTest;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Insets;


public class DetDisciplina {

	public static JFrame frame;
	public JPanel contentPane,tabellaPnl,tabellaPnl2,tabellaPnl3,tabellaPnl4;
	public static JTable table1,table2,table3,table4;
    private ModDetLiv model1; 
    private ModDetIstr model2;
    private ModDetTest model3;
    private ModDetOrari model4;
    private JTabbedPane tabel = new JTabbedPane();
    
	public DetDisciplina() {
     String disciplina=(String) FrameIniziale.table.getValueAt(FrameIniziale.table.getSelectedRow(), 0);
		frame = new JFrame();
		frame.setTitle("Dettaglio Disciplina: "+disciplina+"");
		frame.setBounds(100, 100, 956, 523);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setAutoRequestFocus(true);
		
		frame.setResizable(true);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem MenuRegistra = new JMenuItem("Ritorna alla homepage");
	
		menuBar.add(MenuRegistra);
		MenuRegistra.addActionListener(new Listen(this));
		MenuRegistra.setActionCommand("Vai_home_da_det");
		
		
		
		
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(229, 43, 80));
		contentPane.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(30, 400, 300, 30);	
	    frame.getContentPane().add(scroll);
		
	    tabellaPnl = new JPanel();
		tabellaPnl.setLayout(new BorderLayout());
		tabellaPnl.setBackground(new Color(140,140,140));
		
	    
		
		
		
		
		
		JLabel lblInformazioniLivello = new JLabel("Livelli Disponibili:");
		lblInformazioniLivello.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInformazioniLivello.setOpaque(true);
		lblInformazioniLivello.setBounds(29, 38, 353, 14);
		lblInformazioniLivello.setForeground(new Color (255,255,255));
		lblInformazioniLivello.setBackground(new Color (0,133,217));
		Border c = BorderFactory.createLineBorder(new Color (255,205,255));
		lblInformazioniLivello.setBorder(c);
		gbc.insets = new Insets(0, 0, 5, 5);
		//gbc.gridx = 0;
		//gbc.gridy = 0;
		tabellaPnl.add(lblInformazioniLivello,BorderLayout.NORTH);
		
		table1 = new JTable();
		model1 = new ModDetLiv(DettagliLivelloDAO.elencolivelli(disciplina));
		tabellaPnl.add(VariListener.SettaScroll(table1, 20,model1),BorderLayout.CENTER);
		
		tabel.addTab("Livelli disponibili",tabellaPnl);
		
		
		tabellaPnl2 = new JPanel();
		tabellaPnl2.setLayout(new BorderLayout());
		tabellaPnl2.setBackground(new Color(140,140,140));
		
		JLabel lblInformazioniIstruttore = new JLabel("Istruttori della disciplina:");
		lblInformazioniIstruttore.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInformazioniIstruttore.setBounds(29, 38, 353, 14);
		lblInformazioniIstruttore.setOpaque(true);
		lblInformazioniIstruttore.setForeground(new Color (255,255,255));
		lblInformazioniIstruttore.setBackground(new Color (0,133,217));
		Border d = BorderFactory.createLineBorder(new Color (255,205,255));
		lblInformazioniLivello.setBorder(d);
		
		
		
		tabellaPnl2.add(lblInformazioniIstruttore, BorderLayout.NORTH);
		
		table2 = new JTable();
		model2 = new ModDetIstr(DettagliIstruttoreDAO.elencoistruttore(disciplina));
		tabellaPnl2.add(VariListener.SettaScroll(table2, 20,model2),BorderLayout.CENTER);
		
		
		tabel.addTab("Cultori della disciplina",tabellaPnl2);
		
		tabellaPnl3 = new JPanel();
		tabellaPnl3.setLayout(new BorderLayout());
		tabellaPnl3.setBackground(new Color(140,140,140));
		
		JLabel lblInformazioniTestimonianze = new JLabel("Testimonianze relativa alla disciplina:");
		lblInformazioniTestimonianze.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInformazioniTestimonianze.setBounds(29, 38, 353, 14);
		lblInformazioniTestimonianze.setOpaque(true);
		lblInformazioniTestimonianze.setForeground(new Color (255,255,255));
		lblInformazioniTestimonianze.setBackground(new Color (0,133,217));
		Border f = BorderFactory.createLineBorder(new Color (255,205,255));
		lblInformazioniTestimonianze.setBorder(f);
		
		
		tabellaPnl3.add(lblInformazioniTestimonianze, BorderLayout.NORTH);
		
		
		
		table3 = new JTable();
		model3 = new ModDetTest(DettagliTestimonianzeDAO.elencotestimonianze(disciplina));
		tabellaPnl3.add(VariListener.SettaScroll(table3, 20,model3),BorderLayout.CENTER);
		
		
		
		
		tabel.addTab("Testimonianze relative alla disciplina",tabellaPnl3);
		
		tabellaPnl4 = new JPanel();
		tabellaPnl4.setLayout(new BorderLayout());
		tabellaPnl4.setBackground(new Color(140,140,140));
		
		JLabel lblInformazioniOrari = new JLabel("Orari di svolgimento della disciplina:");
		lblInformazioniOrari.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInformazioniOrari.setBounds(29, 38, 353, 14);
		lblInformazioniOrari.setOpaque(true);
		lblInformazioniOrari.setForeground(new Color (255,255,255));
		lblInformazioniOrari.setBackground(new Color (0,133,217));
		Border e = BorderFactory.createLineBorder(new Color (255,205,255));
		lblInformazioniOrari.setBorder(e);
		
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 13;
		tabellaPnl4.add(lblInformazioniOrari,BorderLayout.NORTH);
		
		
		table4 = new JTable();
		model4 = new ModDetOrari(DettagliOrariDAO.elencoorario(disciplina));
		tabellaPnl4.add(VariListener.SettaScroll(table4, 20,model4),BorderLayout.CENTER);
		
		
		tabel.addTab("Orari relativi alla disciplina",tabellaPnl4);
		
		contentPane.add(tabel,gbc);
	}
}
