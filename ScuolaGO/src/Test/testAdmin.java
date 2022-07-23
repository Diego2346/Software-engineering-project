package Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Dominio.Admin;
import Dominio.Alunno;
import Dominio.Classe;
import Dominio.ScuolaGO;


public class testAdmin{
	 static ScuolaGO scuolago;
	@BeforeAll
    static void setUp() {
		scuolago = ScuolaGO.getInstance();
	}
	
	@Test
	@DisplayName("Registrato nuovo amministratore")
	public void testRegistraAdmin() {
		assertNull(scuolago.checkAdmin("franco@gmail.com"));
		boolean signup=scuolago.registraAdmin("Franco", "Pippo", "franco@gmail.com", "psw");
		assertTrue(signup);
	}
	
	@Test
	@DisplayName("Non viene registrato un nuovo amministratore con email già utilizzata")
	public void testRegistraAdmin2() {
		scuolago.registraAdmin("Mario", "Rossi", "rossi@gmail.com", "psw");
		assertNotNull(scuolago.checkAdmin("rossi@gmail.com"));
		boolean signup=scuolago.registraAdmin("Giovanni", "Rossi", "rossi@gmail.com", "psw");
		assertFalse(signup);
	}
	
	@Test
	@DisplayName("Login Admin")
	public void testLoginAdmin() {
		scuolago.registraAdmin("Mario", "Rossi", "rossi@gmail.com", "psw");
		Admin admin_login=scuolago.loginAdmin("rossi@gmail.com", "psw");
		assertNotNull(admin_login);
	}
	

	
}
