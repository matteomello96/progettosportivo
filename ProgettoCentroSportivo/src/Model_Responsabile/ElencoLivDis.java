package Model_Responsabile;

public class ElencoLivDis{
private String Disciplina;
private String Livello;
private Float Costomensile;

private int codicecomb;
public String getDisciplina() {
	return Disciplina;
}
public void setDisciplina(String disciplina) {
	Disciplina = disciplina;
}
public String getLivello() {
	return Livello;
}
public void setLivello(String livello) {
	Livello = livello;
}
public int getCodicecomb() {
	return codicecomb;
}
public void setCodicecomb(int codicecomb) {
	this.codicecomb = codicecomb;
}
public Float getCostomensile() {
	return Costomensile;
}
public void setCostomensile(Float costomensile) {
	Costomensile = costomensile;
}



}