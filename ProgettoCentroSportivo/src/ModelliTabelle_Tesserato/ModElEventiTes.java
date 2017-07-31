package ModelliTabelle_Tesserato;


import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.Blob;

import Model.DisciplinaElenco;
import Model_Istruttore.ElencoEventi;
import Model_Tesserato.ElencoEventiTes;

public class ModElEventiTes extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ElencoEventiTes> dati;
	
	public ArrayList<ElencoEventiTes> getDati() {
		return dati;
	}

	public ModElEventiTes(ArrayList<ElencoEventiTes> dati) {
		super();
		this.dati = dati;
	}

	
	@Override
	public int getColumnCount() {
		return 8;
	}
	
	
	private String[] tableHeaders = {"Nome Evento","Descrizione","TipoEvento","Fascia oraria","Giorno della settimana","Posti disponibili","Nome istruttore","Cognome istruttore"};
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
		ElencoEventiTes d=dati.get(rowIndex);
		
		  if(columnIndex==0) return d.getNomeEvento();
		else if(columnIndex==1) return d.getDescrizione();
		else if(columnIndex==2) return d.getTipoEvento();
		else if(columnIndex==3) return d.getFasciaOraria();
		else if(columnIndex==4) return d.getGiornoSettimana();
		else if(columnIndex==5) return d.getPostidisp();
		else if(columnIndex==6) return d.getNomeIstruttore();
		else if(columnIndex==7) return d.getCognomeIstruttore();
		 
		return null;
	}

	@Override
	public Class getColumnClass(int column) {
	    if(column==5) return Integer.class;
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
        if(columnIndex==3 ) dati.get(rowIndex).setFasciaOraria(aValue.toString());
        if(columnIndex==4 ) dati.get(rowIndex).setGiornoSettimana(aValue.toString());
        if(columnIndex==5 ) dati.get(rowIndex).setPostidisp((int)aValue);
        if(columnIndex==6) dati.get(rowIndex).setNomeIstruttore(aValue.toString());
        if(columnIndex==7 ) dati.get(rowIndex).setCognomeIstruttore(aValue.toString());
        
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }
	
	
	
	}
	

