package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Business.UtenteBusiness;
import ClassiDao.*;
import VisteIstruttore.FrameIstruttore;
import VisteUtenteGenerico.FrameLogin;
import view_tesserato.FrameTesserato;
import visteadmin.FrameResponsabile;




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
				JOptionPane.showMessageDialog(null, "Accesso come tesserato "+username +".Benvenuto!");
				FrameLogin.frame.setVisible(false);
				new FrameTesserato();
				FrameLogin.frame.dispose();
				
				
			}
			if(tipoUtente.equals("I"))
			{
				
				JOptionPane.showMessageDialog(null, "Accesso come istruttore "+username+".Benvenuto !");
				FrameLogin.frame.setVisible(false);
				new FrameIstruttore();
				FrameLogin.frame.dispose();
				
			}
			if(tipoUtente.equals("R"))
			{
				JOptionPane.showMessageDialog(null, "Accesso come responsabile "+username+".Benvenuto!");
				
				FrameLogin.frame.setVisible(false);
				new FrameResponsabile();
				FrameLogin.frame.dispose();

				
			}
		
			
			//GetInfoDB.setUserStatus(true);
		
		}

		else{
			JOptionPane.showMessageDialog(null, "L'utente \""+username+"\" Utente ancora non acettato o credenziali errate","",JOptionPane.WARNING_MESSAGE);
		}

	}
}
