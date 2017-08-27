package Model;



import javax.swing.ImageIcon;

public class DisciplinaElenco {
private String NomeDisciplina;	
private String Descrizione;
private String Calendario;

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

}
