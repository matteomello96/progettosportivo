package VisteIstruttore;

import javax.swing.JDialog;
import javax.swing.JFrame;

import VisteUtenteGenerico.FrameIniziale;
import ClassiDao.DettagliIstruttoreDAO;
import ClassiDao.DettagliLivelloDAO;
import ClassiDao.DettagliOrariDAO;
import ClassiDao.DettagliTestimonianzeDAO;
import ClassiDao.ElencoDisciplineDAO;
import ModelliTabelle.ModDetIstr;
import ModelliTabelle.ModDetLiv;
import ModelliTabelle.ModDetOrari;
import ModelliTabelle.ModDetTest;
import ModelliTabelle.ModDiscIni;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.TableHeaderUI;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.tree.TreeSelectionModel;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DetAtt {

	private JFrame frame;
	public JPanel contentPane,tabellaPnl,tabellaPnl2,tabellaPnl3,tabellaPnl4;
	public static JTable table1,table2,table3,table4;
    private ModDetLiv model1; 
    private ModDetIstr model2;
    private ModDetTest model3;
    private ModDetOrari model4;
    
    
	public DetAtt() {
     String disciplina=(String) FrameIniziale.table.getValueAt(FrameIniziale.table.getSelectedRow(), 0);
		frame = new JFrame();
		frame.setTitle("Dettaglio Disciplina: "+disciplina+"");
		frame.setBounds(100, 100, 956, 523);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setAutoRequestFocus(true);
		
		frame.setResizable(true);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (255,193,20));
		contentPane.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(30, 400, 300, 30);	
	    frame.getContentPane().add(scroll);
		
		JLabel lblInformazioniLivello = new JLabel("Livelli Disponibili:");
		lblInformazioniLivello.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInformazioniLivello.setBounds(29, 38, 353, 14);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		contentPane.add(lblInformazioniLivello, gbc);
		
		table1 = new JTable();
		model1 = new ModDetLiv(DettagliLivelloDAO.elencolivelli(disciplina));
		table1.setRowHeight(20);
		table1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table1.setCellSelectionEnabled(true);
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table1.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table1.setModel(model1);
		
		Dimension b = table1.getPreferredSize();
		table1.setPreferredSize(b);
		gbc.insets= new Insets(0,0,5,5);
		gbc.gridx =0;
		gbc.gridy =1;
		tabellaPnl = new JPanel();
		tabellaPnl.setLayout(new GridLayout(2, 1));
		tabellaPnl.add(table1.getTableHeader());
		tabellaPnl.add(table1);
		contentPane.add(tabellaPnl, gbc);
		
		
		
		JLabel lblInformazioniIstruttore = new JLabel("Istruttori della disciplina:");
		lblInformazioniIstruttore.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInformazioniIstruttore.setBounds(29, 38, 353, 14);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 5;
		contentPane.add(lblInformazioniIstruttore, gbc);
		
		table2 = new JTable();
		model2 = new ModDetIstr(DettagliIstruttoreDAO.elencoistruttore(disciplina));
		table2.setRowHeight(20);
		table2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table2.setCellSelectionEnabled(true);
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table2.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table2.setModel(model2);
		
		Dimension c = table2.getPreferredSize();
		table2.setPreferredSize(c);
		gbc.insets= new Insets(0,0,5,5);
		gbc.gridx =0;
		gbc.gridy =6;
		tabellaPnl2 = new JPanel();
		tabellaPnl2.setLayout(new GridLayout(2, 1));
		tabellaPnl2.add(table2.getTableHeader());
		tabellaPnl2.add(table2);
		contentPane.add(tabellaPnl2, gbc);

		JLabel lblInformazioniTestimonianze = new JLabel("Testimonianze relativa alla disciplina:");
		lblInformazioniTestimonianze.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInformazioniTestimonianze.setBounds(29, 38, 353, 14);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 9;
		contentPane.add(lblInformazioniTestimonianze, gbc);
		
		
		table3 = new JTable();
		model3 = new ModDetTest(DettagliTestimonianzeDAO.elencotestimonianze(disciplina));
		table3.setRowHeight(20);
		table3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table3.setCellSelectionEnabled(true);
		table3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		table3.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		table3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table3.setModel(model3);
		
		Dimension d = table3.getPreferredSize();
		table3.setPreferredSize(d);
		gbc.insets= new Insets(0,0,5,5);
		gbc.gridx =0;
		gbc.gridy =10;
		tabellaPnl3 = new JPanel();
		tabellaPnl3.setLayout(new GridLayout(2, 1));
		tabellaPnl3.add(table3.getTableHeader());
		tabellaPnl3.add(table3);
		contentPane.add(tabellaPnl3, gbc);
		
		JLabel lblInformazioniOrari = new JLabel("Orari di svolgimento della disciplina:");
		lblInformazioniOrari.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInformazioniOrari.setBounds(29, 38, 353, 14);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 13;
		contentPane.add(lblInformazioniOrari, gbc);
		
		
		table4 = new JTable();
		model4 = new ModDetOrari(DettagliOrariDAO.elencoorario(disciplina));
		table4.setRowHeight(20);
		table4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table4.setCellSelectionEnabled(true);
		table4.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		table4.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		table4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table4.setModel(model4);
		
		Dimension e = table1.getPreferredSize();
		table4.setPreferredSize(e);
		gbc.insets= new Insets(0,0,5,5);
		gbc.gridx =0;
		gbc.gridy =14;
		tabellaPnl4 = new JPanel();
		tabellaPnl4.setLayout(new GridLayout(2, 1));
		tabellaPnl4.add(table4.getTableHeader());
		tabellaPnl4.add(table4);
		contentPane.add(tabellaPnl4, gbc);
	}
}
