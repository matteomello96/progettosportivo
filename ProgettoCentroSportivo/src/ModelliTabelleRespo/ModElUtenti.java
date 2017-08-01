package ModelliTabelleRespo;


import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.Blob;

import Model.ElencoUtenti;

public class ModElUtenti extends AbstractTableModel {

	private ArrayList<ElencoUtenti> dati;
	
	public ArrayList<ElencoUtenti> getDati() {
		return dati;
	}

	public ModElUtenti(ArrayList<ElencoUtenti> dati) {
		super();
		this.dati = dati;
	}

	
	@Override
	public int getColumnCount() {
		return 14;
	}
	
	
	private String[] tableHeaders = {"Id Utente","Nome","Cognome","Codice Fiscale","Città","Via","Numero Civico","Telefono","Email","Username","Password","Attività","Connessione","Tipo Utente"};
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
		ElencoUtenti e=dati.get(rowIndex);
		
		  if(columnIndex==0) return e.getIdutente();
		else if(columnIndex==1) return e.getNome();
		else if(columnIndex==2) return e.getCognome();
		else if(columnIndex==3) return e.getCodicefiscale();
		else if(columnIndex==4) return e.getCitta();
		else if(columnIndex==5) return e.getVia();
		else if(columnIndex==6) return e.getNumciv();
		else if(columnIndex==7) return e.getTelefono();
		else if(columnIndex==8) return e.getEmail();
		else if(columnIndex==9) return e.getUsername();
		else if(columnIndex==10) return e.getPassword();
		else if(columnIndex==11) return e.getAttivita();
		else if(columnIndex==12) return e.getConnessione();  
		else if(columnIndex==13) return e.getTipoUtente();   
		return null;
	}

	@Override
	public Class getColumnClass(int column) {
		if(column==0) return Integer.class;
		else if(column==6) return Integer.class;
		else if(column==11) return Integer.class;
		else if(column==12) return Integer.class;
		return String.class;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	

	@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==0) dati.get(rowIndex).setIdutente((int)aValue);
        if(columnIndex==1) dati.get(rowIndex).setNome(aValue.toString());
        if(columnIndex==2) dati.get(rowIndex).setCognome(aValue.toString());
        if(columnIndex==3) dati.get(rowIndex).setCodicefiscale(aValue.toString());
        if(columnIndex==4) dati.get(rowIndex).setCitta(aValue.toString());
        if(columnIndex==5) dati.get(rowIndex).setVia(aValue.toString());
        if(columnIndex==6) dati.get(rowIndex).setNumciv((int)aValue);
        if(columnIndex==7) dati.get(rowIndex).setTelefono(aValue.toString());
        if(columnIndex==8) dati.get(rowIndex).setEmail(aValue.toString());
        if(columnIndex==9) dati.get(rowIndex).setUsername(aValue.toString());
        if(columnIndex==10) dati.get(rowIndex).setPassword(aValue.toString());
        if(columnIndex==11 ) dati.get(rowIndex).setAttivita((int)aValue);
        if(columnIndex==12 ) dati.get(rowIndex).setConnessione((int)aValue);
        if(columnIndex==13) dati.get(rowIndex).setTipoUtente(aValue.toString());
        
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }
	
	
	
	}
	

