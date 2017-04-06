package DatiGenerali;



import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import DBInterfaccia.DbConnection;

// create a users class
public class DisciplineDAO {
    

    
    private String disciplina;

    private String livello;
    private int maxiscrittiperturno;
    private float costomensile;
    private String descrizione;
    private Object immagine;
    private String calendario;   
    
    
   

	public DisciplineDAO( String disciplina,String livello,int maxiscrittiperturno,float costomensile,String descrizione,Object immagine,String calendario){
        this.disciplina = disciplina;
        this.maxiscrittiperturno = maxiscrittiperturno;
   
        this.costomensile=costomensile;
        this.descrizione=descrizione;
        this.immagine=immagine;
        this.calendario=calendario;
        
        

    }
    
    
public String getDisciplina() {
    	
    	
		return disciplina;
	}

	
	public String getLivello() {
		return livello;
	}

	public int getMaxiscrittiperturno() {
		return maxiscrittiperturno;
	}
	public float getCostomensile() {
		return costomensile;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public Object getImmagine() {
		return immagine;
	}
	public String getCalendario() {
		return calendario;
	}
   
    
    
 
    
    @SuppressWarnings("serial")
	public static DefaultTableModel prendiElementi(String sql){

    	 final DecimalFormat df = new DecimalFormat("0.00");
    		df.setRoundingMode(RoundingMode.CEILING);
        ArrayList<DisciplineDAO> articoli = new ArrayList<DisciplineDAO>();
        
        Connection con = DbConnection.db;
        
        Statement st;
        
        ResultSet rs;
        
        DisciplineDAO dis;
        
        try {
            
            st = con.createStatement();
            
            rs = st.executeQuery(sql); 
            while(rs.next()){
                
                dis = new DisciplineDAO(
                        rs.getString("Disciplina"),
                        rs.getString("Livello"),
                        rs.getInt("MaxIscrittiTurno"),
                        rs.getFloat("CostoMensile"),
                        rs.getString("Descrizione"),
                        rs.getObject("Immagine"),
                        rs.getString("Calendario")
                        
                        
                );
                
                articoli.add(dis);
            }
             
        } catch (SQLException ex) {
           
        }

        
    
    /////////////////////////////////////////////////////////////////////////////////////////
    	
        DefaultTableModel model = new DefaultTableModel(){
        	boolean[] columnEditables = new boolean[] {
    				false, false, false, false, false,false,false
    			};
        	public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
        	
                @SuppressWarnings({ "unchecked", "rawtypes" })
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
                        	return Object.class;
                        default:
                            return String.class;
                    }
                }
            
        	
        	
        };
        
        Object[] columnsName = new Object[7];
        
        columnsName[0] = "Disciplina";
        columnsName[1] = "Livello";
        columnsName[2] = "Max Iscritti per Turno";
        columnsName[3] = "Costo Mensile";
        columnsName[4] = "Descrizione";
        columnsName[5] = "Immagine";
        columnsName[6] = "Calendario";
        
      
        model.setColumnIdentifiers(columnsName);
        
        Object[] rigaDati = new Object[7];
        
        for(int i = 0; i < articoli.size(); i++){
            
            rigaDati[0] = articoli.get(i).getDisciplina();
             rigaDati[1] = articoli.get(i).getLivello();
              rigaDati[2] = articoli.get(i).getMaxiscrittiperturno();
               rigaDati[3] = articoli.get(i).getCostomensile();
               rigaDati[4] = articoli.get(i).getDescrizione();
               rigaDati[5] = articoli.get(i).getImmagine();
               rigaDati[6] = articoli.get(i).getCalendario();
           
               model.addRow(rigaDati);
               
        }
        
		
        return model;

    }
}
