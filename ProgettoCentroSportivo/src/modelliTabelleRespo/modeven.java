package modelliTabelleRespo;


import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


import Model_Responsabile.elencoeventi;

public class modeven extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<elencoeventi> dati;
	
	public ArrayList<elencoeventi> getDati() {
		return dati;
	
	}
	public modeven(ArrayList<elencoeventi> dati) {
		super();
		this.dati = dati;
	}

	
	@Override
	public int getColumnCount() {
		return 13;
	}
	
	
	private String[] tableHeaders = {"codice iscrizione","tesserato","codice evento","tipo evento","costo totale","modalita di pagamento","certificato","confermato","annullato","modificato","giorno","fascia oraria","spazio"};
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
		elencoeventi d=dati.get(rowIndex);
		
		  if(columnIndex==0) return d.getCodiceiscrizioneevento();
		else if(columnIndex==1) return d.getTesserato();
		else if(columnIndex==2) return d.getEvento();
		else if(columnIndex==3) return d.getTipoevento();
		else if(columnIndex==4) return d.getCostotot();
		else if(columnIndex==5) return d.getModalitapagamento();
		else if(columnIndex==6) return d.getCertificatomed(); 
		else if(columnIndex==7) return d.getConfermato();
		else if(columnIndex==8) return d.getAnnullato();
		else if(columnIndex==9) return d.getModificato();
		else if(columnIndex==10) return d.getGiorno();
		else if(columnIndex==11) return d.getFasciaoraria();  
		else if(columnIndex==12) return d.getSpazio(); 
		return null;
	}

	@Override
	public Class getColumnClass(int column) {
	    if(column==3) return String.class;
	    if(column==5) return String.class;
	    if(column==6) return String.class;
	    if(column==10) return String.class;
	    if(column==11) return String.class;
	    if(column==12) return String.class;
		return Integer.class;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	

	@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==0) dati.get(rowIndex).setCodiceiscrizioneevento((int)aValue);
        if(columnIndex==1) dati.get(rowIndex).setTesserato((int)aValue);
        if(columnIndex==2) dati.get(rowIndex).setEvento((int)aValue);
        if(columnIndex==3) dati.get(rowIndex).setTipoevento(aValue.toString());
        if(columnIndex==4) dati.get(rowIndex).setCostotot((int)aValue);
        if(columnIndex==5) dati.get(rowIndex).setModalitapagamento(aValue.toString());
        if(columnIndex==6) dati.get(rowIndex).setCertificatomed(aValue.toString());
        if(columnIndex==7) dati.get(rowIndex).setConfermato((int)aValue);     
        if(columnIndex==8) dati.get(rowIndex).setAnnullato((int)aValue);
        if(columnIndex==9) dati.get(rowIndex).setModificato((int)aValue);
        if(columnIndex==10) dati.get(rowIndex).setGiorno(aValue.toString());
        if(columnIndex==11) dati.get(rowIndex).setFasciaoraria(aValue.toString());
        if(columnIndex==12) dati.get(rowIndex).setSpazio(aValue.toString());
        
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }
	
	
	
	}
	

