package Dominio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

	public class StoricoAvvisi {
	   private Avviso avvisoCorrente;
	   private List<Avviso> avvisi;
	   private List<PropertyListener> listeners;
	   private String evento_avviso="AVVISO";
	
	
	public StoricoAvvisi() {
		avvisi = new ArrayList<>();
		listeners = new LinkedList<PropertyListener>();
		}
	
	public Avviso nuovoAvviso(String data,String msg){
		avvisoCorrente=new Avviso(data,msg);
		return avvisoCorrente;
	}
	public boolean inviaAvviso(List<Classe> classi) {
		avvisoCorrente.setClassi(classi);
		boolean add=avvisi.add(avvisoCorrente);
		publishPropertyEvent(evento_avviso, avvisoCorrente);
		return add;
	}
	
	public List<Avviso> getAvvisi() {
		return avvisi;
	}
	public List<Avviso> getAvvisiClasse(Classe classe) {
		 List<Avviso> avvisi_classe=new ArrayList<>();
		   for(Avviso a:avvisi) {
			   if(a.getClassi().contains(classe)) avvisi_classe.add(a);
		   }
		   return avvisi_classe;
	   } 
	
	public void addPropertyListener(PropertyListener pl) {
		listeners.add(pl);
		publishPropertyEvent(evento_avviso, null);
	}
	public void publishPropertyEvent(String name, Object value) {
		for (PropertyListener pl : listeners)
			pl.onPropertyEvent(this,name,value);
	}
	
	}
