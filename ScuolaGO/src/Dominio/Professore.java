package Dominio;
import java.util.concurrent.atomic.AtomicInteger;

public class Professore extends Utente {
	private static AtomicInteger count = new AtomicInteger(0);
	public Professore(String nome, String cognome, String nascita, String password) {
		super(nome, cognome, nascita, password);
		id=count.incrementAndGet();
	}

}
