package Model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModDetTest extends AbstractTableModel {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<DettagliTestimonianze> dati;
		
		public ArrayList<DettagliTestimonianze> getDati() {
			return dati;
		}

		public ModDetTest (ArrayList<DettagliTestimonianze> dati) {
			super();
			this.dati = dati;
		}

		
		public int getColumnCount() {
			return 6;
		}
		
		
		private String[] tableHeaders = {"Livello","Commento","Data Azione","Username","Nome utente","Cognome utente"};
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
			DettagliTestimonianze d=dati.get(rowIndex);
			
			  if(columnIndex==0) return d.getLivello();
			  else if(columnIndex==1) return d.getCommento();
			  else if(columnIndex==2) return d.getDataAzione();
			  else if(columnIndex==3) return d.getUsername();
			  else if(columnIndex==4) return d.getNomeUtente();
			  else if(columnIndex==5) return d.getCognomeUtente();
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
	        if(columnIndex==0) dati.get(rowIndex).setLivello(aValue.toString());
	        if(columnIndex==1) dati.get(rowIndex).setCommento(aValue.toString());
	        if(columnIndex==2) dati.get(rowIndex).setDataAzione(aValue.toString());
	        if(columnIndex==3) dati.get(rowIndex).setUsername(aValue.toString());
	        if(columnIndex==4) dati.get(rowIndex).setNomeUtente(aValue.toString());
	        if(columnIndex==5) dati.get(rowIndex).setCognomeUtente(aValue.toString());
	        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
	    }
		   
}

