package Model;

import ClassiDao.*;


public class Utente {

	private static String username;
	private String user;
	private String pass;
	private String password;
	private String nome;
	private String cognome;
	private String codicefiscale;
	private String via;
	private String citta;
	private String numcivico;
	private String telefono;
	private String mail;
	
	
	public Utente() {
		super();
	}

	@SuppressWarnings("static-access")
	public Utente(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		Utente.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean login()
	{
		return UtenteDao.getInstance().userExists(this);
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

	public String getCodicefiscale() {
		return codicefiscale;
	}

	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getNumcivico() {
		return numcivico;
	}

	public void setNumcivico(String numcivico) {
		this.numcivico = numcivico;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
