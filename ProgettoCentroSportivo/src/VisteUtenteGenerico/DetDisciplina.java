package VisteUtenteGenerico;

import javax.swing.BorderFactory;

import javax.swing.JFrame;

import VisteUtenteGenerico.FrameIniziale;
import listener.Listen;
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
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

import javax.swing.tree.TreeSelectionModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Insets;


public class DetDisciplina {

	public static JFrame frame;
	public JPanel contentPane,tabellaPnl,tabellaPnl2,tabellaPnl3,tabellaPnl4;
	public static JTable table1,table2,table3,table4,tablemod1,tablemod2,tablemod3,tablemod4;
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
		contentPane.setBackground(new Color (255,193,20));
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
		
	    JLabel lblNull = new JLabel("Nessuna informazione disponibile");
		lblNull.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNull.setBounds(40,40,100,300);
		lblNull.setOpaque(true);
		lblNull.setForeground(new Color (255,255,255));
		lblNull.setBackground(new Color (0,150,17));
		Border b = BorderFactory.createLineBorder(new Color (255,205,255));
		lblNull.setBorder(b);
		
		
		
		
		
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
		table1.setRowHeight(20);
		table1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table1.setCellSelectionEnabled(true);
		table1.setModel(model1);
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table1.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablemod1= setupTableWidths.setupTableWidths(table1);
		tablemod1.setForeground(new Color (255,255,255));
		tablemod1.setBackground(new Color (240,220,130));
		
		
		JScrollPane scrollt1 = new JScrollPane();
		
		scrollt1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollt1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollt1.setBackground(new Color (255,193,20));
		scrollt1.setViewportView(tablemod1);
		if(model1.getRowCount()==0)
		{
			scrollt1.setViewportView(lblNull);
		}
		
		
		/*Dimension b = table1.getPreferredSize();
		table1.setPreferredSize(b);
		gbc.insets= new Insets(0,0,5,5);
		gbc.gridx =0;
		gbc.gridy =1;*/
		/*tabellaPnl = new JPanel();
		tabellaPnl.setLayout(new GridLayout(2, 1));
		tabellaPnl.add(table1.getTableHeader());
		tabellaPnl.add(table1);*/
		tabellaPnl.add(scrollt1,BorderLayout.CENTER);
		
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
		table2.setRowHeight(20);
		table2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table2.setCellSelectionEnabled(true);
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table2.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table2.setModel(model2);
		tablemod2= setupTableWidths.setupTableWidths(table2);
		tablemod2.setForeground(new Color (255,255,255));
		tablemod2.setBackground(new Color (240,220,130));
		
		
		JScrollPane scrollt2 = new JScrollPane();
		
		scrollt2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollt2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollt2.setBackground(new Color (255,193,20));
		scrollt2.setViewportView(tablemod2);
		if(model2.getRowCount()==0)
		{
			scrollt2.setViewportView(lblNull);
		}
		/*Dimension c = table2.getPreferredSize();
		table2.setPreferredSize(c);
		gbc.insets= new Insets(0,0,5,5);
		gbc.gridx =0;
		gbc.gridy =6;
		tabellaPnl2 = new JPanel();
		tabellaPnl2.setLayout(new GridLayout(2, 1));
		tabellaPnl2.add(table2.getTableHeader());
		tabellaPnl2.add(table2);*/
		tabellaPnl2.add(scrollt2,BorderLayout.CENTER);
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
		table3.setRowHeight(20);
		table3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table3.setCellSelectionEnabled(true);
		table3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		table3.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		table3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table3.setModel(model3);
		
		tablemod3= setupTableWidths.setupTableWidths(table3);
		tablemod3.setForeground(new Color (255,255,255));
		tablemod3.setBackground(new Color (240,220,130));
		
		JScrollPane scrollt3 = new JScrollPane();
		
		scrollt3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollt3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollt3.setBackground(new Color (255,193,20));
		scrollt3.setViewportView(tablemod3);
		if(model3.getRowCount()==0)
		{
			scrollt3.setViewportView(lblNull);
		}
		/*Dimension c = table2.getPreferredSize();
		table2.setPreferredSize(c);
		gbc.insets= new Insets(0,0,5,5);
		gbc.gridx =0;
		gbc.gridy =6;
		tabellaPnl2 = new JPanel();
		tabellaPnl2.setLayout(new GridLayout(2, 1));
		tabellaPnl2.add(table2.getTableHeader());
		tabellaPnl2.add(table2);*/
		tabellaPnl3.add(scrollt3,BorderLayout.CENTER);
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
		table4.setRowHeight(20);
		table4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table4.setCellSelectionEnabled(true);
		table4.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		table4.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		table4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table4.setModel(model4);
		
		tablemod4= setupTableWidths.setupTableWidths(table4);
		tablemod4.setForeground(new Color (255,255,255));
		tablemod4.setBackground(new Color (240,220,130));
		
		
		JScrollPane scrollt4 = new JScrollPane();
		
		scrollt4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollt4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollt4.setBackground(new Color (255,193,20));
		scrollt4.setViewportView(tablemod4);
		if(model4.getRowCount()==0)
		{
			scrollt4.setViewportView(lblNull);
		}
		/*Dimension c = table2.getPreferredSize();
		table2.setPreferredSize(c);
		gbc.insets= new Insets(0,0,5,5);
		gbc.gridx =0;
		gbc.gridy =6;
		tabellaPnl2 = new JPanel();
		tabellaPnl2.setLayout(new GridLayout(2, 1));
		tabellaPnl2.add(table2.getTableHeader());
		tabellaPnl2.add(table2);*/
		tabellaPnl4.add(scrollt4,BorderLayout.CENTER);
		tabel.addTab("Orari relativi alla disciplina",tabellaPnl4);
		
		contentPane.add(tabel,gbc);
	}
}
