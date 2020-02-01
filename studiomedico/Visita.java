package studiomedico;

public class Visita {
	private String giorno; 
	private int daora;
	private int aora; 
	private Medico medico;
	public Visita(String giorno, int daora, int aora, Medico medico) {
		super();
		this.giorno = giorno;
		this.daora = daora;
		this.aora = aora;
		this.medico = medico;
	}
	public String getGiorno() {
		return giorno;
	}
	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}
	public int getDaora() {
		return daora;
	}
	public void setDaora(int daora) {
		this.daora = daora;
	}
	public int getAora() {
		return aora;
	}
	public void setAora(int aora) {
		this.aora = aora;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	} 
	

}
