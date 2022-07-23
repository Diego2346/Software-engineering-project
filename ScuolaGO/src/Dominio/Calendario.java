package Dominio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Calendario {
	
	private List<Lezione> lezioni;
	private Lezione lezioneCorrente;
	private List<PropertyListener> listeners;
	private String evento_lezione="LEZIONE";
	
   public Calendario() {
		lezioni = new ArrayList<>();
		listeners = new LinkedList<PropertyListener>();
   } 
   
   public Lezione nuovaLezione(String materia) {
	   lezioneCorrente=new Lezione(materia);
	   return lezioneCorrente;
   }
   
   public void abbinaProfALezione(Professore p) {
	   lezioneCorrente.setProfessore(p);
   }
   
   public void abbinaClasseALezione(Classe c) {
	   lezioneCorrente.setClasse(c);;
   }
   
   public void definisciOrarioLezione(Map<String,List<Integer>> orario) {
	   lezioneCorrente.setOrario(orario);
   }

   public boolean verificaSovrapposizioni() {
	   //sovrapposizioni lezioni prof
	   for(Lezione l1:getLezioniProf(lezioneCorrente.getProfessore())) {
		for(String giorno:lezioneCorrente.getOrario().keySet()) 
		 for(Integer ora: lezioneCorrente.getOrario().get(giorno)) 
		  if(l1.getOrario().containsKey(giorno) && l1.getOrario().get(giorno).contains(ora))
		   return true;}
	   //sovrapposizioni lezioni classe
	   for(Lezione l2:getLezioniClasse(lezioneCorrente.getClasse())){
		 for(String giorno:lezioneCorrente.getOrario().keySet()) 
		  for(Integer ora: lezioneCorrente.getOrario().get(giorno)) 
		   if(l2.getOrario().containsKey(giorno) && l2.getOrario().get(giorno).contains(ora))
		    return true;}
	   	    return false;
   }
   
   public boolean aggiungiLezioneACalendario() {
	   if(!verificaSovrapposizioni()) {
	   boolean add= lezioni.add(lezioneCorrente);
	   publishPropertyEvent(evento_lezione, lezioneCorrente);
	   return add;
	   }
	   return false;
   }
   
   public List<Lezione> getLezioni(){
	   return lezioni;
   }
   
   public List<Lezione> getLezioniProf(Professore prof){
	   List<Lezione> lezioni_prof=new ArrayList<>();
	   for(Lezione l:lezioni) {
		   if(l.getProfessore()==prof) lezioni_prof.add(l);
	   }
	   return lezioni_prof;
   } 
   
   public boolean rimuoviLezioniProf(int id) {  
	   boolean remove=lezioni.removeIf(l->l.getProfessore().getId()==id);
	   publishPropertyEvent(evento_lezione,null);
	   return remove;
   }
   
   public boolean rimuoviLezioniClasse(String nome) {
	   boolean remove=lezioni.removeIf(l->l.getClasse().getNome().equals(nome));
	   publishPropertyEvent(evento_lezione, null);
	   return remove;
   }

   
   public List<Lezione> getLezioniClasse(Classe classe){
	   List<Lezione> lezioni_classe=new ArrayList<>();
	   for(Lezione l:lezioni) {
		   if(l.getClasse()==classe) lezioni_classe.add(l);
	   }
	   return lezioni_classe;
   } 
  
   
	public void addPropertyListener(PropertyListener pl) {
		listeners.add(pl);
		publishPropertyEvent(evento_lezione, null);
	}
	public void publishPropertyEvent(String name, Object value) {
		for (PropertyListener pl : listeners)
			pl.onPropertyEvent(this,name,value);
	}
}
