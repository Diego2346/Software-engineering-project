package Dominio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RegistroVoti {
	
	private List<Voto> voti;
	private Voto votoCorrente;
	private List<PropertyListener> listeners;
	private String evento_voto="VOTO";
	private CalcolaMedia cm;
	
	public RegistroVoti() {
		voti = new ArrayList<>();
		listeners = new LinkedList<PropertyListener>();
	}
	
	public Voto nuovoVoto(String data, Alunno alunno, int valutazione) {
		return votoCorrente= new Voto(data, alunno,valutazione);
	}
	
	public void abbinaVotoALezione(Lezione l) {
		votoCorrente.setLezione(l);
	}
	

	public boolean confermaVoto() {
		if(votoCorrente.getValutazione()>=0 && votoCorrente.getValutazione()<=10) {
		boolean add= voti.add(votoCorrente);
		publishPropertyEvent(evento_voto,votoCorrente);
		return add;}
		return false;
	}
		
	public List<Voto> getVotiProf(Professore prof){
	    List<Voto> voti_prof=new ArrayList<>();
		   for(Voto v:voti) {
			   if(v.getLezione().getProfessore()==prof) voti_prof.add(v);
		   }
		   return voti_prof;
	   } 
	
	public List<Voto> getVotiAlunno(Alunno alunno){
	    List<Voto> voti_alunno=new ArrayList<>();
		   for(Voto v:voti) {
			   if(v.getAlunno()==alunno) voti_alunno.add(v);
		   }
		   return voti_alunno;
	   } 
	
	
	public void setMediaStrategy(CalcolaMedia cm) {
		this.cm=cm;
	}
	
	public double getMedia(Alunno alunno) {
		return cm.getMedia(getVotiAlunno(alunno));
	}
	
	
	public void addPropertyListener(PropertyListener pl) {
		listeners.add(pl);
		publishPropertyEvent(evento_voto, null);
	}
	public void publishPropertyEvent(String name, Object value) {
		for (PropertyListener pl : listeners)
			pl.onPropertyEvent(this,name,value);
	}

}
