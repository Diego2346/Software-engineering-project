package Dominio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class ScuolaGO {

    private static ScuolaGO instance = null;

    private List<Admin> admins;
    private Classe classe;
    private Istituto istituto;
    private OrganicoProfessori organico;
    private Calendario calendario;
    private StoricoAvvisi storico;
    private RegistroAssenze registroAssenze;
    private RegistroVoti registroVoti;
    
    private ScuolaGO() {
        admins = new ArrayList<>();
		classe= new Classe();
		istituto= new Istituto();
		organico= new OrganicoProfessori();
		calendario = new Calendario();
		storico = new StoricoAvvisi();
		registroAssenze=new RegistroAssenze();
		registroVoti=new RegistroVoti();
		}

    public static ScuolaGO getInstance() {
        if (instance == null) {
            instance = new ScuolaGO();
        }
        return instance; 
    }
     
   public OrganicoProfessori getOrganico(){
	   return organico;
   }
   public Istituto getIstituto(){
	   return istituto;
   }
   public Classe getClasse(){
	   return classe;
   }
   public Calendario getCalendario() {
	   return calendario;
   }
   public StoricoAvvisi getStorico() {
	   return storico;
   }
   public RegistroAssenze getRegistroAssenze() {
	   return registroAssenze;
   }
   public RegistroVoti getRegistroVoti() {
	   return registroVoti;
   }
   
   public String getCurrentData() {
	   	SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date(System.currentTimeMillis());
		return formatter.format(date);
	}
    
///ADMIN++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   public Admin checkAdmin(String email){
        for(Admin a : admins){
            if(a.getEmail().equals(email)){
             return a;
            }}
        return null;
    }
    
    public Boolean registraAdmin(String nome,String cognome, String email,String psw) {
    	if(checkAdmin(email)==null){
          Admin admin=new Admin(nome,cognome,email,psw);
              if(admins.add(admin))
               System.out.println("Registrato: "+admin);
              return true;
        }else{
        	return false;
        }}
    	
    public Admin loginAdmin(String email, String psw){
       Admin a = checkAdmin(email);       
       if(a!=null){ 
            if(a.getPassword().equals(psw)){
            		System.out.println("login effettuato");
            		   return a;
            }}
        return null;
        }
  
//PROFESSORE++++++++++++++++++++++++++++++++++++++++++++++
     public Professore loginProfessore(int id,String psw){
         for(Professore p : organico.getProfessori()){ 
             if(p.getId()==id && p.getPassword().equals(psw)) {
             	System.out.println("Login effetuato");	   
             	return p;
             }} 
  		return null;}
      
     public Professore nuovoProfessore(String nome, String cognome, String nascita,String psw) {
  	   return organico.nuovoProfessore(nome, cognome, nascita, psw);
     }
     
     public boolean aggiungiProfessoreAOrganico() {
  	   return organico.aggiungiProfessoreAOrgaznico();
     }
     
     public List<Professore> getProfessori() {
  	   return organico.getProfessori(); 
     }
     
     public boolean rimuoviProfessore(int id) {
    	 calendario.rimuoviLezioniProf(id);
    	 return organico.rimuoviProfessore(id);
     }
  
//CLASSE++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   public Classe nuovaClasse(String nome, String aula, int maxAluunni) {
	   return istituto.nuovaClasse(nome, aula, maxAluunni);
   }
   public boolean aggiungiClasseAIstituto() {
   	   return istituto.aggiungiClasseAIstituto();
   }
   
   public List<Classe> getClassi() { 
	   return istituto.getClassi();
   }
     
   public boolean rimuoviClasse(String nome) {
	 calendario.rimuoviLezioniClasse(nome);
  	 return istituto.rimuoviClasse(nome);
   }

 //ALUNNO+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   public Alunno loginAlunno(int id,String psw){
       for(Alunno a : istituto.getAlunniIstituto()){ 
           if(a.getId()==id && a.getPassword().equals(psw)) {
           	System.out.println("Login effetuato");	   
           	return a;
           }}
		return null;
	}
   
   public Alunno nuovoAlunno(String nome, String cognome, String psw,String nascita) {
   	   return classe.nuovoAlunno(nome,cognome,psw, nascita);
   }
   
   public boolean aggiungiAlunnoAClasse(Classe c) {
	   return classe.aggiungiAlunnoAClasse(c);
   }
  
  public List<Alunno> getAlunniIstituto(){
	   return istituto.getAlunniIstituto();
  }  
  
  
  
//LEZIONE++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   
   public Lezione nuovaLezione(String materia) {
	   return calendario.nuovaLezione(materia);
   }
   
   public void abbinaProfALezione(Professore p) {
	   calendario.abbinaProfALezione(p);
   }
   
   public void abbinaClasseALezione(Classe c) {
	   calendario.abbinaClasseALezione(c);
   }
   
   public void definisciOrarioLezione(Map<String,List<Integer>> orario) {
	   calendario.definisciOrarioLezione(orario);
   }
   
   public boolean aggiungiLezioneACalendario() {
	   return calendario.aggiungiLezioneACalendario();
   }
   
   public List<Lezione> getLezioni() {
	   return calendario.getLezioni();
   }
 
   public List<Lezione> getLezioniProf(Professore p) {
	   return calendario.getLezioniProf(p);
   }
   
   public List<Lezione> getLezioniClasse(Classe c) {
	   return calendario.getLezioniClasse(c);
   }
  
   
//AVVISI++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   
   public Avviso nuovoAvviso(String msg) {
	   return storico.nuovoAvviso(getCurrentData(),msg);
   }
   
   public boolean inviaAvviso(List<Classe> classi) {
	  return storico.inviaAvviso(classi);
   }
    
   public List<Avviso> getAvvisi() {
		  return storico.getAvvisi();
	   }
   
   public List<Avviso> getAvvisiClasse(Classe c) {
		  return storico.getAvvisiClasse(c);
	   }
//REGISTRO ASSENZE++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   
   public Assenze nuovaAssenza(List<Alunno> alunni) {
	   return registroAssenze.nuovaAssenza(getCurrentData(),alunni);
   }
   
	public boolean confermaAssenze() {
		return registroAssenze.confermaAssenze();
	}
	
	public List<Assenze> getAssenze(){
		return registroAssenze.getAssenze();
	}
	
//REGISTRO VOTI+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	public Voto nuovoVoto(Alunno alunno,int valutazione) {
		return registroVoti.nuovoVoto(getCurrentData(), alunno, valutazione);
	}
	
	public void abbinaVotoALezione(Lezione l) {
		registroVoti.abbinaVotoALezione(l);
	}
	
	public boolean confermaVoto() {
		return registroVoti.confermaVoto();
	} 
	
	public List<Voto> getVotiProf(Professore p){
		return registroVoti.getVotiProf(p);
	}
	public List<Voto> getVotiAlunno(Alunno a){
		return registroVoti.getVotiAlunno(a);
	}
	
	public double getMediaAlunno(Alunno a) {
	return registroVoti.getMedia(a);
	}
}