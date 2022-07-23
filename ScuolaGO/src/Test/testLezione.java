package Test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Dominio.Classe;
import Dominio.ScuolaGO;
import Dominio.Lezione;
import Dominio.Professore;

public class testLezione {
	static ScuolaGO scuolago;
	static Professore p1,p2;
	static Classe c1,c2;
    
	@BeforeAll
    static void setUp() {
		scuolago = ScuolaGO.getInstance();
		//test eseguiti in altre classi
		p1=scuolago.nuovoProfessore("Mario", "Rossi", "09-08-1980","psw");
	    scuolago.aggiungiProfessoreAOrganico();
		p2=scuolago.nuovoProfessore("Franco", "Ferro", "10-08-1981","psw");
	    scuolago.aggiungiProfessoreAOrganico();
	    c1=scuolago.nuovaClasse("2E", "Aula 2", 10);
	    scuolago.aggiungiClasseAIstituto();
	    c2=scuolago.nuovaClasse("3E", "Aula 3", 10);
	    scuolago.aggiungiClasseAIstituto();
		
	    }
	
	@Test
	@DisplayName("Creata nuova lezione")
	public void testCreaLezione() {
		 Lezione l1=scuolago.nuovaLezione("Storia");
	     scuolago.abbinaProfALezione(p1); 
		 scuolago.abbinaClasseALezione(c1);
		 scuolago.definisciOrarioLezione(Map.of("Mercoledi",Arrays.asList(1)));
		 scuolago.aggiungiLezioneACalendario();
		 assertTrue(scuolago.getLezioni().contains(l1));
	}
	
	
	@Test
	@DisplayName("Non viene aggiunta una lezione che si sovrappone con un'altra del professore")
	public void testCreaLezione2() {
		 Lezione l1=scuolago.nuovaLezione("Spagnolo");
		 scuolago.abbinaClasseALezione(c1);
	     scuolago.abbinaProfALezione(p1); 
		 scuolago.definisciOrarioLezione(Map.of("Martedi",Arrays.asList(1,2)));
		 scuolago.aggiungiLezioneACalendario();
		 Lezione l2=scuolago.nuovaLezione("Inglese");
		 scuolago.abbinaClasseALezione(c2);
		 scuolago.abbinaProfALezione(p1);
		 scuolago.definisciOrarioLezione(Map.of("Martedi",Arrays.asList(1)));
		 scuolago.aggiungiLezioneACalendario();
		 assertFalse(scuolago.getLezioni().contains(l2));
	}
	
	@Test
	@DisplayName("Non viene aggiunta una lezione che si sovrappone con un'altra della classe")
	public void testCreaLezione3() {
		 Lezione l1=scuolago.nuovaLezione("Italiano");
		 scuolago.abbinaClasseALezione(c1);
		 scuolago.abbinaProfALezione(p1);
		 scuolago.definisciOrarioLezione(Map.of("Lunedi",Arrays.asList(1,2)));
		 scuolago.aggiungiLezioneACalendario();
		 Lezione l2=scuolago.nuovaLezione("Italiano");
		 scuolago.abbinaClasseALezione(c1);
		 scuolago.abbinaProfALezione(p2);
		 scuolago.definisciOrarioLezione(Map.of("Lunedi",Arrays.asList(1)));
		 scuolago.aggiungiLezioneACalendario();
		 assertFalse(scuolago.getLezioni().contains(l2));

	}


}
