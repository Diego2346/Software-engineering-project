package Dominio;

import java.util.ArrayList;
import java.util.List;

public class Classe {

	private String nome;
	private String aula;
	private int maxAlunni;
	private List<Alunno> alunni;
	private Alunno alunnoCorrente;
	private List<PropertyListener> listeners;
	private String evento_alunno="ALUNNO";
	
	public Classe() {
        listeners=new ArrayList<>();

	}

	public Classe(String nome,String aula, int maxAlunni) {
		this.nome = nome;
		this.aula = aula;
		this.maxAlunni = maxAlunni;
        alunni = new ArrayList<>();

	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public int getMaxAlunni() {
		return maxAlunni;
	}

	public void setMaxAlunni(int maxAlunni) {
		this.maxAlunni = maxAlunni;
	}

	public List<Alunno> getAlunniClasse() {
		return alunni;
	}

	public void setAlunni(List<Alunno> alunni) {
		this.alunni = alunni;
	}

	public Alunno getAlunnoCorrente() {
		return alunnoCorrente;
	}

	public void setAlunnoCorrente(Alunno alunnoCorrente) {
		this.alunnoCorrente = alunnoCorrente;
	}

	public Alunno nuovoAlunno(String nome, String cognome, String password,String nascita) {
		alunnoCorrente = new Alunno(nome,cognome,password,nascita);
		return alunnoCorrente;
	}
	
	
	public boolean verificaCapienza(Classe classe) {
		return classe.getAlunniClasse().size()+1>classe.getMaxAlunni();
	}
	
	public boolean aggiungiAlunnoAClasse(Classe classe) {
		if(!verificaCapienza(classe)) { 
			alunnoCorrente.setClasse(classe);
			classe.getAlunniClasse().add(alunnoCorrente);
			publishPropertyEvent(evento_alunno, alunnoCorrente);
			return true;
		}
		else return false;
	} 

    
	@Override
	public String toString() {
		return  nome;
	}
	
	public void addPropertyListener(PropertyListener pl) {
		listeners.add(pl);
		publishPropertyEvent(evento_alunno, null);

	}
	
	public void publishPropertyEvent(String name, Object value) {
		for (PropertyListener pl : listeners)
			pl.onPropertyEvent(this,name,value);
	}
	
	
}
	
	
	
	
	
	
	

