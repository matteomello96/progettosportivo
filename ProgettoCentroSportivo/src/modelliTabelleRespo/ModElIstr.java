package modelliTabelleRespo;


import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.Blob;

import Model.DisciplinaElenco;
import Model_Istruttore.ElencoEventi;
import Model_Responsabile.ElencoIstr;
import Model_Responsabile.ElencoLivDis;

public class ModElIstr extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ElencoIstr> dati;
	
	public ArrayList<ElencoIstr> getDati() {
		return dati;
	
	}
	public ModElIstr(ArrayList<ElencoIstr> dati) {
		super();
		this.dati = dati;
	}

	
	@Override
	public int getColumnCount() {
		return 3;
	}
	
	
	private String[] tableHeaders = {"Nome istruttore","Cognome istruttore","Matricola istruttore"};
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
		ElencoIstr d=dati.get(rowIndex);
		
		  if(columnIndex==0) return d.getNomeIstruttore();
		else if(columnIndex==1) return d.getCognomeIstruttore();
		else if(columnIndex==2) return d.getMatricolaistruttore();
		
		return null;
	}

	@Override
	public Class getColumnClass(int column) {
	    if(column==2 ) return Integer.class;
		return String.class;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	

	@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==0) dati.get(rowIndex).setNomeIstruttore(aValue.toString());
        if(columnIndex==1) dati.get(rowIndex).setCognomeIstruttore(aValue.toString());
        if(columnIndex==2) dati.get(rowIndex).setMatricolaistruttore((int)aValue);
        
        
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }
	
	
	
	}
	

