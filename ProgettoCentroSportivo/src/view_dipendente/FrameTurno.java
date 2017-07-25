package view_dipendente;


import javax.swing.JButton;
import javax.swing.JDialog;


import javax.swing.JLabel;


import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class FrameTurno {
	private JLabel lblNewLabel;
	public JButton btnNewButton;
	public static JDialog frame;
	public static Comboorario Comboorario;
	public static Combogiorno Combogiorno;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public FrameTurno() {
		final DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		
		frame = new JDialog(FrameTesserato.frame,true);
		frame.setTitle("Scegli orario e giorno");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frame.setResizable(true);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 97, 139, 69, 32, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		{
			lblNewLabel = new JLabel("                                                     Sei iscritto alle discipline");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(26, 46, 145, 14);

			frame.getContentPane().add(lblNewLabel);
		}
	
	
		{
		//	btnNewButton = new JButton("Conferma");
			//frame.getContentPane().add(btnNewButton);
		}
		

		 Comboorario = new Comboorario();
		 Comboorario.setEnabled(true);
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox.gridx = 5;
			gbc_comboBox.gridy = 2;
		// Comboorario.addItemListener(new ItemListener() {
			//public void itemStateChanged(ItemEvent e) {
			//	if(Comboorario.getSelectedIndex()<=0)
				//	btnConferma.setEnabled(false);
				//else btnConferma.setEnabled(true);
			//}
		//});
		
		
		
		frame.getContentPane().add(Comboorario,gbc_comboBox);
		
		 Combogiorno = new Combogiorno();
		 Combogiorno.setEnabled(true);
		 frame.getContentPane().add(Combogiorno);
	
	}

}
