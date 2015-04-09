import java.util.Set;

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

        if (super.liste_etat.contains(e))
            return false;
        else {
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

    public void determinise() {

    }

}
