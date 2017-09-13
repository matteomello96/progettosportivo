package ModelliTabelle_Tesserato;


import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Model_Tesserato.ElencoAttivita;
import Model_Tesserato.ElencoGiornoOra;

public class ModGiornoOra extends AbstractTableModel  {

	private ArrayList<ElencoGiornoOra> dati;
	
	public ArrayList<ElencoGiornoOra> getDati() {
		return dati;
	}

	public ModGiornoOra(ArrayList<ElencoGiornoOra> dati) {
		super();
		this.dati = dati;
	}
	
	private String[] tableHeaders = {"Giorno", "Fascia oraria"};
	@Override
	public String getColumnName(int columnIndex){
		return tableHeaders[columnIndex];
	}
	
	@Override
	public int getRowCount() {
		if(dati!=null) return dati.size();
		else return 0;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		//ArrayList<Utente>
		//data binding
		ElencoGiornoOra d=dati.get(rowIndex);
		
		  if(columnIndex==0) return d.getGiorno();
		else if(columnIndex==1) return d.getOra();
		
		  return null;
		  
	}


	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	

	@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==0) dati.get(rowIndex).setGiorno(aValue.toString());
        if(columnIndex==1) dati.get(rowIndex).setOra(aValue.toString());
        
      
        
		
       
        
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }


}
