package Dominio;
import java.util.List;

public class Avviso {
	private String data;
	private List<Classe> classi;
	private String msg;
	
	
	
	public Avviso(String data,String msg) {
		this.data = data;
		this.msg = msg;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public List<Classe> getClassi() {
		return classi;
	}
	public void setClassi(List<Classe> classi) {
		this.classi = classi;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "Avviso [data=" + data + ", msg=" + msg + "]";
	}
	
	
	
	
}
