package ModelliTabelleRespo;


import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.Blob;

import Model.DisciplinaElenco;
import Model_Istruttore.ElencoEventi;
import Model_Responsabile.ElencoIstr;
import Model_Responsabile.ElencoIstrDisp;
import Model_Responsabile.ElencoLivDis;

public class ModIstrDisp extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ElencoIstrDisp> dati;
	
	public ArrayList<ElencoIstrDisp> getDati() {
		return dati;
	
	}
	public ModIstrDisp(ArrayList<ElencoIstrDisp> dati) {
		super();
		this.dati = dati;
	}

	
	@Override
	public int getColumnCount() {
		return 2;
	}
	
	
	private String[] tableHeaders = {"Codice istruttore","Codice combinazionelivdis"};
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
		ElencoIstrDisp d=dati.get(rowIndex);
		
		  if(columnIndex==0) return d.getMatricolaistr();
		else if(columnIndex==1) return d.getCodicecomblivdis();
		
		
		return null;
	}

	@Override
	public Class getColumnClass(int column) {
	    return Integer.class;
		
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	

	@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
       
        if(columnIndex==0) dati.get(rowIndex).setMatricolaistr((int)aValue);
        if(columnIndex==1) dati.get(rowIndex).setCodicecomblivdis((int)aValue);
        
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }
	
	
	
	}
	

