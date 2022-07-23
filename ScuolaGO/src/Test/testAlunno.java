package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Dominio.Alunno;
import Dominio.Classe;
import Dominio.ScuolaGO;


public class testAlunno {
	 static ScuolaGO scuolago;
     static Classe c;
	@BeforeAll
    static void setUp() {
		scuolago = ScuolaGO.getInstance();
		// test eseguiti in altre classi
		c=scuolago.nuovaClasse("3D", "Aula 12", 2);
		scuolago.aggiungiClasseAIstituto();
	}
	
	@Test
	@DisplayName("Aggiunto nuovo alunno")
	public void testAggiungiAlunno() {
		Alunno a=scuolago.nuovoAlunno("Mara","Bianchi", "psw", "11-12-2003");
	    scuolago.aggiungiAlunnoAClasse(c);
	     assertTrue(scuolago.getAlunniIstituto().contains(a));
	}
	
	@Test
	@DisplayName("Non viene aggiunto un alunno in un classe che ha raggiunto la capienza massima")
	public void testAggiungiAlunno2() {
		Alunno a1=scuolago.nuovoAlunno("Mara","Bianchi", "psw", "10-12-2003");
		scuolago.aggiungiAlunnoAClasse(c);
		Alunno a2=scuolago.nuovoAlunno("Giovanni","Pippo", "psw", "11-11-2003");
		scuolago.aggiungiAlunnoAClasse(c);
		Alunno a3=scuolago.nuovoAlunno("Franco","Sordi", "psw", "11-05-2003");
		scuolago.aggiungiAlunnoAClasse(c);
	    assertFalse(scuolago.getAlunniIstituto().contains(a3));
	}
	
	@Test
	@DisplayName("Login alunno")
	public void testLoginAlunno() {
		Alunno a=scuolago.nuovoAlunno("Mara","Bianchi", "psw", "11-12-2003");
		scuolago.aggiungiAlunnoAClasse(c);
		Alunno alunno_login=scuolago.loginAlunno(a.getId(),a.getPassword());
	    assertNotEquals(alunno_login,null);
	}
	

}
