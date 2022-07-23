package Dominio;

import java.util.List;

public class Media2 implements CalcolaMedia {

	@Override
	public double getMedia(List<Voto> voti) {
		double somma=0;
		for(Voto v :voti) {
			somma+=v.getValutazione();
		}
		return Math.ceil(somma/voti.size());
	}
	
}
