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
import java.net.URL;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import ClassiDao.ElencoDisciplineDAO;
import java.awt.Container;
import ModelliTabelle.ModDiscIni;
import javax.swing.JScrollPane;
import listener.Listen;
import listener.VariListener;

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
	public static JTable table;
	private ModDiscIni model;
	Image img;
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
		c.setBackground(new Color(229, 43, 80));
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
		
		
		URL url1 = ClassLoader.getSystemResource("immaginijava/bottone1.png");
		URL url2 = ClassLoader.getSystemResource("immaginijava/bottone2.png");
		URL url3 = ClassLoader.getSystemResource("immaginijava/titolo1.png");
		
        ImageIcon im=new ImageIcon(url1);
        ImageIcon im2=new ImageIcon(url2);
        ImageIcon im3=new ImageIcon(url3);
        
		// panelImage = new JPanel();
		panelCenter = new JPanel();
		panelCenter.setLayout(new GridBagLayout());
		panelCenter.setBackground(new Color(229, 43, 80));
		GridBagConstraints gbc = new GridBagConstraints();
 
		URL url4 = ClassLoader.getSystemResource("immaginijava/logo.GIF");
		Image im4=null;
		try {
			im4 = ImageIO.read(url4);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		ImageIcon icon=null;
		img = ScalaImmagine.immaginescalata(im4, 500, 300);

		JLabel lblNewLabel = new JLabel();
		icon = new ImageIcon(img);
		lblNewLabel.setIcon(icon);
		Border b = BorderFactory.createLineBorder(new Color(255, 205, 255));
		lblNewLabel.setBorder(b);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 1;
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		panelCenter.add(lblNewLabel, gbc);

		
		
		c.add(VariListener.SettaPannelloTitolo(im3, panelCenter, 2, 2, "Le nostre discipline"), BorderLayout.NORTH);

		table = new JTable();
		model = new ModDiscIni(ElencoDisciplineDAO.elencoiniziale());
		
		c.add(VariListener.SettaScroll(table,250,model), BorderLayout.CENTER);

		PanelBottom = new JPanel();
		PanelBottom.setLayout(new GridBagLayout());
		PanelBottom.setBackground(new Color(229, 43, 80));
		
		JLabel lblNewLabel2 = new JLabel("Dettagli disciplina");
		lblNewLabel2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel2.setForeground( Color.WHITE);
		lblNewLabel2.setOpaque(false);
		gbc.gridx = 2;
		gbc.gridy = 2;
		PanelBottom.add(lblNewLabel2, gbc);
		
		
        
		JButton btnNewButton = new JButton(im);
		VariListener.SettaCarBtn(btnNewButton,false,false);
		gbc.gridx = 2;
		gbc.gridy = 2;
		btnNewButton.setMnemonic('d');
		
				
        VariListener.SettaClickBtn1(btnNewButton,lblNewLabel2,im2);
	   
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel2.setForeground( Color.WHITE);
				
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
