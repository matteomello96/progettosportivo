package VisteUtenteGenerico;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;

public class PPh extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textcf;
	private JTextField textcit;
	private JTextField textvia;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textnut;
	private JTextField textpass;
	private JTextField textmail;
	private JTextField txtNom;
	private JTextField txtCog;
	private JTextField textnp;
    private JScrollPane p;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PPh frame = new PPh();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PPh() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 511, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		pack();
		
		
		JScrollPane scroll = new JScrollPane(p);
		scroll.setEnabled(true);
		scroll.setVisible(true);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50,30,300,50);
		GridBagConstraints gbc_scroll = new GridBagConstraints();
		gbc_scroll.ipady = 4;
		gbc_scroll.anchor = GridBagConstraints.WEST;
		gbc_scroll.fill = GridBagConstraints.VERTICAL;
		gbc_scroll.gridheight = 19;
		gbc_scroll.insets = new Insets(0, 0, 0, 5);
		gbc_scroll.gridx = 0;
		gbc_scroll.gridy = 0;
		contentPane.add(scroll, gbc_scroll);
		
		
		
		JLabel lblNom = new JLabel("nom");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.anchor = GridBagConstraints.EAST;
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 1;
		gbc_lblNom.gridy = 2;
		contentPane.add(lblNom, gbc_lblNom);
		
		txtNom = new JTextField();
		GridBagConstraints gbc_txtNom = new GridBagConstraints();
		gbc_txtNom.gridwidth = 2;
		gbc_txtNom.insets = new Insets(0, 0, 5, 5);
		gbc_txtNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNom.gridx = 2;
		gbc_txtNom.gridy = 2;
		contentPane.add(txtNom, gbc_txtNom);
		txtNom.setColumns(10);
		
		JLabel lblCog = new JLabel("cog");
		GridBagConstraints gbc_lblCog = new GridBagConstraints();
		gbc_lblCog.anchor = GridBagConstraints.EAST;
		gbc_lblCog.insets = new Insets(0, 0, 5, 5);
		gbc_lblCog.gridx = 1;
		gbc_lblCog.gridy = 3;
		contentPane.add(lblCog, gbc_lblCog);
		
		txtCog = new JTextField();
		GridBagConstraints gbc_txtCog = new GridBagConstraints();
		gbc_txtCog.gridwidth = 2;
		gbc_txtCog.insets = new Insets(0, 0, 5, 5);
		gbc_txtCog.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCog.gridx = 2;
		gbc_txtCog.gridy = 3;
		contentPane.add(txtCog, gbc_txtCog);
		txtCog.setColumns(10);
		
		
		
		
		
		JLabel lblCodf = new JLabel("codf");
		GridBagConstraints gbc_lblCodf = new GridBagConstraints();
		gbc_lblCodf.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodf.anchor = GridBagConstraints.EAST;
		gbc_lblCodf.gridx = 1;
		gbc_lblCodf.gridy = 4;
		contentPane.add(lblCodf, gbc_lblCodf);
		
		textcf = new JTextField();
		GridBagConstraints gbc_textcf = new GridBagConstraints();
		gbc_textcf.gridwidth = 2;
		gbc_textcf.insets = new Insets(0, 0, 5, 5);
		gbc_textcf.fill = GridBagConstraints.HORIZONTAL;
		gbc_textcf.gridx = 2;
		gbc_textcf.gridy = 4;
		contentPane.add(textcf, gbc_textcf);
		textcf.setColumns(10);
		
		JLabel lblCitt = new JLabel("citt");
		GridBagConstraints gbc_lblCitt = new GridBagConstraints();
		gbc_lblCitt.insets = new Insets(0, 0, 5, 5);
		gbc_lblCitt.anchor = GridBagConstraints.EAST;
		gbc_lblCitt.gridx = 1;
		gbc_lblCitt.gridy = 5;
		contentPane.add(lblCitt, gbc_lblCitt);
		
		textcit = new JTextField();
		GridBagConstraints gbc_textcit = new GridBagConstraints();
		gbc_textcit.gridwidth = 2;
		gbc_textcit.insets = new Insets(0, 0, 5, 5);
		gbc_textcit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textcit.gridx = 2;
		gbc_textcit.gridy = 5;
		contentPane.add(textcit, gbc_textcit);
		textcit.setColumns(10);
		
		JLabel lblVia = new JLabel("via");
		GridBagConstraints gbc_lblVia = new GridBagConstraints();
		gbc_lblVia.insets = new Insets(0, 0, 5, 5);
		gbc_lblVia.anchor = GridBagConstraints.EAST;
		gbc_lblVia.gridx = 1;
		gbc_lblVia.gridy = 6;
		contentPane.add(lblVia, gbc_lblVia);
		
		textvia = new JTextField();
		GridBagConstraints gbc_textvia = new GridBagConstraints();
		gbc_textvia.gridwidth = 2;
		gbc_textvia.insets = new Insets(0, 0, 5, 5);
		gbc_textvia.fill = GridBagConstraints.HORIZONTAL;
		gbc_textvia.gridx = 2;
		gbc_textvia.gridy = 6;
		contentPane.add(textvia, gbc_textvia);
		textvia.setColumns(10);
		
		JLabel lblNciv = new JLabel("nciv");
		GridBagConstraints gbc_lblNciv = new GridBagConstraints();
		gbc_lblNciv.insets = new Insets(0, 0, 5, 5);
		gbc_lblNciv.anchor = GridBagConstraints.EAST;
		gbc_lblNciv.gridx = 1;
		gbc_lblNciv.gridy = 7;
		contentPane.add(lblNciv, gbc_lblNciv);
		
		textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.gridwidth = 2;
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 2;
		gbc_textField_6.gridy = 7;
		contentPane.add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		JLabel lblDatiAcc = new JLabel("dati acc");
		GridBagConstraints gbc_lblDatiAcc = new GridBagConstraints();
		gbc_lblDatiAcc.gridwidth = 2;
		gbc_lblDatiAcc.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatiAcc.gridx = 2;
		gbc_lblDatiAcc.gridy = 8;
		contentPane.add(lblDatiAcc, gbc_lblDatiAcc);
		
		JLabel lblNewLabel_2 = new JLabel("indm");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 9;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textmail = new JTextField();
		GridBagConstraints gbc_textmail = new GridBagConstraints();
		gbc_textmail.gridwidth = 2;
		gbc_textmail.insets = new Insets(0, 0, 5, 5);
		gbc_textmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textmail.gridx = 2;
		gbc_textmail.gridy = 9;
		contentPane.add(textmail, gbc_textmail);
		textmail.setColumns(10);
		
		JLabel lblNut = new JLabel("nut");
		GridBagConstraints gbc_lblNut = new GridBagConstraints();
		gbc_lblNut.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNut.insets = new Insets(0, 0, 5, 5);
		gbc_lblNut.gridx = 1;
		gbc_lblNut.gridy = 10;
		contentPane.add(lblNut, gbc_lblNut);
		
		textnut = new JTextField();
		GridBagConstraints gbc_textnut = new GridBagConstraints();
		gbc_textnut.gridwidth = 2;
		gbc_textnut.insets = new Insets(0, 0, 5, 5);
		gbc_textnut.fill = GridBagConstraints.HORIZONTAL;
		gbc_textnut.gridx = 2;
		gbc_textnut.gridy = 10;
		contentPane.add(textnut, gbc_textnut);
		textnut.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("inus");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 11;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblPass = new JLabel("pass");
		GridBagConstraints gbc_lblPass = new GridBagConstraints();
		gbc_lblPass.insets = new Insets(0, 0, 5, 5);
		gbc_lblPass.anchor = GridBagConstraints.EAST;
		gbc_lblPass.gridx = 1;
		gbc_lblPass.gridy = 12;
		contentPane.add(lblPass, gbc_lblPass);
		
		textpass = new JTextField();
		GridBagConstraints gbc_textpass = new GridBagConstraints();
		gbc_textpass.gridwidth = 2;
		gbc_textpass.insets = new Insets(0, 0, 5, 5);
		gbc_textpass.fill = GridBagConstraints.HORIZONTAL;
		gbc_textpass.gridx = 2;
		gbc_textpass.gridy = 12;
		contentPane.add(textpass, gbc_textpass);
		textpass.setColumns(10);
		
		JLabel lblPpppp = new JLabel("nuovapass");
		GridBagConstraints gbc_lblPpppp = new GridBagConstraints();
		gbc_lblPpppp.anchor = GridBagConstraints.EAST;
		gbc_lblPpppp.insets = new Insets(0, 0, 5, 5);
		gbc_lblPpppp.gridx = 1;
		gbc_lblPpppp.gridy = 13;
		contentPane.add(lblPpppp, gbc_lblPpppp);
		
		textnp = new JTextField();
		GridBagConstraints gbc_textnp = new GridBagConstraints();
		gbc_textnp.gridwidth = 2;
		gbc_textnp.insets = new Insets(0, 0, 5, 5);
		gbc_textnp.fill = GridBagConstraints.HORIZONTAL;
		gbc_textnp.gridx = 2;
		gbc_textnp.gridy = 13;
		contentPane.add(textnp, gbc_textnp);
		textnp.setColumns(10);
		
		JLabel lblOooooo = new JLabel("tipout");
		GridBagConstraints gbc_lblOooooo = new GridBagConstraints();
		gbc_lblOooooo.insets = new Insets(0, 0, 5, 5);
		gbc_lblOooooo.anchor = GridBagConstraints.EAST;
		gbc_lblOooooo.gridx = 1;
		gbc_lblOooooo.gridy = 14;
		contentPane.add(lblOooooo, gbc_lblOooooo);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 14;
		contentPane.add(comboBox, gbc_comboBox);
		
		JButton btnRegi = new JButton("regi");
		GridBagConstraints gbc_btnRegi = new GridBagConstraints();
		gbc_btnRegi.gridwidth = 2;
		gbc_btnRegi.insets = new Insets(0, 0, 5, 5);
		gbc_btnRegi.gridx = 2;
		gbc_btnRegi.gridy = 16;
		contentPane.add(btnRegi, gbc_btnRegi);
	}

}
