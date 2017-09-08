package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Business.UtenteBusiness;
import ClassiDao.*;
import VisteUtenteGenerico.FrameLogin;
import view_tesserato.FrameTesserato;

import visteIstruttore.PannelloIstruttore;
import visteadmin.FrameElencoUtenti;
import visteadmin.PannelloResponsabile;




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
			if(GetInfoDB.getModUt(username)==1)
			{
				JOptionPane.showMessageDialog(null, "Si prega di attendere l'accettazione delle modifiche da parte del responsabile","",JOptionPane.WARNING_MESSAGE);
			}
			else if (GetInfoDB.getBlcUt(username)==1)
			{
				
				JOptionPane.showMessageDialog(null, "Utente bloccato:si prega di chiedere informazioni al responsabile","",JOptionPane.WARNING_MESSAGE);
				
			}
			else if (GetInfoDB.getAttUt(username)==0)
			{
				
				JOptionPane.showMessageDialog(null, "Utente ancora non attivo:si prega di chiedere informazioni al responsabile","",JOptionPane.WARNING_MESSAGE);
				
			}
			else {
		/*	if(Listen.imp!=null){
				
				Listen.imp.frame.setVisible(false);
				Listen.imp.frame.dispose();
				Listen.imp=null;
				}*/
			if(tipoUtente.equals("T"))
			{
				JOptionPane.showMessageDialog(null, "Accesso come tesserato "+username +".Benvenuto!");
				GetInfoDB.SettaConnesso(username);
				FrameLogin.frame.setVisible(false);
				new FrameTesserato();
				FrameLogin.frame.dispose();
				
				
			}
			if(tipoUtente.equals("I"))
			{
				
				JOptionPane.showMessageDialog(null, "Accesso come istruttore "+username+".Benvenuto !");
				GetInfoDB.SettaConnesso(username);
				FrameLogin.frame.setVisible(false);
				new PannelloIstruttore();
				FrameLogin.frame.dispose();
				
			}
			if(tipoUtente.equals("R"))
			{
				JOptionPane.showMessageDialog(null, "Accesso come responsabile "+username+".Benvenuto!");
				GetInfoDB.SettaConnesso(username);
				FrameLogin.frame.setVisible(false);
				new PannelloResponsabile();
				FrameLogin.frame.dispose();

				
			}
		
			
			//GetInfoDB.setUserStatus(true);
		
		}
		}
		else{
			JOptionPane.showMessageDialog(null, "L'utente \""+username+"\"  non esiste","",JOptionPane.WARNING_MESSAGE);
		}

	}
}
