package Model_Responsabile;

import java.io.InputStream;
import java.io.OutputStream;

public class ElencoDisc{
private String Disciplina;
private String Descrizione;
private String Calendario;
private InputStream Immagine;

public String getDisciplina() {
	return Disciplina;
}
public void setDisciplina(String disciplina) {
	Disciplina = disciplina;
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
public InputStream getImmagine() {
	return Immagine;
}
public void setImmagine(InputStream immagine) {
	Immagine = immagine;
}




}