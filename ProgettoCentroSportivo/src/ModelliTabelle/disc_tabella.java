package ModelliTabelle;


import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


import Model.ElencoAttivita;

public class disc_tabella extends AbstractTableModel  {

	private ArrayList<ElencoAttivita> dati;
	
	public ArrayList<ElencoAttivita> getDati() {
		return dati;
	}

	public disc_tabella(ArrayList<ElencoAttivita> dati) {
		super();
		this.dati = dati;
	}

	@Override
	public int getRowCount() {
		if(dati!=null) return dati.size();
		else return 0;
	}

	@Override
	public int getColumnCount() {
		return 6;
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		//ArrayList<Utente>
		//data binding
		ElencoAttivita d=dati.get(rowIndex);
		
		  if(columnIndex==0) return d.getNomeDisciplina();
		else if(columnIndex==1) return d.getNomeLivello();
		else if(columnIndex==2) return d.getCostoMensile();
		else if(columnIndex==3) return d.getFasciaoraria();
		else if(columnIndex==4) return d.getGiornosettimana();
		else if(columnIndex==5) return d.getprenotazionidisponibili();
		  
		  return null;
		  
	}


	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	

	@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==0) dati.get(rowIndex).setNomeDisciplina(aValue.toString());
        if(columnIndex==1) dati.get(rowIndex).setNomeLivello(aValue.toString());
        if(columnIndex==2) dati.get(rowIndex).setCostoMensile((int)aValue);
        if(columnIndex==3) dati.get(rowIndex).setFasciaoraria(aValue.toString());
        if(columnIndex==4) dati.get(rowIndex).setGiornosettimana(aValue.toString());
        if(columnIndex==5) dati.get(rowIndex).setprenotazionidisponibili((int)aValue);
        
		
       
        
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }


}
