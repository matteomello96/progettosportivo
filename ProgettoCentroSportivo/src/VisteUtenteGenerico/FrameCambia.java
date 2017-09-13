package VisteUtenteGenerico;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ClassiDao.PasswordChanged;
import view_tesserato.FrameAttivitaTes;


public class FrameCambia {
	public static JDialog frame;
	private JTextField pass0;
	private JTextField pass1;
	private JTextField reinsert;
	
	
	
	
	
	
	public FrameCambia(){
		frame = new JDialog();
		frame.setTitle("Cambia password utente");
		frame.setBounds(100, 100, 368, 299);
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		
		
		pass0 = new JTextField();
		pass0.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pass0.setBounds(10, 47, 235, 25);
		frame.getContentPane().add(pass0);
		JLabel lblVecchiaPassword = new JLabel("Vecchia password:");
		lblVecchiaPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblVecchiaPassword.setBounds(10, 25, 142, 14);
		frame.getContentPane().add(lblVecchiaPassword);
		
		pass1 = new JTextField();
		pass1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pass1.setBounds(10, 105, 235, 25);
		frame.getContentPane().add(pass1);
		
		
		JLabel lblNuovaPassword = new JLabel("Nuova password:");
		lblNuovaPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNuovaPassword.setBounds(10, 83, 142, 14);
		frame.getContentPane().add(lblNuovaPassword);
		
		reinsert = new JTextField();
		reinsert.setFont(new Font("Tahoma", Font.PLAIN, 11));
		reinsert.setBounds(10, 163, 235, 25);
		frame.getContentPane().add(reinsert);
		JButton ook = new JButton("OK");
		ook.setFont(new Font("Tahoma", Font.PLAIN, 11));
		ook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		if((pass1.getText()).equals(reinsert.getText()))
				PasswordChanged.changed(pass0.getText(), pass1.getText());
		else JOptionPane.showMessageDialog(FrameCambia.frame, "Il contenuto dei campi della nuova password non coincide, reinserire la nuova password"," ",JOptionPane.WARNING_MESSAGE);	
				
			}
		});
		ook.setBounds(263, 234, 89, 25);
		frame.getContentPane().add(ook);
		frame.getRootPane().setDefaultButton(ook); 
		
		JLabel lblReinserisciNuovaPassword = new JLabel("Reinserisci nuova password:");
		lblReinserisciNuovaPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblReinserisciNuovaPassword.setBounds(10, 141, 142, 14);
		frame.getContentPane().add(lblReinserisciNuovaPassword);
		//frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    //@Override
		    /*public void windowClosing(java.awt.event.WindowEvent windowEvent) 
		    {
		    	if(FrameAttivitaTes.frame!=null)
		    		FrameAttivitaTes.frame.setEnabled(true);
		    	//if(MagFrame.frame!=null)
		    		//MagFrame.frame.setEnabled(true);
		    	//if(CapFrame.frame!=null)
		    	//	CapFrame.frame.setEnabled(true);
		    	//if(AdminFrame.frame!=null)
		    	//	AdminFrame.frame.setEnabled(true);
		    }*/
		//});
	}
}
