package ClassiDao; 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import javax.swing.table.DefaultTableModel;
import DBInterfaccia.DbConnection;

public class ElencoDiscipline {

	
	public static DefaultTableModel Elencoiniziale()
	{
		Object[] dat= new Object[2];
        ArrayList<Object[]> dati= new ArrayList<Object[]>();
        
        Connection con = DbConnection.db;
        
        Statement st;
        
        ResultSet rs;
try {
            
            st = con.createStatement();
            rs = st.executeQuery("select distinct  C.NomeDisciplina,B.NomeLivello,A.MaxIscrittiTurno,A.CostoMensile,C.Descrizione,C.Immagine,C.Calendario from disciplinedisponibili as A INNER JOIN livello as B ON A.Livello=B.NomeLivello INNER JOIN disciplina as C ON A.Disciplina=C.NomeDisciplina INNER JOIN calendario as D ON D.nomecalendario=C.Calendario ");
        
            while(rs.next()){
            	
            	dat[0]=rs.getString("NomeDisciplina");
            	dat[1]=rs.getString("NomeLivello");
            	dat[2]=rs.getInt("MaxIscrittiTurno");
            	dat[3]=rs.getFloat("CostoMensile");
            	dat[4]=rs.getString("Descrizione");
            	dat[5]=rs.getByte("Immagine");
            	dat[6]=rs.getString("Calendario");
            	
            	dati.add(dat.clone());
            }
            }catch (SQLException ex) {
                
            }
DefaultTableModel model = new DefaultTableModel(){
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean[] columnEditables = new boolean[] {
			false, false,false,false,false,false,false
		};
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public Class getColumnClass(int column) {
        switch (column) {
            case 0:
                return String.class;
            case 1:
            	return String.class;
            case 2:
            	return Integer.class;
            case 3:
            	return Float.class;
            case 4:
            	return String.class;
            case 5:
            	return Byte.class;
            case 6:
            	return String.class;
            default:
                return Float.class;
                
        }
    }
	
};

Object[] columnsName = new Object[7];

columnsName[0] = "Disciplina";
columnsName[1] = "Livello";   
columnsName[2] = "Max Iscritti per turno"; 
columnsName[3] = "Costo mensile"; 
columnsName[4] = "Descrizione "; 
columnsName[5] = "Immagine"; 
columnsName[6] = "Calendario"; 

model.setColumnIdentifiers(columnsName);

Object[] rigaDati = new Object[7];

for(int i = 0; i < dati.size(); i++){
    
    rigaDati[0] = dati.get(i)[0];
     rigaDati[1] = dati.get(i)[1];
     rigaDati[2] = dati.get(i)[2];
     rigaDati[3] = dati.get(i)[3];
     rigaDati[4] = dati.get(i)[4];
     rigaDati[5] = dati.get(i)[5];
     rigaDati[6] = dati.get(i)[6];
       
       model.addRow(rigaDati);
   
}
return model;
}
}
