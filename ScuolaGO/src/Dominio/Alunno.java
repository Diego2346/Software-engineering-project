package Dominio;

import java.util.concurrent.atomic.AtomicInteger;

public class Alunno extends Utente {
	private static AtomicInteger count = new AtomicInteger(0);
	private Classe classe;

    public Alunno(String nome, String cognome, String nascita, String password) {
		super(nome, cognome, nascita, password);
		id=count.incrementAndGet();
	}

	public Classe getClasse() {
		return classe;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}


    
}