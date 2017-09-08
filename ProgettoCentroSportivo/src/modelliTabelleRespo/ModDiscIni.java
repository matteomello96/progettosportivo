package modelliTabelleRespo;


import java.util.ArrayList;


import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;



import Model_Responsabile.DisciplinaElenco;
import Model_Responsabile.ElencoDisc;

public class ModDiscIni extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
	private ArrayList<ElencoDisc> dati;
	
	public ArrayList<ElencoDisc> getDati() {
		return dati;
	}

	public ModDiscIni(ArrayList<ElencoDisc> dati) {
		super();
		this.dati = dati;
	}

	
	@Override
	public int getColumnCount() {
		return 4;
	}
	
	
	private String[] tableHeaders = {"Nome Disciplina","Descrizione","Calendario","Immagine"};
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
		ElencoDisc d=dati.get(rowIndex);
		
		  if(columnIndex==0) return d.getNomeDisciplina();
		else if(columnIndex==1) return d.getDescrizione();
		else if(columnIndex==2) return d.getCalendario();
		else if(columnIndex==3) return d.getImage();
		
		return null;
	}

	@Override
	public Class getColumnClass(int column) {
	    if(column==3) return ImageIcon.class;
		return String.class;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	

	@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	
        if(columnIndex==0) dati.get(rowIndex).setNomeDisciplina(aValue.toString());
        if(columnIndex==1) dati.get(rowIndex).setDescrizione(aValue.toString());
        if(columnIndex==2 ) dati.get(rowIndex).setCalendario(aValue.toString());
        if(columnIndex==3 ) dati.get(rowIndex).setImage((ImageIcon)aValue);
        
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }
	
	
	

}