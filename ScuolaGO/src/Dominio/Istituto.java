package Dominio;

import java.util.ArrayList;
import java.util.List;

public class Istituto {
	private List<Classe> classi;
	private Classe classeCorrente;
	private List<PropertyListener> listeners;
	private String evento_classe="CLASSE";

	 public Istituto(){
	        classi = new ArrayList<>();
	        listeners=new ArrayList<>();
	 } 

	 
	public List<Classe> getClassi() {
		return classi;
	}

	public void setClassi(List<Classe> classi) {
		this.classi = classi;
	}
	public Classe getClasse(String nome) {
		for(Classe c: classi) {
			if(c.getNome().equals(nome)) return c;
		}
		return null;
	}
	
	public Classe nuovaClasse(String nome, String aula,int maxAlunni) {
		classeCorrente =new Classe(nome,aula,maxAlunni);
		return classeCorrente;
	}
	
	public boolean aggiungiClasseAIstituto() {
		if(classeCorrente.getMaxAlunni()<=30) {
		for(Classe classe:classi) {
		 if(classe.getNome().equals(classeCorrente.getNome())) 
			 return false;
		}
		classi.add(classeCorrente);
		publishPropertyEvent(evento_classe, classeCorrente);
		return true;
		}
		return false;
		}
	
	public boolean rimuoviClasse(String nome) {
		for(Classe classe:classi) {
		 if(classe.getNome().equals(nome)) { 
			 classe.getAlunniClasse().clear();
			 classi.remove(classe);
		 	 publishPropertyEvent(evento_classe, classe);
		    return true;
		}}
		return false;
	}

		
	public List<Alunno> getAlunniIstituto(){
		List<Alunno> alunniIstituto = new ArrayList<>();
		for(Classe c: classi) {
			alunniIstituto.addAll(c.getAlunniClasse());
		}
		return alunniIstituto;
	}
	
	public void addPropertyListener(PropertyListener pl) {
		listeners.add(pl);
		publishPropertyEvent(evento_classe, null);

	}
	
	public void publishPropertyEvent(String name, Object value) {
		for (PropertyListener pl : listeners)
			pl.onPropertyEvent(this,name,value);
	}

	
	
}
