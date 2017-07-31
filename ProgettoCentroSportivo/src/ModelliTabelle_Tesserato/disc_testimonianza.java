package ModelliTabelle_Tesserato;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Model_Tesserato.ElenoTest;

public class disc_testimonianza extends AbstractTableModel  {

	private ArrayList<ElenoTest> dati;
	
	public ArrayList<ElenoTest> getDati() {
		return dati;
	}

	public disc_testimonianza(ArrayList<ElenoTest> dati) {
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
		return 3;
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		//ArrayList<Utente>
		//data binding
		ElenoTest d=dati.get(rowIndex);
		
		  if(columnIndex==0) return d.getDisciplina();
		else if(columnIndex==1) return d.getLivello();
		else if(columnIndex==2) return d.getCommento();
		
		  
		  return null;
		  
	}


	boolean[] columnEditables = new boolean[] {
			false, false, true
		};
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnEditables[columnIndex];
	}
	

	@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==0) dati.get(rowIndex).setDisciplina(aValue.toString());
        if(columnIndex==1) dati.get(rowIndex).setLivello(aValue.toString());
        if(columnIndex==2) dati.get(rowIndex).setCommento(aValue.toString());
      
        
		
       
        
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }


}

