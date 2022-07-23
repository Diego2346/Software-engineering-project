package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Dominio.Avviso;
import Dominio.Classe;
import Dominio.ScuolaGO;

public class testAvviso {
	static ScuolaGO scuolago;
	static Classe c1,c2;
    
	@BeforeAll
    static void setUp() {
		scuolago = ScuolaGO.getInstance();
		// test eseguito in altre classi
		c1=scuolago.nuovaClasse("1E", "Aula 1", 10);
		scuolago.aggiungiClasseAIstituto();
		c2=scuolago.nuovaClasse("2E", "Aula 2", 10);
		scuolago.aggiungiClasseAIstituto();
	    }
	
	@Test
	@DisplayName("Inviato nuovo avviso")
	public void testInviaAvviso() {
		Avviso a=scuolago.nuovoAvviso("Professore assente per una settimana");
		scuolago.inviaAvviso(Arrays.asList(c1,c2));
		assertTrue(scuolago.getAvvisi().contains(a));
		
	}
	
}
