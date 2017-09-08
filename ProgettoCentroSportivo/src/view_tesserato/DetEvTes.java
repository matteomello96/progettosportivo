package view_tesserato;

import javax.swing.JDialog;
import javax.swing.JFrame;

import VisteUtenteGenerico.FrameIniziale;
import modelliTabelleIstruttore.ModDetOrariEv;
import ClassiDao.DettagliIstruttoreDAO;
import ClassiDao.DettagliLivelloDAO;
import ClassiDao.DettagliOrariDAO;
import ClassiDao.DettagliTestimonianzeDAO;
import ClassiDao.ElencoDisciplineDAO;
import ClassiDao.GetInfoDB;
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

import ClassiDAOIstruttore.DettagliOrariEvDAO;

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

public class DetEvTes {

	private JFrame frame;
	public JPanel contentPane,tabellaPnl,tabellaPnl2,tabellaPnl3,tabellaPnl4;
	public static JTable table1,table2,table3,table4;
    private ModDetOrariEv model1; 
    private ModDetIstr model2;
    private ModDetTest model3;
    private ModDetOrari model4;
    
    
	public DetEvTes() {
     String evento=(String) FrameEventi.table.getValueAt(FrameEventi.table.getSelectedRow(), 0);
		frame = new JFrame();
		frame.setTitle("Dettaglio Evento: "+evento+"");
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
		
		JLabel lblTurni = new JLabel("Turni disponibili:");
		lblTurni.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTurni.setBounds(29, 38, 353, 14);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		contentPane.add(lblTurni, gbc);
		
		table1 = new JTable();
		model1 = new ModDetOrariEv(DettagliOrariEvDAO.elencoorario(evento));
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
		
		JLabel costoev = new JLabel("Costo dell'evento:");
		costoev.setBounds(29, 38, 353, 14);
		costoev.setFont(new Font("Tahoma", Font.BOLD, 11));
		costoev.setText("Costo dell'evento: '"+GetInfoDB.getcosto(evento)+"'");
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 5;
		contentPane.add(costoev, gbc);
		
		
		
		
	}
}
