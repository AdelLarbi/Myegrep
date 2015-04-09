import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Automate extends EnsEtat {

	private EnsEtat initiaux;

	public Automate() {
		super();
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
	   boolean res = false ;
	   if (ajouteEtatSeul(e)) {
		   return true;
	   } 
	   else {
		   EnsEtat ee = new EnsEtat(e.succ().liste_etat);
		   for (Etat etat : ee) {
			   res = ajouteEtatRecursif(etat);
		   }
	   }
	   return res ;
	}

	public boolean estDeterministe() {
		for (Etat etat : this.liste_etat) {
			etat.transitions.keySet();
		}
		
   }
}
