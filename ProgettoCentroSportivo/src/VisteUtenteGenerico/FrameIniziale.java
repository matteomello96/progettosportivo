package VisteUtenteGenerico;

import java.awt.BorderLayout;

import javax.swing.border.Border;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.imageio.ImageIO;

import javax.swing.BorderFactory;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JMenuBar;                                   
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;

import java.awt.Image;
import VisteUtenteGenerico.ScalaImmagine;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;

import java.awt.Insets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import ClassiDao.ElencoDisciplineDAO;

import java.awt.ComponentOrientation;
import java.awt.Container;

import ModelliTabelle.ModDiscIni;

import javax.swing.JScrollPane;
import VisteUtenteGenerico.setupTableWidths;
import listener.Listen;

public class FrameIniziale extends JFrame {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	public static JFrame frame;

	public JPanel contentPane, tabellaPnl, panelImage, panelCenter, PanelBottom;
	public static JTable table, tablemod;
	private ModDiscIni model;
	BufferedImage img;
	int cordx;
	int cordy;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 */
	public FrameIniziale() {

		FrameIniziale.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("Pagina iniziale");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(200, 200, 705, 491);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);

		frame.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent ev) {
				cordx = ev.getX();
				cordy = ev.getY();
			}
		});

		frame.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent evt) {
				int x = evt.getXOnScreen() - cordx;
				int y = evt.getYOnScreen() - cordy;
				// System.out.println(x+","+y+" "+xi+","+yi);
				frame.setLocation(x, y);

			}
		});

		Container c = this.getContentPane();
		c.setBackground(new Color(255, 193, 20));
		c.setLayout(new BorderLayout());

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenuItem MenuRegistra = new JMenuItem("Registrati al portale");

		menuBar.add(MenuRegistra);
		MenuRegistra.addActionListener(new Listen(this));
		MenuRegistra.setActionCommand("Vai_reg");

		JMenuItem MenuAccedi = new JMenuItem("Accedi al portale");

		menuBar.add(MenuAccedi);
		MenuAccedi.addActionListener(new Listen(this));
		MenuAccedi.setActionCommand("Vai_log");

		JScrollPane scroll = new JScrollPane(c);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		scroll.setBounds(100, 100, 605, 391);
		frame.getContentPane().add(scroll);

		// panelImage = new JPanel();
		panelCenter = new JPanel();
		panelCenter.setLayout(new GridBagLayout());
		panelCenter.setBackground(new Color(255, 193, 20));
		GridBagConstraints gbc = new GridBagConstraints();

		Image img = null;
		ImageIcon icon = null;
		try {
			img = ScalaImmagine.immaginescalata(ImageIO.read(new File("src/immaginijava/logo.GIF ")), 500, 300);
		} catch (IOException e1) {

			e1.printStackTrace();
		}

		JLabel lblNewLabel = new JLabel();
		icon = new ImageIcon(img);
		lblNewLabel.setIcon(icon);
		lblNewLabel.setForeground(new Color(0, 123, 167));
		lblNewLabel.setBackground(new Color(0, 133, 217));
		Border b = BorderFactory.createLineBorder(new Color(255, 205, 255));
		lblNewLabel.setBorder(b);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 1;
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		panelCenter.add(lblNewLabel, gbc);

		JLabel lblLeNostreDiscipline = new JLabel("Le nostre discipline");
		gbc.gridx = 2;
		gbc.gridy = 2;

		Border bordo2 = BorderFactory.createLineBorder(new Color(255, 205, 255));
		lblLeNostreDiscipline.setBorder(bordo2);
		Font font = new Font("Comic Sans", Font.PLAIN, 25);
		lblLeNostreDiscipline.setFont(font);
		lblLeNostreDiscipline.setFont(lblLeNostreDiscipline.getFont().deriveFont(Font.BOLD));
		lblLeNostreDiscipline.setForeground(Color.WHITE);
		lblLeNostreDiscipline.setOpaque(true);
		lblLeNostreDiscipline.setBackground(new Color(10, 173, 217));

		panelCenter.add(lblLeNostreDiscipline, gbc);

		c.add(panelCenter, BorderLayout.NORTH);

		table = new JTable();
		model = new ModDiscIni(ElencoDisciplineDAO.elencoiniziale());
		table.setRowHeight(250);
		table.setRowHeight(3, 250);
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table.setCellSelectionEnabled(true);
		// .
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(model);
		Font font2 = new Font("Comic Sans", Font.PLAIN, 25);
		table.setFont(font2);
		tablemod = setupTableWidths.setupTableWidths(table);

		tablemod.setForeground(new Color(255, 255, 255));
		tablemod.setBackground(new Color(240, 220, 130));

		JScrollPane scrollt1 = new JScrollPane();

		scrollt1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollt1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollt1.setBackground(new Color(255, 193, 20));
		scrollt1.setViewportView(tablemod);

		c.add(scrollt1, BorderLayout.CENTER);

		PanelBottom = new JPanel();
		PanelBottom.setLayout(new GridBagLayout());
		PanelBottom.setBackground(new Color(255, 193, 20));

		JButton btnNewButton = new JButton("Dettagli Disciplina");
		gbc.gridx = 2;
		gbc.gridy = 2;
		btnNewButton.setMnemonic('d');
		btnNewButton.setSize(50, 75);
		btnNewButton.setBackground(new Color(240, 150, 90));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					new DetDisciplina();
					FrameIniziale.frame.setVisible(false);
				} else
					JOptionPane.showMessageDialog(null, "Seleziona una disciplina dall'elenco", "Errore disciplina",
							JOptionPane.WARNING_MESSAGE);
			}
		});
		PanelBottom.add(btnNewButton, gbc);

		c.add(PanelBottom, BorderLayout.SOUTH);

	}

}
