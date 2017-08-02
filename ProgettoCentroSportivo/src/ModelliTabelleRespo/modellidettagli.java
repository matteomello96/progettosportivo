package ModelliTabelleRespo;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Model_Responsabile.Dettagliiscrizione;
import Model_Responsabile.ModelRichiestaIscrizione;


public class modellidettagli extends AbstractTableModel {
	private ArrayList<Dettagliiscrizione> dati;
	
	
	public ArrayList<Dettagliiscrizione> getDati() {
		return dati;
	}
	
	
	public modellidettagli(ArrayList<Dettagliiscrizione> dati) {
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
		return 6;
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		//ArrayList<Utente>
		//data binding
		Dettagliiscrizione d=dati.get(rowIndex);
		
		  if(columnIndex==0) return d.getDisciplina();
		else if(columnIndex==1) return d.getLivello();
		else if(columnIndex==2) return d.getConferma();
		else if(columnIndex==3) return d.getAnnullla();
		else if(columnIndex==4) return d.getGiorno();
		else if(columnIndex==5) return d.getOrario();
		  return null;
		  
	}


	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	

	@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==0) dati.get(rowIndex).setDisciplina(aValue.toString());
        if(columnIndex==1) dati.get(rowIndex).setLivello(aValue.toString());
        if(columnIndex==2) dati.get(rowIndex).setConferma((int)aValue);
        if(columnIndex==3) dati.get(rowIndex).setAnnullla((int)aValue);
        if(columnIndex==4) dati.get(rowIndex).setGiorno(aValue.toString());
        if(columnIndex==5) dati.get(rowIndex).setOrario(aValue.toString());
     
        
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }

	
}
