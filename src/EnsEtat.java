
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class EnsEtat extends HashSet<Etat> {
	HashSet<Etat> liste_etat;
	public EnsEtat() {
		// TODO Auto-generated constructor stub
	}
	public EnsEtat(Collection<Etat> ce) {
		liste_etat.addAll(ce);
	}
	public Collection<Etat> getListeEtat(){
		return liste_etat;
	}
}
