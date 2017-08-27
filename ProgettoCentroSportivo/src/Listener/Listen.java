package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import VisteIstruttore.FrameInserisciAtt;
import VisteIstruttore.FrameInserisciEv;
import VisteIstruttore.FrameIstruttore;
import VisteIstruttore.FrameModificaAtt;
import VisteIstruttore.FrameModificaEv;
import VisteUtenteGenerico.FrameIniziale;
import VisteUtenteGenerico.FrameLogin;
import VisteUtenteGenerico.FrameRegistrazione;
import view_tesserato.Confermaordine;
import view_tesserato.FrameEventi;
import view_tesserato.FrameTesserato;
import view_tesserato.FrameTestimonianze;
import view_tesserato.FrameTurno;
import visteadmin.FrameGestione;
import visteadmin.FrameInserisciDiscDisp;
import visteadmin.FrameInserisciDisciplina;
import visteadmin.FrameInserisciIstrDisp;
import visteadmin.FrameInserisciLiv;
import visteadmin.FrameInserisciModPag;
import visteadmin.FrameModificaDiscDisp;
import visteadmin.FrameModificaDisciplina;
import visteadmin.FrameModificaLiv;
import visteadmin.FrameModificaModPag;
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
	public FrameModificaEv framemodificaev;
	public FrameModificaAtt framemodificaatt;
	public FrameGestione framegestione;
	public FrameModificaModPag framemodificamodpag;
	public FrameInserisciModPag frameinseriscimodpag;
	public FrameInserisciLiv frameinserisciliv;
	public FrameModificaLiv framemodificaliv;
	public FrameInserisciDiscDisp frameinseriscidiscdisp;
	public FrameModificaDiscDisp framemodificadiscdisp;
	public FrameInserisciIstrDisp frameinserisciistrdisp;
	public FrameInserisciDisciplina frameinseriscidisciplina;
	public FrameModificaDisciplina framemodificadisciplina;
	
	public Listen(FrameModificaLiv frame)
	{
		framemodificaliv=frame;
	}
	
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
	public Listen(FrameModificaEv frame) {
		 framemodificaev = frame;
	}
	public Listen(FrameModificaAtt frame) {
		framemodificaatt = frame;
	}
	public Listen(FrameGestione frame) {
		framegestione = frame;
	}
	public Listen(FrameModificaModPag frame) {
		framemodificamodpag = frame;
	}
	public Listen(FrameInserisciModPag frame) {
		frameinseriscimodpag= frame;
	}
	public Listen(FrameInserisciLiv frame) {
		frameinserisciliv = frame ;
	}
	public Listen(FrameInserisciDiscDisp frame) {
		frameinseriscidiscdisp =frame;
	}
	public Listen(FrameModificaDiscDisp frame) {
		framemodificadiscdisp =frame;
	}
	public Listen(FrameInserisciIstrDisp frame) {
		frameinserisciistrdisp = frame;
	}

	public Listen(FrameInserisciDisciplina frame) {
		frameinseriscidisciplina= frame;
	}

	public Listen(FrameModificaDisciplina frame) {
		framemodificadisciplina = frame;
	}

	public void actionPerformed(ActionEvent e)
	{
if ("Vai_home_da_mod_disc".equals(e.getActionCommand())){
			
			FrameModificaDiscDisp.frame.setVisible(false);
			FrameModificaDiscDisp.frame.dispose();
			new FrameGestione();
			FrameGestione.frame.setVisible(true);
		}
if ("Vai_home_da_ins_disc".equals(e.getActionCommand())){
			
			FrameInserisciDiscDisp.frame.setVisible(false);
			FrameInserisciDiscDisp.frame.dispose();
			new FrameGestione();
			FrameGestione.frame.setVisible(true);
		}	
if ("Vai_home_da_ins_istr".equals(e.getActionCommand())){
	
	FrameInserisciIstrDisp.frame.setVisible(false);
	FrameInserisciIstrDisp.frame.dispose();
	new FrameGestione();
	FrameGestione.frame.setVisible(true);
}	
	
		
		
if ("Vai_istr".equals(e.getActionCommand())){
			
			FrameModificaEv.frame.setVisible(false);
			FrameModificaEv.frame.dispose();
			new FrameIstruttore();
			FrameIstruttore.frame.setVisible(true);
		}
if ("Vai_istr1".equals(e.getActionCommand())){
	
	FrameModificaAtt.frame.setVisible(false);
	FrameModificaAtt.frame.dispose();
	new FrameIstruttore();
	FrameIstruttore.frame.setVisible(true);
}	
if ("Vai_ges".equals(e.getActionCommand())){
	
	FrameModificaModPag.frame.setVisible(false);
	FrameModificaModPag.frame.dispose();
	new FrameGestione();
	FrameGestione.frame.setVisible(true);
}
if ("Vai_ges_da_ins".equals(e.getActionCommand())){
	
	FrameInserisciModPag.frame.setVisible(false);
	FrameInserisciModPag.frame.dispose();
	new FrameGestione();
	FrameGestione.frame.setVisible(true);
}
if ("Vai_ges_da_ins_disc".equals(e.getActionCommand())){
	
	FrameInserisciDisciplina.frame.setVisible(false);
	FrameInserisciDisciplina.frame.dispose();
	new FrameGestione();
	FrameGestione.frame.setVisible(true);
}
if ("Vai_ges_da_mod_disc".equals(e.getActionCommand())){
	
	FrameModificaDisciplina.frame.setVisible(false);
	FrameModificaDisciplina.frame.dispose();
	new FrameGestione();
	FrameGestione.frame.setVisible(true);
}
if ("Vai_ges_da_ins_liv".equals(e.getActionCommand())){
	
	FrameInserisciLiv.frame.setVisible(false);
	FrameInserisciLiv.frame.dispose();
	new FrameGestione();
	FrameGestione.frame.setVisible(true);
}
if ("Vai_ges_da_mod_liv".equals(e.getActionCommand())){
	
	FrameModificaLiv.frame.setVisible(false);
	FrameModificaLiv.frame.dispose();
	new FrameGestione();
	FrameGestione.frame.setVisible(true);
}

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
        	  FrameLogin.frame.dispose();
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
          if ("iniistr2".equals(e.getActionCommand())){
    			
        	  FrameEventi.frame.setVisible(false);
        	  FrameEventi.frame.dispose();
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
