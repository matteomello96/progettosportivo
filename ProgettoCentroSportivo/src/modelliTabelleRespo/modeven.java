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
		return 11;
	}
	
	
	private String[] tableHeaders = {"codiceiscrizione","nome","cognome","username","nomeevento","modalitapagamento","costo","confermato","annullato","codiceevento","certificato"};
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
		else if(columnIndex==1) return d.getNome();
		else if(columnIndex==2) return d.getCognome();
		else if(columnIndex==3) return d.getUsername();
		else if(columnIndex==4) return d.getNomeevento();
		else if(columnIndex==5) return d.getModalitapagamento();
		else if(columnIndex==6) return d.getCostotot();
		else if(columnIndex==7) return d.getConfermato();
		else if(columnIndex==8) return d.getAnnullato();
		else if(columnIndex==9) return d.getCodiceturnoevento();
		else if(columnIndex==10) return d.getCertificatomed();
		return null;
	}

	@Override
	public Class getColumnClass(int column) {
	    if(column==2) return Integer.class;
		return String.class;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	

	@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==0) dati.get(rowIndex).setCodiceiscrizioneevento(aValue.toString());
        if(columnIndex==1) dati.get(rowIndex).setNome(aValue.toString());
        if(columnIndex==2) dati.get(rowIndex).setCognome(aValue.toString());
        if(columnIndex==3) dati.get(rowIndex).setUsername(aValue.toString());
        if(columnIndex==4) dati.get(rowIndex).setNomeevento(aValue.toString());
        if(columnIndex==5) dati.get(rowIndex).setModalitapagamento(aValue.toString());
        if(columnIndex==6) dati.get(rowIndex).setCostotot((int)aValue);
        if(columnIndex==7) dati.get(rowIndex).setConfermato((int)aValue);     
        if(columnIndex==8) dati.get(rowIndex).setAnnullato((int)aValue);
        if(columnIndex==9) dati.get(rowIndex).setCodiceturnoevento((int)aValue);
        if(columnIndex==10) dati.get(rowIndex).setCertificatomed(aValue.toString());
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }
	
	
	
	}
	

