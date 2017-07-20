package view_dipendente;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;









public class Confermaordine {
	public JButton btnConferma;
	public static Combocon ComboP;
	
	public static JDialog frame;
	public Confermaordine(){
		final DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		
		
		frame = new JDialog(FrameTesserato.frame,true);
		frame.setTitle("Conferma ordine");
		frame.setBounds(100, 100, 803, 364);
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		

		JLabel lblTotaleOrdineEur = new JLabel("TOTALE ORDINE:");
		lblTotaleOrdineEur.setToolTipText("");
		lblTotaleOrdineEur.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotaleOrdineEur.setBounds(26, 46, 145, 14);
		frame.getContentPane().add(lblTotaleOrdineEur);
		
		JLabel part = new JLabel("VALORE");
		part.setHorizontalAlignment(SwingConstants.TRAILING);
		part.setText(df.format(FrameTesserato.totale)+" EUR");
		part.setFont(new Font("Tahoma", Font.PLAIN, 14));
		part.setBounds(171, 46, 118, 14);
		frame.getContentPane().add(part);
		
		

		 ComboP = new Combocon();
		ComboP.setEnabled(true);
		ComboP.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(ComboP.getSelectedIndex()<=0)
					btnConferma.setEnabled(false);
				else btnConferma.setEnabled(true);
			}
		});
		
		
		ComboP.setBounds(30, 145, 301, 28);
		frame.getContentPane().add(ComboP);
		
		
		JButton btnTornaAlCarrello = new JButton("Torna al carrello");
		btnTornaAlCarrello.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnTornaAlCarrello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.setVisible(false);
				
				frame.dispose();
				FrameTesserato.frame.setEnabled(true);
				FrameTesserato.frame.setAlwaysOnTop(true);
				FrameTesserato.frame.setAlwaysOnTop(false);
			}
		});
		btnTornaAlCarrello.setBounds(21, 295, 138, 28);
		frame.getContentPane().add(btnTornaAlCarrello);
		
		btnConferma = new JButton("Conferma");
		btnConferma.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConferma.setEnabled(false);
		btnConferma.setBounds(668, 295, 115, 28);
		frame.getContentPane().add(btnConferma);
		
	}
}
