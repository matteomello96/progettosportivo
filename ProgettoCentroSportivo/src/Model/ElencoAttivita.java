package Model;

public class ElencoAttivita {
	private String NomeDisciplina;
	private String NomeLivello;
	private Integer MaxIscrittiTurno;
	private Float CostoMensile;
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
	
}
