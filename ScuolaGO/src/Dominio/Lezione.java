package Dominio;

import java.util.List;
import java.util.Map;

public class Lezione {

	private String materia;
	private Professore professore;
	private Classe classe;
	private Map<String,List<Integer>> orario;
	
	public Lezione(String materia) {
		this.materia = materia;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public Professore getProfessore() {
		return professore;
	}

	public void setProfessore(Professore professore) {
		this.professore = professore;
	}

	public Classe getClasse() {
		return classe;
	}
	
	public List<Alunno> getAlunniLezione(){
		return classe.getAlunniClasse();
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Map<String, List<Integer>> getOrario() {
		return orario;
	}

	public void setOrario(Map<String, List<Integer>> orario) {
		this.orario = orario;
	}

	@Override
	public String toString() {
		return materia +" "+classe;
	}	
	
	
}
