package Model;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class creaLook {

	public static void setLooknimbus()
	{
		try {
            UIManager.put("nimbusBase", new Color(153,203,255));
            UIManager.put("nimbusBlueGrey", new Color(240,220,130));
            UIManager.put("control", new Color(153,203,255));
			UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch(Exception e)
		{

		}
	}



	public static void setLooksys()
	{


		try {
			// 
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			JFrame.setDefaultLookAndFeelDecorated(true);
		} 
		catch (Exception e) {

		}
	}
}
