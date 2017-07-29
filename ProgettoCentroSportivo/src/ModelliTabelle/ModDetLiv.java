package ModelliTabelle;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Model.DettagliLivello;

public class ModDetLiv extends AbstractTableModel {
	
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
		 * 
		 */
		
	private ArrayList<DettagliLivello> dati;
		
		public ArrayList<DettagliLivello> getDati() {
			return dati;
		}
        
		public ModDetLiv (ArrayList<DettagliLivello> dati) {
			super();
			this.dati = dati;
		}
       private String[] tableHeaders = {"Nome Livello","Costo Mensile"};
		@Override
		public String getColumnName(int columnIndex){
			return tableHeaders[columnIndex];
		}
		
		@Override
		public int getColumnCount() {
			return 2;
		}
		
	
		
		@Override
	    public int getRowCount() {
			if(dati!=null) return dati.size();
			else return 0;
		}
		
		
		
        @Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			
			//ArrayList<Utente>
			//data binding
			DettagliLivello d=dati.get(rowIndex);
			
			  if(columnIndex==0) return d.getNomeLivello();
			  else if(columnIndex==1) return d.getCostoMensile();
			return null;
		}

	  @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
		public Class getColumnClass(int column) {
			if(column==1)  return Float.class;
			else return String.class;
		}
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}
		
   @Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	        if(columnIndex==0) dati.get(rowIndex).setNomeLivello(aValue.toString());
	        if(columnIndex==1) dati.get(rowIndex).setCostoMensile((float)aValue);
	        
	        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
	    }
		   
}