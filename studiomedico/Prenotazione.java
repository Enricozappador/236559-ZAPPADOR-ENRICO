package studiomedico;

public class Prenotazione {
	private int codice; 
	private Assistito assistito; 
	private Medico medico; 
	private String giorno; 
	private int inizio;
	private int fine;
	public Prenotazione(int codice, Assistito assistito, Medico medico, String giorno,
			int inizio, int fine) {
		super();
		this.codice = codice;
		this.assistito = assistito;
		this.medico = medico; 
		this.giorno = giorno;
		this.inizio = inizio;
		this.fine = fine;
	}
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public Assistito getAssistito() {
		return assistito;
	}
	public void setAssistito(Assistito assistito) {
		this.assistito = assistito;
	}
	public String getGiorno() {
		return giorno;
	}
	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}
	public int getInizio() {
		return inizio;
	}
	public void setInizio(int inizio) {
		this.inizio = inizio;
	}
	public int getFine() {
		return fine;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	} 
	

}
