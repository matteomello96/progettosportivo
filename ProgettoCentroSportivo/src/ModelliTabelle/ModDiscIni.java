package ModelliTabelle;


import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.Blob;

import Model.DisciplinaElenco;

public class ModDiscIni extends AbstractTableModel {

	private ArrayList<DisciplinaElenco> dati;
	
	public ArrayList<DisciplinaElenco> getDati() {
		return dati;
	}

	public ModDiscIni(ArrayList<DisciplinaElenco> dati) {
		super();
		this.dati = dati;
	}

	
	@Override
	public int getColumnCount() {
		return 4;
	}
	
	
	private String[] tableHeaders = {"Nome Disciplina","Descrizione","Calendario","Immagine"};
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
		DisciplinaElenco d=dati.get(rowIndex);
		
		  if(columnIndex==0) return d.getNomeDisciplina();
		else if(columnIndex==1) return d.getDescrizione();
		else if(columnIndex==2) return d.getCalendario();
		else if(columnIndex==3) return d.getImmaginePath();
		return null;
	}

	@Override
	public Class getColumnClass(int column) {
	    if(column==3) return InputStream.class;
		return String.class;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	

	@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==0) dati.get(rowIndex).setNomeDisciplina(aValue.toString());
        if(columnIndex==4) dati.get(rowIndex).setDescrizione(aValue.toString());
        if(columnIndex==5 ) dati.get(rowIndex).setCalendario(aValue.toString());
        if(columnIndex==6 ) dati.get(rowIndex).setImmaginePath(aValue.toString());
        
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }
	
	
	
	}
	

