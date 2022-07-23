package GUI;


import java.util.Arrays;
import java.util.Map;


import Dominio.Alunno;
import Dominio.Classe;
import Dominio.Lezione;
import Dominio.Media1;
import Dominio.Media2;
import Dominio.Professore;
import Dominio.ScuolaGO;


public class Start { 
	 
	
	public static void main(String[] args) {
	   
		ScuolaGO scuolago = ScuolaGO.getInstance();
		
		//AGGIUNGO USER E ADMIN
        scuolago.registraAdmin("Mario","Rossi","admin@gmail.com","psw");
        
        
        Professore p1=scuolago.nuovoProfessore("Franco", "Gallo", "09-08-1980","psw");
        scuolago.aggiungiProfessoreAOrganico();
        Professore p2=scuolago.nuovoProfessore("Giovanni", "Pippo", "09-08-1980","psw");
        scuolago.aggiungiProfessoreAOrganico();
        Professore p3=scuolago.nuovoProfessore("Giuseppe", "Mangiagli", "10-07-1960","psw");
        scuolago.aggiungiProfessoreAOrganico();
        
        Classe c1=scuolago.nuovaClasse("3A", "Aula 7", 25);
        scuolago.aggiungiClasseAIstituto();
        
        Classe c2=scuolago.nuovaClasse("1C", "Aula 20", 10);
        scuolago.aggiungiClasseAIstituto();
        
        //AGGIUNGO ALUNNI
        Alunno a1=scuolago.nuovoAlunno("Giovanni","Bianchi","01-20-2005","psw");
		scuolago.aggiungiAlunnoAClasse(c1);
		Alunno a2=scuolago.nuovoAlunno("Sara","Russo","05-21-2005","psw");
		scuolago.aggiungiAlunnoAClasse(c1);
		Alunno a3=scuolago.nuovoAlunno("Maria","Neri","03-24-2005","psw");
		scuolago.aggiungiAlunnoAClasse(c2);
		Alunno a4=scuolago.nuovoAlunno("Fabio","Verdi","01-23-2005","psw");
		scuolago.aggiungiAlunnoAClasse(c2);
		
		
		//CREO LEZIONI
		Lezione l1=scuolago.nuovaLezione("Matematica");
		scuolago.abbinaProfALezione(p3);
		scuolago.abbinaClasseALezione(c1);
		scuolago.definisciOrarioLezione(Map.of("Lunedi",Arrays.asList(1, 2)));
		scuolago.aggiungiLezioneACalendario();
		
		Lezione l2=scuolago.nuovaLezione("Fisica");
		scuolago.abbinaProfALezione(p1); 
		scuolago.abbinaClasseALezione(c1);
		scuolago.definisciOrarioLezione(Map.of("Giovedi",Arrays.asList(3, 4)));
		scuolago.aggiungiLezioneACalendario();
		
		Lezione l3=scuolago.nuovaLezione("Fisica");
		scuolago.abbinaProfALezione(p1); 
		scuolago.abbinaClasseALezione(c2);
		scuolago.definisciOrarioLezione(Map.of("Lunedi",Arrays.asList(1,2)));
		scuolago.aggiungiLezioneACalendario();
		
		Lezione l4=scuolago.nuovaLezione("Religione");
		scuolago.abbinaProfALezione(p2); 
		scuolago.abbinaClasseALezione(c1);
		scuolago.definisciOrarioLezione(Map.of("Martedi",Arrays.asList(5)));
		scuolago.aggiungiLezioneACalendario();
		
		//CREO AVVISI
		scuolago.nuovoAvviso("Domani vacanza");
		scuolago.inviaAvviso(Arrays.asList(c1,c2));
		scuolago.nuovoAvviso("Venerdi si entrerà alla 2° ora");
		scuolago.inviaAvviso(Arrays.asList(c1));
		
		//CREO ASSENZE
		scuolago.nuovaAssenza(Arrays.asList(a1,a2));
		scuolago.confermaAssenze();
		
		//CREO VOTI
		scuolago.nuovoVoto(a1, 6);
		scuolago.abbinaVotoALezione(l2);
		scuolago.confermaVoto();
		
		scuolago.nuovoVoto(a1, 3);
		scuolago.abbinaVotoALezione(l1);
		scuolago.confermaVoto();
		
		scuolago.nuovoVoto(a1, 10);
		scuolago.abbinaVotoALezione(l4);
		scuolago.confermaVoto();
		
		//setto strategia media1 (severa)
		scuolago.getRegistroVoti().setMediaStrategy(new Media1());
		
		Login.main(null);
		    
	    
	    
}}
