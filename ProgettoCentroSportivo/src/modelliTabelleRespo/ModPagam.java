package modelliTabelleRespo;


import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.Blob;

import Model.DisciplinaElenco;
import Model_Istruttore.ElencoEventi;
import Model_Istruttore.ElencoLivDis;
import Model_Responsabile.ElencoDisc;
import Model_Responsabile.ElencoLiv;
import Model_Responsabile.ElencoModP;

public class ModPagam extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ElencoModP> dati;
	
	public ArrayList<ElencoModP> getDati() {
		return dati;
	
	}
	public ModPagam(ArrayList<ElencoModP> dati) {
		super();
		this.dati = dati;
	}

	
	@Override
	public int getColumnCount() {
		return 1;
	}
	
	
	private String[] tableHeaders = {"Modalità di pagamento"};
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
		ElencoModP d=dati.get(rowIndex);
		
		  if(columnIndex==0) return d.getModPag();
		

		
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
        if(columnIndex==0) dati.get(rowIndex).setModPag(aValue.toString());
       
        
        
        
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }
	
	
	
	}
	

