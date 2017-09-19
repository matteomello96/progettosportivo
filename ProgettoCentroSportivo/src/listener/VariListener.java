package listener;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import VisteUtenteGenerico.setupTableWidths;

public abstract class VariListener implements MouseListener{
	
	public static void SettaCarBtn(JButton bottone,boolean b1,boolean b2){
		
		bottone.setBorderPainted(b1);
        bottone.setContentAreaFilled(b1);
        bottone.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public static void SettaFocus(JTextField campo){
     campo.addFocusListener(new FocusAdapter() {
			
			public void focusGained(FocusEvent arg0) {
				campo.setBackground(Color.YELLOW);
				if(campo.getText().isEmpty())
					campo.setBackground(Color.CYAN);
				

			}
		});
	}
	public static void SettaLabelGen(JPanel panel,JLabel lbl,String tt,int x,int y){
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		lbl.setText(tt);
	    lbl.setOpaque(false);
		lbl.setBounds(253, 95, 86, 20);
		lbl.setForeground(new Color (255,255,255));
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.anchor = GridBagConstraints.LINE_START;
		panel.add(lbl, gbc);
		
	}
	public static void SettaBox(JPanel panel,@SuppressWarnings("rawtypes") JComboBox box,int x,int y){
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		box.setVisible(true);
		box.setEnabled(true);
		box.setEditable(false);
		box.setForeground(Color.BLUE);
		box.setFont(new Font("Tahoma", Font.PLAIN, 20));
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = x;
		gbc.gridy = y;
		panel.add(box, gbc);
		
	}
	
	public static void SettaTextField(JPanel panel,JTextField campo,String tt,int x,int y){
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		Border border2 = BorderFactory.createLineBorder(Color.BLACK);
		
		campo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		campo.setToolTipText(tt);
		campo.setBounds(253, 95, 86, 20);
		campo.setBorder(border2);
		campo.setForeground(Color.BLACK);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.anchor = GridBagConstraints.LINE_END;
		panel.add(campo,gbc);
		campo.setColumns(10);
		
	}
	
	public static void SettaBtn(JPanel panel,JButton bottone,JLabel lbl,String tt,int x,int y,ImageIcon im2,boolean bool){
		GridBagConstraints gbc = new GridBagConstraints();
		
		lbl.setText(tt);
		lbl.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lbl.setForeground(Color.WHITE);
		lbl.setOpaque(false);
		gbc.gridx = x;
		gbc.gridy = y;
		
		panel.add(lbl, gbc);
		
		if(bool==false){
			lbl.setVisible(bool);
		
		}
        
		
		VariListener.SettaCarBtn(bottone,false,false);
		VariListener.SettaClickBtn1(bottone, lbl, im2);
		gbc.gridx = x;
		gbc.gridy = y;
		panel.add(bottone, gbc);
		
	}
	
	public static void SettaClickBtn1(JButton bottone,JLabel label,ImageIcon im2){
	bottone.addMouseListener(new MouseAdapter(){
		public void mousePressed(MouseEvent e)
	{
	    bottone.setPressedIcon(im2);
		label.setForeground(Color.RED);
	}});
}
	
	
	
	public static JScrollPane SettaScroll(JTable table,int altezza,TableModel model){
		JTable tablemod;
        table.setRowHeight(altezza);
		
        table.setModel(model);
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table.setCellSelectionEnabled(true);
		// .
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		Font font2 = new Font("Comic Sans", Font.PLAIN, 20);
		table.setFont(font2);
		tablemod = setupTableWidths.setupTableWidths(table);

		tablemod.setForeground(new Color(255, 255, 255));
		tablemod.setBackground(new Color(240, 220, 130));
		
		JScrollPane scrollt = new JScrollPane();

		scrollt.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollt.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollt.setBackground(new Color(255, 193, 20));
		scrollt.setViewportView(tablemod);
		if(model.getRowCount()==0)
		{
			scrollt.setViewportView(VariListener.SettaNull());
		}
		return scrollt;
	}
	
	
	public static JScrollPane SettaScroll3(JTable table,int altezza){
		JTable tablemod;
		
        table.setRowHeight(altezza);
        table.setModel(new DefaultTableModel(
    			new Object[][] {
    			},
    			new String[] {
    					"Nome Evento","Descrizione","TipoEvento","Nome istruttore","Cognome istruttore","Disciplina","Livello","Costo Evento","Codice Evento"
    			}
    		){
    			
    			private static final long serialVersionUID = 1L;
    			@SuppressWarnings("rawtypes")
    			Class[] columnTypes = new Class[] {
    					String.class, String.class, String.class,String.class, String.class, String.class, String.class, Integer.class , Integer.class
    					
    				};
    			
    				public Class<?> getColumnClass(int columnIndex) {
    					return columnTypes[columnIndex];
    				}
    				
    			
    		});
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table.setCellSelectionEnabled(true);
		// .
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setAutoCreateRowSorter(true);
		Font font2 = new Font("Comic Sans", Font.PLAIN, 20);
		table.setFont(font2);
		tablemod = setupTableWidths.setupTableWidths(table);

		tablemod.setForeground(new Color(255, 255, 255));
		tablemod.setBackground(new Color(240, 220, 130));
		
		JScrollPane scrollt = new JScrollPane();

		scrollt.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollt.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollt.setBackground(new Color(255, 193, 20));
		scrollt.setViewportView(tablemod);
		
		return scrollt;
	}
	
	
	public static JScrollPane SettaScroll2(JTable table,int altezza){
		JTable tablemod;
		
        table.setRowHeight(altezza);
        table.setModel(new DefaultTableModel(
    			new Object[][] {
    			},
    			new String[] {
    				"Disciplina", "Livello", "CostoMensile"
    			})
    		{
    			
    			private static final long serialVersionUID = 1L;
    			@SuppressWarnings("rawtypes")
    			Class[] columnTypes = new Class[] {
    					String.class, String.class, Integer.class
    					
    				};
    			
    				public Class<?> getColumnClass(int columnIndex) {
    					return columnTypes[columnIndex];
    				}
    				
    			
    		});
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table.setCellSelectionEnabled(true);
		// .
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setAutoCreateRowSorter(true);
		Font font2 = new Font("Comic Sans", Font.PLAIN, 20);
		table.setFont(font2);
		tablemod = setupTableWidths.setupTableWidths(table);

		tablemod.setForeground(new Color(255, 255, 255));
		tablemod.setBackground(new Color(240, 220, 130));
		
		JScrollPane scrollt = new JScrollPane();

		scrollt.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollt.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollt.setBackground(new Color(255, 193, 20));
		scrollt.setViewportView(tablemod);
		
		return scrollt;
	}
	
	
	
	
	public static JPanel SettaPannelloTitolo(ImageIcon img,JPanel oggetto,int x,int y,String titolo){
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel lbl1 = new JLabel(titolo);
		lbl1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lbl1.setForeground( Color.WHITE);
		lbl1.setOpaque(false);
		gbc.gridx = x;
		gbc.gridy = y;
		oggetto.add(lbl1, gbc);
		
		
		
		JLabel lbl2 = new JLabel(img);
		gbc.gridx = x;
		gbc.gridy = y;
		lbl2.setOpaque(true);
		

		oggetto.add(lbl2, gbc);
		
		
		
        return oggetto;
	}
	
	public static JLabel SettaNull(){
		JLabel lblNull = new JLabel("Nessuna informazione disponibile");
		lblNull.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNull.setBounds(40,40,100,300);
		lblNull.setOpaque(true);
		lblNull.setForeground(new Color (255,255,255));
		lblNull.setBackground(new Color (0,150,17));
		Border b = BorderFactory.createLineBorder(new Color (255,205,255));
		lblNull.setBorder(b);
		return lblNull;
	}
	public static void SettaErr(String err,JLabel lblerr,int x,int y,JPanel panel){
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		lblerr.setText(err);
		lblerr.setOpaque(false);
		lblerr.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblerr.setForeground(new Color(255, 255, 255));
		lblerr.setBounds(25, 30, 10, 10);
		lblerr.setVisible(false);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		panel.add(lblerr,gbc);
	}
	
	public static void SettaErr2(String err,JLabel lblerr,int x,int y,JPanel panel){
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		lblerr.setText(err);
		lblerr.setOpaque(false);
		lblerr.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblerr.setForeground(Color.BLUE);
		lblerr.setBounds(25, 30, 10, 10);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		panel.add(lblerr,gbc);
	}
	public static void SettaErr3(String err,JLabel lblerr,int x,int y,JPanel panel){
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		lblerr.setText(err);
		lblerr.setOpaque(false);
		lblerr.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblerr.setForeground(Color.ORANGE);
		lblerr.setBounds(25, 30, 10, 10);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		panel.add(lblerr,gbc);
	}
	
	
}
