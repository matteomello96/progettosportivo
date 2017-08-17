package ModelliTabelle_Tesserato;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


import Model_Tesserato.ElencoEventiTes;

public class controlloevento extends AbstractTableModel  {

	private ArrayList<ElencoEventiTes> dati;
	
	public ArrayList<ElencoEventiTes> getDati() {
		return dati;
	}

	public controlloevento(ArrayList<ElencoEventiTes> dati) {
		super();
		this.dati = dati;
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
		ElencoEventiTes d=dati.get(rowIndex);
		
		  if(columnIndex==0) return d.getCodiceevento();
		else if(columnIndex==1) return d.getTesserato();
		
		  
		  return null;
		  
	}


	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	

	@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==0) dati.get(rowIndex).setCodiceevento((int)aValue);
        if(columnIndex==1) dati.get(rowIndex).setTesserato((int)aValue);
     
        
		
       
        
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }


}