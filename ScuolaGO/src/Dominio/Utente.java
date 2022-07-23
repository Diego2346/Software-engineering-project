package Dominio;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Utente {
	protected int id;
	private String nome;
	private String nascita;
	private String cognome;
	private String password;
	
	
	public Utente(String nome, String cognome, String nascita,String password) {
		this.nome = nome;
		this.cognome = cognome;
		this.nascita = nascita;
		this.password=password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNascita() {
		return nascita;
	}
	public void setNascita(String nascita) {
		this.nascita = nascita;
	}

	@Override
	public String toString() {
		return  nome + " "  + cognome;
	}
}
