package modelliTabelleRespo;



import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Model_Responsabile.ElencoCal;
import Model_Responsabile.ElencoLiv;

public class ModCal extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ElencoCal> dati;
	
	public ArrayList<ElencoCal> getDati() {
		return dati;
	
	}
	public ModCal(ArrayList<ElencoCal> dati) {
		super();
		this.dati = dati;
	}

	
	@Override
	public int getColumnCount() {
		return 1;
	}
	
	
	private String[] tableHeaders = {"Nome Calendario"};
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
		ElencoCal d=dati.get(rowIndex);
		
		  if(columnIndex==0) return d.getCalendario();
		

		
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
        if(columnIndex==0) dati.get(rowIndex).setCalendario(aValue.toString());
       
        
        
        
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }
	
	
	
	}
	

