package Model_Tesserato;

public class ElencoAttivita {
	private String NomeDisciplina;
	private String NomeLivello;
	private Integer CostoMensile;
	private String giorno;
	private String orario;
	private int confermato;

	
	
	
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

	public Integer getCostoMensile() {
		return CostoMensile;
	}
	public void setCostoMensile(Integer costoMensile) {
		CostoMensile = costoMensile;
	}
	public String getGiorno() {
		return giorno;
	}
	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}
	public String getOrario() {
		return orario;
	}
	public void setOrario(String orario) {
		this.orario = orario;
	}
	public int getConfermato() {
		return confermato;
	}
	public void setConfermato(int confermato) {
		this.confermato = confermato;
	}

	
	
	

	
}
