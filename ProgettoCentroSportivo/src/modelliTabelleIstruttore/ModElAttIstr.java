package modelliTabelleIstruttore;


import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.Blob;

import Model.DisciplinaElenco;
import Model_Istruttore.ElencoAtt;
import Model_Istruttore.ElencoEventi;

public class ModElAttIstr extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ElencoAtt> dati;
	
	public ArrayList<ElencoAtt> getDati() {
		return dati;
	}

	public ModElAttIstr(ArrayList<ElencoAtt> dati) {
		super();
		this.dati = dati;
	}

	
	@Override
	public int getColumnCount() {
		return 2;
	}
	
	
	private String[] tableHeaders = {"Disciplina","Livello"};
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
		ElencoAtt d=dati.get(rowIndex);
		
		  if(columnIndex==0) return d.getDisciplina();
		else if(columnIndex==1) return d.getLivello();
		
		
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
        if(columnIndex==0) dati.get(rowIndex).setDisciplina(aValue.toString());
        if(columnIndex==1) dati.get(rowIndex).setLivello(aValue.toString());
     
        
        
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }
	
	
	
	}
	

