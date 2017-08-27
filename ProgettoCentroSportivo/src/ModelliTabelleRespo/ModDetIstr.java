package ModelliTabelleRespo;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Model_Responsabile.DettagliIstruttore;

public class ModDetIstr extends AbstractTableModel{
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<DettagliIstruttore> dati;
		
		public ArrayList<DettagliIstruttore> getDati() {
			return dati;
		}

		public ModDetIstr (ArrayList<DettagliIstruttore> dati) {
			super();
			this.dati = dati;
		}

		
		public int getColumnCount() {
			return 2;
		}
		
		
		private String[] tableHeaders = {"Nome Istruttore","Cognome Istruttore"};
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
			DettagliIstruttore d=dati.get(rowIndex);
			
			  if(columnIndex==0) return d.getNomeIstruttore();
			  else if(columnIndex==1) return d.getCognomeIstruttore();
			return null;
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Class getColumnClass(int column) {
		    
			return String.class;
		}
		
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}
		

		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	        if(columnIndex==0) dati.get(rowIndex).setNomeIstruttore(aValue.toString());
	        if(columnIndex==1) dati.get(rowIndex).setCognomeIstruttore(aValue.toString());
	        
	        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
	    }
		   
}