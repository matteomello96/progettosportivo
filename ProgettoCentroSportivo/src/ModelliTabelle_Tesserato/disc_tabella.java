package ModelliTabelle_Tesserato;


import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Model_Tesserato.ElencoAttivita;

public class disc_tabella extends AbstractTableModel  {

	private ArrayList<ElencoAttivita> dati;
	
	public ArrayList<ElencoAttivita> getDati() {
		return dati;
	}

	public disc_tabella(ArrayList<ElencoAttivita> dati) {
		super();
		this.dati = dati;
	}
	
	private String[] tableHeaders = {"Disciplina", "Livello", "CostoMensile"};
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
	public int getColumnCount() {
		return 3;
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		//ArrayList<Utente>
		//data binding
		ElencoAttivita d=dati.get(rowIndex);
		
		  if(columnIndex==0) return d.getNomeDisciplina();
		else if(columnIndex==1) return d.getNomeLivello();
		else if(columnIndex==2) return d.getCostoMensile();
		
		  
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
      
        
		
       
        
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }


}
