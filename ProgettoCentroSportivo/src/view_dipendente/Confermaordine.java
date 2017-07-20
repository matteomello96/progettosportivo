package view_dipendente;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;



public class Confermaordine {
	public static JDialog frame;
	public Confermaordine(){
		frame = new JDialog(FrameTesserato.frame,true);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("Conferma ordine");
		frame.setBounds(100, 100, 803, 364);
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		JLabel label = new JLabel("_________________________________________________");
		label.setEnabled(false);
		label.setBounds(20, 90, 294, 14);
		frame.getContentPane().add(label);
		JLabel lblNewLabel = new JLabel("Procedi con la conferma dell'ordine:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 11, 279, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPrezzoArticoli = new JLabel("PREZZO ARTICOLI:");
		lblPrezzoArticoli.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrezzoArticoli.setBounds(26, 46, 145, 14);
		frame.getContentPane().add(lblPrezzoArticoli);
		
		JLabel lblCostiSpedizione = new JLabel("COSTI SPEDIZIONE:");
		lblCostiSpedizione.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCostiSpedizione.setBounds(26, 76, 153, 14);
		frame.getContentPane().add(lblCostiSpedizione);
		
		JLabel lblTotaleOrdineEur = new JLabel("TOTALE ORDINE:");
		lblTotaleOrdineEur.setToolTipText("");
		lblTotaleOrdineEur.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotaleOrdineEur.setBounds(26, 110, 164, 14);
		frame.getContentPane().add(lblTotaleOrdineEur);
		
		
		
	}
}
