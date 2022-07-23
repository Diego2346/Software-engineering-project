package Test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Dominio.Alunno;
import Dominio.Classe;
import Dominio.ScuolaGO;
import Dominio.Lezione;

public class testClasse {
	static ScuolaGO scuolago;
    
	@BeforeAll
    static void setUp() {
		scuolago = ScuolaGO.getInstance();
	    }
	
	@Test
	@DisplayName("Aggiunta nuova classe")
	public void testAggiungiClasse() {
		 Classe c1=scuolago.nuovaClasse("2C", "Aula 28", 10);
		 scuolago.aggiungiClasseAIstituto();
	     assertTrue(scuolago.getClassi().contains(c1));
	} 
	
	
	@Test
	@DisplayName("Non viene aggiunta una classe con un nome già presente")
	public void testAggiungiClasse2() {
		Classe c1=scuolago.nuovaClasse("3D", "Aula 28", 10);
		scuolago.aggiungiClasseAIstituto();
		Classe c2=scuolago.nuovaClasse("3D", "Aula 12", 20);
		scuolago.aggiungiClasseAIstituto();
	    assertFalse(scuolago.getClassi().contains(c2));
	}
	
	@Test
	@DisplayName("Non viene aggiunta una classe con una capienza maggiore di 30")
	public void testAggiungiClasse3() {
		Classe c1=scuolago.nuovaClasse("1B", "Aula 10", 35);
		scuolago.aggiungiClasseAIstituto();
	    assertFalse(scuolago.getClassi().contains(c1));
	}
	
	@Test	
	@DisplayName("Rimozione classe, i suoi alunni e le sue lezioni")
	public void testRimuoviClasse() {
		Classe c1=scuolago.nuovaClasse("2A", "Aula 12", 20);
		scuolago.aggiungiClasseAIstituto();
		Alunno a=scuolago.nuovoAlunno("Giovanni", "Rossi", "01-01-2003","psw");
		scuolago.aggiungiAlunnoAClasse(c1);
		Lezione l=scuolago.nuovaLezione("Matematica");
		scuolago.abbinaClasseALezione(c1);
		scuolago.aggiungiLezioneACalendario();
		scuolago.rimuoviClasse(c1.getNome());
	    assertFalse(scuolago.getClassi().contains(c1));
	    assertFalse("Non esistono alunni della classe rimossa",scuolago.getAlunniIstituto().contains(a));
	    assertFalse("Non esistono lezioni della classe rimossa",scuolago.getLezioni().contains(l));
	}
	
}
