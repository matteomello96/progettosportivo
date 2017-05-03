package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Business.UtenteBusiness;
import ClassiDao.*;
import Viste.FrameLogin;




public class LoginListener implements ActionListener{
	private FrameLogin Login;
	
	
	public LoginListener(FrameLogin framelogin) {
		super();
		this.Login = framelogin;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String username = Login.CasellaNomeutente.getText();
		String password =Login.passwordField.getText();
		
		
		boolean utenteEsiste = UtenteBusiness.getInstance().verificaLogin(username, password);
		String tipoUtente = TipoUtente.getTipo(username,password);
		if(utenteEsiste){
		/*	if(Listen.imp!=null){
				
				Listen.imp.frame.setVisible(false);
				Listen.imp.frame.dispose();
				Listen.imp=null;
				}*/
			if(tipoUtente.equals("T"))
			{
				JOptionPane.showMessageDialog(null, "Accesso come tesserato!");
				FrameLogin.frame.setVisible(false);
				FrameLogin.frame.dispose();
				
				
			}
			if(tipoUtente.equals("I"))
			{
				
				JOptionPane.showMessageDialog(null, "Accesso come istruttore!");
				FrameLogin.frame.setVisible(false);
				
				FrameLogin.frame.dispose();
				//JOptionPane.showMessageDialog(null, "Accesso come capo progetto!");
			}
			if(tipoUtente.equals("R"))
			{
				JOptionPane.showMessageDialog(null, "Accesso come tesserato!");
				
				FrameLogin.frame.setVisible(false);
			
				FrameLogin.frame.dispose();

				//JOptionPane.showMessageDialog(null, "Accesso come magazziniere!");
			}
		
			
			//GetInfoDB.setUserStatus(true);
			
		}

		else{
			JOptionPane.showMessageDialog(null, "L'utente \""+username+"\" non esiste o password errata","",JOptionPane.WARNING_MESSAGE);
		}

	}
}