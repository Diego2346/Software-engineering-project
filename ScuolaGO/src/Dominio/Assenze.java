package Dominio;

import java.util.List;

public class Assenze {
	private String data;
	private Classe classe;
	private List<Alunno> alunni;
	
	public Assenze(String data, List<Alunno> alunni) {
		this.data = data;
		this.alunni = alunni;
		this.classe=alunni.get(0).getClasse();
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public List<Alunno> getAlunni() {
		return alunni;
	}
	public void setAlunni(List<Alunno> alunni) {
		this.alunni = alunni;
	}

	@Override
	public String toString() {
		return "Assenze [data=" + data + ", alunni=" + alunni + "]";
	}
	

}
