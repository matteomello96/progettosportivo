package ModelliTabelle;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Model.ElencoAttivita;
import Model.ModelRichiestaIscrizione;

public class modelisc extends AbstractTableModel {
	private ArrayList<ModelRichiestaIscrizione> dati;
	
	
	public ArrayList<ModelRichiestaIscrizione> getDati() {
		return dati;
	}
	
	
	public modelisc(ArrayList<ModelRichiestaIscrizione> dati) {
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
		return 4;
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		//ArrayList<Utente>
		//data binding
		ModelRichiestaIscrizione d=dati.get(rowIndex);
		
		  if(columnIndex==0) return d.getIdordine();
		else if(columnIndex==1) return d.getMatricolatesserato();
		else if(columnIndex==2) return d.getPrezzototale();
		else if(columnIndex==3) return d.getDataconsegnaordine();
		  
		  return null;
		  
	}


	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	

	@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==0) dati.get(rowIndex).setIdordine((int)aValue);
        if(columnIndex==1) dati.get(rowIndex).setMatricolatesserato((int)aValue);
        if(columnIndex==2) dati.get(rowIndex).setPrezzototale((int)aValue);
        if(columnIndex==3) dati.get(rowIndex).setDataconsegnaordine(aValue.toString());
        
		
       
        
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }

	
}
