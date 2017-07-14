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
		return 4;
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		//ArrayList<Utente>
		//data binding
		ElencoAttivita d=dati.get(rowIndex);
		
		  if(columnIndex==0) return d.getNomeDisciplina();
		else if(columnIndex==1) return d.getNomeLivello();
		else if(columnIndex==2) return d.getMaxIscrittiTurno();
		else if(columnIndex==3) return d.getCostoMensile();
		  return null;
		
	}

	@Override
	public Class getColumnClass(int column) {
		if(column==2) return Integer.class;
		else if(column==3) return Float.class;
		return String.class;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	

	@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==0) dati.get(rowIndex).setNomeDisciplina(aValue.toString());
        if(columnIndex==1) dati.get(rowIndex).setNomeLivello(aValue.toString());
        if(columnIndex==2) dati.get(rowIndex).setMaxIscrittiTurno((int)aValue);
        if(columnIndex==3) dati.get(rowIndex).setCostoMensile((float)aValue);
       
        
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }


}
