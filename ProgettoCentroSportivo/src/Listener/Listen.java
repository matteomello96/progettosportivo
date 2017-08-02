package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import VisteIstruttore.FrameInserisciAtt;
import VisteIstruttore.FrameInserisciEv;
import VisteIstruttore.FrameIstruttore;
import VisteUtenteGenerico.FrameIniziale;
import VisteUtenteGenerico.FrameLogin;
import VisteUtenteGenerico.FrameRegistrazione;
import view_tesserato.Confermaordine;
import view_tesserato.FrameEventi;
import view_tesserato.FrameTesserato;
import view_tesserato.FrameTestimonianze;
import view_tesserato.FrameTurno;
import visteadmin.FrameOrdini;
import visteadmin.FrameResponsabile;



public class Listen implements ActionListener {
	public FrameIniziale finestraLogin;
	public FrameRegistrazione finestrareg;
	public FrameLogin framelogin;
	public FrameTesserato frametesserato;
	public FrameResponsabile frameresponsabile;
	public FrameTurno frameturno;
	public FrameTestimonianze frametestimonianze;
	public FrameIstruttore framevediev;
	public FrameEventi frameeventi;
	public FrameInserisciEv frameinserisciev;
	public FrameInserisciAtt frameinserisciatt;
	
	
	public Listen(FrameIniziale frame)
	{
		finestraLogin=frame;
	}
	public Listen(FrameRegistrazione frame)
	{
		finestrareg=frame;
	}
	public Listen(FrameLogin frame)
	{
	  framelogin=frame;
	}
	public Listen(FrameTesserato frame)
	{
	  frametesserato=frame;
	}
	public Listen(FrameResponsabile frame)
	{
	  frameresponsabile=frame;
	}
	
	public Listen(FrameIstruttore frame) {
		framevediev=frame;
	}
	
	
	public Listen(FrameEventi frame) {
		frameeventi= frame;
	}
	
	public Listen(FrameInserisciEv frame) {
		frameinserisciev = frame;
	}
	public Listen(FrameInserisciAtt frame) {
		frameinserisciatt = frame;
	}
	public void actionPerformed(ActionEvent e)
	{
		if ("Vai_reg".equals(e.getActionCommand())){
			
			FrameIniziale.frame.setVisible(false);
			FrameIniziale.frame.dispose();
			new FrameRegistrazione();
			FrameRegistrazione.frame.setVisible(true);
		}
          if ("Vai_home".equals(e.getActionCommand())){
			
        	  FrameRegistrazione.frame.setVisible(false);
        	  FrameRegistrazione.frame.dispose();
			new FrameIniziale();
			FrameIniziale.frame.setVisible(true);
		}
          if ("Vai_home3".equals(e.getActionCommand())){
  			
        	  FrameInserisciEv.frame.setVisible(false);
        	  FrameInserisciEv.frame.dispose();
			new FrameIniziale();
			FrameIniziale.frame.setVisible(true);
		}
          if ("Vai_home4".equals(e.getActionCommand())){
    			
        	  FrameInserisciAtt.frame.setVisible(false);
        	  FrameInserisciAtt.frame.dispose();
			new FrameIniziale();
			FrameIniziale.frame.setVisible(true);
		}
          if ("Vai_log".equals(e.getActionCommand())){
  			
        	  FrameIniziale.frame.setVisible(false);
        	  FrameIniziale.frame.dispose();
			new FrameLogin();
			FrameLogin.frame.setVisible(true);
		}
          if ("Vai_home1".equals(e.getActionCommand())){
  			
        	  FrameLogin.frame.setVisible(false);
        	  FrameLogin.frame.dispose();
			new FrameIniziale();
			FrameIniziale.frame.setVisible(true);
		}
          if ("ini".equals(e.getActionCommand())){
    			
        	  FrameLogin.frame.setVisible(false);
        	  FrameTesserato.frame.dispose();
			new FrameIniziale();
			FrameIniziale.frame.setVisible(true);
		}
          if ("conf".equals(e.getActionCommand())){
  			
			new Confermaordine();
			Confermaordine.frame.setVisible(true);
		}
          
          if ("iniistr".equals(e.getActionCommand())){
  			
        	  FrameIstruttore.frame.setVisible(false);
        	  FrameIstruttore.frame.dispose();
			new FrameIniziale();
			FrameIniziale.frame.setVisible(true);
		}
          
          
          
          
          
          
          if ("iniresp".equals(e.getActionCommand())){
  			
        	  FrameResponsabile.frame.setVisible(false);
        	  FrameResponsabile.frame.dispose();
			new FrameIniziale();
			FrameIniziale.frame.setVisible(true);
		}
		
     
          
          
         
          
		
	}
}
