package Model;

public class DisciplinaElenco {
private String NomeDisciplina;	
private String NomeLivello;
private Integer MaxIscrittiTurno;
private Float CostoMensile;
private String Descrizione;
private String ImmaginePath;
private String Calendario;

public String getNomeDisciplina() {
	return NomeDisciplina;
}
public void setNomeDisciplina(String nomeDisciplina) {
	NomeDisciplina = nomeDisciplina;
}
public String getNomeLivello() {
	return NomeLivello;
}
public void setNomeLivello(String nomeLivello) {
	NomeLivello = nomeLivello;
}
public Integer getMaxIscrittiTurno() {
	return MaxIscrittiTurno;
}
public void setMaxIscrittiTurno(Integer maxIscrittiTurno) {
	MaxIscrittiTurno = maxIscrittiTurno;
}
public Float getCostoMensile() {
	return CostoMensile;
}
public void setCostoMensile(Float costoMensile) {
	CostoMensile = costoMensile;
}
public String getDescrizione() {
	return Descrizione;
}
public void setDescrizione(String descrizione) {
	Descrizione = descrizione;
}
public String getImmaginePath() {
	return ImmaginePath;
}
public void setImmaginePath(String immagine) {
	ImmaginePath = immagine;
}
public String getCalendario() {
	return Calendario;
}
public void setCalendario(String calendario) {
	Calendario = calendario;
	

}
}
