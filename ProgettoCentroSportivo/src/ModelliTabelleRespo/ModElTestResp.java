package ModelliTabelleRespo;


import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.Blob;

import Model.DisciplinaElenco;
import Model_Istruttore.ElencoAtt;
import Model_Istruttore.ElencoEventi;
import Model_Responsabile.ElencoTestResp;

public class ModElTestResp extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ElencoTestResp> dati;
	
	public ArrayList<ElencoTestResp> getDati() {
		return dati;
	}

	public ModElTestResp(ArrayList<ElencoTestResp> dati) {
		super();
		this.dati = dati;
	}

	
	@Override
	public int getColumnCount() {
		return 4;
	}
	
	
	private String[] tableHeaders = {"Commento","Data Azione","Nome tesserato","Cognome tesserato"};
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
		ElencoTestResp d=dati.get(rowIndex);
		
		  if(columnIndex==0) return d.getCommento();
		else if(columnIndex==1) return d.getDataAzione();
		else if(columnIndex==2) return d.getNomeTes();
		else if(columnIndex==3) return d.getCognomeTes();  
		
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
        if(columnIndex==0) dati.get(rowIndex).setCommento(aValue.toString());
        if(columnIndex==1) dati.get(rowIndex).setDataAzione(aValue.toString());
        if(columnIndex==2) dati.get(rowIndex).setNomeTes(aValue.toString());
        if(columnIndex==3) dati.get(rowIndex).setCognomeTes(aValue.toString());
        
        
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }
	
	
	
	}
	

