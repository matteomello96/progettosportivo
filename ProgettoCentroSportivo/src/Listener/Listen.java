package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import VisteUtenteGenerico.FrameIniziale;
import VisteUtenteGenerico.FrameLogin;
import VisteUtenteGenerico.FrameRegistrazione;



public class Listen implements ActionListener {
	public FrameIniziale finestraLogin;
	public FrameRegistrazione finestrareg;
	
	public Listen(FrameIniziale frame)
	{
		finestraLogin=frame;
	}
	public Listen(FrameRegistrazione frame)
	{
		finestrareg=frame;
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
		
		
		
	}
}