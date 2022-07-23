package Dominio;

public class Voto {
	
	private String data;
	private Lezione lezione;
	private Alunno alunno;
	private int valutazione;
	
	public Voto(String data,Alunno alunno, int valutazione) {
		this.data=data;
		this.alunno = alunno;
		this.valutazione = valutazione;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Lezione getLezione() {
		return lezione;
	}
	public void setLezione(Lezione lezione) {
		this.lezione = lezione;
	}
	public Alunno getAlunno() {
		return alunno;
	}
	public void setAlunno(Alunno alunno) {
		this.alunno = alunno;
	}
	public int getValutazione() {
		return valutazione;
	}
	public void setValutazione(int valutazione) {
		this.valutazione = valutazione;
	}


	
	
	
	
}
