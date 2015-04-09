
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EnsEtat extends HashSet<Etat> {
	HashSet<Etat> liste_etat;
	public EnsEtat() {
		// TODO Auto-generated constructor stub
		liste_etat = new HashSet<Etat>();
	}
	public EnsEtat(Set<Etat> ce) {
		liste_etat = new HashSet<Etat>();
		for(Etat ee : ce){
			liste_etat.add(ee);
		}
	}
	public HashSet<Etat> getListeEtat(){
		return liste_etat;
	}
	// fonction qui renvoi l'union de tout les 
	//successeurs de cette ensmble d'etat
	public EnsEtat succ(){
		EnsEtat ensres = new EnsEtat() ;

        HashSet<EnsEtat> list_union_etat = new HashSet<EnsEtat>();
        for(Etat e : this.liste_etat){
			for(EnsEtat et : e.transitions.values()){
					list_union_etat.add(et);
			}
		}
		for(EnsEtat et : list_union_etat){
			ensres.liste_etat.addAll(et.liste_etat);
		}
		return ensres;
	}
	public EnsEtat succ(char c) {
		EnsEtat ensres = new EnsEtat();
		
		for(Etat e : this.liste_etat){
			ensres.liste_etat.addAll(e.succ(c).liste_etat);
		}
		
		return ensres ;
	}
	public boolean contientTerminal() {
		for(Etat e :this.liste_etat){
			if(e.isTerm())
				return true ;
		}
		return false ;
	}

    public Etat getEtatInit() {
        Etat res = null;
        for (Etat etat : this.liste_etat) {
            if (etat.isInit()) {
                res = etat;
                break;
            }
        }
        return res;
    }

    public Etat getEtatTerm() {
        Etat res = null;
        for (Etat etat : this.liste_etat) {
            if (etat.isTerm()) {
                res = etat;
                break;
            }
        }
        return res;
    }

    public Etat getEtat(int i) {
        Etat etat = null;
        int tmp = 0;
        for (Iterator<Etat> it = liste_etat.iterator(); it.hasNext() && (tmp < i); ) {
            etat = it.next();
            tmp++;
        }
        return etat;
    }

    public EnsEtat getEtatFinaux() {
        Set<Etat> etatfinaux = new HashSet<Etat>();
        Etat etat = null;
        for (Iterator<Etat> it = liste_etat.iterator(); it.hasNext(); ) {
            etat = it.next();
            if (etat.isTerm())
                etatfinaux.add(etat);
        }
        return new EnsEtat(etatfinaux);
    }

    public boolean accepte(String mot, int i) {
        boolean test;
        EnsEtat ensEtat = null;
        test = accepte_aux(mot, i, getEtatInit());

        return test;
    }

    private boolean accepte_aux(String mot, int i, Etat etat) {
        Etat etat1 = null;
        EnsEtat transition = null;
        EnsEtat ensEtatFinaux = getEtatFinaux();
        if (i == mot.length())
            return ensEtatFinaux.liste_etat.contains(etat);
        else {
            boolean result = false;
            char c = mot.charAt(i);
            transition = etat.transitions.get(c);
            for (Etat etat2 : transition.liste_etat) {
                result = result || accepte_aux(mot, i + 1, etat2);
            }
            return result;
        }
    }

    public Set<Character> alphabet() {
        Set<Character> alphabet_union = new HashSet<Character>();

        for (Etat etat : this.liste_etat) {
            alphabet_union.addAll(etat.alphabet());
        }
        return alphabet_union;
    }

}
