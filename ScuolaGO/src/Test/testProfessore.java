package Test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Dominio.Classe;
import Dominio.Lezione;
import Dominio.Professore;
import Dominio.ScuolaGO;


public class testProfessore {
	static ScuolaGO scuolago;
    
	@BeforeAll
    static void setUp() {
		scuolago = ScuolaGO.getInstance();
		
	    }
	
	@Test
	@DisplayName("Aggiunto nuovo professore")
	public void testAggiungiProfessore() {
		 Professore prof=scuolago.nuovoProfessore("Mario","Pippo","20-03-1960","psw");
		 scuolago.aggiungiProfessoreAOrganico();
	     assertTrue(scuolago.getProfessori().contains(prof));
	}
	
	@Test
	@DisplayName("Login professore")
	public void testLoginProfessore() {
		 Professore prof=scuolago.nuovoProfessore("Mario","Pippo","20-03-1960","psw");
		 scuolago.aggiungiProfessoreAOrganico();
		 Professore prof_login=scuolago.loginProfessore(prof.getId(),prof.getPassword());
	     assertNotNull(prof_login);
	}
	
	@Test
	@DisplayName("Rimozione professore e sue lezioni")
	public void testRimuoviProfessore() {
		Professore prof=scuolago.nuovoProfessore("Mario","Pippo","20-03-1960","psw");
		scuolago.aggiungiProfessoreAOrganico();
		Classe c1 =scuolago.nuovaClasse("2C","Aula 7",20);
		Lezione l1= scuolago.nuovaLezione("Storia");
		l1.setClasse(c1);
		l1.setProfessore(prof);
		assertTrue(scuolago.rimuoviProfessore(prof.getId()));
		assertFalse("Non esistono lezioni del professore rimosso",scuolago.getLezioni().contains(l1));
	}
	

}
