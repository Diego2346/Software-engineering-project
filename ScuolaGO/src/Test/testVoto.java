package Test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Dominio.Alunno;
import Dominio.Classe;
import Dominio.Lezione;
import Dominio.ScuolaGO;
import Dominio.Voto;

public class testVoto {
	static ScuolaGO scuolago;
	static Classe c1;
	static Alunno a1,a2;
	static Lezione l1;
    
	@BeforeAll
    static void setUp() {
		scuolago = ScuolaGO.getInstance();
		// test eseguito in altre classi
		c1=scuolago.nuovaClasse("1E", "Aula 1", 10);
		scuolago.aggiungiClasseAIstituto();
		a1=scuolago.nuovoAlunno("Rosa", "Bruno", "20-09-2004", "psw");
		scuolago.aggiungiAlunnoAClasse(c1);
		l1=scuolago.nuovaLezione("Matematica");
	    }
	
	@Test
	@DisplayName("Aggiungi nuovo voto")
	public void testRegistraVoto() {
		Voto v1=scuolago.nuovoVoto(a1, 9);
		scuolago.abbinaVotoALezione(l1);
		scuolago.confermaVoto();
		assertTrue(scuolago.getVotiAlunno(a1).contains(v1));
	}
	
	@Test
	@DisplayName("Non viene aggiunta un voto non compreso tra 0 e 10")
	public void testRegistraVoto2() {
		Voto v2=scuolago.nuovoVoto(a1, 11);
		scuolago.abbinaVotoALezione(l1);
		scuolago.confermaVoto();
		assertFalse(scuolago.getVotiAlunno(a1).contains(v2));
	}
}
