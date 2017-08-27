package Model_Responsabile;




import javax.swing.ImageIcon;

public class ElencoDisc{
	private String NomeDisciplina;	
	private String Descrizione;
	private String Calendario;
	private String Pathimmagine;

	private ImageIcon image;

	public String getNomeDisciplina() {
		return NomeDisciplina;
	}
	public void setNomeDisciplina(String nomeDisciplina) {
		NomeDisciplina = nomeDisciplina;
	}
	public String getDescrizione() {
		return Descrizione;
	}
	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}


	public String getCalendario() {
		return Calendario;
	}
	public void setCalendario(String calendario) {
		Calendario = calendario;
		

	}
	public ImageIcon getImage() {
		return image;
	}
	public void setImage(ImageIcon imageIcon) {
		this.image = imageIcon;
	}
	public String getPathimmagine() {
		return Pathimmagine;
	}
	public void setPathimmagine(String pathimmagine) {
		Pathimmagine = pathimmagine;
	}

	




}