package studiomedico;

import java.util.LinkedList;

public class Medico {
	private String titolo; 
	private String cognome; 
	private String nome; 
	private String specializzazione; 
	private LinkedList<String> visite = new LinkedList<String>(); 
	private int maxass =0; 

	public Medico(String titolo, String cognome, String nome,
			String specializzazione) {
		super();
		this.titolo = titolo;
		this.cognome = cognome;
		this.nome = nome;
		this.specializzazione = specializzazione;
		
		
	}

	public String getTitolo() {
		return titolo;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNome() {
		return nome;
	}

	public String getSpecializzazione() {
		return specializzazione;
	}

	public LinkedList<String> getVisite() {
		return visite;
	}

	public void setVisite(LinkedList<String> visite) {
		this.visite = visite;
	}

	public int getMaxass() {
		return maxass;
	}

	public void setMaxass(int maxass) {
		this.maxass = maxass;
	}
}
