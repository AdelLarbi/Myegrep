import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

public class Automate extends EnsEtat {

	private EnsEtat initiaux;
    private EnsEtat finaux;
    
    public Automate() {
        super();
        initiaux = new EnsEtat();
        finaux = new EnsEtat();
    }

	public EnsEtat getInitiaux() {
		return initiaux;
	}

	public boolean ajouteEtatSeul(Etat e) {

        if (super.liste_etat.contains(e)) {
            System.out.println("l'etat" + e.id + " est deja présent");
            return false;
        }
        else {
            System.out.println("Ajout de " + e.id);
            super.liste_etat.add(e);
            if (e.isInit())
                initiaux.add(e);
            if (e.isTerm())
                finaux.add(e);
        }
        return false;
	}

	public boolean ajouteEtatRecursif(Etat e) {
		boolean res = false;
		if (ajouteEtatSeul(e)) {
            EnsEtat ee = new EnsEtat(e.succ().liste_etat);
            for (Etat etat : ee) {
                ajouteEtatRecursif(etat);
            }
        } else {
            EnsEtat ee2 = new EnsEtat(e.succ().liste_etat);
            for (Etat etat : ee2) {
                ajouteEtatRecursif(etat);
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
            res += " ," + e.id;
        }

		for (Etat e : super.liste_etat) {
			res += " ETAT " + e.id+ " \n";
			res += "\n " + e.toStringEtat();
		}

		return res;
	}

	Automate minimise(Automate automateNonMinimal) {		 		 		
		return determinise(inverse(determinise(inverse(automateNonMinimal))));
	}
	
	Automate inverse(Automate automateTmp) {
		
		Etat etatTmp = null;
		initiaux.clear();
		
		for (Etat etat : this.liste_etat) {			
			// inverser les etats 
			if (etat.isInit()) {				
				etat.setInit(false);
				etat.setTerm(true);				
			} else { // est terminale
				etat.setInit(true);
				etat.setTerm(false);
				initiaux.add(etat);				
			}			
			
			// inverser les transitions
			HashMap<Character, EnsEtat> tmpTransitions = etat.transitions;
			for (Character succ: tmpTransitions.keySet()) {
				if (etat.isInit()) {
					etatTmp = new Etat(true, false);
				} else {
					etatTmp = new Etat(false, true);
				}
			    etatTmp.ajouteTransition(succ, etat);
			    automateTmp.add(etatTmp);
			}
		}
		
		// l'automate transposé 
		return automateTmp;
	}
	
	Automate determinise(Automate automateTmp) {		
		// TODO
		return automateTmp;
	}
}
