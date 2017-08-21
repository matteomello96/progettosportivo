package ModelliTabelle_Tesserato;



import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


import Model_Tesserato.elencoiscrizioniattivita;

public class tabellavisevento extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<elencoiscrizioniattivita> dati;
	
	public ArrayList<elencoiscrizioniattivita> getDati() {
		return dati;
	}

	public tabellavisevento(ArrayList<elencoiscrizioniattivita> dati) {
		super();
		this.dati = dati;
	}

	
	@Override
	public int getColumnCount() {
		return 3;
	}
	
	
	private String[] tableHeaders = {"Modalita pagamento","costo totale","Nome Evento"};
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
		elencoiscrizioniattivita d=dati.get(rowIndex);
		
		  if(columnIndex==0) return d.getModalitapagamento();
		else if(columnIndex==1) return d.getCostotot();
		else if(columnIndex==2) return d.getNomeevento();
	
		 
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
        if(columnIndex==0) dati.get(rowIndex).setModalitapagamento(aValue.toString());
        if(columnIndex==1 ) dati.get(rowIndex).setCostotot((int)aValue);
        if(columnIndex==2) dati.get(rowIndex).setNomeevento(aValue.toString());
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }
	
	
	
	}
	

