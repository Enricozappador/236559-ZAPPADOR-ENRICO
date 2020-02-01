package studiomedico;

import java.util.*;

public class Studio {
	
	private Map <String, Medico> medici; 
	private Map <String, Visita> visite; 
	private int countv ; 
	private Map <String, Assistito> assistiti; 
	private Map <String, Assistito> assnome; 
	private Map <String, Assistito> eta; 
	private int codicen; 
	private Map<String, Prenotazione> prenotazioni;
	private LinkedList<String> prenoord; 
	private int countp; 
	private int countm; 
	private Map<String, Visita> vo; 
	
	
	
	public Studio () {
		medici = new TreeMap<String, Medico>();
		visite = new TreeMap<String, Visita>(); 
		countv =0; 
		assistiti = new TreeMap<String, Assistito>(); 
		assnome = new TreeMap <String, Assistito>(); 
		eta = new TreeMap <String, Assistito>(); 
		codicen = 1; 
		prenotazioni = new TreeMap<String, Prenotazione>(); 
		prenoord = new LinkedList<String>(); 
		countp = 0; 
		countm =0; 
		vo =new TreeMap<String, Visita>(); 
	}

	public Medico aggiungiMedico(String titolo, String cognome, String nome, String specializzazione) {
		String chiave = cognome+ " "+nome; 
		Medico mtemp = new Medico(titolo, cognome, nome, specializzazione);
		
		if(medici.containsKey(chiave) == true){
			return medici.get(chiave);
		}
		else {
			medici.put(chiave, mtemp); 
			countm++; 
		}
		
		return mtemp;
	}

	public Collection<Medico> elencoMediciInOrdineAlfabetico() {
		LinkedList<Medico> mtemp = new LinkedList<Medico>(medici.values());
		//qui un error
		return mtemp;
	}

	public Collection<Medico> elencoMediciInOrdineAlfabetico(String specializzazione) {
		LinkedList<Medico> mtemp = new LinkedList<Medico>(medici.values()); 
		LinkedList<Medico> medicispec = new LinkedList<Medico>(); 
		
		for(Medico m : mtemp){
			if (m!=null && m.getSpecializzazione().compareTo(specializzazione)==0){
				medicispec.add(m);
			}
		}
	
		return medicispec;
	}

	public Medico cercaMedico(String cognome, String nome) {
		String chiave = cognome+ " "+ nome; 
		Medico mtemp = null; 
		if(medici.containsKey(chiave) == true){
			mtemp = medici.get(chiave); 
		}
		return mtemp;
	}

	public boolean aggiungiOrarioVisitaMedico(String cognome, String nome, String giorno, int daOra, int aOra) {
		String chiave = giorno+" "+daOra+"-"+aOra;
		String chiave1 = "";
		if(daOra <10 ) 
			chiave1 = giorno+" "+"0"+daOra+"-"+aOra; 
		else 
			chiave1 = chiave; 
		
	Medico mtemp = cercaMedico(cognome , nome); 
		Visita vtemp = new Visita (giorno, daOra, aOra, mtemp);
		LinkedList <Visita> vtemp1 = new LinkedList<Visita>(visite.values());
		boolean flag  = true; 
		
		if(mtemp == null){
			return false; 
		}
		else {
			for(Visita v : vtemp1) {
				if ((v.getMedico().getNome().compareTo(nome)==0 && v.getMedico().getCognome().compareTo(cognome)==0) 
						&& ((aOra>v.getDaora() && aOra<v.getAora()) 
								|| (daOra>v.getDaora() && daOra<v.getAora()))) {
					
					flag = false; 
					return false; 
				}
				
		}
			
		}
		
		if(flag == true) {
			//manca sovrapposizione degli orari 
			visite.put(chiave, vtemp);
			countv++; 
			vo.put(chiave1, vtemp); 
			return true;
			} 
		else
		return false;
	}

	public String stampaOrariVisitaMedicoInOrdineCronologico(String cognome, String nome) {
		LinkedList <Visita> vtemp = new LinkedList <Visita> (vo.values());
	String vordinate = "";
	
	
		//String chiave = cognome + " "+nome; 
		
		for (int i = 0; i<countv; i++){
			if( vtemp.get(i).getMedico().getCognome().compareTo(cognome) == 0 && vtemp.get(i).getMedico().getNome().compareTo(nome)==0){
				vordinate = vordinate + vtemp.get(i).getGiorno()+" "+vtemp.get(i).getDaora()+"-"+vtemp.get(i).getAora();
				if (i!= countv-1)
				vordinate += "\n";
			}
		}
	
		
		
		return vordinate;
	}
	
	public String stampaOrariVisitaStudioInOrdineCronologico() {
		LinkedList<Medico> mtemp = new LinkedList<Medico>(medici.values());
		LinkedList <Visita> vtemp = new LinkedList <Visita> (visite.values());
		String orodinati = ""; 
		String ordcontr = ""; 
		for(int i= 0; i<countm; i++){
			orodinati = orodinati+ mtemp.get(i).getTitolo()+" "+mtemp.get(i).getCognome()+" "+mtemp.get(i).getNome()+" ("+mtemp.get(i).getSpecializzazione()+")"+"\n";
			//if (i!= countm-1)
				//orodinati += "\n";
			ordcontr =orodinati;
			for (int y= 0; y<countv; y++){
				
				if( vtemp.get(y).getMedico().getCognome().compareTo(mtemp.get(i).getCognome()) == 0 && vtemp.get(y).getMedico().getNome().compareTo(mtemp.get(i).getNome())==0){
					orodinati = orodinati + vtemp.get(y).getGiorno()+" "+vtemp.get(y).getDaora()+"-"+vtemp.get(y).getAora();
					//if (y!= countv-1)
					orodinati += "\n";
					 
			}
			
				/*else {
					orodinati= orodinati+"-";
				}
				//
				
				/*else{
					orodinati = orodinati+"-";
					if(y!= countv-1)
						orodinati += "\n";
				}*/
		}
			if(ordcontr == orodinati) {
				orodinati = orodinati+"-"; 
			}
			/*if(mtemp.get(i)!=null) {
				
			}
		}*/
		// da fare ]
		}
		
		return orodinati;
	}	
	
	public Assistito aggiungiAssistito(String codiceFiscale, String cognome, String nome, String dataNascita, String cognomeMedico, String nomeMedico, String dal) throws EccezioneSuperatoNumeroMassimoAssistiti {
		Medico mtemp = cercaMedico(cognomeMedico, nomeMedico); 
		Assistito atemp = new Assistito(codiceFiscale, cognome, nome, dataNascita, dal, " ", mtemp);
		
		if (mtemp.getMaxass() == 100){
			throw new EccezioneSuperatoNumeroMassimoAssistiti (); 
		}
		String chiave = cognomeMedico + " "+nomeMedico; 
		String chiavenome = cognome+ " "+nome; 
		
		if(assistiti.containsKey(codiceFiscale)==true){
			return assistiti.get(codiceFiscale); 
			
			
		}
		else {
			assistiti.put(codiceFiscale, atemp); 
			int maxass1= medici.get(chiave).getMaxass() +1 ; 
			medici.get(chiave).setMaxass(maxass1);
			assnome.put(chiavenome, atemp); 
			eta.put(dataNascita, atemp); 
		}
			
		
		
		return atemp;
		
	}
	
	public void terminaAssistenza(String codiceFiscale, String al) {
		Assistito atemp = null; 
		if(assistiti.containsKey(codiceFiscale)==true){
			assistiti.get(codiceFiscale).setAl(al);
		}
		//FARE
	}
	
	public Collection<Assistito> elencoAssistitiInOrdineAlfabetico(String cognome, String nome) {
		//Medico mtemp = cercaMedico(cognome,nome); 
		LinkedList<Assistito> atemp = new LinkedList<Assistito>(assnome.values()) ; 
		LinkedList<Assistito> print = new LinkedList<Assistito>(); 
		
		for (Assistito a : atemp){
			if(a!=null && a.getNomeMedico().compareTo(nome)==0 && a.getCognomeMedico().compareTo(cognome)==0){
				print.add(a);
			}
		}
		
		return print;
	}
	
	public Collection<Assistito> elencoAssistitiInOrdineEta(String cognome, String nome) {
		LinkedList<Assistito> atemp = new LinkedList<Assistito>(eta.values()) ; 
		LinkedList<Assistito> print = new LinkedList<Assistito>(); 
		
		for (Assistito a : atemp){
			if(a!=null && a.getNomeMedico().compareTo(nome)==0 && a.getCognomeMedico().compareTo(cognome)==0){
				print.add(a);
			}
		}
		
		return print;
	}
	
	public Medico cercaMedicoPerAssistito(String codiceFiscale) {
		Assistito atemp = null; 
			Medico mtemp = null; 
		
		if(assistiti.containsKey(codiceFiscale) == true){
			atemp = assistiti.get(codiceFiscale); 
		mtemp = cercaMedico(atemp.getCognomeMedico(), atemp.getNomeMedico()); 
		}
		
		return mtemp;
	}
	
	public String nuovaPrenotazione(String codiceFiscale, String giorno, int daOra, int aOra) throws EccezioneOrarioVisitaErrato {
		Assistito atemp = null; 
		Medico mtemp = null; 
		
		if(assistiti.containsKey(codiceFiscale) == true){
			atemp = assistiti.get(codiceFiscale); 
			mtemp = cercaMedico(atemp.getCognomeMedico(), atemp.getNomeMedico());
			}
		else{
			return null; 
		}
	//	int X =0; 
		
	String	nomeT = mtemp.getCognome().substring(0,3);
		String data = giorno.substring(0,3);
		String dao = Integer.toString(daOra); 
			String aora = Integer.toString(aOra); 
		String codice = Integer.toString(codicen)+"-"+nomeT.toUpperCase()+"-"+data.toUpperCase()+"-"+dao+"-"+aora;  
		Prenotazione ptemp =new Prenotazione(codicen, atemp, mtemp, giorno, daOra, aOra ); 
		String cercaChiave = giorno+" "+daOra+"-"+aOra;;
		if(visite.containsKey(cercaChiave)==false){
			throw new EccezioneOrarioVisitaErrato(); 
			
		}
		else { 
			
			prenotazioni.put(codice, ptemp); 
			codicen++; 
			prenoord.add(countp++, codice+ " "+ atemp.getCodiceFiscale()+";");
		}
		
		
		return codice;
	}
	
	public boolean verificaEsistenzaPrenotazione(String codicePrenotazione) {
		if(prenotazioni.containsKey(codicePrenotazione)==true){
			return true; 
		}
		return false;
	}
	
	public String stampaPrenotazioniStudioInOrdineInserimento() {
		String toString = ""; 
		
		for(String s : prenoord){
			if(s!=null ){
				toString =toString+ s; 
			}
			
		}
		return toString;
	}
	
	
}
