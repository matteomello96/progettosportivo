package Model_Responsabile;

import javax.swing.ImageIcon;

public class DisciplinaElenco {
private String NomeDisciplina;	
private String Descrizione;
private String Calendario;
private ImageIcon Image;

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
public ImageIcon getImage() {
	return Image;
}
public void setImage(ImageIcon immagine) {
	Image = immagine;
}
public String getCalendario() {
	return Calendario;
}
public void setCalendario(String calendario) {
	Calendario = calendario;
	

}

}
