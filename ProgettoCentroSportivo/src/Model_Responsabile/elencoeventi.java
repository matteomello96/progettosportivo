package Model_Responsabile;

public class elencoeventi {
	private String codiceiscrizioneevento;
	private String nome;
	private String cognome;
	private String nomeevento;
	private String modalitapagamento;
	private int costotot;
	private int  confermato;
	private int  annullato;
	public String getCodiceiscrizioneevento() {
		return codiceiscrizioneevento;
	}
	public void setCodiceiscrizioneevento(String codiceiscrizioneevento) {
		this.codiceiscrizioneevento = codiceiscrizioneevento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNomeevento() {
		return nomeevento;
	}
	public void setNomeevento(String nomeevento) {
		this.nomeevento = nomeevento;
	}
	public String getModalitapagamento() {
		return modalitapagamento;
	}
	public void setModalitapagamento(String modalitapagamento) {
		this.modalitapagamento = modalitapagamento;
	}
	public int getCostotot() {
		return costotot;
	}
	public void setCostotot(int costotot) {
		this.costotot = costotot;
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
