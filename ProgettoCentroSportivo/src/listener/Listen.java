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
import view_tesserato.FrameIscrDisc;
import view_tesserato.FrameIscrEventiTest;
import view_tesserato.FrameAttivitaTes;
import view_tesserato.FrameDettagliConfTess;
import view_tesserato.FrameDettagliDaAccTess;
import view_tesserato.FrameDettagliModTess2;
import view_tesserato.FrameInsTest;
import view_tesserato.FrameTurno;
import view_tesserato.FrameVisTest;
import view_tesserato.PannelloTesserato;
import view_tesserato.sendeventframe;
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
import visteadmin.PannelloResponsabile;
import view_tesserato.FrameDettagliDaAccTess;
import visteadmin.FrameDettagliAcc;
import visteadmin.FrameDettagliDaAccResp;
import visteadmin.FrameDettagliMod;
import visteadmin.FrameElencoUtenti;
import visteadmin.FrameEventiResp;



public class Listen implements ActionListener {
	public FrameIniziale finestraLogin;
	public FrameRegistrazione finestrareg;
	public FrameLogin framelogin;
	public FrameAttivitaTes frametesserato;
	public FrameElencoUtenti frameresponsabile;
	public FrameTurno frameturno;
	public FrameInsTest frametestimonianze;
	
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
	public FrameOrdini frameordini2;
	public FrameDettagliDaAccResp framedet;
	public FrameDettagliMod framedetmod;
	public FrameDettagliAcc frameda;
	public FrameEventiResp frameeventiresp;
	public PannelloTesserato pannellotesserato;
	public FrameIscrDisc frameiscrdisc;
	public FrameDettagliDaAccTess framedettaglidaacc;
	public FrameDettagliConfTess framedettagliconf;
	public FrameDettagliModTess2 framedettaglimod;
	public FrameIscrEventiTest frameevtest;
	public FrameVisTest framevistest;
	public sendeventframe send;
	
	
	
	
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
	public Listen(FrameAttivitaTes frame)
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

	public Listen(FrameOrdini frame) {
		frameordini2=frame;
	}

	public Listen(FrameDettagliDaAccResp frame) {
		framedet=frame;
	}

	public Listen(FrameDettagliMod frame) {
		framedetmod=frame;
	}

	public Listen(FrameDettagliAcc frame) {
		frameda=frame;
	}

	

	public Listen(FrameEventiResp frame) {
		frameeventiresp=frame;
	}

	public Listen(PannelloTesserato frame) {
		pannellotesserato=frame;
	}

	public Listen(FrameIscrDisc frame) {
		frameiscrdisc=frame;
	}

	public Listen(FrameDettagliDaAccTess frame) {
		framedettaglidaacc=frame;
	}

	public Listen(FrameDettagliConfTess frame) {
		framedettagliconf=frame;
	}

	public Listen(FrameDettagliModTess2 frame) {
		framedettaglimod= frame;
	}

	public Listen(FrameIscrEventiTest frame) {
		frameevtest=frame;
	}

	public Listen(FrameVisTest frame) {
		framevistest=frame;
	}

	public Listen(sendeventframe frame) {
		send = frame;
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
if ("send".equals(e.getActionCommand())){
	
	sendeventframe.frame.setVisible(false);
	sendeventframe.frame.dispose();
	new FrameEventi();
	FrameEventi.frame.setVisible(true);
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
if ("iniresp2".equals(e.getActionCommand())){
	
	FrameEventiResp.frame.setVisible(false);
	FrameEventiResp.frame.dispose();
	new PannelloResponsabile();
	PannelloResponsabile.frame.setVisible(true);
}
if ("Vai_pan".equals(e.getActionCommand())){
	
	FrameEventiIstr.frame.setVisible(false);
	FrameEventiIstr.frame.dispose();
	PannelloIstruttore.frame.setVisible(true);
}
if ("ord".equals(e.getActionCommand())){
	
	FrameDettagliDaAccResp.frame.setVisible(false);
	FrameDettagliDaAccResp.frame.dispose();
	FrameOrdini.frame.setVisible(true);
}

if ("orddm".equals(e.getActionCommand())){
	
	FrameDettagliMod.frame.setVisible(false);
	FrameDettagliMod.frame.dispose();
	FrameOrdini.frame.setVisible(true);
}

if ("ordacc".equals(e.getActionCommand())){
	
	FrameDettagliAcc.frame.setVisible(false);
	FrameDettagliAcc.frame.dispose();
	FrameOrdini.frame.setVisible(true);
}

if ("elord".equals(e.getActionCommand())){
	
	FrameDettagliDaAccTess.frame.setVisible(false);
	FrameDettagliDaAccTess.frame.dispose();
	FrameIscrDisc.frame.setVisible(true);
}
if ("elord2".equals(e.getActionCommand())){
	
	FrameDettagliConfTess.frame.setVisible(false);
	FrameDettagliConfTess.frame.dispose();
	FrameIscrDisc.frame.setVisible(true);
}
if ("elord3".equals(e.getActionCommand())){
	
	FrameDettagliModTess2.frame.setVisible(false);
	FrameDettagliModTess2.frame.dispose();
	FrameIscrDisc.frame.setVisible(true);
}


if ("Vai_pan_da_att".equals(e.getActionCommand())){
	
	FrameAttIstr.frame.setVisible(false);
	FrameAttIstr.frame.dispose();
	PannelloIstruttore.frame.setVisible(true);
}

if ("Vai_home_da_ord".equals(e.getActionCommand())){
	
	FrameOrdini.frame.setVisible(false);
	FrameOrdini.frame.dispose();
	new PannelloResponsabile();
	PannelloResponsabile.frame.setVisible(true);
}	
if ("Vai_home_da_ord2".equals(e.getActionCommand())){
	
	FrameIscrDisc.frame.setVisible(false);
	FrameIscrDisc.frame.dispose();
	new PannelloTesserato();
	PannelloTesserato.frame.setVisible(true);
}	
if ("inites2".equals(e.getActionCommand())){
	
	FrameIscrEventiTest.frame.setVisible(false);
	FrameIscrEventiTest.frame.dispose();
	new PannelloTesserato();
	PannelloTesserato.frame.setVisible(true);
}	

if ("vaitest".equals(e.getActionCommand())){
	
	FrameVisTest.frame.setVisible(false);
	FrameVisTest.frame.dispose();
	new PannelloTesserato();
	PannelloTesserato.frame.setVisible(true);
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
	if (GetInfoDB.getTipo(""+Utente.getUsername()+"").equals("I"))
	{
		new PannelloIstruttore();
	PannelloIstruttore.frame.setVisible(true);
	PannelloIstruttore.frame.setEnabled(true);
	}
	if (GetInfoDB.getTipo(""+Utente.getUsername()+"").equals("R"))
	{
		new PannelloResponsabile();
	PannelloResponsabile.frame.setVisible(true);
	PannelloResponsabile.frame.setEnabled(true);
	}
	if (GetInfoDB.getTipo(""+Utente.getUsername()+"").equals("T"))
	{
		new PannelloTesserato();
	PannelloTesserato.frame.setVisible(true);
	PannelloTesserato.frame.setEnabled(true);
	}
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
          if ("pantes".equals(e.getActionCommand())){
  			
        	  FrameAttivitaTes.frame.setVisible(false);
        	  FrameAttivitaTes.frame.dispose();
        	  
			new PannelloTesserato();
			PannelloTesserato.frame.setVisible(true);
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
          if ("pantes2".equals(e.getActionCommand())){
    			
        	  FrameEventi.frame.setVisible(false);
        	  FrameEventi.frame.dispose();
			new PannelloTesserato();
			PannelloTesserato.frame.setVisible(true);
		
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
		
          if ("logouttes".equals(e.getActionCommand())){
    			
        	  PannelloTesserato.frame.setVisible(false);
        	  PannelloTesserato.frame.dispose();
        	  GetInfoDB.SettaLogout(Utente.getUsername());
			new FrameIniziale();
			FrameIniziale.frame.setVisible(true);
		}
		
          
          
         
          
		
	}
}
