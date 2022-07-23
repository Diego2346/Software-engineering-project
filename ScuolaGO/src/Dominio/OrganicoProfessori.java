package Dominio;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class OrganicoProfessori {
	
	private List<Professore> professori;
	private Professore professoreCorrente;
	private List<PropertyListener> listeners;
	private String evento_professore="PROFESSORE";

	public OrganicoProfessori() {
		professori = new ArrayList<>();
		listeners = new LinkedList<PropertyListener>();
	} 

	public Professore getProfessore(int id) {
		for(Professore p: professori) {
			if(p.getId()==id) return p;
		}
		return null;
	}
	
	public List<Professore> getProfessori() {
		return professori;
	}

	public void setProfessori(List<Professore> professori) {
		this.professori = professori;
	} 

	public Professore nuovoProfessore(String nome,String cognome,String nascita, String psw) {
		return professoreCorrente =new Professore(nome,cognome,nascita, psw);
	}
	
	public boolean aggiungiProfessoreAOrgaznico() {
		boolean add= professori.add(professoreCorrente);
		publishPropertyEvent(evento_professore,professoreCorrente);
		return add;
	}
	
	public boolean rimuoviProfessore(int id) {
		for(Professore prof:professori) {
			 if(prof.getId()==id) { 
				 professori.remove(prof);
			 	 publishPropertyEvent(evento_professore, prof);
			    return true;
			}}
			return false;
		}
    
	public void addPropertyListener(PropertyListener pl) {
		listeners.add(pl);
		publishPropertyEvent(evento_professore, null);
	}
	public void publishPropertyEvent(String name, Object value) {
		for (PropertyListener pl : listeners)
			pl.onPropertyEvent(this,name,value);
	}

    
}
