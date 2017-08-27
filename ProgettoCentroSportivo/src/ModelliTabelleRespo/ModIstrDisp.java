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
		return 4;
	}
	
	
	private String[] tableHeaders = {"Nome istruttore","Cognome istruttore","Disciplina","Livello"};
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
		
		  if(columnIndex==0) return d.getNomeistr();
		else if(columnIndex==1) return d.getCognomeistr();
		else if(columnIndex==2) return d.getDisciplina();
		else if(columnIndex==3) return d.getLivello();
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
       
        if(columnIndex==0) dati.get(rowIndex).setNomeistr(aValue.toString());
        if(columnIndex==1) dati.get(rowIndex).setCognomeistr(aValue.toString());
        if(columnIndex==2) dati.get(rowIndex).setDisciplina(aValue.toString());
        if(columnIndex==3) dati.get(rowIndex).setLivello(aValue.toString());
        
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }
	
	
	
	}
	

