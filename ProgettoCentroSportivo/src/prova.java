import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;

import java.awt.GridBagConstraints;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JEditorPane;
import javax.swing.JFrame;

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import ComboTesserato.Combodis;
import ComboTesserato.Combogiorno;
import ComboTesserato.Comboorario;
import ComboTesserato.combolivello;
import Listener.Listen;
import Model.Utente;
import ModelliTabelleRespo.ModElUtenti;
import ModelliTabelleRespo.modelisc;
import VisteUtenteGenerico.FrameCambia;
import classiDAOResponsabile.ElencoUtentiDAO;
import classiDAOResponsabile.RichiesteDao;
import view_tesserato.FrameTesserato;
import visteadmin.FrameOrdini;
import visteadmin.framediscdisp;

import java.awt.Color;

public class prova extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public static JFrame frame;
	
	public JPanel contentPane;
	public JTable table;
    private ModElUtenti model;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public prova() {

		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
	
		JMenu mnNewMenu = new JMenu("Home");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Logout");
		mnNewMenu.add(mntmNewMenuItem);
		

		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("CambiaPassword");

		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem MenuOrdini = new JMenuItem("Visualizza richieste di pagamento");

		mnNewMenu.add(MenuOrdini);

		JMenuItem MenuDiscipline = new JMenuItem("Discipline");
		
	
		
		
		mnNewMenu.add(MenuDiscipline);
		
		 
		GridBagConstraints gbc = new GridBagConstraints();

		
		JLabel lblUtenti = new JLabel("Elenco degli utenti");
		lblUtenti.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUtenti.setForeground(Color.WHITE);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 1;
		add(lblUtenti, gbc);
		
	
		
		
		
		JScrollPane pane2 = new JScrollPane(table);
		pane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridwidth = 2;
		gbc.gridx = 2;
		gbc.gridy = 3;
		
		add(pane2,gbc);
		
	}
	

}
