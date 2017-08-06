package ModelliTabelleIstruttore;


import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.Blob;

import Model.DisciplinaElenco;
import Model_Istruttore.ElencoEventi;
import Model_Istruttore.ElencoLivDis;
import Model_Istruttore.ElencoPartecipanti;

public class ModElPart extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ElencoPartecipanti> dati;
	
	public ArrayList<ElencoPartecipanti> getDati() {
		return dati;
	
	}
	public ModElPart(ArrayList<ElencoPartecipanti> dati) {
		super();
		this.dati = dati;
	}

	
	@Override
	public int getColumnCount() {
		return 2;
	}
	
	
	private String[] tableHeaders = {"Nome Tesserato","Cognome Tesserato"};
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
		ElencoPartecipanti d=dati.get(rowIndex);
		
		  if(columnIndex==0) return d.getNomeTes();
		else if(columnIndex==1) return d.getCognomeTes();

		
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
        if(columnIndex==0) dati.get(rowIndex).setNomeTes(aValue.toString());
        if(columnIndex==1) dati.get(rowIndex).setCognomeTes(aValue.toString());
        
        
        
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }
	
	
	
	}
	

