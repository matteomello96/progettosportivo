package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ClassiDao.GetInfoDB;
import Model.Utente;
import VisteUtenteGenerico.DetDisciplina;
import VisteUtenteGenerico.FrameIniziale;
import VisteUtenteGenerico.FrameLogin;
import VisteUtenteGenerico.FrameModificaDati;
import VisteUtenteGenerico.FrameRegistrazione;
import view_tesserato.Confermaordine;
import view_tesserato.FrameEventi;
import view_tesserato.FrameTesserato;
import view_tesserato.FrameTestimonianze;
import view_tesserato.FrameTurno;
import visteIstruttore.DetAtt;
import visteIstruttore.DetEv;
import visteIstruttore.DetPartAtt;
import visteIstruttore.DetPartEv;
import visteIstruttore.FrameAttIstr;
import visteIstruttore.FrameEventiIstr;
import visteIstruttore.FrameInserisciAtt;
import visteIstruttore.FrameInserisciEv;

import visteIstruttore.FrameModificaAtt;
import visteIstruttore.FrameModificaEv;
import visteIstruttore.PannelloIstruttore;
import visteadmin.FrameGestione;
import visteadmin.FrameInserisciCal;
import visteadmin.FrameInserisciDiscDisp;
import visteadmin.FrameInserisciDisciplina;
import visteadmin.FrameInserisciIstrDisp;
import visteadmin.FrameInserisciLiv;
import visteadmin.FrameInserisciModPag;
import visteadmin.FrameModificaCal;
import visteadmin.FrameModificaDiscDisp;
import visteadmin.FrameModificaDisciplina;
import visteadmin.FrameModificaLiv;
import visteadmin.FrameModificaModPag;
import visteadmin.FrameOrdini;
import visteadmin.FrameOrdini2;
import visteadmin.PannelloResponsabile;
import visteadmin.framedettagli;
import visteadmin.FrameElencoUtenti;



public class Listen implements ActionListener {
	public FrameIniziale finestraLogin;
	public FrameRegistrazione finestrareg;
	public FrameLogin framelogin;
	public FrameTesserato frametesserato;
	public FrameElencoUtenti frameresponsabile;
	public FrameTurno frameturno;
	public FrameTestimonianze frametestimonianze;
	
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
	public DetDisciplina framedetdisc;
	public FrameEventiIstr frameeventiistr;
	public FrameAttIstr frameattistr;
	public DetAtt framedettatt;
	public DetEv framedetev;
	public DetPartAtt framedetpartatt;
	public DetPartEv framedetpartev;
	public PannelloIstruttore pannelloistruttore;
	public FrameModificaDati framemodificadati;
	public PannelloResponsabile pannelloresponsabile;
	public FrameInserisciCal frameinseriscical;
	public FrameModificaCal framemodificacal;
	public FrameOrdini2 frameordini2;
	public framedettagli framedet;
	
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
	public Listen(FrameElencoUtenti frame)
	{
	  frameresponsabile=frame;
	}
	
	
	
	
	public Listen(FrameEventiIstr frame) {
		frameeventiistr= frame;
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

	public Listen(DetDisciplina frame) {
		framedetdisc = frame;
	}

	public Listen(FrameEventi frame) {
		frameeventi=frame;
	}

	

	

	

	public Listen(FrameAttIstr frame) {
		frameattistr=frame;
	}

	

	public Listen(DetAtt frame) {
		framedettatt = frame;
	}

	public Listen(DetEv frame) {
		framedetev= frame;
	}

	public Listen(DetPartAtt frame) {
		framedetpartatt=frame;
	}
	public Listen(DetPartEv frame) {
		framedetpartev=frame;
	}


	

	public Listen(PannelloIstruttore frame) {
		pannelloistruttore= frame;
	}

	public Listen(FrameModificaDati frame) {
		framemodificadati= frame;
	}

	public Listen(PannelloResponsabile frame) {
		pannelloresponsabile= frame;
	}

	public Listen(FrameInserisciCal frame) {
		frameinseriscical=frame;
	}

	public Listen(FrameModificaCal frame) {
		framemodificacal=frame;
	}

	public Listen(FrameOrdini2 frame) {
		frameordini2=frame;
	}

	public Listen(framedettagli frame) {
		framedet=frame;
	}

	public void actionPerformed(ActionEvent e)
	{
if ("Vai_home_da_mod_disc".equals(e.getActionCommand())){
			
			FrameModificaDiscDisp.frame.setVisible(false);
			FrameModificaDiscDisp.frame.dispose();
			new FrameGestione();
			FrameGestione.frame.setVisible(true);
		}
if ("Vai_att".equals(e.getActionCommand())){
	
	DetAtt.frame.setVisible(false);
	DetAtt.frame.dispose();
	new FrameAttIstr();
	FrameAttIstr.frame.setVisible(true);
}
if ("Vai_att_det".equals(e.getActionCommand())){
	
	DetPartAtt.frame.setVisible(false);
	DetPartAtt.frame.dispose();
	new DetAtt(null, null);
	DetAtt.frame.setVisible(true);
}
if ("Vai_ev_det".equals(e.getActionCommand())){
	
	DetPartEv.frame.setVisible(false);
	DetPartEv.frame.dispose();
	new DetEv(null);
	DetEv.frame.setVisible(true);
}

if ("Vai_ev".equals(e.getActionCommand())){
	
	DetEv.frame.setVisible(false);
	DetEv.frame.dispose();
	new FrameEventiIstr();
	FrameEventiIstr.frame.setVisible(true);
}
if ("Vai_home_da_det".equals(e.getActionCommand())){
	
	DetDisciplina.frame.setVisible(false);
	DetDisciplina.frame.dispose();
	FrameIniziale.frame.setVisible(true);
}

if ("Vai_pan".equals(e.getActionCommand())){
	
	FrameEventiIstr.frame.setVisible(false);
	FrameEventiIstr.frame.dispose();
	PannelloIstruttore.frame.setVisible(true);
}
if ("ord".equals(e.getActionCommand())){
	
	framedettagli.frame.setVisible(false);
	framedettagli.frame.dispose();
	FrameOrdini2.frame.setVisible(true);
}







if ("Vai_pan_da_att".equals(e.getActionCommand())){
	
	FrameAttIstr.frame.setVisible(false);
	FrameAttIstr.frame.dispose();
	PannelloIstruttore.frame.setVisible(true);
}

if ("Vai_home_da_ord".equals(e.getActionCommand())){
	
	FrameOrdini2.frame.setVisible(false);
	FrameOrdini2.frame.dispose();
	new PannelloResponsabile();
	PannelloResponsabile.frame.setVisible(true);
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
if ("Vai_home_p".equals(e.getActionCommand())){
	
	FrameModificaDati.frame.setVisible(false);
	FrameModificaDati.frame.dispose();
	new PannelloIstruttore();
	PannelloIstruttore.frame.setVisible(true);
}	
		
		
if ("Vai_istr".equals(e.getActionCommand())){
			
			FrameModificaEv.frame.setVisible(false);
			FrameModificaEv.frame.dispose();
			new FrameEventiIstr();
			FrameEventiIstr.frame.setVisible(true);
		}
if ("Vai_istr1".equals(e.getActionCommand())){
	
	FrameModificaAtt.frame.setVisible(false);
	FrameModificaAtt.frame.dispose();
	new FrameAttIstr();
	FrameAttIstr.frame.setVisible(true);
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
if ("Vai_ges_da_ins_cal".equals(e.getActionCommand())){
	
	FrameInserisciCal.frame.setVisible(false);
	FrameInserisciCal.frame.dispose();
	new FrameGestione();
	FrameGestione.frame.setVisible(true);
}
if ("Vai_ges_da_mod_cal".equals(e.getActionCommand())){
	
	FrameModificaCal.frame.setVisible(false);
	FrameModificaCal.frame.dispose();
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
if ("pandages".equals(e.getActionCommand())){
	
	FrameGestione.frame.setVisible(false);
	FrameGestione.frame.dispose();
	new PannelloResponsabile();
	PannelloResponsabile.frame.setVisible(true);
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
			new FrameEventiIstr();
			FrameEventiIstr.frame.setVisible(true);
		}
          if ("Vai_home4".equals(e.getActionCommand())){
    			
        	  FrameInserisciAtt.frame.setVisible(false);
        	  FrameInserisciAtt.frame.dispose();
			new FrameAttIstr();
			FrameAttIstr.frame.setVisible(true);
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
          if ("out_da_tes".equals(e.getActionCommand())){
  			
        	  FrameTesserato.frame.setVisible(false);
        	  FrameTesserato.frame.dispose();
        	  GetInfoDB.SettaLogout(Utente.getUsername());
			new FrameIniziale();
			FrameIniziale.frame.setVisible(true);
		}
          if ("conf".equals(e.getActionCommand())){
  			
			new Confermaordine();
			Confermaordine.frame.setVisible(true);
		}
          
          if ("iniistr".equals(e.getActionCommand())){
  			
        	  PannelloIstruttore.frame.setVisible(false);
        	  PannelloIstruttore.frame.dispose();
        	  GetInfoDB.SettaLogout(Utente.getUsername());
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
    			
        	  FrameElencoUtenti.frame.setVisible(false);
        	  FrameElencoUtenti.frame.dispose();
			new PannelloResponsabile();
			PannelloResponsabile.frame.setVisible(true);
		}
          
          
          if ("logoutresp".equals(e.getActionCommand())){
  			
        	  PannelloResponsabile.frame.setVisible(false);
        	  PannelloResponsabile.frame.dispose();
        	  GetInfoDB.SettaLogout(Utente.getUsername());
			new FrameIniziale();
			FrameIniziale.frame.setVisible(true);
		}
		
     
          
          
         
          
		
	}
}
