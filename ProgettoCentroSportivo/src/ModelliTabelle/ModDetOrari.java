package ModelliTabelle;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Model.DettagliOrari;

public class ModDetOrari extends AbstractTableModel {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<DettagliOrari> dati;
		
		public ArrayList<DettagliOrari> getDati() {
			return dati;
		}

		public ModDetOrari (ArrayList<DettagliOrari> dati) {
			super();
			this.dati = dati;
		}

		
		public int getColumnCount() {
			return 5;
		}
		 
		
		private String[] tableHeaders = {"Livello","Giorno settimanale","Fascia oraria","Spazio","Posti disponibili per turno"};
		public String getColumnName(int columnIndex){
			return tableHeaders[columnIndex];
		}
		
	    public int getRowCount() {
			if(dati!=null) return dati.size();
			else return 0;
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			
			//ArrayList<Utente>
			//data binding
			DettagliOrari d=dati.get(rowIndex);
			
			  if(columnIndex==0) return d.getLivello();
			  else if(columnIndex==1) return d.getGiornoSettimana();
			  else if(columnIndex==2) return d.getFasciaOraria();
			  else if(columnIndex==3) return d.getSpazio();
			  else if(columnIndex==4) return d.getPrenotazioniDisp();
			return null;
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Class getColumnClass(int column) {
		    if (column==4) return Integer.class;
			return String.class;
		}
		
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}
		

		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	        if(columnIndex==0) dati.get(rowIndex).setLivello(aValue.toString());
	        if(columnIndex==1) dati.get(rowIndex).setGiornoSettimana(aValue.toString());
	        if(columnIndex==2) dati.get(rowIndex).setFasciaOraria(aValue.toString());
	        if(columnIndex==3) dati.get(rowIndex).setSpazio(aValue.toString());
	        if(columnIndex==4) dati.get(rowIndex).setPrenotazioniDisp((int)aValue);
	       
	        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
	    }
		   
}
