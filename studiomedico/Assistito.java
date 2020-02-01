package studiomedico;

public class Assistito {
	private String codice; 
	private String cognome; 
	private String nome;
	private String data; 
	private String dal; 
	private String al;
	private Medico m; 
	
	public Assistito(String codice, String cognome, String nome, String data,
			String dal, String al, Medico m) {
		super();
		this.codice = codice;
		this.cognome = cognome;
		this.nome = nome;
		this.data = data;
		this.dal = dal;
		this.al = al;
		this.m = m;
	}

	public String getCodiceFiscale() {
		return codice;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNome() {
		return nome;
	}

	public String getDataNascita() {
		return data;
	}

	public String getDal() {
		return dal;
	}

	public String getAl() {
		return al;
	}

	public String getCognomeMedico() {
		return m.getCognome();
	}

	public String getNomeMedico() {
		return m.getNome();
	}

	public void setAl(String al) {
		this.al = al;
	}
}
