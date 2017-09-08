package modelliTabelleRespo;


import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.Blob;

import Model.DisciplinaElenco;
import Model_Istruttore.ElencoEventi;
import Model_Responsabile.ElencoLivDis;

public class ModDiscDisp extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ElencoLivDis> dati;
	
	public ArrayList<ElencoLivDis> getDati() {
		return dati;
	
	}
	public ModDiscDisp(ArrayList<ElencoLivDis> dati) {
		super();
		this.dati = dati;
	}

	
	@Override
	public int getColumnCount() {
		return 4;
	}
	
	
	private String[] tableHeaders = {"Disciplina","Livello","Costo mensile","Combinazione Liv-Dis"};
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
		ElencoLivDis d=dati.get(rowIndex);
		
		  if(columnIndex==0) return d.getDisciplina();
		else if(columnIndex==1) return d.getLivello();
		else if(columnIndex==2) return d.getCostomensile();
		else if(columnIndex==3) return d.getCodicecomb();
		
		return null;
	}

	@Override
	public Class getColumnClass(int column) {
		if(column==2) return Float.class;
	    if(column==3) return Integer.class;
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
        if(columnIndex==2) dati.get(rowIndex).setCostomensile((float)aValue);
        if(columnIndex==3) dati.get(rowIndex).setCodicecomb((int)aValue);
        
        
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }
	
	
	
	}
	

