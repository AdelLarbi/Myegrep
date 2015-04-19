package automate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Etat {

	HashMap<Character, EnsEtat> transitions;
	boolean init=false;
	boolean term=false;
	int id;

	public Etat() {
		this.transitions = new HashMap<Character, EnsEtat>();
	}

	public Etat(int id) {
		this.transitions = new HashMap<Character, EnsEtat>();
		this.id = id;
	}

    public Etat(boolean init,boolean term){
        this.transitions = new HashMap<Character, EnsEtat>();
        this.term = term;
        this.init = init;
    }
    
	public Etat(boolean init, boolean term, int id) {
		this.transitions = new HashMap<Character, EnsEtat>();
		this.init = init;
		this.term = term;
		this.id = id;
	}

	public boolean isInit() {
        return this.init;
    }

    public void setInit(boolean init) {
        this.init = init;
    }

	public boolean isTerm() {
        return this.term;
    }

	public void setTerm(boolean term) {

        this.term = term;
    }

    public HashMap<Character, EnsEtat> getTransitions() {
        return transitions;
    }


    @Override
    public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		} else {
			final Etat other = (Etat) obj;
			return (id == other.id);
		}
	}

    public Set<Etat> getStateFromEpsilonTransition() {
        Set<Etat> res = new HashSet<Etat>();
        EnsEtat ens_episolon = null;
        for (Character key : this.transitions.keySet()) {
            if (key.equals(' ')) {
                ens_episolon = this.transitions.get(key);
                for (Etat e : ens_episolon) {
                    res.add(e);
                }

            }
        }
        return res;
    }

    public EnsEtat succ(char c) {
        if (transitions.containsKey(c))
            return transitions.get(c);
        return new EnsEtat();
    }

    public EnsEtat succ() {
        if (!transitions.isEmpty()) {
            EnsEtat tmp = new EnsEtat();
            for (EnsEtat etats : transitions.values()) {
                tmp.addAll(etats);
            }
            return tmp;
        }
        return new EnsEtat();
    }

    public void ajouteTransition(char c, Etat e) {
        // si la transition existe
		if (transitions.containsKey(c)) {
            transitions.get(c).add(e);
        } else {
            EnsEtat tmp = new EnsEtat();
            tmp.add(e);
            transitions.put(c, tmp);
        }
	}

    public String toString() {
        String res = "";
        res += id + "";
        res += (init) ? " initial" : "";
        res += (term) ? " terminal" : "";
        res += "\n";

        for (Map.Entry<Character, EnsEtat> entry : transitions.entrySet()) {
            res += entry.getKey().charValue();
            for (Etat etat : entry.getValue()) {
                res += " " + etat.id;
            }
            res += "\n";
        }
        return res;
    }

    public Set<Character> alphabet() {
        return this.transitions.keySet();
    }

    public String affiche() {
        int i = (init) ? 1 : 0;
        int t = (term) ? 1 : 0;
        String res = "{" + id + " (" + i + "," + t + ")";

        for (Character a : transitions.keySet()) {
            String key = " [" + a + "=>(";
            String etatS = "";
            for (Etat etat : transitions.get(a)) {
                if (etatS.length() != 0) etatS += ",";
                etatS += etat.hashCode() + "";
            }
            key += etatS + ")]";
            res += key;
        }

        res += " }";
        return res;
    }
}
