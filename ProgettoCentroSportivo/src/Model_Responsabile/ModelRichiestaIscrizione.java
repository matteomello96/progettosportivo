package Model_Responsabile;

public class ModelRichiestaIscrizione {
private int codiceiscrizionedisciplina;
private String dataazione;
private int tesserato;
private String modalitapagamento;
private int prezzotot;
private int confermato;
private int annullato;


public int getCodiceiscrizionedisciplina() {
	return codiceiscrizionedisciplina;
}
public void setCodiceiscrizionedisciplina(int codiceiscrizionedisciplina) {
	this.codiceiscrizionedisciplina = codiceiscrizionedisciplina;
}
public String getDataazione() {
	return dataazione;
}
public void setDataazione(String dataazione) {
	this.dataazione = dataazione;
}
public int getTesserato() {
	return tesserato;
}
public void setTesserato(int tesserato) {
	this.tesserato = tesserato;
}
public String getModalitapagamento() {
	return modalitapagamento;
}
public void setModalitapagamento(String modalitapagamento) {
	this.modalitapagamento = modalitapagamento;
}
public int getPrezzotot() {
	return prezzotot;
}
public void setPrezzotot(int prezzotot) {
	this.prezzotot = prezzotot;
}
public int getConfermato() {
	return confermato;
}
public void setConfermato(int confermato) {
	this.confermato = confermato;
}
public int getAnnullato() {
	return annullato;
}
public void setAnnullato(int annullato) {
	this.annullato = annullato;
}




}