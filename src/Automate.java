import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Automate extends EnsEtat {

	private EnsEtat initiaux;

	public Automate(Set<Etat> ee) {
		super(ee);
		initiaux = new EnsEtat();
	}

	public EnsEtat getInitiaux() {
		return initiaux;
	}

	public boolean ajouteEtatSeul(Etat e) {

		for (Iterator<Etat> iterator = liste_etat.iterator(); iterator
				.hasNext();) {
			Etat etmp = (Etat) iterator.next();
			if (etmp.equals(e)) {
				return true;
			}
		}
		initiaux.add(e);
		return false;
	}

	public boolean ajouteEtatRecursif(Etat e) {
		boolean res = false;
		if (ajouteEtatSeul(e)) {
			return true;
		} else {
			EnsEtat ee = new EnsEtat(e.succ().liste_etat);
			for (Etat etat : ee) {
				res = ajouteEtatRecursif(etat);
			}
		}
		return res;
	}

	public boolean estDeterministe() {
		for (Etat etat : this.liste_etat) {
			Set<Character> settmp = etat.transitions.keySet();
			for (Character c : settmp) {
				EnsEtat enstmp = etat.transitions.get(c);
				if (enstmp.size() >= 1)
					return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		String res =  "Initiaux: " + "\n";
		// affichage des initiaux
		for (Etat e : initiaux.liste_etat) {
			res += "\n " + e.toString();
		}
		res+=  "fin des Initiaux: " + "\n";

		int i = 1;
		
		for (Etat e : super.liste_etat) {
			res += " ETAT " + e.id+ " \n";
			res += "\n " + e.toStringEtat();
		}

		return res;
	}

}
