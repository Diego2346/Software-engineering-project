package Dominio;

import java.util.List;

public class Media1 implements CalcolaMedia {

	@Override
	public double getMedia(List<Voto> voti) {
		double somma=0;
		voti.removeIf(v->v.getLezione().getMateria().equals("Religione"));
		voti.removeIf(v->v.getLezione().getMateria().equals("Educazione fisica"));
		for(Voto v :voti) {
			somma+=v.getValutazione();
		}
		return Math.floor(somma/voti.size());
	}


}
