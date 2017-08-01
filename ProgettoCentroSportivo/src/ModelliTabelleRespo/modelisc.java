package ModelliTabelleRespo;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Model_Responsabile.ModelRichiestaIscrizione;


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
		return 7;
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		//ArrayList<Utente>
		//data binding
		ModelRichiestaIscrizione d=dati.get(rowIndex);
		
		  if(columnIndex==0) return d.getCodiceiscrizionedisciplina();
		else if(columnIndex==1) return d.getDataazione();
		else if(columnIndex==2) return d.getTesserato();
		else if(columnIndex==3) return d.getModalitapagamento();
		else if(columnIndex==4) return d.getPrezzotot();
		else if(columnIndex==5) return d.getConfermato();
		else if(columnIndex==6) return d.getAnnullato();
		  return null;
		  
	}


	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	

	@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==0) dati.get(rowIndex).setCodiceiscrizionedisciplina((int)aValue);
        if(columnIndex==1) dati.get(rowIndex).setDataazione(aValue.toString());
        if(columnIndex==2) dati.get(rowIndex).setTesserato((int)aValue);
        if(columnIndex==3) dati.get(rowIndex).setModalitapagamento(aValue.toString());
        if(columnIndex==4) dati.get(rowIndex).setPrezzotot((int)aValue);
        if(columnIndex==5) dati.get(rowIndex).setConfermato((int)aValue);
        if(columnIndex==6) dati.get(rowIndex).setAnnullato((int)aValue);
        
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }

	
}
