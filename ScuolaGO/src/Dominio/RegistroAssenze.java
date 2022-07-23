package Dominio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RegistroAssenze {
	private List<Assenze> assenze;
	private Assenze assenzeCorrenti;
	private List<PropertyListener> listeners;
	private String evento_assenze="ASSENZE";

	public RegistroAssenze(){
		assenze = new ArrayList<>();
		listeners = new LinkedList<PropertyListener>();
	} 
	
	public Assenze nuovaAssenza(String data,List<Alunno> alunni) {
		return assenzeCorrenti=new Assenze(data,alunni);
	}
	
	public boolean confermaAssenze() {
		if(!verificaRegistro()) {
		boolean add=assenze.add(assenzeCorrenti);
		publishPropertyEvent(evento_assenze, assenze);
		return add;
		}
		return false;
	}
	
	public boolean verificaRegistro() {
	 for(Assenze a:getAssenze()) {
		if(a.getData().equals(assenzeCorrenti.getData()) && a.getClasse().equals(assenzeCorrenti.getClasse())) 
			return true;
		}
		return false;
	}
	
	public List<Assenze> getAssenze() {
		return assenze;
	}
	
	public void setAssenze(List<Assenze> assenze) {
		this.assenze = assenze;
	}
	
	public boolean alunnoAssente(Alunno alunno,String data) {
		for(Assenze a:assenze) {
			if(a.getAlunni().contains(alunno) && a.getData().equals(data)) return true;
		}
		return false;
	}
	
	public void addPropertyListener(PropertyListener pl) {
		listeners.add(pl);
		publishPropertyEvent(evento_assenze, null);
	}
	public void publishPropertyEvent(String name, Object value) {
		for (PropertyListener pl : listeners)
			pl.onPropertyEvent(this,name,value);
	}
}
