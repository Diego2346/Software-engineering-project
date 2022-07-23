package Dominio;
import java.util.concurrent.atomic.AtomicInteger;

public class Admin extends Utente {
	private static AtomicInteger count = new AtomicInteger(0);
	private String email;
	
	public Admin(String nome, String cognome, String email, String password) {
		super(nome, cognome, null, password);
		id=count.incrementAndGet();
		this.email=email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Admin= "+super.toString()+" "+email+" "+getPassword();
	}
	
}
 

  