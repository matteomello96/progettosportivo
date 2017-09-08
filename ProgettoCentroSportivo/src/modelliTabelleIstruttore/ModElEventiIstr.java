package modelliTabelleIstruttore;


import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.Blob;

import Model.DisciplinaElenco;
import Model_Istruttore.ElencoEventi;

public class ModElEventiIstr extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ElencoEventi> dati;
	
	public ArrayList<ElencoEventi> getDati() {
		return dati;
	}

	public ModElEventiIstr(ArrayList<ElencoEventi> dati) {
		super();
		this.dati = dati;
	}

	
	@Override
	public int getColumnCount() {
		return 3;
	}
	
	
	private String[] tableHeaders = {"Nome Evento","Descrizione","TipoEvento"};
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
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		//ArrayList<Utente>
		//data binding
		ElencoEventi d=dati.get(rowIndex);
		
		  if(columnIndex==0) return d.getNomeEvento();
		else if(columnIndex==1) return d.getDescrizione();
		else if(columnIndex==2) return d.getTipoEvento();
		
		return null;
	}

	@Override
	public Class getColumnClass(int column) {
	    
		return String.class;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	

	@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==0) dati.get(rowIndex).setNomeEvento(aValue.toString());
        if(columnIndex==1) dati.get(rowIndex).setDescrizione(aValue.toString());
        if(columnIndex==2 ) dati.get(rowIndex).setTipoEvento(aValue.toString());
        
        
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }
	
	
	
	}
	

