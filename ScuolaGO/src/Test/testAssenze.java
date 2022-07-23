package Test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Dominio.Alunno;
import Dominio.Assenze;
import Dominio.Classe;
import Dominio.ScuolaGO;

public class testAssenze {
	static ScuolaGO scuolago;
	static Classe c1,c2;
	static Alunno a1,a2,a3;
    
	@BeforeAll
    static void setUp() {
		scuolago = ScuolaGO.getInstance();
		// test eseguito in altre classi
		c1=scuolago.nuovaClasse("1E", "Aula 1", 10);
		scuolago.aggiungiClasseAIstituto();
		c2=scuolago.nuovaClasse("1D", "Aula 2", 10);
		scuolago.aggiungiClasseAIstituto();
		a1=scuolago.nuovoAlunno("Rosa", "Bruno", "20-09-2004", "psw");
		scuolago.aggiungiAlunnoAClasse(c1);
		a2=scuolago.nuovoAlunno("Bianca", "Verdi", "19-08-2004", "psw");
		scuolago.aggiungiAlunnoAClasse(c2);
		a3=scuolago.nuovoAlunno("Filippo", "Gialli", "19-08-2004", "psw");
		scuolago.aggiungiAlunnoAClasse(c2);
	    }
	
	@Test
	@DisplayName("Aggiungi nuove assenze")
	public void testRegistraAssenze() {
		Assenze as=scuolago.nuovaAssenza(Arrays.asList(a1));
		scuolago.confermaAssenze();
		assertTrue(scuolago.getAssenze().contains(as));
	}
	
	@Test
	@DisplayName("Non è possibile aggiungere assenze più di una volta al giorno per classe")
	public void testRegistraAssenze2() {
		Assenze as1=scuolago.nuovaAssenza(Arrays.asList(a2));
		scuolago.confermaAssenze();
		Assenze as2=scuolago.nuovaAssenza(Arrays.asList(a3));
		scuolago.confermaAssenze();
		assertFalse(scuolago.getAssenze().contains(as2));
	}
}
